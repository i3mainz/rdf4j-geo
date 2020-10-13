package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util;

import javax.media.jai.iterator.RectIterFactory;
import javax.media.jai.iterator.WritableRectIter;

import org.apache.sis.coverage.grid.GridCoverage;

public class RasterIterator extends RasterUtils {


	    public GridCoverage execute(GridCoverage inputGc) {	    	
	        //initSurface(inputGc);
/*
	        DiskMemImage outputImage = this.createDiskMemImage(inputGc, RasterPixelType.FLOAT);
	        WritableRectIter writer = RectIterFactory.createWritable(outputImage,
	                outputImage.getBounds());

	        GridCoordinates pos = new GridCoordinates();

	        int y = bounds.y;
	        writer.startLines();
	        while (!writer.finishedLines()) {

	            int x = bounds.x;
	            writer.startPixels();
	            while (!writer.finishedPixels()) {
	                pos.setLocation(x, y);

	                visitTPI(writer, pos);

	                writer.nextPixel();
	                x++;
	            }

	            writer.nextLine();
	            y++;
	        }

	        return createGridCoverage("TPI", outputImage);
	        
	    */return null;}
	
}
