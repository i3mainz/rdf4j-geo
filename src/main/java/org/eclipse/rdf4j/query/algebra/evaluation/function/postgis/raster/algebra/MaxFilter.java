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
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAlgebraUnaryFunction;

public class MaxFilter extends RasterAlgebraUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_rast_algebra_maxfilter.stringValue();
	}


	@Override
	public GridCoverage modify(GridCoverage raster,Integer rd1) {
		ParameterBlock pbSubtracted = new ParameterBlock();
		pbSubtracted.addSource(raster.render(raster.getGridGeometry().getExtent()));
		RenderedOp subtractedImage = JAI.create("maxfilter", pbSubtracted);
		/*
		 * final GridGeometry grid = new
		 * GridGeometry(raster.getGridGeometry().getExtent(), PixelInCell.CELL_CENTER,
		 * MathTransforms.identity(2),
		 * raster.getGridGeometry().getCoordinateReferenceSystem());
		 * 
		 * final MathTransform1D toUnits = (MathTransform1D) MathTransforms.linear(0.5,
		 * 100);
		 */
		final SampleDimension sd = new SampleDimension.Builder().setName("t")
				.addQuantitative(
						(raster.getSampleDimensions().get(rd1).getName() + "maxfilter"),
						raster.getSampleDimensions().get(0).getMeasurementRange().get(),
						raster.getSampleDimensions().get(0).getTransferFunction().get(),
						raster.getSampleDimensions().get(0).getUnits().get())
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
