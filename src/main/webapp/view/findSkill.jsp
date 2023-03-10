<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/find">
            <label for="id">Skill id:</label><br>
            <input type="text" id="skillId" name="skillId">
            <button type="submit">Find</button>
        </form><br>
        <c:if test="${not empty skill.id}">
            <table>
                <thead>
                    <tr>
                        <th>Skill id:</th>
                        <th>Programming Language:</th>
                        <th>Skill level:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${skill.id}"/>
                        </td>
                        <td>
                            <c:out value="${skill.programmingLanguage}"/>
                        </td>
                        <td>
                            <c:out value="${skill.skillLevel}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty skill.id}">
            <p>${message}</p>
        </c:if>
    </body>
</html>