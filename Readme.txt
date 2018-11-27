Approach:
Firstly, create classes based on the objects in the data.json file.
Then create Fulfilment which uses these classes to manipulate and persist information in memory.
Create FulfilmentClient which acts as a way to input to Fulfilment.

To run:
	1/ Compile the classes using
		javac *.java
		if these cannot compile, add json-simple-1.1.1.jar to the CLASSPATH environment variable.

	2/ Run the class FulfilmentClient as
		java FulfilmentClient (orderno1),(orderno2),(orderno3),(...)
		e.g. 
		java FulfilmentClient 1122,1123,1124,1125

		This will return all orders that are unfulfillable as a string

		e.g. for the above example
		1123,1125

Other notes:
	-Product quantity is updated, though invisible to the end-user.
	-ReorderStub holds information about reorders (if set).


Things that may need to be changed (please message me if you would like me to implement these changes)
	-Input and output seemed to be as JSON file in the example. As of now, they are string input and outputs.
	-This code can be deployed to a tomcat server as a web service which was part of my approach initially. 
	I realised this may have been out of scope, but this can be implemented.

