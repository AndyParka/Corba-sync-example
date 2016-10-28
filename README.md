# Corba-sync-example
Assignment 3 for SENG3400. Asked to build a client and server based on CORBA to simulate synchronous, asynchronous and deferred interactions.

By Andrew Parkinson
c3128094

# How to start corba orb
start orbd –ORBInitialPort 2014

# How to run the server
From the 'Assignment 3 Files' folder

cd DemoServer\bin
start java demoServer –ORBInitialHost localhost –ORBInitialPort 2014

# How to run the client
From the 'Assignment 3 Files' folder

cd DemoClient\bin

// For Synchronus
start java demoClient sync –ORBInitialHost localhost –ORBInitialPort 2014

// For Asynchronus
start java demoClient async –ORBInitialHost localhost –ORBInitialPort 2014

// For Deferred Sync
start java demoClient def –ORBInitialHost localhost –ORBInitialPort 2014

# Note
Built with JDK 7.79
Not tested on any other platform