<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/projects/add" method="post">
            <label for="name">Project name:</label><br>
            <input type="text" id="projectName" name="projectName"><br>
            <label for="name">Cost:</label><br>
            <input type="text" id="cost" name="cost"><br>
            <label for="name">Date created (by format yyyy-mm-dd):</label><br>
            <input type="text" id="dateOfCreation" name="dateOfCreation"><br>
            <button type="submit">Save</button>
        </form>
    </body>
</html>