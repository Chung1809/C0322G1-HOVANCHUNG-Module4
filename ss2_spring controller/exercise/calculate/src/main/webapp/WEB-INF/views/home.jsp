<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/14/2022
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Calculate</h2>
<form action="/save" method="post">
   <div>
       <input type="text" name="number1" placeholder="0">
       <input type="text" name="number2" placeholder="0">
   </div>
    <div>
        <button type="submit" name="operate"value="Addition(+)">+</button>
        <button type="submit" name="operate" value="Subtraction(-)">-</button>
        <button type="submit" name="operate" value="Division(/)">/</button>
        <button type="submit" name="operate" value="Multiplication(*)">*</button>
    </div>
</form>
<hr>
<h3>Kết quả : ${result}</h3>
</body>
</html>
