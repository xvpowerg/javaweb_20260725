package tw.com.web;

public class User {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	public User(String name,int age) {
		this.name = name;
		this.age = age;
	}
}
