package logintest;
//test

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class importPNRtest extends BasePage {
    public importPNRtest(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public WebElement pnrTxt = driver.getDriver().findElement(By.id("spPNR"));
    public By enterPnr = By.xpath("//*[@id=\"spPNR\"]");
    By selectSupplier = By.xpath("//*[@id=\"select-supp\"]");
    By selectBranch = By.xpath("//*[@id=\"branchListId\"]");

    public By GallioLive = By.xpath("//*[@id=\"select-pcc-button\"]/span[2]\n");

    By selectAgency = By.id("agencyListId");
    By selectAgent = By.id("selectagenId");
    By submitButton = By.xpath("//*[@id=\"importPnrSearchForm\"]/div[3]/div[2]/input");

    By messageREQ = By.xpath("//*[@id=\"importPnrSearchForm\"]/div[3]/div[1]/div[3]/div[1]/div");
    public String actualResult;
    public By actual = By.xpath("//*[@id=\"new-passenger-details-wrap\"]/div/div/div[5]/div");
    public String expectedResult = "INVALID RECORD LOCATOR";

    public void enterPnr(String pnr) {
        driver.element().click(enterPnr)
                .type(enterPnr, pnr);
    }

    public void selectSupplier(String SupplierName) {
        driver.element().select(selectSupplier, SupplierName);

    }

    public void selectBranch(String BranchName) {
        driver.element().select(selectBranch, BranchName);
    }

    public void selectAgency(String AgencyName) {
        driver.element().select(selectAgency, AgencyName);
    }

    public void selectAgent(String AgentName) {
        driver.element().select(selectAgent, AgentName);
    }

    public void submitButton() {
        driver.element().click(submitButton);
    }

    public void emptyPNR(String pnr) {
        driver.element().type(enterPnr, pnr);
    }
}