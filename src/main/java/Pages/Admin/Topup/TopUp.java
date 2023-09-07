package Pages.Admin.Topup;

import Pages.BasePage;
import com.shaft.cli.FileActions;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class TopUp extends BasePage {

    public TopUp(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By Admin = By.xpath("//*[@id=\"Admin\"]/a");
    By LeftCorner = By.id("accordion");
    By TopUp = By.id("advanceCreditLimit");
    By AddBttn = By.id("add_click");
    By Browse = By.id("chooseDoct");


    public void addTopUpWithValidData() {

        
        driver.element().click(Admin)
                .click(TopUp)
                .click(AddBttn)
                .typeFileLocationForUpload(By.id("chooseDoct"), FileActions.getInstance().getAbsolutePath(SHAFT.Properties.paths.testData(),"images.png"));

    }

}