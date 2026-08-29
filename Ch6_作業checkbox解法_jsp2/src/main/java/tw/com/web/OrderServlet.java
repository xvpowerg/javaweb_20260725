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
	
	private void setFruitsSession(HttpServletRequest req,String[] fruits ) {
		HttpSession session = req.getSession();		

		HashMap<String, Boolean> fruitChecked  = new HashMap<>();
		fruitChecked  = new HashMap<>();
		fruitChecked.put("0", false);
		fruitChecked.put("1", false);
		fruitChecked.put("2", false);
		if (fruits != null) {
			
			for (String id : fruits) {
				fruitChecked.put(id, true);
			}		
			
		}
		session.setAttribute("fruitChecked", fruitChecked);				
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getSession().getAttribute("fruitChecked") == null){
			setFruitsSession(req,null);	
		}
		
		req.getRequestDispatcher("order.jsp").
		forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String[] fruits = req.getParameterValues("fruit");
		System.out.println("fruits:"+fruits);
		setFruitsSession(req,fruits);
		doGet(req,resp);			
	}

	
}
