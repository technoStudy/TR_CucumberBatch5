package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.*;

public class _02_CountrySteps {
    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();

    @And("Navigate to country")
    public void navigateToCountry() {
      ln.myClick(ln.setup);
      ln.myClick(ln.parameters);
      ln.myClick(ln.countries);
    }

    @When("Create a country")
    public void createACountry() {
       dc.myClick(dc.addButton);
       dc.mySendKeys(dc.nameInput,"ulkeadi");
       dc.mySendKeys(dc.codeInput,"ulkekod");
       dc.myClick(dc.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
       // success yazısını doğrula
    }
}
