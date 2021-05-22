package runner;

import factoryRequest.FactoryRequest;
import factoryRequest.FactoryRequest;
import factoryRequest.RequestInformation;
import helpers.ConfigurationAPI;
import helpers.Environment;
import helpers.JsonHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static helpers.Constantes.AUTHORIZATION;

public class MyStepClean {
    Response response;
    RequestInformation requestInformation= new RequestInformation();
    Map<String,String> myValues= new HashMap<>();

    @Given("I have access to API todo.ly")
    public void iHaveAccessToAPITodoLy() {
        requestInformation = new RequestInformation();
        requestInformation.setTypeAuthentication(AUTHORIZATION);
        requestInformation.setValueAuthentication("Basic "+ Base64.getEncoder().encodeToString((Environment.user+":"+ Environment.password).getBytes()));
    }

    @When("I send a request {} to {string} with body")
    public void iSendARequestPOSTToWithBody(String method, String url, String body) {
        requestInformation.setUrl(buildURL(url));
        requestInformation.setBody(replace(body));
        response=FactoryRequest.make(method).send(requestInformation);
    }

    @Then("I expected the response code is {int}")
    public void iExpectedTheResponseCodeIs(int expectedResult) {
        response.then().statusCode(expectedResult);
    }

    @And("I expected the response body")
    public void iExpectedTheResponseBody(String expectedResult) {
        Assert.assertTrue("ERROR> el response body no es igual", JsonHelper.areEqual(expectedResult,response.body().asString()));
    }

    @And("I save the property {} in {}")
    public void iSaveThePropertyIdInID_PROJECT(String property, String nameVar) {
        String value=response.then().extract().path(property)+"";
        myValues.put(nameVar,value);
    }

    @When("I send a request {} to {string} with ID : {} with body")
    public void iSendARequestPUTToWithIDID_PROJECTWithBody(String method,String url, String id, String body ) {
        requestInformation.setUrl(buildURL(url).replace("ID",replace(id)));
        requestInformation.setBody(replace(body));
        response=FactoryRequest.make(method).send(requestInformation);
    }

    public String buildURL(String url){
        return url.replace("CREATE_PROJECT", ConfigurationAPI.createProjectAPI)
                .replace("UPDATE_PROJECT",ConfigurationAPI.updateProjectAPI)
                .replace("DELETE_PROJECT",ConfigurationAPI.deleteProjectAPI);
    }

    public String replace(String value){
        for (String attribute :myValues.keySet() ) {
            value=value.replace(attribute,myValues.get(attribute));
        }
        return value;
    }

}
