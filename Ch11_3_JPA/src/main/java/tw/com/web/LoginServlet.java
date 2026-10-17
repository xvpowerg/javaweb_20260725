package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.com.ejb.MyUserBeanLocal;
import tw.com.jpa.MyUser;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@EJB
	private MyUserBeanLocal myUserBean;
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			PrintWriter out =  resp.getWriter();
			String acc = req.getParameter("account");
			String pwd = req.getParameter("password");
			MyUser myUser = new MyUser();
			myUser.setAccount(acc);
			myUser.setPassword(pwd);
			boolean login = myUserBean.login(myUser);
			if (login) {
				System.out.println("Login Pass");				
			}else {
				System.out.println("Login Fail");
			}
			
		}
}
