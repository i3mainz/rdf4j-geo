package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateXYM;
import org.locationtech.jts.geom.CoordinateXYZM;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierStringFunction;

public class SwapOrdinates extends GeometricModifierStringFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_swapOrdinates.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, String value) {
            String ords = value;
            List<Coordinate> newcoords=new ArrayList<Coordinate>();
            if(ords.equalsIgnoreCase("xy")) {
            	for(Coordinate coord:geom.getCoordinates()) {
            		if(coord instanceof CoordinateXYM) {
                		newcoords.add(new CoordinateXYM(coord.getY(),coord.getX(),coord.getM()));
            		}else if(coord instanceof CoordinateXYZM) {
            			newcoords.add(new CoordinateXYZM(coord.getY(),coord.getX(),coord.getZ(),coord.getM()));
            		}else {
                		newcoords.add(new Coordinate(coord.getY(),coord.getX()));            			
            		}
            	}
            }else if(ords.equalsIgnoreCase("xz")) {
               	for(Coordinate coord:geom.getCoordinates()) {
            		if(coord instanceof CoordinateXYM) {
                		throw new RuntimeException("Coordinates do not contain a Z value");
            		}else if(coord instanceof CoordinateXYZM) {
            			newcoords.add(new CoordinateXYZM(coord.getZ(),coord.getY(),coord.getX(),coord.getM()));
            		}else {
            			newcoords.add(new Coordinate(coord.getZ(),coord.getY(),coord.getX()));          			
            		}
            	}
            }else if(ords.equalsIgnoreCase("yz")) {
               	for(Coordinate coord:geom.getCoordinates()) {
            		if(coord instanceof CoordinateXYM) {
                		throw new RuntimeException("Coordinates do not contain a Z value");
            		}else if(coord instanceof CoordinateXYZM) {
            			newcoords.add(new CoordinateXYZM(coord.getX(),coord.getZ(),coord.getY(),coord.getM()));
            		}else {
            			newcoords.add(new Coordinate(coord.getX(),coord.getZ(),coord.getY()));         			
            		}
            	}
            }else if(ords.equalsIgnoreCase("xm")) {
               	for(Coordinate coord:geom.getCoordinates()) {
            		if(coord instanceof CoordinateXYM) {
            			newcoords.add(new CoordinateXYM(coord.getM(),coord.getY(),coord.getX()));
            		}else if(coord instanceof CoordinateXYZM) {
            			newcoords.add(new CoordinateXYZM(coord.getM(),coord.getY(),coord.getZ(),coord.getX()));
            		}else {
                		throw new RuntimeException("Coordinates do not contain a M value");          			
            		}
            	}
            }else if(ords.equalsIgnoreCase("ym")) {
               	for(Coordinate coord:geom.getCoordinates()) {
            		if(coord instanceof CoordinateXYM) {
            			newcoords.add(new CoordinateXYM(coord.getX(),coord.getM(),coord.getY()));
            		}else if(coord instanceof CoordinateXYZM) {
            			newcoords.add(new CoordinateXYZM(coord.getX(),coord.getM(),coord.getZ(),coord.getY()));
            		}else {
                		throw new RuntimeException("Coordinates do not contain a M value");          			
            		}
            	}
            }else if(ords.equalsIgnoreCase("zm")) {
               	for(Coordinate coord:geom.getCoordinates()) {
            		if(coord instanceof CoordinateXYM) {
            			throw new RuntimeException("Coordinates do not contain a M and Z value");      
            		}else if(coord instanceof CoordinateXYZM) {
            			newcoords.add(new CoordinateXYZM(coord.getX(),coord.getY(),coord.getM(),coord.getZ()));
            		}else {
                		throw new RuntimeException("Coordinates do not contain a M and Z value");          			
            		}
            	}
            }else {
            	throw new RuntimeException("Invalid second argument"); 
            }
            return LiteralUtils.createGeometry(newcoords, geom.getGeometryType(), geom.getSRID());
	}

}
