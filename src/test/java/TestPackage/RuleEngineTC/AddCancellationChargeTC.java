package TestPackage.RuleEngineTC;

import Pages.RuleEngine.AddRuleEngine.AddCancellationChargePage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class AddCancellationChargeTC extends TCBase {

    String producttype= "Flight";
    String cancellationName = "Tilde TEST";
    String cancellationDescription = "Tested by tilde testing team";
    String country = "a";
    String fareType= "Total Fare";
    String amount = "Amount" ;
    String leivedBy = "Per Person" ;
    int adultAmount = 10 ;
    int childAmount = 10 ;
    int infantAmount = 10 ;

    LoginPage loginObj ;
    DashboardPage dashObj;
    AddCancellationChargePage addCancellationObj;
    @Test
    public void addCancellationChargeWithValidData() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openAddCancellationChargePage();
        addCancellationObj = new AddCancellationChargePage(driver);
        addCancellationObj.addCancellationChargeWithValidData(producttype,cancellationName,cancellationDescription,country,
                fareType,amount,leivedBy,adultAmount,childAmount,infantAmount);
        driver.assertThat().element(addCancellationObj.statusMssg).isVisible();
    }
}
