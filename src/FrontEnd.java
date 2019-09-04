
/*
 * Creates the front end application of the system that handles reading and performing transactions
 * on available user and ticket files
 */
import java.io.*;
import java.util.*;

public class FrontEnd extends BackEnd {
	
	
	static ArrayList <Ticket>ticketsArray = new ArrayList<Ticket>();//Every users in the system
	static ArrayList <User>userArray = new ArrayList<User>();//Every users in the system
	
	static String eventTitle = "";
	static String seller = "";
	static int ticketAmount = 0;
	static double ticketPrice = 0;
	
	static String userName = "";
	static String accountType = "";
	static double balance = 0;
	static boolean userFound = false;
	static double sellerBalance = 0;
	
	
	static String input1 = "";
	static String input2 = "";
	static String input3 = "";
	static String input4 = "";
	static String input5 = "";
	static String input6 = "";
	static String input7 = "";
	
	/*
	 * What the program executes on start
	 */
	public static void main(String[] args) throws IOException {

		login();	
	}
	
	
	/*
	 * Creates the login screen for the users;
	 */
	public static void login() throws IOException {
		
		//Reads the user files
		System.out.println("Please give the name of the file of the user");
		//Scanner file = new Scanner(System.in);
		String fileName = "login.txt";
		readUserFile(fileName);
		
		//Reads the ticket file
		System.out.println("Please give the name of the file of the ticket");
		//Scanner fileT = new Scanner(System.in);
		String ticketFileName = "ticket.txt";
		readTicketFile(ticketFileName);
		
		System.out.println("Reading JUnit test case");
		readUserActions("userActions.txt");
		
		for(Ticket t: ticketsArray) {
			System.out.println(t.getEventName());
		}
		System.out.println("Please give the name of the user");
		Scanner usr = new Scanner(System.in);
		String obj = "apalvetz";
		
			for(User u : userArray) {
				if(u.getUserName().equals(obj)) {
				userName = u.getUserName();
				accountType = u.getAccountType();
				balance = u.getBalance();
				userFound = true;
				break;
				}
			}
		
		if(userFound == false) {
			System.out.println("User not found!");
			login();
		}
		
		System.out.println("Welcome! " + userName);
		switch(accountType) {
		case "AA":
			adminInterface();
			break;
		case "BS":
			buyerInterface();
			break;
		case "SS":
			sellerInterface();
			break;
		default:
			login();
		}
		
	}
	
	/*
	 * Creates the interface for the admin user
	 */
	public static void adminInterface() throws IOException {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Select what you want to perform: ");
		System.out.println("1. Create a user");
		System.out.println("2. Delete a user");
		System.out.println("3. Sell a ticket");
		System.out.println("4. Buy a ticket");
		System.out.println("5. Refund");
		System.out.println("6. Add Credit");
		System.out.println("7. Logout");
		
		String selection = myObj.nextLine();
		switch(selection){
		case "1":
			//createUser();
			break;
		case "2":
			delete();
			break;
		case "3":
			sell();
			break;
		case "4":
			buy();
			break;
		case "5":
			//refund();
			break;
		case "6":
			addCredit();
			break;
		case "7":
			logout();
			updateUserFile(userArray, userName, "ticket.txt", "login.txt");
			break;
		default :
			System.out.println("Invalid choice!");
			adminInterface();
			break;
		}
	}
	
	/*
	 * Creates the buyer interface with there transactions
	 */
	public static void buyerInterface() throws IOException {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Select what you want to perform: ");
		System.out.println("1. Buy a ticket");
		System.out.println("2. Add credit");
		System.out.println("3. Logout");
		
		String selection = myObj.nextLine();
		switch(selection){
		case "1":
			buy();
			break;
		case "2":
			addCredit();
			break;
		case "3":
			logout();
			break;
		default :
			System.out.println("Invalid choice!");
			buyerInterface();
			break;
		}
	}
	
