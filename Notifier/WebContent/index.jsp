<!doctype html>
<html>
	<head>
	
	<title>Sign in- Notifier</title>
	
	<style>
#personalheader{
	background-color: red;
}
#text-align
{
	text-align: center;
}
#header
{
	text-align: center;
	font-family: 'cooper';
	padding-top: 10px;
	width: 100%;
	height: 100px;
	font-weight: bold;
	border-bottom: 1px solid black;
	background-color:rgb(75, 226, 120);
}
#box
{
	padding-top: 50px;
	padding: 40px;
	width:400px;
	border-radius: 5px;
	background-color:rgb(111, 238, 122);
	left: 50%;
	position: absolute;
	margin-left: -240px;
	font-family: 'Helvetica';
	margin-top: 50px;
}
h2
{
	text-align:center;
}
body{
	background-color:whitesmoke;
}
.size{
	width: 380px;
    margin-bottom: 10px;
    padding: 10px;
}
#buttonSubmit{
	width: 400px;
    background-color: green;
	margin-top: 20px;
    padding: 10px;
    color: white;
	cursor: pointer;
}
#buttonSubmit:hover{
	background-color:rgba(157, 247, 184, 0.883);
	color:black;
	
}
#ben{
		font-size: 14px;
}
#text{
	font-size: 10px;
	
}
	</style>
	</head>
	<body>
		<div id="header">
		<p><h1>NOTIFIER<h1></p>
		</div>
		
	<div id="box">
		
		<form id="one" name="login" action="login" method="post">
	
			<div><h2>Login<h2></div>
				
				<input placeholder="Enter Email" type="email" id="email" class="size" name="email"required><br>
				<input placeholder="Enter Password" type="Password" id="pass" class="size" name="pass"required><br>
				<button type="submit" id="buttonSubmit">Login</button>
				<div id="text-align"><p>Don't have an account?<a href="/Notifier/SignUp.jsp">Sign Up</a></p></div>
	
	
	</form>
	</div>	
	</body>
</html>
