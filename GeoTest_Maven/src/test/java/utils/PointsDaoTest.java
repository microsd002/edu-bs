package utils;

import converter.Converter;

import converter.Point;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Blackstar on 16.02.14.
 */
public class PointsDaoTest {
    PointsDAO dao;
    List<Point> points;

    public PointsDaoTest() throws SQLException {

        points = new Converter().convertFromFile("src/main/resources/converter/sample.wpt");

             dao = new PointsDAO();


    }

    @Before
    public void Init() throws SQLException {
        dao.addPoint(points.get(0));
        dao.addPoint(points.get(1));

    }

    @After
    public void Finish() throws SQLException {
        dao.deletePoint(points.get(0));
        dao.deletePoint(points.get(1));

    }

    @Test
    public void testGetPoints() throws SQLException {


            Assert.assertNotNull(dao.getPoints());
            Assert.assertTrue(dao.getPoints().size() > 0);


    }
    @Test
    public void testGetPoint()throws SQLException {

            Assert.assertNotNull(dao.getPoint(1L));
            Assert.assertEquals(dao.getPoint(1L),points.get(0));
            Assert.assertNull(dao.getPoint(100L));

    }

    @Test
    public void testUpdatePoint() throws SQLException {


            Assert.assertTrue(dao.updatePoint(3L, points.get(3)));
            Assert.assertEquals(dao.getPoint(3L).getName(),points.get(3).getName());
            Assert.assertEquals(dao.getPoint(3L).getLongitude(),points.get(3).getLongitude());

    }

    @Test
    public void testAddPoint() throws SQLException {
        Point point = points.get(10);

            Assert.assertTrue(dao.addPoint(point));
            Assert.assertEquals(dao.getPoint(point),point);
            dao.deletePoint(point);

    }
    @Test
    public void testDeletePoint() throws SQLException {


            Point point = dao.getPoint(3L);
            Assert.assertTrue(dao.deletePoint(point));
            Assert.assertNull(dao.getPoint(point));

    }
}
