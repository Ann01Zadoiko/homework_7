<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/add" method="post">
            <label for="name">Programming Language:</label><br>
            <input type="text" id="programmingLanguage" name="programmingLanguage"><br>
            <label for="name">Skill level:</label><br>
            <input type="text" id="skillLevel" name="skillLevel"><br>
            <button type="submit">Save</button>
        </form>
    </body>
</html>