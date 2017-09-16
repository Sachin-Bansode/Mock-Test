<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
        <%
        Boolean b = false;

        session.setAttribute("boo",b);
       /* ArrayList<Integer> no =new ArrayList<Integer>();
        no.add(1);
        no.add(2);
        no.add(3);
        no.add(4);
        no.add(5);
        session.setAttribute("no",no);
        */   
        %>


<html>
    <head>




        <title>MOCK TEST </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="images/logo.ico" />
		<link href="https://fonts.googleapis.com/css?family=Lato:100" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600" rel="stylesheet">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <link rel="stylesheet" type="text/css" href="css/ab.css">
       <script>
			$(document).ready(function(){
			  // Add smooth scrolling to all links
			  $(".nav a").on('click', function(event) {

			    // Make sure this.hash has a value before overriding default behavior
			    if (this.hash !== "") {
			      // Prevent default anchor click behavior
			      event.preventDefault();

			      // Store hash
			      var hash = this.hash;

			      // Using jQuery's animate() method to add smooth page scroll
			      // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
			      $('html, body').animate({
			        scrollTop: $(hash).offset().top
			      }, 800, function(){
			   
			        // Add hash (#) to URL when done scrolling (default click behavior)
			        window.location.hash = hash;
			      });
			    } // End if
			  });
			});
		</script>

    </head>
        

       <body>
		<div class="wrap">
			<div class="nav">
		        <a href="#home">Home</a>
		        <a href="#about">About</a>
		        <a href="#contact">Contact</a>
		        <a href="#" class="register" style="float: right; padding: .5vw;">
		            <div class="reg">
		                <h1>Register</h1>
		            </div>
		        </a> 
			</div>	

			<div class="head" id="home">
				<h1>ONLINE MOCK TEST</h1>
				<h2>This Test is to check your Aptitude Accumen</h2> 
				<form action="Contoller" method="post">
				<button type="submit" class="button button1">Begin Test</button>
				</form>
			</div> 
		</div>

		<div class="about" id="about">
			<h1>About</h1>   
		 	<p>This is a Brain Storming Mock Test which is Going To Test One's Caliber On The Basis Of Aptitude.The Test Also Generates Score Card And View The Mistakes One Has Commited During The Test. </p>
		</div>

		<div id="contact" class="contact-section about-section">
		    <div class="contact-subparts">
		        <h1 class="heading">Contact</h1>
		        <p>0731-4259500<br><a href="http://www.medicaps.ac.in" target="_blank">info@medicaps.ac.in</a></p>
		    </div>
		    
		    <div class="contact-subparts">
		        <h1 class="heading">Address</h1>
		        <p>Medicaps University<br>Indore, Madhya Pradesh<br>453331</p>
		    </div>
		    
		    <div class="contact-subparts">
		        <h1 class="heading">Follow Us:</h1>
		        <a href="" target="_blank"><img src="images/insta.png"></a>
		        <a href="" target="_blank"><img src="images/facebook.png"></a>
		    </div>
		</div>

		<div class="footer">
		    <div class="left">
		        <h1>Designed By:<br><a href="" target="_blank">Shivangi Bodh</a></h1>
		    </div>
		
		    <div class="right">
			    <h1>All Rights Reserved.<br></h1>
		    </div>
		</div>
</body>

</html>
