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
			HttpSession session = req.getSession();
			Student st1 = (Student)session.getAttribute("student");
			PrintWriter out =  resp.getWriter();
			
			if (st1 == null) {
				out.println("Page2");
			}else {
				out.println("Page2:"+st1);
			}
			
		}
}
