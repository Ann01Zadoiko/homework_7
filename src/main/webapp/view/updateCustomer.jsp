<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/customers/update" method="post">
            <label for="name">Customer ID:</label><br>
            <input type="text" id="customerId" name="customerId"><br>
            <label for="name">Customer name:</label><br>
            <input type="text" id="customerName" name="customerName"><br>
            <label for="name">Country:</label><br>
            <input type="text" id="country" name="country"><br>
            <button type="submit">Update</button>
        </form><br>
        <c:if test="${not empty updatedCustomer}">
            <table>
                <thead>
                    <tr>
                        <th>Customer ID:</th>
                        <th>Customer name:</th>
                        <th>Country:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${updatedCustomer.id}"/>
                        </td>
                        <td>
                            <c:out value="${updatedCustomer.customerName}"/>
                        </td>
                        <td>
                            <c:out value="${updatedCustomer.country}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p>${message}</p>
        </c:if>
        <c:if test="${empty updatedCustomer}">
            <p>${message}</p>
        </c:if>
    </body>
</html>