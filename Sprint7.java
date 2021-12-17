import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class Sprint7.
 */
public class Sprint7 extends Application {
  
  /** The stage. */
  private Stage stage;
	
  /** The equipment rentals scene. */
  private Scene equipmentRentalsScene;
  
  /** The boat quantity. */
  private TextField boatQuantity = new TextField();
  
  /** The chair quantity. */
  private TextField chairQuantity = new TextField();
  
  /** The umbrella quantity. */
  private TextField umbrellaQuantity = new TextField();
  
  /** The num days. */
  private TextField numDays = new TextField();
  
  /** The continue next step. */
  private Button continueNextStep = new Button("Continue");
  
  /** The cbo boat rentals. */
  private ComboBox<String> cboBoatRentals = new ComboBox<>();
  
  /** The boat titles. */
  private String[] boatTitles = {"paddle board: $65", "single kayak: $45", "tandem kayak: $65", "3 person canoe: $75", "None"};
  
  /** The cbo chair rentals. */
  private ComboBox<String> cboChairRentals = new ComboBox<>();
  
  /** The chair titles. */
  private String[] chairTitles = {"sling low: $5", "chaise lounge: $7", "folding classic: $5", "adirondack: $10", "None"};
  
  /** The cbo umbrella rentals. */
  private ComboBox<String> cboUmbrellaRentals = new ComboBox<>();
  
  /** The umbrella titles. */
  private String[] umbrellaTitles = {"chair-side: $5", "single: $10", "family: $15", "tent: $20", "None"};
  
  /** The boat rental index. */
  private int boatRentalIndex;
  
  /** The chair rental index. */
  private int chairRentalIndex;
  
  /** The umbrella rental index. */
  private int umbrellaRentalIndex;
  
  /** The cbo boat quantity. */
  private int cboBoatQuantity = 0;
  
  /** The cbo chair quantity. */
  private int cboChairQuantity = 0;
  
  /** The cbo umbrella quantity. */
  private int cboUmbrellaQuantity = 0;
  
  /** The num days rental. */
  private int numDaysRental;
  
  /** The customer items. */
  private Equipment customerItems = new Equipment();
  
  /** The dates scene. */
  private Scene datesScene;
  
  /** The start date. */
  private TextField startDate = new TextField();
  
  /** The end date. */
  private TextField endDate = new TextField();
  
  /** The confirm reservation. */
  private Button confirmReservation = new Button("Confirm Reservation");
  
  /** The reservation summary scene. */
  private Scene reservationSummaryScene;
  
  /** The total tax. */
  private TextField totalTax = new TextField();
  
  /** The total cost. */
  private TextField totalCost = new TextField();
  
  /** The price per rental item boats. */
  private TextField pricePerRentalItemBoats = new TextField();
  
  /** The price per rental item chairs. */
  private TextField pricePerRentalItemChairs = new TextField();
  
  /** The price per rental item umbrellas. */
  private TextField pricePerRentalItemUmbrellas = new TextField();
  
  /** The invoice. */
  private Invoice invoice = new Invoice();
  
  /** The location scene. */
  private Scene locationScene;
  
  /** The location cost. */
  private TextField locationCost = new TextField();
  
  /** The location titles. */
  private String[] locationTitles = {"Vacation Venue: $0", "Bella's Beach: $10", "Griffin's Grove: $20"};
  
  /** The cbo location rentals. */
  private ComboBox<String> cboLocationRentals = new ComboBox<>();
  
  /** The reservation dates. */
  private RentalDates reservationDates = new RentalDates();
  
  /** The customer information scene. */
  private Scene customerInformationScene;
  
  /** The name. */
  private TextField name = new TextField();
  
  /** The email address. */
  private TextField emailAddress = new TextField();
  
  /** The phone number. */
  private TextField phoneNumber = new TextField();
  
  /** The home address. */
  private TextField homeAddress = new TextField();
  
  /** The customer information. */
  private Customer customerInformation = new Customer();
  
  /** The sorted dates. */
  private Button sortedDates = new Button("Sort Reservation Dates");
  
