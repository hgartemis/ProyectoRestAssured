package BasicCode;

import org.json.JSONObject;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BasicCreateProject {

    @Test
    public void CreateProjecUsingStringBody() {

        given()
                .auth()
                .preemptive()
                .basic("jb50@jb50.com","12345")
                .body("{\n" +
                        "    \"Content\":\"ProyectoHGSNuevo\",\n" +
                        "    \"Icon\": \"4\"\n" +
                        "}")
        .when()
                .post("https://todo.ly/api/projects.json")
        .then()
                .statusCode(200)
                .body("Content",equalTo("ProyectoHGSNuevo"))
                .body("Icon",equalTo(4))
        .log().all();

    }

    @Test
    public void CreateProjecUsingExternalFile() {

        given()
                .auth()
                .preemptive()
                .basic("jb50@jb50.com","12345")
                .body(new File("D:\\Infor Acer\\QA JB Enterprise\\Curso RestAssured\\PruebaAPI\\src\\test\\resources\\createProjectoBody.json"))
        .when()
                .post("https://todo.ly/api/projects.json")
        .then()
                .statusCode(200)
                .body("Content",equalTo("ProyectoHGSNuevo"))
                .body("Icon",equalTo(2))
                .log().all();

    }

    @Test
    public void CreateProjecUsingJSONObject() {

        JSONObject bodyProyect = new JSONObject();
        bodyProyect.put("Content","HumbertoJSONPrueba");
        bodyProyect.put("Icon","5");

        given()
                .auth()
                .preemptive()
                .basic("jb50@jb50.com","12345")
                .body(bodyProyect.toString())
        .when()
                .post("https://todo.ly/api/projects.json")
        .then()
                .statusCode(200)
                .body("Content",equalTo("HumbertoJSONPrueba"))
                .body("Icon",equalTo(5))
                .log().all();

    }

}
