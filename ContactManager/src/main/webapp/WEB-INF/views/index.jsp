<%-- 
    Document   : index
    Created on : Apr 9, 2024, 3:26:21 AM
    Author     : d
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Contact List</h1>
            <h3><a href="new">New Contact</a></h3>
            <table border="1" cellpadding="5">
                <tr>
                    <th>No</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Telephone</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${contacts}" var="contact" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${contact.name}</td>
                        <td>${contact.email}</td>
                        <td>${contact.address}</td>
                        <td>${contact.phone}</td>
                        <td colspan="2">
                            <a href="edit?id=${contact.id}" style="margin-right: 20px;">Edit</a>
                            <a href="delete?id=${contact.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        
        
    </body>
</html>
