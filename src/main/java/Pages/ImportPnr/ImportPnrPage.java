package Pages.ImportPnr;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ImportPnrPage extends BasePage {
    public ImportPnrPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

        By enterPnr = By.id("spPNR");
        By selectSupplier = By.id("select-supp");
        By selectBranch = By.id("branchListId");
        By selectAgency = By.id("agencyListId");
        By  selectAgent = By.id("selectagenId");
        By submitButton = By.cssSelector("#importPnrSearchForm > div.search-block > div.row.ng-scope > input");
        By selectPcc = By.xpath("//*[@id=\"select-pcc-button\"]");

        By flightCheckBox = By.cssSelector("tr > th.ng-scope > input");
        By selectButton = By.className("select-btn");

        By payButton = By.className("select-btn");

        By walletPay = By.cssSelector(" div.paymentButton.payBut > input");




        public void enterThePnr(String pnr){
            driver.element().click(enterPnr);
            driver.element().type(enterPnr,pnr);
        }

        public void selectTheSupplier(String SupplierName){
            driver.element().select(selectSupplier, SupplierName);
        }

        public void selectTheBranch(String BranchName){
            driver.element().select(selectBranch,BranchName);
        }

        public void  selectTheAgency(String AgencyName){
            driver.element().select(selectAgency,AgencyName);
        }

        public void selectTheAgent(String AgentName){
            driver.element().select(selectAgent, AgentName);
        }

        public void selectThePcc(String Pcc){

            driver.element().click(selectPcc);

            switch (Pcc) {
                case "GalileoLive" -> driver.element().click(By.cssSelector("#ui-id-1"));
                case "Galileo Live UAE" -> driver.element().click(By.cssSelector("#ui-id-2"));
                case "Live Egypt PCC" -> driver.element().click(By.cssSelector("#ui-id-3"));
                default -> driver.element().click(By.cssSelector("#ui-id-4"));
            }

        }

        public void clickSubmit(){
            driver.element().click(submitButton);
        }


        public void selectTheFlight(){
            driver.element().click(flightCheckBox)
                    .click(selectButton);
        }

        public void payTheTicket1(){
            driver.element().click(payButton);
        }

        public void payTheTicket2(){
            driver.element().click(walletPay);
        }




    }

