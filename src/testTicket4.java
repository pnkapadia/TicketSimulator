import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

/*
 * Checks if the amount being refunded is acceptable
 */

public class testTicket4 {

	public FrontEnd frontend;
	
	@Test
	public void testTicket4() throws IOException {
		String test = frontend.refund("apalvetz", "alice", 100000);
		assertEquals("Accepatable Amount!", test);
	}

}
