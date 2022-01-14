package views;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Item;

public class ItemLoader {
	//Set path for reader

	private String filePath;
	private  ArrayList<Item> items;
	private String location;
	public ItemLoader(ArrayList<Item>items, String filePath, String location) {
		this.items= items;
		this.filePath=filePath;
		this.location=location;
	}
	// get the location from the text file
	public String getLocation() {
		return location;
	}
	//Loads the bank from the text file and creates an arrayList of items
	 public ArrayList<Item> getItems() {
		 
		try {
			File file = new File(filePath);
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) {
			
			String data = scanner.nextLine();
			
			String arr[] = data.split(" ");
			if(!arr[0].equals("Location:")) {
				String name = arr[0];
				double price = Double.parseDouble(arr[1]);
				int quantity = Integer.parseInt(arr[2]);
				Item i = new Item(name, price, quantity);
				
				items.add(i);
			}
			// get the location from the text file. only the line beginning with e word: location 
			else {
				for(int i=1; i<arr.length; i++) {
					location+=arr[i]+" ";
				}
			}
		}
		scanner.close();
		} catch(FileNotFoundException e) {
			System.out.println("An error occured. ");
			e.printStackTrace();
		}
		return items;
	}
	 
	 // test the itemLoad class
	
//	 public static void main ( String[] args) throws FileNotFoundException {
//		
//		
//		String filePath= "C:\\Users\\huy_a\\Desktop\\software_engineering\\eclipse_ws\\eclipse-ws3\\team6_f21-main (1)\\team6_f21-main\\Team6_VM\\src\\views\\ItemBank.txt";
//	 	ArrayList<Item> items = new ArrayList<Item>();
//	 	String loc="";
//	 	ItemLoader it = new ItemLoader(items,filePath, loc);
//	 	ArrayList<Item> arrs = it.getItems();
//		
//		System.out.println(it.getLocation());
//			
//		
//		
//		
//
//			
//		
//	 }
}


