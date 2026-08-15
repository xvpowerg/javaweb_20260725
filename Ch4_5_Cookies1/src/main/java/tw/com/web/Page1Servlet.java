package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =  resp.getWriter();
		out.println("Page1");
		LocalDateTime now = LocalDateTime.now();
		Cookie cookie1 = new Cookie("datatime",now.toString());
		resp.addCookie(cookie1);
		//req.getCookies()
		
	}
}
