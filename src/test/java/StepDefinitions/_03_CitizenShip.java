package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class _03_CitizenShip {
    LeftNav ln = new LeftNav();
    DialogContent dc=new DialogContent();

    @And("Navigate to CitizenShip")
    public void navigateToCitizenShip() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.citizenship);
    }

    @When("Create a CitizenShip")
    public void createACitizenShip() {
        String citizenshipName = RandomStringUtils.randomAlphanumeric(8);//8 harf
        String citizenshipShortName = RandomStringUtils.randomAlphanumeric(4); // 4 rakam

        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput, citizenshipName);
        dc.mySendKeys(dc.shortName, citizenshipShortName);
        dc.myClick(dc.saveButton);
    }

    @When("Create a CitizenShip name as {string} shortkod as {string}")
    public void createACitizenShipNameAsShortkodAs(String name, String shortKod) {
        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput, name);
        dc.mySendKeys(dc.shortName, shortKod);
        dc.myClick(dc.saveButton);
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.alreadyExist,"already");
    }


    @When("user delete name as {string}")
    public void userDeleteNameAs(String deleteName) {
          dc.deleteItem(deleteName);
    }
}
