<%@include file="header.jsp"%>
<%@include file="footer.jsp"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<title>adminSupplier</title>
<%@include file="header.jsp"%>
<div class="container" id="categoryTable">
		
<br><br><br>
<a href="<c:url value="/admin" />">Home</a><br>
		<h1>Edit Customer Information</h1>

		<c:url var="addAction" value="/customer/add"></c:url>

		<form:form action="${pageContext.request.contextPath}/admin/customer/add" commandName="customercommand">
			<table id="editcustomer">

				<tr>
					<td><label for="userid">ID</label></td>
							<td><form:input path="userid" id="userid" readonly="true" /></td>
						
				</tr>
				<tr>
					<td>Name</td>
					<td><form:input path="username" id="username" required="true"/></td>
					<td><form:errors path="username" cssClass="error">Name</form:errors></td>
				</tr>
				
				<tr>
					<td>Contact No.</td>
					<td><form:input type="tel" path="usernumber" title="id should contains 10 digit" required="true" placeholder=" "/></td>
					<td><form:errors path="usernumber">*</form:errors></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="useremail" type="email" required="true"/></td>
					<td><form:errors path="useremail" cssClass="error">
						</form:errors>
				</tr>
				
				<tr>
					
							<td><input type="submit" value="Edit" /></td>
						
				</tr>
			</table>
		</form:form>
		<!-- <input type="text" ng-model="searchtype" placeholder="I want........"
			class="inputText pull-right"><br> -->

		<c:if test="${!empty userList}">
			<h3>Supplier List</h3>
			<table class="table table-bordered table-striped" id="table">
				<tr>
					<th width="80">ID</th>
					<th width="120">Name</th>
					<th width="80">Contact No.</th>
					<th width="80">Email</th>
					<th width="80">Password</th>
					<th width="80">Enabled</th>
					<th width="80">Edit</th>
					
				</tr>
				<tbody>
					<c:forEach var="user" items="${userList}">
						<tr>
							<td>${user.userid}</td>
							<td>${user.username}</td>
							<td>${user.usernumber}</td>
							<td>${user.useremail}</td>
							<td>${user.userloginpassword}</td>
							<td>${user.enabled}</td>
							<td><a href="<c:url value="/admin/customer/edit/${user.userid}" />"><span class="glyphicon glyphicon-pencil">Edit</span></a></td>
							<%-- <td><a href="<c:url value="/admin/supplier/remove/${sup.sid}" />"><span class="glyphicon glyphicon-trash">Delete</span></a></td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>


	<!--  </div> -->
	<br>
	<br>
	<br>
<%@include file="footer.jsp"%>