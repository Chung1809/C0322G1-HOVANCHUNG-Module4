<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/15/2022
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Hòm thư điện tủ</h2>

<c:forEach items="${list}" var="list" >
    <p>Laguages: ${list.language}</p>
    <p>PageSize: ${list.size}</p>
    <p>Spams filter: ${list.spamsFilter}</p>
    <p>Signature : ${list.signature}</p>



</c:forEach>

</body>
</body>
</html>
