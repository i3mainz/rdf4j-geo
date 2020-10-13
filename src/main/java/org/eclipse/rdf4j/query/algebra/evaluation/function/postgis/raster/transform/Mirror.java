package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import java.util.List;
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
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierBoolDoubleFunction;

public class Mirror extends RasterModifierBoolDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_mirror.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage raster, Boolean type, Double zFactor) {
		 // transpose parameters: type
        // http://download.java.net/media/jai/javadoc/1.1.3/jai-apidocs/javax/media/jai/operator/TransposeDescriptor.html
        // http://java.sun.com/products/java-media/jai/forDevelopers/jai1_0_1guide-unc/Geom-image-manip.doc.html#51140
        final PlanarImage inputImage = (PlanarImage) raster.render(raster.getGridGeometry().getExtent());
        ParameterBlockJAI parameterBlock = new ParameterBlockJAI("transpose", "rendered");
        parameterBlock.addSource(inputImage);

        parameterBlock.setParameter("type", TransposeDescriptor.FLIP_HORIZONTAL);
        PlanarImage outputImage = JAI.create("transpose", parameterBlock);

        final int numBands = raster.getSampleDimensions().size();
        /*
        if (numBands == 1) {
        	return raster;
        } else {
            List<SampleDimension> bands = raster.getSampleDimensions();

            Set<Number> nodataValues = bands.get(0).getNoDataValues();
            Object noData = nodataValues == null ? Integer.MAX_VALUE : nodataValues[0];

            Map properties = raster.getProperties();
            properties.put(Vocabulary.formatInternational(VocabularyKeys.NODATA), noData);
            properties.put("GC_NODATA", noData);

            GridCoverageFactory factory = CoverageFactoryFinder.getGridCoverageFactory(null);
    		return CoverageWrapper.createGeometry(factory.create(raster. getName(), outputImage, raster.getEnvelope(), bands, null,
                    properties), wrapper.getSrsURI(), wrapper.getRasterDatatypeURI()).asNodeValue();
	}*/
        return null;
	}

}
