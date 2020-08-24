package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricExportToRasterFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.util.AffineTransformation;
import org.opengis.feature.Feature;

import gov.noaa.ncdc.geotools.VectorToRaster;

public class ToRaster extends GeometricExportToRasterFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_toRaster.stringValue();
	}


	@Override
	public GridCoverage operation(Geometry geom) {
		VectorToRaster vectorast=new VectorToRaster();
		//vectorast.addFeature(new Feature(geom));
		// TODO Auto-generated method stub
		return null;
	}

}
