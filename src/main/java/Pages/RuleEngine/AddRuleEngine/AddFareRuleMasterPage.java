package Pages.RuleEngine.AddRuleEngine;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddFareRuleMasterPage extends BasePage {
    public AddFareRuleMasterPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By supplierNameInput = By.id("supplierID");
    By validFromInput = By.id("validFrom");
    By validToInput = By.id("validTo");
    By countryFromInput = By.id("country-dropdown");
    By countryToInput = By.id("agency-dropdown");
//    By airLineInput = By.id("Input");
    By chargeNameInput = By.id("chargeName");
//    By descriptionInput = By.xpath("html/body[@class = 'form-control wysihtml5-editor']");

//    By descriptionInput = By.className("wysihtml5-editor");
    By iframe = By.className("wysihtml5-sandbox");
    By sendForApproval = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div/div[6]/input");
    By fromDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[4]/a");
    By toDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a");
    By countryFromCheckbox = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div/div[3]/div[1]/div[1]/div[2]/div[2]/ul/li/input");
    By countryToCheckbox = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div/div[3]/div[2]/div[1]/div[2]/div[2]/ul/li/input");

    By airlineInput = By.id("airline-dropdown");
    By airLineCheckbox = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/input");

    By txtArea = By.xpath("/html/body");
    WebElement mainFrame = driver.getDriver().findElement(By.xpath("/html/body/div[1]"));
   public By statusMsg = By.id("statusMsg");
   public By errorStatusMsg = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[2]/span/font");
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void addFareRuleWithValidData(String chargeName,String supplierName,String airline,String countryFrom,String countryTo) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(2);
        driver.element().select(supplierNameInput, supplierName)
                .type(validFromInput,today.format(myFormatObj))
                .type(validToInput,tomorrow.format(myFormatObj))
                .type(airlineInput,airline)
                .click(airLineCheckbox)
                .type(countryFromInput,countryFrom);
        Thread.sleep(2000);
                driver.element().click(countryFromCheckbox)
                .type(countryToInput,countryTo);
        Thread.sleep(2000);
                driver.element().click(countryToCheckbox)
                .type(chargeNameInput, chargeName);
        WebElement iframe = driver.getDriver().findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div/div[5]/div[1]/div/div/div[2]/iframe"));

        driver.getDriver().switchTo().frame(iframe);
        driver.element().type(txtArea, "test");
//        Thread.sleep(1000);
        driver.getDriver().switchTo().parentFrame();
                driver.element().click(sendForApproval);
        Thread.sleep(3000);
    }

    public void addFareRuleWithEmptyFields(){
        driver.element().click(sendForApproval);
    }

}
