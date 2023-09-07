package Pages.Admin.Topup;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TopUpSearchPage extends BasePage {
    public TopUpSearchPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    /*
        By startDateEle = By.id("startDate");
        By endDateEle = By.id("endDate");
        By popupContent = By.cssSelector("#myModal_NDCEG-TOP-F342132.>.div");
        By shifting = By.xpath("//*[@id=\"formId\"]/div/div[7]");
        By successMsg = By.id("statusMsg");


     */


    By searchBttn = By.id("searchButton");
    By receiptTxt = By.id("bankRefNo");
    public By resultsTable = By.id("salesDataTable");
    By approveIcon = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[2]/form/div/div[7]/div[2]/table/tbody/tr/td[11]/a[1]");
    By approveBttn = By.xpath("//button[@type='button' and contains(text(), 'Approve')]");

    By paginagtion = By.xpath("//*[@id=\"salesDataTable_paginate\"]/span/a");


    public void searchAboutValidTopUp() {
        driver.element().click(searchBttn);

    }

    public void approveTopUpRequest() throws InterruptedException {
        driver.element().click(searchBttn)
                .keyPress(paginagtion, Keys.ARROW_RIGHT)
                .keyPress(paginagtion, Keys.ARROW_RIGHT)
                .keyPress(paginagtion, Keys.ARROW_RIGHT)
                .keyPress(paginagtion, Keys.ARROW_RIGHT)
                .click(approveIcon)
                .click(approveBttn);

    }

    public void searchAboutValidTopUpUsingReceiptNoAndApproveIt(String receipt) throws InterruptedException {
        driver.element().type(receiptTxt, receipt)
                .click(searchBttn)
                .keyPress(paginagtion, Keys.ARROW_RIGHT)
                .keyPress(paginagtion, Keys.ARROW_RIGHT)
                .keyPress(paginagtion, Keys.ARROW_RIGHT)
                .keyPress(paginagtion, Keys.ARROW_RIGHT)
                .click(approveIcon);
        Thread.sleep(1000);
        driver.element().click(approveBttn);

    }


}
