package stepDefs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Then;

public class SecondStepDefs extends BaseCucumberTest {
    private BaseCucumberTest BaseCucumberTest;

    public SecondStepDefs(baseEntities.BaseCucumberTest baseCucumberTest) {
        BaseCucumberTest = baseCucumberTest;
    }

    @Then("открыть страницу настроек")
    public void openSetupPage() {
        driver.get("");
    }
}
