package Pages.Admin.Department;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AddDepartmentPage extends BasePage {
    public AddDepartmentPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By depPage = By.id("departmentMenu");
    By openAddPage = By.id("airport_add");
    By depNameInput = By.id("departmentId");
    By assignedQueueInput = By.id("departmentList");
    By sendForAprBtn = By.xpath("//*[@id=\"createDepartmentForm\"]/div/div[3]/input[1]");
    By canselBtn = By.xpath("//*[@id=\"createDepartmentForm\"]/div/div[3]/input[2]");

    // +ve //
    public void addDepartmentWithValidData() {
        driver.element().click(depPage).click(openAddPage)
                .type(depNameInput,"")
                .select(assignedQueueInput, "")
                .click(sendForAprBtn);
    }
    // -ve //
    public void searchWithInvalidName(){
        driver.element().click(depPage).click(openAddPage)
                .type(depNameInput,"")
                .select(assignedQueueInput, "")
                .click(sendForAprBtn);
    }

}
