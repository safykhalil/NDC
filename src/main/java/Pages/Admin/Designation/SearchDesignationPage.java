package Pages.Admin.Designation;

import org.openqa.selenium.By;

public class SearchDesignationPage {
    By designationPage = By.xpath("//*[@id=\"designationMenu\"]");
    By desgNameInput = By.id("degId");
    By dashBoardInput = By.id("dashbord-button");
    By inActiveStatusSelect = By.xpath("//*[@id=\"searchDesignationForm\"]/div/div[3]/div[3]/div/ul/li[1]/label/label");
    By activeStatusSelect = By.xpath("//*[@id=\"searchDesignationForm\"]/div/div[3]/div[3]/div/ul/li[2]/label/label");
    By bothStatusSelect = By.xpath("//*[@id=\"searchDesignationForm\"]/div/div[3]/div[3]/div/ul/li[3]/label/label");
    By searchBtn = By.xpath("//*[@id=\"searchDesignationForm\"]/div/div[4]/input");
    By sendForAprBtn = By.xpath("//*[@id=\"designationForm\"]/div/div[3]/input[1]");

}
