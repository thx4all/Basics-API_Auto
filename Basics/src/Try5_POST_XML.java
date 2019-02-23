import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Try5_POST_XML {

	@Test
	public void postData() throws IOException
	{
		String postdata=GenerateStringFromResource("C:\\Users\\Kefir\\git\\Basics-API_Auto\\Basics\\src\\files\\add_xml_path1.xml");
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().
		
		given().
			queryParam("key","qaclick123").
			
			body(postdata).
			when().
			post("maps/api/place/add/xml").
			
			then().assertThat().			
			statusCode(200).and().
			contentType(ContentType.XML).and().
			//body("status",equalTo("OK"));
			extract().response();
		
		String respon=res.asString();
		System.out.println(respon);
	}

	public static String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
