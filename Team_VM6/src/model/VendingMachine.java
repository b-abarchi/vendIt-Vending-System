package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Scanner;

import javafx.scene.control.ListView;


public class VendingMachine {
	// just_added and modified from line 16 to 50. replace "items" by "getProducts" in few methods
	private String filePath;
	
	private String location;
	
	
	
	private ArrayList<String> vmNames;
	private ArrayList<Item> items; 
	private ArrayList<Item> listSold= new ArrayList<Item>();
	private double balance;
	private double count =0;
	int nickelCount = 10; 
	int dimeCount = 10;
	int quarterCount = 10; 
	int dollarCount = 10;
	double totalSum = (.05 * nickelCount) + (0.10 * dimeCount) + (0.25 * quarterCount) + (1 * dollarCount);
//	private HashMap<String, Integer> change = new HashMap<String, Integer>();

	
	
	
		// Constructors 
		public VendingMachine() {}
		public VendingMachine(String filePath) {
			this.filePath=filePath;
		} 
		
		public VendingMachine(ArrayList<Item> listSold, ArrayList<Item> items, double balance, String filePath, String location, ArrayList<String> vmNames) {
			this.vmNames =vmNames;
			this.listSold=listSold;
			this.balance=balance;
			this.filePath= filePath;
			this.location =location;
			this.items=items;
			
			
		}
		
		// methods
		// get the list of items
	
		public ArrayList<Item> getProducts(){
			return items;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String loc) {
			this.location=loc;
		}
		public void setBalance() {
			balance=0.0;
		}
		public ArrayList<Item> getSold() {
			return listSold;
		}
		public double getBalance () {
			return balance;
		}
		public ArrayList<String> getVmNames() {
			return vmNames;
		}
		public String roundChange(double d) {
			return String.format("%.2f", d);
		}
		// get item
		public Item getItem(String name) {
			Item it = new Item();
			for(int i=0; i<getProducts().size(); i++) {
				if(getProducts().get(i).getName().equals(name)) {
					it=getProducts().get(i);
				}
			}
			return it;
		}
		
		public String getPrice(String s) {
			String price = "";
			for (int i=0; i<getProducts().size(); i++) {
				if(getProducts().get(i).getName().equals(s)){
					price= String.valueOf(getProducts().get(i).getPrice());
					
				}
			}
			return price;
		}
	
		//update the balance
		
		public double upDateBalance() {
			
			for(int i=0; i<getSold().size(); i++) {
				
				balance+=getSold().get(i).getPrice();
			}
			return balance;
		}

		
		// remove item from the list
		public void removeItem(String s, String name) throws IOException {
			
			
			String old_string = "";
			for(int i = 0; i<getProducts().size(); i++) {
				Item it = getProducts().get(i);
				if(it.getName().equals(s) && it.getvmName().equals(name)) {
					listSold.add(it);
					
					old_string= it.getName()+" "+ String.valueOf(it.getPrice())+ " "+String.valueOf(it.getQuantity());
					String new_string="";
					if(outOfStock(it.getQuantity())) {
						new_string = it.getName()+" "+ String.valueOf(it.getPrice())+ " "+"0";
					}
					else {
						it.setQuantity();
						new_string = it.getName()+" "+ String.valueOf(it.getPrice())+ " "+String.valueOf(it.getQuantity());
					}
					
//					new_string = it.getName()+" "+ String.valueOf(it.getPrice())+ " "+String.valueOf(it.getQuanity());
					rewrite_file(old_string, new_string);
					
				}
				
			}
			
			
		}
		public void remove_all_quantity(Item it, String name) throws IOException{
			if(expired(it)==true && it.getvmName().equals(name)) {
				
				
				String old_string = it.getName()+" "+ String.valueOf(it.getPrice())+ " "+String.valueOf(it.getQuantity());
				String new_string="";
				
					new_string = it.getName()+" "+ String.valueOf(it.getPrice())+ " "+"0";

//				new_string = it.getName()+" "+ String.valueOf(it.getPrice())+ " "+String.valueOf(it.getQuanity());
				rewrite_file(old_string, new_string);
			}
		}
		
