package TestcasesSS;

import TestPackage.BasePage.TCBase;
import com.shaft.validation.Validations;
import logintest.dashBoardTest;
import logintest.testLogin;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class dashBoardTestCase extends TCBase {
    testLogin LoginObject ;
    dashBoardTest dashObj ;



    @Test
    public void searchWithValidData() throws InterruptedException {
        LoginObject = new testLogin(driver);
        LoginObject.loginWithValidData();
        dashObj = new dashBoardTest(driver);
        dashObj.searchOnDashBoardPage( );

        Validations.verifyThat().element(By.xpath("//*[@id=\"activ_0_2\"]/a/p")).exists().perform();

    }



}
