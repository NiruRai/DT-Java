<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<title>adminCategory</title>
<%@include file="header.jsp"%>
<div class="container" id="categoryTable">
		
<br>
	<br><br><a href="<c:url value="/admin" />">Home</a><br>
	<br>
	<h1>Add a Category</h1>

		<c:url var="addAction" value="/category/add"></c:url>

		<form:form action="${pageContext.request.contextPath}/admin/category/add" commandName="categorycommand">
			<table id="edittable">

				<tr>
					<td><label for="cid">ID</label></td>
					<c:choose>
						<c:when test="${!empty categorycommand.cid}">
							<td><form:input path="cid" id="cid" readonly="true" /></td>
						</c:when>
						<c:otherwise>
							<td><form:input path="cid" id="cid" required="true"
									title="id should contains 6 to 7 characters" /></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td>Name</td>
					<td><form:input path="cname" id="cname" required="true" /></td>
					<td><form:errors path="cname" cssClass="error">Name</form:errors></td>
				</tr>
				
				<tr>
					<td>Description</td>
					<td><form:input path="description" id="description" required="true"/></td>
					<td><form:errors path="description" cssClass="error">
						</form:errors>
				</tr>
				<tr>

					<td>Stock</td>
					<td><form:input path="stock" id="stock" required="true"/></td>
					<td><form:errors path="stock" cssClass="error">
						</form:errors>

				</tr>
				<tr>
					<td><c:if test="${!empty categorycommand.cid}">
							<input type="submit" value="Edit" />
						</c:if> <c:if test="${empty categorycommand.cid}">
							<input type="submit" value="Submit" /></c:if></td>
							<td><c:if test="${empty categorycommand.cid}">
							<input type="reset" value="Reset" />
						</c:if></td>
				</tr>
			</table>
		</form:form>
		<!-- <input type="text" ng-model="searchtype" placeholder="I want........"
			class="inputText pull-right"><br> -->

		<c:if test="${!empty category}">
			<h3>Category List</h3>
			<table class="table table-bordered table-striped" id="table">
				<tr>
					<th width="80">ID</th>
					<th width="120">Name</th>
					<th width="80">Description</th>
					<th width="80">Stock</th>
					<th width="80">Edit</th>
					<th width="80">Delete</th>
				</tr>
				<tbody>
					<c:forEach var="cat" items="${category}">
						<tr>
							<td>${cat.cid}</td>
							<td>${cat.cname}</td>
							<td>${cat.description}</td>
							<td>${cat.stock}</td>
							<td><a href="<c:url value="/admin/category/edit/${cat.cid}" />">Edit</a></td>
							<td><a href="<c:url value="/admin/category/remove/${cat.cid}" />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

	<br>
	<br>
	<br>
<%@include file="footer.jsp"%>