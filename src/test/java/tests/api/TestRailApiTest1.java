package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestRailApiTest1 extends BaseApiTest {
    int projectId;
    Project expectedProject;

    @Test
    public void addProject1() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("AV_project_01");
        expectedProject.setAnnouncement("AV_description");
        expectedProject.setType(1);
        expectedProject.setShownAnnouncement(true);

        given()
                .body(String.format("{\n" +
                                "  \"name\": \"%s\",\n" +
                                "  \"announcement\": \"%s\",\n" +
                                "  \"show_announcement\": %b,\n" +
                                "  \"suite_mode\" : %d\n" +
                                "}",
                        expectedProject.getName(),
                        expectedProject.getAnnouncement(),
                        expectedProject.isShownAnnouncement(),
                        expectedProject.getType()
                ))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject2() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("AV_project_02");
        expectedProject.setAnnouncement("AV_description");
        expectedProject.setType(1);
        expectedProject.setShownAnnouncement(true);

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", expectedProject.getName());
        jsonMap.put("suite_mode", expectedProject.getType());

        given()
                .body(jsonMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject3() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("AV_project_03_2");
        expectedProject.setAnnouncement("AV_description");
        expectedProject.setType(1);
        expectedProject.setShownAnnouncement(true);

        given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject3_1() {
        ProjectAdapter projectAdapter = new ProjectAdapter();
        Project expectedProject = new Project();
        expectedProject.setName("AV_project_03_2");
        expectedProject.setAnnouncement("AV_description");
        expectedProject.setType(1);
        expectedProject.setShownAnnouncement(true);

        Project actualProject = projectAdapter.add(expectedProject);
        Assert.assertEquals(expectedProject, actualProject);
    }

    @Test
    public void addProject4() {
        String endpoint = "index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("AV_project_04");
        expectedProject.setAnnouncement("Description");
        expectedProject.setType(1);
        expectedProject.setShownAnnouncement(true);

        projectId = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .get("id");

        System.out.println(projectId);
    }

    @Test
    public void addProject5() {
        String endpoint = "index.php?/api/v2/add_project";

        expectedProject = new Project();
        expectedProject.setName("AV_Project_05");
        expectedProject.setAnnouncement("Description");
        expectedProject.setType(1);
        expectedProject.setShownAnnouncement(true);

        Response response = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        projectId = response.getBody().jsonPath().get("id");

        Assert.assertEquals(response.getBody().jsonPath().getString("name"),
                expectedProject.getName());

        System.out.println(projectId);
    }

    @Test(dependsOnMethods = "addProject5")
    public void readProject() {
        String endpoint = "index.php?/api/v2/get_project/{project_id}";

        Response response = given()
                .pathParam("project_id", projectId)
                .log().uri()
        .when()
                .get(endpoint)
        .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(projectId))
                .body("name", is(expectedProject.getName()))
                .extract().response();
    }

}
