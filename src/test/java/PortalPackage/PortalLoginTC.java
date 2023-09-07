package PortalPackage;

import PortalPackage.Base.PortalTCBase;
import Portal.PortalLoginPage;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class PortalLoginTC extends PortalTCBase {
    PortalLoginPage portalloginobject;


    @AfterSuite
    public void CloseBrowser() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().closeCurrentWindow();
        driver.quit();
    }



    @Test
    public void PortalLoginWithValidCredentials() throws InterruptedException {
        portalloginobject = new PortalLoginPage(driver);
        portalloginobject.PortalLoginWithValidData();
    }

}
