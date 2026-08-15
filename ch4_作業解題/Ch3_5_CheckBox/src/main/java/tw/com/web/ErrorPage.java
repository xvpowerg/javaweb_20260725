package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/error_page")
public class ErrorPage  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =  resp.getWriter();
		out.println("Error Page<br>");
		ArrayList<String> errorFoods =  (ArrayList)req.getAttribute("error_foods");
		for (String errorfood : errorFoods) {
			out.println(errorfood+"<br>");
		}
		out.println("以上餐點請選數量");
	}
}
