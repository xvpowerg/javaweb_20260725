package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	private final static String[]  foodData = {"漢堡","薯條","炸雞" }; 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		String[] foods = req.getParameterValues("food");
		ArrayList<Product> pList = new ArrayList<>();
		for (String fId : foods) {
			String name = foodData[Integer.parseInt(fId)];
			int count = 0;
			try {
				count = Integer.parseInt(req.getParameter("food_"+fId));
			}catch(Exception ex) {
				
			}		
			Product p1 = new Product(name,count);
			pList.add(p1);			
		}
		HttpSession session =  req.getSession();
		session.setAttribute("pList", pList);
		resp.getWriter().println("<h2>以加入購物車</h2> <a href='view'>預覽購物車</a>");
		
	}
}
