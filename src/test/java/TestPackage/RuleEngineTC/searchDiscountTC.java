package TestPackage.RuleEngineTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.SearchRuleEngine.SearchDiscountPage;
import TestPackage.BasePage.TCBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class searchDiscountTC extends TCBase {
    LoginPage loginobj;
    DashboardPage dashObj;
    SearchDiscountPage searchDisObj;
    @Test
    public void searchAboutAllActiveDiscount() throws InterruptedException{
        loginobj= new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj= new DashboardPage(driver);
        dashObj.openDiscountSearchPage();
        searchDisObj = new SearchDiscountPage(driver);
        searchDisObj.searchAboutActiveDiscount();
        driver.assertThat().element(By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[7]")).isVisible();
    }
    @Test
    public void searchAboutAllInActiveDiscount() throws InterruptedException{
        loginobj= new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj= new DashboardPage(driver);
        dashObj.openDiscountSearchPage();
        searchDisObj = new SearchDiscountPage(driver);
        searchDisObj.searchAboutInActiveDiscount();
        driver.assertThat().element(By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[7]")).isVisible();
    }
}
