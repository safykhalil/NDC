package Pages.RuleEngine.AddRuleEngine;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

public class AddTermsAndConditionsPage extends BasePage {
    public AddTermsAndConditionsPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By addButton = By.id("add_click");
    By product = By.id("productId");
    By suuplierId = By.id("supplierId");
    By countryDropDown = By.id("country-dropdown");
    By countryCheckBox = By.xpath("/html/body/div/section/div/div[2]/div/div/form/div/div[3]/div[1]/div[1]/div[2]/div[2]/ul/li");
    By branchDropDown = By.id("branch-dropdown");
    By branchCheckBox = By.xpath("/html/body/div/section/div/div[2]/div/div/form/div/div[3]/div[2]/div[1]/div[2]/div[2]/ul/li");
    By reviewPage = By.xpath("/html/body/div/section/div/div[2]/div/div/form/div/div[4]/ul/li[3]/label");
    By txtArea = By.xpath("/html/body");
    By sendForApproval = By.xpath("/html/body/div/section/div/div[2]/div/div/form/div/div[6]/div/input");
    By active = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form[1]/div[1]/div[3]/div/div/ul/li[2]/label");
    By inactive = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form[1]/div[1]/div[3]/div/div/ul/li[1]/label");
    By search = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form[1]/div[1]/div[4]/input");
    By approveIcon = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form[1]/div[2]/div/table/tbody/tr[1]/td[4]/a[2]/img");
    By remarks = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form[1]/div[2]/div/table/tbody/tr[1]/td[4]/div/div/div/div[2]/textarea");
    By approveButton = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form[1]/div[2]/div/table/tbody/tr[1]/td[4]/div/div/div/div[3]/button[1]");
    By editIcon = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form[1]/div[2]/div/table/tbody/tr[1]/td[4]/a[1]/img");
    By cancelButton = By.xpath("//*[@id=\"ruleTermConditionEdit\"]/div/div[8]/a");
    By deactivateButton = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form[1]/div[2]/div/table/tbody/tr[1]/td[4]/span[2]");
    public String currentUrl = driver.getDriver().getCurrentUrl();
    public String decription = "test3";
    public String txt;

    //    String chargeName,String supplierName,String airline,String countryFrom,String countryTo
    public void addTermsAndConditionsWithValidData() throws InterruptedException {

        driver.element().click(addButton)
                .select(product,"Flight")
                .select(suuplierId,"Galileo")
                .type(countryDropDown,"Egy")
                .click(countryCheckBox)
                .type(branchDropDown,"Test")
                .click(branchCheckBox)
                .click(reviewPage);
        WebElement iframe = driver.getDriver().findElement(By.xpath("/html/body/div/section/div/div[2]/div/div/form/div/div[5]/div/div[1]/div/div[2]/iframe"));
        driver.getDriver().switchTo().frame(iframe);
        driver.element().type(txtArea, "test3");
        Thread.sleep(3000);
        driver.getDriver().switchTo().parentFrame();
        driver.element().click(sendForApproval);
    }
    public void searchForInactiveTermsAndConditions() throws InterruptedException {

        driver.element().click(inactive)
                .click(search);
    }
    public void searchForActiveTermsAndConditions() throws InterruptedException {

        driver.element().click(active)
                .click(search);
    }
    public void approveTermsAndConditions() throws InterruptedException {

        driver.element().click(approveIcon);
        Thread.sleep(2000);
                driver.element().type(remarks,"approved")
                        .click(approveButton);
    }
    public void addTermsAndConditionsWithEmptyData() throws InterruptedException {
        driver.element().click(addButton);
        Thread.sleep(2000);
        driver.element().click(sendForApproval);
    }
    public void editTermsAndConditions(){
        driver.element().click(editIcon);
    }
    public void getTermsAndConditionsText() throws InterruptedException {
        Thread.sleep(2000);
        WebElement iframe = driver.getDriver().findElement(By.xpath("/html/body/div/section/div/div[2]/div/div/form/div/div[5]/div/div[1]/div/div[2]/iframe"));
        driver.getDriver().switchTo().frame(iframe);
        txt = driver.element().getText(txtArea);
        driver.getDriver().switchTo().parentFrame();
        driver.element().click(cancelButton);
//        return txt;
    }
    public void deactivateTermsAndConditions(){
        driver.element().click(deactivateButton);
    }

}
