package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.algebra;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;
import java.awt.image.renderable.ParameterBlock;
import java.util.LinkedList;
import java.util.List;

import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

import org.apache.sis.coverage.SampleDimension;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.internal.coverage.BufferedGridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAlgebraConstFunction;

public class MultConst extends RasterAlgebraConstFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_rast_algebra_multconst.stringValue();
	}


	@Override
	public GridCoverage modify(GridCoverage raster,Integer rd1,Double constt) {
		ParameterBlock pbSubtracted = new ParameterBlock();
		pbSubtracted.addSource(raster.render(raster.getGridGeometry().getExtent()));
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
		pbSubtracted.add(consts);
		RenderedOp subtractedImage = JAI.create("multconst", pbSubtracted);
		final SampleDimension sd = new SampleDimension.Builder().setName("t")
				.addQuantitative(
						(raster.getSampleDimensions().get(rd1).getName() + " multconst "
								+ constt).toString(),
						raster.getSampleDimensions().get(rd1).getMeasurementRange().get(),
						raster.getSampleDimensions().get(rd1).getTransferFunction().get(),
						raster.getSampleDimensions().get(rd1).getUnits().get())
				.build();
		
		List<SampleDimension>sds=new LinkedList<SampleDimension>();
		sds.add(sd);
		/*
		 * Create the grid coverage, gets its image and set values directly as short
		 * integers.
		 */
		BufferedGridCoverage coverage = new BufferedGridCoverage(raster.getGridGeometry(),
				sds, DataBuffer.TYPE_SHORT);
		WritableRaster rasterr = ((BufferedImage) coverage.render(null)).getRaster();
		rasterr.setRect(subtractedImage.getSourceImage(0).getData());
		return coverage;
	}

}
