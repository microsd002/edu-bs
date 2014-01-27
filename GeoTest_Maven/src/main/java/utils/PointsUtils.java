package utils;

import converter.Point;

import java.util.ArrayList;
import java.util.List;



public class PointsUtils {

    static private final double PiOver180 = Math.PI / 180.0;

    private PointsUtils() {
    }

    public static List<Point> selectPointsInRectangle(List<Point> pointList, Point nePoint, Point swPoint) {
       List<Point> result = new ArrayList<>();
        Double top = nePoint.getLatitude();
        Double right = nePoint.getLongitude();
        Double bottom = swPoint.getLatitude();
        Double left = swPoint.getLongitude();
        Double tmp;
        if(right<left){
            tmp=left;
            left=right;
            right=tmp;
        }
        if(top<bottom){
            tmp=bottom;
            bottom=top;
            top=tmp;
        }


        for(Point point: pointList){
            boolean north = point.getLatitude() <= top;
            boolean east = point.getLongitude() <= right;
            boolean south = point.getLatitude() >= bottom;
            boolean west = point.getLongitude() >= left;
            if(north && east && south && west) {
                result.add(point);
            }
        }
        return result;
    }

    public static List<Point> selectPointsInRadius(List<Point> pointList, Point center, Double radiusInDegrees) {

        List<Point> result = new ArrayList<>();


        for(Point point: pointList){
            boolean isTrue = (Math.pow(point.getLatitude() - center.getLatitude(), 2)
            + Math.pow(point.getLongitude() - center.getLongitude(), 2)<= Math.pow(radiusInDegrees,2));

        if (isTrue){
            result.add(point);
        }
    }
        return result;
    }

    public static Long calculateDistanceInMeters(Point p1, Point p2) {
        int EARTH_RADIUS = 6372795;
        double lat1 = toRadians(p1.getLatitude());
        double lat2 = toRadians(p2.getLatitude());
        double long1 = toRadians(p1.getLongitude());
        double long2 = toRadians(p2.getLongitude());

        double cl1 = Math.cos(lat1);
        double cl2 = Math.cos(lat2);
        double sl1 = Math.sin(lat1);
        double sl2 = Math.sin(lat2);
        double delta = long2 - long1;
        double cdelta = Math.cos(delta);
        double sdelta = Math.sin(delta);

        double y = Math.sqrt(Math.pow(cl2 * sdelta, 2) + Math.pow(cl1 * sl2 - sl1 * cl2 * cdelta, 2));
        double x = sl1 * sl2 + cl1 * cl2 * cdelta;
        double ad = Math.atan2(y, x);
        Long dist = Math.round(ad * EARTH_RADIUS);
        return dist;
    }

    public static  Double toRadians(Double degrees){
        return degrees*PiOver180;
    }
    
}
