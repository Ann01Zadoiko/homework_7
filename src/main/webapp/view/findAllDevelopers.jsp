<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <table>
            <thead>
                <tr>
                    <th>ID:</th>
                    <th>Developer name:</th>
                    <th>Age:</th>
                    <th>Salary:</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="developer" items="${developers}">
                    <tr>
                        <td>
                            <c:out value="${developer.id}"/>
                        </td>
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
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>