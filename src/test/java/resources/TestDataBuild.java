package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace_Serialization;
import pojo.location_Serialization;

public class TestDataBuild {
	
	public AddPlace_Serialization addPlacepayLoad(String name, String language, String address)
	{
		AddPlace_Serialization pp = new AddPlace_Serialization();
		pp.setAccuracy(50);
		pp.setAddress(address);
		pp.setLanguage(language);
		pp.setName(name);
		pp.setPhone_number("(+91) 983 893 6140");
		pp.setWebsite("https://rahulshettyacademy.com");

		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		pp.setTypes(myList);

		location_Serialization loc = new location_Serialization();
		loc.setLat(-38.383494);
		loc.setLat(33.427362);
		pp.setLocation(loc);
		
		return pp;
	}
	
	
	public String deletePayload (String plId)
	{
		return "{\r\n    \"place_id\":\"" + plId + "\"\r\n}";
		
	}

}
