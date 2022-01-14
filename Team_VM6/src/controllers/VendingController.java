package controllers;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.rmi.AccessException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import model.VendingCustomer;
import model.VendingManager;
import model.VendingTechnician;
import model.VendingMachine;
import model.Item;
import javafx.scene.control.MultipleSelectionModel;


public class VendingController {
	   @FXML
	    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, 
	    			   btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, create;
	   @FXML
	  private ToggleGroup selected;
	   
	  @FXML
	  private RadioButton radio_cash, radio_credit;
	  @FXML private TextArea details, input;
	  @FXML
	   private Button product_report;
	  @FXML
	    private MenuButton reportMnuBtn;
	  @FXML
	    private TextArea report_manager;
	  @FXML
	    private Button machine_report;
	  @FXML
	  private TextField txtDetails;
	  @FXML
	  private TextField vmName;
	  @FXML
	  private TextField vmLocation;
	  @FXML		
	  private TextField txtDetails2;	
	  @FXML		
	   private TextField txtChangeAmount;	
	  @FXML		
	  private ListView<String> listChange;
	  @FXML
	  private Spinner<Integer> SpinQuantity;
	  int initialValue = 0; 
//	  private ArrayList<String> listPrice= new ArrayList<String>();
	  private ArrayList<Item> listSold= new ArrayList<Item>();
	  
	  private ArrayList<String> venName = new ArrayList<String>();
	  private String location;
	  double b= 0;
	  private String pickedItem;
	  double cash=0.0;
	
	  private VendingTechnician vT = new VendingTechnician();
	  @FXML
	    private ListView listView;
	  @FXML
	    private ListView selectVm;
	    private ArrayList<Item> items= new ArrayList<Item>();
	    ObservableList observableList = FXCollections.observableArrayList();
	    ObservableList observableList1 = FXCollections.observableArrayList();
	// please add your own ItemBank.txt path in your local computer
	    private String filePath= "C:\\Eclipse\\team6_f21-Emmanuel.zip_expanded\\team6_f21-Emmanuel\\Team6_VM\\src\\views\\ItemBank.txt";
	    
	    private VendingMachine vM = new VendingMachine(listSold, items,b , filePath, location, venName );
	    private VendingCustomer vC= new VendingCustomer(pickedItem,cash, vM);
	    // items'buttons 
	    
	    @FXML
        public void handleSelectVm(MouseEvent event) throws IOException {
	   		
	   			vM.remove_all_items();
                String name =  String.valueOf((selectVm.getSelectionModel().getSelectedItem()));

                vM.getItem_by_name(name, 22);

                }
	    
		public void handleButtonClick1(ActionEvent event) throws IOException {
//			vM.getItems();
//			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22); // just_added 
			String item = btn1.getText();
			
			int quantity = vM.getItem(item).getQuantity();
			
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				
				
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
		}
	public void handleButtonClick2(ActionEvent event) throws IOException {
		vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
		
			
		String item = btn2.getText();
		int quantity = vM.getItem(item).getQuantity();
		if(vM.outOfStock(quantity)) {
			details.setText("Sorry! this item outs of stock");
		}
		else {
			vC.setItem(item);
			details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
			
		}
	}
	public void handleButtonClick3(ActionEvent event) throws IOException {
		
		vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
		String item = btn3.getText();
		int quantity = vM.getItem(item).getQuantity();
		if(vM.outOfStock(quantity)) {
			details.setText("Sorry! this item outs of stock");
		}
		else {
			vC.setItem(item);
			details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
			
		}
	}
	public void handleButtonClick4(ActionEvent event) throws IOException {
		vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
		String item = btn4.getText();
		int quantity = vM.getItem(item).getQuantity();
		if(vM.outOfStock(quantity)) {
			details.setText("Sorry! this item outs of stock");
		}
		else {
		vC.setItem(item);
		details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
		}
	}
	public void handleButtonClick5(ActionEvent event) throws IOException {
		vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
		String item = btn5.getText();
		int quantity = vM.getItem(item).getQuantity();
		if(vM.outOfStock(quantity)) {
			details.setText("Sorry! this item outs of stock");
		}
		else {
			vC.setItem(item);
			details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
			
		}
	}
	public void handleButtonClick6(ActionEvent event) throws IOException {
		vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
		String item = btn6.getText();
		int quantity = vM.getItem(item).getQuantity();
		if(vM.outOfStock(quantity)) {
			details.setText("Sorry! this item outs of stock");
		}
		else {
			vC.setItem(item);
			details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
			
		}
	}
	public void handleButtonClick7(ActionEvent event) throws IOException {
		vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
		String item = btn7.getText();
		int quantity = vM.getItem(item).getQuantity();
		if(vM.outOfStock(quantity)) {
			details.setText("Sorry! this item outs of stock");
		}
		else {
			vC.setItem(item);
			details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
			
		}
	}
		public void handleButtonClick8(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn8.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
	}
		public void handleButtonClick9(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn9.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
	
	}
		public void handleButtonClick10(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn10.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
	}
		public void handleButtonClick11(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn11.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
	}
		public void handleButtonClick12(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn12.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
	}
		public void handleButtonClick13(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn13.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
		}
		public void handleButtonClick14(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn14.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
		}
		public void handleButtonClick15(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn15.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
		}
		public void handleButtonClick16(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn16.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
		}
		public void handleButtonClick17(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn17.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
		}
		public void handleButtonClick18(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn18.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
		}
		public void handleButtonClick19(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn19.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
		}
		public void handleButtonClick20(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn20.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
		}
		public void handleButtonClick21(ActionEvent event) throws IOException {
			vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
			String item = btn21.getText();
			int quantity = vM.getItem(item).getQuantity();
			if(vM.outOfStock(quantity)) {
				details.setText("Sorry! this item outs of stock");
			}
			else {
				vC.setItem(item);
				details.setText(item+ ": $"+ vM.getPrice(item)+"\nPlease select method of payment");
				
			}
		}
		
