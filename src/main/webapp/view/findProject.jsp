<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/projects/find">
            <label for="id">Project id:</label><br>
            <input type="text" id="projectId" name="projectId">
            <button type="submit">Find</button>
        </form><br>
        <c:if test="${not empty project.id}">
            <table>
                <thead>
                    <tr>
                        <th>Project id:</th>
                        <th>Project name:</th>
                        <th>Cost:</th>
                        <th>Date created:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${project.id}"/>
                        </td>
                        <td>
                            <c:out value="${project.projectName}"/>
                        </td>
                        <td>
                            <c:out value="${project.cost}"/>
                        </td>
                        <td>
                            <c:out value="${project.dateOfCreation}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty project.id}">
            <p>${message}</p>
        </c:if>
    </body>
</html>