package Pages.Admin.Department;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchDepartmentPage extends BasePage {
    public SearchDepartmentPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By depPage = By.id("departmentMenu");
    By depSearchInput = By.id("dpt");
    By inactiveStatusSelect = By.xpath("//*[@id=\"searchDepartmentForm\"]/div/div[3]/div[2]/div/ul/li[1]/label");
    By activeStatusSelect = By.xpath("//*[@id=\"searchDepartmentForm\"]/div/div[3]/div[2]/div/ul/li[2]/label");
    By bothStatusSelect = By.xpath("//*[@id=\"searchDepartmentForm\"]/div/div[3]/div[2]/div/ul/li[3]/label");
    By searchBtn = By.xpath("//*[@id=\"searchDepartmentForm\"]/div/div[4]/input");

    public void searchWithValidCredentials(){
        driver.element().click(depPage)
                .type(depSearchInput, "")
                .click(activeStatusSelect).click(searchBtn);
    }
}
