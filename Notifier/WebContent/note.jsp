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
                	<button class="w3-right" type="submit" style="background-color: transparent; border: none; margin-top:5px;color: white;"><i  class="fa fa-sign-out w3-button w3-large">Logout</i></button>
                </form>
                
                <label class="w3-right w3-button" onclick="document.getElementById('id01').style.display='block'" style="margin-top:5px;margin-right: 10px;">NEW NOTE</label>
                <div id="id01" class="w3-modal">
                    <div class="w3-modal-content">
                      <div class="w3-container ">
                        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright" style="color: black;">&times;</span>
                        <h2 class="w3-center" style="color: black;">ADD NOTE</h2>
                        <form action="add_note" method="post">
                            <label style="color: black;">Note Name</label><br>
                            <input class="w3-input w3-border" name="notename" required><br>
                            <label style="color: black;">Start Date</label>
                            <input type="date" id="startdate" name="startdate">
                            <label  style="color: black;">End Date</label>
                            <input type="date" id="enddate" name="enddate">
                            <label style="color: black;">Reminder Date</label>
                            <input type="date" id="reminddate" name="reminddate"><br><br>
                            <label style="color: black;">Status</label><br>
                            <select class="w3-input w3-border" name="status">
                                <option>Started</option>
                                <option>Ended</option>
                                <option>Finished</option>
                            </select><br>
                            <label style="color: black;">Tag</label>
                            <select class="w3-input w3-border" name="tag">
                                <option>Private</option>
                                <option>Public</option>
                            </select><br>
                            <label style="color: black;">Description</label>
                            <textarea placeholder="Write Notes..." class="w3-input w3-border" name="description"></textarea>

                            <button class="w3-button w3-teal w3-round w3-margin" type="submit">Add Note</button>
                        </form>
                      </div>
                    </div>
                  </div>
            </div>
        </div>

        <div class="w3-row">
            <h2 class="w3-left w3-margin-left">Notes</h2>
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
                	<button onclick="myFunction('${s.slno}')" class="w3-btn w3-block" style="background-color: LightGray"><h6 style="font-weight: bold;color: teal" class="w3-center">${s.notename}</h6><i class="fa fa-angle-double-down"></i></button>
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
            	<button class="w3-button" onclick="myFunction('${s.slno}')"></button>
                    <label class="w3-left w3-margin">${s.notename}</label>
                    <label class="w3-left w3-margin">Start Date: ${s.startdate}</label>
                    <label class="w3-card w3-green w3-round w3-left w3-margin">${s.status}</label><br>
                    
                    <form action="delete" method="post">
               				<div class="w3-right"><button onclick="check_delete()" type="submit" style="background-color: transparent;border:none"><i class="fa fa-close w3-button w3-right"style="margin-right: 10px">delete</i> </button></div>
               				<input name="note_slno" value="${s.slno}" style="visibility: hidden"></input>
               		
              		</form>
                    <form action="change_note" method="post" >
	           				<div class="w3-right"><button type="submit" style="background-color: transparent;border:none" ><i class="fa fa-edit w3-button w3-right" style="margin-right: 10px">Edit</i></button></div>
	               	
	           				<input name="note_slno" value="${s.slno}" style="visibility: hidden"></input>
	                	
	           		</form> 
	               	
                    
                   <button class="w3-button w3-mobile" onclick="myFunction('${s.slno}alldetails')"><i class="fa fa-angle-double-down "></i></button>  
                     <div id="${s.slno}alldetails" class="w3-container w3-hide">
						<table >
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
    function w3_open() 
    {
      document.getElementById("mySidebar").style.display = "block";
    }
    
    function w3_close() {
      document.getElementById("mySidebar").style.display = "none";
    }
    if ( window.history.replaceState ) 
    {
    	  window.history.replaceState( null, null, window.location.href );
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
    