		// just added this method to update the data base text file for technician 
		public void restock_rewrite_file(Item i, int quantity, String name) throws IOException {
			for(int m = 0; m<getProducts().size(); m++) { // just added this to loop through the item list to re-write the text file base on the condition bellow

				Item it = getProducts().get(m);
				int quantity_old = it.getQuantity();
				// create variable old_string and new_string to add into the rewrite_file method to post the data
				String old_string = it.getName()+" "+ String.valueOf(it.getPrice())+ " "+String.valueOf(quantity_old);
				String new_string="";
				if(it.getName().equals(i.getName()) && it.getvmName().equals(name)) {
					
					new_string=it.getName()+" "+ String.valueOf(it.getPrice())+ " "+String.valueOf(quantity);
				}
				else {
					
					new_string=it.getName()+" "+ String.valueOf(it.getPrice())+ " "+String.valueOf(quantity_old);
				}
				rewrite_file(old_string, new_string);
			}
				
		}
		// copy of previous method but instead of Quantity it's Date
				//but it is not rewriting
				public void renewDate_rewrite_file(Item i, LocalDate expirationDate, String name) throws IOException {
					for(int m = 0; m<getProducts().size(); m++) { // just added this to loop through the item list to re-write the text file base on the condition bellow

						Item it = getProducts().get(m);
						LocalDate ExpirationDate_old = it.getExpirationDate();
						String old_day = String.valueOf(ExpirationDate_old.getDayOfMonth());
						String old_month = String.valueOf(ExpirationDate_old.getMonthValue());
						String old_year = String.valueOf(ExpirationDate_old.getYear());
						String old_date= old_month+"/"+old_day+"/"+old_year;
						
						String new_day = String.valueOf(expirationDate.getDayOfMonth());
						String new_month = String.valueOf(expirationDate.getMonthValue());
						String new_year = String.valueOf(expirationDate.getYear());
						String new_date= new_month+"/"+new_day+"/"+new_year;
						
						// create variable old_string and new_string to add into the rewrite_file method to post the data
						String old_string = it.getName()+" "+ String.valueOf(it.getPrice())+ " "+String.valueOf(it.getQuantity())+ " "+ old_date;
						String new_string="";
						if(it.getName().equals(i.getName()) && it.getvmName().equals(name)) {
							it.setQuantity(0);
							new_string=it.getName()+" "+ String.valueOf(it.getPrice())+ " "+String.valueOf(0) + " "+ new_date;
						}
						else {
							
							new_string=it.getName()+" "+ String.valueOf(it.getPrice())+ " "+String.valueOf(it.getQuantity())+ " "+ new_date ;
						}
						rewrite_file(old_string, new_string);
					}
						
				}
		public boolean outOfStock(int quantity) {
			return quantity<=0;
		}
		// print out the items in the vending machine 
		@Override
		public String toString() {
			String s = "";
			for(int i=0; i<getProducts().size(); i++) {
				s+= getProducts().get(i).toString() + "\n";
			}
			
			return s;
		}
		
		// print out the items and their number of sold
		public String reportSoldList() {
			String s = "Items Name\t\t\tThe number of sold\n";
			for ( int i=0; i<getProducts().size(); i++) {
				Item it = getProducts().get(i);
				String numberSold= "";
				if(!outOfStock(it.getQuantity())) {
					numberSold= String.valueOf(10-it.getQuantity());
				}
				else {
					numberSold="10";
				}
					s += it.getName() +"\t\t\t\t\t  " + numberSold+"\n";
				
			}
			return s;
		}
		// method to re-write the text file
		public void rewrite_file (String oldString, String newString) throws IOException{
			
			//get the file that want to re-write
			File file= new File(filePath);
		    Scanner sc = new Scanner(file);
		    // buffer object from the StringBuffer class
		    StringBuffer buffer = new StringBuffer();
		    // Reading lines from the file and appending them to StringBuffer
		    while(sc.hasNext()) {
		    	buffer.append(sc.nextLine()+System.lineSeparator());
		    }
		    
		    String fileContents = buffer.toString();
		    fileContents = fileContents.replaceAll(oldString, newString);
		    @SuppressWarnings("resource")
		    // rewrite the file after change the expected text at expected location
			FileWriter writer = new FileWriter(filePath);
		    writer.append(fileContents);
		    writer.flush();
		    sc.close();
				
		}
//		// create the same original file 
//		public void create_New_File(String filePath, String pathSave) throws IOException {
//			PrintWriter writer = new PrintWriter(pathSave, "UTF-8");
//			File file = new File(filePath);
//			Scanner sc = new Scanner(file);
//			while(sc.hasNext()) {
//				String s = sc.nextLine();
//				writer.println(s);
//				
//			}
//			sc.close();
//			writer.close();
//				
//		}
		
