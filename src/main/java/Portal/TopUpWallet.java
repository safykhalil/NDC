package Portal;

import com.shaft.cli.FileActions;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TopUpWallet {

    public SHAFT.GUI.WebDriver driver;

    public TopUpWallet(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    By TopUpBttn = By.xpath("//*[@id=\"top-up\"]/input");
    By Amount = By.id("topup-amount");
    By RecieptNumber = By.id("recieptNumber");
    By UploadedFile = By.xpath("//*[@id=\"uploadBtn\"]");
    By SendForApproval = By.xpath("//*[@id=\"topupCashForm\"]/div[6]/div/input");
    By ConfirmationMSG = By.xpath("//*[@id=\"order-details\"]/div/table/tbody/tr[1]/td/h1");



    public void AddingTopUpWallet() {
        driver.element().click(TopUpBttn)
                .type(Amount, "5000")
                .type(RecieptNumber, "545456454")
                .typeFileLocationForUpload(By.xpath("//*[@id=\"chooseDoct\"]"), FileActions.getInstance().getAbsolutePath(SHAFT.Properties.paths.testData(), "pdf-test.pdf"))
                .click(SendForApproval);

    }

}
