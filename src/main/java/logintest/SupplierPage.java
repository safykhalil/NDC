package logintest;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SupplierPage extends BasePage {
    public SupplierPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By supplierName = By.id("supplierName");
    By searchSupplier = By.id("searchSupplier");
    By products = By.id("ui-id-1-button");
    By inactive = By.xpath("//*[@id=\"searchSupplierForm\"]/div[3]/div[5]/div/div/ul/li[1]");
    By active = By.xpath("//*[@id=\"searchSupplierForm\"]/div[3]/div[5]/div/div/ul/li[2]/label");
    By both = By.xpath("//*[@id=\"searchSupplierForm\"]/div[3]/div[5]/div/div/ul/li[3]/label");
    By search = By.xpath("//*[@id=\"searchSupplierForm\"]/div[3]/div[6]/input");
    By supplierButton = By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]");
    By activeTable = By.xpath("(//span[@class='bg_active'])[1]");
    By inActiveTable = By.xpath("//*[@id=\"tr_126\"]/td[6]/span");
    By hotel = By.xpath("//*[@id=\"ui-id-4\"]");


    By flight = By.xpath("//*[@id=\"ui-id-3\"]");
    public By table = By.id("air_tb");
    public By notFound = By.id("noDataFound");

    public By supplierNameTable = By.xpath("//*[@id=\"tr_126\"]/td[2]");
    public By inactiveSupplierMasg = By.xpath("//*[@id=\"statusMsg\"]/font/center/font");

    public void searchWithAllSupplier() {

        driver.element().click(both)
                .click(products)
                .click(flight);

    }

    public void searchButton() {
        driver.element().click(search);
    }

    public void openSupplierPage() {
        driver.element().click(supplierButton)
                .click(searchSupplier);
    }

    public void SearchWithSpecificActiveSupplier() {
        driver.element().click(active)
                .click(products)
                .click(flight)
                .type(supplierName, "FlyEgypt");
    }

    public void searchWithSupplierNameAfterChangeStatusToInactive() throws InterruptedException {
        driver.element().click(active)
                .click(products)
                .click(flight)
                .type(supplierName, "FlyEgypt")
                .click(search)
                .click(activeTable);
                Thread.sleep(2000);
        driver.element()  .click(inactive);
    }

    public void ClickInactiveOption() {
        driver.element().click(inActiveTable);
    }

    public void searchWithSelectHotelFromProduct() {
        driver.element().click(both)
                .click(products)
                .click(hotel)
                .type(supplierName, "supplierName");
    }


}
