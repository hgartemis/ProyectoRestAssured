package BasicCode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.HttpCookie;

import static io.restassured.RestAssured.given;

public class BasicJUnit {

    @Before
    public void setup() {
        System.out.println("before");
    }

    @After
    public void setupdespues() {
        System.out.println("after");
    }



    @Test
    public void ProjectoCompleto() {

        System.out.println("Lista de Projectos");

        // given ---> configuracion
        // when  ---> method
        // then  ---> verificacion de respuesta

                given()
                    .auth()
                    .preemptive()
                    .basic("jb50@jb50.com","12345")
                    .log().all()
                .when()
                    .get("https://todo.ly/api/projects.json")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all();

    }

    @Test
    public void crearProjecto() {

        given()
            .auth()
            .preemptive()
            .basic("jb50@jb50.com","12345")
            .log().all()
                .body("{\n" +
                        "    \"Content\":\"ProyectoHGSNuevo\",\n" +
                        "    \"Icon\": \"4\"\n" +
                        "}")
          .when()
                .post("https://todo.ly/api/projects.json")
          .then()
                .statusCode(HttpStatus.SC_OK)
                .log().all();

    }

}
