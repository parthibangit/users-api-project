package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestStatusHooks {

    @Before
    public void printInfo() {

        System.out.println("Scenario started ................");
    }


    @After
    public void updateStatus(Scenario scenario) {

        if (scenario.isFailed()) {
            System.out.println("Following scenario got failed: "+ scenario.getName());
        }
    }
}
