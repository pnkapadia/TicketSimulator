import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

/*
 * Checks that user name isn't greater than 15 characters
 */

public class testCreate3 {
	
	public FrontEnd frontend;

	@Test
	public void testCreate3() throws IOException {
		String test = frontend.createUser("apalvetz", "lmarque543543654654365", 212.00, "BS");
		assertEquals("Too long", test);
	}

}
