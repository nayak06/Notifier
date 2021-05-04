<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("index.jsp");
	}
%>

<head>
	<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
              
              
              <!-- CHANGE -->
            <div >
                <button class="w3-button w3-xlarge w3-left" onclick="w3_open()"><i class="fa fa-bars"></i></button>
                <h3 class="w3-left w3-margin-left">Welcome back ${name}</h3>
                <form action="logout">
                	<button class="w3-right" type="submit" style="background-color: transparent; border: none; margin-top:10px;color: white"><i  class="fa fa-sign-out w3-button w3-large">Logout</i></button>
                </form>
                <div  class="w3-dropdown-hover w3-right" style="margin-top:10px;margin-right: 10px">
                    <button class="w3-button w3-transparent"><i class="fa fa-bell"></i></button>
                    <div class="w3-dropdown-content w3-bar-block w3-border">
                        <h4 id="reminder" class="w3-center w3-bold" style="color: teal;" >No Reminder</h4>
                        <c:forEach items="${remind_list}" var="s">
                        <c:if test="${s.notename!=null}">
                        	<style>
                        		#reminder{display: none;}
                        	</style>
                        </c:if>
                        <div>
                        	<h5 class="w3-center">${s.notename}</h5>
                        	<h6 class="w3-center">${s.reminddate}</h6>
                        	<hr>
                        </div>
                        
                        </c:forEach>
                        
                       
                      </div>
                      <c:if test="${reminder_nos!=0}">
                      <span  class="badge" style="position: absolute;top: -10px;right: -10px;padding: 5px 10px; border-radius: 50%;background-color: red;color: white; font-size: x-small;">${reminder_nos}</span>
                      </c:if>
                      
                </div>
            </div>
        </div>

         <div class="w3-row">
            <h2 class="w3-left w3-margin">All Notes</h2>
            <form class="w3-right">
                <input style="margin-top:20px;margin-right: 10px" type="text" placeholder="search" name="search">
                <i class="fa fa-search w3-button w3-right"style="margin-top:20px;margin-right: 10px"></i>
            </form>
        </div>
        <div class="w3-container ">
        
        	
        		<div class="w3-col " style=" width:250px">
                	<h4 class="w3-center">Your Daily Task</h4>
                	<c:forEach items="${note_list}" var="s">
                		<div class="w3-round w3-card">
                		<button onclick="myFunction('${s.slno}')" class="w3-btn w3-block " style="background-color: LightGray"><h6 style="font-weight: bold;color: teal" class="w3-center">${s.notename}</h6><i class="fa fa-angle-double-down"></i></button>
						<div id="${s.slno}" class="w3-container w3-hide">  						
                			<label style="font-size: x-small;font-weight: bold;">Start Date: ${s.startdate}</label><br>
                			<label style="font-size: x-small; font-weight: bold;">End Date: ${s.enddate}</label>
						</div>
                		
                		<br>
                	</div>
                	<br>
                    	
                	
                	</c:forEach>
            	</div>
        	
        	
            
            <div class="w3-rest">
            
            
            <div class="w3-row w3-teal w3-round w3-card w3-margin">
                    
              <div id="notenote" class="w3-row w3-teal w3-round w3-card w3-margin">
            			<h2 class="w3-center w3-white w3-margin">No Notes</h2>
            		</div>
             
            <c:forEach items="${note_list}" var="s">
            	<c:if test="${s.notename!=null}">
            		
           			<style>#notenote{display: none}</style>
            	</c:if>
            	
            	<div class="w3-row w3-white w3-round  w3-card w3-margin">
            	
                    <label class="w3-left w3-margin">${s.notename}</label>
                    <label class="w3-left w3-margin">Start Date: ${s.startdate}</label>
                    <label class="w3-card w3-green w3-round w3-left w3-margin">${s.status}</label>
                    
                   
	               	
                    
                   <button class="w3-button w3-mobile w3-left w3-row" onclick="myFunction('${s.slno}alldetails')"><i class="fa fa-angle-double-down "></i></button>  
                     <div id="${s.slno}alldetails" class="w3-container w3-hide">
						<table >
						<tr>
							  <td >NoteBook Name:</td>
							  <th>${s.notebook_name}</th>
							  
							</tr>
							<tr>
							  <td >Note Name:</td>
							  <th>${s.notename}</th>
							  
							</tr>
							<tr>
							  <td >Start Date: </td>
							  <th>${s.startdate}</th>
							</tr>
							<tr>
							  <td >End Date: </td>
							  <th>${s.enddate}</th>
							</tr>
							<tr>
							  <td >Reminder Date: </td>
							  <th>${s.remind_date}</th>
							</tr>
							<tr>
							  <td >Status: </td>
							  <th class="w3-green">${s.status}</th>
							</tr>
							<tr>
							  <td >Tag: </td>
							  <th>${s.tag}</th>
							</tr>
							<tr>
							  <td >Description: </td>
							  <th>${s.description}</th>
							</tr>
						</table>
  						
                		<br>
                		
					</div>
                		
                		<br>
                </div>
             </c:forEach>
            </div>
           
                
            </div>
        </div>
        
        
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
    function myFunction(id) 
    {
  	  var x = document.getElementById(id);
  	  if (x.className.indexOf("w3-show") == -1) {
  	    x.className += " w3-show";
  	  } else { 
  	    x.className = x.className.replace(" w3-show", "");
  	  }
  	}
</script>


