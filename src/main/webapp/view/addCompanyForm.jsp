<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies/add" method="post">
            <label for="name"><font color="#ffffff">Company name:</font></label><br>
            <input type="text" id="companyName" name="companyName"><br>
            <label for="name"><font color="#ffffff">Country:</font></label><br>
            <input type="text" id="country" name="country"><br>
            <button type="submit">Save</button>
        </form>
    </body>
</html>