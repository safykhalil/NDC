package PortalPackage;

import Portal.TopUpWallet;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class TopUpWalletTC extends PortalLoginTC  {

    TopUpWallet TopUpObj;
    PortalLoginTC PortalLoginObj3;

    @Test
    public void AddingTopUp() throws InterruptedException {
        PortalLoginObj3 = new PortalLoginTC();
        PortalLoginObj3.PortalLoginWithValidCredentials();
        TopUpObj = new TopUpWallet(driver);
        TopUpObj.AddingTopUpWallet();
        driver.assertThat().element(By.xpath("//*[@id=\"order-details\"]/div/table/tbody/tr[1]/td/h1")).isVisible();
    }
}

