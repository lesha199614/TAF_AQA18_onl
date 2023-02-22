package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.Milestone;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MilestoneAdapter {
    public Milestone addMilestone(Milestone milestone, int projectId) {
        return given()
                .pathParam("project_id", projectId)
                .body(milestone, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(milestone.getName()))
                .body("description", is(milestone.getDescription()))
                .extract().as(Milestone.class, ObjectMapperType.GSON);
    }

    public Milestone getMilestone(int milestoneId) {
        return given()
                .pathParam("milestone_id", milestoneId)
                .log().uri()
                .when()
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(milestoneId))
                .extract().as(Milestone.class, ObjectMapperType.GSON);
    }
    public void getDeletedMilestone(int milestoneId) {
        given()
                .pathParam("milestone_id", milestoneId)
                .log().uri()
                .when()
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    public Milestone updateMilestone(int milestoneId, Milestone updatedMilestone) {
        return given()
                .pathParam("milestone_id", milestoneId)
                .body(updatedMilestone, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(updatedMilestone.getName()))
                .body("description", is(updatedMilestone.getDescription()))
                .extract().as(Milestone.class, ObjectMapperType.GSON);
    }

    public void deleteMilestone(int milestoneId) {
        given()
                .pathParam("milestone_id", milestoneId)
                .log().uri()
                .when()
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
