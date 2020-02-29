package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.geometry.DirectPosition2D;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeIntIntGeomFunction;
import org.locationtech.jts.geom.Geometry;
import org.opengis.referencing.datum.PixelInCell;

public class PixelAsPoint extends RasterAttributeIntIntGeomFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_pixelAsPoint.stringValue();
	}

	@Override
	public Geometry attribute(GridCoverage coverage, Integer columnx, Integer rowy) {
		/*coverage.getGridGeometry().getGridToCRS(anchor)
		PixelInCell pincell=new Pixel;
		pincell.
		
		coverage.getGridGeometry().getGridToCRS(anchor)*/
		// TODO Auto-generated method stub
		return null;
	}

}
