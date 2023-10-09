package aop_beleg_2_fantasy;

public abstract class Item {
	private Integer price;
	private	String name;
	private String execute;
	
	public Item(Integer setPrice, String setName, String setExecute) {
		price = setPrice;	
		name = setName;
		execute = setExecute;
	}

	public Integer getPrice() {
		return price;
	}


	public String getName() {
		return name;
	}


	public String getExecute() {
		return execute;
	}
	
	
	
	
}