	//	 just_added. Merged Itemloader class to vending machine class. ItemLoader is considered to be removed 
		 public void getItems() {
			 if(count==0) {
				try {
					File file = new File(filePath);
				Scanner scanner = new Scanner(file);
				
				
				while(scanner.hasNextLine()) {
					String location_name= "";
					String vmName= "";
					String data = scanner.nextLine();
					
					String arr[] = data.split(" ");
					if(arr[0].equals("Location:"))  {
						for(int i=1; i<arr.length; i++) {
							location_name+=arr[i]+" ";
						}
						continue;
					}
					else if(arr[0].equals("Name:")) {
						for(int i=1; i<arr.length; i++) {
							vmName+=arr[i]+" ";
						}
						vmNames.add(vmName);
						continue;
						}
					
					else if(!arr[0].equals("END")) { 
							String name = arr[0];
							double price = Double.parseDouble(arr[1]);
							int quantity = Integer.parseInt(arr[2]);
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
							LocalDate localDate = LocalDate.parse(arr[3], formatter);
							Boolean refrigerated = refrigerated(arr[4]);
	
							Item i = new Item(name, price, quantity, localDate, refrigerated);
							
							items.add(i);
						}
					
				
					// get the location from the text file. only the line beginning with e word: location 
					
					setLocation(location_name);
				}
				scanner.close();
				} catch(FileNotFoundException e) {
					System.out.println("An error occured. ");
					e.printStackTrace();
				}
				count++;
			 }
				
		 }
		
		// read the file with the specific String vM name method
		 public void getItem_by_name(String vname, int n) throws IOException {
			 String lineIWant = "";
			 
//				load the file
				File file = new File(filePath);
				Scanner scanner = new Scanner(file);
				FileInputStream fs= new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				 try {
					 String location_name= "";
					 int count = 0;
					 boolean cont =  true;
						while(scanner.hasNextLine() && cont) {
						
							
							String vmName= "";
							String data = scanner.nextLine();
							
							String arr[] = data.split(" ");
							
//					Part1:		Read the line with the word "Name:" and add to the list of vM name
							if(arr[0].equals("Name:")) {
								
									for(int i=1; i<arr.length; i++) {
										vmName+=arr[i]+ " ";
										
									}
									
									if (vmName.equals(vname)) {
										lineIWant+= vmName+"\n";
										cont= false; // stop the loop if find the matching name 
									}
							}
							count++; // count the line 
						}
						scanner.close();
						
						// Part 2:  read the content from the specific line that is the count number to the nth line base on the original file  
						if(count !=0 && cont==false) {
							for(int i = 0; i < count-1; ++i) {

								  br.readLine();		  
								  
							}

								if (br.readLine()!=null) {
									for(int m=0; m<n; m++) {
										String s= br.readLine();
									  String arr1[]= s.split(" "); 
			
										if(arr1[0].equals("Location:"))  {
											for(int i=1; i<arr1.length; i++) {
												location_name+=arr1[i]+" ";
											}
											continue;
										}
										
										else  { 
											
											String name = arr1[0];

											double price = Double.parseDouble(arr1[1]);
											int quantity = Integer.parseInt(arr1[2]);
											DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
											LocalDate localDate = LocalDate.parse(arr1[3], formatter);
											Boolean refrigerated = refrigerated(arr1[4]);
											
					
											Item i = new Item(name, price, quantity, localDate, refrigerated, vname);
											
											items.add(i);
										}
										
									  
									}
								  }
						
//						System.out.println(count);
							
						setLocation(location_name);

				
			 }
						else {
							System.out.println("continue");
						}
						
		}
				 
				catch(FileNotFoundException e) {
					System.out.println("An error occured. ");
					e.printStackTrace();
				}
//			 return  lineIWant;
			}
		 

