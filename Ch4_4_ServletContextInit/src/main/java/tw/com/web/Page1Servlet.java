package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext app = 	this.getServletContext();
		String dbAcc = app.getInitParameter("db_acc");
		String dbPwd = app.getInitParameter("db_pwd");
		PrintWriter out = resp.getWriter();
		out.println(dbAcc+":"+dbPwd);
	}
}
