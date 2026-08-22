package tw.com.web;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, Boolean> fruitChecked = new HashMap();

		fruitChecked.put("0", false);
		fruitChecked.put("1", false);
		fruitChecked.put("2", false);
		
		String[] fruit = req.getParameterValues("fruit");
		HttpSession session = req.getSession();
		session.setAttribute("fruit", fruit);
		for (String id : fruit) {
			fruitChecked.put(id, true);
		}
		session.setAttribute("fruitChecked", fruitChecked);
		
		doGet(req,resp);			
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("order.jsp").
		forward(req, resp);
	}
	
}
