package tw.com.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("name");
		//Request Attribute 存活時間 一個頁面(page)
		//主要用於短時間的顯示
		int score =Integer.parseInt(req.getParameter("score")) ;
		Student st1 = new Student(name,score);
		req.setAttribute("st", st1);
		req.getRequestDispatcher("/page2").forward(req, resp);
	}
}
