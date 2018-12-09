package team.child;

import team.parent.Wearable;

public class Cloth extends Wearable{
	private char gender;

	public Cloth(String name, String color, int price, char gender) {
		super(name, color, price);
		this.gender = gender;
	}

	public char getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Cloth";
	}

}
