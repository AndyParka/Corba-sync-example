package demoCli;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import ass03.randCharServer;
import ass03.randCharServerHelper;

public class demoClient {

	static boolean gshutdown = false;
	static String s = "Client has started successfully";

	// sync
	// async
	// def

	public static void main(String[] args) {


		try {

			// CORBA stuff
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			randCharServer randobj = randCharServerHelper.narrow(ncRef.resolve_str("sorandom"));
			System.out.println("Obtained a handle on server object: " + randobj);

			// For readability
			for (int i = 0; i < 4; i++) {
				System.out.println("");
			}

			// First loop of *****
			for (int i = 0; i < 4; i++) {
				System.out.println("*");
			}

			// Mode selection based off the argument entered

			if (args[0].equalsIgnoreCase("sync")) {
				// synchronous
				System.out.println(s);
				sync.main(randobj);

			} else if (args[0].equalsIgnoreCase("async")) {
				// a-synchronous
				System.out.println(s);
				async.main(randobj);

			} else if (args[0].equalsIgnoreCase("def")) {
				// deferred synchronous
				System.out.println(s);
				def.main(randobj);

			} else {
				System.out.println("Invalid Argument, Please try : sync || async || def");

			}

			gshutdown = true;
			randobj.shutdown();

		} catch (Exception e) {
			// dodgy hack to stop the orb.shutdown() function appearing as a
			// crash
			if (!gshutdown) {
				System.out.println("Client exception: " + e);
				e.printStackTrace();
			}
		}

		private String Counter(){


		}

	}

}