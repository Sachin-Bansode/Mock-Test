

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% int skip = (Integer)session.getAttribute("skip");
   int correct = (Integer)session.getAttribute("correct");
%>
<!DOCTYPE html>
<html>
    <head>
       <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600|Roboto:100,300,400,500" rel="stylesheet">
        <link rel="stylesheet"  href="css/style.css">

        <title>RESULT</title>
        <script type="text/javascript">
		$(document).ready(function(){
			$(".bar").addClass("demo");

			var i = 1;                     													

			function myLoop () {           													
			   setTimeout(function () {    													
			      document.getElementById("value").innerHTML = i+"%";         				
			      i++;                     													
			      if (i <=80) {            													
			         myLoop();             													 
			      }                        													
			   }, 40)
			}

			myLoop();  

			$(".left,.right,.center").slideDown("slow");

			$("h2,h3").delay("1000").slideDown("slow");
		});

	</script>


    </head>
    <body>
<div class="head">
	<h1>RESULT</h1>
</div>

<div class="progress">
	<div class="bar">
		
	</div>
</div>

<div class="container">
	<div class="left">
		<h2>Your Score</h2>
		<h3 id="value"></h3>
	</div>
	
	<div class="center">
		<h2>Need to improve</h2>
                <h3>Probability<br>Statistics<br>Percentage</h3>
	</div>

	<div class="right">
		<h2>Correct Answers</h2>
		<h3><%=correct%></h3>
                <h2>Skips Made</h2>
		<h3><%=skip%></h3>
	</div>

</div>
</body>
</html>