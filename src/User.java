

/*
 * Creates the object of the user account
 */
public class User {

	String userName;//The user name
	String accountType;//The account type
	double balance;//The balance
	
	/*
	 * Creates the user constructor
	 * @param String userName
	 * @param String accountType
	 * @param double balance
	 */
	public User(String userName, String accountType, double balance) {
		this.userName = userName;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	/*
	 * Returns the user name
	 */
	public String getUserName() {
		return userName;
	}
	
	/*
	 * Returns the account type
	 */
	public String getAccountType() {
		return accountType;
	}
	
	/*
	 * Returns the balance
	 */
	public double getBalance() {
		return balance;
	}
}
