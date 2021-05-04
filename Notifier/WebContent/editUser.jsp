<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("index.jsp");
	}
%>
<!DOCTYPE html>

<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta charset="ISO-8859-1">
</head>
<body>
    <div >
        <div class="w3-row w3-teal ">
            <div class="w3-sidebar w3-bar-block w3-border-right" style="display:none" id="mySidebar">
                <button onclick="w3_close()" class="w3-bar-item w3-large ">Close &times;</button>
                <form action="notebook" method="post"> <button type="submit" class="w3-bar-item w3-button w3-black w3-margin" name="action" value="NoteBooks">NoteBooks</button></form>
                <form action="dashboard"> <button type="submit" class="w3-bar-item w3-button w3-black w3-margin">Notes</button></form>
                <form action="edituser"> <button type="submit" class="w3-bar-item w3-button w3-black w3-margin">Edit User</button><input name="action" value="fetch_details" style="display: none"></form>
              </div>
              <!-- Page Content -->
            
            <div >
                <button class="w3-button w3-xlarge w3-left" onclick="w3_open()"><i class="fa fa-bars"></i></button>
                <form action="logout">
                	<button class="w3-right" type="submit" style="background-color: transparent; border: none; margin-top:10px;color: white"><i  class="fa fa-sign-out w3-button w3-large">Logout</i></button>
                </form>
                
            </div>
            
        </div>
        <div class="w3-container">
            <div class="w3-center" style="width: 50%; margin: auto;"  >
                <h1>Edit User</h1>
                <label style="color: green">${success}</label>
                <label style="color: red">${oldpasswordwrong}</label>
                <form action="edituser" method="post">
                    <div class="w3-card w3-round" >
                            <table class="w3-table">
                                <tr>
                                    <td>Email ID:</td>
                                    <td ><label>${email}</label></td>
                                </tr>
                                <tr>
                                    <td>Name:</td>
                                    <td ><input type="text" value="${name}" name="Name"></td>
                                </tr>
                                <br>
                                <tr>
                                    <td>Old Password:</td>
                                    <td><input  type="text" placeholder="old password" name="old_pass"></td>
                                </tr>
                                <br>
                                <tr>
                                    <td>New Password:</td>
                                    <td><input type="text" placeholder="new password" name="new_pass"></td>
                                </tr>
                                
                            </table>
                            <br>
                            <input name="action" value="edit_details" style="display: none">
                            <button type="submit" >Edit</button>
                            <br><br><br>
                    </div>
                </form>
            </div>

        </div>

        <!-- <div class="w3-row">
            <h2 class="w3-left">NoteBooks</h2>
            <form class="w3-right">
                <input style="margin-top:20px;margin-right: 10px" type="text" placeholder="search" name="search">
                <i class="fa fa-search w3-button w3-right"style="margin-top:20px;margin-right: 10px"></i>
            </form>
        </div>
        <div class="w3-row w3-teal w3-round w3-card w3-margin">
            <h2 class="w3-center w3-white w3-margin">No NoteBook</h2>
           <div class="w3-row w3-white  w3-card w3-margin">
               <label class="w3-left">${notebook_name}</label>
               <span class="w3-right"><i class="fa fa-edit w3-button w3-right"style="margin-right: 10px">Edit</i> </span>
               <span class="w3-right"><i class="fa fa-close w3-button w3-right"style="margin-right: 10px">delete</i> </span>
               <label class="w3-row">${0}notes</label>    
           </div>
           
           
        </div> -->
        
    </div>
</body>
</html>
<script>
    function w3_open() {
      document.getElementById("mySidebar").style.display = "block";
    }
    
    function w3_close() {
      document.getElementById("mySidebar").style.display = "none";
    }
    if ( window.history.replaceState ) 
    {
    	  window.history.replaceState( null, null, window.location.href );
    }
    </script>
