<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">        
  <table class="table">
    <thead>
      <tr>
        <th>product ID</th>
        <th>product Name</th>
        <th>product Batch</th>
        <th>product Price</th>
        <th>product Stock</th>
        <th>product Type</th>
      </tr>
    </thead>
    <tbody>
   
    <c:forEach items="${ProList}" var="e">
     <tr>
        <td>${e.id }</td>
        <td>${e.name }</td>
        <td>${e.batch }</td>
        <td>${e.price}</td>
        <td>${e.stock }</td>
        <td>${e.type }</td>
        
      </tr>
    </c:forEach>
     
  
    </tbody>
  </table>
</div>

</body>
</html>