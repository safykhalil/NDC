package Pages.RuleEngine.AddRuleEngine;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class AddMarkupPage extends BasePage {

    public AddMarkupPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By productType = By.xpath("//*[@id=\"ruleGroupId\"]");
    By markupName = By.id("markupName");
    By markupDescription = By.id("markupDesc");
    By validFrom = By.id("validFrom"); //select from date
    By validTo = By.id("validTo");     //select to date
    By countryName = By.id("country-dropdown"); // fill it with egy
    By countryCheckBox = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[2]/div[1]/div[1]/div[2]/div[2]/ul/li[1]/input"); //click on it
    By branchIconImage = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[2]/div[2]/div[1]/div[1]/img"); // click on it to select all branches
    By optionAllBranches = By.xpath("/html/body/div/section/div/div[2]/div/div/form/div[2]/div[6]/div[2]/div[2]/div[1]/div[2]/div[2]/div/input"); // OPTION ALL
    By agencyIconImage = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[3]/div[1]/div[1]/div[1]/img"); //click on it to select all agencies
    By optionAllAgencies = By.xpath("/html/body/div/section/div/div[2]/div/div/form/div[2]/div[6]/div[3]/div[1]/div[1]/div[2]/div[2]/div/input"); // OPTION ALL agencies
    By selectCriteriaOfDiscount = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[4]/div[1]/ul/li[1]/select"); //select list of criteria
    By searchIcon = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[4]/div[1]/ul/li[4]/span[1]/a/img"); //click on it to
    By allOptionsOfAllSuppliers = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[9]/div/div/div[2]/div[3]/div[1]/div[2]/label[1]/input"); //click on it to select all suppliers
    By addBttnOfAllSuppliers = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[9]/div/div/div[2]/div[3]/div[2]/ul/li[1]/input"); // button click on it to add it
    By saveBttn = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[9]/div/div/div[3]/input"); // click on it save all suppliers
    By fareType = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[7]/div/div/div[2]/div[1]/select"); // select "Total Fare" from list
    By amountList = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[7]/div/div/div[2]/div[2]/select"); // select "Amount" from list
    By amount = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[7]/div/div/div[2]/div[3]/input"); // add value as amount of discount
    ////////////
    By sendForApprovalBttn = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[8]/input[1]"); // click on it to send discount request
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public By statusMssg = By.id("statusMsg");


    public void addMarkupWithValidCriteria(String producttype, String markupname, String markupdescription, String country,
                                           String supplierChoice, String faretype, String Amount, String value) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(markupName, markupname)
                .type(markupDescription, markupdescription)
                .type(validFrom, today.format(myFormatObj))
                .type(validTo, tomorrow.format(myFormatObj))
                .type(countryName, country);
        new ElementActions().keyPress(countryName, Keys.ARROW_DOWN).click(countryCheckBox);
        driver.element().click(branchIconImage)
                .click(optionAllBranches)
                .click(agencyIconImage)
                .click(optionAllAgencies)
                .select(selectCriteriaOfDiscount, supplierChoice)
                .click(searchIcon)
                .click(allOptionsOfAllSuppliers)
                .click(addBttnOfAllSuppliers)
                .click(saveBttn)
                .select(fareType, faretype)
                .select(amountList, Amount)
                .type(amount, value)
                .click(sendForApprovalBttn);
    }
    // Add new Markup Without a Markup Name
    public void addMarkupWithNoMarkupName(String producttype, String markupdescription, String country,
                                          String supplierChoice, String faretype, String Amount, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(markupDescription, markupdescription)
                .type(validFrom, today.format(myFormatObj))
                .type(validTo, tomorrow.format(myFormatObj))
                .type(countryName, country);
        new ElementActions().keyPress(countryName, Keys.ARROW_DOWN).click(countryCheckBox);
        driver.element().click(branchIconImage)
                .click(optionAllBranches)
                .click(agencyIconImage)
                .click(optionAllAgencies)
                .select(selectCriteriaOfDiscount, supplierChoice)
                .click(searchIcon)
                .click(allOptionsOfAllSuppliers)
                .click(addBttnOfAllSuppliers)
                .click(saveBttn)
                .select(fareType, faretype)
                .select(amountList, Amount)
                .type(amount, value)
                .click(sendForApprovalBttn);
    }

    // Add new Markup Without Markup Description
    public void addMarkupWithNoMarkupDescription(String producttype, String markupname, String country,
                                                 String supplierChoice, String faretype, String Amount, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(markupName, markupname)
                .type(validFrom, today.format(myFormatObj))
                .type(validTo, tomorrow.format(myFormatObj))
                .type(countryName, country);
        new ElementActions().keyPress(countryName, Keys.ARROW_DOWN).click(countryCheckBox);
        driver.element().click(branchIconImage)
                .click(optionAllBranches)
                .click(agencyIconImage)
                .click(optionAllAgencies)
                .select(selectCriteriaOfDiscount, supplierChoice)
                .click(searchIcon)
                .click(allOptionsOfAllSuppliers)
                .click(addBttnOfAllSuppliers)
                .click(saveBttn)
                .select(fareType, faretype)
                .select(amountList, Amount)
                .type(amount, value)
                .click(sendForApprovalBttn);
    }

    // Add New Markup Without Validity Period
    public void addMarkupWithNoValidityPeriod(String producttype, String markupname, String markupdescription, String country,
                                              String supplierChoice, String faretype, String Amount, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(markupName, markupname)
                .type(markupDescription, markupdescription)
                .type(countryName, country);
        new ElementActions().keyPress(countryName, Keys.ARROW_DOWN).click(countryCheckBox);
        driver.element().click(branchIconImage)
                .click(optionAllBranches)
                .click(agencyIconImage)
                .click(optionAllAgencies)
                .select(selectCriteriaOfDiscount, supplierChoice)
                .click(searchIcon)
                .click(allOptionsOfAllSuppliers)
                .click(addBttnOfAllSuppliers)
                .click(saveBttn)
                .select(fareType, faretype)
                .select(amountList, Amount)
                .type(amount, value)
                .click(sendForApprovalBttn);
    }

    // Add New Markup Without Country and With Branch

    // Add New Markup Without Fare Type
    public void addMarkupWithNoFareType(String producttype, String markupname, String markupdescription, String country,
                                        String supplierChoice, String Amount, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(markupName, markupname)
                .type(markupDescription, markupdescription)
                .type(validFrom, today.format(myFormatObj))
                .type(validTo, tomorrow.format(myFormatObj))
                .type(countryName, country);
        new ElementActions().keyPress(countryName, Keys.ARROW_DOWN).click(countryCheckBox);
        driver.element().click(branchIconImage)
                .click(optionAllBranches)
                .click(agencyIconImage)
                .click(optionAllAgencies)
                .select(selectCriteriaOfDiscount, supplierChoice)
                .click(searchIcon)
                .click(allOptionsOfAllSuppliers)
                .click(addBttnOfAllSuppliers)
                .click(saveBttn)
                .select(amountList, Amount)
                .type(amount, value)
                .click(sendForApprovalBttn);
    }

    // Add new Markup Without % Or Amount
    public void addMarkupWithNoPresOrAmount (String producttype, String markupname, String markupdescription, String country, String supplierChoice, String faretype, String value) throws InterruptedException{
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(markupName, markupname)
                .type(markupDescription, markupdescription)
                .type(validFrom, today.format(myFormatObj))
                .type(validTo, tomorrow.format(myFormatObj))
                .type(countryName, country);
        new ElementActions().keyPress(countryName, Keys.ARROW_DOWN).click(countryCheckBox);
        driver.element().click(branchIconImage)
                .click(optionAllBranches)
                .click(agencyIconImage)
                .click(optionAllAgencies)
                .select(selectCriteriaOfDiscount, supplierChoice)
                .click(searchIcon)
                .click(allOptionsOfAllSuppliers)
                .click(addBttnOfAllSuppliers)
                .click(saveBttn)
                .select(fareType, faretype)
                .type(amount, value)
                .click(sendForApprovalBttn);
    }
    // Add new Markup Without Value
    public void addMarkupWithNoValue (String producttype, String markupname, String markupdescription, String country, String supplierChoice, String faretype, String Amount) throws InterruptedException{
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(markupName, markupname)
                .type(markupDescription, markupdescription)
                .type(validFrom, today.format(myFormatObj))
                .type(validTo, tomorrow.format(myFormatObj))
                .type(countryName, country);
        new ElementActions().keyPress(countryName, Keys.ARROW_DOWN).click(countryCheckBox);
        driver.element().click(branchIconImage)
                .click(optionAllBranches)
                .click(agencyIconImage)
                .click(optionAllAgencies)
                .select(selectCriteriaOfDiscount, supplierChoice)
                .click(searchIcon)
                .click(allOptionsOfAllSuppliers)
                .click(addBttnOfAllSuppliers)
                .click(saveBttn)
                .select(fareType, faretype)
                .select(amountList, Amount)
                .click(sendForApprovalBttn);
    }
}
