<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
#bdy {
    /* The image used */
    background-image: url("https://images.unsplash.com/photo-1517963879433-6ad2b056d712?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=44d61d92470aca6a8cb6819f6d4c1aa8&auto=format&fit=crop&w=1050&q=80");
	
    /* Full height */
    height: 100%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    
}
</style>
<body id="bdy">
	<div class="container">
		<h2 class="title">Dashboard</h2>
		<div class="weight">
			<h3>Calculate ideal weight</h3>
			<form method="GET" action="/idealweight">
				<p>
					<b>Enter your height</b>
					<input type="text" id="height" name="height" required>
				</p>
				<p>
					<b>Enter your gender</b>
					<input type="text" id="gender" placeholder="Enter gender" name="gender" required>
				</p>
				<input type="submit" name="Submit" value="Submit">
			</form>
			<h1><font>${weight}</font></h1>
		</div>
		<div class="activity">
			<h3>Track your fitness level</h3>
			<form method="GET" action="/showactivities">
				<input type="submit" name="Show Activities" value="Fitness Tracker">
			</form>
		</div>
		<br /><br />
			
			<input type=button class="btn btn-danger" onClick="parent.open('http://espoktaproject-env.cgp8m3deci.us-east-1.elasticbeanstalk.com/login')" value='Nutrition Website' >

	</div>
</body>



</html>
<style>
	.container {
		color: white;
		width: 33%;
	    padding-top: 30px;
	    margin: auto;
	}
	.title {
		text-align: center;
    		font-size: 34px;
	}
	.weight {
	    padding-bottom: 10px;
    		border-bottom: 1px solid white;
	}
	.activity {
	    padding-bottom: 10px;
    		border-bottom: 1px solid white;
	}
</style>