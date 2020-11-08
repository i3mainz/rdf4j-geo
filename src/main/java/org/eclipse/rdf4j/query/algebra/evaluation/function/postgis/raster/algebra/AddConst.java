package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.algebra;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;
import java.awt.image.renderable.ParameterBlock;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.measure.Unit;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

import org.apache.sis.coverage.Category;
import org.apache.sis.coverage.SampleDimension;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridExtent;
import org.apache.sis.coverage.grid.GridGeometry;
import org.apache.sis.internal.coverage.BufferedGridCoverage;
import org.apache.sis.measure.MeasurementRange;
import org.apache.sis.util.iso.DefaultNameFactory;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAlgebraConstFunction;
import org.opengis.referencing.datum.PixelInCell;
import org.opengis.referencing.operation.MathTransform1D;

public class AddConst extends RasterAlgebraConstFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_rast_algebra_addconst.stringValue();
	}


	@Override
	public GridCoverage modify(GridCoverage raster,Integer rd1,Double constt) {
		ParameterBlock pbSubtracted = new ParameterBlock();
		pbSubtracted.addSource(raster.render(raster.getGridGeometry().getExtent()));
		System.out.println(raster.render(null).getSampleModel().getDataType());
		System.out.println(raster.render(raster.getGridGeometry().getExtent()));
		double[] consts=new double[raster.getSampleDimensions().size()];
		if(rd1.intValue()<0) {
			for(int i=0;i<consts.length;i++) {
				consts[i]=constt;
			}
		}else {
			for(int i=0;i<consts.length;i++) {
				if(i==rd1.intValue()) {
					consts[i]=constt;
				}else {
					consts[i]=0;
				}
			}
		}
		System.out.println(Arrays.toString(consts));
		pbSubtracted.add(consts);
		RenderedOp subtractedImage = JAI.create("addconst", pbSubtracted);
		System.out.println(subtractedImage);
		/*MeasurementRange<?> range = null;
		MathTransform1D transferfunc = null;
		Unit<?> unit = null;
		try {
			range=raster.getSampleDimensions().get(rd1).getMeasurementRange().get();
		}catch(Exception e) {
			
		}
		try {
			transferfunc=raster.getSampleDimensions().get(rd1).getTransferFunction().get();
		}catch(Exception e) {
			
		}
		try {
			unit=raster.getSampleDimensions().get(rd1).getUnits().get();
		}catch(Exception e) {
			
		}*/
		final SampleDimension sd =raster.getSampleDimensions().get(rd1);/* new SampleDimension.Builder().setName("t")
				.addQuantitative(
						(raster.getSampleDimensions().get(rd1).getName() + " addconst "
								+ constt).toString(),
						raster.getSampleDimensions().get(rd1).getMeasurementRange(),
						raster.getSampleDimensions().get(rd1).getTransferFunction(),
						raster.getSampleDimensions().get(rd1).getUnits())
				.build();
		*/
		List<SampleDimension>sds=new LinkedList<SampleDimension>();
		sds.add(sd);
        GridExtent extent=new GridExtent(subtractedImage.getWidth(), subtractedImage.getHeight());
        GridGeometry gridgeom=new GridGeometry(extent, PixelInCell.CELL_CENTER, raster.getGridGeometry().getGridToCRS(PixelInCell.CELL_CENTER), raster.getCoordinateReferenceSystem());
        List<SampleDimension> dimensions=new LinkedList<SampleDimension>();
        DefaultNameFactory fac=new DefaultNameFactory();
        for(int i=0;i<subtractedImage.getNumBands();i++) {
        	dimensions.add(new SampleDimension(fac.createGenericName(null,  "Dimension "+i),0.,new LinkedList<Category>()));
        }
        BufferedGridCoverage coverage=new BufferedGridCoverage(
        		gridgeom, dimensions, subtractedImage.getData().getDataBuffer());
		/*
		 * Create the grid coverage, gets its image and set values directly as short
		 * integers.
		 */
		//BufferedGridCoverage coverage=new BufferedGridCoverage(raster.getGridGeometry(),
		//		sds, subtractedImage.getData());
		/*BufferedGridCoverage coverage = new BufferedGridCoverage(raster.getGridGeometry(),
				sds, DataBuffer.TYPE_SHORT);
		WritableRaster rasterr = ((BufferedImage) coverage.render(null)).getRaster();
		rasterr.setRect(subtractedImage.getSourceImage(0).getData());*/
		return coverage;
	}

}
