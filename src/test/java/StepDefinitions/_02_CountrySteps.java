package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.*;
import org.apache.commons.lang3.RandomStringUtils;

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
       String ulkeAdi= RandomStringUtils.randomAlphanumeric(8); //8 harf ver
       String ulkeKod= RandomStringUtils.randomNumeric(4); //4 rakam ver

       dc.myClick(dc.addButton);
       dc.mySendKeys(dc.nameInput,ulkeAdi);
       dc.mySendKeys(dc.codeInput,ulkeKod);
       dc.myClick(dc.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.successMessage,"success");
    }
}
