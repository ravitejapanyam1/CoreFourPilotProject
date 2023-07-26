package com.Cyclos_Core_Four_StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import io.github.bonigarcia.wdm.WebDriverManager;
import repositories.AccInfoRepo;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class AccInfoStepDefinition {
	public static WebDriver driver;
	File f = new File(
			"C:\\Users\\rpanyam\\eclipse-workspace\\AccountInformation\\src\\main\\resources\\ExcelData\\ExcelData.xlsx");

	@Before
	public void config() {	//this before method is
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("User login into Cyclos")
	public void user_login_into_cyclos() throws IOException {
		driver.get("https://demo.cyclos.org/ui/login");
		PageFactory.initElements(driver, AccInfoRepo.class);
		WebDriverWait wait = new WebDriverWait(driver, 15);

		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mysheet = wb.getSheet("Userdetails");
		Row row = mysheet.getRow(1);
		Cell a = row.getCell(0);
		Cell b = row.getCell(1);
		String user = a.getStringCellValue();
		int password = (int) b.getNumericCellValue();
		String pass = Integer.toString(password);

		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.username));
		AccInfoRepo.username.sendKeys(user);
		AccInfoRepo.password.sendKeys(pass);

//		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.username));
//		AccInfoRepo.username.sendKeys("demo");
//		AccInfoRepo.password.click();
//		AccInfoRepo.password.sendKeys("1234");

		AccInfoRepo.Loginbtn.click();

	}

	@Then("User should click on banking menu")
	public void user_should_click_on_banking_menu() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.banking));
		AccInfoRepo.banking.click();

	}

	// testcase1
	@Then("check the memberAccount")
	public void check_the_member_account() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.mem_acc));

		String Expected = "Member account";
		String Actual = AccInfoRepo.mem_acc.getText();

		//System.out.println(Actual);

		Assert.assertEquals(Actual, Expected);

	}

	// testcase2
	@Then("check member account balance")
	public void check_member_account_balance() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.balanceinfo));
		AccInfoRepo.balanceinfo.getText();

	}

	// testcase3
	@Then("click on notifications")
	public void click_on_notifications() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.notification));
		AccInfoRepo.notification.click();
	}

	@Then("able to see payment history")
	public void able_to_see_payment_history() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.payhistory));
		System.out.println(AccInfoRepo.payhistory.getText());

	}

	// 4th testcase
	@Then("should click payment to users")
	public void should_click_payment_to_users() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.PaymentToUser));
		AccInfoRepo.PaymentToUser.click();

	}

	@Then("select one user from userlist and select a user")
	public void select_one_user_from_userlist_and_select_a_user() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.selectUserlist));
		AccInfoRepo.selectUserlist.click();
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.selectuser));
		AccInfoRepo.selectuser.click();

	}

	@Then("Enter amount")
	public void enter_amount() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.amt));
		AccInfoRepo.amt.sendKeys("20");

	}

	@Then("click anyOption from Scheduling")
	public void click_any_option_from_scheduling() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.description1));
		AccInfoRepo.description1.click();

		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.description1));
		AccInfoRepo.description1.sendKeys("rent");

	}

	@Then("click on Next button")
	public void click_on_next_button() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.Nextbtn));
		AccInfoRepo.Nextbtn.click();
	}

	@Then("click on confirm")
	public void click_on_confirm() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
//		boolean confirm_res=AccInfoRepo.Confirmbtn.isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.Confirmbtn));
		AccInfoRepo.Confirmbtn.click();
	}

	@Then("click on print to download")
	public void click_on_print_to_download() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.paymentprint1));

		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.popup));
		System.out.println(AccInfoRepo.popup.getText());

//		boolean print_res=AccInfoRepo.paymentprint1.isDisplayed();
//		System.out.println(print_res);
//		if(print_res==false) {
//		System.out.println(" You have exceeded the maximum of payments per day for the demo network ");
//
//		}else {
//			wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.paymentprint1));
//			AccInfoRepo.paymentprint1.click();
//		}

	}

	// 5th testcase
	@Then("click the showfilter button")
	public void click_the_showfilter_button() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.member_acc_filter));
		AccInfoRepo.member_acc_filter.click();

	}

	@Then("select a user from userlist")
	public void select_a_user_from_userlist() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.Userlist));
		AccInfoRepo.Userlist.click();

		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.selectuser));
		AccInfoRepo.selectuser.click();
	}

	@Then("click on period menu and select any opton")
	public void click_on_period_menu_and_select_any_opton() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.rangemenu));
		AccInfoRepo.rangemenu.click();
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.SelectInrange));
		AccInfoRepo.SelectInrange.click();
	}

	@Then("select description and enter content")
	public void select_description_and_enter_content() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.description2));
		AccInfoRepo.description2.click();

		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.description2));
		AccInfoRepo.description2.sendKeys("rent");

	}

	@Then("click on from amout and enter value")
	public void click_on_from_amout_and_enter_value() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.from_amt));
		AccInfoRepo.from_amt.sendKeys("1");
	}

	@Then("click on to amount and enter value")
	public void click_on_to_amount_and_enter_value() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.to_amt));
		AccInfoRepo.to_amt.sendKeys("1");
	}

	@Then("click on filter and select one option")
	public void click_on_filter_and_select_one_option() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.memfilter));
		AccInfoRepo.memfilter.click();

		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.MemberPayments));
		AccInfoRepo.MemberPayments.click();

	}

	@Then("click on transaction number and enter value")
	public void click_on_transaction_number_and_enter_value() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.transactionNumber));
		AccInfoRepo.transactionNumber.click();

		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.transactionNumber));
		AccInfoRepo.transactionNumber.sendKeys("DEM-931388-NMR");

	}

	@Then("click on direction and select one option")
	public void click_on_direction_and_select_one_option() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.direction));
		AccInfoRepo.direction.click();

		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.OutDirection));
		AccInfoRepo.OutDirection.click();

	}

	@Then("click on orderby and select one option")
	public void click_on_orderby_and_select_one_option() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.orderby));
		AccInfoRepo.orderby.click();

		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.selectOrderby));
		AccInfoRepo.selectOrderby.click();

	}

	// 6th testcase
	@When("click a user from Account summary")
	public void click_a_user_from_account_summary() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.AccSummery));
		AccInfoRepo.AccSummery.click();

	}

	@Then("payment details should be display")
	public void payment_details_should_be_display() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.printbtn));
		System.out.println(AccInfoRepo.printbtn.getText());

	}

	// 7th testcase
	@When("click any user from 	account summary")
	public void click_any_user_from_account_summary() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.AccSummery));
		AccInfoRepo.AccSummery.click();
	}

	@Then("print the transferDetails")
	public void print_the_transfer_details() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(AccInfoRepo.printbtn));
		AccInfoRepo.printbtn.click();
	ExtentCucumberAdapter.addTestStepLog(Status.PASS + "Account Information details "); 
	}

}