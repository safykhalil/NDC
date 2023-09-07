package Portal;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class DiscountActivated {
    public SHAFT.GUI.WebDriver driver;

    public DiscountActivated(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    By flashIconBttn = By.xpath("/html/body/div[1]/div/div[11]/div[2]/div/div[2]/div[5]/div[1]/div[2]/div/div[1]/a/img[2]");
    public By discountValue = By.xpath("//*[@id=\"one-way\"]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div[1]/p[4]");
    public void MakeSureDiscountIsActivated(){
        driver.element().isElementDisplayed(flashIconBttn);
        driver.element().click(flashIconBttn);



    }
}
