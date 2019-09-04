import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

/*
 * Checks that user already exists
 */

public class testCreate2 {
	
	public FrontEnd frontend;
	
	/*
	 * In the FrontEnd, we added a new user pnkapadia to the arraylist
	 * userArray.add(new User ("pkapadia", "AA", 200.0));
	 * This test fails because the user already exists and the program stops
	 */
	
	@Test
	public void testCreate2() throws IOException {
		String test = frontend.createUser("lmarque", "pkapadia", 200.0, "AA");
		assertEquals("pnkapadia", test);

	}

}
