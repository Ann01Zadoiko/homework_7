<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/customers/add" method="post">
            <label for="name">Customer name:</label><br>
            <input type="text" id="customerName" name="customerName"><br>
            <label for="name">Country:</label><br>
            <input type="text" id="country" name="country"><br>
            <button type="submit">Save</button>
        </form><br>
        <c:if test="${not empty savedCustomer}">
            <table>
                <thead>
                    <tr>
                        <th>Customer name:</th>
                        <th>Country:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${savedCustomer.customerName}"/>
                        </td>
                        <td>
                            <c:out value="${savedCustomer.country}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
        <c:if test="${empty savedCustomer}">
            <p>${message}</p>
        </c:if>
    </body>
</html>