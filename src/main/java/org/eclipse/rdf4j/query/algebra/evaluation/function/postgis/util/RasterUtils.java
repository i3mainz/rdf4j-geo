package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.util.HashMap;
import java.util.Map;

import javax.media.jai.PlanarImage;

import org.apache.sis.coverage.SampleDimension;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridGeometry;
import org.apache.sis.util.resources.Vocabulary;
import org.locationtech.jts.geom.Envelope;
//import org.opengis.coverage.grid.GridCoordinates;

public class RasterUtils {
	
	protected double srcNoData = -Float.MAX_VALUE;
	
	/** Default tolerance for double comparisons: 1.0e-8 = 0.00000001 */
    public static final double DOUBLE_COMPARE_TOLERANCE = 0.00000001d;

    /** Default tolerance for float comparisons: 1.0e-4 = 0.0001 */
    public static final float FLOAT_COMPARE_TOLERANCE = 0.0001f;
    
    protected double CellSizeX=30.;
    
    protected double CellSizeY=30.;

    protected double _8DX = CellSizeX * 8;

    protected double _8DY = CellSizeY * 8;
    

    protected PlanarImage image;

    protected java.awt.Rectangle bounds;

    private int maxCol;

    private int maxRow;
    
    protected Envelope Extent = null;

    //protected RasterPixelType PixelType = RasterPixelType.INTEGER;

    protected double NoData = Float.MIN_VALUE;

    protected double MinValue = Double.MAX_VALUE;

    protected double MaxValue = Double.MIN_VALUE;

	/*
    public static GridCoverage createGridCoverage(CharSequence name, PlanarImage tiledImage) {
        return createGridCoverage(name, tiledImage, 1, NoData, MinValue, MaxValue, Extent);
    }
    
	public static double[][] getSubMatrix(GridCoordinates pos, int width, int height, double zFactor) {
        int posX = width / 2;
        int posY = height / 2;

        // upper-left corner
        GridCoordinates ulPos = new GridCoordinates(pos.x - posX, pos.y - posY);
        Rectangle rect = new Rectangle(ulPos.x, ulPos.y, width, height);

        Raster subsetRs = image.getData(rect);

        boolean hasNAN = false;
        double[][] mx = new double[width][height];
        for (int dy = ulPos.y, row = 0; row < height; dy++, row++) {
            for (int dx = ulPos.x, col = 0; col < width; dx++, col++) {
                if (dx < bounds.x || dy < bounds.y || dx >= maxCol || dy >= maxRow) {
                    mx[col][row] = Double.NaN;
                    hasNAN = true;
                } else {
                    double ret = subsetRs.getSampleDouble(dx, dy, 0);
                    if (RasterUtils.compareDouble(ret, this.srcNoData)) {
                        mx[col][row] = Double.NaN;
                        hasNAN = true;
                    } else {
                        mx[col][row] = ret * zFactor;
                    }
                }
            }
        }

        if (Double.isNaN(mx[1][1])) {
            return mx;
        }

        // http://help.arcgis.com/en/arcgisdesktop/10.0/help/index.html#/How_Slope_works/009z000000vz000000/
        // If any neighborhood cells are NoData, they are assigned the value of the center cell;
        // then the slope is computed.
        if (hasNAN) {
            for (int drow = 0; drow < height; drow++) {
                for (int dcol = 0; dcol < width; dcol++) {
                    if (Double.isNaN(mx[dcol][drow])) {
                        mx[dcol][drow] = mx[1][1];
                    }
                }
            }
        }

        return mx;
    }
	
	 public static double[][] getSubMatrix(GridCoordinates pos, int width, int height) {
	        return getSubMatrix(pos, width, height, 1.0);
	    }
	 
	 protected void initSurface(GridCoverage gc) {
	        GridGeometry gridGeometry2D = gc.getGridGeometry();
	        AffineTransform gridToWorld = (AffineTransform) gridGeometry2D.getGridToCRS2D();

	        CellSizeX = Math.abs(gridToWorld.getScaleX());
	        CellSizeY = Math.abs(gridToWorld.getScaleY());

	        srcNoData = RasterHelper.getNoDataValue(gc);
	        NoData = -9999;

	        _8DX = CellSizeX * 8;
	        _8DY = CellSizeY * 8;

	        image = (PlanarImage) gc.getRenderedImage();
	        bounds = image.getBounds();

	        maxCol = bounds.x + image.getWidth();
	        maxRow = bounds.y + image.getHeight();
	    }
	 
	 public static boolean compareDouble(double a, double b) {
	        return compareDouble(a, b, DOUBLE_COMPARE_TOLERANCE);
	    }

	 public static boolean compareDouble(double a, double b, double rTol) {
	        final double aTol = 0.00000001;

	        if (Math.abs(a - b) < aTol + (rTol * Math.abs(b))) {
	            return true;
	        }

	        return false;
	    }
	 
	    public static boolean compareFloat(float a, float b, float rTol) {
	        final float aTol = 0.0001f;

	        if (Math.abs(a - b) < aTol + (rTol * Math.abs(b))) {
	            return true;
	        }

	        return false;
	    }

	    public static boolean compareFloat(float a, float b) {
	        return compareFloat(a, b, FLOAT_COMPARE_TOLERANCE);
	    }

	protected GridCoverage createGridCoverage(CharSequence name, RenderedImage image,
            SampleDimension[] bands, double noDataValue, double minValue, double maxValue,
            Envelope extent) {

        if (image == null || extent == null) {
            throw new NullPointerException("WritableRaster is null!");
        }

        if (noDataValue == minValue) {
            noDataValue = minValue - 1;
        } else if (noDataValue == maxValue) {
            noDataValue = maxValue + 1;
        } else if (noDataValue > minValue && noDataValue < maxValue) {
            noDataValue = minValue - 1;
        }

        CharSequence noDataName = Vocabulary.formatInternational(VocabularyKeys.NODATA);

        // setting metadata
        final Map<CharSequence, Double> properties = new HashMap<CharSequence, Double>();
        properties.put("Maximum", Double.valueOf(maxValue));
        properties.put("Minimum", Double.valueOf(minValue));
        // properties.put("Mean", 1.0);
        // properties.put("StdDev", 1.0);
        properties.put(noDataName, Double.valueOf(noDataValue));
        properties.put("GC_NODATA", Double.valueOf(noDataValue));

        GridCoverageFactory factory = CoverageFactoryFinder.getGridCoverageFactory(null);
        return factory.create(name, image, extent, bands, null, properties);
    }*/

	
}
