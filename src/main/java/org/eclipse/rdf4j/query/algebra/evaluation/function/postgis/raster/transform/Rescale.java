package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import java.awt.geom.AffineTransform;
import java.util.Map;

import javax.media.jai.PlanarImage;

import org.apache.sis.coverage.SampleDimension;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.util.resources.Vocabulary;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierDoubleDoubleFunction;
import org.opengis.geometry.Envelope;
import org.opengis.parameter.InvalidParameterValueException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

public class Rescale extends RasterModifierDoubleDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rescale.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage inputCoverage, Double xScale, Double yScale) {
		if (xScale <= 0) {
            throw new InvalidParameterValueException("xScale must be greater than zero", "xScale",
                    xScale);
        }

        if (yScale <= 0) {
            throw new InvalidParameterValueException("yScale must be greater than zero", "yScale",
                    yScale);
        }

        this.initilizeVariables(inputCoverage);

        final int numBands = inputCoverage.getSampleDimensions().size();

        ReferencedEnvelope extent = new ReferencedEnvelope(inputCoverage.getEnvelope());
        GridGeometry gridGeometry2D = inputCoverage.getGridGeometry();
        AffineTransform gridToWorld = (AffineTransform) gridGeometry2D.getGridToCRS2D();
        CellSizeX = Math.abs(gridToWorld.getScaleX()) * xScale;
        CellSizeY = Math.abs(gridToWorld.getScaleY()) * yScale;

        // 1. The output size is multiplied by the scale factor for both the x and y directions. The
        // number of columns and rows stays the same in this process, but the cell size is
        // multiplied by the scale factor.
        // 2. The scale factor must be positive.
        // 3. A scale factor greater than one means the image will be rescaled to a larger
        // dimension,
        // resulting in a larger extent because of a larger cell size.
        // 4. A scale factor less than one means the image will be rescaled to a smaller dimension,
        // resulting in a smaller extent because of a smaller cell size.

        // Rescale extent
        final PlanarImage inputImage = (PlanarImage) inputCoverage.getRenderedImage();
        double maxX = extent.getMinX() + (inputImage.getWidth() * CellSizeX);
        double maxY = extent.getMinY() + (inputImage.getHeight() * CellSizeY);

        CoordinateReferenceSystem crs = inputCoverage.getCoordinateReferenceSystem();
        Envelope Extent = inputCoverage.getGridGeometry().getEnvelope();

        if (numBands == 1) {
            return createGridCoverage(inputCoverage.getName(), inputImage);
        } else {
            SampleDimension[] bands = inputCoverage.getSampleDimensions();

            double[] nodataValues = bands[0].getNoDataValues();
            Object noData = nodataValues == null ? Integer.MAX_VALUE : nodataValues[0];

            Map properties = inputCoverage.getProperties();
            properties.put(Vocabulary.formatInternational(VocabularyKeys.NODATA), noData);
            properties.put("GC_NODATA", noData);

            GridCoverageFactory factory = CoverageFactoryFinder.getGridCoverageFactory(null);
            return factory.create(inputCoverage.getName(), inputImage, Extent, bands, null,
                    properties);
        }
	}

}
