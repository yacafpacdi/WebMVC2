
package souscontroleurs;

import java.io.Serializable;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VersPage02 implements ControleurInterface, Serializable{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String s = "dans VersPage02";
        request.setAttribute("msg", s);
        return "/WEB-INF/page02.jsp"; 
    }
    
}
