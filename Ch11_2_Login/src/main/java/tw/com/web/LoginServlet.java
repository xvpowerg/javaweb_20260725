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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
		boolean login = userDao.login(acc, pass);
		PrintWriter out =  resp.getWriter();
		if (login) {
			out.print("Pass");
			//作業
			//紀錄session 說誰登入成功
			//回到jsp 顯示是誰登入
		}else {
			out.print("Faill");
		}
		
	}
}
