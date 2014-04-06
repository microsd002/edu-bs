<%--
  Created by IntelliJ IDEA.
  User: Blackstar
  Date: 05.04.14
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>File Uploading Form</title>
</head>
<body>
<h3>File Upload:</h3>
Select a file to upload: <br />
<form action="UploadServlet.jsp" method="post"
      enctype="multipart/form-data">
    <input type="file" name="file" size="50" />
    <br />
    <input type="submit" value="Upload File" />
</form>
<form action="Points.jsp">
    <input type="submit" value="ShowPoints" />
    </form>


</body>
</html>


