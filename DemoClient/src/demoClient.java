import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import ass03.randCharServer;
import ass03.randCharServerHelper;

public class demoClient {

	static boolean gshutdown = false;

	/**
	 * @param args
	 *            sync async def the command line arguments
	 */
	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			randCharServer randobj = randCharServerHelper.narrow(ncRef.resolve_str("sorandom"));

			if (args[0].equalsIgnoreCase("sync")) {
				System.out.println("Client has started successfully");
				System.out.println("Obtained a handle on server object: " + randobj);
				Thread.sleep(2000);
				System.out.println(".");
				Thread.sleep(2000);
				System.out.println(randobj.get());
				Thread.sleep(2000);
				System.out.println(".");
				gshutdown = true;
				randobj.shutdown();

			} else if (args[0].equalsIgnoreCase("async")) {
				System.out.println("Client has started successfully");
			} else if (args[0].equalsIgnoreCase("def")) {
				System.out.println("Client has started successfully");
			} else {
				System.out.println("Client has started successfully");
			}

			for (;;) {

			}

		} catch (Exception e) {
			// dodgy hack to stop the orb.shutdown() function appearing as a
			// crash
			if (!gshutdown) {
				System.out.println("Client exception: " + e);
				e.printStackTrace();
			}
		}

	}

}