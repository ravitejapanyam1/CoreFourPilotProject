package repositories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccInfoRepo {

	@FindBy(xpath = "//input[@formcontrolname='principal']")
	public static WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public static WebElement password;

	@FindBy(css = "button.btn.d-flex")
	public static WebElement Loginbtn;

	@FindBy(xpath = "//div[text()='Banking']")
	public static WebElement banking;

	@FindBy(xpath = "//div[text()='Member account']")
	public static WebElement mem_acc;

	@FindBy(xpath = "//div[@class='row no-gutters']/div[4]")
	public static WebElement balanceinfo;

	@FindBy(id = "notifications-link")
	public static WebElement notification;

	@FindBy(css = "div.title-text.flex-grow-1")
	public static WebElement payhistory;

	@FindBy(className = "//button[contains(@class,'back-button btn')]")
	public static WebElement paymentprint1;

	@FindBy(css = "button.btn.btn-icon")
	public static WebElement selectUserlist;

	@FindBy(xpath = "//div[text()='Payment to user']")
	public static WebElement PaymentToUser;

	@FindBy(linkText = "Show filters")
	public static WebElement filterbutton;

	@FindBy(xpath = "//button[contains(@class,'btn btn-icon')]")
	public static WebElement Userlist;

	@FindBy(xpath = "(//div[@class='mb-2']//a)[2]")
	public static WebElement selectuser;

	@FindBy(css = "input[type='tel']")
	public static WebElement amt;

	@FindBy(css = "button[title='Last 12 months']")
	public static WebElement rangemenu;

	@FindBy(xpath = "//a[contains(text(),'Last month')]")
	public static WebElement SelectInrange;

	@FindBy(css = "textarea.form-control.ng-pristine")
	public static WebElement description1;

	@FindBy(xpath = "(//input[contains(@class,'form-control w-100')])[1]")
	public static WebElement description2;

	@FindBy(xpath = "//button[contains(@class,'btn d-flex')]")
	public static WebElement Nextbtn;

	@FindBy(xpath = "//span[text()='Confirm']")
	public static WebElement Confirmbtn;

	@FindBy(xpath = "(//div[@class='input-group']//input)[1]")
	public static WebElement from_amt;

	@FindBy(xpath = "(//div[@class='input-group']//input)[2]")
	public static WebElement to_amt;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	public static WebElement member_acc_filter;

	@FindBy(css = "button[title='No options selected']")
	public static WebElement memfilter;

	@FindBy(xpath = "//label[text()=' Member payments ']")
	public static WebElement MemberPayments;

	@FindBy(css = "button[title='Not applied']")
	public static WebElement direction;

	@FindBy(xpath = "//a[contains(text(),'Outgoing')]")
	public static WebElement OutDirection;

	@FindBy(xpath = "//*[@id='id_6']")
	public static WebElement transactionNumber;

	@FindBy(css = "button[title='Date (newest first)']")
	public static WebElement orderby;

	@FindBy(xpath = "//a[contains(text(),'Amount (highest first)')]")
	public static WebElement selectOrderby;

	@FindBy(xpath = "//table[contains(@class,'table table-hover')]")
	public static WebElement AccSummery;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	public static WebElement printbtn;

	@FindBy(xpath = "//div[@class='notification-icon']/following-sibling::div[1]")
	public static WebElement popup;

}
