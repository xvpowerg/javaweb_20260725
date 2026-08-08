package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import tw.com.beans.Food;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	HashMap<String,Food> foodMap = new HashMap();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String food = req.getParameter("food");
		Food f1 = new Food("0","雞腿飯",120);
		Food f2 = new Food("1","排骨飯",100);
		Food f3 = new Food("2","魚排飯",110);
		foodMap.put("0", f1);
		foodMap.put("1", f2);
		foodMap.put("2", f3);
		
		resp.setContentType("text/html;charset=utf-8");		
		String[] foods = req.getParameterValues("food");
		PrintWriter out =  resp.getWriter();
		if (foods == null) {
			out.println("請點選則一項餐點");
			return;
		}
		/*
		<input type="checkbox" name="food" value="120">雞腿飯
		<input type="checkbox" name="food" value="100">排骨飯
		<input type="checkbox" name="food" value="110">魚排飯*/

		out.println("Page1");
		int total = 0;
		out.println("<ol>");
		for (String fId : foods) {
			Food f = foodMap.get(fId);
			total += f.getPrice();
			out.println("<li>"+f.getName()+":"+f.getPrice()+"</li>");
			
		}
		out.println("</ol>");
		out.println("訂單總額:"+total);
		
	}
}
