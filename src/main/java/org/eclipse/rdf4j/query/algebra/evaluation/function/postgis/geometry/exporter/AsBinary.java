package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;


import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKBDatatype;

public class AsBinary extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
		return WKBDatatype.INSTANCE.unparse(geom);
       /* String endianness = arg1.getString();
        WKBWriter writer=new WKBWriter();
        
        byte[] result=writer.write(geom);
        if(arg1!=null) {
            ByteBuffer bb = ByteBuffer.wrap(result);
        	if("XDR".equals(endianness)) {
                bb.order( ByteOrder.BIG_ENDIAN);
        	}else if("NDR".equals(endianness)) {
        		bb.order( ByteOrder.LITTLE_ENDIAN);
        	}
            return bb.toString();
        }
        return result.toString();*/
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASBINARY.stringValue();
	}
	
	

}
