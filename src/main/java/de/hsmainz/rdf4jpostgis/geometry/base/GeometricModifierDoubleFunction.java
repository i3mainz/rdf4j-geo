package main.java.de.hsmainz.rdf4jpostgis.geometry.base;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.spatial4j.context.SpatialContext;

public abstract class GeometricModifierDoubleFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 2) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 2 arguments, got " + args.length);
		}

		SpatialContext geoContext = SpatialSupport.getSpatialContext();
		Geometry geom1 = FunctionArguments.getShape(this, args[0], geoContext);
		Geometry geom2 = FunctionArguments.getShape(this, args[0], geoContext);
		try {
			boolean result = relation(geom1, geom2);

			return valueFactory.createLiteral(result);
		} catch (RuntimeException e) {
			throw new ValueExprEvaluationException("error evaluating geospatial relation", e);
		}
	}

	protected abstract Geometry relation(Geometry geom, Double value);

}
