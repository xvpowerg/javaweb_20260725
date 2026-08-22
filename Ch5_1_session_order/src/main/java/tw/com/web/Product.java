package tw.com.web;

public class Product {
	private String name;
	private int count;
	
	public Product(String name,int count) {
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return this.name;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public String toString() {
		return this.name+":"+this.count;
		
	}
	
}
