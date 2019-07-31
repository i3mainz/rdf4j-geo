/*
 * Copyright 2018 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import java.io.IOException;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.gml2.GMLReader;
import org.locationtech.jts.io.gml2.GMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 *
 */
public class GMLDatatype extends VectorLiteral {

    private static final Logger LOGGER = LoggerFactory.getLogger(GMLDatatype.class);

    /**
     * The default GML type URI.
     */
    public static final String URI = POSTGIS.GML;

    /**
     * A static instance of GMLDatatype.
     */
    public static final GMLDatatype INSTANCE = new GMLDatatype();

    /**
     * XML element tag "gml" is defined for the convenience of GML generation.
     */
    public static final String GML_PREFIX = "gml";

    /**
     * This method Un-parses the JTS Geometry to the GML literal
     *
     * @param geometry - the JTS Geometry to be un-parsed
     * @return GML - the returned GML Literal.
     * <br> Notice that the Spatial Reference System
     * "urn:ogc:def:crs:OGC::CRS84" is predefined in the returned GML literal.
     */
    @Override
    public String unparse(Geometry geometry) {
         return GMLWriter.write(geometry);
    }

    @Override
    public Geometry read(String geometryLiteral) {
        try {
            GMLReader gmlReader = GMLReader.extract(geometryLiteral);
            Geometry geometry = gmlReader.getGeometry();
            DimensionInfo dimensionInfo = gmlReader.getDimensionInfo();

            return geometry;
        } catch (JDOMException | IOException ex) {
            throw new DatatypeFormatException("Illegal GML literal:" + geometryLiteral + ". " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "GMLDatatype{" + URI + '}';
    }

}