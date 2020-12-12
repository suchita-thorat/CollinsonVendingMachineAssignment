package Collinson.VendingMachineProgram;

import static org.testng.Assert.assertTrue;
import java.util.List;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class VendingMachineTest {
	private static VendingMachine vm;

	@BeforeTest
	public void setUp() {
		vm = VendingMachineFactory.createVendingMachine();
	}

	@AfterTest
	public void tearDown() {
		vm = null;
	}

	@Test(priority = 1)
	public void testBuyItemWithExactPrice() {
		// select item, price in cents
		long price = vm.selectItemAndGetPrice(Item.COKE);
		// price should be Coke's price
		assertEquals(Item.COKE.getPrice(), price);
		// 25 cents paid
		vm.insertCoin(Coin.QUARTER);
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
		Item item = bucket.getFirst();
		List<Coin> change = bucket.getSecond();
		// should be Coke
		assertEquals(Item.COKE, item);
		// there should not be any change as it was exact price
		assertTrue(change.isEmpty());
	}

	@Test(priority = 2)
	public void testBuyItemWithMorePrice() {
		long price = vm.selectItemAndGetPrice(Item.SODA);
		assertEquals(Item.SODA.getPrice(), price);

		vm.insertCoin(Coin.QUARTER);
		vm.insertCoin(Coin.QUARTER);

		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
		Item item = bucket.getFirst();
		List<Coin> change = bucket.getSecond();

		// should be SODA
		assertEquals(Item.SODA, item);
		// there should be change
		assertTrue(!change.isEmpty());

		// comparing returned change with price difference
		assertEquals(50 - Item.SODA.getPrice(), getTotal(change));
	}

	private long getTotal(List<Coin> change) {
		long total = 0;
		for (Coin c : change) {
			total = total + c.getDenomination();
		}
		return total;
	}

	// Testing the refund functionality
	@Test(priority = 3)
	public void testRefund() {
		long price = vm.selectItemAndGetPrice(Item.PEPSI);
		assertEquals(Item.PEPSI.getPrice(), price);
		vm.insertCoin(Coin.DIME);
		vm.insertCoin(Coin.NICKLE);
		vm.insertCoin(Coin.PENNY);
		vm.insertCoin(Coin.QUARTER);
		assertEquals(41, getTotal(vm.refund()));
	}

	@Test(priority = 4, expectedExceptions = { NotFullPaidException.class })
	public void testBuyItemWithLessPrice() {
		long price = vm.selectItemAndGetPrice(Item.PEPSI);
		assertEquals(Item.PEPSI.getPrice(), price);

		vm.insertCoin(Coin.QUARTER);
		vm.collectItemAndChange();
	}

	@Test(priority = 5, expectedExceptions = { SoldOutException.class })
	public void testSoldOut() {
		for (int i = 0; i < 5; i++) {
			vm.selectItemAndGetPrice(Item.COKE);
			vm.insertCoin(Coin.QUARTER);
			vm.collectItemAndChange();
		}
	}

	@Test(priority = 6, expectedExceptions = { NotSufficientChangeException.class })
	public void testNotSufficientChangeException() {
		for (int i = 0; i < 5; i++) {
			vm.selectItemAndGetPrice(Item.SODA);
			vm.insertCoin(Coin.QUARTER);
			vm.insertCoin(Coin.QUARTER);
			vm.collectItemAndChange();
			vm.selectItemAndGetPrice(Item.PEPSI);
			vm.insertCoin(Coin.QUARTER);
			vm.insertCoin(Coin.QUARTER);
			vm.collectItemAndChange();
		}
	}

	//Test for reset functionality
	@Test(priority=7)
	public void testReset() {
		int pepsiQuantity= vm.reset();
		assertEquals(5,pepsiQuantity);
	}
}
