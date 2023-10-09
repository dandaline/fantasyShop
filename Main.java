package fantasyShop;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Jeweler runTheJewels = new Jeweler(3);
		ScrollStore nuPaper = new ScrollStore(2);
		BlackSmith eisenhower = new BlackSmith(5);
		Player p1 = new Player("doerte_the_digit_slayer", 2000, 1000);
		System.out.print("$$$€€€--FANTASY SHOPPING MALL--$$$€€€ \nWelcome \"" + p1.getName() + "\"\n");
		System.out.println("--name: " +  p1.getName() + "  power: "+ p1.getPower() + "  purse" + p1.getPurse() + "$--");
		p1.showBackpack();
		eisenhower.showShelf();
		runTheJewels.showShelf();
		nuPaper.showShelf();
		System.out.println("\nYou will know automatically shop the mall until you run out of money. You may only pick the order of stores.\n");
		String select;
		while(p1.getPurse() > 50) {
			System.out.print("\n--Which shop would you like to visit? \n--black smith(b), jewelery(j) or scroll store(s) OR show player stats(p) >>>");
			select = input.next();
			System.out.println("\n");
				switch(select) {
				case "b":
					if(p1.shopVisited(0)) {
						eisenhower.setShelf(eisenhower.autoShop(eisenhower.getShelf(), p1));
						eisenhower.showShelf();
						System.out.println("\nyou have " + p1.getPurse() + "$ left.");
					} else {
						System.out.println("--ERROR: You need to visit all other shops first, before you can come back!--");
					}
				break;
				
				case "j":
					if(p1.shopVisited(1)) {
						runTheJewels.setShelf(runTheJewels.autoShop(runTheJewels.getShelf(), p1));
						runTheJewels.showShelf();
						System.out.println("\nyou have " + p1.getPurse() + "$ left.");
					} else {
						System.out.println("--ERROR: You need to visit all other shops first, before you can come back!--");
					}
				break;
				
				case "s":
					if(p1.shopVisited(2)) {
						nuPaper.setShelf(nuPaper.autoShop(nuPaper.getShelf(), p1));
						nuPaper.showShelf();
						System.out.println("\nyou have " + p1.getPurse() + "$ left.");
					} else {
						System.out.println("--ERROR: You need to visit all other shops first, before you can come back!--");
					}
				break;
					
				case "p":
					System.out.println("\nname: " +  p1.getName() + "  power: "+ p1.getPower() + "  purse" + p1.getPurse() + "$");
					p1.showBackpack();
				break;
				
				default:
					System.out.println("--try again please!--\n");
				break;
			}		
				p1.updatePower();
		}
		
		System.out.println("\n--you ran out of money! Here are your stats: \n");
		System.out.println("\nname: " +  p1.getName() + "  power: "+ p1.getPower() + "  purse" + p1.getPurse() + "$");
		p1.showBackpack();
		System.out.println("--Press any key to execute all items in backpack--");
		select = input.next();
		String format = "%-30s%s%n";
		for(int i = 0; i < p1.backpack.size(); i++) {
			System.out.printf(format, p1.backpack.get(i).getName(), p1.backpack.get(i).getExecute());
		}
		System.out.println("\n--Good bye--");
		input.close();	
	}

}
