
// By Andrew Parkinson
// c3128094
// Assignment 3
// SENG3400 S2
// October 2016

package demoSrv;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import ass03.randCharServer;
import ass03.randCharServerHelper;

public class demoServer {

	public static void main(String args[]) {
		try {
			// initialize the ORB
			ORB orb = ORB.init(args, null);

			// Get reference to rootpoa
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			// Activate the POAManager
			rootpoa.the_POAManager().activate();

			// create servant and register it with the ORB
			randCharOBJ randobj = new randCharOBJ();
			randobj.setORB(orb);

			// get object reference from the servant
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(randobj);
			randCharServer href = randCharServerHelper.narrow(ref);

			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			NameComponent path[] = ncRef.to_name("sorandom");
			ncRef.rebind(path, href);

			System.out.println("Server Online");
			System.out.println("Awaiting Client");

			// wait for invocations from clients
			orb.run();

		}

		catch (Exception e) {

			System.err.println("Client exception: : " + e);
			e.printStackTrace(System.out);

		}

		System.out.println("Server Exiting ...");

	}
}