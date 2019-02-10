import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Try1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI="http://216.10.245.166";
		
		given().
			//param("key","qaclick123").
			body("{\r\n" + 
					"    \"location\":{\r\n" + 
					"        \"lat\" : -38.383494,\r\n" + 
					"        \"lng\" : 33.427362\r\n" + 
					"    },\r\n" + 
					"    \"accuracy\":50,\r\n" + 
					"    \"name\":\"Frontline house\",\r\n" + 
					"    \"phone_number\":\"(+91) 983 893 3937\",\r\n" + 
					"    \"address\" : \"29, side layout, cohen 09\",\r\n" + 
					"    \"types\": [\"shoe park\",\"shop\"],\r\n" + 
					"    \"website\" : \"http://google.com\",\r\n" + 
					"    \"language\" : \"French-IN\"\r\n" + 
					"}").
			when().
			post("maps/api/place/add/json?key=qaclick123").
			then().assertThat().
			
			statusCode(200).and().
			contentType(ContentType.JSON);
	}

}
