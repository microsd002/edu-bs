package utils;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import converter.Point;
import converter.PointImpl;

/**
 * Created by Blackstar on 15.02.14.
 */
public class PointsDAO {

    private String login = "blackstar";
    private String password = "therion";
    private String url = "jdbc:mysql://localhost/bs_edu";
    private String table = "Points";
    private Connection connection;


    public PointsDAO(String url, String table, String login, String password) throws SQLException {
        this.url = url;
        this.table = table;
        this.login = login;
        this.password = password;
        connect();
    }
    public PointsDAO() throws SQLException {
        connect();
    }

    private void connect() throws SQLException {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,login,password);
        }
        catch(ClassNotFoundException e){ System.err.println("MySQL driver not found!");}
    }


    public boolean addPoint(Point p) throws SQLException {
        String query =
                String.format(Locale.ENGLISH,"INSERT INTO %s(idPoints,namePoints,latPoints,longPoints,descrPoints)" +
                        " VALUES('%d','%s','%f','%f','%s')"
                       ,table,p.getId(),p.getName(),p.getLatitude(),p.getLongitude(),p.getDescription());


            Statement st = connection.createStatement();
           return  st.executeUpdate(query) == 1;

            }

    public boolean updatePoint(long id, Point newPoint) throws SQLException {

       String query = String.format(Locale.ENGLISH,"UPDATE %s SET namePoints = '%s', latPoints = '%f'," +
               "longPoints = '%f', descrPoints = '%s' WHERE idPoints = "+id,table,newPoint.getName(),newPoint.getLatitude(),
               newPoint.getLongitude(),newPoint.getDescription());

        Statement st = connection.createStatement();

        return st.executeUpdate(query) == 1;
    }

    public List<Point> getPoints() throws SQLException {

        Point point;

        List<Point> points = new ArrayList<>();
        String query = "SELECT * FROM "+table;
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){

           point = new PointImpl();

           point.setId(rs.getLong("idPoints"));
           point.setName(rs.getString("namePoints"));
           point.setLatitude(rs.getDouble("latPoints"));
           point.setLongitude(rs.getDouble("longPoints"));
           point.setDescription(rs.getString("descrPoints"));
           points.add(point);
           }

        return points;
    }

    public Point getPoint(long id) throws SQLException {
        Point point = null;
        String query = "SELECT * FROM "+table+" WHERE idPoints = "+id;
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        if(rs.next()){
         point = new PointImpl(rs.getLong(1),rs.getDouble(3),rs.getDouble(4),rs.getString(2),rs.getString(5));
        }

        return point;
    }

    public Point getPoint(Point p) throws SQLException {
        Point point = null;
        String query = "SELECT * FROM "+table+" WHERE idPoints = "+p.getId();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            point = new PointImpl(rs.getLong(1),rs.getDouble(3),rs.getDouble(4),rs.getString(2),rs.getString(5));
        }
        return point;
    }
    public boolean deletePoint(Point p) throws SQLException {

        String query = "DELETE FROM "+table+" WHERE idPoints = "+p.getId();
        Statement st = connection.createStatement();

       return st.executeUpdate(query) == 1;
    }

    public boolean deletePoint(long id) throws SQLException {

        String query = "DELETE FROM "+table+" WHERE idPoints = "+id;
        Statement st = connection.createStatement();

        return st.executeUpdate(query) == 1;
    }
/*
        public static void main(String... args){
            try {
               PointsDAO dao = new PointsDAO();
               Point point = new PointImpl(1L,90.045860,23.454690,"YPIE","descr");
                dao.addPoint(point);
               List<Point>list =  dao.getPoints();
           //     boolean i = dao.deletePoint(2l);
            //    System.out.println(i);

                System.out.println(dao.getPoint(1l));
                dao.updatePoint(1l,point);
                System.out.println(dao.getPoint(1l));

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

    }
*/
    }
