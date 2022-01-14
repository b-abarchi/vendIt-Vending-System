package model;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Set;

public class VendingManager {
//	private ArrayList<String> listSold = new ArrayList<String>();
	private VendingMachine vM;

	// Constructor
	public VendingManager(VendingMachine vM) {
		this.vM = vM;
	}

	public VendingManager() {
	}

	public VendingMachine getVendingMachine() {
		return vM;
	}

	// method to get report of products
	public String productReport() {
		vM.getItems(); // just_added
		String items = "Location: " + vM.getLocation(); // just_added
		items += "\n-----Here is the list of products in this Vending Maching------\n"; // report the items available in
																						// vending machine

		items += vM.toString();
		return items;
	}

	// get report of the machine
	public String report() {
		vM.getItems(); // just_added
		String report = "Location: " + vM.getLocation(); // just_added
		String soldItem = "\n-----The items got sold in this Vending Machine-----\n"; // report items get sold
		soldItem += vM.reportSoldList();
		String balance = String.format("-----The amount deposits into the vending mahcine -----\nTotal: $%.2f",
				vM.upDateBalance()); // report the amount deposit

		report += soldItem + balance;
		return report;
	}

	// get list of items in vending machine
	public ArrayList<Item> getList() {
		return vM.getProducts();
	}

	public String manufacturerReport() {
		String s = "";
		s += " PepsiCo\n" + "	Cheetos\n" + "	Lays\n" + "	Doritos\n" + "	Tostitos\n" + "Mars\n" + "	Kind\n"
				+ "	M&Ms\n" + "Barcel\n" + "	Takis\n" +

				"Hershey\n" + "	Reese's\n" + "	Take 5" + "Clif Bar & Company\n" + "	Clif Bar/n" + "Kellogg's\n"
				+ "	Pringles\n" + "Nabisco\n" + "	Nutter Butter\n" + "Coca-Cola Company\n" + "	coca_cola\n"
				+ "	Diet coke\n" + "	cherry coke\n" + "	Sprite\n" + "	Dasani\n" + "	Fanta\n" +

				"Keurig Dr Pepper\n" + "	CanadaDry\n" + "	DrPepper\n" + "Hornell Brewing Co.\n" + "	Arizona";

		return s;
	}

	public String LocationReport(VendingMachine vM) {
		String s = "";

		s += " " + vM.getLocation() + "\n";

		return s;
	}

	public String DryReport() {
		String s = "";
		for (Item i : vM.getProducts()) {
			if (!i.isRefrigerated()) {
				s += " " + i.getName() + "\n";
			}

		}
		return s;
	}

	public String RefrigeratedReport() {
		String s = "";
		for (Item i : vM.getProducts()) {
			if (i.isRefrigerated()) {
				s += " " + i.getName() + "\n";
			}

		}
		return s;
	}

	public String ExpiredReport() {
		String s = "";
		for (Item i : vM.getProducts()) {
			if (vM.expired(i)) {
				s += " " + i.getName() + "\n";
			}
		}
		return s;
	}
	
}