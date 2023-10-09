package fantasyShop;

import java.util.ArrayList;

public abstract class Shop implements PurchasableIF {
	
	public Shop() {
		
	}
	
	public ArrayList<Item> autoShop(ArrayList<Item> shelf, Player p) {
		if(shelf.isEmpty()) {
			System.out.println("this shop is empty :(");
			return shelf;
		} else {
			for(int i = 0; i < shelf.size(); i++) {
				if(shelf.get(i) instanceof Sword || shelf.get(i) instanceof  SilverRing || shelf.get(i) instanceof CurseOfTheQuill) {
					if(purchasable(shelf.get(i).getPrice(), p.getPurse() )) {
						p.setPurse(p.getPurse() - shelf.get(i).getPrice());
						p.pushBackBackpack(shelf.get(i));
						shelf.remove(i);
					} else {
						System.out.println(p.getName() + " has not enough money to purchase: " + p.getPurse() + "$");
					}
						break;
				}
			}
		}
		if(shelf.isEmpty()) {
			System.out.println("this shop is empty :(");
			return shelf;
		} else {
			for(int i = 0; i < shelf.size(); i++) {
				if(shelf.get(i) instanceof Bow || shelf.get(i) instanceof  GoldRing || shelf.get(i) instanceof Hypnos) {
					if(purchasable(shelf.get(i).getPrice(), p.getPurse() )) {
						p.setPurse(p.getPurse() - shelf.get(i).getPrice());
						p.pushBackBackpack(shelf.get(i));
						shelf.remove(i);
					} else {
						System.out.println(p.getName() + " has not enough money to purchase: " + p.getPurse() + "$");
					}
					break;
				}
			}
		}
		return shelf;
	}
	
	public void showShop(ArrayList<Item> shelf) {
		System.out.println("--show shop--");
		for(Item s : shelf) {
			System.out.println(s.getName());
		}
	}
	
	
	public boolean purchasable(Integer cost, Integer purse) {
		if(cost <= purse) {
			return true;
		} else {
			return false;
		}
	}
}
