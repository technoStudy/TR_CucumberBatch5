package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;


public class GWD {

    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();

    public static WebDriver getDriver(){

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadDriver.get() == null) { //1 kez oluştur

            threadDriver.set(new ChromeDriver()); //bulunduğum hatta driver yok idi, ben bir tane set ettim

            threadDriver.get().manage().window().maximize();
            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }

        return threadDriver.get();
    }


    public static void quitDriver(){

        //test sonucu ekranı bir miktar beklesin diye
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //driver kapat
        if (threadDriver.get() != null){ //bu hatta driver var ise

            threadDriver.get().quit();

            WebDriver driver= threadDriver.get();
            driver=null;
            threadDriver.set(driver);//bu hattaki driver NULL oldu
        }

    }


}
