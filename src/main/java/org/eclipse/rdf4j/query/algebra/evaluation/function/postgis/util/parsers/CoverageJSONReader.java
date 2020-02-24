package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.parsers;

import java.util.LinkedList;
import java.util.List;

import org.apache.sis.coverage.SampleDimension;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridExtent;
import org.apache.sis.coverage.grid.GridGeometry;
import org.apache.sis.internal.coverage.BufferedGridCoverage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.opengis.coverage.grid.Grid;

public class CoverageJSONReader {

	public static GridCoverage covJSONToCoverage(JSONObject covjson) {
		List<SampleDimension> dimensions=new LinkedList<SampleDimension>();
		Grid grid=new Grid();
		SampleDimensionBuilder builder;
		JSONObject axes=covjson.getJSONObject("domain").getJSONObject("axes");
		Integer minX=Integer.MAX_VALUE;
		Integer maxX=0;
		Integer minY=Integer.MAX_VALUE;
		Integer maxY=0;
		if(axes.getJSONObject("x").has("values")) {
			JSONArray xvalues=axes.getJSONObject("x").getJSONArray("values");
			for(int i=0;i<xvalues.length();i++) {
				if(xvalues.getInt(i)<minX) {
					minX=xvalues.getInt(i);
				}
				if(xvalues.getInt(i)>maxX) {
					maxX=xvalues.getInt(i);
				}
			}
		}
		if(axes.getJSONObject("y").has("values")) {
			JSONArray yvalues=axes.getJSONObject("y").getJSONArray("values");
			for(int i=0;i<yvalues.length();i++) {
				if(yvalues.getInt(i)<minY) {
					minY=yvalues.getInt(i);
				}
				if(yvalues.getInt(i)>maxY) {
					maxY=yvalues.getInt(i);
				}
			}
		}
		GridGeometry gridgeom=new GridGeometry(extent, envelope)//domain
		SampleDimension dim=new SampleDimension(name, background, categories)
		
		GridExtent extent=new GridExtent(width, height)
		
		GridCoverage res=new GridCover
		return null;
	}
}