	/*
	 * Creates the seller interface with there transaction
	 */
	public static void sellerInterface() throws IOException {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Select what you want to perform: ");
		System.out.println("1. Sell a ticket");
		System.out.println("2. Add credit");
		System.out.println("3. Logout");
		
		String selection = myObj.nextLine();
		switch(selection){
		case "1":
			sell();
			break;
		case "2":
			addCredit();
			break;
		case "3":
			logout();
			break;
		default :
			System.out.println("Invalid choice!");
			sellerInterface();
			break;
		}
	}
	
	/*
	 * Reads a file
	 * @param String fileName
	 * @param String type
	 */
	public static void readUserFile(String fileName){

		try {
		    File tmp = new File("/Users/prachikapadia/Desktop/cps707/testFiles/" + fileName);
		    Scanner sc = new Scanner(tmp);

		    sc.useDelimiter("_|\\n");

		    while (sc.hasNext()) {
			userName = sc.next().trim();
			
			if (eventTitle.equals("END")) {
				break;
			}
			accountType = sc.next().trim();
			balance = Double.parseDouble(sc.next().trim());			
			userArray.add(new User(userName, accountType, balance));
		   }
		}catch (Exception e) {}
		
	}
	
	/*
	 * Reads a file
	 * @param String fileName
	 * @param String type
	 */
	public static void readUserActions(String fileName){

		try {
		    File tmp = new File("/Users/prachikapadia/Desktop/cps707/testFiles/" + fileName);
		    Scanner sc = new Scanner(tmp);

		    sc.useDelimiter("_|\\n");

		    while (sc.hasNext()) {
			input1 = sc.next().trim();			
			input2 = sc.next().trim();
			input3 = sc.next().trim();			
			input4 = sc.next().trim();
		   }
		}catch (Exception e) {}
		
	}
	
	/*
	 * Reads in the available ticket file
	 * @param String fileName
	 */
	public static void readTicketFile(String fileName) {
		try {
		    File tmp = new File("/Users/prachikapadia/Desktop/cps707/testFiles/" + fileName);
		    Scanner sc = new Scanner(tmp);

		    sc.useDelimiter("_|\\n");

		    while (sc.hasNext()) {
			eventTitle = sc.next().trim();
			
			if (eventTitle.equals("END")) {
				break;
			}
			seller = sc.next().trim();
			ticketAmount = Integer.parseInt(sc.next().trim());
			ticketPrice = Double.parseDouble(sc.next());
			ticketsArray.add(new Ticket(eventTitle, seller, ticketAmount, ticketPrice));
		   }
		}catch (Exception e) {}
	}
	
	
	/*
	 * Logs the user out of the system
	 */
	public static void logout() throws IOException{
		System.out.println(userName + " Logged out Successfully!");
		dailyTransactionWriter("00",userName, accountType, balance);
		updateTicketFile(ticketsArray, userName, "newTicket.txt", "newUserFile.txt");
		updateUserFile(userArray, userName, "newTicket.txt", "newUserFile.txt");
		login();
	}
	
	/*
	 * Allows the user to create a new user
	 * @param String userName
	 */
	public static String createUser(String userName, String newuserName, double credit, String accType) throws IOException{
		
		String result = "";
		
		userArray.add(new User ("pkapadia", "AA", 200.0));
		//String newuserName;
       	/*System.out.println("Enter a new username:  or 0 to cancel");
       	Scanner scan = new Scanner(System.in);
      	newuserName = scan.nextLine();
      	*/
      	//Checks to see if the username is more than 15 characters
      	if(newuserName.length() > 15) {
      		System.out.println("Too many characters! Please try again");
      		result =  "Too long";
      		return result;    		
      		//createUser();
      	}
      	
      	//Checks to see if the balance is more than 999,999
      	if(credit > 999999){
      		System.out.println("The balance is too high please try again");
      		//createUser();
      		result = "The balance is too high please try again";
      		return result;
      	}
      	
      	//Checks to see if the user already exists
      	for(User u : userArray) {
			if(u.getUserName().equals(newuserName)) {
			System.out.println("User already exists!");
			return "User already exists!";
			//createUser();
			//break;
			}
		}
      	   	
      	//Cancel option
      	if(newuserName.equals("0")){
      		adminInterface();		
      	}
      	else {
      		//String accType;
      		//double credit;
      		String creditstr; //the string format of the credit in the account
      		Scanner scan2 = new Scanner(System.in);
      		
      		if (accType != null && !accType.isEmpty()) {
      			System.out.println("Type of user (AA, SS, BS): ");
      			result = "AA";
      			return result; 
      		}
      		
          	System.out.println("Set the balance amount: ");
          	creditstr = scan2.nextLine();
          	//credit = Double.parseDouble(creditstr);
          	
          	userArray.add(new User(newuserName, accType, credit));
          	dailyTransactionWriter("01", userName, "AA", balance);
          	updateUserFile(userArray, userName, "newTicket.txt", "newUserFile.txt");
          	
          	System.out.println("New user added!");
          	for(User u : userArray) {
          		System.out.println(u.getUserName() +  " " + u.getAccountType() + " " + u.getBalance() );
          	}
         
          	result = "01" + "_" + userName + "_" + "AA" + balance;
          	adminInterface();
          	
      	}
      	return result;

	}
	
	

