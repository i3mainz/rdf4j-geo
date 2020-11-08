package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.algebra;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;
import java.awt.image.renderable.ParameterBlock;
import java.util.LinkedList;
import java.util.List;

import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

import org.apache.sis.coverage.Category;
import org.apache.sis.coverage.SampleDimension;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridExtent;
import org.apache.sis.coverage.grid.GridGeometry;
import org.apache.sis.internal.coverage.BufferedGridCoverage;
import org.apache.sis.util.iso.DefaultNameFactory;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAlgebraConstFunction;
import org.opengis.referencing.datum.PixelInCell;

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
		RenderedOp subtractedImage = JAI.create("multiplyconst", pbSubtracted);
		final SampleDimension sd =raster.getSampleDimensions().get(rd1);
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
		return coverage;
	}

}
