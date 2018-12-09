package team.child;

import team.parent.Wearable;

public class Shoes extends Wearable{
	private int size;

	public Shoes(String name, String color, int price, int size) {
		super(name, color, price);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "Shoes";
	}
}
