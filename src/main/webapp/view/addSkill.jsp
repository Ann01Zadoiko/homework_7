<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/add" method="post">
            <label for="name"><font color="#ffffff">Programming Language:</font></label><br>
            <input type="text" id="programmingLanguage" name="programmingLanguage"><br>
            <label for="name"><font color="#ffffff">Skill level:</font></label><br>
            <input type="text" id="skillLevel" name="skillLevel"><br>
            <button type="submit">Save</button>
        </form><br>
        <c:if test="${not empty savedSkill}">
            <table>
                <thead>
                    <tr>
                        <th>Programming Language:</th>
                        <th>Skill level:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${savedSkill.programmingLanguage}"/>
                        </td>
                        <td>
                            <c:out value="${savedSkill.skillLevel}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty savedSkill}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>