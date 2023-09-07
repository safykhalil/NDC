package TestcasesSS;
//test
import TestPackage.BasePage.TCBase;
import logintest.testLogin;
import org.testng.annotations.Test;

public class testCaseLogin extends TCBase {

testLogin loginObj;
    @Test
    public void loginWithValidData() throws InterruptedException {
        loginObj = new testLogin(driver);
        loginObj.loginWithValidData();
//        String url = driver.browser().getCurrentURL();
//        System.out.println(url);
    }

}
