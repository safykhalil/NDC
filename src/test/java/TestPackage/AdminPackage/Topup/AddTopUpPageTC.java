package TestPackage.AdminPackage.Topup;

import Pages.Admin.Topup.AddTopUpPage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class AddTopUpPageTC extends TCBase {
    String branchName="Test";
    String agencyName= "moataztest";
    String topUpLimit= "1000";
    String receiptNo= "102030";

    LoginPage loginobj;
    DashboardPage dashObj;
    AddTopUpPage addTopUpObj;
    @Test
    public void addingTopUpAmountToBranch() throws InterruptedException {
        loginobj =new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openAddTopUpPage();
        addTopUpObj = new AddTopUpPage(driver);

    }
    @Test
    public void addingTopUpAmountToAgency() throws InterruptedException {

        addTopUpObj.addTopUpTOAgencyWithValidData(branchName,agencyName,topUpLimit,
                receiptNo);

    }

}