	/*
	 * Allows the user to delete the account
	 * @param String userName
	 */
	public static void delete() throws IOException{
	
       	String usertoDelete;
       	System.out.println("Enter the username you wish to remove: ");
       	System.out.println("Enter 0 to cancel");
       	Scanner scan = new Scanner(System.in);
      	usertoDelete = scan.nextLine();

      	//The cancel selection
      	if(usertoDelete.equals("0")){
      		adminInterface();  		
      	}
      	else {
      		//Removes the user
      		for(User u : userArray) {
          		if(u.getUserName().equals(usertoDelete)){
          			u.userName = "";
          			u.balance = 0;
          			u.accountType = "";
          		}
          	}
      	System.out.println("You have deleted the account: " + usertoDelete);
      	dailyTransactionWriter("02",userName, accountType, balance);
      	updateUserFile(userArray, userName, "ticket.txt", "login.txt");
      	
      	for(User u : userArray) {
			System.out.println("Remaining accounts: " + u.getUserName() + " " + u.getAccountType() + " " + u.getBalance());
			}
		}
      	adminInterface();
      	}
	
	
	/*
	 * Sells tickets to a potential buyer
	 */
	public static void sell() throws IOException{	
		System.out.println("Please list the event title");
		Scanner scan = new Scanner(System.in);
		String event = scan.nextLine();
		
		//Checks if the event title is greater than 25 characters
		if(event.length() > 25) {
			System.out.println("Event title is too long!");
			sell();
		}
		
		System.out.println("Please list the sell price");
		double price = scan.nextDouble();
		
		//Checks if the price is over 999.99
		if(price > 999.99){
			System.out.println("The max price to sell a ticket is 999.99 please try again!");
			price = scan.nextDouble();
		}
		
		System.out.println("Please list the number of tickets for sale");
		int ticketAmount = scan.nextInt();
		
		//Checks if the amount of tickets sold is greater than 100
		if(ticketAmount > 100){
			System.out.println("The number of tickets allowed to sell is 100 please try again!");
			ticketAmount = scan.nextInt();
		}
		
		System.out.println(ticketAmount + " tickets are for sale at " + price + " for the event " + event);
		ticketsArray.add(new Ticket(event, userName, ticketAmount, price));
		dailyTransactionWriterSell("03", event, userName, ticketAmount, price);
		updateTicketFile(ticketsArray, userName, "newTicket.txt", "newUserFile.txt");
		
		switch(accountType) {
		case "AA":
			adminInterface();
			break;
		case "BS":
			buyerInterface();
			break;
		case "SS":
			sellerInterface();
			break;
		default:
			sell();
		}

	}
	
	
	/*
	 * Allows the user to buy tickets from a seller
	 */
	public static void buy() throws IOException{
		String buy, sell, event, result;
    	int ticket = 0;
    	
    	String eventTitle = "";//The sellers event title
    	double ticketPrice = 0;//The sellers ticket price
    	int ticketAmountX = 0;//The sellers inventory
    	double sellPrice = 0;//The total sale cost
    	String eventTitleX = "";
    	
    	//Displays all the sellers and there offerings
    	for(Ticket t : ticketsArray) {
    		System.out.println("Event: " + t.getEventName() +"\n" );
    		System.out.println("Ticket Price: " + t.getTicketPrice() + "\n");
    		System.out.println("Tickets Available: " + t.getTicketAmount() +"\n");
    		System.out.println("Seller: " + t.getSellerName() + "\n");
    	}
    	
    	System.out.println("Enter the event title: ");
    	Scanner scanner = new Scanner(System.in);
    	event = scanner.nextLine();
    	
    	
    //Checks to see if the event that they want to buy from exists
    	/*for(Ticket t : ticketsArray) {
    		 if(!t.getEventName().contentEquals(eventTitleX)) {
    		    	System.out.println("The event does not exist! Please try again");
    		    	buy();
    		    }
    	}*/
   
    
    System.out.println("Enter seller's username: ");
    Scanner scanner1 = new Scanner(System.in);
    sell = scanner1.nextLine();

    seller = sell;
    //Checks to see if the seller exists  
   /* for(Ticket t : ticketsArray) {
		 if(!t.seller.equals(seller)) {
		    	System.out.println("The seller does not exist! Please try again");
		    	buy();
		    }
	}*/
    
    System.out.println("Enter buyer's username ");
    Scanner scanner2 = new Scanner(System.in);
    buy = scanner2.nextLine();
    
    System.out.println("Enter the number of tickets to purchase: ");
    Scanner scanner3 = new Scanner(System.in);
    ticket = scanner3.nextInt();
    
    //Ensures that at most 4 tickets can be purchased
    if(ticket > 4) {
    	System.out.println("At most 4 tickets can be purchased!");
    	buy();
    }
    
    //Gets the sellers ticket amount and the price
    for(Ticket t : ticketsArray) {
		 if(t.getSellerName().contentEquals(seller)) {
		    	ticketAmountX = t.getTicketAmount();
		    	ticketPrice = t.getTicketPrice();		    	
		    }
	}
    
    //Gets the sellers balance 
    for(User u : userArray) {
    	if(u.getUserName().contentEquals(seller)) {
    		sellerBalance = u.getBalance();
    	}
    }
  
 
    //Checks to see if enough tickets are for sale
    if(ticket > ticketAmount) {
    	System.out.println("There are not enough tickets for sale!");
    	buy();
    }
    
    sellPrice = ticketPrice * ticket;//The total cost of the transaction
    System.out.println("The total cost is: " + sellPrice);
  
    //Checks if the buyers has enough funds
    if(balance < sellPrice) {
    	System.out.println("Insufficient Funds!");
    	buy();
    }
    
    System.out.println("Are you sure that you want to make the purchase?(yes/no)");
    Scanner scan = new Scanner(System.in);
    result = scan.nextLine();
    
    
    //Checks if the purchase is accepted
    if(result.contentEquals("yes")){
    			balance -= sellPrice;//Subtracts the buyers balance 
    			ticketAmountX -= ticket;//The total amount of tickets left
    			sellerBalance += sellPrice;//Adds credits to the seller
    			
    			 for(Ticket t : ticketsArray) {
    				 if(t.getSellerName().equals(sell)) {
    				    	ticketAmount = ticketAmountX;
    				  		    	
    				    }
    			}
    			
    			//Sets the sellers balance to the new balance
    			 for(User u  : userArray) {
    				 if(u.getUserName().contentEquals(seller)) {
    				    	u.balance = sellerBalance;
    				  		    	
    				    }
    			}
    			 
     	 
    		 System.out.println(buy + " has bought " + ticket + " tickets from " + sell + "\n");
    		 System.out.println(seller + " has " + ticketAmountX + " tickets left");
    		 System.out.println(seller + " has " + sellerBalance + " left in the account");
    	  
    	    dailyTransactionWriterSell("04", eventTitle, seller, ticketAmountX, ticketPrice);
    	    updateTicketFile(ticketsArray, seller, "newTicket.txt", "newUserFile.txt");
    	    updateUserFile(userArray, userName, "newTicket.txt", "newUserFile.txt");
    	    
    	    switch(accountType) {
    	    case "AA":
    	    	adminInterface();
    	    	break;
    	    case "BS":
    	    	buyerInterface();
    	    	break;
    	    case "SS":
    	    	sellerInterface();
    	    	break;
    	    default:
    	    	buy();
    	    }
    	  
    }else{buy();}
    
	}
	

	
	/*
	 * Adds credit to an account
	 */
	public static void addCredit() throws IOException {
		System.out.println("Please give the username of the account you would like to credit to");
		Scanner scan = new Scanner(System.in);
      	String usr = scan.nextLine();
      	
      	//Checks to see if the user exists
      	for(User u : userArray) {
      		u.userName = usr;
      		if(!userArray.contains(u)) {
      			System.out.println("User does not exist!");
      			addCredit();
      		}
      	}
      	
      	System.out.println("Please state the amount of credits");
      	String amount = scan.nextLine();
      	double balanced = Double.parseDouble(amount);
      	
      	//Checks to see if the amount is over 1000
      	if(balanced > 1000) {
      		System.out.println("You have exceeded the $1000 limit!");
      		addCredit();
      	}
      	double newbalance = 0;
      	//Adds the balance to account
      	for(User u : userArray) {
      		if(u.getUserName().equals(usr)) {   			
      			u.balance += balanced;
      			newbalance = u.balance;
      		}
      	}
		System.out.println("You have added " + amount +  " to: " + usr);
		dailyTransactionWriter("06", usr, accountType, newbalance);
		dailyTransactionWriter("06", userName, accountType, balance);
		updateUserFile(userArray, userName, "ticket.txt", "login.txt");
		adminInterface();
	}
	
