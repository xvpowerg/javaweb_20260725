package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/page2")
public class Page2Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/http;charset=utf-8");
		PrintWriter out = 	 resp.getWriter();
		HttpSession session =  req.getSession();
		String account = (String)session.getAttribute("account");
		if (account != null) {
			out.println("你登入成功可以看到我了");
		}else {
			out.println("尚未登入 登入了才看的到我!");	
		}
		
	}
}
