package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.com.db.MySqlUser;
import tw.com.db.PasswordUtil;
import tw.com.db.UserDao;
@WebServlet("/regisrter")
public class RegisrterServlet extends HttpServlet  {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acc = req.getParameter("account");
		String pass = req.getParameter("password");
		try {
			pass = PasswordUtil.hash(pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} 
		UserDao userDao = new MySqlUser();
		boolean regisrter = userDao.regisrter(acc, pass);
		PrintWriter out =  resp.getWriter();
		if (regisrter) {
			resp.sendRedirect("login.html");
		}else {
			out.print("Faill");
		}
		
	}
}
