package model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Item {
	private String name;
	private double price;
	private int quantity;
	private LocalDate expirationDate;
	private boolean refrigerated;
	private String vmName;
	

	//ADD BOOL REFRIGERATED
	//ADD EXPIRATION DATE
	// the constructors show the item always has attributes are name and price
	public Item (String name, double price, int quantity) {
		this.name=name;
		this.price=price;
		if(quantity>10) {
			this.quantity = 10;
		}
		else {
		this.quantity = quantity;
		}
	}
	
	public Item (String name, double price, int quantity, LocalDate experationDate) {
		this.name=name;
		this.price=price;
		if(quantity>10) {
			this.quantity = 10;
		}
		else {
		this.quantity = quantity;
		}
		this.expirationDate = experationDate;
	}
	
	public Item (String name, double price, int quantity, LocalDate experationDate, boolean refrigerated) {
		this.name=name;
		this.price=price;
		if(quantity>10) {
			this.quantity = 10;
		}
		else {
		this.quantity = quantity;
		}
		this.expirationDate = experationDate;
		this.refrigerated = refrigerated;
	}
	public Item (String name, double price, int quantity, LocalDate experationDate, boolean refrigerated, String vmName) {
		this.name=name;
		this.price=price;
		if(quantity>10) {
			this.quantity = 10;
		}
		else {
		this.quantity = quantity;
		}
		this.expirationDate = experationDate;
		this.refrigerated = refrigerated;
		this.vmName= vmName;
	}
	
	public Item() {
		
	}
	
	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
// method to set name of item
	public void setName(String name) {
		this.name=name;
	}
	// method to set the price
	public void setPrice(String price) {
		this.price=Double.parseDouble(price);
	}
	// set the quantity
	public void setQuantity(int quantity) {
		
		if(quantity>10) {
			this.quantity = 10;
		}
		else {
		this.quantity = quantity ;
		}
	}
	public String getvmName() {
		return vmName;
	}
	public void setvmName(String name) {
		this.vmName=name;
	}
	public void setQuantity() {
		quantity--;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public boolean isRefrigerated() {
		
		return refrigerated;
	}
	
	public String toString() {
		if(quantity<=0) {
			return String.format("%s | Price: %.2f | Quantity: %d | Expiration: %s", name, price, 0 , expirationDate);
		}
        return String.format("%s | Price: %.2f | Quantity: %d | Expiration: %s", name, price, quantity, expirationDate );
    }
}