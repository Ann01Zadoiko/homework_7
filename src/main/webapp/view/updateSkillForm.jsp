<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/update" method="post">
            <label for="name">Skill ID:</label><br>
            <input type="text" id="skillId" name="skillId"><br>
            <label for="name">Programming Language:</label><br>
            <input type="text" id="programmingLanguage" name="programmingLanguage"><br>
            <label for="name">Skill level:</label><br>
            <input type="text" id="skillLevel" name="skillLevel"><br>
            <button type="submit">Update</button>
        </form>
    </body>
</html>