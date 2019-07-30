package org.eclipse.rdf4j.query.algebra.postgis.linestring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.PrecisionModel;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.util.FactoryException;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricModifierDoubleFunction;

public class Segmentize extends GeometricModifierDoubleFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_segmentize.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double value) {
        double segmentLength = value;

        List<LineString> linestrings;
        try {
			linestrings = createSegments(geom, segmentLength);
	        GeometryFactory fac=new GeometryFactory();
	        return fac.createMultiLineString(linestrings.toArray(new LineString[0]));	
        } catch (FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
 }
	
	public List<LineString> createSegments(Geometry track, double segmentLength) throws NoSuchAuthorityCodeException, FactoryException {

        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING));

        SRSInfo srsInfo = track.getSrsInfo();

        List<Coordinate> coordinates = new ArrayList<>(track.getCoordinates().length);
        Collections.addAll(coordinates, track.getCoordinates());

        double accumulatedLength = 0;
        List<Coordinate> lastSegment = new ArrayList<>();
        List<LineString> segments = new ArrayList<>();
        Iterator<Coordinate> itCoordinates = coordinates.iterator();

        for (int i = 0; itCoordinates.hasNext() && i < coordinates.size() - 1; i++) {
            Coordinate c1 = coordinates.get(i);
            Coordinate c2 = coordinates.get(i + 1);

            lastSegment.add(c1);

            double length;
            //Check for geographic or planar distance.
            //Does the rest of the calculation take into consideration geographic is non-linear in X/Y relationship?
            if (srsInfo.isGeographic()) {
                length = GreatCircleDistance.haversineFormula(c1, c2);
            } else {
                length = c1.distance(c2);
            }

            if (length + accumulatedLength >= segmentLength) {
                double offsetLength = segmentLength - accumulatedLength;
                double ratio = offsetLength / length;
                double dx = c2.x - c1.x;
                double dy = c2.y - c1.y;

                Coordinate segmentationPoint = new Coordinate(c1.x + (dx * ratio), c1.y + (dy * ratio));

                lastSegment.add(segmentationPoint); // Last point of the segment is the segmentation point
                segments.add(geometryFactory.createLineString(lastSegment.toArray(new Coordinate[lastSegment.size()])));

                lastSegment = new ArrayList<>(); // Resets the variable since a new segment will be built
                accumulatedLength = 0D;
                coordinates.add(i + 1, segmentationPoint);
            } else {
                accumulatedLength += length;
            }
        }

        lastSegment.add(coordinates.get(coordinates.size() - 1)); // Because the last one is never added in the loop above
        segments.add(geometryFactory.createLineString(lastSegment.toArray(new Coordinate[lastSegment.size()])));

        return segments;
    }

}
