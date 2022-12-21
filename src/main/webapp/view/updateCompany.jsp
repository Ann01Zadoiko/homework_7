<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies/update" method="post">
            <label for="name">ID:</label><br>
            <input type="text" id="companyId" name="companyId"><br>
            <label for="name">Company name:</label><br>
            <input type="text" id="companyName" name="companyName"><br>
            <label for="name">Country:</label><br>
            <input type="text" id="country" name="country"><br>
            <button type="submit">Update</button>
        </form><br>
        <c:if test="${not empty updatedCompany}">
            <table>
                <thead>
                    
                    <tr>
                        <th>ID:</th>
                        <th>Company name:</th>
                        <th>Country:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${updatedCompany.id}"/>
                        </td>
                        <td>
                            <c:out value="${updatedCompany.companyName}"/>
                        </td>
                        <td>
                            <c:out value="${updatedCompany.country}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p>${message}</p>
        </c:if>
        <c:if test="${empty updatedCompany}">
            <p>${message}</p>
        </c:if>
    </body>
</html>