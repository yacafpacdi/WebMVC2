package souscontroleurs;

import java.io.Serializable;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VersPage03 implements ControleurInterface, Serializable{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        
        String s = "dans VersPage03";
        request.setAttribute("msg", s);
        return "/WEB-INF/page03.jsp";  
    
    }
    
}
