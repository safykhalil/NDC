package Pages.Admin.Staff;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchStaff extends BasePage {

    public SearchStaff(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By Admin = By.xpath("//*[@id=\"Admin\"]/a");
    By LeftCorner = By.id("accordion");
    By Staff = By.xpath("//*[@id=\"accordion\"]/div[4]/a/div");
    By staffElementTxt = By.id("firstName");
    By branchName = By.id("branch");
    By searchBttn = By.id("searchButton");
    public By ResultsTable = By.id("air_tb");

    public void searchAboutStaffWithValidData() {
        driver.element().click(Admin);
        driver.element().click(Staff);
        driver.element().select(branchName, "Test");
        driver.element().click(searchBttn);

    }


}