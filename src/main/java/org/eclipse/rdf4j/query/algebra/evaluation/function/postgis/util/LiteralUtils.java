package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util;

import java.awt.Rectangle;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.util.LinkedList;
import java.util.List;

import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

import org.apache.sis.coverage.Category;
import org.apache.sis.coverage.SampleDimension;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridExtent;
import org.apache.sis.coverage.grid.GridGeometry;
import org.apache.sis.geometry.DirectPosition2D;
import org.apache.sis.geometry.Envelope2D;
import org.apache.sis.internal.coverage.BufferedGridCoverage;
import org.apache.sis.referencing.CRS;
import org.apache.sis.util.iso.DefaultNameFactory;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.OctagonalEnvelope;
import org.locationtech.jts.geom.Polygon;
import org.opengis.geometry.DirectPosition;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.datum.PixelInCell;
import org.opengis.referencing.operation.CoordinateOperation;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import org.opengis.util.FactoryException;


public class LiteralUtils {

	public static Geometry toGeometry(final org.opengis.geometry.Envelope envelope) {
		
        GeometryFactory gf = new GeometryFactory();
        return gf.createPolygon(gf.createLinearRing(
                new Coordinate[]{
                    new Coordinate(envelope.getLowerCorner().getDirectPosition().getCoordinate()[0], envelope.getLowerCorner().getDirectPosition().getCoordinate()[1]),
                    new Coordinate(envelope.getUpperCorner().getDirectPosition().getCoordinate()[0], envelope.getLowerCorner().getDirectPosition().getCoordinate()[1]),
                    new Coordinate(envelope.getUpperCorner().getDirectPosition().getCoordinate()[0], envelope.getUpperCorner().getDirectPosition().getCoordinate()[1]),
                    new Coordinate(envelope.getLowerCorner().getDirectPosition().getCoordinate()[0], envelope.getLowerCorner().getDirectPosition().getCoordinate()[1]),
                    new Coordinate(envelope.getLowerCorner().getDirectPosition().getCoordinate()[0], envelope.getLowerCorner().getDirectPosition().getCoordinate()[1])
                }), null);
    }
	
	public static Geometry toGeometry(final Envelope envelope) {
        GeometryFactory gf = new GeometryFactory();
        return gf.createPolygon(gf.createLinearRing(
                new Coordinate[]{
                    new Coordinate(envelope.getMinX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMinY())
                }), null);
    }
	
	public static Geometry toGeometry(final Envelope2D envelope) {
        GeometryFactory gf = new GeometryFactory();
        return gf.createPolygon(gf.createLinearRing(
                new Coordinate[]{
                    new Coordinate(envelope.getMinX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMinY())
                }), null);
    }
	
	public static Geometry toGeometry(final OctagonalEnvelope envelope) {
        GeometryFactory gf = new GeometryFactory();
        return gf.createPolygon(gf.createLinearRing(
                new Coordinate[]{
                    new Coordinate(envelope.getMinX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMinY())
                }), null);
    }
	

	
	/*public static Geometry toGeometry(final BoundingBox envelope) {
        GeometryFactory gf = new GeometryFactory();
        return gf.createPolygon(gf.createLinearRing(
                new Coordinate[]{
                    new Coordinate(envelope.getMinX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMinY()),
                    new Coordinate(envelope.getMaxX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMaxY()),
                    new Coordinate(envelope.getMinX(), envelope.getMinY())
                }), null);
    }*/
	
