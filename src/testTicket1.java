import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

/*
 * Prints to the daily transaction file the refund received by the buyer from the seller.
 */

public class testTicket1 {

	public FrontEnd frontend;
	
	@Test
	public void testTicket1() throws IOException {
		String test = frontend.refund("apalvetz", "alice", 100);
		assertEquals("05_apalvetz_alice_100",test);
	}

}
