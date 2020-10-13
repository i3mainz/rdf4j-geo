package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import java.util.List;
import java.util.Map;

import javax.media.jai.PlanarImage;

import org.apache.sis.coverage.SampleDimension;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.util.resources.Vocabulary;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierIntIntFunction;

public class Shift extends RasterModifierIntIntFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_shift.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage inputCoverage, Integer xTrans, Integer yTrans) {
		if (xTrans == 0 && yTrans == 0) {
            return inputCoverage;
        }

        this.initilizeVariables(inputCoverage);

        final int numBands = inputCoverage.getSampleDimensions().size();
        final PlanarImage inputImage = (PlanarImage) inputCoverage.render(inputCoverage.getGridGeometry().getExtent());

        // 1. The cell size of the output raster will be the same as that of the input raster.
        // 2. The number of rows and columns in the output raster will be the same as those of the
        // input raster, no matter what parameters are specified.
        // 3. The coordinates of the lower left corner of the output raster will be offset from the
        // input raster by the x and y shift coordinate values specified.
        // 4. Using a negative shift x-coordinate value will shift the output to the left. A
        // positive shift x-coordinate value will shift the output to the right. Using a negative
        // shift y-coordinate value will shift the output down. A positive shift y-coordinate value
        // will shift the output to the top.

        ReferencedEnvelope Extent = new ReferencedEnvelope(inputCoverage.getGridGeometry().getEnvelope());
        Extent.translate(xTrans, yTrans);

        if (numBands == 1) {
            return createGridCoverage(inputCoverage.getName(), inputImage);
        } else {
            List<SampleDimension> bands = inputCoverage.getSampleDimensions();

            double[] nodataValues = bands.getNoDataValues();
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
