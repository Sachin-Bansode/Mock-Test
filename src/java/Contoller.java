/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kunika
 */
public class Contoller extends HttpServlet {

   HttpSession session;
   boolean boolcheck ;
    mypkg.MockBean bean;
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            PrintWriter out = response.getWriter();
          
          
           session= request.getSession();
           
          boolcheck = (Boolean)session.getAttribute("boo");
          if(boolcheck == false)
          {
              bean = new mypkg.MockBean();
              bean.orderhandler();
              boolcheck=true;
              session.setAttribute("boo",boolcheck);
              session.setAttribute("beandata",bean);
             
              
              
          }
          else
          {
              bean=(mypkg.MockBean)session.getAttribute("beandata");
              
          }
          
          bean.processDataforEasy();
          session.setAttribute("beandata",bean);
          System.out.println("que"+bean.getQuestion());
          response.sendRedirect("display.jsp");
          }
        catch(Exception e){}
    }
               
        

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
