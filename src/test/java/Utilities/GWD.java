package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;


public class GWD {

    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>(); //her bir thread e özel static
    private static ThreadLocal<String> threadBrowserName=new ThreadLocal<>();

    //  threadDriver.get() -> bulunduğu hat taki driverı ver
    //  threadDriver.set(driver) -> bulunduğu hata driver set et

    // Her bir sürecin kendine özel STATİC driverı olmalı : Local Static diyeceğiz
    // süreç = Thread
    // Thread.Sleep => ilgili süreci durduryor belli süre
    // her bir Thread in kendine özel STATİC i olmalı, yani LOCAL Static


    public static WebDriver getDriver(){

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadDriver.get() == null) { // hatta driver var mı, yok ise
            threadDriver.set(new ChromeDriver());  // bir tane oluştur hatta set et
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
        if (threadDriver.get() != null){ //driver var ise
            threadDriver.get().quit();
            WebDriver driver=null;
            threadDriver.set(driver);
        }

    }


}
