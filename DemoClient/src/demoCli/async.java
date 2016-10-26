package demoCli;

import java.util.concurrent.ThreadLocalRandom;

import ass03.randCharServer;

public class async {

	private static char randReturn = '*';

	private static String strOutput(int counter, char randReturn) {
		return counter + ". Value is " + randReturn;
	}

	public static void main(randCharServer randobj) throws InterruptedException {

		int count = 0;

		for (;;) {

			count++;
			Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));

			if (count < 5) {
				System.out.println(strOutput(count, randReturn));

			} else if (count < 10) {
				randReturn = randobj.getChar();
				System.out.println(strOutput(count, randReturn));

			} else {
				System.out.println("Results complete");
				break;
			}

		}

	}

}
