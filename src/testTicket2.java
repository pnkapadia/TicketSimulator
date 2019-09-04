import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

/*
 * Checks if the user info is written into the daily transaction file.
 */

public class testTicket2 {

	public BackEnd backend;
	
	@Test
	public void testTicket2() throws IOException {
		String test = backend.dailyTransactionWriter("05", "apalvetz", "AA", 100);
		assertEquals("05_apalvetz_AA_100.0", test);
	}

}
