package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.VendingMachine;
import model.VendingManager;

class VendingManagerTest {

	
	@DisplayName("test constructor getVendingMachine ")
	@Test
	public void testVendingManager() {
		VendingMachine vM = new VendingMachine();
		VendingManager vMa = new VendingManager(vM);
		assertEquals(vM, vMa.getVendingMachine());
	}

	
	
	@DisplayName("product report without the getsold report")
	@Test
	public void testProductReport() {
		VendingMachine vM = new VendingMachine();
		VendingManager vMa = new VendingManager(vM);
		String expected = "-----Here is the list of products in this Vending Maching------\nCheetos: $2.2\nLays: $5.6\n: M$M $1.2\nDorito: $5.3\nTakis: $3.4\nPringles: $4.5\nReese: $4.5\nClifBar: $2.5\nTostitos: $1.75\nKindEnergy: $3.5\nTake Five: $1.75\nNutter butter: $1.80\n\nThe products get sold:\n";
		String actual = vMa.productReport();
		assertEquals(expected, actual);
	}
	@DisplayName("product report with some items in getSold")
	@Test
	public void testProductReport1() {
		VendingMachine vM = new VendingMachine();
		vM.removeItem("Cheetos: $2.2");
		vM.removeItem("Lays: $5.6");
		
		VendingManager vMa = new VendingManager(vM);
		String expected = "-----Here is the list of products in this Vending Maching------\n: M$M $1.2\nDorito: $5.3\nTakis: $3.4\nPringles: $4.5\nReese: $4.5\nClifBar: $2.5\nTostitos: $1.75\nKindEnergy: $3.5\nTake Five: $1.75\nNutter butter: $1.80\n\nThe products get sold:\nCheetos: $2.2\nLays: $5.6\n";
		String actual = vMa.productReport();
		assertEquals(expected, actual);
	}
	@DisplayName("machine report some items get Sold")
	@Test
	void testReport() {
		VendingMachine vM = new VendingMachine();
		vM.removeItem("Cheetos: $2.2");
		vM.removeItem("Lays: $5.6");
		VendingManager vMa = new VendingManager(vM);
		String expected = "-----The items got sold in this Vending Machine-----\nCheetos: $2.2\nLays: $5.6\n-----The amount deposits into the vending mahcine -----\nTotal: $7.8";
		String actual = vMa.report();
		assertEquals(expected, actual);
	}
//
//	@Test
//	void testGetList() {
//		fail("Not yet implemented");
//	}

}
