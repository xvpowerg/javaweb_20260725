package tw.com.ewb;

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
	PrintWriter out = resp.getWriter();
	out.println("<!DOCTYPE html>\r\n"
			+ "<html>\r\n"
			+ "<head>\r\n"
			+ "<meta charset=\"UTF-8\">\r\n"
			+ "<title>9x9</title>\r\n"
			+ "</head>\r\n"
			+ "<body>");
	out.print("<table border='1'>");
	
	for(int i =2; i<=9 ;i++) {
		out.print("<tr>");
		for(int k = 1; k<=9;k++) {
			out.print("<td>%d*%d=%d</td>".formatted(i,k,i*k));
		}
			
		
	   out.print("</tr>");
	}
	
	out.print("</table>");
	out.print("</body>\r\n"
			+ "</html>");
	
	}
}
