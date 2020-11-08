package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import java.awt.geom.AffineTransform;
import java.awt.image.RenderedImage;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridGeometry;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeStringFunction;
import org.opengis.referencing.datum.PixelInCell;

public class Summary extends RasterAttributeStringFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_summary.stringValue();
	}


	@Override
	public String attribute(GridCoverage raster) {
		StringBuilder builder = new StringBuilder();
		RenderedImage rendered;
				rendered = raster.render(null);
        builder.append("Raster of " + rendered.getWidth() + "x" + rendered.getHeight() +"\n MemSize: "+raster.render(null).getData().getDataBuffer().getSize()+ 
        		"\nMINX/Y: ["+rendered.getMinX()+","+rendered.getMinY()+"] pixels has " 
        		+ raster.getSampleDimensions().size() + " bands\n and extent of " +raster.getGridGeometry().getEnvelope().toString()
        		);//+"\n and grid geometry of "+ raster.getGridGeometry() + System.lineSeparator());
        builder.append("SampleModel: "+rendered.getSampleModel()+"\n");
        builder.append("PropertyNames: "+rendered.getPropertyNames()+"\n");
        builder.append("Tiles: "+rendered.getNumXTiles()+"/"+rendered.getNumYTiles()+"["+rendered.getTileWidth()+"/"+rendered.getTileHeight()+"] Offset: ["+rendered.getTileGridXOffset()+"/"+rendered.getTileGridYOffset()+"]\n");
        builder.append("Dimensions: "+raster.getGridGeometry().getDimension()+"\n");
        builder.append("DataElements: "+rendered.getData().getNumDataElements()+"\n");
        builder.append("DataType: "+rendered.getData().getDataBuffer().getDataType()+"\n");
        builder.append("ColorModel: "+rendered.getColorModel()+"\n");
		GridGeometry gridGeometry2D = raster.getGridGeometry();
        AffineTransform gridToWorld = (AffineTransform) gridGeometry2D.getGridToCRS(PixelInCell.CELL_CENTER);
        builder.append("Shear: ["+gridToWorld.getShearX()+"/"+gridToWorld.getShearY()+"] Scale: ["+gridToWorld.getScaleX()+"/"+gridToWorld.getScaleY()+"]\n");
        builder.append("GridToWorld: ["+gridToWorld. getShearX()+"/"+gridToWorld.getShearY()+"] Scale: ["+gridToWorld.getScaleX()+"/"+gridToWorld.getScaleY()+"]\n");
        builder.append("PixelData: \n");
        for(int k=0;k<raster.getSampleDimensions().size();k++) {
        	builder.append("Band "+k+"\n");
        	for(int i=0;i<rendered.getSampleModel().getWidth();i++) {
        		builder.append("| ");
        		for(int j=0;j<rendered.getSampleModel().getHeight();j++) {
        			builder.append(rendered.getData().getSample(i, j, k)+" | ");
        		}
        		builder.append("\n");
        	}
        }
        builder.append("CRS: "+raster.getGridGeometry().getCoordinateReferenceSystem().getName()+"\n");
        for (int i = 0; i < raster.getSampleDimensions().size(); i++) {
            builder.append("band " + i + " of pixtype " + raster.getSampleDimensions().get(i).getMeasurementRange() + " is in-db with NODATA value of " + raster.getSampleDimensions().get(i).getNoDataValues() + System.lineSeparator());
        }
        return builder.toString();
	}

}
