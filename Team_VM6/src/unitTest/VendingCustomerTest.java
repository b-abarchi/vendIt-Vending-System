package unitTest;
import model.VendingCustomer;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class VendingCustomerTest {

	@Test
	void testVendingCustomerArrayListOfString() {
		ArrayList<String> items = new ArrayList<String>();
		String item1 = "Item: cheetos, Price: 1.75";
		String item2 = "Item: Pringles, Prices: 1.75";
		items.add(item1);
		items.add(item2);
		VendingCustomer c = new VendingCustomer(items);
		assertEquals(c.getList(), items);
	}

	
	@Test
	void testVendingCustomerArrayListOfStringDouble() {
		ArrayList<String> items = new ArrayList<String>();
		String item1 = "Item: cheetos, Price: 1.75";
		String item2 = "Item: Pringles, Prices: 1.75";
		items.add(item1);
		items.add(item2);
		double cash = 3.00;
		VendingCustomer c = new VendingCustomer(items, cash);
		assertEquals(c.getList(), items);
		assertEquals(c.getCash(), 3.00);
	}

//	@Test
//	void testSetCash() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetList() {
		ArrayList<String> items = new ArrayList<String>();
		String item1 = "Item: cheetos, Price: 1.75";
		String item2 = "Item: Pringles, Prices: 1.75";
		items.add(item1);
		items.add(item2);
		VendingCustomer c = new VendingCustomer(items);
		assertEquals(c.getList(), items);
	}

	@Test
	void testAddTo() {
		ArrayList<String> items = new ArrayList<String>();
		String item1 = "Item: cheetos, Price: 1.75";
		VendingCustomer c = new VendingCustomer(items);
		c.addTo(item1);
		assertEquals(c.getList().get(0), item1);
	}

	@Test
	void testRemove() {
		ArrayList<String> items = new ArrayList<String>();
		String item1 = "Item: cheetos, Price: 1.75";
		String item2 = "Item: Pringles, Prices: 1.75";
		items.add(item1);
		items.add(item2);
		VendingCustomer c = new VendingCustomer(items);
		c.remove(item2);
		assertEquals(c.getList().size(), 1);
	}

	@Test
	void testIs_emptyFalse() {
		ArrayList<String> items = new ArrayList<String>();
		String item1 = "Item: cheetos, Price: 1.75";
		String item2 = "Item: Pringles, Prices: 1.75";
		items.add(item1);
		items.add(item2);
		VendingCustomer c = new VendingCustomer(items);
		assertEquals(c.is_empty(), false);
	}
	
	@Test
	void testIs_emptyTrue() {
		ArrayList<String> items = new ArrayList<String>();
		String item1 = "Item: cheetos, Price: 1.75";
		String item2 = "Item: Pringles, Prices: 1.75";
		VendingCustomer c = new VendingCustomer(items);
		assertEquals(c.is_empty(), true);
	}

	@Test
	void testChangeBack() {
		ArrayList<String> items = new ArrayList<String>();
		String item1 = "Item: cheetos, Price: 1.75";
		String item2 = "Item: Pringles, Prices: 1.75";
		items.add("Cheetos: $2.2");
		double cash = 3.2;
		VendingCustomer c = new VendingCustomer(items, cash);

		System.out.println(c.changeBack());
		assertEquals(c.changeBack(), 1.0);
	}

//	@Test
//	void testPurchase() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testClear() {
		ArrayList<String> items = new ArrayList<String>();
		String item1 = "Item: cheetos, Price: 1.75";
		String item2 = "Item: Pringles, Prices: 1.75";
		items.add(item1);
		items.add(item2);
		VendingCustomer c = new VendingCustomer(items);
		c.clear();
		assertEquals(c.getList().size(), 0);
	}
//
//	@Test
//	void testPrice() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testIsCustomer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetvM() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAsCustomer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testRemoveItem1() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetItems() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCompareItem() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testToString() {
//		fail("Not yet implemented");
//	}
//
}
