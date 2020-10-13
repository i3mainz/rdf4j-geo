package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import java.io.IOException;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.referencing.CRS;
import org.apache.sis.referencing.cs.DefaultCartesianCS;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.geotoolkit.coverage.wkb.WKBRasterReader;
import org.geotoolkit.coverage.wkb.WKBRasterWriter;
//import org.geotoolkit.factory.Factories;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKBWriter;
import org.opengis.referencing.crs.CRSAuthorityFactory;
import org.opengis.util.FactoryException;

public class HexWKBRastDatatype extends RasterLiteral {

	public static final String URI = POSTGIS.NAMESPACE+POSTGIS.HexWKBRaster;
	
	public static final HexWKBRastDatatype INSTANCE =new HexWKBRastDatatype();
	
	public static final IRI LiteralIRI=SimpleValueFactory.getInstance().createIRI(POSTGIS.NAMESPACE+POSTGIS.HexWKBRaster);

	
	@Override
	public GridCoverage read(String geometryLiteral) {
		WKBRasterReader reader2=new WKBRasterReader();
		try {
			GridCoverage coverage;
			System.out.println("Read it: "+geometryLiteral);
			CRSAuthorityFactory crs=CRS.getAuthorityFactory("EPSG");
			coverage = reader2.readCoverage(WKBReader.hexToBytes(geometryLiteral),crs);
			System.out.println("Read wan le: "+coverage);
			return coverage;
		} catch (IOException | FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
    @Override
    public String toString() {
        return "HexWKBRasterDatatype{" + URI + '}';
    }


	@Override
	public String unparse(GridCoverage geom) {
        WKBRasterWriter writer=new WKBRasterWriter();
		String rasterWKB;
		try {
			rasterWKB = WKBWriter.toHex(writer.write((GridCoverage) geom)).toString();
			return rasterWKB.toString();
		} catch (IOException | FactoryException e) {
			throw new AssertionError(e.getMessage());
		}
	}
}