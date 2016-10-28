
import org.omg.CORBA.ORB;
import org.omg.CORBA.Request;
import org.omg.CORBA.TCKind;

import ass03.randCharServer;

public class async {

	private static char randReturn = '*';

	private static String strOutput(int counter, char randReturn) {
		return counter + ". Value is " + randReturn;
	}

	public static void main(randCharServer randobj, ORB orb) throws Exception {

		int count = 0;
		int countSinceReturn = 0;

		// Object request
		Request getChar = randobj._request("getChar");

		// Set return type
		getChar.set_return_type(orb.get_primitive_tc(TCKind.tk_char));

		while (true) {

			// Create delays between outputs
			Thread.sleep(1000);

			count++;

			// Output
			System.out.println(strOutput(count, randReturn));

			if (count == 5) {
				// on 6th count, do server request
				getChar.send_deferred();

			}

			if (count >= 5 && randReturn == '*') {

				// If response has polled
				if (getChar.poll_response()) {
					getChar.get_response();
					// Set private var to the server's random char response
					randReturn = getChar.return_value().extract_char();

				}

			}

			if (countSinceReturn == 5) {
				break;
			} else if (randReturn != '*') {
				countSinceReturn++;
			}

		}

	}
}
