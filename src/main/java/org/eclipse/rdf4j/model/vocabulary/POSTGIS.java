package org.eclipse.rdf4j.model.vocabulary;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;


public class POSTGIS {

	public static final String NAMESPACE="http://www.opengis.net/ont/geosparql#";
	
	public static final	ValueFactory factory = SimpleValueFactory.getInstance();
	public static final	IRI ST_DWITHIN3D=factory.createIRI(NAMESPACE, "ST_3DDWithin");
	public static final	IRI ST_CLOSESTPOINT3D=factory.createIRI(NAMESPACE, "ST_ClosestPoint3D");
	public static final	IRI ST_LONGESTLINE3D=factory.createIRI(NAMESPACE, "ST_LongestLine3D");
	public static final	IRI ST_MAXDISTANCE3D=factory.createIRI(NAMESPACE, "ST_MaxDistance3D");
	public static final	IRI ST_SHORTESTLINE3D=factory.createIRI(NAMESPACE, "ST_ShortestLine3D");
	public static final	IRI ST_ACCUM=factory.createIRI(NAMESPACE, "ST_Accum");
	public static final	IRI ST_ADDBAND=factory.createIRI(NAMESPACE, "ST_AddBand");
	public static final	IRI ST_ADDPOINT=factory.createIRI(NAMESPACE, "ST_AddPoint");
	public static final	IRI ST_ADDZ=factory.createIRI(NAMESPACE, "ST_AddZ");
	public static final IRI st_angle = factory.createIRI(NAMESPACE,"ST_Angle");
	public static final	IRI ST_ASBINARY=factory.createIRI(NAMESPACE, "ST_AsBinary");
	public static final	IRI ST_ASENCODEDPOLYLINE=factory.createIRI(NAMESPACE, "ST_AsEncodedPolyline");
	public static final	IRI ST_ASHEXEWKB=factory.createIRI(NAMESPACE, "ST_AsHEXEWKB");
	public static final	IRI ST_ASKML=factory.createIRI(NAMESPACE, "ST_AsKML");
	public static final	IRI ST_ASGARS=factory.createIRI(NAMESPACE, "ST_AsGARS");
	public static final	IRI ST_ASGML=factory.createIRI(NAMESPACE, "ST_AsGML");
	public static final	IRI ST_ASGEOHASH=factory.createIRI(NAMESPACE, "ST_AsGeoHash");
	public static final	IRI ST_ASGEOURI=factory.createIRI(NAMESPACE, "ST_AsGeoURI");
	public static final	IRI ST_ASGEOBUF=factory.createIRI(NAMESPACE, "ST_AsGeoBuf");
	public static final	IRI ST_ASGEOJSON=factory.createIRI(NAMESPACE, "ST_AsGeoJSON");
	public static final	IRI ST_ASGEOJSONLD=factory.createIRI(NAMESPACE, "ST_AsGeoJSONLD");
	public static final	IRI ST_ASGEORSS=factory.createIRI(NAMESPACE, "ST_AsGeoRSS");
	public static final	IRI ST_ASGEOTIFF=factory.createIRI(NAMESPACE, "ST_AsGeoTIFF");
	public static final	IRI ST_ASCOVERAGEJSON=factory.createIRI(NAMESPACE, "ST_AsCoverageJSON");
	public static final	IRI ST_ASGMLCOV=factory.createIRI(NAMESPACE, "ST_AsGMLCOV");
	public static final	IRI ST_ASGPX=factory.createIRI(NAMESPACE, "ST_AsGPX");
    public static final IRI st_aspect=factory.createIRI(NAMESPACE, "ST_Aspect");
	public static final	IRI ST_ASNETCDF=factory.createIRI(NAMESPACE, "ST_AsNetCDF");
    public static final	IRI ST_ASPOLYSHAPE=factory.createIRI(NAMESPACE, "ST_AsPolyshape");
	public static final	IRI ST_ASTIFF=factory.createIRI(NAMESPACE, "ST_AsTIFF");
	public static final	IRI ST_ASTOPOJSON=factory.createIRI(NAMESPACE, "ST_AsTopoJSON");
	public static final	IRI ST_ASJPG=factory.createIRI(NAMESPACE, "ST_AsJPG");
	public static final	IRI ST_ASLATLONTEXT=factory.createIRI(NAMESPACE, "ST_AsLatLonText");
	public static final	IRI ST_ASPNG=factory.createIRI(NAMESPACE, "ST_AsPNG");
	public static final	IRI ST_ASMVT=factory.createIRI(NAMESPACE, "ST_AsMVT");
	public static final	IRI ST_ASMVTGEOM=factory.createIRI(NAMESPACE, "ST_AsMVTGeom");
	public static final	IRI ST_ASSVG=factory.createIRI(NAMESPACE, "ST_AsSVG");
	public static final	IRI ST_ASTEXT=factory.createIRI(NAMESPACE, "ST_AsText");
	public static final	IRI ST_ASTEXTRAW=factory.createIRI(NAMESPACE, "ST_AsTextRaw");
	public static final	IRI ST_ASTEXTROUND=factory.createIRI(NAMESPACE, "ST_AsTextRound");
	public static final	IRI ST_ASTWKB=factory.createIRI(NAMESPACE, "ST_AsTWKB");
	public static final	IRI ST_ASWKB=factory.createIRI(NAMESPACE, "ST_AsWKB");
	public static final IRI st_asRasterHexWKB = factory.createIRI(NAMESPACE,"ST_AsRasterHexWKB");
	public static final IRI st_asRasterWKB = factory.createIRI(NAMESPACE,"ST_AsRasterWKB");
	public static final IRI st_asRaster = factory.createIRI(NAMESPACE,"ST_AsRaster");
	public static final	IRI ST_ASWKT=factory.createIRI(NAMESPACE, "ST_AsWKT");
	public static final	IRI ST_ASX3D=factory.createIRI(NAMESPACE, "ST_AsX3D");
	public static final	IRI ST_AREA=factory.createIRI(NAMESPACE, "ST_Area");
	public static final IRI ST_AREA3D =factory.createIRI(NAMESPACE, "ST_Area3D");
	public static final	IRI ST_AREASIMILARITY=factory.createIRI(NAMESPACE, "ST_AreaSimilarity");
	public static final	IRI ST_AZIMUTH=factory.createIRI(NAMESPACE, "ST_Azimuth");
	public static final	IRI st_bboxabove =factory.createIRI(NAMESPACE,"ST_BBOXAbove");
    public static final IRI st_bboxbelow = factory.createIRI(NAMESPACE,"ST_BBOXBelow");
    public static final	IRI st_bboxcontains = factory.createIRI(NAMESPACE,"ST_BBOXContains");
    public static final	IRI st_bboxdistance = factory.createIRI(NAMESPACE,"ST_BBOXDistance");
    public static final	IRI st_bboxequals = factory.createIRI(NAMESPACE, "ST_BBOXEquals");
    public static final	IRI st_bboxfpintersects = factory.createIRI(NAMESPACE, "ST_BBOXFPIntersects");
    public static final	IRI st_bboxintersect = factory.createIRI(NAMESPACE, "ST_BBOXIntersects");
    public static final	IRI st_bboxiscontainedby =factory.createIRI(NAMESPACE, "ST_BBOXIsContainedBy");
    public static final	IRI st_bboxleftof = factory.createIRI(NAMESPACE, "ST_BBOXLeftOf");
    public static final	IRI st_bboxoverlapsabove = factory.createIRI(NAMESPACE, "ST_BBOXOverlapsAbove");
    public static final	IRI st_bboxoverlapsbelow =factory.createIRI(NAMESPACE, "ST_BBOXOverlapsBelow");
    public static final	IRI st_bboxoverlapsleft = factory.createIRI(NAMESPACE ,"ST_BBOXOverlapsLeft");
    public static final	IRI st_bboxoverlapsright = factory.createIRI(NAMESPACE, "ST_BBOXOverlapsRight");
    public static final	IRI st_bboxrightof = factory.createIRI(NAMESPACE, "ST_BBOXRightOf");
	public static final	IRI ST_BAND=factory.createIRI(NAMESPACE, "ST_Band");
	public static final IRI ST_BANDISNODATA=factory.createIRI(NAMESPACE, "ST_BandIsNoData");
	public static final	IRI ST_BANDMETADATA=factory.createIRI(NAMESPACE, "ST_BandMetaData");
	public static final	IRI ST_BANDNODATAVALUE=factory.createIRI(NAMESPACE, "ST_BandNoDataValue");
	public static final	IRI ST_BANDPIXELTYPE=factory.createIRI(NAMESPACE, "ST_BandPixelType");
	public static final	IRI ST_BEZIERSMOOTHING=factory.createIRI(NAMESPACE, "ST_BezierSmoothing");
	public static final	IRI ST_BOUNDARY=factory.createIRI(NAMESPACE, "ST_Boundary");
	public static final	IRI ST_BOUNDINGDIAGONAL=factory.createIRI(NAMESPACE, "ST_BoundingDiagonal");
	public static final	IRI ST_CENTROID=factory.createIRI(NAMESPACE, "ST_Centroid");
	public static final	IRI ST_CENTROIDDISTANCE=factory.createIRI(NAMESPACE, "ST_CentroidDistance");
	public static final	IRI ST_CHAIKINSMOOTHING=factory.createIRI(NAMESPACE, "ST_ChaikinSmoothing");
	public static final	IRI ST_CLIP=factory.createIRI(NAMESPACE, "ST_Clip");
	public static final	IRI ST_CLIPBYBOX2D=factory.createIRI(NAMESPACE, "ST_ClipByBox2D");
	public static final	IRI ST_CLOSESTPOINT=factory.createIRI(NAMESPACE, "ST_ClosestPoint");
	public static final	IRI ST_CLOSESTPOINTOFAPPROACH=factory.createIRI(NAMESPACE, "ST_ClosestPointOfApproach");
	public static final	IRI ST_CLUSTERINTERSECTING=factory.createIRI(NAMESPACE, "ST_ClusterIntersecting");
	public static final	IRI ST_CLUSTERKMEANS=factory.createIRI(NAMESPACE, "ST_ClusterKMeans");
	public static final	IRI ST_CLUSTERWITHIN=factory.createIRI(NAMESPACE, "ST_ClusterWithin");
	public static final	IRI ST_COLLECTIONHOMOGENIZE=factory.createIRI(NAMESPACE, "ST_CollectionHomogenize");
	public static final	IRI ST_COMPACTNESSRATIO=factory.createIRI(NAMESPACE, "ST_CompactnessRatio");
	public static final	IRI ST_CONCAVEHULL=factory.createIRI(NAMESPACE, "ST_ConcaveHull");
	public static final	IRI ST_CONTAINS=factory.createIRI(NAMESPACE, "ST_Contains");
	public static final	IRI ST_CONTAINSPROPERLY=factory.createIRI(NAMESPACE, "ST_ContainsProperly");
	public static final	IRI ST_CONVEXHULL=factory.createIRI(NAMESPACE, "ST_ConvexHull");
	public static final	IRI ST_COUNT=factory.createIRI(NAMESPACE, "ST_Count");
	public static final	IRI ST_CURVETOLINE=factory.createIRI(NAMESPACE, "ST_CurveToLine");
	public static final	IRI st_circularity=factory.createIRI(NAMESPACE, "ST_Circularity");
    public static final IRI st_curvature=factory.createIRI(NAMESPACE, "ST_Curvature");
    public static final IRI st_crop=factory.createIRI(NAMESPACE, "ST_Crop");
	public static final	IRI ST_DENSIFY=factory.createIRI(NAMESPACE, "ST_Densify");
	public static final	IRI ST_DELAUNAYTRIANGLES=factory.createIRI(NAMESPACE, "ST_DelaunayTriangles");
	public static final	IRI ST_DIMENSION=factory.createIRI(NAMESPACE, "ST_Dimension");
	public static final	IRI ST_DISTANCE=factory.createIRI(NAMESPACE, "ST_Distance");
	public static final	IRI ST_DISTANCE3D=factory.createIRI(NAMESPACE, "ST_Distance3D");
	public static final	IRI ST_DISTANCESPHERE=factory.createIRI(NAMESPACE, "ST_DistanceSphere");
	public static final	IRI st_dissolvepoints=factory.createIRI(NAMESPACE, "ST_DissolvePoints");
	public static final	IRI st_dissolvesegments=factory.createIRI(NAMESPACE, "ST_DissolveSegments");
	public static final	IRI ST_DWITHIN=factory.createIRI(NAMESPACE, "ST_DWithin");;
	public static final	IRI ST_ENDPOINT=factory.createIRI(NAMESPACE, "ST_EndPoint");
	public static final	IRI ST_EQUALS=factory.createIRI(NAMESPACE, "ST_Equals");
	public static final	IRI ST_EQUALSNORM=factory.createIRI(NAMESPACE, "ST_EqualsNorm");
	public static final	IRI ST_EQUALSTOPO=factory.createIRI(NAMESPACE, "ST_EqualsTopo");
	public static final	IRI ST_EQUALSRS=factory.createIRI(NAMESPACE, "ST_EqualSRS");
	public static final	IRI ST_EPSGTOSRID=factory.createIRI(NAMESPACE, "ST_EPSGToSRID");
	public static final	IRI ST_FILTERBYM=factory.createIRI(NAMESPACE, "ST_FilterByM");
	public static final	IRI ST_FILTERBYT=factory.createIRI(NAMESPACE, "ST_FilterByT");
    public static final IRI st_flip=factory.createIRI(NAMESPACE, "ST_Flip");
	public static final	IRI ST_FLIPCOORDINATES=factory.createIRI(NAMESPACE, "ST_FlipCoordinates");
	public static final	IRI ST_flowdirection=factory.createIRI(NAMESPACE, "ST_FlowDirection");
	public static final	IRI st_ensureClosedRings=factory.createIRI(NAMESPACE, "ST_EnsureClosedRings");
	public static final IRI st_equals=factory.createIRI(NAMESPACE, "ST_Equals");
        public static final IRI st_equalsNorm=factory.createIRI(NAMESPACE, "ST_EqualNorm");
        public static final IRI st_equalsTopo=factory.createIRI(NAMESPACE, "ST_EqualTopo");
		public static final IRI st_equalType=factory.createIRI(NAMESPACE, "ST_EqualType");
        public static final IRI st_equalSRS=factory.createIRI(NAMESPACE, "ST_EqualSRS");
        public static final IRI st_epsgToSRID=factory.createIRI(NAMESPACE, "ST_EPSGToSRID");
		public static final IRI st_expand=factory.createIRI(NAMESPACE, "ST_Expand");
        public static final IRI st_exteriorRing=factory.createIRI(NAMESPACE, "ST_ExteriorRing");
        public static final IRI st_filterByM=factory.createIRI(NAMESPACE, "ST_FilterByM");
        public static final IRI st_filterByT=factory.createIRI(NAMESPACE, "ST_FilterByT");
        public static final IRI st_flipCoordinates=factory.createIRI(NAMESPACE, "ST_FlipCoordinates");
        public static final IRI st_force2d=factory.createIRI(NAMESPACE, "ST_Force2D");
        public static final IRI st_force3d=factory.createIRI(NAMESPACE, "ST_Force3D");
        public static final IRI st_force3dm=factory.createIRI(NAMESPACE, "ST_Force3DM");
        public static final IRI st_force3dz=factory.createIRI(NAMESPACE, "ST_Force3D");
        public static final IRI st_force4d=factory.createIRI(NAMESPACE, "ST_Force4D");
        public static final IRI st_forceCollection=factory.createIRI(NAMESPACE, "ST_ForceCollection");
        public static final IRI st_forceCurve=factory.createIRI(NAMESPACE, "ST_ForceCurve");
        public static final IRI st_forceLHR=factory.createIRI(NAMESPACE, "ST_ForceLHR");
        public static final IRI st_forcePolygonCW=factory.createIRI(NAMESPACE, "ST_ForcePolygonCW");
        public static final IRI st_forcePolygonCCW=factory.createIRI(NAMESPACE, "ST_ForcePolygonCCW");
        public static final IRI st_forceSFS=factory.createIRI(NAMESPACE, "ST_ForceSFS");
        public static final IRI st_frechetDistance=factory.createIRI(NAMESPACE, "ST_FrechetDistance");
        public static final IRI st_generatePoints=factory.createIRI(NAMESPACE, "ST_GeneratePoints");
        public static final IRI st_geohash=factory.createIRI(NAMESPACE, "ST_AsGeoHash");
        public static final IRI st_geomCollFromText = factory.createIRI(NAMESPACE,"ST_GeomCollFromText");
        public static final IRI st_geomFromGeoJSON=factory.createIRI(NAMESPACE, "ST_GeomFromGeoJSON");
        public static final IRI st_geomFromGeoHash=factory.createIRI(NAMESPACE, "ST_GeomFromGeoHash");
        public static final IRI st_geomFromGML=factory.createIRI(NAMESPACE, "ST_GeomFromGML");
        public static final IRI st_geomFromKML=factory.createIRI(NAMESPACE, "ST_GeomFromKML");
        public static final IRI st_geomFromWKB=factory.createIRI(NAMESPACE, "ST_GeomFromWKB");
        public static final IRI st_geomFromText=factory.createIRI(NAMESPACE, "ST_GeomFromText");
        public static final IRI st_geometricMedian=factory.createIRI(NAMESPACE, "ST_GeometricMedian");
        public static final IRI st_geometryN=factory.createIRI(NAMESPACE, "ST_GeometryN");
        public static final IRI st_geometryType=factory.createIRI(NAMESPACE, "ST_GeometryType");
        public static final IRI st_gmlToSQL=factory.createIRI(NAMESPACE, "ST_GeomFromGML");
        public static final IRI st_hasNoBand=factory.createIRI(NAMESPACE, "ST_HasNoBand");
        public static final IRI ST_hasHorizontalCRS=factory.createIRI(NAMESPACE, "ST_HasHorizontalCRS");
        public static final IRI st_hasRepeatedPoints=factory.createIRI(NAMESPACE, "ST_HasRepeatedPoints");
        public static final IRI st_hausdorffDistance=factory.createIRI(NAMESPACE, "ST_HausdorffDistance");
        public static final IRI st_height=factory.createIRI(NAMESPACE, "ST_Height");
        public static final IRI st_hillshade=factory.createIRI(NAMESPACE, "ST_Hillshade");
		public static final IRI st_histogram = factory.createIRI(NAMESPACE,"ST_Histogram");
        public static final IRI st_interiorRingN=factory.createIRI(NAMESPACE, "ST_InteriorRingN");
        public static final IRI st_interpolatePoint=factory.createIRI(NAMESPACE, "ST_InterpolatePoint");
        public static final IRI st_intersectionMatrix=factory.createIRI(NAMESPACE, "ST_IntersectionMatrix");
        public static final IRI st_intersectionPercentage=factory.createIRI(NAMESPACE, "ST_IntersectionPercentage");
        public static final IRI st_is3D=factory.createIRI(NAMESPACE, "ST_Is3D");
        public static final IRI st_isCollection=factory.createIRI(NAMESPACE, "ST_IsCollection");
        public static final IRI st_isClosed=factory.createIRI(NAMESPACE, "ST_IsClosed");
        public static final IRI st_isConvex=factory.createIRI(NAMESPACE, "ST_IsConvex");
        public static final IRI st_isEmpty=factory.createIRI(NAMESPACE, "ST_IsEmpty");
		public static final IRI st_isEquilateralTriangle=factory.createIRI(NAMESPACE, "ST_IsEquilateralTriangle");
        public static final IRI st_isGrayscale=factory.createIRI(NAMESPACE, "ST_IsGrayscale");
        public static final IRI st_isIndexed=factory.createIRI(NAMESPACE, "ST_IsIndexed");
		public static final IRI st_isIsocelesTriangle=factory.createIRI(NAMESPACE, "ST_IsIsocelesTriangle");
        public static final IRI st_isLocationOnEdge=factory.createIRI(NAMESPACE, "ST_IsLocationOnEdge");
        public static final IRI st_isMeasured=factory.createIRI(NAMESPACE, "ST_IsMeasured");
        public static final IRI st_isMorePrecise=factory.createIRI(NAMESPACE, "ST_IsMorePrecise");
        public static final IRI st_isNodingValid=factory.createIRI(NAMESPACE, "ST_IsNodingValid");
		public static final IRI st_isPlanar = factory.createIRI(NAMESPACE, "ST_IsPlanar");
        public static final IRI st_isPointOnLine=factory.createIRI(NAMESPACE, "ST_IsPointOnLine");
        public static final IRI st_isPointInRing=factory.createIRI(NAMESPACE, "ST_IsPointInRing");
        public static final IRI st_isPolygonCW=factory.createIRI(NAMESPACE, "ST_IsPolygonCW");
        public static final IRI st_isPolygonCCW=factory.createIRI(NAMESPACE, "ST_IsPolygonCCW");
        public static final IRI st_isRectangle=factory.createIRI(NAMESPACE, "ST_IsRectangle");
        public static final IRI st_isRightTriangle=factory.createIRI(NAMESPACE, "ST_IsRightTriangle");
        public static final IRI st_isRing=factory.createIRI(NAMESPACE, "ST_IsRing");
        public static final IRI st_isSimple=factory.createIRI(NAMESPACE, "ST_IsSimpleFF");
		public static final IRI st_isSolid = factory.createIRI(NAMESPACE, "ST_IsSolid");
		public static final IRI st_isTiled=factory.createIRI(NAMESPACE, "ST_IsTiled");
	    public static final IRI st_isTranslucent=factory.createIRI(NAMESPACE, "ST_IsTranslucent");
		public static final IRI st_isTriangle= factory.createIRI(NAMESPACE, "ST_IsTriangle");
        public static final IRI st_isValid=factory.createIRI(NAMESPACE, "ST_IsValidFF");
        public static final IRI st_isValidTrajectory=factory.createIRI(NAMESPACE, "ST_IsValidTrajectory");
        public static final IRI st_isValidReason=factory.createIRI(NAMESPACE, "ST_IsValidReason");
        public static final IRI st_isValidDetail=factory.createIRI(NAMESPACE, "ST_IsValidDetail");
        public static final IRI st_Length=factory.createIRI(NAMESPACE, "ST_Length");
        public static final IRI st_Length2D=factory.createIRI(NAMESPACE, "ST_Length");
        public static final IRI st_Length3D=factory.createIRI(NAMESPACE, "ST_Length3D");
        public static final IRI st_LengthToPoint=factory.createIRI(NAMESPACE, "ST_LengthToPoint");
        public static final IRI st_lineCrossingDirection=factory.createIRI(NAMESPACE, "ST_LineCrossingDirection");
        public static final IRI st_lineFromEncodedPolyline=factory.createIRI(NAMESPACE, "ST_LineFromEncodedPolyline");
        public static final IRI st_lineFromMultiPoint=factory.createIRI(NAMESPACE, "ST_LineFromMultiPoint");
        public static final IRI st_lineFromWKB=factory.createIRI(NAMESPACE, "ST_LineFromWKB");
        public static final IRI st_lineFromWKT=factory.createIRI(NAMESPACE, "ST_LineFromText");
        public static final IRI st_lineFromText=factory.createIRI(NAMESPACE, "ST_LineFromText");
        public static final IRI st_lineInterpolatePoint=factory.createIRI(NAMESPACE, "ST_LineInterpolatePoint");
        public static final IRI st_lineInterpolatePoints=factory.createIRI(NAMESPACE, "ST_LineInterpolatePoints");
        public static final IRI st_lineLocatePoint=factory.createIRI(NAMESPACE, "ST_LineLocatePoint");
        public static final IRI st_lineLength3D=factory.createIRI(NAMESPACE, "ST_LineLength3D");
        public static final IRI st_lineMerge=factory.createIRI(NAMESPACE, "ST_LineMerge");
        public static final IRI st_lineSelfIntersectionPoint=factory.createIRI(NAMESPACE, "ST_LineSelfIntersectionPoint");
        public static final IRI st_lineSubstring=factory.createIRI(NAMESPACE, "ST_LineSubstring");
        public static final IRI st_lineToCurve=factory.createIRI(NAMESPACE, "ST_LineToCurve");
        public static final IRI st_locateAlong=factory.createIRI(NAMESPACE, "ST_LocateAlong");
        public static final IRI st_locateBetween=factory.createIRI(NAMESPACE, "ST_LocateBetween");
        public static final IRI st_locateBetweenElevations=factory.createIRI(NAMESPACE, "ST_LocateBetweenElevations");
        public static final IRI st_longestLine=factory.createIRI(NAMESPACE, "ST_LongestLine");
        public static final IRI st_m=factory.createIRI(NAMESPACE, "ST_M");
        public static final IRI st_maxDistance=factory.createIRI(NAMESPACE, "ST_MaxDistance");
        public static final IRI st_maxDistance3D=factory.createIRI(NAMESPACE, "ST_MaxDistance3D");
        public static final IRI st_makeBox2D=factory.createIRI(NAMESPACE, "ST_MakeBox2D");
        public static final IRI st_makeBox3D=factory.createIRI(NAMESPACE, "ST_MakeBox3D");
        public static final IRI st_makeCircle=factory.createIRI(NAMESPACE, "ST_MakeCircle");
        public static final IRI st_makeEllipse=factory.createIRI(NAMESPACE, "ST_MakeEllipse");
        public static final IRI st_makeEmptyCoverage=factory.createIRI(NAMESPACE, "ST_MakeEmptyCoverage");
        public static final IRI st_makeEmptyRaster=factory.createIRI(NAMESPACE, "ST_MakeEmptyRaster");
        public static final IRI st_makeEnvelope=factory.createIRI(NAMESPACE, "ST_MakeEnvelope");
        public static final IRI st_makeLine=factory.createIRI(NAMESPACE, "ST_MakeLine");
        public static final IRI st_makePoint=factory.createIRI(NAMESPACE, "ST_MakePoint");
        public static final IRI st_makePointM=factory.createIRI(NAMESPACE, "ST_MakePointM");
        public static final IRI st_makePolygon=factory.createIRI(NAMESPACE, "ST_MakePolygon");
        public static final IRI st_makeValid=factory.createIRI(NAMESPACE, "ST_MakeValid");
        public static final IRI st_memsize=factory.createIRI(NAMESPACE, "ST_MemSize");
        public static final IRI st_minimumBoundingCircle=factory.createIRI(NAMESPACE, "ST_MinimumBoundingCircle");
        public static final IRI st_minimumBoundingCircleCenter=factory.createIRI(NAMESPACE, "ST_MinimumBoundingCircleCenter");
        public static final IRI st_minimumBoundingRadius=factory.createIRI(NAMESPACE, "ST_MinimumBoundingRadius");
        public static final IRI st_minimumClearance=factory.createIRI(NAMESPACE, "ST_MinimumClearance");
        public static final IRI st_minimumClearanceLine=factory.createIRI(NAMESPACE, "ST_MinimumClearanceLine");
        public static final IRI st_minimumDiameter=factory.createIRI(NAMESPACE, "ST_MinimumDiameter");
        public static final IRI st_minimumDiameterLine=factory.createIRI(NAMESPACE, "ST_MinimumDiameterLine");
        public static final IRI st_minimumRectangle=factory.createIRI(NAMESPACE, "ST_MinimumRectangle");
        public static final IRI st_minConvexHull=factory.createIRI(NAMESPACE, "ST_MinConvexHull");
        public static final IRI st_minTileX=factory.createIRI(NAMESPACE, "ST_MinTileX");
        public static final IRI st_minTileY=factory.createIRI(NAMESPACE, "ST_MinTileY");
		public static final IRI st_rast_minX = factory.createIRI(NAMESPACE, "ST_MinX");
		public static final IRI st_rast_maxX = factory.createIRI(NAMESPACE, "ST_MaxX");
		public static final IRI st_rast_minY = factory.createIRI(NAMESPACE, "ST_MinY");
		public static final IRI st_rast_maxY = factory.createIRI(NAMESPACE, "ST_MaxY");
		public static final IRI st_mirror=factory.createIRI(NAMESPACE, "ST_Mirror");
        public static final IRI st_mLineFromText=factory.createIRI(NAMESPACE, "ST_MLineFromText");
        public static final IRI st_mMin=factory.createIRI(NAMESPACE, "ST_MMin");
        public static final IRI st_mMax=factory.createIRI(NAMESPACE, "ST_MMax");
        public static final IRI st_mPointFromText=factory.createIRI(NAMESPACE, "ST_MPointFromText");
        public static final IRI st_mPolyFromText=factory.createIRI(NAMESPACE, "ST_MPolyFromText");
        public static final IRI st_multi=factory.createIRI(NAMESPACE, "ST_Multi");
        public static final IRI st_multiplyz=factory.createIRI(NAMESPACE, "ST_MultiplyZ");
        public static final IRI st_nearestValue=factory.createIRI(NAMESPACE, "ST_NearestValue");
        public static final IRI st_numBands=factory.createIRI(NAMESPACE, "ST_NumBands");
		public static final IRI st_numDistinctGeometries=factory.createIRI(NAMESPACE, "ST_NumDistinctGeometries");
        public static final IRI st_numDistinctPoints=factory.createIRI(NAMESPACE, "ST_NumDistinctPoints");
        public static final IRI st_numGeometries=factory.createIRI(NAMESPACE, "ST_NumGeometries");
        public static final IRI st_numInteriorRings=factory.createIRI(NAMESPACE, "ST_NumInteriorRings");
        public static final IRI st_numPatches=factory.createIRI(NAMESPACE, "ST_NumPatches");
        public static final IRI st_numPoints=factory.createIRI(NAMESPACE, "ST_NumPoints");
        public static final IRI st_numXTiles=factory.createIRI(NAMESPACE, "ST_NumXTiles");
        public static final IRI st_numYTiles=factory.createIRI(NAMESPACE, "ST_NumYTiles");
        public static final IRI st_nDims=factory.createIRI(NAMESPACE, "ST_NDims");
        public static final IRI st_nPoints=factory.createIRI(NAMESPACE, "ST_NumPoints");
        public static final IRI st_nRings=factory.createIRI(NAMESPACE, "ST_NRings");
        public static final IRI st_node=factory.createIRI(NAMESPACE, "ST_Node");
        public static final IRI st_normalize=factory.createIRI(NAMESPACE, "ST_Normalize");
        public static final IRI st_octogonalEnvelope=factory.createIRI(NAMESPACE, "ST_OctogonalEnvelope");
        public static final IRI st_offsetCurve=factory.createIRI(NAMESPACE, "ST_OffsetCurve");
        public static final IRI st_orientation=factory.createIRI(NAMESPACE, "ST_Orientation");
        public static final IRI st_orderingEquals=factory.createIRI(NAMESPACE, "ST_OrderingEquals");
        public static final IRI st_osmlink=factory.createIRI(NAMESPACE, "ST_AsOSMLink");
        public static final IRI st_patchN=factory.createIRI(NAMESPACE, "ST_PatchN");
        public static final IRI st_partOfGeometryAfter=factory.createIRI(NAMESPACE, "ST_PartOfGeometryAfter");
        public static final IRI st_partOfGeometryBefore=factory.createIRI(NAMESPACE, "ST_PartOfGeometryBefore");
        public static final IRI st_perimeter=factory.createIRI(NAMESPACE, "ST_Perimeter");
        public static final IRI st_perimeter2D=factory.createIRI(NAMESPACE, "ST_Perimeter");
        public static final IRI st_perimeter3D=factory.createIRI(NAMESPACE, "ST_Perimeter3D");
        public static final IRI st_pixelAsCentroid=factory.createIRI(NAMESPACE, "ST_PixelAsCentroid");
        public static final IRI st_pixelAsCentroids=factory.createIRI(NAMESPACE, "ST_PixelAsCentroids");
        public static final IRI st_pixelAsPoint=factory.createIRI(NAMESPACE, "ST_PixelAsPoint");
        public static final IRI st_pixelAsPoints=factory.createIRI(NAMESPACE, "ST_PixelAsPoints");
        public static final IRI st_pixelAsPolygon=factory.createIRI(NAMESPACE, "ST_PixelAsPolygon");
        public static final IRI st_pixelAsPolygons=factory.createIRI(NAMESPACE, "ST_PixelAsPolygons");
        public static final IRI st_pixelHeight=factory.createIRI(NAMESPACE, "ST_PixelHeight");
        public static final IRI st_pixelOfValue=factory.createIRI(NAMESPACE, "ST_PixelOfValue");
        public static final IRI st_pixelWidth=factory.createIRI(NAMESPACE, "ST_PixelWidth");
        public static final IRI st_points=factory.createIRI(NAMESPACE, "ST_Points");
        public static final IRI st_pointN=factory.createIRI(NAMESPACE, "ST_PointN");
        public static final IRI st_pointFromGeoHash=factory.createIRI(NAMESPACE, "ST_PointFromGeoHash");
        public static final IRI st_pointFromWKB=factory.createIRI(NAMESPACE, "ST_PointFromWKB");
        public static final IRI st_pointFromText=factory.createIRI(NAMESPACE, "ST_PointFromText");
        public static final IRI st_pointInsideCircle=factory.createIRI(NAMESPACE, "ST_PointInsideCircle");
        public static final IRI st_pointOnSurface=factory.createIRI(NAMESPACE, "ST_PointOnSurface");
        public static final IRI st_polygon=factory.createIRI(NAMESPACE, "ST_Polygon");
        public static final IRI st_polygonize=factory.createIRI(NAMESPACE, "ST_Polygonize");
        public static final IRI st_polygonFromText=factory.createIRI(NAMESPACE, "ST_PolygonFromText");
        public static final IRI st_polygonFromWKB=factory.createIRI(NAMESPACE, "ST_PolygonFromWKB");
        public static final IRI st_precisionReducer=factory.createIRI(NAMESPACE, "ST_PrecisionReducer");
		public static final IRI st_rastFromCovJSON=factory.createIRI(NAMESPACE,"ST_RastFromCovJSON");
		public static final IRI st_rastFromGMLCOV=factory.createIRI(NAMESPACE,"ST_RastFromGMLCOV");
		public static final IRI st_rastFromNetCDF=factory.createIRI(NAMESPACE,"ST_RastFromNetCDF");
		public static final IRI st_rastFromWKB=factory.createIRI(NAMESPACE, "ST_RastFromWKB");
        public static final IRI st_rastFromHexWKB=factory.createIRI(NAMESPACE, "ST_RastFromHexWKB");
		public static final IRI ST_rast_algebra_abs = factory.createIRI(NAMESPACE, "ST_Abs");
		public static final IRI ST_rast_algebra_add =factory.createIRI(NAMESPACE, "ST_Add");
		public static final IRI ST_rast_algebra_addconst =factory.createIRI(NAMESPACE, "ST_AddConst");
		public static final IRI ST_rast_algebra_and =factory.createIRI(NAMESPACE, "ST_And");
		public static final IRI ST_rast_algebra_andconst =factory.createIRI(NAMESPACE, "ST_AndConst");
		public static final IRI ST_rast_algebra_equal =factory.createIRI(NAMESPACE, "ST_Equal");
		public static final IRI ST_rast_algebra_exp =factory.createIRI(NAMESPACE, "ST_Exp");
		public static final IRI ST_rast_algebra_idct =factory.createIRI(NAMESPACE, "ST_IDCT");
		public static final IRI ST_rast_algebra_idft =factory.createIRI(NAMESPACE, "ST_IDFT");
		public static final IRI ST_rast_algebra_subtract =factory.createIRI(NAMESPACE, "ST_Subtract");
		public static final IRI ST_rast_algebra_subtractconst =factory.createIRI(NAMESPACE, "ST_SubtractConst");
		public static final IRI ST_rast_algebra_div =factory.createIRI(NAMESPACE, "ST_Divide");
		public static final IRI ST_rast_algebra_divconst =factory.createIRI(NAMESPACE, "ST_DivideConst");
		public static final IRI ST_rast_algebra_invert =factory.createIRI(NAMESPACE, "ST_Invert");
		public static final IRI ST_rast_algebra_log =factory.createIRI(NAMESPACE, "ST_Log");
		public static final IRI ST_rast_algebra_or =factory.createIRI(NAMESPACE, "ST_Or");
		public static final IRI ST_rast_algebra_orconst =factory.createIRI(NAMESPACE, "ST_OrConst");
		public static final IRI ST_rast_algebra_max=factory.createIRI(NAMESPACE, "ST_Max");
		public static final IRI ST_rast_algebra_maxfilter=factory.createIRI(NAMESPACE, "ST_MaxFilter");
		public static final IRI ST_rast_algebra_mean =factory.createIRI(NAMESPACE, "ST_Mean");
		public static final IRI ST_rast_algebra_medianfilter =factory.createIRI(NAMESPACE, "ST_MedianFilter");
		public static final IRI ST_rast_algebra_min=factory.createIRI(NAMESPACE, "ST_Min");
		public static final IRI ST_rast_algebra_minfilter =factory.createIRI(NAMESPACE, "ST_MinFilter");
		public static final IRI ST_rast_algebra_mult =factory.createIRI(NAMESPACE, "ST_Mult");
		public static final IRI ST_rast_algebra_multconst =factory.createIRI(NAMESPACE, "ST_MultConst");
		public static final IRI ST_rast_algebra_not  =factory.createIRI(NAMESPACE, "ST_Not");
		public static final IRI ST_rast_algebra_xor =factory.createIRI(NAMESPACE, "ST_Xor");
		public static final IRI ST_rast_algebra_xorconst =factory.createIRI(NAMESPACE, "ST_XorConst");
        public static final IRI st_rast_isEmpty=factory.createIRI(NAMESPACE, "ST_IsEmpty");
        public static final IRI st_rast_Contains=factory.createIRI(NAMESPACE, "ST_Contains");
        public static final IRI st_rast_Covers=factory.createIRI(NAMESPACE, "ST_Covers");
        public static final IRI st_rast_CoveredBy=factory.createIRI(NAMESPACE, "ST_CoveredBy");
        public static final IRI st_rast_Crosses=factory.createIRI(NAMESPACE, "ST_Crosses");
        public static final IRI st_rast_Disjoint=factory.createIRI(NAMESPACE, "ST_Disjoint");
		public static final IRI st_rast_DWithin = factory.createIRI(NAMESPACE, "ST_DWithin");
		public static final IRI st_rast_DFullyWithin = factory.createIRI(NAMESPACE, "ST_DFullyWithin");
        public static final IRI st_rast_Intersects=factory.createIRI(NAMESPACE, "ST_Intersects");
        public static final IRI st_rast_Intersection=factory.createIRI(NAMESPACE, "ST_Intersection");
        public static final IRI st_rast_Overlaps=factory.createIRI(NAMESPACE, "ST_Overlaps");
		public static final IRI st_rast_SameAlignment = factory.createIRI(NAMESPACE, "ST_SameAlignment");
        public static final IRI st_rast_srid=factory.createIRI(NAMESPACE, "ST_SRID");
        public static final IRI st_rast_Touches=factory.createIRI(NAMESPACE, "ST_Touches");
        public static final IRI st_rast_Within=factory.createIRI(NAMESPACE, "ST_Within");
        public static final IRI st_rasterToWorldCoord=factory.createIRI(NAMESPACE, "ST_RasterToWorldCoord");
        public static final IRI st_rasterToWorldCoordX=factory.createIRI(NAMESPACE, "ST_RasterToWorldCoordX");
        public static final IRI st_rasterToWorldCoordY=factory.createIRI(NAMESPACE, "ST_RasterToWorldCoordY");
        public static final IRI st_reflect=factory.createIRI(NAMESPACE, "ST_Reflect");
        public static final IRI st_relate=factory.createIRI(NAMESPACE, "ST_Relate");
        public static final IRI st_relateMatch=factory.createIRI(NAMESPACE, "ST_RelateMatch");
        public static final IRI st_removePoint=factory.createIRI(NAMESPACE, "ST_RemovePoint");
        public static final IRI st_removePoints=factory.createIRI(NAMESPACE, "ST_RemovePoints");
        public static final IRI st_removeRepeatedPoints=factory.createIRI(NAMESPACE, "ST_RemoveRepeatedPoints");
        public static final IRI st_reskew=factory.createIRI(NAMESPACE, "ST_Reskew");
        public static final IRI st_resample=factory.createIRI(NAMESPACE, "ST_Resample");
        public static final IRI st_rescale=factory.createIRI(NAMESPACE, "ST_Rescale");
        public static final IRI st_resize=factory.createIRI(NAMESPACE, "ST_Resize");
        public static final IRI st_retile=factory.createIRI(NAMESPACE, "ST_Retile");
        public static final IRI st_reverse=factory.createIRI(NAMESPACE, "ST_Reverse");
        public static final IRI st_rotate=factory.createIRI(NAMESPACE, "ST_Rotate");
        public static final IRI st_rotateX=factory.createIRI(NAMESPACE, "ST_RotateX");
        public static final IRI st_rotateY=factory.createIRI(NAMESPACE, "ST_RotateY");
        public static final IRI st_rotateZ=factory.createIRI(NAMESPACE, "ST_RotateZ");
        public static final IRI st_rotation=factory.createIRI(NAMESPACE, "ST_Rotation");
        public static final IRI st_roughness=factory.createIRI(NAMESPACE, "ST_Roughness");
        public static final IRI st_scale=factory.createIRI(NAMESPACE, "ST_Scale");
        public static final IRI st_scaleX=factory.createIRI(NAMESPACE, "ST_ScaleX");
        public static final IRI st_scaleY=factory.createIRI(NAMESPACE, "ST_ScaleY");
        public static final IRI st_shearTransformation=factory.createIRI(NAMESPACE, "ST_ShearTransformation");
        public static final IRI st_segmentize=factory.createIRI(NAMESPACE, "ST_Segmentize");
		public static final IRI ST_selfIntersections=factory.createIRI(NAMESPACE, "ST_SelfIntersections");
		public static final IRI st_setBandNoDataValue = factory.createIRI(NAMESPACE, "ST_SetBandNoDataValue");
		public static final IRI st_setEndPoint=factory.createIRI(NAMESPACE, "ST_SetEndPoint");
		public static final IRI st_setScale=factory.createIRI(NAMESPACE, "ST_SetScale");
        public static final IRI st_setSkew=factory.createIRI(NAMESPACE, "ST_SetSkew");
		public static final IRI st_setStartPoint=factory.createIRI(NAMESPACE, "ST_SetStartPoint");
        public static final IRI st_setRotation=factory.createIRI(NAMESPACE, "ST_SetRotation");
        public static final IRI st_setGeoReference=factory.createIRI(NAMESPACE, "ST_SetGeoReference");
        public static final IRI st_setUpperLeft=factory.createIRI(NAMESPACE, "ST_SetUpperLeft");
        public static final IRI st_setPoint=factory.createIRI(NAMESPACE, "ST_SetPoint");
        public static final IRI st_setSRID=factory.createIRI(NAMESPACE, "ST_SetSRID");
        public static final IRI st_shift=factory.createIRI(NAMESPACE, "ST_Shift");
        public static final IRI st_simplify=factory.createIRI(NAMESPACE, "ST_Simplify");
        public static final IRI st_simplifyPreserveTopology=factory.createIRI(NAMESPACE, "ST_SimplifyPreserveTopology");
        public static final IRI st_simplifyVW=factory.createIRI(NAMESPACE, "ST_SimplifyVW");
        public static final IRI st_sharedPaths=factory.createIRI(NAMESPACE, "ST_SharedPaths");
        public static final IRI st_shiftLongitude=factory.createIRI(NAMESPACE, "ST_ShiftLongitude");
        public static final IRI st_shortestLine=factory.createIRI(NAMESPACE, "ST_ShortestLine");
        public static final IRI st_shortestLine3D=factory.createIRI(NAMESPACE, "ST_ShortestLine3D");
        public static final IRI st_slope=factory.createIRI(NAMESPACE, "ST_Slope");
        public static final IRI st_skewX=factory.createIRI(NAMESPACE, "ST_SkewX");
        public static final IRI st_skewY=factory.createIRI(NAMESPACE, "ST_SkewY");
        public static final IRI st_snap=factory.createIRI(NAMESPACE, "ST_Snap");
        public static final IRI st_split=factory.createIRI(NAMESPACE, "ST_Split");
        public static final IRI st_srid=factory.createIRI(NAMESPACE, "ST_GetSRIDFF");
        public static final IRI st_sridToEPSG=factory.createIRI(NAMESPACE, "ST_SRIDToEPSG");
        public static final IRI st_startPoint=factory.createIRI(NAMESPACE, "ST_StartPoint");
        public static final IRI st_straightSkeleton=factory.createIRI(NAMESPACE, "ST_StraightSkeleton");
        public static final IRI st_summary=factory.createIRI(NAMESPACE, "ST_Summary");
        public static final IRI st_swapOrdinates=factory.createIRI(NAMESPACE, "ST_SwapOrdinates");
        public static final IRI st_symDifference=factory.createIRI(NAMESPACE, "ST_SymDifference");
        public static final IRI st_tesselate=factory.createIRI(NAMESPACE, "ST_Tesselate");
        public static final IRI st_t=factory.createIRI(NAMESPACE, "ST_T");
		public static final IRI st_tileGridXOffset = factory.createIRI(NAMESPACE, "ST_TileGridXOffset");
		public static final IRI st_tileGridYOffset = factory.createIRI(NAMESPACE, "ST_TileGridYOffset");
		public static final IRI st_tileHeight = factory.createIRI(NAMESPACE, "ST_TileHeight");
		public static final IRI st_tileWidth = factory.createIRI(NAMESPACE, "ST_TileWidth");
        public static final IRI st_tMin=factory.createIRI(NAMESPACE, "ST_TMin");
        public static final IRI st_tMax=factory.createIRI(NAMESPACE, "ST_TMax");
        public static final IRI st_tpi=factory.createIRI(NAMESPACE, "ST_TPI");
        public static final IRI st_tri=factory.createIRI(NAMESPACE, "ST_TRI");
		public static final IRI st_trajectoryInterpolatePoint=factory.createIRI(NAMESPACE, "ST_TrajectoryInterpolatePoint");
        public static final IRI st_transscale=factory.createIRI(NAMESPACE, "ST_TransScale");
        public static final IRI st_translate=factory.createIRI(NAMESPACE, "ST_Translate");
        public static final IRI st_transform=factory.createIRI(NAMESPACE, "ST_Transform");
        public static final IRI st_union=factory.createIRI(NAMESPACE, "ST_Union");
        public static final IRI st_unaryUnion=factory.createIRI(NAMESPACE, "ST_UnaryUnion");
        public static final IRI st_upperLeftX=factory.createIRI(NAMESPACE, "ST_UpperLeftX");
        public static final IRI st_upperLeftY=factory.createIRI(NAMESPACE, "ST_UpperLeftY");
		public static final IRI st_value = factory.createIRI(NAMESPACE, "ST_Value");
        public static final IRI st_vectorize=factory.createIRI(NAMESPACE, "ST_Vectorize");
		public static final IRI st_volume=factory.createIRI(NAMESPACE, "ST_Volume");
        public static final IRI st_voronoiLines=factory.createIRI(NAMESPACE, "ST_VoronoiLines");
        public static final IRI st_voronoiPolygons=factory.createIRI(NAMESPACE, "ST_VoronoiPolygons");
        public static final IRI st_width=factory.createIRI(NAMESPACE, "ST_Width");
        public static final IRI st_wkbToSQL=factory.createIRI(NAMESPACE, "ST_GeomFromWKB");
        public static final IRI st_wktToSQL=factory.createIRI(NAMESPACE, "ST_GeomFromText");
        public static final IRI st_worldToRasterCoord=factory.createIRI(NAMESPACE, "ST_WorldToRasterCoord");
        public static final IRI st_worldToRasterCoordX=factory.createIRI(NAMESPACE, "ST_WorldToRasterCoordX");
        public static final IRI st_worldToRasterCoordY=factory.createIRI(NAMESPACE, "ST_WorldToRasterCoordY");
        public static final IRI st_x=factory.createIRI(NAMESPACE, "ST_X");
        public static final IRI st_xMin=factory.createIRI(NAMESPACE, "ST_XMin");
        public static final IRI st_xMax=factory.createIRI(NAMESPACE, "ST_XMax");
        public static final IRI st_y=factory.createIRI(NAMESPACE, "ST_Y");
        public static final IRI st_yMin=factory.createIRI(NAMESPACE, "ST_YMin");
        public static final IRI st_yMax=factory.createIRI(NAMESPACE, "ST_YMax");
        public static final IRI st_z=factory.createIRI(NAMESPACE, "ST_Z");
        public static final IRI st_zMin=factory.createIRI(NAMESPACE, "ST_ZMin");
        public static final IRI st_zMax=factory.createIRI(NAMESPACE, "ST_ZMax");
        public static final IRI st_zmFlag=factory.createIRI(NAMESPACE, "ST_Zmflag");
		
