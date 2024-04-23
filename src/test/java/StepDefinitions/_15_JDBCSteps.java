package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class _15_JDBCSteps {
    DialogContent dc=new DialogContent();
    @Then("Send The Query the Database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String sorgu) {

        // DB den oku sonuçları al
        List<List<String>> dbList= DBUtility.getListData(sorgu);

        // kontorl ediyorum db den okuyabildim mi
        for (int i = 0; i < dbList.size(); i++)
            System.out.println(dbList.get(i).get(0));

        // UI(Web) dan oku sonuçları al
        List<WebElement> UIList=dc.nameList;
        //kontrol
        for (int i = 0; i < UIList.size(); i++)
            System.out.println(UIList.get(i).getText());


        //karşılaştır, birebir aynı mı
        for (int i = 0; i < dbList.size(); i++)
            Assert.assertEquals(dbList.get(i).get(0),
                                UIList.get(i).getText().trim(),
                                "Eşleştirme yapılamadı");

    }
}
