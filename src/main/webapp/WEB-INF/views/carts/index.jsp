<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Carts</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h3 style="color: blue; font-family: sans-serif;">Cart List:</h3>
	
	<a href="<c:url value="/"/>">Add Cart</a> --- 
	<a href="<c:url value="/"/>">Return to Index</a>
	<br/><br/>
	
	<table border="1" style="width: 100%;">
		<tr>
			<th width="5%">Cart Id</th>
			<th width="10%">Lines Amount</th>
			<th width="10%">Shipping Amount</th>
			<th width="10%">Cart Amount</th>
			<th width="17%">Ship To</th>
			<th width="7%">Status</th>
			<th width="15%">Created Date</th>
			<th width="15%">Modified Date</th>
			<th width="11%">Delete</th>
		</tr>
		<c:forEach var="cart" items="${carts}">
			<tr>
				<td><a href="/batch-jdbc/carts/show/${cart.id}"><fmt:formatNumber pattern="000" value="${cart.id}"/></a></td>
				<td><fmt:formatNumber pattern="$ #,##0.00" value="${cart.linesAmount}" /></td>
				<td><fmt:formatNumber pattern="$ #,##0.00" value="${cart.shippingAmount}" /></td>
				<td><fmt:formatNumber pattern="$ #,##0.00" value="${cart.cartAmount}" /></td>
				<td>${cart.shipTo.name}</td>
				<td>${cart.status.description}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${cart.createDate}" /></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${cart.updateDate}" /></td>
				<td><c:if test="${cart.status.id != 1300}">Delete</c:if></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
