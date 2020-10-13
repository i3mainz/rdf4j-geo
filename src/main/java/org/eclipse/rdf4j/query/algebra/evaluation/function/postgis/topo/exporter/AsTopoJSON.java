package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.topo.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.topo.base.TopologyStringExportFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.topo.TopoJSONDatatype;
import org.mibcxb.topojson.Topology;

public class AsTopoJSON extends TopologyStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_ASTOPOJSON.stringValue();
	}

	@Override
	public String modify(Topology topo) {
		return TopoJSONDatatype.INSTANCE.unparse(topo);
	}

}
