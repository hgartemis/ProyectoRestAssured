package BasicCode;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BasicCRUDProject {

    @Test
    public void verifyCRUDProject(){
        // Create

        JSONObject bodyProject = new JSONObject();
        bodyProject.put("Content","JBProjectJSONhgs");
        bodyProject.put("Icon","1");

        Response response=given()
                .auth()
                .preemptive()
                .basic("jb50@jb50.com","12345")
                .body(bodyProject.toString())
                .log()
                .all()
                .when()
                .post("http://todo.ly/api/projects.json");
        response.then()
                .statusCode(200)
                .body("Content",equalTo("JBProjectJSONhgs"))
                .body("Icon",equalTo(1))
                .log()
                .all();

        String idProject = response.then().extract().path("Id")+"";
        System.out.println("**** ID Project: "+idProject);



        // Update

        bodyProject = new JSONObject();
        bodyProject.put("Content","JBProjectJSONUpdateHgs");
        bodyProject.put("Icon","2");
        System.out.println("****************** UPDATE *********************");

        response=given()
                .auth()
                .preemptive()
                .basic("jb50@jb50.com","12345")
                .body(bodyProject.toString())
                .log()
                .all()
                .when()
                .put("http://todo.ly/api/projects/"+idProject+".json");
        response.then()
                .statusCode(200)
                .body("Content",equalTo("JBProjectJSONUpdateHgs"))
                .body("Icon",equalTo(2))
                .log()
                .all();


        // Get

        response= given()
                .auth()
                .preemptive()
                .basic("jb50@jb50.com","12345")
                .log()
                .all()
                .when()
                .get("http://todo.ly/api/projects/"+idProject+".json");

        response.then()
                .statusCode(200)
                .body("Content",equalTo("JBProjectJSONUpdateHgs"))
                .body("Icon",equalTo(2))
                .body("Deleted",equalTo(false))
                .log()
                .all();

        // Delete

        response= given()
                .auth()
                .preemptive()
                .basic("jb50@jb50.com","12345")
                .log()
                .all()
                .when()
                .delete("http://todo.ly/api/projects/"+idProject+".json");

        response.then()
                .statusCode(200)
                .body("Content",equalTo("JBProjectJSONUpdateHgs"))
                .body("Icon",equalTo(2))
                .body("Deleted",equalTo(true))
                .log()
                .all();

    }

}
