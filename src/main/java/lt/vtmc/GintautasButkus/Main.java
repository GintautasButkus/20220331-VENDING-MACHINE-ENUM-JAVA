package lt.vtmc.GintautasButkus;

import lt.vtvpmc.vending.machine.ProductType;

public class Main {

	public static void main(String[] args) {
		System.out.println(ProductType.CHOCOLATE_DELIGHT.getPrice());
		System.out.println(ProductType.EPIC_CANDY.getPrice());
		System.out.println(ProductType.MAGIC_CROISSANT.getPrice());
		
		for(ProductType string : ProductType.values()) {
			System.out.println(string.getPrice());
		}
	}

}
