<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/15/2022
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Setting</h1>
<form:form action="/create" method="post" modelAttribute="mail">
    <div>
        Languages:
        <form:select path="language">
            <form:options items="${languageList}"></form:options>
        </form:select>
    </div>
    <div>
        Page Size : Show
        <form:select path="size">
            <form:options items="${pageSizeList}"></form:options>
        </form:select>
        email per page
    </div>
    <div>
        Spam filter :
        <form:checkbox path="spamsFilter"></form:checkbox>
        Enable spams filter
    </div>
    <div>
        Signature :
        <form:textarea path="signature"/>
    </div>
    <div>
        <button type="submit">Update</button>
        <button type="submit"><a href="/create">Cancel</a></button>
    </div>
</form:form>
<button><a href="/list">Show List Email</a></button>
</body>
</html>
