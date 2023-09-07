package Pages.RuleEngine.AddRuleEngine;


import Pages.BasePage;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class AddDiscountPage extends BasePage {

    public AddDiscountPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By productType = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[3]/div/select"); // select product type (Flight)
    By discountName = By.id("discountName"); //enter discount name
    By discountDescription = By.id("discountDesc"); // add description to discount
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
    By allOptionsOfAllSuppliers = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[7]/div/div/div[2]/div[3]/div[1]/div[2]/label[1]/input"); //click on it to select all suppliers
    By addBttnOfAllSuppliers = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[7]/div/div/div[2]/div[3]/div[2]/ul/li[1]/input"); // button click on it to add it
    By saveBttn = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[7]/div/div/div[3]/input"); // click on it save all suppliers
    By fareType = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[5]/div/div/div[2]/div[1]/select"); // select "Total Fare" from list
    By amountList = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[5]/div/div/div[2]/div[2]/select"); // select "Amount" from list
    By amount = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[5]/div/div/div[2]/div[3]/input"); // add value as amount of discount
    By sendForApprovalBttn = By.xpath("//*[@id=\"sendApprovel\"]"); // click on it to send discount request
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public By statusMssg = By.id("statusMsg");
    public void SendForApproval() {

        driver.element().click(sendForApprovalBttn);
    }
    public void addDiscountWithValidCriteria(String producttype, String discountname, String discountdescription, String country,
                                             String supplierChoice, String faretype, String Amount, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(discountName, discountname)
                .type(discountDescription, discountdescription)
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
                .type(amount, value);
    }
    // Add new Discount Without Product Type
    public void addDiscountWithNoProduct(String discountname, String discountdescription, String country,
                                         String supplierChoice, String faretype, String Amount, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().type(discountName, discountname)
                .type(discountDescription, discountdescription)
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
                .type(amount, value);
    }
    // Add new Discount Without Discount Name
    public void addDiscountWithNoDiscountName(String producttype, String discountdescription, String country, String supplierChoice, String faretype, String Amount, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(discountDescription, discountdescription)
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
                .type(amount, value);
    }
    // Add new Discount Without Discount Description
    public void addDiscountWithNoDiscountDescription(String producttype, String discountname, String country, String supplierChoice, String faretype, String Amount, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
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
                .type(amount, value);
    }
    // Add new discount Without Validity Period
    public void addDiscountWithNoValidityPeriod(String producttype, String discountname, String discountdescription, String country,
                                                String supplierChoice, String faretype, String Amount, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(discountDescription, discountdescription)
//                .type(validFrom, today.format(myFormatObj))
//                .type(validTo, tomorrow.format(myFormatObj))
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
                .type(amount, value);
    }
    // Add new discount Without Country With Branch
    public void addDiscountWithNoCountryWithBranch(String producttype, String discountname, String discountdescription, String supplierChoice, String faretype, String Amount, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(discountDescription, discountdescription)
                .type(validFrom, today.format(myFormatObj))
                .type(validTo, tomorrow.format(myFormatObj));
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
                .type(amount, value);
    }
    // Add new Discount With Country Without Branch
    public void addDiscountWithCountryWithNoBranch(String producttype, String discountname, String discountdescription, String country, String supplierChoice, String faretype, String Amount, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(discountDescription, discountdescription)
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
                .type(amount, value);
    }
    // Add new discount Without Fare Type
    public void addDiscountWithNoFareType(String producttype, String discountname, String discountdescription, String country, String supplierChoice, String Amount, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(discountDescription, discountdescription)
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
                .type(amount, value);
    }
    // Add New Discount Without Amount
    public void addDiscountWithNoAmount(String producttype, String discountname, String discountdescription, String country, String supplierChoice, String faretype, String value) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(discountDescription, discountdescription)
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
                .type(amount, value);
    }
    // Add New Discount Without Value
    public void addDiscountWithNoValue(String producttype, String discountname, String discountdescription, String country, String supplierChoice, String faretype, String Amount) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(discountDescription, discountdescription)
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
                .select(amountList, Amount);
    }
}