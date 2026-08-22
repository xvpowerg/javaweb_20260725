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
		PrintWriter out =  resp.getWriter();
		String count = req.getParameter("count");
		int intCount = Integer.parseInt(count);
		out.println("<html>");
		out.println("<body>");
		out.println("<ul>");
		for (int i =1; i<= intCount;i++) {
			out.println("<li>");
			out.println(i);
			out.println("</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}
}
