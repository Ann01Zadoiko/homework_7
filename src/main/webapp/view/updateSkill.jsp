<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/update" method="post">
            <label for="name"><font color="#ffffff">Skill ID:</font></label><br>
            <input type="text" id="skillId" name="skillId"><br>
            <label for="name"><font color="#ffffff">Programming Language:</font></label><br>
            <input type="text" id="programmingLanguage" name="programmingLanguage"><br>
            <label for="name"><font color="#ffffff">Skill level:</font></label><br>
            <input type="text" id="skillLevel" name="skillLevel"><br>
            <button type="submit">Update</button>
        </form><br>
        <c:if test="${not empty updatedSkill}">
            <table>
                <thead>
                    <tr>
                        <th>Skill ID:</th>
                        <th>Programming Language:</th>
                        <th>Skill level:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${updatedSkill.id}"/>
                        </td>
                        <td>
                            <c:out value="${updatedSkill.programmingLanguage}"/>
                        </td>
                        <td>
                            <c:out value="${updatedSkill.skillLevel}"/>
                         </td>
                    </tr>
                </tbody>
            </table>
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
        <c:if test="${empty updatedSkill}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>