  /** The checkout. */
  private Button checkout = new Button("Checkout");
  
  /** The continue next step 1. */
  private Button continueNextStep1 = new Button("Continue");
  
  /** The continue next step 2. */
  private Button continueNextStep2 = new Button("Continue");
  
  /** The continue next step 3. */
  private Button continueNextStep3 = new Button("Continue");
  
  /** The add reservation. */
  private Button addReservation = new Button("Make Another Reservation");
  
  /** The exit. */
  private Button exit = new Button("Exit");
  
  /** The place holder rental cost. */
  private TextField placeHolderRentalCost = new TextField();
  
  /** The place holder location cost. */
  private TextField placeHolderLocationCost = new TextField();
  
  /** The invoice scene. */
  private Scene invoiceScene;
  
  /** The invoice rental cost. */
  private TextField invoiceRentalCost = new TextField();
  
  /** The invoice location cost. */
  private TextField invoiceLocationCost = new TextField();
  
  /** The invoice tax. */
  private TextField invoiceTax = new TextField();
  
  /** The invoice total cost. */
  private TextField invoiceTotalCost = new TextField();

  /* (non-Javadoc)
   * @see javafx.application.Application#start(javafx.stage.Stage)
   */
  @Override public void start(Stage stage) {
    this.stage = stage;
    customerInformationScene = createCustomerInformationScene();
    locationScene = createLocationScene();
    equipmentRentalsScene = createEquipmentRentalsScene();
    datesScene = createDatesScene();
    reservationSummaryScene = createReservationSummaryScene();
    invoiceScene = createInvoiceScene();

    stage.setScene(customerInformationScene);
    stage.show();
  }
  
  /**
   * Creates the customer information scene.
   *
   * @return the scene
   */
  private Scene createCustomerInformationScene() {
	  GridPane gridPane = new GridPane();
	    gridPane.setHgap(20);
	    gridPane.setVgap(20);
	    gridPane.setStyle("-fx-font-size: 15; -fx-padding: 10;");
	    
	    Label welcome = new Label("Welcome to Victoria's Vacation Venue");
	    gridPane.add(welcome, 1, 0);
	    Label title = new Label("Customer Contact Information");
	    gridPane.add(title, 1, 2);
	    gridPane.add(new Label("Enter your name: "), 0, 3);
	    gridPane.add(name, 1, 3);
	    gridPane.add(new Label("Enter your email address: "), 0, 4);
	    gridPane.add(emailAddress, 1, 4);
	    gridPane.add(new Label("Enter your phone number: "), 0, 5);
	    gridPane.add(phoneNumber, 1, 5);
	    gridPane.add(new Label("Enter your home address: "), 0, 6);
	    gridPane.add(homeAddress, 1, 6);
	    gridPane.add(continueNextStep1, 1, 7);
	    gridPane.setAlignment(Pos.CENTER);
	    welcome.setFont(Font.font("Times New Roman", 38));
	    title.setFont(Font.font("Times New Roman", 24));
	    
	    name.setMaxWidth(250);
	    emailAddress.setMaxWidth(250);
	    phoneNumber.setMaxWidth(250);
	    homeAddress.setMaxWidth(450);
	    
	    EventHandler<ActionEvent> handler = e -> {
	    	customerInformation();
	    	stage.setScene(locationScene);
	    };
	    
	    continueNextStep1.setOnAction(handler);

	    return new Scene(gridPane, 1200, 650);
  }
  
  /**
   * Customer information.
   */
  private void customerInformation() {
	  customerInformation.setName(name.getText());
	  customerInformation.setEmail(emailAddress.getText());
	  customerInformation.setPhoneNumber(phoneNumber.getText());
	  customerInformation.setAddress(homeAddress.getText());
  }
  
