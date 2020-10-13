package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import java.awt.Rectangle;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;

import it.geosolutions.jaiext.range.RangeFactory;

import javax.media.jai.JAI;
import javax.media.jai.ParameterBlockJAI;
import javax.media.jai.ROI;
import javax.media.jai.ROIShape;
import javax.media.jai.RenderedOp;
import javax.media.jai.util.Range;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.geometry.GeneralEnvelope;
import org.apache.sis.internal.feature.jts.JTS;
import org.apache.sis.referencing.CRS;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierGeometryFunction;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryCollection;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;
import org.opengis.feature.Operation;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.parameter.ParameterValueGroup;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

public class Crop extends RasterModifierGeometryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_crop.stringValue();
	}
	
	 private ParameterBlock buildParameterBlock(RenderedImage source, boolean newDescriptor,
	            boolean roiUsed, boolean noDataUsed) {
	        // Creation of the parameterBlock associated with its operation
	        ParameterBlockJAI pb;
	        if (newDescriptor) {
	            pb = new ParameterBlockJAI("Crop");
	        } else {
	            pb = new ParameterBlockJAI("crop");
	        }
	        // Setting of the source
	        pb.setSource("source0", source);
	        // Setting of the parameters
	        pb.setParameter("x", (float) 0);
	        pb.setParameter("y", (float) 0);
	        pb.setParameter("width", (float) 20);
	        pb.setParameter("height", (float) 20);
	        if (newDescriptor) {
	            // If ROI is present, then it is added
	            if (roiUsed) {
	                ROI roi = new ROIShape(new Rectangle(5, 5, 10, 10));
	                pb.setParameter("ROI", roi);
	            }
	            // If NoData is present, then it is added
	            if (noDataUsed) {
	                Range noData = RangeFactory.create(noDataValue, true, noDataValue, true);
	                pb.setParameter("NoData", noData);
	                pb.setParameter("destNoData", destNoData);
	            }

	        }
	        return pb;
	    }

	@Override
	public GridCoverage modify(GridCoverage inputCoverage, Geometry cropShape) {
		 CoordinateReferenceSystem crs = inputCoverage.getCoordinateReferenceSystem();
		 ParameterBlock pb = buildParameterBlock(inputCoverage.render(inputCoverage.getGridGeometry().getExtent()), false, false, false);

	        ParameterBlock pbNew = buildParameterBlock(inputCoverage.render(inputCoverage.getGridGeometry().getExtent()), true, false, false);

	        // Images creation
	        RenderedOp cropped = JAI.create("crop", pb);
	        RenderedOp jaiextCropped = JAI.create("Crop", pbNew);
	        // Test on the selected image
	        assertImageEquals(cropped, jaiextCropped);

	        // Display Image
	        if (INTERACTIVE && TEST_SELECTOR == 0) {
	            RenderedImageBrowser.showChain(jaiextCropped, false, false);
	            try {
	                System.in.read();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	        }
	        // check geometry
	        GeometryCollection roi = null;
	        if (cropShape == null || cropShape.isEmpty()) {
	            roi = null;
	        } else {
	            Class<?> geomBinding = cropShape.getClass();
	            if (geomBinding.isAssignableFrom(MultiPolygon.class)
	                    || geomBinding.isAssignableFrom(Polygon.class)) {
	                if (!cropShape.isValid() || !cropShape.isSimple()) {
	                    cropShape = cropShape.buffer(0);
	                    cropShape.setUserData(cropShape.getUserData());
	                }
	            }

	            // transform if necessary
	            cropShape = transformGeometry(cropShape, crs);

	            // force it to a collection if necessary
	            if (cropShape instanceof GeometryCollection) {
	                roi = (GeometryCollection) cropShape;
	            } else {
	                roi = cropShape.getFactory().createGeometryCollection(new Geometry[] { cropShape });
	            }
	        }

	        // check bounds
	        GeneralEnvelope bounds = null;
	        if (extent == null || extent.isEmpty() || extent.isNull()) {
	            if (roi != null) {
	                bounds = new GeneralEnvelope(new ReferencedEnvelope(roi.getEnvelopeInternal(), crs));
	            }
	        } else {
	            CoordinateReferenceSystem extCrs = extent.getCoordinateReferenceSystem();
	            if (!CRS.equalsIgnoreMetadata(crs, extCrs)) {
	                    MathTransform transform = CRS.findMathTransform(extCrs, crs, true);
	                    Envelope env = JTS.transform(extent, transform);
	                    bounds = new GeneralEnvelope(new ReferencedEnvelope(env, crs));

	            } else {
	                bounds = new GeneralEnvelope(extent);
	            }
	        }

	        // perform the crops
	        final CoverageProcessor coverageProcessor = CoverageProcessor.getInstance();
	        final Operation cropOperation = coverageProcessor.getOperation("CoverageCrop");

	        final ParameterValueGroup param = cropOperation.getParameters();
	        param.parameter("Source").setValue(inputCoverage);
	        param.parameter("Envelope").setValue(bounds);
	        param.parameter("ROI").setValue(roi);
	        param.parameter("ROITolerance").setValue(roiTolerance); // default

	        return doOperation(param, null);
	}

}
