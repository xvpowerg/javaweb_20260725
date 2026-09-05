package tw.com.web;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	private ArrayList<Integer> myList = new ArrayList<Integer>();
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init()!");	
		System.out.println("myList:"+myList.size());
		for(int i =1; i<= 100;i++) {
			myList.add(i);
		}

	}
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Thread Name:"+Thread.currentThread().getName());
		System.out.println("HashCode:"+this.hashCode());
		// TODO Auto-generated method stub
		System.out.println(myList.size());
			
	}
}
