package TestPackage.AdminPackage.Branch;

import Pages.Admin.Branch.AddNewBranch;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import Pages.Admin.Branch.SearchBranch;
import TestPackage.BasePage.TCBase;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;


public class AddNewBranchTC extends TCBase {
    SHAFT.TestData.JSON branchData;
    LoginPage loginobj;
    DashboardPage dashObj;
    AddNewBranch addBranchObj;
    SearchBranch searchObj;
    Faker faker = new Faker();
    String branchName = faker.name().name();


    @Test
    public void AddBranchWithValidDataAndApproveIt() throws InterruptedException {
        branchData = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath") + "addbranchdata.json");
        loginobj = new LoginPage(driver);
        searchObj = new SearchBranch(driver);
        dashObj = new DashboardPage(driver);
        addBranchObj = new AddNewBranch(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj.openAddBranchPage();
        addBranchObj.addBranchWithValidData(branchName, branchData.getTestData("address"), String.valueOf(faker.number().digits(8)),
                String.valueOf(faker.number().digits(11)), faker.internet().emailAddress(), branchData.getTestData("branchPassword"), faker.name().name(),
                faker.internet().emailAddress(), String.valueOf(faker.number().digits(11)), branchData.getTestData("creditLimit"), branchData.getTestData("topUpLimit"),
                branchData.getTestData("creditDays"));
        driver.assertThat().element(addBranchObj.confirmationmssg).isVisible();
        searchObj.searchAboutSpecificBranchUsingBranchName(branchName);
        searchObj.approveNewBranchRequest();
        Thread.sleep(100000);



    }
}



