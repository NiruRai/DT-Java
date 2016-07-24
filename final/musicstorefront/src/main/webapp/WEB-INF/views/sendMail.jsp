<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Sending Favorite Product</h1>

            <p class="lead">Now Send Your Favorite Product to your Near and Dear Ones!!</p>
        </div>
        <form method="post" action="/product/sendEmail">
			<table border="0" width="80%">
				<tr>
					<td>To:</td>
					<td><input type="text" name="recipient" size="65" /></td>
				</tr> 
				<tr>
					<td>Subject:</td>
					<td><input type="text" name="subject" size="65" value="${subject}" /></td>
				</tr> 
				<tr>
					<td>Message:</td>
					<td><textarea cols="50" rows="10" name="message" value="${msg}"></textarea></td>
				</tr> 
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Send E-mail" />
					</td>
				</tr>
			</table>
		</form>
		</div>
		</div>
<%@ include file="footer.jsp" %>