package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;


public class GWD {

    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();  // thread e özel driver
    public static ThreadLocal<String> threadBrowserName=new ThreadLocal<>(); // o thread e özel browser name

    //threadDriver.get() -> bulunduğum thread deki driver ı al
    //threadDriver.set(driver) -> bulunduğum threade driver set et
    public static WebDriver getDriver(){

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadBrowserName.get()==null) // XML den çalışmayan durumlar için
            threadBrowserName.set("chrome");  // default chrome

        if (threadDriver.get() == null) { //1 kez oluştur

            switch (threadBrowserName.get())
            {
                case "firefox" : threadDriver.set(new FirefoxDriver()); break;
                case "edge" : threadDriver.set(new EdgeDriver()); break;
                default:

                    if (isRunningOnJenkins()){ //program jenkins den mi çalışıyor
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");

                        threadDriver.set(new ChromeDriver(options));  //bulunduğum hatta driver yok idi, ben bir tane set ettim
                    }
                    else
                        threadDriver.set(new ChromeDriver());
            }

            threadDriver.get().manage().window().maximize();
            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }

        return threadDriver.get();
    }


    public static boolean isRunningOnJenkins() {
        String jenkinsHome = System.getenv("JENKINS_HOME");
        return jenkinsHome != null && !jenkinsHome.isEmpty();
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

            WebDriver driver= threadDriver.get(); //hattaki driverı aldım
            driver=null;  // null haline getirdim
            threadDriver.set(driver);//tekrar hatta atadım.
        }

    }


}
