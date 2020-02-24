package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import javax.media.jai.Interpolation;

import org.apache.lucene.util.automaton.Operations;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridGeometry;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;
import org.opengis.coverage.grid.GridEnvelope;
import org.opengis.metadata.spatial.Dimension;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

public class Resample extends RasterModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_resample.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage inputCoverage) {
		Interpolation interpolation = Interpolation.getInstance(Interpolation.INTERP_NEAREST);
        switch (resamplingType) {
        case BICUBIC:
            interpolation = Interpolation.getInstance(Interpolation.INTERP_BICUBIC);
            break;
        case BILINEAR:
            interpolation = Interpolation.getInstance(Interpolation.INTERP_BILINEAR);
            break;
        default:
            interpolation = Interpolation.getInstance(Interpolation.INTERP_NEAREST);
            break;
        }

        // recalculate gridenvelope
        CoordinateReferenceSystem crs = inputCoverage.getCoordinateReferenceSystem();
        ReferencedEnvelope extent = RasterHelper.getResolvedEnvelope(new ReferencedEnvelope(
                inputCoverage.getEnvelope()), cellSizeX, cellSizeY);

        Dimension dim = RasterHelper.getDimension(extent, cellSizeX, cellSizeY);
        GridEnvelope gridRange = new GridEnvelope(0, 0, dim.width, dim.height);
        GridGeometry gridGeometry = new GridGeometry(gridRange, extent);

        // execute resample
        try {
            return (GridCoverage) Operations.DEFAULT.resample(inputCoverage, crs, gridGeometry,
                    interpolation);
        } catch (CoverageProcessingException e) {
            throw new ProcessException(e);
        }
	}

}

