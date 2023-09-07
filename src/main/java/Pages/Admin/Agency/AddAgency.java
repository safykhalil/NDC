package Pages.Admin.Agency;

import Pages.BasePage;
import com.shaft.cli.FileActions;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

import java.util.Random;


public class AddAgency<images> extends BasePage {
        public AddAgency(SHAFT.GUI.WebDriver driver) {
            super(driver);

        }

        By Admin = By.xpath("//*[@id=\"Admin\"]/a");
        By LeftCorner = By.id("accordion");
        By Agency = By.xpath("//*[@id=\"Agency\"]");
        By Agency2 = By.xpath("//*[@id=\"searchAgency\"]");
        By AddAgencyBttn = By.id("add_click");
        By Branch = By.id("groupId");
        By AgencyName = By.id("groupName");
        By State = By.id("state");
        By City = By.id("city");
        By IATAAgency = By.id("itata");
        By NoOption = By.xpath("//*[@id=\"addAgencyForm\"]/div[1]/div/div[5]/div[1]/div/ul/li[2]/label/label");
        By postOfficeBox = By.id("orgModal.zipcode");
        By Address1 = By.id("orgModal.address");
        By phoneNo = By.id("orgModal.phone");
        By ContactPerson = By.id("orgModal.organizationContactModel0.name");
        By Email = By.id("email");
        By OwnerPhoneNo = By.id("orgModal.organizationContactModel0.phone");
        By ChooseFile = By.id("uploadFileA");
        By UploadBttn = By.xpath("//*[@id=\"addAgencyForm\"]/div[4]/div[2]/div/input[2]");
        By Browse = By.id("uploadBtn_0");
        By ChooseDocument = By.name("orgModal.orgDocModel[0].docList");
        By UploadBttn1 = By.xpath("//*[@id=\"addAgencyForm\"]/div[3]/div[2]/div[1]/div/input[4]");
        By UploadBttnforDoc2 =  By.xpath("//*[@id=\"addAgencyForm\"]/div[3]/div[3]/div[1]/div/input[4]");
        By LogoUploadBttn = By.xpath("//*[@id=\"addAgencyForm\"]/div[4]/div[2]/div/input[2]");
        By Logo = By.xpath("//*[@id=\"uploadFileA\"]");
        By StartDate = By.id("uploadBtn_0_contractStartDate0");
        By SelectStartMonth = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
        By SelectStartDay = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[5]/a");
        By EndDate = By.id("uploadBtn_0_contractEndDate0");
        By SelectEndMonth = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
        By SelectEndDay = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[4]/a");
        By SelectEndYear = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");
        By UploadLogo = By.id("show_fareCodeA");
        By SalesName = By.id("sales_name");
        By Designation = By.name("orgModal.organizationContactModel[1].designation");
        By EmailID = By.id("sales_email");
        By PhoneNumber1 = By.id("sales_phone");
        By AccountNumber = By.id("orgModal.organizationAccountModel0.accNo");
        By AccountType = By.id("orgModal.organizationAccountModel0.accType");
        By BankName = By.id("orgModal.organizationAccountModel0.accEntityName");
        By InvoiceGeneration = By.id("invoiceGenFrequency");
        By CreditLimit = By.id("creditLimit");
        By TopUpLimit = By.id("topupLimit");
        By CreditTermsDays = By.id("creditTerms");
        By Cash = By.xpath("//*[@id=\"payment_option\"]/li[1]/label");
        By Flight = By.xpath("//*[@id=\"check_box\"]/li[1]/label/text()");
        By SendForApproval = By.id("createAgn");



        private static final String[] NAMES = {
                "Agency1", "Agency2", "Agency3", "Agency4", "Agency5", "Agency6", "Agency7", "Agency8", "Agency9", "Agency10"
        };
        private static final Random random = new Random();

        public static String generateRandomName() {
                String name = NAMES[random.nextInt(NAMES.length)];
                return name;
        }
        public void addAgencyWithValidData(){
                String randomName = generateRandomName();
                driver.element().click(Admin)
                    .click(Agency)
                    .click(Agency2)
                    .click(AddAgencyBttn)
                    .select(Branch, "Test")
                    .type(AgencyName, randomName)
                    .select(State, "Cairo")
                    .select(City, "Cairo")
                    .click(NoOption)
                    .type(postOfficeBox, "02202")
                    .type(Address1, "1 St, Maadi")
                    .type(phoneNo, "01096946424")
                    .type(ContactPerson, "Test")
                    .type(Email, "a.sayed@tildetech.ae")
                    .type(OwnerPhoneNo, "01096946424")
                    .typeFileLocationForUpload(By.xpath("//input[@type='file'][@id='uploadBtn_0']"), FileActions.getInstance().getAbsolutePath(SHAFT.Properties.paths.testData(), "pdf-test.pdf"))
                    .click(UploadBttn1)
                    .click(StartDate)
                    .click(SelectStartMonth)
                    .click(SelectStartDay)
                    .click(EndDate)
                    .select(SelectEndMonth, "Oct")
                    .select(SelectEndYear, "2026")
                    .click(SelectEndDay)
                    .typeFileLocationForUpload(By.id("uploadBtnA"), FileActions.getInstance().getAbsolutePath(SHAFT.Properties.paths.testData(), "images.png"))
                    .click(LogoUploadBttn)
                    .type(AccountNumber, "12345678")
                    .select(AccountType, "Saving")
                    .type(BankName, "HSBC")
                    .select(InvoiceGeneration, "Monthly")
                    .click(Cash)
                    .click(SendForApproval);



        }
        }


