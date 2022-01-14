package unitTest;

//import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.VendingMachine;;

class VendingMachineTest {

	@Test
	void testRefrigerated() {
		VendingMachine vM = new VendingMachine();
		String r = "R";
		boolean ans = true;
		assertEquals(vM.refrigerated(r), ans);
	}
//	@Test
//	void testVendingMachine() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testVendingMachineArrayListOfString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testVendingMachineArrayListOfStringDouble() {
//		fail("Not yet implemented");
//	}
//  
//	@DisplayName("Get the list of products ")
//	@Test
//	void testGetProducts() {
//		ArrayList<String> listSold = new ArrayList<String>();
//		VendingMachine vM= new VendingMachine(listSold);
//		String [] expectLists = {"Cheetos: $2.2", "Lays: $5.6", ": M$M $1.2", "Dorito: $5.3", "Takis: $3.4", "Pringles: $4.5", "Reese: $4.5", "ClifBar: $2.5", "Tostitos: $1.75", "KindEnergy: $3.5", "Take Five: $1.75", "Nutter butter: $1.80"}; // expect result
//		String [] actualLists = vM.getProducts(); // actual result
//		assertArrayEquals(expectLists, actualLists);
//	}
//
//	@Test
//	void testClearList() {
//		fail("Not yet implemented");
//	}
//
//	@DisplayName("get the list sold ")
//	@Test
//	void testGetSold() {
//		ArrayList<String> listSold = new ArrayList<String>();
//		listSold.add("Cheetos: $2.2");
//		listSold.add("Lays: $5.6");
//		VendingMachine vM= new VendingMachine(listSold);
//		
//		String [] expect = new String [2];// expect result
//		expect[0]= listSold.get(0);
//		expect[1]=listSold.get(1);
//		
//		ArrayList<String> actualListSold= vM.getSold(); 
//		String [] actual = new String [2];// actual result
//		actual[0]=actualListSold.get(0);
//		actual[1]=actualListSold.get(1);
//		assertArrayEquals(expect, actual);
//	}
//
//	@DisplayName("Get the balance")
//	@Test
//	void testGetBalance() {
//		ArrayList<String> listSold = new ArrayList<String>();
//		double balance = 50.50;
//		VendingMachine vM= new VendingMachine(listSold, balance);
//		double expectBalance = 50.50;
//		double actualBalance = vM.getBalance();
//		assertEquals(expectBalance, actualBalance);
//	}
//	@DisplayName("Get the right number from a string")
//	@Test
//	void testPrice() {
//		ArrayList<String> listSold = new ArrayList<String>();
//		VendingMachine vM= new VendingMachine(listSold);
//		String expectNumber = "2.2"; // expect result
//		String actualNumber = vM.price("Cheetos: $2.2"); // actual result
//		assertEquals(expectNumber, actualNumber);
//		
//		
//	}
//	@DisplayName("update the balance")
//	@Test
//	void testUpDateBalance() {
//		ArrayList<String> listSold = new ArrayList<String>();
//		double balance = 50.50;
//		VendingMachine vM= new VendingMachine(listSold, balance);
//		double expectBalance = 52.70;
//		vM.removeItem("Cheetos: $2.2");
//		double actualBalance = vM.upDateBalance();
//		assertEquals(expectBalance, actualBalance);
//	}
////
////	@Test
////	void testGetIndex() {
////		fail("Not yet implemented");
////	}
////
////	@Test
////	void testRemoveItem() {
////		fail("Not yet implemented");
////	}
////
//	@DisplayName("print out the report")
//	@Test
//	void testToString() {
//		ArrayList<String> listSold = new ArrayList<String>();
//		VendingMachine vM= new VendingMachine(listSold);
//		String expect ="Cheetos: $2.2\nLays: $5.6\n: M$M $1.2\nDorito: $5.3\nTakis: $3.4\nPringles: $4.5\nReese: $4.5\nClifBar: $2.5\nTostitos: $1.75\nKindEnergy: $3.5\nTake Five: $1.75\nNutter butter: $1.80\n" ;		
//		String actual = vM.toString();
//		assertEquals(expect, actual);
//		
//	}
//	
//	@Test
//	void testExpired() {
//		
//	}
//

	private void assertEquals(boolean refrigerated, boolean ans) {
		// TODO Auto-generated method stub
		
	}
}
