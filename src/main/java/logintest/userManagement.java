package logintest;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class userManagement extends BasePage {
    public userManagement(SHAFT.GUI.WebDriver driver) {
        super(driver);}
    By managementButton =By.xpath("//*[@id=\"UserManagement\"]/a");
    By selectAgency = By.id("agencyId");

    By fullName = By.id("firstName");
    By contactNo = By.id("mobileNo");
    By email = By.id("email");
    By agencyText = By.xpath("//*[@id=\"errorSelection\"]");
    By searchButton = By.xpath("//*[@id=\"searchAgentBtn\"]");
    By shamsTravel = By.xpath("//*[@id=\"agencyId\"]/option[2]/text()");
    By CorporateDetails =By.id("searchCorporateDetails");
   public By agentName = By.xpath("//*[@id=\"DataTables_Table_0\"]/thead/tr/th[1]");
   public By agentNameYin=By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[1]");
   public By selectAgencyText=By.xpath("//*[@id=\"errorSelection\"]");

    public void selectAgency(String AgencyName ){

        driver.element() .click(selectAgency);
        driver.element().select(selectAgency ,AgencyName);
    }
    public void selectFullName (String name){
        driver.element().click(fullName)
       .type(fullName ,name);
    }
    public void searchButton(){
        driver.element().click(searchButton);
    }

}
