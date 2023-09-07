package Pages.Reports;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import io.cucumber.java.sl.In;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.util.Date;

import static org.sikuli.script.Mouse.click;

public class PerformanceReportsPage extends BasePage {
    public PerformanceReportsPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By performanceReport = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/a[6]/div/div[1]/label");
    By branchName = By.id("branchListValue");
    By allCheckBox = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/div[1]/div/div/div/ul/li[1]/label/input");
    By branchNameSelect = By.id("branchIDChk0"); //To Select Mansoura Branch
    By yearInput = By.xpath("//*[@id=\"year\"]");
    By yearSelect = By.xpath("//*[@id=\"year\"]/option[4]");
    By searchBtn = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div/input");
    By firstEleInTable = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[2]/strong"); //to get first branch in table
  //  By secondEleInTable = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[2]/strong");
    Alert alert;
    public String alertText;
    public void searchWithValidData() throws InterruptedException {
        driver.element().click(performanceReport);
        Thread.sleep(1000);
               driver.element().click(allCheckBox)
                       .click(branchNameSelect)
                       .click(yearInput)
                       .click(yearSelect)
                       .click(searchBtn);
    }
    //Check Branch name in Results
    public boolean checkBranchNameResults(){
        String firstBranch = driver.element().getText(firstEleInTable);
        String branchMansoura = driver.element().getText(branchNameSelect);
        boolean mansouraBranchCheck = branchMansoura.equals(firstBranch);
        System.out.println(mansouraBranchCheck);
        return mansouraBranchCheck;
    }
    //search Without Selecting a Branch
    public void searchWithoutBranch() throws InterruptedException {

        driver.element().click(performanceReport)
                .click(branchName);
        Thread.sleep(1000);
                driver.element().click(allCheckBox)
                .click(yearInput)
                .click(yearSelect)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
    // Search Without Selecting a Year
    public void searchWithoutYear() throws InterruptedException {
        driver.element().click(performanceReport)
                .click(branchName);
        Thread.sleep(1000);
        driver.element().click(allCheckBox)
                .click(branchNameSelect)
                .click(yearInput)
                .click(searchBtn);
        alert = driver.getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
    }
}
