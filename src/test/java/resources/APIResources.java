package resources;

//enum is special class in java which has collection of constants or methods
public enum APIResources {

	AddPlaceAPI("maps/api/place/add/json"), 
	GetPlaceAPI("maps/api/place/get/json"),
	DeletePlaceAPI("maps/api/place/delete/json");

	private String resources;

	APIResources(String resources) {

		this. resources=  resources;
	}

	public String Getresource() {

		return resources;
	}
}
