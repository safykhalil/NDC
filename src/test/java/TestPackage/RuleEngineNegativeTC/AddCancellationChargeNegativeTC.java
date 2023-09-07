package TestPackage.RuleEngineNegativeTC;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.RuleEngine.AddRuleEngine.AddCancellationChargePage;
import TestPackage.BasePage.TCBase;
import com.github.javafaker.Faker;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddCancellationChargeNegativeTC extends TCBase {

    LoginPage loginObj ;
    DashboardPage dashObj;
    AddCancellationChargePage addCancellationObj;
    SHAFT.TestData.JSON cancellationData;
    Faker faker;

    @BeforeTest
    public void beforeTest()throws InterruptedException{
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openAddCancellationChargePage();
    }

    @Test
    public void addCancellationChargeWithEmptyFields() throws InterruptedException {
        dashObj.openAddCancellationChargePage();
        addCancellationObj = new AddCancellationChargePage(driver);
        addCancellationObj.addCancellationChargeWithEmptyFields();
        Assert.assertEquals(driver.getDriver().getCurrentUrl(),"http://192.168.1.50:8080/odeysysadmin/Rules/createRuleCancellationCharge");
    }
    @Test (priority = 1)
    public void addCancellationChargeWithEmptyCountry() throws InterruptedException {
        cancellationData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") +"AddCancellationChargeData.json") ;
        faker = new Faker();
        dashObj.openAddCancellationChargePage();
        addCancellationObj = new AddCancellationChargePage(driver);
        addCancellationObj.addCancellationChargeWithEmptyCountry(cancellationData.getTestData("producttype"),faker.name().name(),faker.name().fullName(),
                cancellationData.getTestData("fareType"), cancellationData.getTestData("amount"), cancellationData.getTestData("leivedBy"),
                Integer.parseInt(cancellationData.getTestData("adultAmount")),Integer.parseInt(cancellationData.getTestData("childAmount")),Integer.parseInt(cancellationData.getTestData("infantAmount")));
        Thread.sleep(2000);
        Assert.assertEquals(driver.element().getText(addCancellationObj.countryErrorMsg),"Country POS Is required.");
    }
    @Test (priority = 2)
    public void addCancellationChargeWithCountryThatAlreadyExists() throws InterruptedException {
        dashObj.openAddCancellationChargePage();
        addCancellationObj = new AddCancellationChargePage(driver);
        addCancellationObj.addCancellationChargeWithCountryThatAlreadyExists(cancellationData.getTestData("producttype"),faker.name().name(),faker.name().fullName(), cancellationData.getTestData("country"),
                cancellationData.getTestData("fareType"),cancellationData.getTestData("amount"),cancellationData.getTestData("leivedBy"),
                Integer.parseInt(cancellationData.getTestData("adultAmount")),Integer.parseInt(cancellationData.getTestData("childAmount")),Integer.parseInt(cancellationData.getTestData("infantAmount")));
        Assert.assertEquals(driver.element().getText(addCancellationObj.errorMsg),"Egypt is already mapped.Please remove these countries from existing RuleCancellationCharge Records.");
    }
}