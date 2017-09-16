
<%@page import="java.util.ArrayList"%>
<jsp:useBean id= "beandata" class= "mypkg.MockBean" scope="session"/>
<%@page import="mypkg.MockBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! 
   public static int no =1;
   public static Boolean nocheck=false;
   String h ="xyz";
   String t;
  
  
   
%>
 <%   if(nocheck== false)
      {
          nocheck=true;
         t ="";
        session.setAttribute("nodisp",1);
      }
      else{
       no = (int)session.getAttribute("nocnt");
       
        session.setAttribute("nodisp",no);
         nocheck=true;
         ArrayList<String> opt = (ArrayList<String>)session.getAttribute("opt");
         t = opt.get(no-1);
             if(t == "-1"){t ="";}
      }
%>
<html>
    <head>
        <title>Mock Test</title>
        <link rel="stylesheet" href="quedisp.css">
    </head>
    <body>
        <form action="Checker" method="get">
            <pre>                                                                                    <button type="submit" onclick="fun()"> Submit Your Test </button>
             <strong>Question</strong><%=no%> <jsp:getProperty name="beandata" property="question"/>
            A)  <input type="radio" name="options" id="option1" value="option1"><jsp:getProperty name="beandata" property="option1"/>
            B)  <input type="radio" name="options" id="option2" value="option2"><jsp:getProperty name="beandata" property="option2"/>
            C)  <input type="radio" name="options" id="option3" value="option3"><jsp:getProperty name="beandata" property="option3"/>
            D)  <input type="radio" name="options" id="option4" value="option4"><jsp:getProperty name="beandata" property="option4"/>
                <input type="hidden" name="hide" id="hiddenField"/>                                                            <input type="reset" value="Reset"/>

               <button type="submit"  value="PREVIOUS" name="ACTION">PREVIOUS</button>              <button type="submit"  value="NEXT" name="ACTION">NEXT</button>         
            </pre>
        </form> 
            <script>
                var e = '<%=t%>';
                document.getElementById(e).checked = "true";
                function fun()
                {
                document.getElementById("hiddenField").value = 'cool';
                }
                </script>
    </body>
</html>

             
 