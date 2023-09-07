package logintest;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class KnowledgeCenterPage extends BasePage {
    public KnowledgeCenterPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By knowledgeCenter = By.id("searchKc");
    By dateFrom = By.id("searchFrmDate");
    By year = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");
    By month = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
    By day18 = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[1]/a");
    By day24Aug = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[5]/a");
    By day1Sep = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[6]/a");
    By dateTo = By.id("searchToDate");
    By yearTo = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");
    By monthTo = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
    By day18To = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[1]/a");
    By day31AugTo = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[5]/a");
    By day4SepTo = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[2]/a");
    By country = By.id("country-dropdown");
    By egypt = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[4]/form/div[2]/div[1]/div/div[2]/div[2]/ul/li[1]");
    By turkye = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[4]/form/div[2]/div[1]/div/div[2]/div[2]/ul/li[9]");
    By branch = By.id("branch-dropdown");
    By agency = By.id("agency-dropdown");
    By ErbilFh = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[4]/form/div[3]/div/div/div[2]/div[2]/ul/li[7719]/input");
    By city = By.id("city-dropdown");
    By dropDown = By.xpath("//*[@id=\"searchKcModel\"]/div[2]/div[1]/div/div[2]/div[2]");


    By search = By.xpath("//*[@id=\"searchKcModel\"]/div[5]/input");
    By countrySelect = By.xpath("//*[@id=\"searchKcModel\"]/div[2]/div[1]/div/div[1]/img");
    public By countryName = By.xpath("//*[@id=\"searchKcModel\"]/div[2]/div[1]/div/div[2]/div[1]/ul");
    By branchSelect = By.xpath("//*[@id=\"searchKcModel\"]/div[2]/div[2]/div/div[1]/img");
    By branchTest = By.xpath("//div[@data-result='branches']//li[@id='948']//input[@type='checkbox']");
    By wonderTurkey = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[4]/form/div[2]/div[2]/div/div[2]/div[2]/ul/li");
    By AgencySelect = By.xpath("//*[@id=\"searchKcModel\"]/div[3]/div/div/div[1]/img");
    By AgencyIstanbul = By.xpath("//div[@data-result='agencies']//li[@id='2166']//input[@type='checkbox']");
    By inactive = By.xpath("//*[@id=\"searchKcModel\"]/div[4]/div[2]/div/ul/li[1]/label/label");
    By active = By.xpath("//*[@id=\"searchKcModel\"]/div[4]/div[2]/div/ul/li[2]");
    By Both = By.xpath("//*[@id=\"searchKcModel\"]/div[4]/div[2]/div/ul/li[3]");
    public By notFound = By.id("noDataFound");
    public By table = By.id("DataTables_Table_0_wrapper");

    public By rejected = By.xpath("//*[@id=\"tr_809\"]/td[6]");
    By Miscellaneous = By.id("Miscellaneous");
    public By description = By.xpath("//*[@id=\"tr_811\"]/td[2]");

    public void searchWithInactiveData() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(knowledgeCenter);
        Thread.sleep(2000);
        driver.element().click(inactive)
                .click(dateFrom)
                .select(month, "Jun")
                .click(day18)
                .click(dateTo)
                .select(monthTo, "Jun")
                .click(day18To)
                .click(countrySelect);
        Thread.sleep(2000);
        driver.element().click(egypt);
        Thread.sleep(2000);

    }

    public void searchWithActiveData() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(knowledgeCenter);
        driver.element().click(active)
                .click(dateFrom)
                .click(day1Sep)
                .click(dateTo)
                .click(day4SepTo)
                .click(countrySelect);
        Thread.sleep(2000);
        driver.element().click(turkye)
                .click(branchSelect)
                .click(wonderTurkey)
                .click(agency)
                .click(AgencySelect)
                .click(AgencyIstanbul);
    }

    public void searchButton() {
        driver.element().click(search);
    }

    public void searchWithSpecificDate() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(knowledgeCenter);
        Thread.sleep(3000);
        driver.element().click(Both);
        Thread.sleep(1000);
        driver.element().click(dateFrom)
                .select(month, "Aug")
                .click(day24Aug)
                .click(dateTo)
                .select(monthTo, "Aug")
                .click(day31AugTo);
        Thread.sleep(2000);

    }

    public void searchWithoutEnterDate() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(knowledgeCenter);
        driver.element().click(Both);
    }

    public void searchWithBranch() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(knowledgeCenter);
        driver.element().click(Both);
        Thread.sleep(1000);
        driver.element().click(branchSelect)
                .click(branchTest);
    }

    public void searchWithAgency() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(knowledgeCenter);
        Thread.sleep(1000);
        driver.element().click(Both);
        Thread.sleep(1000);
        driver.element().click(AgencySelect);
        Thread.sleep(1000);
        driver.element().click(ErbilFh);
    }

    public void searchWithWrongStatus() throws InterruptedException {
        driver.element().click(Miscellaneous);
        Thread.sleep(1000);
        driver.element().click(knowledgeCenter);
        driver.element().click(active)
                .click(dateFrom)
                .click(day1Sep)
                .click(dateTo)
                .click(day4SepTo)
                .click(countrySelect);
        Thread.sleep(2000);
        driver.element().click(egypt);
        Thread.sleep(2000);
    }
}
