package Collinson.VendingMachineProgram;

import java.io.IOException;
import java.util.List;


public class RunVendingMachineProgram {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("*******Starting Vending Machine Program Execution*******");
		
		VendingMachine vm;
		int amountReturned=0;
		vm = VendingMachineFactory.createVendingMachine();
		System.out.println("*******User Selects Item COKE *******");
		long price = vm.selectItemAndGetPrice(Item.COKE); 

		System.out.println("Price of COKE:" + price);
		vm.insertCoin(Coin.QUARTER);
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange(); 
		Item item = bucket.getFirst(); 
		List<Coin> change = bucket.getSecond(); 
		if (change.isEmpty())
		{
			amountReturned=0;
		}
		System.out.println("Item Returned: "+ item +" Change Returned: "+ amountReturned);
		
		vm.printStats();
		
		long price1 = vm.selectItemAndGetPrice(Item.PEPSI);
		System.out.println("Price of PEPSI:" + price1); 
		
	}

}
