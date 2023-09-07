package Pages.Admin.Branch;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AddNewBranch extends BasePage {
    public AddNewBranch(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By BrandList = By.id("brand");//list
    By OperatingCountry = By.id("operatingCountry"); //autocomplete
    By BranchName = By.id("groupName");
    By State = By.id("state"); //list
    By City = By.id("city"); //list
    By postOfficeBoxEle = By.id("zip");
    By phoneNoEle = By.id("phoneOne1");
    By address = By.id("address1");
    By BranchEmail = By.id("branchEmail");
    By BranchPassword = By.id("branchEmailPassword");
    By BranchContactName = By.id("name1");
    By BranchEmailId = By.id("email");
    By BranchPhoneNo = By.id("phone1");
    By DepartmentList = By.id("mutti_select");
    By branchManagerChoice = DepartmentList.cssSelector("ul-li-ol-style");
    By branchManagerIcon = branchManagerChoice.xpath("/html/body/div/section/div/div[2]/div/div/div[4]/form/div[3]/div[2]/div/div[4]/div[2]/div[1]/div/div/ul/li[2]/label/input");
    By CreditTxt = By.id("creditLimit");
    By TopUpLimit = By.id("topupLimit");
    By CreditDays = By.id("creditTerms");
    By cashOption = By.xpath("/html/body/div/section/div/div[2]/div/div/div[4]/form/div[3]/div[5]/div[2]/ul/li[1]/label");
    By galillioCheckBox = By.xpath("(//*[@id=\"1\"]/td[1]/label)[1]");
    By supplierDescriptionTxtFiled = By.id("desc_0");
    By pccChoices = By.id("credentialGalileo0");
    By galelioManagerName = By.id("managerNameGalileo0");
    By supplierCredentialDescription = By.id("descriptionPccGalileo0");
    public By confirmationmssg = By.xpath("//*[@id=\"statusMsg\"]/font/font");
    By sendForApprovalBttn = By.id("create");
    By selectedCountry = By.xpath("//*[@id=\"ui-id-16\"]");


    ;

    public void addBranchWithValidData(String branchName, String Address, String postOfficeBox
            , String phoneNo, String branchEmail, String branchPassword, String branchContactName, String branchEmailContact
            , String branchPhoneNumber, String creditLimit, String topUpLimit, String creditTermsDays) throws InterruptedException {
        driver.element().select(BrandList, "NDC"); //list
        driver.element().type(OperatingCountry, "egy").click(OperatingCountry);
        driver.element().keyPress(OperatingCountry, Keys.ARROW_DOWN).keyPress(OperatingCountry, Keys.ENTER);
        driver.element().type(BranchName, branchName);
        driver.element().select(State, "giza");
        //list
        driver.element().select(City, "giza") //list
                .type(address, Address)
                .type(postOfficeBoxEle, postOfficeBox)
                .type(phoneNoEle, phoneNo)
                .type(BranchEmail, branchEmail)
                .type(BranchPassword, branchPassword)
                .type(BranchContactName, branchContactName)
                .type(BranchEmailId, branchEmailContact)
                .type(BranchPhoneNo, branchPhoneNumber)
                .click(DepartmentList).scrollToElement(branchManagerIcon).click(branchManagerIcon)
                .type(CreditTxt, creditLimit)
                .type(TopUpLimit, topUpLimit)
                .type(CreditDays, creditTermsDays)
                .click(cashOption)
                .click(galillioCheckBox)
                .type(supplierDescriptionTxtFiled, "LIVE")
                .select(pccChoices, "Galileo Live UAE")
                .select(pccChoices, "importpnr PCC")
                .select(pccChoices, "Live Egypt PCC")
                .type(galelioManagerName, "Hesham")
                .type(supplierCredentialDescription, "LIVE")
                .click(sendForApprovalBttn);


    }
}
