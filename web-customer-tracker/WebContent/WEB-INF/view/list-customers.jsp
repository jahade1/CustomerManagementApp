<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title> List Customers</title>
													<!-- gives proper name of application -->
	<link	type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

	<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager </h2>
			</div>
	</div>
	
	<div id="Container">
	
		<div id="content">
		
		<!-- put button to add customer -->
		
		<input type="button" value="Add customer" onclick="window.location.href='ShowFormforAdd';return false;" 
			class="add-button" />
		<!--  add out html table here -->
		
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			
			<!-- loop over list of customers -->
			<c:forEach var="tempCustomer" items="${customers}">
			
			<!-- construct update link with customer id -->
			<c:url var="updateLink" value="/customer/showFormforUpdate">
				<c:param name="customerId" value="${tempCustomer.id}"/>
			</c:url>
			
			<tr>
				<td>${tempCustomer.firstName}</td>
				<td>${tempCustomer.lastName}</td>
				<td>${tempCustomer.email}</td>
				<td>
				<!-- display update link -->
				<a href="${updateLink}">Update</a>
				</td>
				
			</tr>
			
			</c:forEach>
		</table>
		
		
		</div>
	
	</div>


</body>



</html>