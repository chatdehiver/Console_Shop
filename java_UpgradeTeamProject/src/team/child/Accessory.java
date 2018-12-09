package team.child;

import team.parent.Wearable;

public class Accessory extends Wearable{
	private String jewelry;
	private int qnt;

	public Accessory(String name, String color, int price, String jewelry) {
		super(name, color, price);
		this.jewelry = jewelry;
	}

	public String getJewelry() {
		return jewelry;
	}

	@Override
	public String toString() {
		return "Accessory";
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
	
}
