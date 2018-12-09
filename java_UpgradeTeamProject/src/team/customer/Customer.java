package team.customer;

import team.parent.Wearable;

public class Customer {
	private String name;
	private String addr;
	private int useMoney;
	private int haveMoney;
	Wearable[] wear;

	public Customer(String name, String addr, int useMoney) {
		super();
		this.name = name;
		this.addr = addr;
		this.useMoney = useMoney;
	}


	public void setWear(Wearable[] wear) {
		this.wear = wear;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public int getUseMoney() {
		return useMoney;
	}

	public Wearable[] getWear() {
		return wear;
	}

	public int getHaveMoney() {
		return haveMoney;
	}

	public void setHaveMoney(int haveMoney) {
		this.haveMoney = haveMoney;
	}
	
	
}
