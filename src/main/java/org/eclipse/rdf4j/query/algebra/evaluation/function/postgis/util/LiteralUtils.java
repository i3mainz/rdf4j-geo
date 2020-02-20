package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import org.apache.sis.geometry.DirectPosition2D;
import org.apache.sis.geometry.Envelope2D;
import org.apache.sis.referencing.CRS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.OctagonalEnvelope;
import org.locationtech.jts.geom.Polygon;
import org.opengis.geometry.BoundingBox;
import org.opengis.geometry.DirectPosition;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.CoordinateOperation;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import org.opengis.util.FactoryException;


public class LiteralUtils {

	public static Geometry toGeometry(final org.opengis.geometry.Envelope envelope) {
		
        GeometryFactory gf = new GeometryFactory();
        return gf.createPolygon(gf.createLinearRing(
                new Coordinate[]{
                    new Coordinate(envelope.getLowerCorner().getDirectPosition().getCoordinate()[0], envelope.getLowerCorner().getDirectPosition().getCoordinate()[1]),
                    new Coordinate(envelope.getUpperCorner().getDirectPosition().getCoordinate()[0], envelope.getLowerCorner().getDirectPosition().getCoordinate()[1]),
                    new Coordinate(envelope.getUpperCorner().getDirectPosition().getCoordinate()[0], envelope.getUpperCorner().getDirectPosition().getCoordinate()[1]),
                    new Coordinate(envelope.getLowerCorner().getDirectPosition().getCoordinate()[0], envelope.getLowerCorner().getDirectPosition().getCoordinate()[1]),
                    new Coordinate(envelope.getLowerCorner().getDirectPosition().getCoordinate()[0], envelope.getLowerCorner().getDirectPosition().getCoordinate()[1])
                }), null);
    }
	
	public static Geometry toGeometry(final Envelope envelope) {
        GeometryFactory gf = new GeometryFactory();
        return gf.createPolygon(gf.createLinearRing(
                new Coordinate[]{
                    new Coordinate(envelope.getMinX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMinY())
                }), null);
    }
	
	public static Geometry toGeometry(final Envelope2D envelope) {
        GeometryFactory gf = new GeometryFactory();
        return gf.createPolygon(gf.createLinearRing(
                new Coordinate[]{
                    new Coordinate(envelope.getMinX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMinY())
                }), null);
    }
	
	public static Geometry toGeometry(final OctagonalEnvelope envelope) {
        GeometryFactory gf = new GeometryFactory();
        return gf.createPolygon(gf.createLinearRing(
                new Coordinate[]{
                    new Coordinate(envelope.getMinX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMinY())
                }), null);
    }
	

	
	public static Geometry toGeometry(final BoundingBox envelope) {
        GeometryFactory gf = new GeometryFactory();
        return gf.createPolygon(gf.createLinearRing(
                new Coordinate[]{
                    new Coordinate(envelope.getMinX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMinY())
                }), null);
    }
	
	 public static Geometry toGeometry(final Rectangle envelope) {
	        GeometryFactory gf = new GeometryFactory();
	        return gf.createPolygon(gf.createLinearRing(
	                new Coordinate[]{
	                    new Coordinate(envelope.getMinX(), envelope.getMinY()),
	                    new Coordinate(envelope.getMaxX(), envelope.getMinY()),
	                    new Coordinate(envelope.getMaxX(), envelope.getMaxY()),
	                    new Coordinate(envelope.getMinX(), envelope.getMaxY()),
	                    new Coordinate(envelope.getMinX(), envelope.getMinY())
	                }), null);
	    }
	
	 
		public static Geometry createGeometry(Coordinate[] coordinates,String geomtype,Integer srid) {
			GeometryFactory fac=new GeometryFactory();
			Geometry geom;
			switch(geomtype) {
			case "Point":
				geom= fac.createPoint(coordinates[0]);
				geom.setSRID(srid);
				return geom;
			case "MultiPoint":
				geom=fac.createMultiPointFromCoords(coordinates);
				geom.setSRID(srid);
				return geom;
			case "LineString":
				geom= fac.createLineString(coordinates);
				geom.setSRID(srid);
				return geom;
			case "Polygon":
				geom= fac.createPolygon(coordinates);
				geom.setSRID(srid);
				return geom;
			case "MultiLineString":
				List<LineString> list=new LinkedList<LineString>();
				list.add(fac.createLineString(coordinates));
				geom= fac.createMultiLineString(list.toArray(new LineString[0]));
				geom.setSRID(srid);
				return geom;
			case "MultiPolygon":
				List<Polygon> plist=new LinkedList<Polygon>();
				plist.add(fac.createPolygon(coordinates));
				geom= fac.createMultiPolygon(plist.toArray(new Polygon[0]));
				geom.setSRID(srid);
				return geom;
			default:
				return null;
			}
		}

		public static Geometry createGeometryCollection(List<Geometry> geometries,String geomtype,Integer srid) {
			return createGeometryCollection(geometries.toArray(new Geometry[0]), geomtype, srid);		
		}
		
		public static Geometry createGeometryCollection(Geometry[] geometries,String geomtype,Integer srid) {
			GeometryFactory fac=new GeometryFactory();
			return fac.createGeometryCollection(geometries);			
		}
		
		public static Geometry createGeometry(List<Coordinate> coordarray,String geomtype,Integer srid) {
			return createGeometry(coordarray.toArray(new Coordinate[0]), geomtype,srid);
		}
		
		public static Geometry transform(Geometry sourcegeom,Geometry targetgeom) {
		
			CoordinateReferenceSystem source;
				try {
					source = CRS.forCode("EPSG:"+sourcegeom.getSRID());
					CoordinateReferenceSystem target = CRS.forCode("EPSG:"+targetgeom.getSRID());                   // WGS 84 / World Mercator
					CoordinateOperation operation = CRS.findOperation(source, target, null);
					if (CRS.getLinearAccuracy(operation) > 100) {
					    // If the accuracy is coarser than 100 metres (or any other threshold at application choice)
					    // maybe the operation is not suitable. Decide here what to do (throw an exception, etc).
					}
					MathTransform mt = operation.getMathTransform();
					List<Coordinate> coords=new LinkedList<Coordinate>();
					for(Coordinate coord:targetgeom.getCoordinates()) {
						DirectPosition resposition = new DirectPosition2D(20, 30);            // 20°N 30°E   (watch out axis order!)
						mt.transform(new DirectPosition2D(coord.getY(),coord.getY()), resposition);
						coords.add(new Coordinate(resposition.getCoordinate()[1],resposition.getCoordinate()[0]));
					}
					return LiteralUtils.createGeometry(coords, targetgeom.getGeometryType(), targetgeom.getSRID());

				} catch (FactoryException | MismatchedDimensionException | TransformException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
				
		}
}
