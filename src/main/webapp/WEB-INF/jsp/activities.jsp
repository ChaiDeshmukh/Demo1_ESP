<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<title>Company Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function displayAlert () {
		alert("Activity has been successfully recorded.");
	}
</script>

</head>
<body
	background="https://images.unsplash.com/photo-1517963879433-6ad2b056d712?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=44d61d92470aca6a8cb6819f6d4c1aa8&auto=format&fit=crop&w=1050&q=80">

	<div class="container">
		<h3>Activity Monitor</h3>
		<form action="/recorduseractivity" method="GET">
			<div class="activity-container">
				<div class="col-xs-5">
					<label class="control-label">Abs :</label>
					<input type="hidden" id="muscle" name="muscle" value="abs">
					<select id="exercise" name="exercise">
						<option value="null">-- select exercise --</option>
						<c:forEach items="${abs}" var="item">
							<option value="${item.exercise}">${item.exercise}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-xs-5">
					<label for="fname">Duration :</label>
	  				<input type="text" id="time" name="time">
				</div>
				<div class="col-xs-2">
					<button type="submit" onclick="displayAlert()">ADD</button>
				</div>
				<div class="clearfix"></div>
			</div>
		</form>
				
		<form action="/recorduseractivity" method="POST">
			<div class="activity-container">
				<div class="col-xs-5">
					<label class="control-label">Biceps :</label>
					<input type="hidden" id="muscle" name="muscle" value="biceps">
					<select id="exercise" name="exercise">
						<option value="null">-- select exercise --</option>
						<c:forEach items="${biceps}" var="item">
							<option value="${item.exercise}">${item.exercise}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-xs-5">
					<label for="fname">Duration :</label>
	  				<input type="text" id="time" name="time">
				</div>
				<div class="col-xs-2">
					<button type="submit" onclick="displayAlert()">ADD</button>
				</div>
				<div class="clearfix"></div>
			</div>
		</form>	
			
		<form action="/recorduseractivity" method="POST">
			<div class="activity-container">
				<div class="col-xs-5">
					<label class="control-label">Chest :</label>
					<input type="hidden" id="muscle" name="muscle" value="chest">
					<select id="exercise" name="exercise">
						<option value="null">-- select exercise --</option>
						<c:forEach items="${chest}" var="item">
							<option value="${item.exercise}">${item.exercise}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-xs-5">
					<label for="fname">Duration :</label>
	  				<input type="text" id="time" name="time">
				</div>
				<div class="col-xs-2">
					<button type="submit" onclick="displayAlert()">ADD</button>
				</div>
				<div class="clearfix"></div>
			</div>
		</form>	

		<form action="/recorduseractivity" method="POST">
			<div class="activity-container">
				<div class="col-xs-5">
					<label class="control-label">Back :</label>
					<input type="hidden" id="muscle" name="muscle" value="back">
					<select id="exercise" name="exercise">
						<option value="null">-- select exercise --</option>
						<c:forEach items="${back}" var="item">
							<option value="${item.exercise}">${item.exercise}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-xs-5">
					<label for="fname">Duration :</label>
	  				<input type="text" id="time" name="time">
				</div>
				<div class="col-xs-2">
					<button type="submit" onclick="displayAlert()">ADD</button>
				</div>
				<div class="clearfix"></div>
			</div>
		</form>	
			
		<form action="/recorduseractivity" method="POST">
			<div class="activity-container">
				<div class="col-xs-5">
					<label class="control-label">Shoulder :</label>
					<input type="hidden" id="muscle" name="muscle" value="shoulder">
					<select id="exercise" name="exercise">
						<option value="null">-- select exercise --</option>
						<c:forEach items="${shoulder}" var="item">
							<option value="${item.exercise}">${item.exercise}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-xs-5">
					<label for="fname">Duration :</label>
	  				<input type="text" id="time" name="time">
				</div>
				<div class="col-xs-2">
					<button type="submit" onclick="displayAlert()">ADD</button>
				</div>
				<div class="clearfix"></div>
			</div>
		</form>		
			
		<form action="/recorduseractivity" method="POST">
			<div class="activity-container">
				<div class="col-xs-5">
					<label class="control-label">Tricep :</label>
					<input type="hidden" id="muscle" name="muscle" value="tricep">
					<select id="exercise" name="exercise">
						<option value="null">-- select exercise --</option>
						<c:forEach items="${tricep}" var="item">
							<option value="${item.exercise}">${item.exercise}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-xs-5">
					<label for="fname">Duration :</label>
	  				<input type="text" id="time" name="time">
				</div>
				<div class="col-xs-2">
					<button type="submit" onclick="displayAlert()">ADD</button>
				</div>
				<div class="clearfix"></div>
			</div>
		</form>	
	
		<form action="/recorduseractivity" method="POST">
			<div class="activity-container">
				<div class="col-xs-5">
					<label class="control-label">Leg :</label>
					<input type="hidden" id="muscle" name="muscle" value="leg">
					<select id="exercise" name="exercise">
						<option value="null">-- select exercise --</option>
						<c:forEach items="${leg}" var="item">
							<option value="${item.exercise}">${item.exercise}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-xs-5">
					<label for="fname">Duration :</label>
	  				<input type="text" id="time" name="time">
				</div>
				<div class="col-xs-2">
					<button type="submit" onclick="displayAlert()">ADD</button>
				</div>
				<div class="clearfix"></div>
			</div>
		</form>		

	<form action="/calculatecaloriesburnt" method="POST">
		<button type="submit">Submit</button>
		<font class="calories">${caloriesburnt}</font>
	</form> 
</div>


</body>
</html>
<style>
.tripdata {
	display: block;
}
#container {
	font-family: "Times New Roman", Times, serif;
  	font-size: 20px;
  	display: block;
  	width: 100%;
  	margin: auto;
}
.activity-container {
  padding: 20px;
  border: 1px solid #666;
  background: #e3dcdc;
  margin-bottom: 15px;
}
.control-label {
	width: 70px;
}
#exercise {
	width: 60%;
}
.calories {
	font-size: 25px;
    color: white;
    margin-left: 15px;
}
</style>
