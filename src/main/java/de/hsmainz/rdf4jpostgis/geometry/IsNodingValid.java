package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.noding.FastNodingValidator;
import org.locationtech.jts.noding.SegmentStringUtil;

public class IsNodingValid extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		FastNodingValidator nv = new FastNodingValidator(
		        SegmentStringUtil.extractNodedSegmentStrings(geom));
		return nv.isValid();
	}
	
	

}
