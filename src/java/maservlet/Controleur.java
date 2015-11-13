package maservlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import souscontroleurs.ControleurInterface;

/**
 * @author pham
 */
public class Controleur extends HttpServlet {

    private HashMap<String, ControleurInterface> mp;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        mp = new HashMap();
        for (Enumeration<String> e = config.getInitParameterNames();
                e.hasMoreElements();) {
            String name = e.nextElement();
            String valeur = config.getInitParameter(name);

            try {
                ControleurInterface ctrl = (ControleurInterface) Class.forName(valeur).newInstance();
                mp.put(name, ctrl);
            } catch (ClassNotFoundException ex) {

            } catch (InstantiationException ex) {

            } catch (IllegalAccessException ex) {

            }
        }
    }

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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String section = request.getParameter("section");
        String url = "/WEB-INF/page01.jsp";
        
        if(section!= null && section.endsWith(".ctrl")){
            ControleurInterface ctrl = mp.get(section);
            url = ctrl.execute(request, response, this);
        }
        
        url = response.encodeURL(url);
        getServletContext().getRequestDispatcher(url).include(request, response);

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
