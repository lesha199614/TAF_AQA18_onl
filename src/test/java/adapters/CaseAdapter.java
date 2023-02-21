package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.TestCase;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class CaseAdapter {

    public TestCase add(TestCase testCase, int sectionId) {
        return given()
                .pathParam("section_id", sectionId)
                .body(testCase, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.ADD_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(TestCase.class, ObjectMapperType.GSON);
    }

    public TestCase update(TestCase testCase, int caseId) {
        return given()
                .pathParam("case_id", caseId)
                .body(testCase, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.UPDATE_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().all()
                .extract().as(TestCase.class, ObjectMapperType.GSON);
    }

    public TestCase get(int caseId) {
        return given()
                .pathParam("case_id", caseId)
                .log().uri()
                .when()
                .get(Endpoints.GET_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().all()
                .extract().as(TestCase.class, ObjectMapperType.GSON);
    }

    public TestCase moveToSection(int sectionId, int caseId) {
        return given()
                .pathParam("section_id", sectionId)
                .body(String.format("{\n" +
                                "  \"case_ids\": \"%s\"" +
                                "}",
                        caseId))
                .log().all()
                .when()
                .post(Endpoints.MOVE_CASES_TO_SECTION)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(TestCase.class, ObjectMapperType.GSON);
    }

    public void deleteCase(int caseId) {
        given()
                .pathParam("case_id", caseId)
                .log().uri()
                .when()
                .post(Endpoints.DELETE_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
