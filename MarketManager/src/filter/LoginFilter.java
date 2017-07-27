package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String url=((HttpServletRequest)request).getRequestURI();
		if(url.indexOf("login")>=0||url.indexOf("center")>=0||url.indexOf("js")>=0||url.indexOf("css")>=0||url.indexOf("images")>=0){
			chain.doFilter(request, response);
		}else{
			if(((HttpServletRequest)request).getSession().getAttribute("user")==null){
				((HttpServletResponse)response).sendRedirect("center.jsp");
			}else{
				chain.doFilter(request, response);
			}
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}


	

}
