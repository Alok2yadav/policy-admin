<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Policy Finder | Policy List</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<div class="container-fluid">
	<jsp:include page="nav.jsp" />


<div class="row">
	<div class="col-md-12">
		<h3>Policy Index Inquiry Screen</h3>
	</div>
</div>

<div class="row section">
	<div class="col-md-6">
	    <p><span id="p_selection" class="badge badge-primary"></span>	</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Enter Effective Date</th>
					<th>Policy Number</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="listValue" items="${policies}">

					<tr class="tr_policyrow">
						<td>${listValue.effectiveDate}</td>

						<td class="td_policyid">${listValue.policyNumber}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</div>

<div class="row">
	<div class="col-md-12">
		
		<button id="btn_showdetails" class="btn btn-primary" disabled><a id="a_btn_showdetails" class="btn-link" href="/policy?id=">Show Details</a></button>
		<button id="btn_add" class="btn btn-primary"><a class="btn-link" href="/addNewPolicy">Add Policy</a></button>
		<button id="btn_delAll" class="btn btn-primary"><a class="btn-link" href="/deleteAllPolicy">Delete All</a></button>
	</div>
</div>
</div>
</body>
</html>

<script>

	$("tr.tr_policyrow").click(function() {
		
		var policyId = $(this).find("td.td_policyid").text();
		var url = "/policy?id="+(policyId);
		
		$("#p_selection").text("Selected Policy :"+policyId);
		
		
		$("#btn_showdetails").removeAttr('disabled');
		$("#a_btn_showdetails").attr('href',url);
		
	});
	
	$("*:not(.table)").click(function() {
		
		console("outside");
		
	});
	
	
	
	
	
</script>