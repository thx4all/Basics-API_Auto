import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.payLoad;
import files.resources;

public class Try3_POST_ADD_and_DELETE_place {

	Properties prop= new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		
		FileInputStream fis= new FileInputStream("C:\\Users\\Kefir\\git\\Basics-API_Auto\\Basics\\src\\files\\env.properties");
		prop.load(fis);
		//prop.get("HOST");
	}
	
	
	@Test
	public void Add_and_Delete_Place()
	{
		
		
		//Grab the response
		RestAssured.baseURI= prop.getProperty("HOST");
		Response res=given().
		
		given().
			queryParam("key",prop.getProperty("KEY")).
			
			body(payLoad.AddBody1()).
			
			when().
			//post("maps/api/place/add/json").
			post(resources.placePostData()).
			
			then().assertThat().			
			statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("status",equalTo("OK")).
			
			extract().response();
		
		//Grab the Place_id from response	
		String responseString=res.asString();
		System.out.println(responseString);
		JsonPath js= new JsonPath(responseString);
		String place_id=js.get("place_id");
		System.out.println(place_id);
		
		
		//Take place_id to the delete request
		given().
			queryParam("key","qaclick123").
			
			when().
			
			body("{"+
			    "\"place_id\":\""+place_id+"\""+          
			"}").
			
			post("/maps/api/place/delete/json").
			
			then().assertThat().			
			statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("status",equalTo("OK"));
		
		
		//Check what place are successfully deleted
		given().
			queryParam("key","qaclick123").
					
			when().
					
			body("{"+
					    "\"place_id\":\""+place_id+"\""+          
			"}").
					
			post("/maps/api/place/delete/json").
					
			then().assertThat().			
			statusCode(404).and().
			contentType(ContentType.JSON).and().
			body("msg",equalTo("Delete operation failed, looks like the data doesn't exists"));
				
	}

}
