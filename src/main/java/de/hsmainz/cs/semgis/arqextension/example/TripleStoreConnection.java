package de.hsmainz.cs.semgis.arqextension.example;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter.AsGeoJSON;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralRegistry;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.VectorLiteral;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParseException;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.rio.UnsupportedRDFormatException;
import org.eclipse.rdf4j.sail.memory.MemoryStore;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Geometry;

public class TripleStoreConnection {

	public static final TripleStoreConnection INSTANCE = new TripleStoreConnection();

	public static final String prefixCollection = "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
			+ System.lineSeparator() + "PREFIX geo: <http://www.opengis.net/ont/geosparql#>";

	public static final Map<String, Model> modelmap=new TreeMap<>();

	public static Repository repo = new SailRepository(new MemoryStore());
	public TripleStoreConnection() {
		
		//modelmap=new TreeMap<>();
		repo= new SailRepository(new MemoryStore());
		repo.initialize();
		// read the file 'example-data-artists.ttl' as an InputStream.
		//InputStream input = Example08ReadTurtle.class.getResourceAsStream("/" + filename);

		try {
			//modelmap.put("testdata.ttl", Rio.parse(new File("testdata.ttl").toURL().openStream(), "", RDFFormat.TURTLE));
			modelmap.put("testdata2.ttl", Rio.parse(new File("testdata2.ttl").toURL().openStream(), "", RDFFormat.TURTLE));
			//modelmap.put("rasterexample.ttl", Rio.parse(new File("rasterexample.ttl").toURL().openStream(), "", RDFFormat.TURTLE));
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

		RepositoryConnection con = repo.getConnection();
		System.out.println(INSTANCE.modelmap);
		con.begin();
		con.add(INSTANCE.modelmap.get(model));
		con.commit();
		//System.out.println("Empty? "+con.isEmpty());
		/*for(Statement statement:modelmap.get(model)) {
			System.out.println(statement);
		}*/
		TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, query);
		//System.out.println(tupleQuery.toString());
		TupleQueryResult qresult = tupleQuery.evaluate();
		//System.out.println(qresult.getBindingNames());
		//System.out.println(qresult.hasNext());
		//System.out.println(qresult.);			
		List<JSONArray> allfeatures=new LinkedList<JSONArray>();
		JSONObject result=new JSONObject();
		JSONArray geojsonresults=new JSONArray();
		JSONArray obj=new JSONArray();
		Boolean first=true;
		while(qresult.hasNext()) {
			BindingSet bindingSet = qresult.next();
			JSONObject jsonobj=new JSONObject();
			JSONObject properties=new JSONObject();
			List<JSONObject> geoms=new LinkedList<JSONObject>();
			int geomvars=0;
			for(String name:bindingSet.getBindingNames()) {
				if(name.endsWith("_geom")) {
					//System.out.println(name+" end with geom");
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
					Value val=bindingSet.getValue(name);
					Literal lit=(Literal)val;
					//System.out.println(LiteralRegistry.INSTANCE.literals);
					//System.out.println(LiteralRegistry.getLiteral(lit.getDatatype().toString()));
					if(LiteralRegistry.getLiteral(lit.getDatatype().toString())!=null){
						LiteralType l=LiteralRegistry.getLiteral(lit.getDatatype().toString());
						Geometry geom=((VectorLiteral)l).read(bindingSet.getValue(name).stringValue());
						String geojsonstring=geojson.operation(geom);
						JSONObject geomobj=new JSONObject(geojsonstring);
						geoms.add(geomobj);
					}
					//System.out.println("Geoms: "+geoms.size());
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



	public static void main(String[] args) throws JSONException {
		String res = TripleStoreConnection.executeQuery(
				" SELECT ?geom ?wkt_geom WHERE { ?geom geo:asWKT ?wkt_geom .  } LIMIT 10",
				"testdata2.ttl");
		// System.out.println(res[0]);
		System.out.println(res);
		System.out.println(
				"=====================================================================================================");
		/*res = TripleStoreConnection.executeQuery(
					"SELECT ?geom ?wkt WHERE { ?geom geo:asWKT ?wkt . FILTER(geo:ST_Area(?wkt)>10) }", "testdata2.ttl");
			// System.out.println(res[0]);
			System.out.println(res);
			res = TripleStoreConnection.executeQuery(
					"SELECT ?wkt2 WHERE { ?geom geo:asWKT ?wkt . BIND(geo:ST_YMax(?wkt) AS ?wkt2). FILTER(geo:ST_Area(?wkt)>10) }",
					"testdata2.ttl");
			System.out.println(res);
			System.out.println(res);*/
	}

}
