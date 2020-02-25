/*******************************************************************************
 * Copyright (c) 2016 The University of Reading
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the University of Reading, nor the names of the
 *    authors or contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/

package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.parsers;

import org.apache.sis.coverage.SampleDimension;
import org.apache.sis.coverage.grid.GridCoverage;
import org.json.JSONArray;
import org.json.JSONObject;

public class CoverageJsonWriter {
	GridCoverage coverage;

	public CoverageJsonWriter(GridCoverage coverage) {
		this.coverage=coverage;
	}
	
	public static JSONObject coverageToCovJSON(GridCoverage coverage) {
		JSONObject result=new JSONObject();
		result.put("type","Coverage");
		JSONObject domain=new JSONObject();
		result.put("domain",domain);
		domain.put("type", "Domain");
		domain.put("domainType", "Grid");
		JSONObject axes=new JSONObject();
		domain.put("axes",axes);
		JSONArray x=new JSONArray();
		JSONArray y=new JSONArray();
		axes.put("x", x);
		axes.put("y", y);
		if(coverage.getGridGeometry().getEnvelope().getDimension()>2) {
			JSONArray z=new JSONArray();
			axes.put("z", z);
		}
		JSONArray referencing=new JSONArray();
		domain.put("referencing", referencing);
		//coverage.getGridGeometry().getCoordinateReferenceSystem().getName()
		JSONObject ref=new JSONObject();
		referencing.put(ref);
		ref.put("coordinates",new JSONArray());
		JSONObject crs=new JSONObject();
		ref.put("system",crs);
		crs.put("type", "GeopraphicCRS");
		crs.put("id", coverage.getCoordinateReferenceSystem().getName());
		if(coverage.getGridGeometry().getTemporalExtent().length!=0) {
			
		}
		JSONObject parameters=new JSONObject();
		result.put("parameters", parameters);
		for(SampleDimension dimension:coverage.getSampleDimensions()) {
			JSONObject sampledim=new JSONObject();
			parameters.put(dimension.getName().toString(),sampledim);
			sampledim.put("type","Parameter");
			JSONObject description=new JSONObject();
			sampledim.put("description",description);
			description.put("en",dimension.getName().toString());
			if(dimension.getUnits()!=null && dimension.getUnits().isPresent()) {
				JSONObject unit=new JSONObject();
				sampledim.put("unit",unit);
				JSONObject unitlabel=new JSONObject();
				unit.put("label",unitlabel);
				unitlabel.put("en",dimension.getUnits().get().getName());
				JSONObject symbol=new JSONObject();
				unit.put("symbol",symbol);
				symbol.put("value",dimension.getUnits().get());
			}
			JSONObject observedProperty=new JSONObject();
			sampledim.put("observedProperty",observedProperty);
			JSONObject oPLabel=new JSONObject();
			observedProperty.put("label",oPLabel);
			/*oPLabel.put("en",dimension.)
			
			dimension.getCategories();
			dimension.getMeasurementRange()*/
		}

		JSONObject ranges=new JSONObject();
		result.put("ranges",ranges);
		return result;
	}
	
}
