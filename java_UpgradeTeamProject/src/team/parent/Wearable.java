package team.parent;

public class Wearable {
	String name;
	String color;
	int price;
	int qnt;
	
	
	public Wearable(String name, String color, int price) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
	}

	public Wearable() {}
	
	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public int getPrice() {
		return price;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public int getQnt() {
		return qnt;
	}
	
	
}
