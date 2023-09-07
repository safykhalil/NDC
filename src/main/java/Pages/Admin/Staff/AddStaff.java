package Pages.Admin.Staff;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

    public class AddStaff extends BasePage {
        public AddStaff(SHAFT.GUI.WebDriver driver) {
            super(driver);
        }

        By Admin = By.xpath("//*[@id=\"Admin\"]/a");
        By LeftCorner = By.id("accordion");
        By Staff = By.xpath("//*[@id=\"accordion\"]/div[4]/a/div");
        By Addbttn = By.id("add_click");
        By OperatingCountryName = By.xpath("//*[@id=\"operCn\"]");
        By EgyptLive = By.xpath("//*[@id=\"operatingCn\"]/li[3]/label");
        By Branch = By.id("journeyList");
        By TrainingDept = By.xpath("//*[@id=\"branchIdUl\"]/li[2]/label");
        By SelectDept = By.id("departmentListId");
        By AREAMANAGER = By.xpath("//*[@id=\"departmentIdUl\"]/li[1]/label");
        By OFFICEADMIN = By.xpath("//*[@id=\"departmentIdUl\"]/li[7]/label");
        By SelectDesignation = By.id("designation");
        By Roles = By.id("roleIds");
        By ACC = By.xpath("//*[@id=\"roleIds\"]/option[1]");
        By EmployeeName = By.id("firstName");
        By EmployeeEmail = By.id("email");
        By EmployeePhoneNo = By.id("mobileNo");
        By Username = By.id("userAlias");
        By ApproverList = By.id("approverListId");
        By SendForApproval = By.id("create");


        public void addStaffWithValidData() {
            driver.element().click(Admin)
                    .click(Staff)
                    .click(Addbttn)
                    .click(OperatingCountryName)
                    .click(EgyptLive)
                    .click(Branch)
                    .click(TrainingDept)
                    .click(SelectDept)
                    .click(AREAMANAGER)
                    .click(OFFICEADMIN)
                    .select(SelectDesignation, "ADMIN")
                    .click(ACC)
                    .type(EmployeeName, "Tesssst")
                    .type(EmployeeEmail, "Email@testing.com")
                    .type(EmployeePhoneNo, "01096946424")
                    .type(Username, "TestingNewUser")
                    .select(ApproverList, "No Approver")
                    .click(SendForApproval);


                    //.hoverAndClick(By.xpath("//*[@id=\"operCn\"]"), By.xpath("//*[@id=\"operatingCn\"]/li[2]/label/text()"))




            //SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData());
            //By adminButton = SHAFT.GUI.Locator.hasTagName("input").containsText("staff").relativeBy().below(Admin);

//            driver.getDriver().
//            public FluentElementActions keyPress(OperatingCountryName, "egypt(Egypt)")
            //ElementActions.keyPress(DriverFactoryHelper.getDriver().get(), OperatingCountryName, "egypt(Egypt)");


            }

    }