  /**
   * Creates the location scene.
   *
   * @return the scene
   */
  private Scene createLocationScene() {
	  GridPane gridPane = new GridPane();
	    gridPane.setHgap(20);
	    gridPane.setVgap(20);
	    gridPane.setStyle("-fx-font-size: 15; -fx-padding: 10;");
	    
	    Label title = new Label("Reservation Location");
	    gridPane.add(title, 1, 0);
	    gridPane.add(new Label("Enter the location: "), 0, 1);
	    gridPane.add(cboLocationRentals, 1, 1);
	    gridPane.add(continueNextStep2, 1, 2);
	    gridPane.setAlignment(Pos.CENTER);
	    title.setFont(Font.font("Times New Roman", 24));
	    gridPane.setHalignment(continueNextStep2, HPos.CENTER);
	    
	    cboLocationRentals.setPrefWidth(210);
	    cboLocationRentals.setValue("Available Locations");
	    ObservableList<String> reservationLocation = FXCollections.observableArrayList(locationTitles);
	    cboLocationRentals.getItems().addAll(locationTitles); 
	    
	    EventHandler<ActionEvent> handler = e -> {
	    	calculateLocationCost(reservationLocation.indexOf(cboLocationRentals.getValue()));
	    	stage.setScene(equipmentRentalsScene);
	    };
	    
	    continueNextStep2.setOnAction(handler);

	    return new Scene(gridPane, 1200, 650);
  }

  /**
   * Calculate location cost.
   *
   * @param locationRental the location rental
   */
  private void calculateLocationCost(int locationRental) {
	  RentalLocation customerReservation = new RentalLocation();
	  customerReservation.setReservation(locationRental);
	  double locationCostReservation = customerReservation.calculateLocationCost();
	  String locationCostReservationString = Double.toString(locationCostReservation);
	  placeHolderLocationCost.setText(locationCostReservationString);
  }
  
  /**
   * Creates the equipment rentals scene.
   *
   * @return the scene
   */
  private Scene createEquipmentRentalsScene() {
	  GridPane gridPane = new GridPane();
	    gridPane.setHgap(20);
	    gridPane.setVgap(20);
	    gridPane.setStyle("-fx-font-size: 15; -fx-padding: 10;");
	    
	    Label title = new Label("Equipment Rentals");
	    gridPane.add(title, 1, 0);
	    gridPane.add(new Label("3 days or more 10% discount on boats."), 1, 1);
	    gridPane.add(new Label("4 chairs or more 10% discount."), 2, 1);
	    gridPane.add(new Label("Enter equipment item: "), 0, 2);
	    gridPane.add(cboBoatRentals, 1, 2);
	    gridPane.add(cboChairRentals, 2, 2);
	    gridPane.add(cboUmbrellaRentals, 3, 2);
	    gridPane.add(new Label("Enter the quantity: "), 0, 3);
	    gridPane.add(boatQuantity, 1, 3);
	    gridPane.add(chairQuantity, 2, 3);
	    gridPane.add(umbrellaQuantity, 3, 3);
	    gridPane.add(new Label("Enter the number of days for the rental: "), 0, 4);
	    gridPane.add(numDays, 1, 4);
	    numDays.setText("1");
	    gridPane.add(continueNextStep3, 1, 5);
	    
	    gridPane.setAlignment(Pos.CENTER);
	    gridPane.setHalignment(continueNextStep3, HPos.CENTER);
	    title.setFont(Font.font("Times New Roman", 24));
	    
	    cboBoatRentals.setPrefWidth(210);
	    cboBoatRentals.setValue("Boat Rentals");
	    ObservableList<String> boatItems = FXCollections.observableArrayList(boatTitles);
	    cboBoatRentals.getItems().addAll(boatItems); 
	    
	    cboChairRentals.setPrefWidth(210);
	    cboChairRentals.setValue("Chair Rentals");
	    ObservableList<String> chairItems = FXCollections.observableArrayList(chairTitles);
	    cboChairRentals.getItems().addAll(chairItems); 
	    
	    cboUmbrellaRentals.setPrefWidth(210);
	    cboUmbrellaRentals.setValue("Umbrella Rentals");
	    ObservableList<String> umbrellaItems = FXCollections.observableArrayList(umbrellaTitles);
	    cboUmbrellaRentals.getItems().addAll(umbrellaItems); ///////////////// life jackets 

	    EventHandler<ActionEvent> handler = e -> {
	    	equipmentSelection(boatItems.indexOf(cboBoatRentals.getValue()), chairItems.indexOf(cboChairRentals.getValue()), umbrellaItems.indexOf(cboUmbrellaRentals.getValue()));
	    	stage.setScene(datesScene);
	    };
	    
	    continueNextStep3.setOnAction(handler);
	     
	    return new Scene(gridPane, 1200, 650);
	  }
  
