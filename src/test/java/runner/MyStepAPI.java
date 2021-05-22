package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MyStepAPI {
    Response response;
    String idProject;

    @Given("que tengo acceso al API de todo.ly")
    public void queTengoAccesoAlAPIDeTodoLy() {
    }

    @When("yo ejecuto un POST request a {string} con el body")
    public void yoEjecutoUnPOSTRequestAConElBody(String url,String body) {
        response=given()
                .auth()
                .preemptive()
                .basic("jb50@jb50.com","12345")
                .body(body)
                .log()
                .all()
                .when()
                .post(url);
    }

    @Then("yo espero que el codigo de respuesta sea {int}")
    public void yoEsperoQueElCodigoDeRespuestaSea(int expectedResult) {
        response.then().statusCode(expectedResult);
    }

    @And("espero que el Content sea {string}")
    public void esperoQueElContentSea(String expectedResult) {
        response.then()
                .body("Content",equalTo(expectedResult));
    }

    @And("yo recupero el Id del projecto en ID_PROJECT")
    public void yoRecuperoElIdDelProjectoEnID_PROJECT() {
        idProject = response.then().extract().path("Id")+"";
    }

    @When("yo ejecuto un PUT request a {string} con el body")
    public void yoEjecutoUnPUTRequestAConElBody(String url, String body) {
        response=given()
                .auth()
                .preemptive()
                .basic("jb50@jb50.com","12345")
                .body(body)
                .log()
                .all()
                .when()
                .put(url.replace("ID_PROJECT",idProject));
    }

    @When("yo ejecuto un DELETE request a {string}")
    public void yoEjecutoUnDELETERequestA(String url) {
        response=given()
                .auth()
                .preemptive()
                .basic("jb50@jb50.com","12345")
                .log()
                .all()
                .when()
                .delete(url.replace("ID_PROJECT",idProject));
    }
}
