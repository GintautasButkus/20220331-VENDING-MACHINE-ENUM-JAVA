package lt.vtmc.GintautasButkus;

import java.util.HashMap;
import java.util.Map;

import lt.vtvpmc.vending.machine.Coin;
import lt.vtvpmc.vending.machine.ProductPurchaseResult;
import lt.vtvpmc.vending.machine.ProductType;
import lt.vtvpmc.vending.machine.VendingMachine;

public class VendingMachineImpl implements VendingMachine {
	
	private Map<ProductType, Integer> vendinMachine = new HashMap<ProductType, Integer>();
	private double insertedAmountCoins = 0;

	public void addProduct(ProductType productType, int amount) {
		if(productType != null && amount >= 0) {
			vendinMachine.putIfAbsent(productType, amount);
			vendinMachine.computeIfPresent(productType, (key, val) -> val + amount);
		} else {
			throw new IllegalArgumentException("Product not specified or amount is negative");
		}
	}

	public ProductPurchaseResult buyProduct(ProductType productType) {
			double amountInserted = insertedAmountCoins;
			double change = Math.round((amountInserted - productType.getPrice())*100); 
			change = change/100;
			if(productType.getPrice() <= amountInserted && vendinMachine.keySet().contains(productType) && vendinMachine.get(productType)>0) {
				amountInserted-=productType.getPrice();
				insertedAmountCoins = 0.0;
				return new ProductPurchaseResult(true, change, productType);				
			} 
			return new ProductPurchaseResult(false, insertedAmountCoins, productType);
	}

	public void insertCoin(Coin coin) {
		switch(coin) {
		case CENTS_10:
			insertedAmountCoins += 0.1;
			break;
		case CENTS_20:
			insertedAmountCoins += 0.2;
			break;
		case CENTS_50:
			insertedAmountCoins += 0.5;
			break;
		case EURO_1:
			insertedAmountCoins += 1;
			break;
		case EURO_2:
			insertedAmountCoins += 2;
			break;
		}
	}
}
