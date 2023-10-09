package fantasyShop;

public abstract class Weapon extends Item {
	protected Integer power;

	public Weapon(Integer price, String name, String execute) {
		super(price, name, execute);
	}
	
	
}
