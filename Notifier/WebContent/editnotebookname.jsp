<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta charset="ISO-8859-1">
</head>
<body class="w3-black">
    <div class="w3-container">
        
	               	<form action="notebook" method="post">
		                    <div class="w3-modal-content">
		                      <div class="w3-container ">
		                        <br><br><br><br><br>
		                        <h2 class="w3-center" style="color: black;">CHANGE NOTEBOOK NAME</h2>
		                        <br><br><br><br>
		                            <input class="w3-input w3-border" type="text" placeholder="NoteBook Name" name="new_notebookname" required>
                                    <br><br><br>
		                            <button class="w3-button w3-teal w3-round w3-margin-bottom w3-display-bottommiddle" type="submit" name="action" value="edit_notebookname">Change NoteBook Name</button>
		                            <br><br><br><br>
                                    
		                            
		                        	
		                      </div>
	                    </div>
                    </form>
	              		
    </div>                
               
</body>
</html>
