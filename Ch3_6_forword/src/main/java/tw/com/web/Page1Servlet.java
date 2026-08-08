package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req.getRequestDispatcher("/page2").forward(req, resp);
		String page = req.getParameter("page");
		PrintWriter out =  resp.getWriter();
		if (page != null) req.getRequestDispatcher(page).forward(req, resp);
		out.println("Page1");
	}
}