  /**
   * Equipment selection.
   *
   * @param boatIndex the boat index
   * @param chairIndex the chair index
   * @param umbrellaIndex the umbrella index
   */
  private void equipmentSelection(int boatIndex, int chairIndex, int umbrellaIndex) {
	DecimalFormat df = new DecimalFormat("0.00");
	
	boatRentalIndex = boatIndex;
	chairRentalIndex = chairIndex;
	umbrellaRentalIndex = umbrellaIndex;
	
	if (boatQuantity.getText() != "") {
		if (boatIndex != 4) {
		    cboBoatQuantity = Integer.parseInt(boatQuantity.getText());
		}
	}
	if (chairQuantity.getText() != "") {
		if (chairIndex != 4) {
			cboChairQuantity = Integer.parseInt(chairQuantity.getText());
		}
	}
	if (umbrellaQuantity.getText() != "") {
		if (umbrellaIndex != 4) {
			cboUmbrellaQuantity = Integer.parseInt(umbrellaQuantity.getText());
		}
	}
	
    numDaysRental = Integer.parseInt(numDays.getText());
    
    if (boatIndex != 4) {
    	if (cboBoatQuantity > 0) {
    		customerItems.setBoats(boatRentalIndex, cboBoatQuantity);
    	}
    }
    if (chairIndex != 4) {
    	if (cboChairQuantity > 0) {
    		customerItems.setChairs(chairRentalIndex, cboChairQuantity);
    	}
    }
	if (umbrellaIndex != 4) {
		if (cboUmbrellaQuantity > 0) {
			customerItems.setUmbrellas(umbrellaRentalIndex, cboUmbrellaQuantity);
		}
	}
	    double boatsCost = customerItems.calculateBoatsCost();
		double chairsCost = customerItems.calculateChairsCost();
		double umbrellasCost = customerItems.calculateUmbrellasCost();
		
		if (boatsCost > 0 && numDaysRental >= 3) {
		  boatsCost = boatsCost - (boatsCost * .1);
		}
		if (chairsCost > 0 && customerItems.getChairCounter() >= 4) {
		  chairsCost = chairsCost - (chairsCost * .1);
		}

		double equipmentCost = boatsCost + chairsCost + umbrellasCost;				// Calculate the equipment cost.
		double rentalCost = equipmentCost * numDaysRental;
		
		customerItems.setEquipmentCost();
		customerItems.setBoatCounter();
		customerItems.setChairCounter();
		customerItems.setUmbrellaCounter();
		
		if (cboBoatQuantity == 0 || boatTitles[boatRentalIndex] == "None") {
			pricePerRentalItemBoats.setText("");
		}
		else {
			pricePerRentalItemBoats.setText(cboBoatQuantity + " " + boatTitles[boatRentalIndex]);
		}
		if (cboChairQuantity == 0 || chairTitles[chairRentalIndex] == "None") {
			 pricePerRentalItemChairs.setText("");
		}
		else {
			 pricePerRentalItemChairs.setText(cboChairQuantity +  " " + chairTitles[chairRentalIndex]);
		}
		if (cboUmbrellaQuantity == 0 || umbrellaTitles[umbrellaRentalIndex] == "None") {
			pricePerRentalItemUmbrellas.setText("");
		}
		else {
			pricePerRentalItemUmbrellas.setText(cboUmbrellaQuantity + " " + umbrellaTitles[umbrellaRentalIndex]);
		}
		
		String rentalCostString = Double.toString(rentalCost);
		
	    placeHolderRentalCost.setText(rentalCostString);
  }

