package tw.com.web;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/page3")
public class Page3Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//透過page3 接收一個trCount = 3 tdCount = 5
		HttpSession session =  req.getSession();
		session.setAttribute("sessionValue", "page3 Session");
		ServletContext app = getServletContext();
		app.setAttribute("appValue", "Page3 app");
		req.getRequestDispatcher("page3.jsp").forward(req, resp);
		
	}
}
