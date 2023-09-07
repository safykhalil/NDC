package TestPackage.AdminPackage.Branch;

import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Admin.Branch.SearchBranch;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class SearchBranchTC extends TCBase {
    LoginPage loginobj ;
    DashboardPage dashObj;
    SearchBranch searchBranchObj;
    String branchName = "Test";
    String branchCode = "BRN2";
    @Test(priority = 1)
    public void searchAboutAllActiveBranches() throws InterruptedException {
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openSearchBranchPage();
        searchBranchObj = new SearchBranch(driver);
        searchBranchObj.searchAboutAnyBranchWithActiveStatus();
        driver.assertThat().element(searchBranchObj.branchTable).isVisible();
    }
    @Test(priority = 2)
    public void searchAboutSpecificBranch() throws InterruptedException {

        searchBranchObj.searchAboutSpecificBranchWithValidData(branchCode,branchName);
        driver.assertThat().element(searchBranchObj.branchTable).isVisible();

    }
    @Test(priority = 3)
    public void searchAboutAllInActiveBranches() throws InterruptedException {

        searchBranchObj.searchAboutAnyBranchWithInActiveStatus();
        driver.assertThat().element(searchBranchObj.branchTable).isVisible();

    }
    @Test(priority = 4)
    public void approveNewBranchRequest() throws InterruptedException {

        searchBranchObj.approveNewBranchRequest();

    }

}
