package runner;

import helpers.GetProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
public class Runner {

    @Before
    public void beforeHook() throws IOException {
        System.out.println("INFO> before hook **");
        new GetProperties().leerPropiedades();

    }

    @After
    public void afterHook() {
        System.out.println("INFO> after hook **");
    }
}
