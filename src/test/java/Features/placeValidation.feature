Feature: Validating Place API's

#Scenario: Verify if Place is being Succesfully added using AddPlaceAPI
#					Given Add Place Payload
#					When User Calls "AddPlaceAPI" with Post http request
#					Then the API call got success with status code 200
#					And "status" in response body is "OK"
#					And "scope" in response body is "APP"

@AddPlace @Regression
Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
					Given Add Place Payload "<name>" "<language>" "<address>"
					When User Calls "AddPlaceAPI" with "POST" http request
					Then the API call got success with status code 200
					And "status" in response body is "OK"
					And "scope" in response body is "APP"
					And verify place_id created map to "<name>" using "GetPlaceAPI"
					
Examples:
					| name 	| language  | address			  |
					| Sanju | English 	| Graphix tower |
#					| karan | Czec 	    | iThum tower |
		
@DeletePlace @Regression		
Scenario: Verify if Delete Place Functiuonality is working

					Given Delete payload
					When User Calls "DeletePlaceAPI" with "POST" http request
					Then the API call got success with status code 200
					And "status" in response body is "OK"
					
					
