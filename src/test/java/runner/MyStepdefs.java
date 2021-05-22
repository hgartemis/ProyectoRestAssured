package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("yo voy a la pagina todo.ly")
    public void yoVoyALaPaginaTodoLy() {
        System.out.println("abriendo todo.ly");
    }

    @When("ingreso mi {} : {}")
    public void ingresoMiEmailPruebaPruebaCom(String control, String valor) {

        System.out.println("ingreso mi: "  + control + " con el valor de: " +valor);
    }

    @And("hago click en el boton login")
    public void hagoClickEnElBotonLogin() {
        System.out.println("click en login");
    }

    @Then("yo deberia de ingresar a la aplicacion")
    public void yoDeberiaDeIngresarALaAplicacion() {
        System.out.println("verificando valores ");
    }
}
