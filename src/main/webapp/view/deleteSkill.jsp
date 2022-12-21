<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/delete">
            <label for="id">Skill id:</label><br>
            <input type="text" id="skillId" name="skillId">
            <button type="submit">Delete</button>
        </form><br>
        <p>${message}</p>
    </body>
</html>