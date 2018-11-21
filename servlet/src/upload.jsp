<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UPLOAD</title>
</head>
<body>

<form method="post" action="/UpLoadServlet" enctype="multipart/form-data">
    <input type="file" name="uploadfile"/>
    <br/>
    <input type="submit" value="上传">


</form>
</body>
</html>