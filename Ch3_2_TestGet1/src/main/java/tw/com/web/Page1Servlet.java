package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//中文問題也可用它處裡	
	resp.setContentType("text/html;charset=UTF-8");
	PrintWriter out = resp.getWriter();
	out.println("Page1");
	String num = req.getParameter("num");
	int count = Integer.parseInt(num);
	for (int i = 1; i<= count;i++) {
		out.println("<a href='#'>%d</a>".formatted(i));
	}
	out.println("num:"+num);
	}
}
