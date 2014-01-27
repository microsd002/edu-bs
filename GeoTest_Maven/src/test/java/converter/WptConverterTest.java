package converter;

import org.junit.Assert;

import org.junit.Test;

import java.util.List;


public class WptConverterTest {

    List<Point> points;
    Point testPoint;

    public WptConverterTest() {
    }

    @Test
    public void testConverter() {

        points = new Converter().convertFromFile("src/main/resources/converter/sample.wpt");

        testPoint = new PointImpl(1L,49.045860,23.454690,"HREBET","descr");

        Assert.assertEquals("Error!", testPoint, points.get(0));


    }

}
