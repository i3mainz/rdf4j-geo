package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.topo.editor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.topo.base.TopologyModificationGeometryFunction;
import org.locationtech.jts.geom.Geometry;
import org.mibcxb.topojson.TopoObject;
import org.mibcxb.topojson.Topology;

public class Topo_AddPoint extends TopologyModificationGeometryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_Topo_AddPoint.stringValue();
	}
	
	@Override
	public Topology modify(Topology topo, Geometry geometry) {
		TopoObject topoobj=new TopoObject();
		/*Geometry[] geoms=topoobj.
		topoobj.setGeometries(geometries);
		for(TopoObject topobj:topo.getObjects().values()) {
			if(topobj.getType().equals(geometry.getGeometryType())) {
				topobj.
			}
		}
		topo.getObjects().*/
		// TODO Auto-generated method stub
		return null;
	}

}
