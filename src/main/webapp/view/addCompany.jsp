<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies/add" method="post">
            <label for="name">Company name:</label><br>
            <input type="text" id="companyName" name="companyName"><br>
            <label for="name">Country:</label><br>
            <input type="text" id="country" name="country"><br>
            <button type="submit">Save</button>
        </form><br>
        <c:if test="${not empty savedCompany}">
            <table>
                <thead>
                    <tr>
                        <th>Company name:</th>
                        <th>Country:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${savedCompany.companyName}"/>
                        </td>
                        <td>
                            <c:out value="${savedCompany.country}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
        <c:if test="${empty savedCompany}">
            <p>${message}</p>
        </c:if>
    </body>
</html>