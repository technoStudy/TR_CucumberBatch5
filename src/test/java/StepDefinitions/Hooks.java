package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;

public class Hooks {


    @After // Cucumber ın Annotation ı
            // her senaryodan sonra çalışır
    public void after(){
        GWD.quitDriver();
    }


}
