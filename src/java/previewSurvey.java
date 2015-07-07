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
@WebServlet(urlPatterns = {"/previewSurvey"})
public class previewSurvey extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            
            String contact = "N/A";
            if (!"".equals(request.getParameter("contact")))
                contact = request.getParameter("contact");
            
            String musicPref[] = {"None"};
            if (request.getParameterValues("musicPref")!=null)
                musicPref = request.getParameterValues("musicPref");
            
            String musicSpot[] = {"None"};
            if (request.getParameterValues("musicSpot")!=null)
                musicSpot = request.getParameterValues("musicSpot");
            
            String musicDay = request.getParameter("musicDay");
            String musicDec = request.getParameter("musicDec");
            String musicFreq = request.getParameter("musicFreq");
            
            String comments = "No Comments";
            if (!"".equals(request.getParameter("comment")))
                comments = request.getParameter("comment");
            
            boolean isSubscribe = false;
            if (request.getParameter("isSubscribe")!=null)
                isSubscribe = true;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Preview Survey</title>");            
            out.println("</head>");
            out.println("<body>");

            out.println("<table align='center'>");
            out.println("<tr>");
                out.println("<td class = 'text-right'> Name : </td>");
                out.println("<td>" + name + "</td>");
            out.println("</tr><tr>");
                out.println("<td class = 'text-right'> E-mail : </td>");
                out.println("<td>" + email + "</td>");
            out.println("</tr><tr>");
                out.println("<td class = 'text-right'> Contact No : </td>");
                out.println("<td>" + contact + "</td>");
            out.println("</tr><tr>");
                out.println("<td class = 'text-right'> Preferred Day : </td>");
                out.println("<td>" + musicDay + "</td>");
            out.println("</tr><tr>");
                out.println("<td class = 'text-right'> Frequency : </td>");
                out.println("<td>" + musicFreq + "</td>");
            out.println("</tr><tr>");
                out.println("<td class = 'text-right'> Fav Decade : </td>");
                out.println("<td>" + musicDec + "</td>");
            out.println("</tr><tr>");
                out.println("<td class = 'text-right'> Musical Pref : </td>");
                out.println("<td>");
                    for (String a:musicPref){
                        out.println(a + "<br>");
                    }
                out.println("</td>");
            out.println("</tr><tr>");
                out.println("<td class = 'text-right'> Pref Place : </td>");
                out.println("<td>");
                    for (String a:musicSpot){
                        out.println(a + "<br>");
                    }
                out.println("</td>");
            out.println("</tr><tr>");
                out.println("<td class = 'text-right'> Comments : </td>");
                out.println("<td>" + comments + "</td>");
            out.println("</tr><tr>");
                out.println("<td class = 'text-right'> Sub to Newsletter : </td>");
                out.println("<td>" + isSubscribe + "</td>");
            out.println("</tr><tr>");
            out.println("</table>");
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
