package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _08_DataTableSteps {
    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();

    @And("Click on the Element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable linkler) {
        List<String> strLinkList= linkler.asList(String.class);

        for(int i=0;i< strLinkList.size();i++) {
            //System.out.println(strLinkList.get(i));
            WebElement linkWebElemnt= ln.getWebElement(strLinkList.get(i));
            ln.myClick(linkWebElemnt);
        }
    }

    @And("Click on the Element in Dialog")
    public void clickOnTheElementInDialog(DataTable butonlar) {
        List<String> strButtonList= butonlar.asList(String.class);

        for(int i=0;i< strButtonList.size();i++) {
            //System.out.println(strLinkList.get(i));
            WebElement linkWebElemnt= dc.getWebElement(strButtonList.get(i));
            dc.myClick(linkWebElemnt);
        }
    }

    @And("User sending the keys in Dialog")
    public void userSendingTheKeysInDialog(DataTable textBoxVeYazilar) {
        List< List<String> > listTxtYazi= textBoxVeYazilar.asLists(String.class);

        for (int i = 0; i < listTxtYazi.size(); i++) {
            WebElement txtBoxWebElemnt= dc.getWebElement(listTxtYazi.get(i).get(0));
            dc.mySendKeys(txtBoxWebElemnt, listTxtYazi.get(i).get(1));
        }
    }

    @And("User delete the Element from Dialog")
    public void userDeleteTheElementFromDialog(DataTable Silinecekler) {
        List<String> strSilList= Silinecekler.asList(String.class);

        for(int i=0;i< strSilList.size();i++) {
            dc.deleteItem(strSilList.get(i));
        }

    }
}