		public static final IRI Abs =factory.createIRI(NAMESPACE, "Abs");
		public static final IRI Cos=factory.createIRI(NAMESPACE, "Cos");
		public static final IRI CosH = factory.createIRI(NAMESPACE, "CosH");	
		public static final IRI ACos=factory.createIRI(NAMESPACE, "ACos");
		public static final IRI Exp =factory.createIRI(NAMESPACE, "Exp");
		public static final IRI Sin=factory.createIRI(NAMESPACE, "Sin");
		public static final IRI SinH = factory.createIRI(NAMESPACE, "SinH");
		public static final IRI Sqrt = factory.createIRI(NAMESPACE, "Sqrt");
		public static final IRI ASin=factory.createIRI(NAMESPACE, "ASin");
		public static final IRI Log =factory.createIRI(NAMESPACE, "Log");
		public static final IRI Log10 =factory.createIRI(NAMESPACE, "Log10");
		public static final IRI Pow =factory.createIRI(NAMESPACE, "Pow");
		public static final IRI Tan=factory.createIRI(NAMESPACE, "Tan");
		public static final IRI TanH=factory.createIRI(NAMESPACE, "TanH");
		public static final IRI ATan=factory.createIRI(NAMESPACE, "ATan");
		public static final IRI Ceil=factory.createIRI(NAMESPACE, "Ceil");
		public static final IRI Sign=factory.createIRI(NAMESPACE, "Sign");
		public static final IRI Floor=factory.createIRI(NAMESPACE, "Floor");
		public static final IRI PI =factory.createIRI(NAMESPACE, "PI");
		public static final IRI CentimeterToMeter =factory.createIRI(NAMESPACE, "CentimeterToMeter");
		public static final IRI MillimeterToMeter =factory.createIRI(NAMESPACE, "MillimeterToMeter");
		public static final IRI KilometerToMeter =factory.createIRI(NAMESPACE, "KilometerToMeter");
		public static final IRI DecimeterToMeter =factory.createIRI(NAMESPACE, "DecimeterToMeter");
		public static final IRI MeterToCentimeter=factory.createIRI(NAMESPACE, "MeterToCentimeter");
		public static final IRI MeterToKilometer=factory.createIRI(NAMESPACE, "MeterToKilometer");
		public static final IRI MeterToDecimeter=factory.createIRI(NAMESPACE, "MeterToDecimeter");
		public static final IRI MeterToMillimeter=factory.createIRI(NAMESPACE, "MeterToMillimeter");
		public static final IRI MeterToNauticalMile=factory.createIRI(NAMESPACE, "MeterToNauticalMile");
		public static final IRI MeterToChain=factory.createIRI(NAMESPACE, "MeterToChain");
		public static final IRI MeterToInch=factory.createIRI(NAMESPACE, "MeterToInch");
		public static final IRI MeterToFoot=factory.createIRI(NAMESPACE, "MeterToFoot");
		public static final IRI MeterToLink = factory.createIRI(NAMESPACE, "MeterToLink");
		public static final IRI MeterToYard=factory.createIRI(NAMESPACE, "MeterToYard");		
		public static final IRI MeterToMile=factory.createIRI(NAMESPACE, "MeterToMile");
		public static final IRI MeterToFathom=factory.createIRI(NAMESPACE, "MeterToFathom");
		public static final IRI MeterToUSMile = factory.createIRI(NAMESPACE, "MeterToUSMile");
		public static final IRI MeterToUSFoot = factory.createIRI(NAMESPACE, "MeterToUSFoot");
		public static final IRI MeterToUSYard= factory.createIRI(NAMESPACE, "MeterToUSYard");
		public static final IRI ChainToMeter =factory.createIRI(NAMESPACE, "ChainToMeter");
		public static final IRI InchToMeter =factory.createIRI(NAMESPACE, "InchToMeter");
		public static final IRI LinkToMeter =factory.createIRI(NAMESPACE, "LinkToMeter");
		public static final IRI FootToMeter =factory.createIRI(NAMESPACE, "FootToMeter");
		public static final IRI MileToMeter =factory.createIRI(NAMESPACE, "MileToMeter");
		public static final IRI NauticalMileToMeter =factory.createIRI(NAMESPACE, "NauticalMileToMeter");
		public static final IRI YardToMeter =factory.createIRI(NAMESPACE, "YardToMeter");
		public static final IRI FathomToMeter =factory.createIRI(NAMESPACE, "FathomToMeter");
		public static final IRI USMileToMeter =factory.createIRI(NAMESPACE, "USMileToMeter");
		public static final IRI USFootToMeter =factory.createIRI(NAMESPACE, "USFootToMeter");		
		public static final IRI USYardToMeter =factory.createIRI(NAMESPACE, "USYardToMeter");
		public static final IRI USInchToMeter =factory.createIRI(NAMESPACE, "USInchToMeter");
		public static final IRI EPSGToSRID =factory.createIRI(NAMESPACE, "EPSGToSRID");
		public static final IRI SRIDGetAxis1Name =factory.createIRI(NAMESPACE, "SRID_GetAxis1Name");
		public static final IRI SRIDGetAxis2Name =factory.createIRI(NAMESPACE, "SRID_GetAxis2Name");
		public static final IRI SRIDGetAxis1Orientation =factory.createIRI(NAMESPACE, "SRID_GetAxis1Orientation");
		public static final IRI SRIDGetAxis2Orientation =factory.createIRI(NAMESPACE, "SRID_GetAxis2Orientation");
		public static final IRI SRIDHasFlippedAxis =factory.createIRI(NAMESPACE, "SRID_HasFlippedAxis");
		public static final IRI SRIDToEPSG =factory.createIRI(NAMESPACE, "SRIDToEPSG");
		
