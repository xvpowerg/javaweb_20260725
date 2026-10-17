package tw.com.web;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.com.ejb.MyUserBeanLocal;
import tw.com.jpa.MyUser;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
		@Inject
		private EntityManager em;
		
		@EJB
		private MyUserBeanLocal myUserBean;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			resp.getWriter().println("Page1");
			MyUser myUser = new MyUser();
			myUser.setAccount("ken");
			myUser.setPassword("123456");
			boolean b1 = myUserBean.regisrter(myUser);
			resp.getWriter().println("Page1:"+b1);
			
			MyUser myUser2 = myUserBean.findUserByAccount("ken", "123456");
			System.out.println(myUser2);
			
			myUser2.setAccount("iris");
			boolean updateUser =  myUserBean.updateUser(myUser2);
			System.out.println(updateUser);
			
			boolean delUser= myUserBean.deleteUser(myUser2);
			System.out.println(delUser);
			
		}

}
