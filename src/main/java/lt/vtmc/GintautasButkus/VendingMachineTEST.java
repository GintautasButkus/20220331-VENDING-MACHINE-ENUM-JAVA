package lt.vtmc.GintautasButkus;

import lt.vtvpmc.vending.machine.BaseVendingMachineTest;
import lt.vtvpmc.vending.machine.VendingMachine;

public class VendingMachineTEST extends BaseVendingMachineTest {

	@Override
	protected VendingMachine getNewVendingMachine() {
		return new VendingMachineImpl();
	}

}
