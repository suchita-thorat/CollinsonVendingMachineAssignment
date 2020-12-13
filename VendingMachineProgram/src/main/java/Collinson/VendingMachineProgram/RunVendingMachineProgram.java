package Collinson.VendingMachineProgram;

import java.io.IOException;
import java.util.List;

public class RunVendingMachineProgram {

	public static void main(String[] args) throws IOException {
		VendingMachine vm;
		int amountReturned=0;
		
		System.out.println("*******Starting Vending Machine Program Execution*******");
	//	System.out.println("*******Only few functionalities execution inculded in Main method*******");
	//	System.out.println("*******Main method can be customized as per requirement*******");
		vm = VendingMachineFactory.createVendingMachine();
	
		System.out.println("*******Current stock of items and coins at beginning*******");
		vm.printStats();
		
		//Buy item with exact price
		System.out.println("*******Buy item with exact price:User selects item COKE *******");
		long price = vm.selectItemAndGetPrice(Item.COKE); 

		System.out.println("Price of COKE displayed by machine(in Cents):" + price);
		System.out.println("*******User inserts QUARTER coin*******");
		vm.insertCoin(Coin.QUARTER);
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange(); 
		Item item = bucket.getFirst(); 
		List<Coin> change = bucket.getSecond(); 
		if (change.isEmpty())
		{
			amountReturned=0;
		}
		System.out.println("Item Returned: "+ item +" Change Returned: "+ amountReturned);
		
		System.out.println("*********************************************");
		System.out.println("********Stock after Coke is sold**********");
		vm.printStats();

		//Buy item with more price
		System.out.println("*******Buy item with more price:User selects item PEPSI *******");
		price = vm.selectItemAndGetPrice(Item.PEPSI); 
		
		System.out.println("Price of PEPSI displayed by machine(in Cents):" + price);
		System.out.println("*******User inserts four DIME coins*******");
		vm.insertCoin(Coin.DIME);
		vm.insertCoin(Coin.DIME);
		vm.insertCoin(Coin.DIME);
		vm.insertCoin(Coin.DIME);
		Bucket<Item, List<Coin>> bucket1 = vm.collectItemAndChange(); 
		Item item1 = bucket1.getFirst(); 
		List<Coin> change1 = bucket1.getSecond(); 
		if (change1.isEmpty())
		{
			amountReturned=0;
		}
		System.out.println("Item Returned: "+ item1 +" Change Returned: "+ change1);
		
		System.out.println("*********************************************");
		System.out.println("********Stock after PEPSI is sold**********");
		vm.printStats();
		
		System.out.println("*********************************************");
		System.out.println("********Now reset the machine**********");
		int pepsiQuantity= vm.reset();
		
		System.out.println("*******Stock of items and coins after reset*******");
		vm.printStats();
		
	}

}
