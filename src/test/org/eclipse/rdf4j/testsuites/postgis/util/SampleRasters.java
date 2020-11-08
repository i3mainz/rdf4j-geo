package org.eclipse.rdf4j.testsuites.postgis.util;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.algebra.Log;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute.Summary;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;

import com.sun.jersey.core.util.Base64;


public class SampleRasters {

	public static final String rasterLiteral1="";
	
	public static final String rasterBand="";
	
	public static String minwkbString="01"               /* little endian (uint8 ndr) */
			 +"0000"             /* version (uint16 0) */
			 +"0100"             /* nBands (uint16 1) */
			 +"000000000000F03F" /* scaleX (float64 1) */
			 +"0000000000000040" /* scaleY (float64 2) */
			 +"0000000000000840" /* ipX (float64 3) */
			 +"0000000000001040" /* ipY (float64 4) */
			 +"0000000000001440" /* skewX (float64 5) */
			 +"0000000000001840" /* skewY (float64 6) */
			 +"0A000000"         /* SRID (int32 10) */
			 +"0100"             /* width (uint16 1) */
			 +"0100"             /* height (uint16 1) */
			 +"40"               /* First band type (1BB, in memory, hasnodata) */
			 +"00"               /* nodata value (0) */
			 +"01";               /* pix(0,0) == 1 */
	
	public static String wkbString1="00000000013FF00000000000003FF00000000000000000000000000000000000000000000000000000000000000000000000000000000010E600020002040000010100";
	
	public static String wkbString2="0000000001407F4000000000003FF00000000000000000000000000000000000000000000000000000000000000000000000000000000010E600020002040022283800";

	public static String wkbString3="00000000013FF000000000000040000000000000004008000000000000401000000000000040140000000000004018000000000000000010E6"         /* SRID (int32 10) */
	 +"0003"             /* width (uint16 3) */
	 +"0002"             /* height (uint16 2) */
	 +"05"               /* First band type (16BSI, in memory) */
	 +"FFFF"             /* nodata value (-1) */
	 +"FFFF"             /* pix(0,0) == -1 */
	 +"0000"             /* pix(1,0) ==  0 */
	 +"FFF0"             /* pix(2,0) == -16 */
	 +"007F"             /* pix(0,1) == 127 */
	 +"000A"             /* pix(1,1) == 10 */
	 +"0002";
	
	public static String wkbString4="01"                  /* little endian (uint8 ndr) */
			 +"0000"              /* version (uint16 0) */
			 +"0300"              /* nBands (uint16 3) */
			 +"9A9999999999A93F"  /* scaleX (float64 0.050000) */
			 +"9A9999999999A9BF"  /* scaleY (float64 -0.050000) */
			 +"000000E02B274A41"  /* ipX (float64 3427927.750000) */
			 +"0000000077195641"  /* ipY (float64 5793244.000000) */
			 +"0000000000000000"  /* skewX (float64 0.000000) */
			 +"0000000000000000"  /* skewY (float64 0.000000) */
			 +"E6100000"          /* srid (int32 -1) */
			 +"0500"              /* width (uint16 5) */
			 +"0500"              /* height (uint16 5) */
			 +"44"                /* 1st band pixel type (8BUI, in memory, hasnodata) */
			 +"00"                /* 1st band nodata 0 */
			 +"FDFEFDFEFEFDFEFEFDF9FAFEFEFCF9FBFDFEFEFDFCFAFEFEFE" /* 1st band pixels */
			 +"44"                /* 2nd band pixel type (8BUI, in memory, hasnodata) */
			 +"00"                /* 2nd band nodata 0 */
			 +"4E627AADD16076B4F9FE6370A9F5FE59637AB0E54F58617087" /* 2nd band pixels */
			 +"44"                /* 3rd band pixel type (8BUI, in memory, hasnodata) */
			 +"00"                /* 3rd band nodata 0 */
			 +"46566487A1506CA2E3FA5A6CAFFBFE4D566DA4CB3E454C5665"; /* 3rd band pixels */
	
	public static String wkbString5="01"               /* little endian (uint8 ndr) */
			 +"0000"             /* version (uint16 0) */
			 +"0100"             /* nBands (uint16 1) */
			 +"0000000000805640" /* scaleX (float64 90.0) */
			 +"00000000008056C0" /* scaleY (float64 -90.0) */
			 +"000000001C992D41" /* ipX (float64 969870.0) */
			 +"00000000E49E2341" /* ipY (float64 642930.0) */
			 +"0000000000000000" /* skewX (float64 0) */
			 +"0000000000000000" /* skewY (float64 0) */
			 +"FFFFFFFF"         /* SRID (int32 -1) */
			 +"0300"             /* width (uint16 3) */
			 +"0100"             /* height (uint16 1) */
			 +"45"               /* First band type (16BSI, in memory, hasnodata) */
			 +"0100"             /* nodata value (1) */
			 +"0100"             /* pix(0,0) == 1 */
			 +"B401"             /* pix(1,0) == 436 */
			 +"AF01";             /* pix(2,0) == 431 */
	
	public static String hexwkbString1="010000000000000000000000400000000000000840000000000000E03F000000000000E03F000000000000000000000000000000000F1000000A001400";
	
	public static final String covJSONString1="";
	
	public static String rasterWKB;
		
	public static SampleRasters rasters;		
			
	protected SampleRasters()  {
		String inputFile = "wkb.bin";
		InputStream is;
		try {
			is = new FileInputStream(inputFile);
			rasterWKB=new String(Base64.encode(IOUtils.toByteArray(is)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SampleRasters getInstance()  {
		if(rasters==null) {
			rasters=new SampleRasters();
		}
		return rasters;
	}
	
	public static String displayRasterSummary(String rast) {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(rast, org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.HexWKBRastDatatype.LiteralIRI);
        Summary instance=new Summary();
        Value result= instance.evaluate(valfac,cov1);
        return result.stringValue();
	}
	
	public static String displayRasterSummary(Value cov1) {		
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Summary instance=new Summary();
        Value result= instance.evaluate(valfac,cov1);
        return result.stringValue();
	}
	
}
