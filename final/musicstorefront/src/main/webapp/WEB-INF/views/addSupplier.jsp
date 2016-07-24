<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<title>adminSupplier</title>
<%@include file="header.jsp"%>
<div class="container" id="categoryTable">
		
<br><br><br>
<a href="<c:url value="/admin" />">Home</a><br>
		<h1>Add a Supplier</h1>

		<c:url var="addAction" value="/supplier/add"></c:url>

		<form:form action="${pageContext.request.contextPath}/admin/supplier/add" commandName="suppliercommand">
			<table id="editsupplier">

				<tr>
					<td><label for="sid">ID</label></td>
					<c:choose>
						<c:when test="${!empty suppliercommand.sid}">
							<td><form:input path="sid" id="sid" readonly="true" /></td>
						</c:when>
						<c:otherwise>
							<td><form:input path="sid" id="sid" required="true"
									title="id should contains 6 to 7 characters" /></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td>Supplier Name</td>
					<td><form:input path="supname" id="supname" required="true"/></td>
					<td><form:errors path="supname" cssClass="error">Name</form:errors></td>
				</tr>
				<tr>
					<td>Supplier Address</td>
					<td><form:input path="supaddress" required="true"/></td>
					<td><form:errors path="supaddress" cssClass="error"></form:errors></td>

				</tr>
				<tr>
					<td>Contact No.</td>
					<td><form:input type="tel" path="supnumber" title="id should contains 10 digit" required="true" placeholder=" "/></td>
					<td><form:errors path="supnumber">*</form:errors></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="supemail" type="email" required="true"/></td>
					<td><form:errors path="supemail" cssClass="error">
						</form:errors>
				</tr>
				<tr>
					<td>Product</td>
					<td><form:input path="supproduct" required="true"/></td>
					<td><form:errors path="supproduct" cssClass="error">
						</form:errors>
				</tr>
				<tr>
					<td>Brand</td>
					<td><form:input path="brand" required="true"/></td>
					<td><form:errors path="brand" cssClass="error">
						</form:errors>
				</tr>
				<tr>
					<td><c:if test="${!empty suppliercommand.sid}">
							<input type="submit" value="Edit" />
						</c:if> <c:if test="${empty suppliercommand.sid}">
							<input type="submit" value="Submit" />
						</c:if></td>
						<td><c:if test="${empty suppliercommand.sid}">
							<input type="reset" value="Reset" /></c:if></td>
				</tr>
			</table>
		</form:form>
		<!-- <input type="text" ng-model="searchtype" placeholder="I want........"
			class="inputText pull-right"><br> -->

		<c:if test="${!empty supplier}">
			<h3>Supplier List</h3>
			<table class="table table-bordered table-striped" id="table">
				<tr>
					<th width="80">ID</th>
					<th width="120">Name</th>
					<th width="80">Address</th>
					<th width="80">Contact No.</th>
					<th width="80">Email</th>
					<th width="80">Brand</th>
					<th width="80">Product</th>
					<th width="80">Edit</th>
					<th width="80">Delete</th>
				</tr>
				<tbody>
					<c:forEach var="sup" items="${supplier}">
						<tr>
							<td>${sup.sid}</td>
							<td>${sup.supname}</td>
							<td>${sup.supaddress}</td>
							<td>${sup.supnumber}</td>
							<td>${sup.supemail}</td>
							<td>${sup.brand}</td>
							<td>${sup.supproduct}</td>
							<td><a href="<c:url value="/admin/supplier/edit/${sup.sid}" />"><span class="glyphicon glyphicon-pencil">Edit</span></a></td>
							<td><a href="<c:url value="/admin/supplier/remove/${sup.sid}" />"><span class="glyphicon glyphicon-trash">Delete</span></a></td>
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