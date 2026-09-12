package tw.com.web;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestListener {
		@Override
		public void requestInitialized(ServletRequestEvent sre) {
			// TODO Auto-generated method stub
			System.out.println("requestInitialized");
		}
		@Override
		public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
			System.out.println("requestDestroyed");
		}
}
