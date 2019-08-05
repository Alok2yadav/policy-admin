<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Policy Finder | Policy Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 <style><%@include file="/WEB-INF/css/style.css"%></style>
 
</head>

<body>
	<div class="container-fluid">
	<jsp:include page="nav.jsp" />
		<div class="row">
			<div class="col-md-12">
				<h3>Policy Form</h3>
			</div>
		</div>

		<div id="addPolicy" class="row section">
			<div class="col-md-6">

				<form:form action="/save" method="post"
					modelAttribute="policy_form">


					<table class="table table-borderless">
							<tr>
								<td><label>Effective Date</label></td>
								<td><form:input path="effectiveDate" type="date" /></td>
							</tr>
							<tr>
								<td><label>Policy Number</label></td>
								<td><form:input path="policyNumber" /></td>
							</tr>
							<tr>
								<td><label>Coverage Amount</label></td>
								<td><form:input path="coverageAmount" /></td>
							</tr>							
							<tr>
								<td><label>Insured Person Name</label></td>
								<td><form:input path="insuredPerson" /></td>
							</tr>
							<tr>
								<td></td>
								<td><input class="btn btn-primary" type="SUBMIT" value="Save" /></td>
								
							</tr>

						</tbody>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>