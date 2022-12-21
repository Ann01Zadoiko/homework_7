<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies/add" method="post">
            <label for="name">Company name:</label><br>
            <input type="text" id="companyName" name="companyName"><br>
            <label for="name">Country:</label><br>
            <input type="text" id="country" name="country"><br>
            <button type="submit">Save</button>
        </form>
    </body>
</html>