package fantasyShop;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private boolean[] forced = {false, false, false}; //BlackSmith, Jewelery, ScrollStore
	private int silverRingsColl = 0;
	private Integer shopCounter = 0;
	public List <Item> backpack = new ArrayList<Item>();
	private String name;
	private Integer power;
	private Integer purse;
	
	public Player(String setName, Integer setPower, Integer setPurse) {
		setName(setName);
		setPower(setPower);
		setPurse(setPurse);
	}
	
	public void updatePower() {
		int count = 0;
		for(Item bp : this.backpack) {
			if(bp instanceof SilverRing) {
				count++;
			}
		}
		if(count - silverRingsColl > 0) {
			this.power = this.power + (count - silverRingsColl) * 1000; 
			silverRingsColl = silverRingsColl + (count - silverRingsColl);
		}
		  	
	}
	
	
	public boolean shopVisited(Integer selection) {
		if(shopCounter < 3 && forced[selection] == false) {
			shopCounter++;
			forced[selection] = true;
			return true;
		} else if(shopCounter >= 3 && forced[selection] == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public Item getItemBackpack(Integer i) {
		return backpack.get(i);
	}
	
	public void showBackpack() {
		System.out.println("--Backpack of " + this.name + "--");
		for(Item bp : this.backpack) {
			System.out.println(bp.getName());
		}
		System.out.println("\n");
	}

	public void pushBackBackpack(Item bought) {
		this.backpack.add(bought);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getPurse() {
		return purse;
	}

	public void setPurse(Integer purse) {
		this.purse = purse;
	}

}
