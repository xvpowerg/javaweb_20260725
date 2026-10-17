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

@WebServlet("/regisrter")
public class RegisrterServlet extends HttpServlet {
	@EJB
	private MyUserBeanLocal myUserBean;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =  resp.getWriter();
		String acc = req.getParameter("account");
		String pwd = req.getParameter("password");
		MyUser myuser = new MyUser();
		myuser.setAccount(acc);
		myuser.setPassword(pwd);
		boolean regisrter = myUserBean.regisrter(myuser);
		if (regisrter) {
			out.println("Pass");
		}else {
			out.println("Faill");
		}
	}
}
