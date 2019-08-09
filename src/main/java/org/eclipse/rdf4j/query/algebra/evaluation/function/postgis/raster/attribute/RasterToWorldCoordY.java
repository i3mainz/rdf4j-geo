package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridGeometry;
import org.apache.sis.geometry.DirectPosition2D;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeIntIntDoubleFunction;
import org.locationtech.jts.geom.Coordinate;
import org.opengis.geometry.DirectPosition;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

public class RasterToWorldCoordY extends RasterAttributeIntIntDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rasterToWorldCoordY.stringValue();
	}

	@Override
	public Double attribute(GridCoverage raster, Integer longitude, Integer latitude) {
        try {     	
          	 GridGeometry gg2D = raster.getGridGeometry();
               MathTransform gridToCRS = gg2D.getGridToCRS();
               DirectPosition realPos=new DirectPosition2D(latitude, longitude);
               DirectPosition gridPos = new DirectPosition2D();
               DirectPosition res=gridToCRS.transform(realPos, gridPos);
               Coordinate coord=new Coordinate(res.getCoordinate()[0],res.getCoordinate()[1]);
               return coord.y;
          } catch (TransformException e) {
              return (Double) null;
          }
	}

}
