package tw.com.web;

import java.time.LocalDateTime;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class MyUser implements HttpSessionBindingListener {
	private String name;
	public MyUser(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.getName();
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name =  event.getName();
		Object obj = event.getValue();
		System.out.println("valueBound:"+name+":"+obj);
		System.out.println("登入時間:"+ LocalDateTime.now());
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name =  event.getName();
		Object obj = event.getValue();
		System.out.println("valueUnbound:"+name+":"+obj);
		System.out.println("登出時間:"+ LocalDateTime.now());
	}
	
}
