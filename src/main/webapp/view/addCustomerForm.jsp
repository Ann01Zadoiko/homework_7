<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
         <form action="/customers/add" method="post">
            <label for="name">Customer name:</label><br>
            <input type="text" id="customerName" name="customerName"><br>
            <label for="name">Country:</label><br>
            <input type="text" id="country" name="country"><br>
            <button type="submit">Save</button>
        </form>
    </body>
</html>