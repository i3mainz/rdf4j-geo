package org.eclipse.rdf4j.testsuites.postgis.raster.editor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.testsuites.postgis.util.SampleRasters;
import org.junit.jupiter.api.Test;

public class AddBandTest extends SampleRasters {
	
	@Test
	public void testTileHeight() {
		NodeValue covLiteral = NodeValue.makeNode(rasterLiteral1, CovJSONDatatype.INSTANCE);
		NodeValue rasterBand = NodeValue.makeNode(rasterBand, WKTDatatype.INSTANCE);
        AddBand instance=new AddBand();
        NodeValue expResult = NodeValue.makeInteger(10);
        NodeValue result = instance.exec(covLiteral,rasterBand);
        assertEquals(expResult, result);
	}
}
