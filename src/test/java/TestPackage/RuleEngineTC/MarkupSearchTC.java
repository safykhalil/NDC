package TestPackage.RuleEngineTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.SearchRuleEngine.MarkupSearchPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class MarkupSearchTC extends TCBase {
    LoginPage loginobj;
    DashboardPage dashObj;
    MarkupSearchPage markupObj;
    String productType= "Flight";

   @Test
    public void searchAboutAllActiveMarkups() throws InterruptedException {
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openMarkupSearchPage();
        markupObj = new MarkupSearchPage(driver);
        markupObj.searchAboutAllActiveMarkups(productType);
        driver.assertThat().element(markupObj.mssg).isVisible();



    }
    @Test
    public void searchAboutAllInActiveMarkups() throws InterruptedException {

        markupObj.searchAboutAllInActiveMarkups(productType);
        driver.assertThat().element(markupObj.resultTable).isVisible();


    }

}
