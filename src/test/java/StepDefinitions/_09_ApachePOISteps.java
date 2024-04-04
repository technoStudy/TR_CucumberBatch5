package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class _09_ApachePOISteps {
    DialogContent dc=new DialogContent();
    @When("User create citizenship with ApchePOI")
    public void userCreateCitizenshipWithApchePOI() {

        ArrayList< ArrayList<String> > tablo= ExcelUtility.getData(
                "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
                "testCitizen", 2);

        for (ArrayList<String> satir : tablo){
            dc.myClick(dc.addButton);
            dc.mySendKeys(dc.nameInput, satir.get(0));
            dc.mySendKeys(dc.shortName, satir.get(1));
            dc.myClick(dc.saveButton);
            dc.verifyContainsText(dc.successMessage, "success");
        }

    }

    @Then("User delete citizenship with ApchePOI")
    public void userDeleteCitizenshipWithApchePOI() {
        ArrayList< ArrayList<String> > tablo= ExcelUtility.getData(
                "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
                "testCitizen", 2);

        for (ArrayList<String> satir : tablo){
            dc.deleteItem(satir.get(0));
            dc.verifyContainsText(dc.successMessage, "success");
        }
    }
}
