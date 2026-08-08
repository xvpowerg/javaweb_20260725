package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Optional;
@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =  resp.getWriter();
		out.println("Page1");
		String idStr = req.getParameter("id");
		out.println(idStr);
		int id = -1;
		Optional<String> idOption = Optional.ofNullable(idStr);
		if (idOption.isPresent()) {
			id = Integer.parseInt(idOption.get());
		}
	
		String action = req.getParameter("action");
		out.println("id:"+id+" action:"+action);
	}
}
