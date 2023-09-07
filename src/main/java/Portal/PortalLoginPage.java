package Portal;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;



public class PortalLoginPage extends PortalBasePage{
//    protected SHAFT.GUI.WebDriver driver;




//
//    public PortalLoginPage(SHAFT.GUI.WebDriver driver) {
//        super();
//        this.driver = driver;
//    }
    public PortalLoginPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By AgencyCode = By.id("agencyCodeMain");
    By Email = By.id("userAlias");
    By Password = By.id("password_password");
    By LoginBttn = By.xpath("//*[@id=\"loginPage\"]/div/div[2]/div/div[1]/div[5]/input");



    public void PortalLoginWithValidData() {
            driver.element().type(AgencyCode, "AGN2")
                    .type(Email, "E.saady@ndceg.com")
                    .type(Password, "a");
            driver.element().click(LoginBttn);

    }



}