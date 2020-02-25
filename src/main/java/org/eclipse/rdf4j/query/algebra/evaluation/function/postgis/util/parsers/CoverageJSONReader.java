package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.parsers;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.sis.coverage.Category;
import org.apache.sis.coverage.SampleDimension;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridExtent;
import org.apache.sis.coverage.grid.GridGeometry;
import org.apache.sis.geometry.Envelope2D;
import org.apache.sis.internal.coverage.GridCoverage2D;
import org.json.JSONArray;
import org.json.JSONObject;
import org.opengis.metadata.spatial.DimensionNameType;
import org.opengis.util.FactoryException;

public class CoverageJSONReader {

	public static GridCoverage covJSONStringToCoverage(String covjson) {
		return covJSONToCoverage(new JSONObject(covjson));
	}
	
	public static GridCoverage covJSONToCoverage(JSONObject covjson) {
		JSONObject axes=covjson.getJSONObject("domain").getJSONObject("axes");
		Integer minX=Integer.MAX_VALUE;
		Integer maxX=0;
		Integer minY=Integer.MAX_VALUE;
		Integer maxY=0;
		Integer minZ=Integer.MAX_VALUE;
		Integer maxZ=0;
		Integer minT=Integer.MAX_VALUE;
		Integer maxT=0;
		List<DimensionNameType> axestypes=new LinkedList<DimensionNameType>();
		List<Long> mins=new LinkedList<Long>();
		List<Long> maxs=new LinkedList<Long>();
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
			mins.add(Long.valueOf(minX));
			maxs.add(Long.valueOf(maxX));
			axestypes.add(DimensionNameType.COLUMN);
		}else if(axes.getJSONObject("x").has("start") && axes.getJSONObject("x").has("stop")
				&& axes.getJSONObject("x").has("num")) {
			mins.add(axes.getJSONObject("x").getLong("start"));
			maxs.add(axes.getJSONObject("x").getLong("stop"));
			axestypes.add(DimensionNameType.COLUMN);
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
			mins.add(Long.valueOf(minY).longValue());
			maxs.add(Long.valueOf(maxY).longValue());
			axestypes.add(DimensionNameType.ROW);
		}else if(axes.getJSONObject("y").has("start") && axes.getJSONObject("y").has("stop")
				&& axes.getJSONObject("y").has("num")) {
			mins.add(axes.getJSONObject("y").getLong("start"));
			maxs.add(axes.getJSONObject("y").getLong("stop"));
			axestypes.add(DimensionNameType.ROW);
		}
		if(axes.has("z")) {
			if(axes.getJSONObject("z").has("values")) {
				JSONArray zvalues=axes.getJSONObject("z").getJSONArray("values");
				for(int i=0;i<zvalues.length();i++) {
					if(zvalues.getInt(i)<minZ) {
						minZ=zvalues.getInt(i);
					}
					if(zvalues.getInt(i)>maxZ) {
						maxZ=zvalues.getInt(i);
					}
				}
				mins.add(Long.valueOf(minZ).longValue());
				maxs.add(Long.valueOf(maxZ).longValue());
				axestypes.add(DimensionNameType.VERTICAL);
			}else if(axes.getJSONObject("y").has("start") && axes.getJSONObject("y").has("stop")
					&& axes.getJSONObject("y").has("num")) {
				mins.add(axes.getJSONObject("y").getLong("start"));
				maxs.add(axes.getJSONObject("y").getLong("stop"));
				axestypes.add(DimensionNameType.VERTICAL);
			}
		}
		if(axes.has("t")) {
			if(axes.getJSONObject("t").has("values")) {
				JSONArray tvalues=axes.getJSONObject("t").getJSONArray("values");
				for(int i=0;i<tvalues.length();i++) {
					if(tvalues.getInt(i)<minT) {
						minT=tvalues.getInt(i);
					}
					if(tvalues.getInt(i)>maxT) {
						maxT=tvalues.getInt(i);
					}
				}
				mins.add(Long.valueOf(minT).longValue());
				maxs.add(Long.valueOf(maxT).longValue());
				axestypes.add(DimensionNameType.TIME);
			}else if(axes.getJSONObject("y").has("start") && axes.getJSONObject("y").has("stop")
					&& axes.getJSONObject("y").has("num")) {
				mins.add(axes.getJSONObject("y").getLong("start"));
				maxs.add(axes.getJSONObject("y").getLong("stop"));
				axestypes.add(DimensionNameType.TIME);
			}
		}
		GridExtent extent=new GridExtent(axestypes.toArray(new DimensionNameType[0]),
				ArrayUtils.toPrimitive(mins.toArray(new Long[0])), ArrayUtils.toPrimitive(maxs.toArray(new Long[0])),true);		
		Envelope2D gridenv=new Envelope2D();
		GridGeometry gridgeom=new GridGeometry(extent, gridenv);//domain
		Map<String,List<Category>> categories=new TreeMap<>();
		for(String key:covjson.getJSONObject("ranges").keySet()) {
			Category cat=new Category(key,)
		}
		List<SampleDimension> dimensions=new LinkedList<SampleDimension>();
		for(String key:covjson.getJSONObject("parameters").keySet()) {
			dimensions.add(new SampleDimension(key, 0, categories));
		}
		//SampleDimension dim=new SampleDimension(name, background, categories)
		GridCoverage res;
		try {
			res = new GridCoverage2D(gridgeom,dimensions,null);
			return res;
		} catch (FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
