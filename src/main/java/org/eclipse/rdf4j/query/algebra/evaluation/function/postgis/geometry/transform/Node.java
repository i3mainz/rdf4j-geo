package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.locationtech.jts.algorithm.RobustLineIntersector;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.noding.IntersectionAdder;
import org.locationtech.jts.noding.MCIndexNoder;
import org.locationtech.jts.noding.Noder;
import org.locationtech.jts.noding.SegmentStringUtil;

public class Node extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_node.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Geometry g2) {
		 Noder noder = new MCIndexNoder(new IntersectionAdder(new RobustLineIntersector()));
	        noder.computeNodes(SegmentStringUtil.extractNodedSegmentStrings(geom1));
	        GeometryFactory fac=new GeometryFactory();
	        return SegmentStringUtil.toGeometry(noder.getNodedSubstrings(), fac);

	}

}