	  /**
  	 * Creates the dates scene.
  	 *
  	 * @return the scene
  	 */
  	private Scene createDatesScene() {
		  GridPane gridPane = new GridPane();
	      gridPane.setHgap(20);
	      gridPane.setVgap(20);
	      gridPane.setAlignment(Pos.CENTER);
	      gridPane.setStyle("-fx-font-size: 15; -fx-padding: 10;");
		    
	      Label title = new Label("Reservation Dates");
	      title.setFont(Font.font("Times New Roman", 24));
	      gridPane.add(title, 1, 0);
	      gridPane.add(new Label("Enter reservation start date(dd/mm/yyyy): "), 0, 1);
	      gridPane.add(startDate, 1, 1);
	      gridPane.add(new Label("Enter reservation end date(dd/mm/yyyy): "), 0, 2);
	      gridPane.add(endDate, 1, 2);
	      gridPane.add(confirmReservation, 1, 3);
	      gridPane.setHalignment(confirmReservation, HPos.CENTER);
	      
	      EventHandler<ActionEvent> handler = e -> {
	    	    datesSelection();
		    	stage.setScene(reservationSummaryScene);
		  };
	      
	      confirmReservation.setOnAction(handler);

	    return new Scene(gridPane, 1200, 650);
	  }
	  
	  /**
  	 * Dates selection.
  	 */
  	private void datesSelection() {
	    Date datesEqual = new Date(0);                // Create Date objects
		Date startDateReservation = datesEqual;     
	    Date endDateReservation = datesEqual;
	    Date currentDate = datesEqual;
		SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");
		Date todaysDate = Calendar.getInstance().getTime();
		String todayDate = dates.format(todaysDate);
			
			try {
			  currentDate = dates.parse(todayDate);
			}
			catch (ParseException e) {
				stage.setScene(datesScene);
			}
			
			try {
				if (startDate.getText() != "") {
				startDateReservation = dates.parse(startDate.getText());
			}
			} 
			  catch (ParseException e) {
				  stage.setScene(datesScene);
			}
			  try {		
				  if (startDate.getText() != "") {
						endDateReservation = dates.parse(endDate.getText());
				  }
			  } 
			  catch (ParseException e) {
				  stage.setScene(datesScene);
			  }
			reservationDates.setStartDate(startDateReservation); 
			reservationDates.setEndDate(endDateReservation);
			long numDaysReservation = reservationDates.calculateDates(); 
			calculateTotalCosts();
	  }
	  
	  /**
  	 * Calculate total costs.
  	 */
  	private void calculateTotalCosts() {
		  	double subTotal1 = Double.parseDouble(placeHolderRentalCost.getText());
		    double subTotal2 = Double.parseDouble(placeHolderLocationCost.getText());
		    double totalCostReservation = subTotal1 + subTotal2;
		    double totalTaxReservation = totalCostReservation * .06;
		    totalCostReservation += totalTaxReservation;
		  
		    totalTax.setText(String.format("$%.2f", totalTaxReservation));
		    totalCost.setText(String.format("$%.2f", totalCostReservation));
		    locationCost.setText(String.format("$%.2f", subTotal2));
		    invoice.setTotalRentalCost(subTotal1);
		    invoice.setTotalDeliveryCost(subTotal2);
		    invoice.setTotalTax(totalTaxReservation);
		    invoice.setTotalCost(totalCostReservation);
		    
		    invoiceRentalCost.setText(String.format("$%.2f", invoice.getTotalRentalCost()));
		    invoiceLocationCost.setText(String.format("$%.2f", invoice.getTotalDeliveryCost()));
		    invoiceTax.setText(String.format("$%.2f", invoice.getTotalTax()));
		    invoiceTotalCost.setText(String.format("$%.2f", invoice.getTotalCost()));
	  }
	  
