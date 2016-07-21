<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<form action="">
<table>
<tr><td>Name:</td>
<td><input type="text"/></td></tr>
<tr><td>Address:</td>
<td><input type="text"/></td></tr>
<tr><td>Phone:</td>
<td><input type="text"/></td></tr>
<tr><td>Country:</td>
<td><input type="text"/></td></tr>
<tr><td>Pin:</td>
<td><input type="text"/></td></tr>
<input type="hidden" name="_flowExecutionKey" />



        <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected" />

        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>

</table>
</form>
</body>
</html>