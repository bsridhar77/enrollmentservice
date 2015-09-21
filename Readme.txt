To Build the project ( Builds a jar not a WAR ) 

	mvn package
	
	
To Run the service
	
	java -jar target/enrollmentservice-0.0.1-SNAPSHOT.jar server enrollmentservice.yml
	
	
The Port on which the Enrollment service runs is configured in enrollmentservice.yml

Fetch Quote Detalis By QuoteID
		http://localhost:6080/quote/{id}
		
			http://localhost:6080/quote/1	


Fetch All Quotes
	http://localhost:6080/quote
	
	
Fetch All Quotes By AgentId
	http://localhost:6080/quote/all/agent/{id}
	
		http://localhost:6080/quote/all/agent/123
	
	
Fetch Small Group Type Quotes By Agent Id
	http://localhost:6080/quote/sg/agent/{id}
	
		http://localhost:6080/quote/sg/agent/123	
	
	
Fetch Medium Type Quotes By Agent Id
	http://localhost:6080/quote/med/agent/{id}
	
		http://localhost:6080/quote/med/agent/123	

Fetch Quote List By Agent Id and Quote Type
	http://localhost:6080/quote/agent/{id}?type={type}
	
		http://localhost:6080/quote/agent/789?type=SeniorGroup
		
		http://localhost:6080/quote/agent/789?type=MediumGroup
	

		
