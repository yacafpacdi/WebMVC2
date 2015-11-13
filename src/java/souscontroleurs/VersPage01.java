package souscontroleurs;

import java.io.Serializable;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VersPage01 implements ControleurInterface, Serializable{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String s = "dans VersPage01";
        request.setAttribute("msg", s);
        return "/WEB-INF/page01.jsp";   
    }
    
}
