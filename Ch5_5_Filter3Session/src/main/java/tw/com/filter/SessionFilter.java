package tw.com.filter;

import java.io.IOException;
import java.time.LocalDateTime;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@WebFilter("/*")
public class SessionFilter implements Filter {
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpReq = (HttpServletRequest)arg0;
		HttpSession session =  httpReq.getSession();
		LocalDateTime now = LocalDateTime.now();
		session.setAttribute("time", now.toString());
		arg2.doFilter(arg0, arg1);
	}
}
