package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.geometry.DirectPosition2D;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeIntIntGeomFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.opengis.coverage.grid.GridGeometry;
import org.opengis.geometry.DirectPosition;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

public class RasterToWorldCoord extends RasterAttributeIntIntGeomFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rasterToWorldCoord.stringValue();
	}

	@Override
	public Geometry attribute(GridCoverage raster, Integer longitude, Integer latitude) {
		 try {     	
          	 GridGeometry gg2D = raster.getGridGeometry();
               MathTransform gridToCRS = gg2D.getGridToCRS();
               DirectPosition realPos=new DirectPosition2D(latitude, longitude);
               DirectPosition gridPos = new DirectPosition2D();
               DirectPosition res=gridToCRS.transform(realPos, gridPos);
               Coordinate coord=new Coordinate(res.getCoordinate()[0],res.getCoordinate()[1]);
               GeometryFactory fac=new GeometryFactory();
               return fac.createPoint(coord);
          } catch (TransformException e) {
              return null;
          }
	}

}
