<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/18/2022
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 STYLE="text-align: center">TỜ KHAI Y TẾ</h3>
<form:form  modelAttribute="${medical}" method="post">
<div>
    <div>
        <p>Họ tên(ghi chữ IN HOA)</p>
        <form:input path="name" cssStyle="width: 100%"/>
    </div>
    <div>
        <p>Năm sinh</p>
        <form:select path="birthDay" cssStyle="width: 100%;">
            <form:options items="${bithDay}"></form:options>
        </form:select>
    </div>
    <div>
        <p>Thông tin đi lại</p>
        <form:select path="vehicle" cssStyle="width: 100%;">
            <form:options items="${vehicle}"></form:options>
        </form:select>
    </div>
    <div>
        <p>Thông tin đi lại</p>
        <form:select path="vehicle" cssStyle="width: 100%;">
            <form:options items="${vehicle}"></form:options>
        </form:select>
    </div>
</div>
</form:form>
</body>
</html>
