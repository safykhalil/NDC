package TestPackage.RuleEngineTC;

import Pages.RuleEngine.AddRuleEngine.AddDiscountPage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;

public class AddDiscountTC extends TCBase {
    LoginPage loginobj;
    DashboardPage dashObj;
    AddDiscountPage addDiscountObj;
    SHAFT.TestData.JSON discountData ;

    @Test
    public void addDiscountWithAValidData() throws InterruptedException {
        discountData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "AddDiscountData.json");
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openAddDiscountPage();

        addDiscountObj = new AddDiscountPage(driver);
        addDiscountObj.addDiscountWithValidCriteria(discountData.getTestData("productType"),
                discountData.getTestData("discountName"),
                discountData.getTestData("discountDescription"),
                discountData.getTestData("country"),
                discountData.getTestData("supplier"),
                discountData.getTestData("fareType"),
                discountData.getTestData("Amount"),
                discountData.getTestData("value"));
        driver.assertThat().element(addDiscountObj.statusMssg).isVisible();
        driver.assertThat().element(addDiscountObj.statusMssg).isVisible();
      

    }
}
