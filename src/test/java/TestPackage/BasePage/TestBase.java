package TestPackage.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public static WebDriver driver;


    @BeforeSuite
    public void SetupDriver() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ndc-egy.com/odeysysadmin/");
                Thread.sleep(2000);
    }
}
