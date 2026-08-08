package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private void showValue(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");	
		PrintWriter out = 	resp.getWriter();
		String account = req.getParameter("account");
		String pwd = req.getParameter("pwd"); 
		out.println("帳號:"+account);
		out.println("<br>");
		out.println("密碼:"+pwd);
		//帳號:qwer
		//密碼:123456
		out.println("Login");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		showValue(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		showValue(req,resp);
	}
}
