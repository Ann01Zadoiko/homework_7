<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies/find">
            <label for="id">Company id:</label><br>
            <input type="text" id="companyId" name="companyId">
            <button type="submit">Find</button>
        </form><br>
        <c:if test="${not empty company.id}">
            <table>
                <thead>
                     <tr>
                        <th>Company id:</th>
                        <th>Company name:</th>
                        <th>Country:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${company.id}"/>
                        </td>
                        <td>
                            <c:out value="${company.companyName}"/>
                        </td>
                        <td>
                            <c:out value="${company.country}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty company.id}">
            <p>${message}</p>
        </c:if>
    </body>
</html>