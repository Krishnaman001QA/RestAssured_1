package StepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenarios() throws IOException {
		stepdefination sd = new stepdefination();

		if (stepdefination.pid == null) {
			sd.add_place_payload("Sanya", "English", "Noida");
			sd.user_calls_with_http_request("AddPlaceAPI", "POST");
			sd.verify_place_id_created_map_to_using("Sanya", "GetPlaceAPI");
		}

	}
}