	 public static Geometry toGeometry(final Rectangle envelope) {
	        GeometryFactory gf = new GeometryFactory();
	        return gf.createPolygon(gf.createLinearRing(
	                new Coordinate[]{
	                    new Coordinate(envelope.getMinX(), envelope.getMinY()),
	                    new Coordinate(envelope.getMaxX(), envelope.getMinY()),
	                    new Coordinate(envelope.getMaxX(), envelope.getMaxY()),
	                    new Coordinate(envelope.getMinX(), envelope.getMaxY()),
	                    new Coordinate(envelope.getMinX(), envelope.getMinY())
	                }), null);
	    }
	
	 
		public static Geometry createGeometry(Coordinate[] coordinates,String geomtype,Integer srid) {
			GeometryFactory fac=new GeometryFactory();
			Geometry geom;
			switch(geomtype) {
			case "Point":
				geom= fac.createPoint(coordinates[0]);
				geom.setSRID(srid);
				return geom;
			case "MultiPoint":
				geom=fac.createMultiPointFromCoords(coordinates);
				geom.setSRID(srid);
				return geom;
			case "LineString":
				geom= fac.createLineString(coordinates);
				geom.setSRID(srid);
				return geom;
			case "Polygon":
				geom= fac.createPolygon(coordinates);
				geom.setSRID(srid);
				return geom;
			case "MultiLineString":
				List<LineString> list=new LinkedList<LineString>();
				list.add(fac.createLineString(coordinates));
				geom= fac.createMultiLineString(list.toArray(new LineString[0]));
				geom.setSRID(srid);
				return geom;
			case "MultiPolygon":
				List<Polygon> plist=new LinkedList<Polygon>();
				plist.add(fac.createPolygon(coordinates));
				geom= fac.createMultiPolygon(plist.toArray(new Polygon[0]));
				geom.setSRID(srid);
				return geom;
			default:
				return null;
			}
		}

		public static Geometry createGeometryCollection(List<Geometry> geometries,String geomtype,Integer srid) {
			return createGeometryCollection(geometries.toArray(new Geometry[0]), geomtype, srid);		
		}
		
		public static Geometry createGeometryCollection(Geometry[] geometries,String geomtype,Integer srid) {
			GeometryFactory fac=new GeometryFactory();
			return fac.createGeometryCollection(geometries);			
		}
		
		public static Geometry createGeometry(List<Coordinate> coordarray,String geomtype,Integer srid) {
			return createGeometry(coordarray.toArray(new Coordinate[0]), geomtype,srid);
		}
		
