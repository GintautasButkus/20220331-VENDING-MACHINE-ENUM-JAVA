package lt.vtmc.GintautasButkus;

import lt.vtvpmc.vending.machine.Coin;
import lt.vtvpmc.vending.machine.ProductType;

public class Main {

	public static void main(String[] args) {
		VendingMachineImpl vm = new VendingMachineImpl();
		
		vm.addProduct(ProductType.CHOCOLATE_DELIGHT, 3);
		vm.addProduct(ProductType.EPIC_CANDY, 3);
		vm.addProduct(ProductType.MAGIC_CROISSANT, 3);
		
		vm.insertCoin(Coin.CENTS_50);
		vm.insertCoin(Coin.EURO_1);
		
		System.out.println("Chocolate price: " + ProductType.CHOCOLATE_DELIGHT.getPrice());
		System.out.println("Croissant price: " + ProductType.MAGIC_CROISSANT.getPrice());
		System.out.println("Candy price: " + ProductType.EPIC_CANDY.getPrice());
		
		System.out.println("Change of buying Croissant: " + vm.buyProduct(ProductType.MAGIC_CROISSANT).getChange());
		
		
		

	}

}
