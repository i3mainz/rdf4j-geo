package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import java.util.Map;
import java.util.Set;

import javax.media.jai.JAI;
import javax.media.jai.ParameterBlockJAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.TransposeDescriptor;

import org.apache.sis.coverage.SampleDimension;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.util.resources.Vocabulary;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;

public class Flip extends RasterModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_flip.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage raster) {/*
		final PlanarImage inputImage = (PlanarImage) ((GridCoverage)raster).getRenderedImage();
        ParameterBlockJAI parameterBlock = new ParameterBlockJAI("transpose", "rendered");
        parameterBlock.addSource(inputImage);

        parameterBlock.setParameter("type", TransposeDescriptor.FLIP_VERTICAL);
        PlanarImage outputImage = JAI.create("transpose", parameterBlock);

        final int numBands = raster.getSampleDimensions().size();
        GridCoverageFactory factory = CoverageFactoryFinder.getGridCoverageFactory(null);
        if (numBands == 1) {
        	return raster;
        } else {
            SampleDimension[] bands = raster.getSampleDimensions().toArray(new SampleDimension[0]);

            Set<Number> nodataValues = bands[0].getNoDataValues();
            Object noData = nodataValues == null ? Integer.MAX_VALUE : nodataValues.iterator().next().doubleValue();

            Map properties = raster.getProperties();
            properties.put(Vocabulary.formatInternational(VocabularyKeys.NODATA), noData);
            properties.put("GC_NODATA", noData);

            return factory.create(raster.getName(), outputImage, raster.getEnvelope(), bands, null,
                    properties);*/
		return null;
	}

}