	/*
	 * Gives the user a refund from the seller
	 */
	public static String refund(String buyerName, String sellerName, double balanced) throws IOException{
		String result = "";
		String buyer;//The buyer who wants a refund
		String amount;//The in string format
		double amountD;//The amount in double format
		
		double amountS = 0;//The sellers balance;
		
		System.out.println("Buyer's username (Refund to):  ");
  		Scanner scan = new Scanner(System.in);
  		//buyer = scan.nextLine();
  		buyer = buyerName;
  		
  	    //Checks to see if the user exists
      	for(User u : userArray) {
      		u.userName = buyer;
      		if(!userArray.contains(u)) {
      			System.out.println("Buyer does not exist!");
      			//refund();
      			result = "Buyer does not exist!";
      			return result;
      		}
      	}
      	
      	
      	
  		System.out.println("Seller's username (Refund from):  ");
  		Scanner scan2 = new Scanner(System.in);
  		//seller = scan2.nextLine();
  		seller = sellerName;
  		
  		//Checks if the seller exists
      /*	for(User u : userArray) {
      		u.userName = seller;
      		if(!userArray.contains(u)) {
      			System.out.println("Seller does not exist!");
      			//refund();
      			result = "Seller does not exist!";
      			return result;
      		}
      		if(u.getUserName().equals(seller)) {
      			amountS = u.getBalance();
      		}
      	}*/
      	
  		System.out.println("Amount being refunded:  ");
  		Scanner scan3 = new Scanner(System.in);
  		//amount = scan3.nextLine();
  		//amountD = Double.parseDouble(amount);
		//amountS -= amountD;
		
  		//balance += amountD;
  		
  		if(balanced > 0) {
  			result = "Accepatable Amount!";
  			//return result;
  			
  		}
  		amountD = balanced;
  	   //Corrects the balance amounts for both accounts
      /*	for(User u : userArray) {
      		if(u.getUserName().equals(seller)) {
      			u.balance = amountS;
      		}
      		if(u.getUserName().equals(buyer)) {
      			u.balance = balance;
      		}
      	}*/
		System.out.println(buyer + " received a " + amountD + " refund from " + seller);
		dailyTransactionWriter("05", buyer, seller, amountD);
		updateUserFile(userArray, userName, "ticket.txt", "login.txt");
		result = "" +  "05_" + buyer + "_" + seller + "_" + "100";
		return result;
		/* switch(accountType) {
 	    case "AA":
 	    	adminInterface();
 	    	break;
 	    case "BS":
 	    	buyerInterface();
 	    	break;
 	    case "SS":
 	    	sellerInterface();
 	    	break;
 	    default:
 	    	refund();
 	    }*/
		

	}
}