	  /**
  	 * Creates the reservation summary scene.
  	 *
  	 * @return the scene
  	 */
  	private Scene createReservationSummaryScene() {
		  GridPane gridPane = new GridPane();
	      gridPane.setHgap(20);
	      gridPane.setVgap(20);
	      gridPane.setStyle("-fx-font-size: 15; -fx-padding: 10;");
	      
	      Label title = new Label("Reservation Summary");
	      gridPane.add(title, 1, 0);
	      gridPane.add(new Label("Price Per Rental Item(Boats, Chairs, Umbrellas): "), 0, 1);
	      gridPane.add(pricePerRentalItemBoats, 1, 1);
	      gridPane.add(pricePerRentalItemChairs, 2, 1);
	      gridPane.add(pricePerRentalItemUmbrellas, 3, 1);
	      gridPane.add(new Label("Delivery Cost: "), 0, 2);
	      gridPane.add(locationCost, 1, 2);
	      gridPane.add(new Label("Rental Tax: "), 0, 3);
	      gridPane.add(totalTax, 1, 3);
	      gridPane.add(new Label("Rental Cost: "), 0, 4);
	      gridPane.add(totalCost, 1, 4);
	      gridPane.add(addReservation, 1, 5);
	      gridPane.add(checkout, 2, 5);
	      
	      gridPane.setHalignment(addReservation, HPos.CENTER);
	      gridPane.setHalignment(checkout, HPos.CENTER);
	      gridPane.setAlignment(Pos.CENTER);
		  title.setFont(Font.font("Times New Roman", 24));
		  
	      totalTax.setEditable(false);
	      totalCost.setEditable(false);
	      pricePerRentalItemBoats.setEditable(false);
	      pricePerRentalItemChairs.setEditable(false);
	      pricePerRentalItemUmbrellas.setEditable(false);
	      locationCost.setEditable(false);
	      
	      EventHandler<ActionEvent> firstScene = e -> {
		    	stage.setScene(locationScene);
		  };
	      
	      addReservation.setOnAction(firstScene);
	      
	      EventHandler<ActionEvent> checkoutScene = e -> {
		    	stage.setScene(invoiceScene);
		  };
	      
	      checkout.setOnAction(checkoutScene);
	      
	      return new Scene(gridPane, 1200, 650);
	  }
	  
	  /**
  	 * Creates the invoice scene.
  	 *
  	 * @return the scene
  	 */
  	private Scene createInvoiceScene() {
		  GridPane gridPane = new GridPane();
	      gridPane.setHgap(20);
	      gridPane.setVgap(20);
	      gridPane.setAlignment(Pos.CENTER);
	      gridPane.setStyle("-fx-font-size: 15; -fx-padding: 10;");
	      
	      Label title = new Label("Invoice Summary");
	      gridPane.add(title, 1, 0);
	      gridPane.add(new Label("Total Rental Cost: "), 0, 1);
	      gridPane.add(invoiceRentalCost, 1, 1);
	      gridPane.add(new Label("Total Delivery Cost: "), 0, 2);
	      gridPane.add(invoiceLocationCost, 1, 2);
	      gridPane.add(new Label("Total Tax: "), 0, 3);
	      gridPane.add(invoiceTax, 1, 3);
	      gridPane.add(new Label("Total Cost: "), 0, 4);
	      gridPane.add(invoiceTotalCost, 1, 4);
	      gridPane.add(exit, 1, 5);
	      
	      gridPane.setHalignment(exit, HPos.CENTER);
	      title.setFont(Font.font("Times New Roman", 24));
	      
	      invoiceRentalCost.setEditable(false);
	      invoiceLocationCost.setEditable(false);
	      invoiceTax.setEditable(false);
	      invoiceTotalCost.setEditable(false);
	      
	      EventHandler<ActionEvent> exitScene = e -> {
		    stage.close();
		  };
	      
	      exit.setOnAction(exitScene);
	      
	      return new Scene(gridPane, 1200, 650);
	  }

	  /**
  	 * The main method.
  	 *
  	 * @param args the arguments
  	 */
  	public static void main(String[] args) {
		  launch(args);
	  }
	}