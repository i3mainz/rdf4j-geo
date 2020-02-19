package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util;

import javax.media.jai.iterator.RectIterFactory;
import javax.media.jai.iterator.WritableRectIter;

import org.apache.sis.coverage.grid.GridCoverage;
import org.opengis.coverage.grid.GridCoordinates;

public abstract class RasterIterator {
	
	protected double srcNoData = -Float.MAX_VALUE;

	protected Integer NoData = -9999;
	
	 private double xL2;

	 private double x2L;
	
	public abstract void execute(WritableRectIter writer, GridCoordinates pos);
	
	
	
	public GridCoverage calculateNewRaster(GridCoverage inputGc) {

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

                execute(writer, pos);

                writer.nextPixel();
                x++;
            }

            writer.nextLine();
            y++;
        }

        return createGridCoverage("TPI", outputImage);
    }

}
