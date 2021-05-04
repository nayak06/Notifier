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
        <div class="w3-modal-content">
            <div class="w3-margin">
	               	<h2 class="w3-center" style="color: black;">EDIT NOTE(Rewrite all values)</h2>
                        <form action="edit_note" method="post">
                            <label style="color: black;" >Note Name</label><br>
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

                            <button class="w3-button w3-teal w3-round w3-margin" type="submit">Edit Note</button>
                        </form>                       
	              	</div>
	              	</div>	
    </div>                
               
</body>
</html>