<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/projects/delete">
            <label for="id">Project id:</label><br>
            <input type="text" id="projectId" name="projectId">
            <button type="submit">Delete</button>
        </form><br>
        <p>${message}</p>
    </body>
</html>