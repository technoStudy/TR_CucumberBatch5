package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before// Cucumber ın Annotation ı
    public void before(){
        // System.out.println("Senaryo başladı");
    }

    @After // Cucumber ın Annotation ı
            // her senaryodan sonra çalışır
    public void after(){
        GWD.quitDriver();
    }


}
