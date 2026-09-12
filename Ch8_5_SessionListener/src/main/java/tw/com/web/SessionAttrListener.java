package tw.com.web;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttrListener  implements HttpSessionAttributeListener{
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		Object value = event.getValue();
		System.out.println("attributeAdded:"+name+":"+value);
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		Object value = event.getValue();
		HttpSession session = event.getSession();
		System.out.println("Replaced:"+name+":"+value);
		System.out.println("Replaced:"+session.getAttribute(name));
		
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		Object value = event.getValue();
		System.out.println("Removed:"+name+":"+value);
	}
}
