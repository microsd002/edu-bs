package utils;

import converter.Converter;
import converter.Point;
import converter.PointImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * User: igl
 * Date: 07.02.2011
 */
public class PointUtilsTest {

    private static final Point MOSCOW = new PointImpl(0L,55.45,37.38,"Moscow","descr");
    private static final Point BERLIN = new PointImpl(0L,52.30,13.22,"Berlin","descr");
    private static final Point RIO = new PointImpl(0L,-22.53,-43.15,"Rio","descr");

    List<Point> points = new Converter().convertFromFile("src/main/resources/converter/sample.wpt");

    public PointUtilsTest() {
    }

    @Test
    public void testSelectPointsInRectangle() {
        List<Point> result =  PointsUtils.selectPointsInRectangle(points,points.get(1),points.get(5));
        Assert.assertEquals(3L,(long)result.size());

        result =  PointsUtils.selectPointsInRectangle(points,points.get(4),points.get(5));
        Assert.assertEquals(7L,(long)result.size());

    }

    @Test
    public void testSelectPointsInRadius() {
        List<Point> result =  PointsUtils.selectPointsInRadius(points,points.get(4),0.03);
        Assert.assertEquals(4L,(long)result.size());

        result =  PointsUtils.selectPointsInRadius(points,points.get(5),0.02);
        Assert.assertEquals(5L,(long)result.size());



    }

    @Test
    public void testCalculateDistanceInMeters() {
        Long distance = PointsUtils.calculateDistanceInMeters(MOSCOW, BERLIN);
        Assert.assertEquals("Error", 1613000d, (double) distance, 800d);

        distance = PointsUtils.calculateDistanceInMeters(MOSCOW, RIO);
        Assert.assertEquals("Error", 11483000d, (double) distance,5000d);
    }

}
