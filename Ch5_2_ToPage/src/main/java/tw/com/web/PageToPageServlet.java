package tw.com.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page_to_page")
public class PageToPageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		resp.getWriter().print("PageToPage:"+id);
		switch(id) {
		case "1":
			resp.sendRedirect("page1.html");
			break;
		case "2":
			resp.sendRedirect("page2.html");
			break;
		case "3":
			resp.sendRedirect("page3.html");
			break;	
		}
		
	}
}
