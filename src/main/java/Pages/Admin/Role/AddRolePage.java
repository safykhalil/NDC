package Pages.Admin.Role;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AddRolePage extends BasePage {
    public AddRolePage (SHAFT.GUI.WebDriver driver) {super(driver);}

    By rolePage = By.xpath("//*[@id=\"rolesMenu\"]");
    By openAddPage = By.id("add_click");
    By roleNameInptu = By.id("roleName");
    By closeDashboardGroup = By.xpath("//*[@id=\"accordionAB\"]/div[1]/div[1]/h4/a");
    By selectAllDashboard = By.xpath("//*[@id=\"collapseInner00\"]/div/div/label");
    By viewDashboard = By.xpath("//*[@id=\"collapseInner00\"]/div/table/tbody/tr/td[2]/label");
    By editDashboard = By.xpath("//*[@id=\"collapseInner00\"]/div/table/tbody/tr/td[3]/label");
    By openAdminGroup = By.xpath("//*[@id=\"accordionAB\"]/div[2]/div[1]/h4/a");
    By selectAllAdmin = By.xpath("//*[@id=\"collapseInner10\"]/div/div/label");
    By openBranch = By.xpath("//*[@id=\"accordionABC1\"]/div[2]/div[1]/h4/a");
    By selectAllBranch = By.xpath("//*[@id=\"collapseInner11\"]/div/div/label");
    By openAgency = By.xpath("//*[@id=\"accordionABC1\"]/div[3]/div[1]/h4/a");
    By selectAllAgency = By.xpath("//*[@id=\"collapseInner12\"]/div/div/label");
    By openStaff = By.xpath("//*[@id=\"accordionABC1\"]/div[4]/div[1]/h4/a");
    By selectAllStaff =By.xpath("//*[@id=\"collapseInner13\"]/div/div/label");
    By openMasterGroup = By.xpath("//*[@id=\"accordionAB\"]/div[3]/div[1]/h4/a");
    By selectAllFlight = By.xpath("//*[@id=\"collapseInner20\"]/div/div/label");
    By openSupplier = By.xpath("//*[@id=\"accordionABC2\"]/div[2]/div[1]/h4/a");
    By selectAllSupplier = By.xpath("//*[@id=\"collapseInner21\"]/div/div/label");
    By openMiscellaneous = By.xpath("//*[@id=\"accordionABC2\"]/div[3]/div[1]/h4/a");
    By selectAllMiscellaneous = By.xpath("//*[@id=\"collapseInner22\"]/div/div/label");
    By openPaymentGateWay = By.xpath("//*[@id=\"accordionABC2\"]/div[4]/div[1]/h4/a");
    By selectAllPaymentGateWay = By.xpath("//*[@id=\"collapseInner23\"]/div/div/label");

    By sendForAprBtn = By.xpath("//*[@id=\"addRolesForm\"]/div[5]/input");

}
