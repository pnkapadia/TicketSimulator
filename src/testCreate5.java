import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

/*
 * Checks if the balance is greater than 999,999
 */

public class testCreate5 {

	public FrontEnd frontend;
	
	@Test 
	public void testCreate5() throws IOException {
		String test = frontend.createUser("pnkapadia", "lmarque", 9999999.00, "AA");
		assertEquals("The balance is too high please try again", test);
	}

}
