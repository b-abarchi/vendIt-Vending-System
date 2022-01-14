package model;
import java.util.ArrayList;


	
public class VendingCustomer {
	// just_added and modified from line 8 to line 18
	private VendingMachine vM;
	private String pickedItem;
	
	int tempNickCount; 		
	int tempDimeCount;		
	int tempQuartCount; 		
	int tempDollCount;
	
	private double cash;

	public VendingCustomer(String pickedItem, double cash, VendingMachine vM) {
		this.cash=cash;
		this.pickedItem=pickedItem;
		this.vM= vM;
	}
	public VendingCustomer() {}
	
	
	
	// set input cash
	public void setcash(double cash) {
		
		this.cash=cash;
	}
	//get item that customer bought
	public String getItem(){
		
		return pickedItem;
	}
	// set item picked 
	public void setItem(String pickedItem) {
		
		this.pickedItem=pickedItem;
	}

	// get the change to customer
	public double changeBack() {
		double total=0.0;
		
		double change =0.0;
		if(cash!=0.0) {
			
				for(int i=0; i<vM.getProducts().size(); i++) {
					Item it = vM.getProducts().get(i);
					if(pickedItem.equals(it.getName())) {
						total+= it.getPrice();
					}
				}
			
			change = cash-total;
		
		}
		else {
			change = 0.0;
		}
		return change;
		
	}

	
	// question whether the change is negative
	public boolean purchase(double change) {
		return change<0.0;
	}
	
	 public double insertcustomerCash (double c) {	
			if (c == .05) {  setTempChangeCount(.05); 	return cash += c; }			
			if (c == .10) {   setTempChangeCount(.10); return cash += c;}		
			if (c == .25) {   setTempChangeCount(.25); 	return cash += c; }		
			if (c == 1.00) {  setTempChangeCount(1.00); 	return cash += c; }	
						else	
				return 0;	
		 	 }
	 
	
public void setTempChangeCount (double c) {		
		if (c == .05) { tempNickCount++; }			
	    if (c == .10) {tempDimeCount++;}		
		if (c == .25) {tempQuartCount++; }		
		if (c == 1.00) {tempDollCount++;}		
						 		 }		
		
		
public void clearTemp (){		
	this.tempNickCount = 0; 		
	this.tempDimeCount = 0;		
	this.tempQuartCount = 0;		
	this.tempDollCount = 0;		
						 		 }		
		
	public int getTempNickCount() {		
		return tempNickCount;		
	}		
	public void setTempNickCount(int tempNickCount) {		
		this.tempNickCount = tempNickCount;		
	}		
	public int getTempDimeCount() {		
		return tempDimeCount;		
	}		
	public void setTempDimeCount(int tempDimeCount) {		
		this.tempDimeCount = tempDimeCount;		
	}		
	public int getTempQuartCount() {		
		return tempQuartCount;		
	}		
	public void setTempQuartCount(int tempQuartCount) {		
		this.tempQuartCount = tempQuartCount;		
	}		
	public int getTempDollCount() {		
		return tempDollCount;		
	}		
	public void setTempDollCount(int tempDollCount) {		
		this.tempDollCount = tempDollCount;		
	}
	 public String getCash(){
		 String s =	String.format("%,.2f", cash);
			return s;
		}
	 
	 public void setCash(double c) {
			cash = c; 
		}

	

	// print out the items get sold 
	public String toString1() {
		String strs="";
		
		for(int i=0; i<vM.getSold().size(); i++) {
			strs+=vM.getSold().get(i) + "\n";
		}
		return strs;
	}}