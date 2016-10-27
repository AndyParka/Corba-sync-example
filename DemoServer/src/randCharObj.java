
// By Andrew Parkinson
// c3128094
// Assignment 3
// SENG3400 S2
// October 2016

//package demoSrv;

import java.util.concurrent.ThreadLocalRandom;

import org.omg.CORBA.ORB;

import ass03.randCharServerPOA;

class randCharOBJ extends randCharServerPOA {
	private ORB orb;

	public void setORB(ORB orb_val) {
		orb = orb_val;
	}

	@Override
	public void shutdown() {
		// Shutdown the server
		orb.shutdown(false);
	}

	@Override
	public char getChar() {
		// Generates and returns a random character between a=>z or A=>Z

		// String containing possible outputs
		String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		// Sets a char from the 'range' string,
		// based on a randomly generated index int
		char randChar = range.charAt(ThreadLocalRandom.current().nextInt(0, range.length()));

		System.out.println("...Fake Lag...");
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(10000, 15000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Returning Char...");
		return randChar;
	}

}