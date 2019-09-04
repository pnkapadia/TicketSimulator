import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

/*
 * New user info is written out into the daily transaction file
 */
public class testCreate1 {

	public BackEnd backend;
	
	@Test
	public void testCreate1() throws IOException {
		String test = backend.dailyTransactionWriter("01", "bob", "BS", 100.0);
		assertEquals("01_bob_BS_100.0", test);
	}

}
