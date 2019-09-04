
/*
 * Creates the ticket object
 */
public class Ticket {

	String eventTitle;//The event title
	String seller;//The seller name
	int ticketAmount;//The amount of tickets on sale
	double ticketPrice;//The ticket price
	
	/*
	 * Creates the ticket constructor
	 * @param String eventTitle
	 * @param String seller
	 * @param int ticketAmount
	 * @param double ticketPrice
	 */
	public Ticket(String eventTitle, String seller, int ticketAmount, double ticketPrice) {
		this.eventTitle = eventTitle;
		this.seller = seller;
		this.ticketAmount = ticketAmount;
		this.ticketPrice = ticketPrice;
	}
	
	/*
	 * Returns the event title
	 */
	public String getEventName() {
		return eventTitle;
	}
	
	/*
	 * Returns the sellers name
	 */
	public String getSellerName() {
		return seller;
	}
	
	/*
	 * Returns the amount of tickets on sale
	 */
	public int getTicketAmount() {
		return ticketAmount;
	}
	
	/*
	 * Returns the ticket price
	 */
	public double getTicketPrice() {
		return ticketPrice;
	}
}
