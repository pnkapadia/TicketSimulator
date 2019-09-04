
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/*
 * Creates the BackEnd poriton of the system that updates the new user files and ticket files
 * based on previous transactions done and by merging the old files into new ones
 */
public class BackEnd {

	
	/*
	 * Writes out the daily transaction log for the user
	 * @param String userName
	 * @param String type
	 * @param String accType
	 * @param double credit
	 */
	public static String dailyTransactionWriter(String type, String userName, String accType, double credit) throws IOException {
		File file = new File("/Users/prachikapadia/Desktop/cps707/testFiles/daily-transactions.txt");
		FileWriter fr = new FileWriter(file, true);
		BufferedWriter br = new BufferedWriter(fr);
		br.newLine();
		br.write(type + "_" + userName + "_" + accType + "_" + credit +"\n");	
		br.close();
		fr.close();
		String test = "" + type + "_" + userName + "_" + accType + "_" + "" + credit;
		return test;
	}
	
	/*
	 * Creates the daily transaction log for a ticket sale
	 * @param String transType
	 * @param String event
	 * @param String seller
	 * @param int ticketAmount
	 * @param double ticketPrice
	 */
	public static void dailyTransactionWriterSell(String transType, String event, String seller, int ticketAmount, double ticketPrice) throws IOException {
		File file = new File("/Users/prachikapadia/Desktop/cps707/testFiles/daily-transactions.txt");
		FileWriter fr = new FileWriter(file, true);
		BufferedWriter br = new BufferedWriter(fr);
		br.newLine();
		br.write(transType + "_" + event + "_" + seller + "_" + ticketAmount + "_" + ticketPrice + "\n");	
		br.close();
		fr.close();
		
	}
	
	/*
	 * Updates all the ticket transactions and sets the information into the file newTicket.txt
	 * @param ArrayList ticketsArray
	 * @param String seller
	 * @param String transactionFile
	 * @param String userFile
	 */
	public static void updateTicketFile(ArrayList<Ticket> ticketsArray, String seller, String transactionFile, String userFile) {
		
		try {
			PrintWriter writer = new PrintWriter("/Users/prachikapadia/Desktop/cps707/testFiles/" + transactionFile);
			writer.close();
			
			
			File file = new File("/Users/prachikapadia/Desktop/cps707/testFiles/newTicket.txt");
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			
			//Writes the ticket information into the new ticket file
			for(Ticket t : ticketsArray) {
				br.write(t.getEventName() + "_" + t.getSellerName() + "_" + t.getTicketAmount() + "_" + t.getTicketPrice());
				br.newLine();
			}
			br.close();
			fr.close();
					
		}catch (IOException e) {}
		
		
	}
	
	/*
	 * Updates the user file when changes are made
	 * @param ArrayList userArray
	 * @param String user
	 * @param transactionFile
	 * @param String userFile
	 */
	public static String updateUserFile(ArrayList<User> userArray, String user, String transactionFile, String userFile) {
		
		try {
			PrintWriter writer = new PrintWriter("/Users/prachikapadia/Desktop/cps707/testFiles/newUserFile.txt");
			writer.close();
			
			File file = new File("/Users/prachikapadia/Desktop/cps707/testFiles/newUserFile.txt");
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			
			/*
			for(User u : userArray) {
				br.write(u.getUserName() + "_" + u.getAccountType() + "_" + u.getBalance());
				br.newLine();
			}*/
			br.close();
			fr.close();
					
		}catch (IOException e) {}
		
		return  "" + user + "_" + transactionFile + "_" + userFile;
		
	}
	
	
}
