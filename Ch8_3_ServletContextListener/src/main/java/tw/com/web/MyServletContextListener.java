package tw.com.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
@WebListener
public class MyServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextInitialized");
		ServletContext context = sce.getServletContext();
		String imagePath = context.getInitParameter("image_path");
		String password = context.getInitParameter("pwd");
		System.out.println("imagePath:"+imagePath);
		System.out.println("password:"+password);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed");
	}
	
}
