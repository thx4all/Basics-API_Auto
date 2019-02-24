import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import files.Reusable_methods;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Try5_POST_XML {

	Properties prop= new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		
		FileInputStream fis= new FileInputStream("C:\\Users\\Kefir\\git\\Basics-API_Auto\\Basics\\src\\files\\env.properties");
		prop.load(fis);
		//prop.get("HOST");
	}
	
	
	@Test
	public void postData() throws IOException
	{
		String postdata=GenerateStringFromResource("C:\\Users\\Kefir\\git\\Basics-API_Auto\\Basics\\src\\files\\add_xml_path1.xml");
		RestAssured.baseURI=prop.getProperty("HOST");
		Response res=given().
		
		given().
			queryParam("key",prop.getProperty("KEY")).
			
			body(postdata).
			when().
			post("maps/api/place/add/xml").
			
			then().assertThat().			
			statusCode(200).and().
			contentType(ContentType.XML).and().
			//body("status",equalTo("OK")).
			
			extract().response();
		

		//String responseString=res.asString();
		//System.out.println(responseString);
		XmlPath x=Reusable_methods.rawToXML(res);
		String status=(x.get("PlaceAddResponse.status"));
		System.out.println("status="+status);
		
	}

	public static String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
