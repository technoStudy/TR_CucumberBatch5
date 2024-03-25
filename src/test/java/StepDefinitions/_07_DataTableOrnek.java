package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class _07_DataTableOrnek {
    @When("write username {string}")
    public void writeUsername(String username) {
        System.out.println(username);
    }

    @And("write username and password {string} and {string}")
    public void writeUsernameAndPasswordAnd(String username, String password) {
        System.out.println(username+" "+password);
    }

    @And("write username as DataTable")
    public void writeUsernameAsDataTable(DataTable userlar) {
        List<String> listUserlar=userlar.asList(String.class);

        for(String user: listUserlar)
            System.out.println("user = " + user);
    }


    @And("write username and password as DataTable")
    public void writeUsernameAndPasswordAsDataTable(DataTable userPass) {

        List< List<String> > listUserPass= userPass.asLists(String.class);

        for (int i = 0; i < listUserPass.size(); i++) {
            System.out.println(listUserPass.get(i).get(0)+" "+
                    listUserPass.get(i).get(1));
        }


    }
}
