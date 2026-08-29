package tw.com.web;

public class Item {
	private String itemName;
	private int price;
	public String getItemName() {
		return itemName;
	}
	public int getPrice() {
		return this.price;
	}
	public Item(String name,int price) {
		this.itemName = name;
		this.price = price;
	}
}
