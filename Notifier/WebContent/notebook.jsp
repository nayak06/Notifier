<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<%
	
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
<style>
h4:hover{
text-decoration: underline;
}
</style>
<body>
    <div >
        <div class="w3-row w3-teal ">
            <div class="w3-sidebar w3-bar-block w3-border-right" style="display:none" id="mySidebar">
                <button onclick="w3_close()" class="w3-bar-item w3-large ">Close X</button>
                <form action="notebook" method="post"> <button type="submit" class="w3-bar-item w3-button w3-black w3-margin" name="action" value="NoteBooks">NoteBooks</button></form>
                <form action="dashboard"> <button type="submit" class="w3-bar-item w3-button w3-black w3-margin">Notes</button></form>
                <form action="edituser"> <button type="submit" class="w3-bar-item w3-button w3-black w3-margin">Edit User</button><input name="action" value="fetch_details" style="display: none"></form>
              </div>
              <!-- Page Content -->
            <div >
                <button class="w3-button w3-xlarge" onclick="w3_open()"><i class="fa fa-bars"></i></button>
                
                <label class="w3-right w3-button" onclick="document.getElementById('id01').style.display='block'" style="margin-top:5px;margin-right: 10px;">NEW NOTEBOOK</label>
                <div id="id01" class="w3-modal">
                    <div class="w3-modal-content">
                      <div class="w3-container ">
                        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright" style="color: black;">&times;</span>
                        <h2 class="w3-center" style="color: black;">ADD NOTEBOOK</h2>
                        <form action="notebook" method="post">
                            <input class="w3-input w3-border" type="text" placeholder="NoteBook Name" name="notebookname" required>
                            <button class="w3-button w3-teal w3-round w3-margin" type="submit" name="action" value="Add_NoteBook">Add NoteBook</button>
                        </form>
                      </div>
                    </div>
                  </div>
            </div>
        </div>

        <div class="w3-row">
            <h2 class="w3-left">NoteBooks</h2>
            <form class="w3-right">
                <input style="margin-top:20px;margin-right: 10px" type="text" placeholder="search" name="search">
                <i class="fa fa-search w3-button w3-right"style="margin-top:20px;margin-right: 10px"></i>
            </form>
        </div>
        <div  class="w3-row w3-teal w3-round w3-card w3-margin">
            <div id="notenote" class="w3-row w3-teal w3-round w3-card w3-margin">
            			<h2 class="w3-center w3-white w3-margin">No Notes</h2>
            		</div>
        	 
        	  
            <c:forEach items="${notebook_list}" var="s">
    		<c:if test="${s.notebook_name!=null}">
            		
           			<style>#notenote{display: none}</style>
            	</c:if>
    	<div class="w3-row w3-white  w3-card w3-margin">
    		  <form action="note_entry">
    		  		<button type="submit" style="background-color: transparent;border: none; cursor: pointer;" class="w3-left "><h4 class="w3-bold w3-margin-left ">${s.notebook_name}</h4></button>
              		<input name="notebook_name" value="${s.notebook_name}" style="visibility: hidden">
              		
              </form>
              <form action="notebook" method="post">
               		<span class="w3-right"><button onclick="check_delete()" type="submit" style="background-color: transparent;border:none" name="action" value="delete"><i class="fa fa-close w3-button w3-right"style="margin-right: 10px">delete</i> </button></span>
               		<input name="notebookname" value="${s.notebook_name}" style="visibility: hidden"></input>
               		
               </form>
               
               <form action="notebook" method="post" >
	           		<span class="w3-right"><button type="submit" style="background-color: transparent;border:none" name="action" value="change_notebookname" onclick="document.getElementById('id02').style.display='block'"><i class="fa fa-edit w3-button w3-right" style="margin-right: 10px">Edit</i></button></span>
	               	
	           		<input name="notebookname" value="${s.notebook_name}" style="visibility: hidden"></input>
	                	
	           </form> 
	               	
	                 
                 
               <label class="w3-row">${s.count} notes</label>
             
           </div>
    		</c:forEach>
    		
    	
           
           
           
        </div>
        
    </div>
    
    <div>
    	
    
    	
    	
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
    
    
    </script>
