


import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Checker extends HttpServlet {
    HttpSession session;
    mypkg.MockBean tempbean;
    Connection con;
    ResultSet rs,rs1,rs2;
    PreparedStatement ps,ps1,ps2;
  // public static String[] ocheck = new String[5];
  // public static int flag=0;
  // public static int tflag;
  // public static int correct=0;
   //public static String[] idd = new String[5];
 
   int q;
    static int skip=0;
    static int correct=0;
   // public static int[] skip = new int[5];
     ArrayList<Integer> no;
   //public static String check;
    ArrayList<Integer> order; 
    String op1,op2,op3,op4;
    String qr1,qr2;
    String opa,opb; //option a usne choose kiya h or option b correct vala h
    //int sum=0;
  
   

    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        try {

            String e = request.getParameter("hide");
            System.out.println(e);
            if(e.equals("cool"))
            {
                
                 ArrayList<String> opt = (ArrayList<String>)session.getAttribute("opt");
           ArrayList<Integer> order = (ArrayList<Integer>)session.getAttribute("order");
               
           Class.forName("com.mysql.jdbc.Driver");
            System.out.println("++++++++++++++++Loaded Successfully+++++++++++++++++++++++");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            System.out.println("------------------Connected Successfully----------------");
            for(int i=0;i<8;i++){
                
            
                
          String optionchosen = opt.get(i);
            
            System.out.println("option chosen is"+opt.get(i));
            
            
           if(optionchosen.equals("-1")){
               skip++;
            }
            else{
            if(optionchosen.equals("option1")){
             qr1 ="select option1 from noptions where Qid=?";
            }
            else if(optionchosen.equals("option2")){
           qr1 ="select option2 from noptions where Qid=?";
            }
            else if(optionchosen.equals("option3")){
           qr1 ="select option3 from noptions where Qid=?";
            }
            else if(optionchosen.equals("option4")){
            qr1 ="select option4 from noptions where Qid=?";
            }
            
            ps1 = con.prepareStatement(qr1);
            ps1.setInt(1,order.get(i));
            rs1 =  ps1.executeQuery();
            
            rs1.next();
            
            qr2="select Correct from nanswers where Qid=?";
            
            
            ps2 = con.prepareStatement(qr2);
            ps2.setInt(1,order.get(i));
            rs2 =  ps2.executeQuery();
            
            rs2.next();
            
            opa= rs1.getString(1);
            System.out.println("opa is"+ opa);
            opb= rs2.getString(1);
            System.out.println("opb is"+ opb);
            if(opa.equals(opb)){
            correct++;
            }
            
                System.out.println(correct);
            
            
            
            }
           }
            System.out.println("total correct answers are"+correct);
            System.out.println("skips made are"+skip);
            session.setAttribute("skip",skip);
            session.setAttribute("correct",correct);
            response.sendRedirect("result.jsp");
          }
       

          

            String action = request.getParameter("ACTION");

            if ("NEXT".equals(action)) {

                //PrintWriter out= response.getWriter();
                session = request.getSession(true);
                //String id = (String)session.getAttribute("id");
                int nodisp = (int) session.getAttribute("nodisp");
                System.out.println(nodisp);
                String selopt[] = request.getParameterValues("options");
                ArrayList<String> opt = (ArrayList<String>) session.getAttribute("opt");

                if (opt == null) {
                    opt = new ArrayList<String>();
                    for (int i = 1; i <= 8; i++) {
                        opt.add("-1");
                    }
                }

                opt.remove(nodisp - 1);
                if (selopt != null) {
                    opt.add(nodisp - 1, selopt[0]);
                } else {
                    opt.add(nodisp - 1, "-1");
                }
                session.setAttribute("opt", opt);

                System.out.println(opt);
                // int no = (int)session.getAttribute("nodisp");  
                // System.out.println("option selected is"+selopt[0]);//this no will take the number of question displayed on screen
                tempbean = (mypkg.MockBean) session.getAttribute("beandata");
                order = mypkg.MockBean.getOrder();
                int y = tempbean.getQid();
                int index = order.indexOf(y);
                //idd[no-1] = id;

                if (index == 7) {

                    tempbean.setQid(order.get(4));
                    q = order.get(7);

                    session.setAttribute("q", q);
                    session.setAttribute("nocnt", 8);
                    //session.setAttribute("idd",idd);
                    session.setAttribute("order", order);
                    response.sendRedirect("display.jsp");

                } else if (index < 7) {

                    q = order.get(index + 1);
                    tempbean.setQid(q);
                    session.setAttribute("q", q);
                    //System.out.println(q);
                    //session.setAttribute("idd",idd);
                    session.setAttribute("order", order);
                    session.setAttribute("nocnt", index + 2);
                    response.sendRedirect("display.jsp");
                }

                Class.forName("com.mysql.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

                String qr = "select Correct from nanswers where Qid=?";
                String quest = "select * from neasy_amplitude_que where Qid=?";
                String tr = "select * from noptions where Qid=?";

                ps = con.prepareStatement(qr);
                ps1 = con.prepareStatement(quest);
                ps2 = con.prepareStatement(tr);

                ps.setInt(1, q);
                ps1.setInt(1, q);
                ps2.setInt(1, q);

                rs = ps.executeQuery();
                rs1 = ps1.executeQuery();
                rs2 = ps2.executeQuery();

                rs.next();
                rs1.next();
                tempbean.setQuestion(rs1.getString(3));
                if (rs2.next()) {
                    op1 = rs2.getString(2);
                    op2 = rs2.getString(3);
                    op3 = rs2.getString(4);
                    op4 = rs2.getString(5);
                    tempbean.setOption1(op1);
                    tempbean.setOption2(op2);
                    tempbean.setOption3(op3);
                    tempbean.setOption4(op4);
                   // String correct_option = rs.getString(1);
                    //out.println("Correct option is " + correct_option);
                   // String option_chosen = request.getParameter("options");
                    //out.println("Chosen option is" + option_chosen);
                   // ocheck[q - 1] = option_chosen;

                   // if (option_chosen == null) {
                        //skip[q - 1] = 1;

                    //} else if (option_chosen.equals(correct_option)) {
                      //  skip[q - 1] = 0;
                       // correct++;

                  //  }

                }

                // response.sendRedirect("display.jsp");
            } else if ("PREVIOUS".equals(action)) {
                //PrintWriter out = response.getWriter();

                session = request.getSession();
                // String id = (String)session.getAttribute("id");
                String selopt[] = request.getParameterValues("options");
                int nodisp = (int) session.getAttribute("nodisp");
                System.out.println("the current no is" + nodisp);

                ArrayList<String> opt = (ArrayList<String>) session.getAttribute("opt");

                opt.remove(nodisp - 1);
                if (selopt != null) {
                    opt.add(nodisp - 1, selopt[0]);
                } else {
                    opt.add(nodisp - 1, "-1");
                }
                session.setAttribute("opt", opt);

                System.out.println(opt);
                // int no = (int)session.getAttribute("nodisp");  

                // int no = (int)session.getAttribute("nodisp");  
                // System.out.println("option selected is"+selopt[0]);//this no will take the number of question displayed on screen
                //  no = (ArrayList<Integer>)session.getAttribute("no");
                tempbean = (mypkg.MockBean) session.getAttribute("beandata");

                order = mypkg.MockBean.getOrder();

                int y = tempbean.getQid();
                //System.out.println("current qid is"+y);

                //idd[y-1] = id;
                int index = order.indexOf(y);
                // System.out.println("current index is"+index);

                if (index > 0) {
                    q = order.get(index - 1);
                    tempbean.setQid(q);
                    //System.out.println(q);
                    session.setAttribute("nocnt", index);
                    response.sendRedirect("display.jsp");
                } else if (index == 0) {
                    tempbean.setQid(order.get(0));
                    q = order.get(0);
                    // System.out.println(q);
                    session.setAttribute("nocnt", 1);
                    response.sendRedirect("display.jsp");

                }

                Class.forName("com.mysql.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
                String qr = "select Correct from nanswers where Qid=?";
                String quest = "select * from neasy_amplitude_que where Qid=?";
                String tr = "select * from noptions where Qid=?";

                ps = con.prepareStatement(qr);
                ps1 = con.prepareStatement(quest);
                ps2 = con.prepareStatement(tr);
                ps.setInt(1, q);
                ps1.setInt(1, q);
                ps2.setInt(1, q);

                rs = ps.executeQuery();
                rs1 = ps1.executeQuery();
                rs2 = ps2.executeQuery();

                rs.next();
                rs1.next();
                tempbean.setQuestion(rs1.getString(3));
                if (rs2.next()) {
                    op1 = rs2.getString(2);
                    op2 = rs2.getString(3);
                    op3 = rs2.getString(4);
                    op4 = rs2.getString(5);
                    tempbean.setOption1(op1);
                    tempbean.setOption2(op2);
                    tempbean.setOption3(op3);
                    tempbean.setOption4(op4);

                }

              /*  String correct_option = rs.getString(1);
                //out.println("Correct option is " + correct_option);
                String option_chosen = request.getParameter("options");
                //out.println("Chosen option is" + option_chosen);

                if (option_chosen == null) {
                    skip[q - 1] = 1;
                } else if (option_chosen.equals(correct_option)) {
                    skip[q - 1] = 0;
                    correct++;

                }
*/

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

   
}
