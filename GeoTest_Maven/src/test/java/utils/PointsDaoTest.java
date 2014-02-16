package utils;

import converter.Converter;

import converter.Point;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Blackstar on 16.02.14.
 */
public class PointsDaoTest {
    PointsDAO dao;
    List<Point> points;

    public PointsDaoTest(){

        points = new Converter().convertFromFile("src/main/resources/converter/sample.wpt");
        try {
             dao = new PointsDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPoints(){

        try {
            Assert.assertNotNull(dao.getPoints());
            Assert.assertTrue(dao.getPoints().size() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGetPoint(){
        try {
            Assert.assertNotNull(dao.getPoint(1L));
            Assert.assertEquals(dao.getPoint(1L),points.get(0));
            Assert.assertNull(dao.getPoint(100L));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testUpdatePoint(){

        try {
            Point p = dao.getPoint(3L);
            Assert.assertTrue(dao.updatePoint(3L, points.get(3)));
            Assert.assertEquals(dao.getPoint(3L).getName(),points.get(3).getName());
            Assert.assertEquals(dao.getPoint(3L).getLongitude(),points.get(3).getLongitude());
            dao.updatePoint(3L, p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddPoint(){
        Point point = points.get(10);
        try {
            Assert.assertTrue(dao.addPoint(point));
            Assert.assertEquals(dao.getPoint(point),point);
            dao.deletePoint(point);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testDeletePoint(){

        try {
            Point point = dao.getPoint(3L);
            Assert.assertTrue(dao.deletePoint(point));
            Assert.assertNull(dao.getPoint(point));
            dao.addPoint(point);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
