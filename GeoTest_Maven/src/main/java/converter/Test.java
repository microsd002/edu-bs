package converter;


 import utils.PointsUtils;

import java.util.List;

/**
 * Created by Blackstar on 12.01.14.
 */
public class Test {
    private static final Point MOSCOW = new PointImpl(0L,55.45,37.38,"Moscow","descr");
    private static final Point BERLIN = new PointImpl(0L,52.30,13.22,"Berlin","descr");


    public static void main(String... args){

        List<Point> points =  getConverter().convertFromFile("src/main/resources/converter/sample.wpt");



        System.out.println("-----------------------------");

        for(Point point : points)

            System.out.println(point);

        System.out.println("-----------------------------");

        Point point1 = points.get(4);
        Point point2 = points.get(5);
        System.out.println(point1);
        System.out.println(point2);
        System.out.println("-----------------------------");
        for(Point point : PointsUtils.selectPointsInRectangle(points,point1,point2))

            System.out.println(point);
        System.out.println("-----------------------------");
        for(Point point : PointsUtils.selectPointsInRadius(points,point2,0.02))

            System.out.println(point);

        System.out.println(PointsUtils.calculateDistanceInMeters(point1,point2));
        System.out.println(PointsUtils.calculateDistanceInMeters(BERLIN,MOSCOW));
    }






private static PointConverter getConverter(){
    return new Converter();
}

}