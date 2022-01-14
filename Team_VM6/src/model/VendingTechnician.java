package model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



public class VendingTechnician {


	private VendingMachine vM = new VendingMachine();
	
	// constructor
	public VendingTechnician() {}

	public VendingTechnician(VendingMachine vM) {
		this.vM = vM;
	}
	
				// set the quantity of item and post it to the text file 
	
	public void restock(Item i, int n, String name) throws IOException {
		int quantity = i.getQuantity();
		quantity += n;
		if(n > 0) {
			if(i.getQuantity()+n<=10) {
				vM.restock_rewrite_file(i, i.getQuantity()+n, name);
			}
			else {
				vM.restock_rewrite_file(i, 10, name);
			}
			i.setQuantity(quantity);
			
		}
		
	}
	

}
