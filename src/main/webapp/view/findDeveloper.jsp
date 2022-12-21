<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/developers/find">
            <label for="id">Developer id:</label><br>
            <input type="text" id="developerId" name="developerId">
            <button type="submit">Find</button>
        </form><br>
        <c:if test="${not empty developer.id}">
            <table>
                <thead>
                    <tr>
                        <th>Developer name:</th>
                        <th>Age:</th>
                        <th>Salary:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${developer.developerName}"/>
                        </td>
                        <td>
                            <c:out value="${developer.age}"/>
                        </td>
                        <td>
                            <c:out value="${developer.salary}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty developer.id}">
            <p>${message}</p>
        </c:if>
    </body>
</html>