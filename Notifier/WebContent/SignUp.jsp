<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<title>Sign up - Notifier</title>
	
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
	width: 400px;
	border-radius: 5px;
	background-color:rgb(111, 238, 122);
	left: 50%;
	position: absolute;
	margin-left: -200px;
	font-family: 'Helvetica';
	margin-top: 50px;
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
	<label style="color: red">${duplicate_email}</label>
		<div id="text-align"><p>Have an account?<a href="/Notifier/index.jsp">Log in</a></p></div>
		<form id="one" name="myJS" action="signup"method="post" >
	
			<div><h2>SIGN UP<h2></div>
				<input placeholder="Name" type="text" id="name" class="size" name="name"required><br>
				<input placeholder="Email" type="email" id="email" class="size" name="email"required><br>
				<input placeholder="Re-enter email" type="email" id="emailid" class="size" name="remail"required><br>
				<input placeholder="Password" type="Password" id="pass" class="size" name="pass"required><br>
				<input placeholder="Re-enter password " type="Password" id="password" class="size" name="rpass"required><br>
				<input type="checkbox" id="button" name="check" style=" margin-left: -1px" >
				<label for="button" id="ben">Accept terms and conditions</label><br><br>
				<button type="submit" id="buttonSubmit">Create Account</button>
	
	
	
	</form>
	</div>	
	</body>
</html>
<script>
	function check(){
					var abc = document.myJS.iname.value;
					var email= document.myJS.email.value;
					var reemail = document.myJS.remail.value;
					var password= document.myJS.password.value;
					var rpass= document.myJS.rpass.value;
					var check = document.myJS.check.checked;
					
					
					if(email != reemail)
					{
						alert("Re-enter email do not match!!");
						return false;
					}
					
					else if(password.length<6)
					{
						alert("Password must be at least 6 characters long!!");
						return false;
					}
					
					else if(password!=rpass)
					{
						alert("Re-enter Password do not match!!");
						return false;
					}
					else if(check==false)
					{
						alert("Please accept terms and conditions");
						return false;
					}
					else
						return true;
					
					}
	</script>