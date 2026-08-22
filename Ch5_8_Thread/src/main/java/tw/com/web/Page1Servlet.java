package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//session 製作count累加 ? 作業
		HttpSession session =  req.getSession();
		Object countObj = session.getAttribute("count");
		int count  = session.getAttribute("count") == null ?0 : (Integer)countObj;
		
		count++;
		PrintWriter out =  resp.getWriter();
		out.println("hashCode:"+this.hashCode());
		out.println("Threda Name:"+Thread.currentThread().getName());
		out.println("count:"+count);
	}
}
