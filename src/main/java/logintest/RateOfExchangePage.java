package logintest;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RateOfExchangePage extends BasePage {
    public RateOfExchangePage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By Miscellaneous = By.id("Miscellaneous");
    By rateButton = By.id("ROE");
    By fromCurrency = By.id("fromCurrency");
    By toCurrency = By.id("toCurrency");
    public By table =By.id("DataTables_Table_0");
    By fromDollar =By.xpath("//*[@id=\"fromCurrency\"]/option[11]");
    By fromPound=By.xpath("//*[@id=\"fromCurrency\"]/option[2]");
    By toPound=By.xpath("//*[@id=\"toCurrency\"]/option[2]");
    By toDollar =By.xpath("//*[@id=\"toCurrency\"]/option[11]");
   public By addSuccessText =By.xpath("//*[@id=\"statusMsg\"]/font");

    By addRateOfExchange=By.id("rateOfExchange");
    By add = By.id("add_click");
    By senForApproval = By.xpath("//*[@id=\"addExchangeRateForm\"]/div/div[3]/input[1]");
    public By rateInTable = By.xpath("//*[@id=\"tr_\"]/td[5]");
    By searchButton = By.xpath("//*[@id=\"searchRateExchangeForm\"]/div/div[2]/div[2]/input");
    public boolean identicalData;
    List<WebElement> rows;
    By tableRows = By.tagName("tr");
    By byTableData = By.tagName("td");




    //Search Rate of Exchange
    public void searchWithAllCurrencies(){
        driver.element().click(Miscellaneous)
                .click(rateButton)
                .click(searchButton);
    }
    public void searchFromDollarToPound(){
    driver.element().click(Miscellaneous)
            .click(rateButton)
            .select(fromCurrency,"United States Dollar (USD)")
            .select(toCurrency,"Egyptian Pound (EGP)")
            .click(searchButton);
}
     public void addExchangeRate() throws InterruptedException {
         driver.element().click(Miscellaneous)
                 .click(rateButton)
                 .click(add)
                 .select(fromCurrency,"United States Dollar (USD)")
                 .select(toCurrency,"Euro (EUR)")
                 .type(addRateOfExchange,"40")
                 .click(senForApproval);
         Thread.sleep(3000);
}
   public void searchWithFromEGP(){
    driver.element().click(Miscellaneous)
            .click(rateButton)
            .select(fromCurrency,"Egyptian Pound (EGP)")
            .click(searchButton);
       checkDataInTable(2, "Egyptian Pound(EGP)");

}
    private void checkDataInTable (int colNumber, String data) {
        identicalData = true;
        rows = driver.getDriver().findElements(tableRows);
        int index = 1;
        while (!rows.isEmpty() && index < rows.size() && identicalData) {
            WebElement row = rows.get(index);
            List<WebElement> cols = row.findElements(byTableData);
            if (cols.get(colNumber).getText().toLowerCase().equals(data.toLowerCase())) {
                identicalData = true;
            } else {
                identicalData = false;
            }
            index++;
        }
    }


}
