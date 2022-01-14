package unitTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Item;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

class ItemTest {
	
	@Test
	void testItemStringDoubleDate() {
		LocalDate today = LocalDate.of(20202, 1, 8);
		Item i = new Item("Pringles",1.70, 0, today);
		assertEquals(i.getExperationDate(), today);
	}

//	@Test
//	void testItemStringDouble() {
//		Item i = new Item("Pringles", 1.70);
//		assertEquals(i.getName(), "Pringles");
//		assertEquals(i.getPrice(), 1.70);
//	}
//
//	@Test
//	void testItemString() {
//		Item i = new Item("Pringles");
//		assertEquals(i.getName(), "Pringles");
//		assertEquals(i.getPrice(), 0.00);
//	}
//
//	@Test
//	void testItemDouble() {
//		Item i = new Item(1.70);
//		assertEquals(i.getName(), null);
//		assertEquals(i.getPrice(), 1.70);
//	}
//
//	@Test
//	void testGetName() {
//		Item i = new Item("Pringles");
//		String actualOutput =  i.getName();
//		String expectedOutput = "Pringles";
//		assertEquals(actualOutput, expectedOutput);
//	}
//
//	@Test
//	void testGetPrice() {
//		Item i = new Item(1.70);
//		Double actualOutput =  i.getPrice();
//		Double expectedOutput = 1.70;
//		assertEquals(actualOutput, expectedOutput);
//	}
//
//	@Test
//	void testToString() {
//		Item i = new Item("Pringles", 1.70);
//		String actualOutput =  i.toString();
//		String expectedOutput = "Item: Pringles, Price: 1.70";
//		assertEquals(actualOutput, expectedOutput);
//	}

}
