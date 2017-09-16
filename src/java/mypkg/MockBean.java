package mypkg;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Random;
import java.sql.*;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public  class MockBean {
    public java.sql.Connection con;
    public HttpServletRequest request;
    private int qid;
    private String question,option1,option2,option3,option4,Correct;
    private static ArrayList<Integer> order =new ArrayList<Integer>();
    //private static boolean present[]= new boolean[5];
    public boolean create=true;
    MockBean bean;
    HttpSession session;
    
    static int i=0;

    public static ArrayList<Integer> getOrder() {
        return order;
    }

    public static void setOrder(ArrayList<Integer> order) {
        MockBean.order = order;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
    
    
   
    

   

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrect() {
        return Correct;
    }

    public void setCorrect(String Correct) {
        this.Correct = Correct;
    }
    public void orderhandler()
    {
        for (int i=1; i<9; i++) {
            order.add(new Integer(i));
        }
        Collections.shuffle(order);
        setOrder(order);
        
    }
   
    public void processDataforEasy()
    {
        try
        {
           int code=0;
           // int code=orderhandler();
            if(i<8)
            {
             code=order.get(i++);
             setQid(code);
             
            }
          
           Class.forName("com.mysql.jdbc.Driver");
            System.out.println("------------------loaded-----------------");
          con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
          System.out.println("------------------connected-----------------");
           String qr="select * from neasy_amplitude_que where Qid=?";
           String tr="select * from noptions where Qid=?";
           java.sql.PreparedStatement ps = con.prepareStatement(qr);
           java.sql.PreparedStatement ts = con.prepareStatement(tr);
           ps.setInt(1,code);
           ts.setInt(1,code);
           ResultSet ps1 = ps.executeQuery();
           ResultSet ts1 = ts.executeQuery();
           if(ps1.next());
           setQuestion(ps1.getString(3));
           System.out.println("---------------"+question+"-------------------");
           if(ts1.next())
           {
           option1=ts1.getString(2);
           option2=ts1.getString(3);
           option3=ts1.getString(4);
           option4=ts1.getString(5);
           }
           }
        catch(Exception e){
        System.out.println(e);}
    }
}

