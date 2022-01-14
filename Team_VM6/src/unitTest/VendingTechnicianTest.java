package unitTest;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import model.Item;
import model.VendingTechnician;

class VendingTechnicianTest {

	@Test
	void restockTest() {
		Item i = new Item("pringles", 3.00, 10);
		VendingTechnician t = new VendingTechnician();
		t.restock(i, 5);
		System.out.println(i.getQuantity());
		assertEquals(i.getQuantity(), 15);
	}
	
	@Test
	void restockTestNegativeValue() {
		Item i = new Item("pringles", 3.00, 10);
		VendingTechnician t = new VendingTechnician();
		t.restock(i, -5);
		System.out.println(i.getQuantity());
		assertEquals(i.getQuantity(), 10);
	}
}
