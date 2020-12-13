package Collinson.VendingMachineProgram;

import java.util.List;

// Declare Interface
//This Interface has methods for high-level functionalities of the program

public interface VendingMachine {
	public long selectItemAndGetPrice(Item item);

	public void insertCoin(Coin coin);

	public List<Coin> refund();

	public Bucket<Item, List<Coin>> collectItemAndChange();

	public int reset();

	public void printStats();
}
