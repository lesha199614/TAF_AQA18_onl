package baseEntities;

import adapters.MilestoneAdapter;
import adapters.ProjectAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import dbTables.CaseTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;

import static io.restassured.RestAssured.given;

public class BaseApiGSONTest {
    protected Gson gson;
    protected DataBaseService dbService;
    protected CaseTable testCasesTable;

    @BeforeTest
    public void setupApi() {
        gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation().create();

        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        dbService = new DataBaseService();
        testCasesTable = new CaseTable(dbService);
    }
}
