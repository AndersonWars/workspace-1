package br.com.renan.andrade.util;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import br.com.renan.andrade.domain.*;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Usuario user = null;
        HttpSession sess = ((HttpServletRequest)request).getSession(false);
        
        if (sess != null){
              user = (Usuario) sess.getAttribute("usuarioLogado");
        }      

        if (user == null) {
           String contextPath = ((HttpServletRequest)request).getContextPath();
           ((HttpServletResponse) response).sendRedirect(contextPath + "/templates/login.xhtml");
        } else {
              chain.doFilter(request, response);
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
