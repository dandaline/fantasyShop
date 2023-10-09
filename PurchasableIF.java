package fantasyShop;

import java.util.ArrayList;

public interface PurchasableIF {
	public ArrayList<Item> autoShop(ArrayList<Item> shelf, Player p);
}
