package tw.com.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page4")
public class Page4Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int trCount = Integer.parseInt(req.getParameter("trCount"));
		int tdCount = Integer.parseInt(req.getParameter("tdCount"));
		req.setAttribute("trCount", trCount);
		req.setAttribute("tdCount", tdCount);
		req.getRequestDispatcher("page4.jsp").forward(req, resp);
		
		
	}
}
