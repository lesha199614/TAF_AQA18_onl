package tests.api;

import configuration.ReadProperties;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestRailApiTest extends BaseApiTest{

   @Test
    public void getAllUsers () {
       String endpoint = "index.php?/api/v2/get_users";

       RequestSpecification httpRequest = given();
       httpRequest.auth().basic(ReadProperties.username(),ReadProperties.password());

       Response response = httpRequest.request(Method.GET, endpoint);
       Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

      System.out.println(response.getBody().asPrettyString());

   }

}
