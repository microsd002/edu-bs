<%--
  Created by IntelliJ IDEA.
  User: Blackstar
  Date: 05.04.14
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="converter.Converter" %>
<%@ page import="converter.Point" %>
<%@ page import="utils.PointsDAO" %>
<%@ page import="java.sql.SQLException" %>

<%
    PointsDAO dao;
    List<Point> points;






    File file ;
    int maxFileSize = 5000 * 1024;
    int maxMemSize = 5000 * 1024;
    ServletContext context = pageContext.getServletContext();
    String filePath = context.getInitParameter("file-upload");

    // Verify the content type
    String contentType = request.getContentType();
    if ((contentType.contains("multipart/form-data"))) {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("c:\\temp"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax( maxFileSize );
        try{
            dao = new PointsDAO();
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();



            out.println("<html>");
            out.println("<head>");
            out.println("<title>JSP File upload</title>");
            out.println("</head>");
            out.println("<body>");
            while ( i.hasNext () )
            {
                FileItem fi = (FileItem)i.next();
                if ( !fi.isFormField () )
                {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    // Write the file
                    if( fileName.lastIndexOf("\\") >= 0 ){
                        file = new File( filePath +
                                fileName.substring( fileName.lastIndexOf("\\"))) ;
                    }else{
                        file = new File( filePath +
                                fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                    }
                    fi.write( file ) ;


                    points = new Converter().convertFromFile(file.getPath());

                    for(Point p : points){
                        try{
                        dao.addPoint(p);
                            }
                        catch(SQLException exception){
                            out.println(p.getId()+" "+ p.getName() + " is already added in database!<br/>");
                        }
                    }
                    out.println("Uploaded Filename: " + filePath +
                            fileName + "<br>");
                    out.println("<a href=\"index.jsp\">Go Back</a>");

                }
            }


            out.println("</body>");
            out.println("</html>");
        }catch(Exception ex) {

            }



    }else{
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet upload</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>No file uploaded</p>");
        out.println("<a href=\"index.jsp\">Go Back</a>");
        out.println("</body>");
        out.println("</html>");
    }
%>