		public void handleButtonClickNickel(ActionEvent event) {
			vC.insertcustomerCash(.05);
			input.setText("" + vC.getCash());
		}
		
	public void handleButtonClickDime(ActionEvent event) {
		vC.insertcustomerCash(.10);
		input.setText("" + vC.getCash());
		}
	
	
public void handleButtonClickQuarter(ActionEvent event) {
	vC.insertcustomerCash(.25);
	input.setText("" + vC.getCash());
	}


public void handleButtonClickDollar(ActionEvent event) {
	vC.insertcustomerCash(1.00);
	input.setText("" + vC.getCash());
}

public void handleButtonClickCancel(ActionEvent event) {
	vC.setCash(0);
	input.setText("" + vC.getCash());
			}

		// checking the valid input 
		private boolean checkNumber(String s) {
			if(s==null || s=="") {
				return false;
			}
			try {
				 double i = Double.parseDouble(s);
				return true;
			}
			catch(NumberFormatException e) {
				return false;
			}
			
		}
		// checking the small dollars bill
		private boolean checkBigCash(String s) {
			return Double.parseDouble(s)>=10;
		}
		// purchase buttons 
		public void handleBtnPurchase(ActionEvent event) throws IOException {
			String s = input.getText();
			
			
			if(vC.getItem()==null || s=="Sorry! this item outs of stock") {  // check whether the customer has not picked the items
				details.setText("Hi! How can I help you \nplease pick an item");
				input.setText("");
				
			}
			else {
				//condition of the cash back 
				
				
				if(radio_cash.isSelected()) { // check whether the customer forgot to deposit 
//					input.setEditable(true);
					if(checkNumber(s)==false || checkBigCash(s)) {
						input.setText("");
						vC.setCash(0);
						details.setText("Please insert the valid cash or smaller bill!");
					}
					
					else {
						vC.setCash(Double.parseDouble(s)); // set the cash input to vendingCustomer class
						double change = vC.changeBack();
						String changeBack = vM.roundChange(change);
						
						
						if(change<0.0) {
							details.setText("Sorry you do not have enough cash");
							input.clear();
							System.out.println(changeBack);
						}
						else{
//							String str = vC.compareItem(s);
//							String str = String.format("%.2f", change);
							details.setText("Thanks for shopping!" + "\nYour change is: $"+ changeBack);
							String item = vC.getItem();
							vM.removeItem(item, String.valueOf((selectVm.getSelectionModel().getSelectedItem())) );
							vM.setChangeCount(vC.getTempNickCount(), vC.getTempDimeCount(), vC.getTempQuartCount(), vC.getTempDollCount());
							vC.clearTemp();
							input.clear();
						}
						vC.setCash(0);
						radio_cash.setSelected(false); // reset radio button after click purchase 
						// reset input text
						
					}
				}
				if(radio_credit.isSelected()&&!details.getText().equals("Hi! How can I help you \nplease pick an item")) {
					details.setText("Thank you! see you later");
					radio_credit.setSelected(false); 
					String item = vC.getItem();
					vM.removeItem(item, String.valueOf((selectVm.getSelectionModel().getSelectedItem())));
					vM.setChangeCount(vC.getTempNickCount(), vC.getTempDimeCount(), vC.getTempQuartCount(), vC.getTempDollCount());
					vC.clearTemp();
					
				}
				input.setText(""); 
				vC.setCash(0);
			}
			
		}
		// radio buttons 
	   @FXML
	    public void getDeposit(ActionEvent event) {
		   
		   if(vC.getItem()==null) {  // check whether the customer has not picked the items
				details.setText("Hi! How can I help you \nplease pick an item");
				
			}
		   else {
			   if(radio_cash.isSelected()) {
				   details.setText("Please insert the cash!");
			   }
			   else {
				   input.setText("");
				   details.setText("");
			   }
			   
		   }
		   	
	    }
	   
