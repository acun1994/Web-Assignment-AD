/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(urlPatterns = {"/gradeCalc"})
public class gradeCalc extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            final double w_final = 30.0/100, w_mid = 30.0/100, w_proj = 40.0/100;
            
            double final_m = Double.parseDouble(request.getParameter("final"));
            double mid = Double.parseDouble(request.getParameter("midterm"));
            double proj = Double.parseDouble(request.getParameter("project"));
            
            double marks = final_m*w_final + mid * w_mid + proj*w_proj;
            
            int point;
            char grade;
            if (marks<60){
                point = 0;
                grade = 'F';
            }
            else if (marks<70){
                point = 1;
                grade = 'D';
            }
            else if (marks<80){
                point = 2;
                grade = 'C';
            }
            else if (marks<90){
                point = 3;
                grade = 'B';
            }
            else{
                point = 4;
                grade = 'A';
            }
            
            boolean isPoint = false;
            boolean isGrade = false;
            
            if (request.getParameter("isPoint")!=null) isPoint = true;
            if (request.getParameter("isGrade")!=null) isGrade = true;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Mark Converter</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.printf(" MidTerm : %.2f/%.2f<br>", mid*w_mid, w_mid*100);
            out.printf(" Final : %.2f/%.2f<br>", final_m*w_final, w_final*100);
            out.printf(" Project : %.2f/%.2f<br>", proj*w_proj, w_proj*100);
            out.printf(" Total Marks : %.2f %s", marks, "% <br>");
            if (isPoint)  out.println(" Point : " + point + "<br>");
            if (isGrade)  out.println(" Grade : " + grade + "<br>");
            if (marks<60)  out.println(" You have failed. ");
            else out.println(" You have passed. ");
            
            out.println("</body>");
            out.println("</html>");
        }
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
