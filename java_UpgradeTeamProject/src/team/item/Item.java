package team.item;

public class Item {
	String name;
	int qn;//quantity
	String brandName;
	
	public Item(String name, int qn, String brandName) {
		super();
		this.name = name;
		this.qn = qn;
		this.brandName = brandName;
	}

	public String getName() {
		return name;
	}

	public int getQn() {
		return qn;
	}

	public void setQn(int qn) {
		this.qn = qn;
	}

	public String getbrandName() {
		return brandName;
	}
}