	 // Manager screen 
	   private VendingManager vMa = new VendingManager(vM);
	   MenuItem productMnuItem;
	  
	   @FXML
	    void machineReport(ActionEvent event) {
		   String report = vMa.report();
		   report_manager.setText(report);
		   vM.setBalance();
	    }
	  
	   @FXML
	   public void productReport(ActionEvent event) {
		   
		   String report = vMa.productReport();
		   
		   report_manager.setText(report);
	   }
	   @FXML 
	   public void manufacturerReport(ActionEvent event) {
		   String report = vMa.manufacturerReport();
		   report_manager.setText(report);
	   }
	   @FXML 
	   public void locationReport() {
		  
		   String report = vMa.LocationReport(vM);
		   report_manager.setText("------Location Report-------\n");
		   report_manager.appendText(report);
	   }
	   @FXML 
	   public void dryReport() {
		  
		   String report = vMa.DryReport();
		   report_manager.setText("------Dry Items Report-------\n");
		   report_manager.appendText(report);
	   }
	   @FXML 
	   public void RefrigeratedReport() {
		  
		   String report = vMa.RefrigeratedReport();
		   report_manager.setText("------Refrigerated Items Report-------\n");
		   report_manager.appendText(report);
		 
	   }
	   @FXML 
	   public void ExpiredReport() {
		  
		   String report = vMa.ExpiredReport();
		   report_manager.setText("------Expired Items Report-------\n");
		   report_manager.appendText(report);
		  
	   }
		 //technician screen
	   private VendingTechnician tech = new VendingTechnician(vM);
	   @FXML
	   private TextArea txtExpired;
	  @FXML
	  public void initialize() throws IOException{
		  vM.getItems();
		  vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22); // just added this line of code, then we can run the technician function on the Gui
		   listChange.getItems().addAll("Nickels", "Dimes", "Quarters", "Dollars");
		   
