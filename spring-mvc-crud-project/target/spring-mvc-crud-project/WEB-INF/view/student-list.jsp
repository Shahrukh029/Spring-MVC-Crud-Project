<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
<title>Student List</title>

<style type="text/css">
.content-table {
	border-collapse: collapse;
	border: 25px;
	font-size: 0.9em;
	min-width: 400px;
	border-radius: 5px 5px 0 0;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
	width: 100%;
}

.content-table thead tr {
	background-color: #009879;
	color: #ffffff;
	text-align: left;
	font-weight: bold;
}

.content-table th,td {
	padding: 12px 15px;
}

.content-table tbody tr {
	border-bottom: 1px sollid #dddddd;
}

.content-table tbody tr:nth-of-type(even) {
	background-color: #f3f3f3;
}

.content-table tbody tr:last-of-type {
	border-bottom: 2px solid #009829;
}

#wrapper {
	width: 100%;
	margin-top: 0px;
}

#header {
	width: 100%;
	background: #009879; ;
	margin-top: 0px;
	padding: 15px 0px 15px 15px;
}

#header h2 {
	width: 100%;
	margin: auto;
	color: #FFFFFF;
}

#container {
	width: 100%;
	margin: auto
}

#container h3 {
	color: #000;
}

#container #content {
	margin-top: 20px;
}

.add-button {
	position:relative;
	transition:all .2s ease-in-out;
	border: 1px solid #666;
	border-radius: 8px;
	padding: 8px;
	font-size: 12px;
	font-weight: bold;
	width: 120px;
	padding: 5px 10px;
	margin-bottom: 15px;
	background: #009879;;
	color:#ffffff;
	cursor: pointer;
	
}

button:hover
{
	background-color:#ffffff;
	color: #009879;
}


</style>


</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Student Management System</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->

			<input type="button" value="Add Student"
				onclick="window.location.href='showAddForm'; return false;"
				class="add-button" />




			<!--  add our html table here -->

			<table class="content-table">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>

				<!-- loop over and print our customers -->
				<c:forEach var="tempStudent" items="${students}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/mywebsite.com/student/showUpdate">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/mywebsite.com/student/delete">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					<tbody>
						<tr>
							<td>${tempStudent.firstName}</td>
							<td>${tempStudent.lastName}</td>
							<td>${tempStudent.email}</td>

							<td>
								<!-- display the update link --> <a href="${updateLink}">Update</a>
								| <a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">Delete</a>
							</td>

						</tr>
					</tbody>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</body>
</html>