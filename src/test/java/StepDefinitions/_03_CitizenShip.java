package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

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

}
