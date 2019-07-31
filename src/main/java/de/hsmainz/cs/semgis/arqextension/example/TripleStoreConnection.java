package de.hsmainz.cs.semgis.arqextension.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter.AsGeoJSON;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParseException;
import org.eclipse.rdf4j.rio.RDFParser;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.rio.UnsupportedRDFormatException;
import org.eclipse.rdf4j.sail.memory.MemoryStore;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TripleStoreConnection {

	public static final TripleStoreConnection INSTANCE = new TripleStoreConnection();

	public static final String prefixCollection = "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
			+ System.lineSeparator() + "PREFIX geo: <http://www.opengis.net/ont/geosparql#>";

	public static Map<String, Model> modelmap;

	public static  Repository repo = new SailRepository(new MemoryStore());
	public TripleStoreConnection() {
		File dataDir = new File("C:\\temp\\myRepository\\");
		String filename = "example-data-artists.ttl";
		modelmap=new TreeMap<>();
		repo= new SailRepository(new MemoryStore());
		repo.initialize();
		// read the file 'example-data-artists.ttl' as an InputStream.
		//InputStream input = Example08ReadTurtle.class.getResourceAsStream("/" + filename);

		try {
			modelmap.put("testdata.ttl", Rio.parse(new File("testdata.ttl").toURL().openStream(), "", RDFFormat.TURTLE));
			modelmap.put("testdata2.ttl", Rio.parse(new File("testdata2.ttl").toURL().openStream(), "", RDFFormat.TURTLE));
			modelmap.put("rasterexample.ttl", Rio.parse(new File("rasterexample.ttl").toURL().openStream(), "", RDFFormat.TURTLE));
		} catch (RDFParseException | UnsupportedRDFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// modelmap.put("testdata3.ttl", ModelFactory.createOntologyModel());
		// modelmap.put("testdata4.ttl", ModelFactory.createOntologyModel());

	}

	public static String executeQuery(String query,String model) throws JSONException {
		query=prefixCollection+query;
		System.out.println(query);
		System.out.println(model);
		System.out.println(INSTANCE.modelmap.keySet());
		if(!INSTANCE.modelmap.containsKey(model)) {
			model=INSTANCE.modelmap.keySet().iterator().next();
		}
		RepositoryConnection con = repo.getConnection();
		con.add(modelmap.get(model));
			TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, query);
		
			TupleQueryResult qresult = tupleQuery.evaluate();
			System.out.println(qresult);
			try {
				BindingSet bindingSet = qresult.next();
				List<JSONArray> allfeatures=new LinkedList<JSONArray>();
				JSONObject result=new JSONObject();
				JSONArray geojsonresults=new JSONArray();
				JSONArray obj=new JSONArray();
				Boolean first=true;
				while(qresult.hasNext()) {
					JSONObject jsonobj=new JSONObject();
					JSONObject properties=new JSONObject();
					List<JSONObject> geoms=new LinkedList<JSONObject>();
					int geomvars=0;
					for(String name:bindingSet.getBindingNames()) {
						if(name.endsWith("_geom")) {
							if(first) {
								JSONObject geojsonresult=new JSONObject();
								geojsonresult.put("type", "FeatureCollection");
								geojsonresult.put("name", name);
								JSONArray features=new JSONArray();
								allfeatures.add(features);

								geojsonresults.put(geojsonresult);
								geojsonresults.getJSONObject(geojsonresults.length()-1).put("features",features);
							}
							geomvars++;
							AsGeoJSON geojson=new AsGeoJSON();
							try {
								/*geojson.operation(geom) 

								NodeValue val=geojson.exec(NodeValue.makeNode(bindingSet.getValue(name),bindingSet.get(name).getDatatype()));
								JSONObject geomobj=new JSONObject(val.asNode().getLiteralValue().toString());
								geoms.add(geomobj);*/

							}catch(Exception e) {
								e.printStackTrace();
							}
						}
						jsonobj.put(name, bindingSet.getValue(name));
						properties.put(name, bindingSet.getValue(name));
						obj.put(jsonobj);
					}
					first=false;
					int geomcounter=0;
					for(JSONObject geom:geoms) {
						JSONObject geojsonobj=new JSONObject();
						geojsonobj.put("type", "Feature");
						geojsonobj.put("properties", properties);
						geojsonobj.put("geometry", geom);
						allfeatures.get(geomcounter%geomvars).put(geojsonobj);  
						geomcounter++;
					}
				}
				result.put("geojson", geojsonresults);
				result.put("data", obj);
				//result.put("size", test.size());
				return result.toString();

			}
			finally {
				con.close();
			}

		}
		

		public static void main(String[] args) throws JSONException {
			String res = TripleStoreConnection.executeQuery(
					"SELECT ?geom ?wkt WHERE { ?geom geo:asWKT ?wkt . FILTER(!geo:ST_IsCollection(?wkt)) }",
					"testdata2.ttl");
			// System.out.println(res[0]);
			System.out.println(res);
			System.out.println(
					"=====================================================================================================");
			res = TripleStoreConnection.executeQuery(
					"SELECT ?geom ?wkt WHERE { ?geom geo:asWKT ?wkt . FILTER(geo:ST_Area(?wkt)>10) }", "testdata2.ttl");
			// System.out.println(res[0]);
			System.out.println(res);
			res = TripleStoreConnection.executeQuery(
					"SELECT ?wkt2 WHERE { ?geom geo:asWKT ?wkt . BIND(geo:ST_YMax(?wkt) AS ?wkt2). FILTER(geo:ST_Area(?wkt)>10) }",
					"testdata2.ttl");
			System.out.println(res);
			System.out.println(res);
		}

	}