		 public void setChangeCount (double nickel, double dime, double quarter, double dollar) {		
			 nickelCount += nickel; 		
			 dimeCount += dime; 		
			 quarterCount += quarter; 		
			 dollarCount += dollar; 	 		
			 		 		
																 		 }
		 
		 
		 
		 public int getNickelCount() {
			return nickelCount;
		}
		public void setNickelCount(int nickelCount) {
			this.nickelCount = nickelCount;
		}
		public int getDimeCount() {
			return dimeCount;
		}
		public void setDimeCount(int dimeCount) {
			this.dimeCount = dimeCount;
		}
		public int getQuarterCount() {
			return quarterCount;
		}
		public void setQuarterCount(int quarterCount) {
			this.quarterCount = quarterCount;
		}
		public int getDollarCount() {
			return dollarCount;
		}
		public void setDollarCount(int dollarCount) {
			this.dollarCount = dollarCount;
		}
		public double getTotalSum() {		
			return totalSum = (.05 * nickelCount) + (0.10 * dimeCount) + (0.25 * quarterCount) + (1 * dollarCount);		
		}
		public void setTotalSum(double totalSum) {
			this.totalSum = totalSum;
		}
		public boolean expired(Item i) {
				LocalDate today = LocalDate.now();
			
				if(i.getExpirationDate().isEqual(today) || i.getExpirationDate().isBefore(today) ) {
					return true;
				}
				else {
					return false;
				}
		 }
		
		public boolean refrigerated(String s) {
			if(s.equals("R")) {
				return true;
			}
			else {
				return false;
			}
		}
		public void remove_all_items() {
			items.clear();
		}
		
		//sets quantity to 0 while also changing vM
		// not updating list though
		 public void removeItem(Item i, String name) throws IOException {
			 
			 for (Item in : getProducts()) {
				 if (in.getName().equals(i.getName())) {
					 if (expired(i)==true && i.getvmName().equals(name) ) {
						 in.setQuantity(0);
						 
						 LocalDate newExpiratitonDate = LocalDate.now().plusDays(1); 
						 restock_rewrite_file(i, 0, name);
						 renewDate_rewrite_file(i, newExpiratitonDate, name);
					 }
				 }
			 }
		 }
		 
		 
//		 public static void main (String[]args) throws IOException {
//			 String filePath= "C:\\Users\\huy_a\\Downloads\\team6_f21-Bello (1)\\team6_f21-Bello\\Team6_VM\\src\\views\\ItemBank.txt";
//			  int initialValue = 0; 
////			  private ArrayList<String> listPrice= new ArrayList<String>();
//			  ArrayList<Item> listSold= new ArrayList<Item>();
//			  ArrayList<String> venNames = new ArrayList<String>();
//			  
//			  String location = "";
//			  double b= 0;
//			   String pickedItem;
//			  double  cash=0.0;
//			  ArrayList<Item> items= new ArrayList<Item>();
//			   VendingMachine vM = new VendingMachine(listSold, items,b , filePath, location, venNames );
////			   vM.getItems();
//			   
//			   
//			   vM.remove_all_items();
//			  vM. getItem_by_name("a ", 20);
//			  System.out.println(vM.getLocation());
//			  System.out.println(vM.getVmNames().toString());
//			 
//			  System.out.println(vM.getProducts().get(0).toString());
//			  System.out.println(vM.getProducts().get(0).getQuantity());
//			  vM.removeItem(vM.getProducts().get(0), "a " );
//			  System.out.println(vM.getProducts().get(0).getQuantity());
//			  System.out.println(vM.getProducts().get(0).toString());
//			  
//		 }

}