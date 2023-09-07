package Pages.RuleEngine.AddRuleEngine;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class AddServiceChargePage extends BasePage {
    public AddServiceChargePage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By productList = By.id("ruleGroupId");
    By serviceChargeName = By.id("serviceChargeName");
    By serviceChargeDescription = By.id("serviceChargeDesc");
    By serviceChargeFromPeriod = By.id("validFrom");
    By serviceChargeToPeriod = By.id("validTo");
    By countryDropDown = By.id("country-dropdown");  //text send to it country name
    By countryResultList = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[2]/div[1]/div[1]/div[2]/div[2]"); // list choose from it country
    By imageBranch = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[2]/div[2]/div[1]/div[1]/img"); // image click on it to select all branches
    By optionAllBranches = By.xpath("/html/body/div/section/div/div[2]/div/div/form/div[2]/div[6]/div[2]/div[2]/div[1]/div[2]/div[2]/div/input"); // OPTION ALL
    By imageAgency = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[3]/div[1]/div[1]/div[1]/img"); // image click on it to select all agencies
    By optionAllAgencies = By.xpath("/html/body/div/section/div/div[2]/div/div/form/div[2]/div[6]/div[3]/div[1]/div[1]/div[2]/div[2]/div/input"); // OPTION ALL agencies
    By ruleCriteria = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[4]/div[1]/ul"); //list specify criteria from it
    By selectCriteriaList = ruleCriteria.id("entity_0"); // select list (supplier choice )
    By searchIcon = ruleCriteria.id("ssearch_0");
    By supplierList = By.id("add_entity"); // list of suppliers
    By allSupplierOptions = supplierList.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[8]/div/div/div[2]/div[3]/div[1]/div[2]/label[1]/input"); //click on it
    By addBttn = By.id("add_restricted_airline"); // add button click on it
    By saveBttn = By.id("save_airline"); // save button
    By fareList = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[5]/div/div/div[2]/div[1]/select"); // fare list
    By amountOrPercentageList = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[5]/div/div/div[2]/div[2]/select"); // percentage or amount list
    By serviceChargeAmount = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[5]/div/div/div[2]/div[3]/input");
    public By statusMssg = By.id("statusMsg");
    By sendForApprovalBttn = By.id("sendApprovel"); // send for approval button
    Calendar calendar = Calendar.getInstance();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public void addServiceChargeWithValidCriteria(String productType, String servicechargename, String servicechargedescription,
                                                  String country, String supplierChoice, String fareType, String amount, int value) {

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productList, productType)
                .type(serviceChargeName, servicechargename)
                .type(serviceChargeDescription, servicechargedescription)
                .type(serviceChargeFromPeriod, today.format(myFormatObj))
                .type(serviceChargeToPeriod, tomorrow.format(myFormatObj))
                .type(countryDropDown, country)
                .click(countryResultList)
                .click(imageBranch)
                .click(optionAllBranches)
                .click(imageAgency)
                .click(optionAllAgencies)
                .select(selectCriteriaList, supplierChoice)
                .click(searchIcon)
                .click(allSupplierOptions)
                .click(addBttn)
                .click(saveBttn)
                .select(fareList, fareType)
                .select(amountOrPercentageList, amount)
                .type(serviceChargeAmount, String.valueOf(value))
                .click(sendForApprovalBttn);
    }
    public void addServiceChargeWithNoServiceName(String productType, String servicechargedescription,
                                                  String country, String supplierChoice, String fareType, String amount, int value) throws InterruptedException{
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productList, productType)
                .type(serviceChargeDescription, servicechargedescription)
                .type(serviceChargeFromPeriod, today.format(myFormatObj))
                .type(serviceChargeToPeriod, tomorrow.format(myFormatObj));
        new ElementActions().keyPress(countryDropDown, Keys.ARROW_DOWN).click(countryResultList);
        driver.element().click(imageBranch)
                .click(optionAllBranches)
                .click(imageAgency)
                .click(optionAllAgencies)
                .select(selectCriteriaList, supplierChoice)
                .click(searchIcon)
                .click(allSupplierOptions)
                .click(addBttn)
                .click(saveBttn)
                .select(fareList, fareType)
                .select(amountOrPercentageList, amount)
                .type(serviceChargeAmount, String.valueOf(value))
                .click(sendForApprovalBttn);
    }
    public void addServiceChargeWithNoServiceDescription(String productType, String servicechargename,
                                                         String country, String supplierChoice, String fareType, String amount, int value)throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productList, productType)
                .type(serviceChargeName, servicechargename)
                .type(serviceChargeFromPeriod, today.format(myFormatObj))
                .type(serviceChargeToPeriod, tomorrow.format(myFormatObj));
        new ElementActions().keyPress(countryDropDown, Keys.ARROW_DOWN);
        Thread.sleep(1000);
        driver.element().click(countryResultList);
        driver.element().click(imageBranch)
                .click(optionAllBranches)
                .click(imageAgency)
                .click(optionAllAgencies)
                .select(selectCriteriaList, supplierChoice)
                .click(searchIcon)
                .click(allSupplierOptions)
                .click(addBttn)
                .click(saveBttn)
                .select(fareList, fareType)
                .select(amountOrPercentageList, amount)
                .type(serviceChargeAmount, String.valueOf(value))
                .click(sendForApprovalBttn);
    }
    public void addServiceChargeWithNoValidityPeriod(String productType, String servicechargename, String servicechargedescription,
                                                     String country, String supplierChoice, String fareType, String amount, int value) throws InterruptedException{
        driver.element().select(productList, productType)
                .type(serviceChargeName, servicechargename)
                .type(serviceChargeDescription, servicechargedescription);
        new ElementActions().keyPress(countryDropDown, Keys.ARROW_DOWN).click(countryResultList);
        driver.element().click(imageBranch)
                .click(optionAllBranches)
                .click(imageAgency)
                .click(optionAllAgencies)
                .select(selectCriteriaList, supplierChoice)
                .click(searchIcon)
                .click(allSupplierOptions)
                .click(addBttn)
                .click(saveBttn)
                .select(fareList, fareType)
                .select(amountOrPercentageList, amount)
                .type(serviceChargeAmount, String.valueOf(value))
                .click(sendForApprovalBttn);
    }
    public void addServiceChargeWithNoFareType(String productType, String servicechargename, String servicechargedescription,
                                               String country, String supplierChoice, String amount, int value) throws InterruptedException{
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productList, productType)
                .type(serviceChargeName, servicechargename)
                .type(serviceChargeDescription, servicechargedescription)
                .type(serviceChargeFromPeriod, today.format(myFormatObj))
                .type(serviceChargeToPeriod, tomorrow.format(myFormatObj));
        new ElementActions().keyPress(countryDropDown, Keys.ARROW_DOWN).click(countryResultList);
        driver.element().click(imageBranch)
                .click(optionAllBranches)
                .click(imageAgency)
                .click(optionAllAgencies)
                .select(selectCriteriaList, supplierChoice)
                .click(searchIcon)
                .click(allSupplierOptions)
                .click(addBttn)
                .click(saveBttn)
                .select(amountOrPercentageList, amount)
                .type(serviceChargeAmount, String.valueOf(value))
                .click(sendForApprovalBttn);
    }
    // Add new Service Charge Without Amount
    public void addServiceChargeWithNoAmount(String producttype, String servicechargename, String servicechargedescription, String country, String supplierChoice, String fareType, int value) throws InterruptedException{
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productList, producttype)
                .type(serviceChargeName, servicechargename)
                .type(serviceChargeDescription, servicechargedescription)
                .type(serviceChargeFromPeriod, today.format(myFormatObj))
                .type(serviceChargeToPeriod, tomorrow.format(myFormatObj));
        new ElementActions().keyPress(countryDropDown, Keys.ARROW_DOWN).click(countryResultList);
        driver.element().click(imageBranch)
                .click(optionAllBranches)
                .click(imageAgency)
                .click(optionAllAgencies)
                .select(selectCriteriaList, supplierChoice)
                .click(searchIcon)
                .click(allSupplierOptions)
                .click(addBttn)
                .click(saveBttn)
                .select(fareList, fareType)
                .type(serviceChargeAmount, String.valueOf(value))
                .click(sendForApprovalBttn);
    }
    public void addServiceChargeWithNoValue(String productType, String servicechargename, String servicechargedescription,
                                            String country, String supplierChoice, String fareType, String amount) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productList, productType)
                .type(serviceChargeName, servicechargename)
                .type(serviceChargeDescription, servicechargedescription)
                .type(serviceChargeFromPeriod, today.format(myFormatObj))
                .type(serviceChargeToPeriod, tomorrow.format(myFormatObj));
        new ElementActions().keyPress(countryDropDown, Keys.ARROW_DOWN).click(countryResultList);
        driver.element().click(imageBranch)
                .click(optionAllBranches)
                .click(imageAgency)
                .click(optionAllAgencies)
                .select(selectCriteriaList, supplierChoice)
                .click(searchIcon)
                .click(allSupplierOptions)
                .click(addBttn)
                .click(saveBttn)
                .select(fareList, fareType)
                .select(amountOrPercentageList, amount)
                .click(sendForApprovalBttn);
    }
    public void addServiceChargeWithNoData()throws InterruptedException {
    }
}