package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import javax.media.jai.iterator.WritableRectIter;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterIterator;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterUtils;
import org.opengis.coverage.grid.GridCoordinates;

public class Curvature extends RasterModifierFunction {

	Double zFactor=null;
	
	@Override
	public String getURI() {
		return POSTGIS.st_curvature.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage coverage) {
		this.zFactor=zFactor;
		return iter.calculateNewRaster(coverage);
	}
	
	RasterIterator iter=new RasterIterator() {
		
		@Override
		public void execute(WritableRectIter writer, GridCoordinates pos) {
			 // http://resources.arcgis.com/en/help/main/10.1/#/How_Curvature_works/009z000000vs000000/
	        // Zeverbergen, L. W., and C. R. Thorne. 1987. Quantitative Analysis of Land Surface
	        // Topography.
	        // Earth Surface Processes and Landforms 12: 47–56.

	        double[][] mx = RasterUtils.getSubMatrix(pos, 3, 3, zFactor);
	        if (Double.isNaN(mx[1][1]) || RasterUtils.compareDouble(srcNoData, mx[1][1])) {
	            writer.setSample(0, NoData);
	            return;
	        }

	        // Z = Ax²y² + Bx²y + Cxy² + Dx² + Ey² + Fxy + Gx + Hy + I

	        // A = [(Z1 + Z3 + Z7 + Z9) / 4 - (Z2 + Z4 + Z6 + Z8) / 2 + Z5] / L4
	        // double A = ((Z1 + Z3 + Z7 + Z9) / 4 - (Z2 + Z4 + Z6 + Z8) / 2 + Z5) / L4 ;

	        // B = [(Z1 + Z3 - Z7 - Z9) /4 - (Z2 - Z8) /2] / L3
	        // double B = ((Z1 + Z3 - Z7 - Z9) /4 - (Z2 - Z8) /2) / L3;

	        // C = [(-Z1 + Z3 - Z7 + Z9) /4 + (Z4 - Z6)] /2] / L3
	        // double C = ((-Z1 + Z3 - Z7 + Z9) /4 + (Z4 - Z6)] /2) / L3;

	        // +-------+ +----------+
	        // | 0 1 2 | | Z1 Z2 Z3 |
	        // | 3 4 5 |>| Z4 Z5 Z6 |
	        // | 6 7 8 | | Z7 Z8 Z9 |
	        // +-------+ +----------+
	        // D = [(Z4 + Z6) /2 - Z5] / L2
	        double D = ((mx[0][1] + mx[2][1]) / 2.0 - mx[1][1]) / xL2;

	        // E = [(Z2 + Z8) /2 - Z5] / L2
	        double E = ((mx[1][0] + mx[1][2]) / 2.0 - mx[1][1]) / yL2;

	        // F = (-Z1 + Z3 + Z7 - Z9) / 4L2
	        // double F = (mx[2][0] - mx[0][0] + mx[0][2] - mx[2][2]) / x4L2;

	        // G = (-Z4 + Z6) / 2L
	        double G = (mx[2][1] - mx[0][1]) / x2L;

	        // H = (Z2 - Z8) / 2L
	        double H = (mx[1][0] - mx[1][2]) / y2L;

	        // I = Z5
	        // double I = Z5;

	        // The output of the Curvature tool is the second derivative of the surface—for example,
	        // the slope of the slope—such that: Curvature = -2(D + E) * 100

	        final double k2 = G * G + H * H;

	        double curvature = 0;
	        if (k2 != 0) {
	            curvature = -2.0 * (E + D);

	            // optional Horizontal curvature & Vertical curvature
	            // double k1 = F * G * H;
	            // double vCurv = -2.0 * (D * G * G + E * H * H + k1) / k2;
	            // double hCurv = -2.0 * (D * H * H + E * G * G - k1) / k2;
	        }

	        // Units of the curvature output raster, as well as the units for the optional output
	        // profile curve raster and output plan curve raster, are one hundredth (1/100) of a z-unit.

	        curvature = curvature * (100.0 * zFactor);

	        writer.setSample(0, curvature);
			
		}
	};

}
