package Pages.Admin.Role;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchRolePage extends BasePage {
    public SearchRolePage (SHAFT.GUI.WebDriver driver) {super(driver);}

    By rolePage = By.xpath("//*[@id=\"rolesMenu\"]");
    By roleNameInput = By.id("roleName");
    By inActiveStatusSelect = By.xpath("//*[@id=\"searchRoleForm\"]/div/div[5]/div[1]/div[2]/div/ul/li[1]/label/label");
    By activeStatusSelect = By.xpath("//*[@id=\"searchRoleForm\"]/div/div[5]/div[1]/div[2]/div/ul/li[2]/label/label");
    By bothStatusSelect = By.xpath("//*[@id=\"searchRoleForm\"]/div/div[5]/div[1]/div[2]/div/ul/li[3]/label/label");
    By searchBtn = By.xpath("//*[@id=\"searchButton\"]");
}
