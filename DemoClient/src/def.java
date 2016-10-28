
import org.omg.CORBA.ORB;
import org.omg.CORBA.Request;
import org.omg.CORBA.TCKind;

import ass03.randCharServer;

public class def {

	private static char randReturn = '*';

	private static String strOutput(int counter, char randReturn) {
		return counter + ". Value is " + randReturn;
	}

	public static void main(randCharServer randobj, ORB orb) throws Exception {

		int count = 0;

		// Object request
		Request getChar = randobj._request("getChar");

		// Set return type
		getChar.set_return_type(orb.get_primitive_tc(TCKind.tk_char));

		for (int i = 0; i < 15; i++) {

			// Create delays between outputs
			Thread.sleep(1000);

			count++;

			// Output
			System.out.println(strOutput(count, randReturn));

			if (count == 5) {
				// on 6th count, do server request
				getChar.send_deferred();

			}

			// If response has polled
			if (getChar.poll_response()) {
				getChar.get_response();
				// Set private var to the server's random char response
				randReturn = getChar.return_value().extract_char();

				// else if it hasn't by 10 counts
			} else if (!getChar.poll_response() && count == 10) {

				// wait for server's response by continuous polling
				while (!getChar.poll_response()) {

					// Try to get response
					// If response has polled
					if (getChar.poll_response()) {
						getChar.get_response();
						// Set private var to the server's random char
						randReturn = getChar.return_value().extract_char();
						break;
					}

				}
			}
		}
	}
}