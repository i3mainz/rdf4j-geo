package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import javax.media.jai.iterator.RectIterFactory;
import javax.media.jai.iterator.WritableRectIter;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterUtils;
import org.opengis.coverage.grid.GridCoordinates;

public class Slope extends RasterModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_slope.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage coverage) {
		return null;//calculateSlope(coverage, slopeType, zFactor)
	}
	
public GridCoverage calculateSlope(GridCoverage inputGc, Boolean slopeType, double zFactor) {
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

                calculateSlopeForPixel(writer, pos, slopeType, zFactor);

                writer.nextPixel();
                x++;
            }

            writer.nextLine();
            y++;
        }

        return RasterUtils.createGridCoverage("Slope", outputImage);
        */
	return null;
    }
/*
    private void calculateSlopeForPixel(WritableRectIter writer, GridCoordinates pos, Boolean slopeType,
            double zFactor) {
        // http://webhelp.esri.com/arcgisdesktop/9.3/index.cfm?TopicName=How%20Slope%20works
        // Burrough, P. A. and McDonell, R.A., 1998. Principles of Geographical Information Systems
        // (Oxford University Press, New York), p. 190.
        // [dz/dx] = ((c + 2f + i) - (a + 2d + g) / (8 * x_cell_size)
        // [dz/dy] = ((g + 2h + i) - (a + 2b + c)) / (8 * y_cell_size)
        // slope_degrees = ATAN ( ( [dz/dx]2 + [dz/dy]2 ) ) * 57.29578

        // For degrees, the range of slope values is 0 to 90.
        // For percent rise, the range is 0 to essentially infinity.
        // A flat surface is 0 percent, a 45 degree surface is 100 percent
        // If the center cell in the immediate neighborhood (3 x 3 window) is NoData,
        // the output is NoData.
        // If any neighborhood cells are NoData, they are assigned the value of the center cell;
        // then the slope is computed.

        // +-------+ +-------+
        // | 0 1 2 | | a b c |
        // | 3 4 5 |>| d e f |
        // | 6 7 8 | | g h i |
        // +-------+ +-------+
        double[][] mx = RasterUtils.getSubMatrix(pos, 3, 3, zFactor);
        if (Double.isNaN(mx[1][1]) || RasterUtils.compareDouble(srcNoData, mx[1][1])) {
            writer.setSample(0, NoData);
            return;
        }

        double dZdX = ((mx[2][0] + 2 * mx[2][1] + mx[2][2]) - (mx[0][0] + 2 * mx[0][1] + mx[0][2]))
                / (_8DX);
        double dZdY = ((mx[0][2] + 2 * mx[1][2] + mx[2][2]) - (mx[0][0] + 2 * mx[1][0] + mx[2][0]))
                / (_8DY);

        double rise_run = (dZdX * dZdX) + (dZdY * dZdY);
        if (Double.isNaN(rise_run) || Double.isInfinite(rise_run)) {
            writer.setSample(0, NoData);
            return;
        }

        double slope = Math.atan(Math.sqrt(rise_run));

        if (slopeType) {
            slope = Math.toDegrees(slope);
        } else {
            slope = Math.tan(slope) * 100;
        }

        if (slope < 0 || slope > 100) {
            writer.setSample(0, NoData);
            return;
        }

        writer.setSample(0, slope);
    }
*/
}
