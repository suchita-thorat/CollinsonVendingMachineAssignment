package Collinson.VendingMachineProgram;

//Class to create different kinds of Vending Machine

public class VendingMachineFactory {
	public static VendingMachine createVendingMachine() {
		return new VendingMachineImpl();
	}
}
