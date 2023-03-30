import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import resources.Payload;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class XRAYFunctionalities extends Utils {

    String testKey;
    String issueId;
    String stepId;
    RequestSpecification requestSpec;
    Response response;
    SessionFilter session = new SessionFilter();
    TestDataBuild dataBuild = new TestDataBuild();



    public void getSession() throws IOException {
        Response getSessionResponse = given()
                .header("Content-Type", "application/json")
                .body("{ \n" +
                        "\"username\": \""+getGlobalValue("username")+"\", \n" +
                        "\"password\": \""+getGlobalValue("password")+"\" \n" +
                        "}")
                .log()
                .all()
                .filter(session)
                .when()
                .post("/rest/auth/1/session")
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

   public void createTest(String method) throws IOException {
       APIResources resourceAPI = APIResources.valueOf(method);
       requestSpec = given()
               .spec(requestSpecification())
               .body(Payload.AddTest())
               .filter(session)
               .log()
               .all();
       response = requestSpec
               .when()
               .post(resourceAPI.getResource())
               .then()
               .spec(responseSpecification())
               .log()
               .all()
               .assertThat()
               .statusCode(201)
               .extract()
               .response();

       issueId = getJsonPath(response,"id");
        System.out.println("Issue ID:" +issueId);
        testKey = getJsonPath(response,"key");
        System.out.println("Test Key:" +testKey);

   }

       public void getTest(String method) throws IOException {
           APIResources resourceAPI = APIResources.valueOf(method);
           requestSpec = given()
                   .spec(requestSpecification())
                   .pathParam("issueId", issueId)
                   .filter(session)
                   .log()
                   .all();
           response = requestSpec.when().get(resourceAPI.getResource())
                   .then()
                   .spec(responseSpecification())
                   .log()
                   .all()
                   .assertThat()
                   .statusCode(200)
                   .extract()
                   .response();

           String extractedIssueId = getJsonPath(response,"id");
           System.out.println("Extracted Issue ID:" +extractedIssueId);
           Assert.assertEquals(issueId,extractedIssueId);
       }

    public void deleteTest(String method) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(method);
        requestSpec = given()
                .spec(requestSpecification())
                .header("X-Atlassian-Token", "no-check")
                .pathParam("issueId", issueId)
                .filter(session)
                .log()
                .all();
        response = requestSpec.when().delete(resourceAPI.getResource())
                .then()
                .spec(responseSpecification())
                .log()
                .all()
                .assertThat()
                .statusCode(204)
                .extract()
                .response();

        getNonExistingTestRequest("GetTestAPI");
    }

    public void getNonExistingTestRequest(String method) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(method);
        requestSpec = given()
                .spec(requestSpecification())
                .header("X-Atlassian-Token", "no-check")
                .filter(session)
                .pathParam("issueId", testKey)
                .log()
                .all();
        response = requestSpec.when().get(resourceAPI.getResource())
                .then()
                .spec(responseSpecification())
                .log()
                .all()
                .assertThat()
                .statusCode(404)
                .extract()
                .response();

        String errorMessage = getJsonPath(response,"errorMessages.get(0)");
        System.out.println("Error message:" +errorMessage);
        Assert.assertEquals(errorMessage, "Issue Does Not Exist");

    }

    public void addTestStep(String method) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(method);
        requestSpec = given()
                .spec(requestSpecification())
                .pathParam("issueId", testKey)
                .body(Payload.AddTestStep())
                .filter(session)
                .log()
                .all();
        response = requestSpec
                .when()
                .post(resourceAPI.getResource())
                .then()
                .spec(responseSpecification())
                .log()
                .all()
                .assertThat()
                .statusCode(201)
                .extract()
                .response();

        stepId = getJsonPath(response,"step.id");
        System.out.println("Step ID:" +stepId);
        getTestStep("GetTestStepAPI");
    }

    public void editTestStep(String method) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(method);
        requestSpec = given()
                .spec(requestSpecification())
                .pathParam("issueId", testKey)
                .pathParam("stepId",stepId)
                .body(Payload.EditTestStep())
                .filter(session)
                .log()
                .all();
        response = requestSpec
                .when()
                .put(resourceAPI.getResource())
                .then()
                .spec(responseSpecification())
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String editedStepId = getJsonPath(response,"step.id");
        System.out.println("Edited Step ID:" +editedStepId);
        Assert.assertEquals(stepId,editedStepId);
    }

    public void getTestStep(String method) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(method);
        requestSpec = given()
                .spec(requestSpecification())
                .pathParam("issueId", testKey)
                .pathParam("stepId", stepId)
                .filter(session)
                .log()
                .all();
        response = requestSpec
                .when()
                .get(resourceAPI.getResource())
                .then()
                .spec(responseSpecification())
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String extractedStepId = getJsonPath(response,"step.id");
        System.out.println("Extracted Step ID:" +extractedStepId);
        Assert.assertEquals(stepId,extractedStepId);
    }

        public void deleteTestStep(String method) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(method);
        requestSpec = given()
                .spec(requestSpecification())
                .pathParam("issueId", testKey)
                .pathParam("stepId",stepId)
                .filter(session)
                .log()
                .all();
        response = requestSpec
                .when()
                .delete(resourceAPI.getResource())
                .then()
                .spec(responseSpecification())
                .log()
                .all()
                .assertThat()
                .statusCode(204)
                .extract()
                .response();

        getNonExistingTestStepRequest("GetTestStepAPI");
    }


    public void getNonExistingTestStepRequest(String method) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(method);
        requestSpec = given()
                .spec(requestSpecification())
                .header("X-Atlassian-Token", "no-check")
                .pathParam("issueId", issueId)
                .pathParam("stepId", stepId)
                .filter(session)
                .log()
                .all();
        response = requestSpec
                .when()
                .get(resourceAPI.getResource())
                .then()
                .spec(responseSpecification())
                .log()
                .all()
                .assertThat()
                .statusCode(400)
                .extract()
                .response();

        String errorMessage = getJsonPath(response,"error");
        System.out.println("Error message:" +errorMessage);
        Assert.assertEquals(errorMessage, "Test Step with id "+stepId+" not found or is not of type Test Step.");
    }

    public void AddTestsToTestSet(String method) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(method);
        requestSpec = given()
                .spec(requestSpecification())
                .pathParam("testSetKey", "XRAY-160")
                .body(dataBuild.addTest("XRAY-29","XRAY-3"))
                .filter(session)
                .log()
                .all();
        response = requestSpec
                .when()
                .post(resourceAPI.getResource())
                .then()
                .spec(responseSpecification())
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        getTestSet("TestSetAPI");
    }

    public void removeTestFromTestSet(String method) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(method);
        requestSpec = given()
                .spec(requestSpecification())
                .pathParam("testSetKey", "XRAY-160")
                .body(Payload.removeTestsFromTestSet())
                .filter(session)
                .log()
                .all();
        response = requestSpec
                .when()
                .post(resourceAPI.getResource())
                .then()
                .spec(responseSpecification())
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

       List<String> responseList = new ArrayList<>();
       responseList.add(response.asString());
       Assert.assertFalse(responseList.contains("XRAY-29, XRAY-3"));
    }

    public void getTestSet(String method) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(method);
        requestSpec = given()
                .spec(requestSpecification())
                .pathParam("testSetKey", "XRAY-160")
                .filter(session)
                .log()
                .all();
        response = requestSpec
                .when()
                .get(resourceAPI.getResource())
                .then()
                .spec(responseSpecification())
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String getResponse = getJsonPath(response,"key");
        System.out.println(getResponse);
        Assert.assertTrue(getResponse.contains("XRAY-29, XRAY-3"));

    }
}

