package files;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Reusable_methods {

	
	public static XmlPath rawToXML(Response res)
	{
		String respon=res.asString();
		XmlPath x=new XmlPath(respon);
		return x;
	}
	
	
	public static JsonPath rawToJSON(Response res)
	{		
		String responseString=res.asString();
		JsonPath js= new JsonPath(responseString);
		return js;
	}
}
