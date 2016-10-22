
//
//
import org.omg.CORBA.ORB;

import ass03.randCharServerPOA;

class randCharOBJ extends randCharServerPOA {
	private ORB orb;

	public void setORB(ORB orb_val) {
		orb = orb_val;
	}

	public static boolean gshutdown = false;

	// implement add() method
	@Override
	public char get() {
		char r = 'A';
		return r;
	}

	// implement shutdown() method
	@Override
	public void shutdown() {
		gshutdown = true;
		orb.shutdown(false);
	}
}