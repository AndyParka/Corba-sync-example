# Corba-sync-example
Assignment 3 for SENG3400. Asked to build a client and server based on CORBA to simulate synchronous, asynchronous and deferred interactions.

# How to start corba orb
orbd –ORBInitialPort 1337

# How to run the server
From the 'Assignment 3 Files' folder

cd DemoServer\bin
java demoServer –ORBInitialHost localhost –ORBInitialPort 1337

# How to run the client
From the 'Assignment 3 Files' folder

cd DemoClient\bin

// For Synchronus
java demoClient sync –ORBInitialHost localhost –ORBInitialPort 1337

// For Asynchronus
java demoClient async –ORBInitialHost localhost –ORBInitialPort 1337

// For Deferred Sync
java demoClient def –ORBInitialHost localhost –ORBInitialPort 1337