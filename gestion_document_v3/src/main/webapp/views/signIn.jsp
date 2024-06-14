<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Sign In</title>
		<link rel="stylesheet" href="css/signIn.css">
		
		<script type="text/javascript">
		    function toggleConfidentialPassword() {
		        var userType = document.getElementById("userType").value;
		        var confidentialPasswordDiv = document.getElementById("confidentialPasswordDiv");
		        if (userType === "admin") {
		            confidentialPasswordDiv.style.display = "block";
		        } else {
		            confidentialPasswordDiv.style.display = "none";
		        }
		    }
		
		    function validateForm() {
		        var userType = document.getElementById("userType").value;
		        if (userType === "admin") {
		            var confidentialPass = document.getElementById("confidentialPass").value;
		            if (confidentialPass !== "1111") {
		                alert("Invalid confidential password. Please try again.");
		                return false;
		            }
		        }
		        return true;
		    }
		</script>
	    <link rel="stylesheet" href="css/signIn.css">
	</head>
	
	<body>
		<header>
	        <h1>Compte Verrouillé</h1>
	    </header>
	
		<main>
		    <div class="container">
		        <div class="form-box">
		            <h2 style="text-align: center;">S'enregistrer</h2>
		            <form action="submitSignIn.do" method="post" onsubmit="return validateForm()">
		                <label for="username">Nom d'utilisateur:</label>
		                <input type="text" id="username" name="username" required><br><br>
		
		                <label for="pass">Mot de passe:</label>
		                <input type="password" id="pass" name="pass" required><br><br>
		
		                <label for="userType">Type d'utilisateur:</label>
		                <select id="userType" name="userType" onchange="toggleConfidentialPassword()" required>
		                    <option value="user">User</option>
		                    <option value="admin">Admin</option>
		                </select><br><br>
		
		                <div id="confidentialPasswordDiv" style="display:none;">
		                    <label for="confidentialPass"> Mot de passe confidentiel:</label>
		                    <input type="password" id="confidentialPass" name="confidentialPass"><br><br>
		                </div>
		
						<%if(request.getAttribute("message")!=null) { %>
							<h4 class="error-message" style="color:red;"><%=request.getAttribute("message") %></h4>
						<%} %>
								
		                <input type="submit" value="S'enregistrer">
		            </form>
		        </div>
		    </div>
		</main>
		
		<footer>
	        <p>&copy; 2024 - Gestion des documents</p>
	    </footer>
	</body>
</html>
