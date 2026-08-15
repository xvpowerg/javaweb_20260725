package tw.com.beans;

public class Food {
	private String id;
	private String name;
	private int price;
	
	public Food(String id,String name,int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
	public String getName() {
		return this.name;
	}
	public String toString() {
		return this.id+":"+this.name;
	}
}
