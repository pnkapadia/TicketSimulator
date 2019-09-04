import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.Scanner;

/*
 * Checks if we're able to set accountType of created user
 * In the FrontEnd code, we assume the user will enter "AA" as the type of user
 * Thus, our test confirms that we have set the user's account type
 * 
 * 		if (accType != null && !accType.isEmpty()) {
      			System.out.println("Type of user (AA, SS, BS): ");
      			Scanner scan2 = new Scanner(System.in);
      			result = "AA";
      			return result; 
      		}
      	
 */

public class testCreate4 {

	public FrontEnd frontend;
	
	@Test
	public void testCreate4() throws IOException{
		String test = frontend.createUser("lmarque", "apalvetz", 200.0, "AA");
		assertEquals("AA", test);
	}

}
