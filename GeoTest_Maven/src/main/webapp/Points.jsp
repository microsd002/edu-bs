<%--
  Created by IntelliJ IDEA.
  User: Blackstar
  Date: 06.04.14
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="converter.*" %>
<%@ page import="utils.*" %>
<%@ page import="java.sql.SQLException" %>
<html>
<head>
    <title>Point from database </title>
    <style>
        table{
            border:solid;
            border-collapse:collapse;
        }
        td{
            align-content:center;
            padding:4px;

        }
    </style>
</head>
<body>
<H2>Points From Database </H2>
<%
    try{
    PointsDAO dao = new PointsDAO();

    out.print("<table border=1><tr>");
    out.print("<th>ID</th>");
    out.print("<th>Name</th>");
    out.print("<th>Latitude</th>");
    out.print("<th>Longitude</th>");
    out.print("<th>Descr</th>");
    out.print("</tr><tr>");

    for(Point p : dao.getPoints()){
        out.print("<tr>");
        out.print("<td>");
        out.print(p.getId());
        out.print("</td>");
        out.print("<td>");
        out.print(p.getName());
        out.print("</td>");
        out.print("<td>");
        out.print(p.getLatitude());
        out.print("</td>");
        out.print("<td>");
        out.print(p.getLongitude());
        out.print("</td>");
        out.print("<td>");
        out.print(p.getDescription());
        out.print("</td>");
        out.print("</tr>");
    }
    out.print("</table>");
    } catch (SQLException ex){}

%>
<a href="index.jsp">Go Back</a>


</body>
</html>
