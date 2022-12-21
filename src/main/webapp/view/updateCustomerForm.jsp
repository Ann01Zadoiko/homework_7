<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/customers/update" method="post">
            <label for="name">Customer ID:</label><br>
            <input type="text" id="customerId" name="customerId"><br>
            <label for="name">Customer name:</label><br>
            <input type="text" id="customerName" name="customerName"><br>
            <label for="name">Country:</label><br>
            <input type="text" id="country" name="country"><br>
            <button type="submit">Update</button>
        </form>
    </body>
</html>