		public static Geometry transform(Geometry sourcegeom,Geometry targetgeom) {
			if(sourcegeom.getSRID()!=targetgeom.getSRID()) {
			CoordinateReferenceSystem source;
			if(sourcegeom.getSRID()==targetgeom.getSRID()) {
				return sourcegeom;
			}
				try {
					source = CRS.forCode("EPSG:"+sourcegeom.getSRID());
					CoordinateReferenceSystem target = CRS.forCode("EPSG:"+targetgeom.getSRID());                   // WGS 84 / World Mercator
					CoordinateOperation operation = CRS.findOperation(source, target, null);
					if (CRS.getLinearAccuracy(operation) > 100) {
					    // If the accuracy is coarser than 100 metres (or any other threshold at application choice)
					    // maybe the operation is not suitable. Decide here what to do (throw an exception, etc).
					}
					MathTransform mt = operation.getMathTransform();
					List<Coordinate> coords=new LinkedList<Coordinate>();
					for(Coordinate coord:targetgeom.getCoordinates()) {
						DirectPosition resposition = new DirectPosition2D(20, 30);            // 20°N 30°E   (watch out axis order!)
						mt.transform(new DirectPosition2D(coord.getY(),coord.getY()), resposition);
						coords.add(new Coordinate(resposition.getCoordinate()[1],resposition.getCoordinate()[0]));
					}
					return LiteralUtils.createGeometry(coords, targetgeom.getGeometryType(), targetgeom.getSRID());

				} catch (FactoryException | MismatchedDimensionException | TransformException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}else {
				return sourcegeom;
			}
				
				
		}
		
		public static Double maxRasterValue(GridCoverage raster,Integer bandnum) {
			RenderedImage rendered=raster.render(null);
			Double maxVal=Double.MIN_VALUE;
	    	for(int i=0;i<rendered.getSampleModel().getWidth();i++) {
	    		for(int j=0;j<rendered.getSampleModel().getHeight();j++) {
	    			if(rendered.getData().getSample(i, j, bandnum)>maxVal) {
	    				maxVal=(double) rendered.getData().getSample(i, j, bandnum);
	    			}
	    		}
	    	}
	    	System.out.println("MaxRasterVal: "+maxVal);
	    	return maxVal;
		}

		public static Double arithmeticMeanRasterValue(GridCoverage raster, Integer bandnum) {
			RenderedImage rendered=raster.render(null);
			Double sum=0.,counter=0.;
	        for(int i=0;i<rendered.getSampleModel().getWidth();i++) {
	        	for(int j=0;j<rendered.getSampleModel().getHeight();j++) {
	        		sum+=(double) rendered.getData().getSample(i, j, bandnum);
	        		counter++;
	        	}
	        }
	    	System.out.println("MeanRasterVal: "+(sum/counter));
			return (sum/counter);
		}

		public static Double minRasterValue(GridCoverage raster, Integer bandnum) {
			RenderedImage rendered=raster.render(null);
			Double maxVal=Double.MAX_VALUE;
	        	for(int i=0;i<rendered.getSampleModel().getWidth();i++) {
	        		for(int j=0;j<rendered.getSampleModel().getHeight();j++) {
	        			if(rendered.getData().getSample(i, j, bandnum)<maxVal) {
	        				maxVal=(double) rendered.getData().getSample(i, j, bandnum);
	        			}
	        		}
	        	}
	        System.out.println("MinRasterVal: "+maxVal);
			return maxVal;
		}
		
		
		public static Boolean containsRasterValue(GridCoverage raster, Integer bandnum, Double value) {
			RenderedImage rendered=raster.render(null);
	        	for(int i=0;i<rendered.getSampleModel().getWidth();i++) {
	        		for(int j=0;j<rendered.getSampleModel().getHeight();j++) {
	        			if(rendered.getData().getSample(i, j, bandnum)==value) {
	        				return true;
	        			}
	        		}
	        	}
			return false;
		}
		
		public static Coordinate worldToRaster(GridCoverage raster, Double latitude, Double longitude) throws MismatchedDimensionException, TransformException {    	
	    	 GridGeometry gg2D = raster.getGridGeometry();
	         MathTransform gridToCRS = gg2D.getGridToCRS(PixelInCell.CELL_CENTER);
	         MathTransform crsToGrid = gridToCRS.inverse();
	         DirectPosition realPos=new DirectPosition2D(latitude, longitude);
	         DirectPosition gridPos = new DirectPosition2D();
	         DirectPosition res=crsToGrid.transform(realPos, gridPos);
	         Coordinate coord=new Coordinate(res.getCoordinate()[0],res.getCoordinate()[1]);
	         return coord;
		}
		
		public static GridCoverage cropRaster2(GridCoverage raster,Double width, Double height, Double x, Double y) throws MismatchedDimensionException, TransformException {
			 Coordinate coord=worldToRaster(raster, x, y);
			 Coordinate coord2=worldToRaster(raster, x+width, y+height);
			 Double xx=coord.getX();
			 Double yy=coord.getY();
			 xx=Double.valueOf(xx.intValue())-1;
			 yy=Double.valueOf(yy.intValue())-1;
			 Double widthh=coord2.getX()-x;
			 Double heightt=coord2.getY()-y;	
			 if(widthh==0)
				 widthh=1.;
			 if(heightt==0)
				 heightt=1.;
		     RenderedImage rendered = raster.render(null);
			 ParameterBlock pbSubtracted = new ParameterBlock(); 
		     pbSubtracted.addSource(rendered); 
		     pbSubtracted.add(xx.floatValue()); 
		     pbSubtracted.add(yy.floatValue()); 
		     pbSubtracted.add(widthh.floatValue());
		     pbSubtracted.add(heightt.floatValue());
	
		     System.out.println(rendered.getMinX()+" "+rendered.getMinY());
		     System.out.println(rendered.getWidth()+" "+rendered.getHeight());
		     System.out.println(xx+" "+yy+" "+widthh+" "+heightt);
		     RenderedOp subtractedImage = JAI.create("crop",pbSubtracted);
				final SampleDimension sd =raster.getSampleDimensions().get(0);
				List<SampleDimension>sds=new LinkedList<SampleDimension>();
				sds.add(sd);
		        GridExtent extent=new GridExtent(subtractedImage.getWidth(), subtractedImage.getHeight());
		        GridGeometry gridgeom=new GridGeometry(extent, PixelInCell.CELL_CENTER, raster.getGridGeometry().getGridToCRS(PixelInCell.CELL_CENTER), raster.getCoordinateReferenceSystem());
		        List<SampleDimension> dimensions=new LinkedList<SampleDimension>();
		        DefaultNameFactory fac=new DefaultNameFactory();
		        for(int i=0;i<subtractedImage.getNumBands();i++) {
		        	dimensions.add(new SampleDimension(fac.createGenericName(null,  "Dimension "+i),0.,new LinkedList<Category>()));
		        }
		        BufferedGridCoverage coverage=new BufferedGridCoverage(
		        		gridgeom, dimensions, subtractedImage.getData().getDataBuffer());
				return coverage;
		}
		
		
}