		  SpinnerValueFactory<Integer> quantityAdd = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 7);
		   this.SpinQuantity.setValueFactory(quantityAdd);
		   observableList.removeAll(observableList);
		   observableList.addAll(vM.getProducts());
		   listView.getItems().addAll(observableList);
		   
		   //select vm listview
		   observableList1.removeAll(observableList1);
		   observableList1.addAll(vM.getVmNames());
		   selectVm.getItems().addAll(observableList1);
		   
		  
	  }
	  @FXML
	  public void displayQuantity(MouseEvent event) {
		  String quantity =  String.valueOf(((Item) listView.getSelectionModel().getSelectedItem()).getQuantity());
		  if(quantity==null||quantity.isEmpty()) {
			  txtDetails.setText("0");
		  }
		  txtDetails.setText(quantity);
	  }
	  
	   @FXML
	   void restockItem(ActionEvent event) throws IOException  {
		   tech.restock((Item)listView.getSelectionModel().getSelectedItem(), (int)SpinQuantity.getValue(), String.valueOf((selectVm.getSelectionModel().getSelectedItem())));
		   observableList.remove(listView.getSelectionModel().getSelectedItem());
		   observableList.add(listView.getSelectionModel().getSelectedItem());
		   listView.getItems().addAll(observableList);
	   }
	   public void handleShowExpired(ActionEvent event) throws IOException {
		   txtExpired.clear();
		   vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
		   for(Item i: vM.getProducts()) {
			   if(vM.expired(i)) {
				   txtExpired.appendText( i.getName() + " "+ i.getQuantity() +" " + "\n");
			   }
			   
			  }}
	   //CREATE NEW VENDING MACHINE AND WRITE TO NEW TXT FILE
	   @FXML
		//writes new vending machine from template
		public void write_New_Vending() throws IOException {
			// please add your own ItemBank.txt and ItemBank.orig path in your local computer
			 String file_origin = "C:\\Eclipse\\team6_f21-Emmanuel.zip_expanded\\team6_f21-Emmanuel\\Team6_VM\\src\\views\\ItemBank.orig";
			 String write = "C:\\Eclipse\\team6_f21-Emmanuel.zip_expanded\\team6_f21-Emmanuel\\Team6_VM\\src\\views\\ItemBank.txt";
			 BufferedReader bufferedReader = new BufferedReader(new FileReader(file_origin));
		        String txt = "";
		        String curLine;
		        while ((curLine = bufferedReader.readLine()) != null){
		            //process the line as required
		        	if(curLine.equals("Location:")) {
		        		txt += "Location: " + vmLocation.getText() + "\n";
		        		continue;
		        	}
		        	if(curLine.equals("Name:")) {
		        		txt +=  "Name: " + vmName.getText() + "\n";
		        		continue;
		        	}
		        	else {
		            txt += curLine + "\n";
		          
		        	}
		        }
		        System.out.println(txt);
		      
		        bufferedReader.close();

		        try(
		             FileWriter fw = new FileWriter(write, true);
		             BufferedWriter bw = new BufferedWriter(fw);
		             PrintWriter out = new PrintWriter(bw)
		           )
		           {
		        	
		             out.print(txt);
		           }  
		         catch( IOException e ){
		         // File writing/opening failed at some stage.
		         }

		     }
		    
	   @FXML
	   public void viewChange(ActionEvent event) {
			  txtExpired.clear();
			  txtExpired.appendText("Nickels: " + vM.getNickelCount() + "\n");
			  txtExpired.appendText("Dimes: " +vM.getDimeCount() + "\n");
			  txtExpired.appendText("Quarters: " + vM.getQuarterCount() + "\n");
			  txtExpired.appendText("Dollars: " + vM.getDollarCount() + "\n");
			  txtExpired.appendText("Total Sum: $" + vM.getTotalSum() + "\n");
			//  txtExpired.setText(vM.getNickels() + "/n");
		  }
	   
	   //supposed to to execute remove() on all Items
	   //remove already determines when it is expired or not
	   
	   @FXML
		public void handleBtnSubmitChange(ActionEvent event) {		
			String hold = "";		
			ObservableList<String> change;		
			change = listChange.getSelectionModel().getSelectedItems();		
					
			for(String h: change) {		
			hold += h;		
					
			if(hold.equals("Nickels")) {		
				vM.setNickelCount(vM.getNickelCount()  +   Integer.valueOf(txtChangeAmount.getText()));		
			}		
			else if (hold.equals("Dimes")) {		
				vM.setDimeCount(vM.getDimeCount()  +   Integer.valueOf(txtChangeAmount.getText()));		
			}		
			else if(hold.equals("Quarters")) {		
				vM.setQuarterCount(vM.getQuarterCount()  +   Integer.valueOf(txtChangeAmount.getText()));		
			}		
			else if(hold.equals("Dollars")) {		
				vM.setDollarCount(vM.getDollarCount()  +   Integer.valueOf(txtChangeAmount.getText()));		
			}		
			}		
										
		}
		
	   
	   @FXML
	   public void handleRemoveExpired(ActionEvent event) throws IOException {
		   txtExpired.clear();
		   vM.getItem_by_name((String)selectVm.getSelectionModel().getSelectedItem(), 22);
		   for(Item i: vM.getProducts()) {
			   vM.removeItem(i, String.valueOf((selectVm.getSelectionModel().getSelectedItem())));
		   }
		 
	   }
	  
   
}
