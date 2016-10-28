
import java.util.concurrent.ThreadLocalRandom;

import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Request;
import org.omg.CORBA.TCKind;

import ass03.randCharServer;

public class sync {

	private static char randReturn = '*';

	private static String strOutput(int counter, char randReturn) {
		return counter + ". Value is " + randReturn;
	}

	public static void main(randCharServer randobj, ORB orb) throws InterruptedException {

		int count = 0;

		for (;;) {

			// Create delays between outputs
			Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));

			// Initial 5 *s
			if (count < 5) {
				count++;
				System.out.println(strOutput(count, randReturn));

			} else if (count < 10) {
				try {
					// on 5th count, do server request
					if (count == 5) {

						// Object request
						Request getChar = randobj._request("getChar");

						// Set return type
						getChar.set_return_type(orb.get_primitive_tc(TCKind.tk_char));

						// Request from server
						getChar.invoke();

						// Set private var to the server's random char response
						randReturn = getChar.return_value().extract_char();

					}
					count++;
					System.out.println(strOutput(count, randReturn));
				} catch (BAD_OPERATION e) {
					// TODO Auto-generated catch block
					System.out.println("Error connecting to server\n\n");
					e.printStackTrace();
				}

			} else {

				break;
			}

		}

	}
}
