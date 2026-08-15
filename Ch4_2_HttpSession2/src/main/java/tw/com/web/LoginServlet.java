package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String accountDB = "qwer";
			String pwdDB = "12345";
			resp.setContentType("text/http;charset=utf-8");
			PrintWriter out =  resp.getWriter();
			String account = req.getParameter("account");
			String pwd = req.getParameter("pwd");
			HttpSession session =  req.getSession();
			if (accountDB.equals(account) && pwdDB.equals(pwd)) {
				out.println("登入成功");
				session.setAttribute("account", account);
			}else {
				out.println("登入失敗");
			}
		
		}
}
