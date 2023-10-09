package fantasyShop;

import java.util.ArrayList;
import java.util.List;

public class ScrollStore extends Shop {
	
	private List <Scroll> shelfScroll = new ArrayList<Scroll>();
	
	public ScrollStore(Integer stock) {
		for(Integer i = 1; i < stock+1; i++) {
			String name = "Curse of the Quill";
			name += Integer.toString(i);
			CurseOfTheQuill curse = new CurseOfTheQuill(100, name, "destroys all enemy swords nearby");
			this.shelfScroll.add(curse);
		}
		for(Integer i = 1; i < stock+1; i++) {
			String name = "Eyes of Hypnos";
			name += Integer.toString(i);
			Hypnos hypnos = new Hypnos(50, name, "paralyzes all monsters nearby");
			this.shelfScroll.add(hypnos);
		}
	}
	
	public void setShelf(List<Item> list) {
		shelfScroll.clear();
		for(Item item : list) {
			shelfScroll.add((Scroll) item);
		}
	}

	public ArrayList<Item> getShelf() {
		ArrayList<Item> list = new ArrayList<Item>();
		for(Item it : this.shelfScroll) {
			list.add(it);
		}
		return list;
	}
	
	public void showShelf() {
		System.out.println("--scroll store stock--");
		String format = "%-20s%s%n";
		for(Item stock: shelfScroll) {
			System.out.printf(format, stock.getName(), stock.getPrice() + "$"); 
		}
	}

}
