<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View By Name</title>
</head>
<body>
<table border=1>
<thead>
<tr>

<th> Name</th>
<th> Price </th>
</tr>
</thead>
<tbody>
<c:forEach var="b1" items="${booklist}">
<tr>
<td> ${b1.Name }</td>
<td> ${b1.Price}</td>

</tr>
</c:forEach>

</tbody>
</table>



</body>
</html>