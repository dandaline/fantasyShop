package aop_beleg_2_fantasy;

import java.util.ArrayList;
import java.util.List;

public class BlackSmith extends Shop{
	

	private List <Weapon> shelfWeapon = new ArrayList<Weapon>();
	
	public BlackSmith(Integer stock) {
		for(Integer i = 1; i < stock+1; i++) {
			String name = "sword";
			name += Integer.toString(i);
			Sword sword = new Sword(50, name, "deals damage in conjuction with you power");
			this.shelfWeapon.add(sword);
		}
		for(Integer i = 1; i < stock+1; i++) {
			String name = "bow";
			name += Integer.toString(i);
			Bow bow = new Bow(100, name, "deals damage in conjuction with you power, ineffective at close range");
			this.shelfWeapon.add(bow);
		}
		
	}
	
	public void setShelf(List<Item> list) {
		shelfWeapon.clear();
		for(Item item : list) {
			shelfWeapon.add((Weapon) item);
		}
	}

	public ArrayList<Item> getShelf() {
		ArrayList<Item> list = new ArrayList<Item>();
		for(Item it : this.shelfWeapon) {
			list.add(it);
		}
		return list;
	}
	
	public void showShelf() {
		System.out.println("--black smith - stock--");
		String format = "%-20s%s%n";
		for(Item stock: shelfWeapon) {
			System.out.printf(format, stock.getName(), stock.getPrice() + "$");
		}
	}

}
