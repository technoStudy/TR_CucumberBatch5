package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Hooks {

    @Before// Cucumber ın Annotation ı
    public void before(){
        // System.out.println("Senaryo başladı");
    }

    @After // Cucumber ın Annotation ı
            // her senaryodan sonra çalışır
    public void after(Scenario senaryo){

        //senaryo fail olduysa ekran kaydı al
        if (senaryo.isFailed()){
            TakesScreenshot ts=(TakesScreenshot) driver;
            File hafizadakiHali= ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(hafizadakiHali, new File("ekranGoruntuler\\screenshot.jpg"));
        }

        GWD.quitDriver();
    }


}
