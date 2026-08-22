package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/view")
public class ViewOrder extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out =  resp.getWriter();
		HttpSession session =  req.getSession();
		ArrayList<Product> pList = (ArrayList)session.getAttribute("pList");
		out.println("<ol>");
		for(Product  p : pList) {
			out.println("<p>");
			out.println("品名:"+p.getName());
			out.println("數量:"+p.getCount());
			out.println("</p>");
		}
		
		out.println("</ol>");
	}
}
