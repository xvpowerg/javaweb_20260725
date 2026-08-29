package tw.com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Item item = new Item("Item1",100);
		req.setAttribute("item1", item);
		
	 	HttpSession session =   req.getSession();
	 	ArrayList<User> userList = new ArrayList<>();
	 	userList.add(new User("User1",21));
	 	userList.add(new User("User2",22));
	 	userList.add(new User("User3",16));
	 	userList.add(new User("User4",25));
	 	
	 	session.setAttribute("userList", userList);
	 	Map<String,User> userMap =  new HashMap<>(); 
	 	userMap.put("user1", new User("user1",17));
	 	userMap.put("my user2", new User("user2",25));
	 	ServletContext app = this.getServletContext();
	 	app.setAttribute("userMap", userMap);
	 	
	 	req.getRequestDispatcher("page1.jsp").forward(req, resp);
		
	}
}