        public static final String WKB = "WKB";
        public static final String GeoJSON = "GeoJSON";
        public static final String GeoJSONLD = "GeoJSONLD";
        public static final String GeoHash = "GeoHash";
        public static final String GeoBuf = "GeoBuf";
        public static final String GeoURI="GeoURI";
        public static final String GeoRSS="GeoRSS";
        public static final String GMLCOV="GMLCOV";
        public static final String KML = "KML";
        public static final String WKBRaster = "WKBRaster";
        public static final String GEOTIFF = "GeoTIFF";
        public static final String EncodedPolyline = "EncodedPolyline";
        public static final String Polyshape= "Polyshape";
        public static final String TWKB = "TWKB";
        public static final String HEXWKB = "HEXWKB";
        public static final String DXF="DXF";
        public static final String MVT = "MVT";
        public static final String X3D = "X3D";
        public static final String OSM= "OSM";
        public static final String HexWKBRaster = "HexWKBRaster";
        public static final String TopoJSON = "TopoJSON";
        public static final String TemporalRange="TemporalRange";
        public static final String CoverageJSON = "CoverageJSON";

		public static final String SVG="SVG";

		public static final String NETCDF="NetCDF";
		public static final String GML="GML";
		public static final String WKT="WKT";

		public static final IRI ST_ToDegrees=factory.createIRI(NAMESPACE, "ST_ToDegrees");
		
		public static final IRI ST_ToRadians=factory.createIRI(NAMESPACE, "ST_ToRadians");

	



	































































}
