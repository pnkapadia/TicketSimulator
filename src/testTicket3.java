import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Checks if the user file updated with user information
 */

public class testTicket3 {

	public BackEnd backend;
	public ArrayList<User> list = new ArrayList<User>();
	
	@Test
	public void testTicket3() throws IOException {
		String test = backend.updateUserFile(list, "apalvetz", "AA", "100");
		assertEquals("apalvetz_AA_100", test);
	}

}
