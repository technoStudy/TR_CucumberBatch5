package StepDefinitions;

import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _08_DataTableSteps {
    LeftNav ln=new LeftNav();

    @And("Click on the Element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable linkler) {
        List<String> strLinkList= linkler.asList(String.class);

        for(int i=0;i< strLinkList.size();i++) {
            //System.out.println(strLinkList.get(i));
            WebElement linkWebElemnt= ln.getWebElement(strLinkList.get(i));
            ln.myClick(linkWebElemnt);
        }

    }
}
