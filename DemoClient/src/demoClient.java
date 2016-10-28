
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import ass03.randCharServer;
import ass03.randCharServerHelper;

public class demoClient {

	static String s = "Client has started successfully";

	// Possible args are:
	// sync
	// async
	// def

	public static void main(String[] args) {

		try {

			// CORBA stuff, I guess its connecting to the orb and
			// magically finding the server objects through it.
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			randCharServer randobj = randCharServerHelper.narrow(ncRef.resolve_str("sorandom"));
			System.out.println("Obtained a handle on server object: " + randobj);

			// For readability
			System.out.println("\n\n\n");

			// Mode selection based off the argument entered

			if (args[0].equalsIgnoreCase("sync")) {
				// synchronous
				System.out.println(s + "\n\n\n");
				sync.main(randobj, orb);

			} else if (args[0].equalsIgnoreCase("async")) {
				// a-synchronous
				System.out.println(s + "\n\n\n");
				async.main(randobj, orb);

			} else if (args[0].equalsIgnoreCase("def")) {
				// deferred synchronous
				System.out.println(s + "\n\n\n");
				def.main(randobj, orb);

			} else {
				System.out.println("Invalid Argument, Please try : sync || async || def");

			}

		} catch (Exception e) {

			System.out.println("Client exception: " + e);
			e.printStackTrace();

		}

	}

}