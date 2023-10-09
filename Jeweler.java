package aop_beleg_2_fantasy;

import java.util.ArrayList;
import java.util.List;

public class Jeweler extends Shop {

	private List <Ring> shelfRing = new ArrayList<Ring>();
	
	public Jeweler(Integer stock) {
		for(Integer i = 1; i < stock+1; i++) {
			String name = "silver ring";
			name += Integer.toString(i);
			SilverRing silver = new SilverRing(50, name, "inceases your power by 1000 per silver ring");
			this.shelfRing.add(silver);
		}
		for(Integer i = 1; i < stock+1; i++) {
			String name = "gold ring";
			name += Integer.toString(i);
			GoldRing gold = new GoldRing(100, name, "tames monsters");
			this.shelfRing.add(gold);
		}
	}
	
	public void setShelf(List<Item> list) {
		shelfRing.clear();
		for(Item item : list) {
			shelfRing.add((Ring) item);
		}
	}

	public ArrayList<Item> getShelf() {
		ArrayList<Item> list = new ArrayList<Item>();
		for(Item item : this.shelfRing) {
			list.add(item);
		}
		return list;
	}
	
	public void showShelf() {
		System.out.println("--jewelery - stock--");
		String format = "%-20s%s%n";
		for(Item stock: shelfRing) {
			System.out.printf(format, stock.getName(), stock.getPrice() + "$");
		}
	}

}
