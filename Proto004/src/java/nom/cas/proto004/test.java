/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nom.cas.proto004;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author Cristiano
 */
public class test extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            log("caller="+request.getParameter("id"));
            /* TODO output your page here. You may use following sample code. */
            out.println("id="+request.getParameter("id"));
            out.println("block="+request.getParameter("block"));
            out.println("sendTime="+request.getParameter("sendTime"));
            out.println("receivedTime="+Calendar.getInstance().getTimeInMillis());
//            out.println("Received Time:"+SimpleDateFormat.getTimeInstance(DateFormat.LONG).format(Calendar.getInstance().getTime()));
            out.println("Received Time:"+String.format("%1$tH:%1$tM:%1$tS,%1$tL", Calendar.getInstance().getTime()));
            
            if (request.getParameter("sendTime") != null && NumberUtils.isNumber(request.getParameter("sendTime"))) {
//                out.println("Send Time:"+SimpleDateFormat.getTimeInstance(DateFormat.LONG).format(new Date(Long.valueOf(request.getParameter("sendTime")))));
                out.println("Send Time:"+String.format("%1$tH:%1$tM:%1$tS,%1$tL", new Date(Long.valueOf(request.getParameter("sendTime")))));
            }
            long pause = 0;
            if (request.getParameter("block") != null && NumberUtils.isNumber(request.getParameter("block"))) {
                pause = Long.valueOf(request.getParameter("block"));
            }
            
            if (pause == 0) {
                pause = 2500;
            }
            try {
                Thread.currentThread().sleep(pause);
            } catch (InterruptedException ex) {
                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }
//            out.println("Response Time:"+SimpleDateFormat.getTimeInstance(DateFormat.LONG).format(Calendar.getInstance().getTime()));
            out.println("Response Time:"+String.format("%1$tH:%1$tM:%1$tS,%1$tL", Calendar.getInstance().getTime()));
            out.println("responseTime="+Calendar.getInstance().getTimeInMillis());
            out.println("responseTime="+Calendar.getInstance().getTimeInMillis());
            out.println("thread="+Thread.currentThread().getName());
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
