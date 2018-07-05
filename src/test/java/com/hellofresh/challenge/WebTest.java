package com.hellofresh.challenge;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import com.hellofresh.challenge.BaseHelper;
import com.hellofresh.challenge.TestBase;
import com.hellofresh.challenge.SigninPage;
import com.hellofresh.challenge.LoginPage;
import com.hellofresh.challenge.CheckoutPage;

//Using inheritance of base class to use all base functions and objects
public class WebTest extends TestBase{
	//We can define all the driver initialization part in baseclass and using inheritance reuse the same
	/*WebDriver driver;
    WebDriverWait wait;*/ //will get from base class
	private SigninPage signinPage;
	private LoginPage loginPage;
	private CheckoutPage checkoutPage;
	private TakesScreenshot scrShot;
	private BaseHelper commonService;
	private SigninPageService signinPageService;
	private LoginPageService loginPageService;
	private CheckoutPageService checkoutPageService;
	WebElement heading;
	String timestamp;
	String email;
	String name;
	String surname;
	String password;
	String days;
	String months;
	String years;
	String company;
	String address1;
	String address2;
	String city;
	String state;
	String postalCode;
	String phone;
	String phone_mob;
	String alias;
	String headingText;
	String fullName;

	//This will be used to get the whole Excel Sheet Test Data
	private enum ColumnMapper {
		NAME(0),
		SURNAME(1),
		PASSWORD(2),
		DAYS(3),
		MONTHS(4),
		YEARS(5),
		COMPANY(6),
		ADDRESS1(7),
		ADDRESS2(8),
		CITY(9),
		STATE(10),
		POSTALCODE(11),
		PHONE(12),
		PHONE_MOB(13),
		ALIAS(14),
		HEADINGTEXT(15),
		FULLNAME(16);
		int index;
		private ColumnMapper(int index) {
			this.index = index;
		}
		public int getIndex() {
			return index;
		}
	}
	//Instead of hard code the static data we can read the data from external source so we can easily maintain the code like from property file
	/*String existingUserEmail = "hf_challenge_123456@hf12345.com";
    String existingUserPassword = "12345678";*/
	String existingUserEmail    = config.getProperty("existingUser.Email");
	String existingUserPassword = config.getProperty("existingUser.Password");

	@Before
	public void setUp() {
		System.setProperty(config.getProperty("chrome.driver"), config.getProperty("driver.path"));
		/*driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);//WebDriverWait constructor takes only 2 arguments driver object and time(by default in seconds)*/
		//instead of above two lines we can just call initialize method to initialize basic required setup and load the static data set
		initialize();
		commonService                  = new BaseHelper();
		Object [][] webTestData        = BaseHelper.getData(eventDriver, collectError, this.getClass().getSimpleName());
		driver.get(config.getProperty("base.url"));
		this.signinPage                = new SigninPage();
		this.loginPage                 = new LoginPage();
		this.checkoutPage              = new CheckoutPage();
		this.signinPageService         = new SigninPageService();
		this.loginPageService          = new LoginPageService();
		this.checkoutPageService       = new CheckoutPageService();
		this.timestamp                 = String.valueOf(new Date().getTime());
		this.email                     = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
		//Read this kind of dynamic or test case specific data from external source file TestData1.xlsx
		this.name                      = String.valueOf(webTestData[0][ColumnMapper.NAME.getIndex()]);
		this.surname                   = String.valueOf(webTestData[0][ColumnMapper.SURNAME.getIndex()]);
		this.password                  = String.valueOf(webTestData[0][ColumnMapper.SURNAME.getIndex()]);
		this.days                      = String.valueOf(webTestData[0][ColumnMapper.DAYS.getIndex()]);
		this.months                    = String.valueOf(webTestData[0][ColumnMapper.MONTHS.getIndex()]);
		this.years                     = String.valueOf(webTestData[0][ColumnMapper.YEARS.getIndex()]);
		this.company                   = String.valueOf(webTestData[0][ColumnMapper.COMPANY.getIndex()]);
		this.address1                  = String.valueOf(webTestData[0][ColumnMapper.ADDRESS1.getIndex()]);
		this.address2                  = String.valueOf(webTestData[0][ColumnMapper.ADDRESS2.getIndex()]);
		this.city                      = String.valueOf(webTestData[0][ColumnMapper.CITY.getIndex()]);
		this.state                     = String.valueOf(webTestData[0][ColumnMapper.STATE.getIndex()]);
		this.postalCode                = String.valueOf(webTestData[0][ColumnMapper.POSTALCODE.getIndex()]);
		this.phone                     = String.valueOf(webTestData[0][ColumnMapper.PHONE.getIndex()]);
		this.phone_mob                 = String.valueOf(webTestData[0][ColumnMapper.PHONE_MOB.getIndex()]);
		this.alias                     = String.valueOf(webTestData[0][ColumnMapper.ALIAS.getIndex()]);
		this.headingText               = String.valueOf(webTestData[0][ColumnMapper.HEADINGTEXT.getIndex()]);
		this.fullName                  = String.valueOf(webTestData[0][ColumnMapper.FULLNAME.getIndex()]);
		this.scrShot                   =((TakesScreenshot)driver);
	}

	@Test
	public void signInTest() {
		try{
			//We can remove this business logic into separate service file so the test file will more readable and maintainable format
			//instead of hard coding the locators in test file we can read from page classes as per page object model to maintain code easily
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(this.signinPage.CLASS_LOGIN))).click();
			//defining all the variable globally so we can utilize them through out the class and initialize before first test method will run
			/*String timestamp = String.valueOf(new Date().getTime());
            String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
            String name = "Firstname";
            String surname = "Lastname";*/
			//Reading all the locators from corresponding page class  as per Page object model
			driver.findElement(By.id(signinPage.ID_EMAIL_CREATE)).sendKeys(this.email);
			driver.findElement(By.id(signinPage.ID_SUBMIT_CREATE)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(signinPage.ID_GENDER))).click();
			driver.findElement(By.id(signinPage.ID_CUSTOMER_FIRSTNAME)).sendKeys(this.name);
			driver.findElement(By.id(signinPage.ID_CUSTOMER_LASTNAME)).sendKeys(this.surname);
			driver.findElement(By.id(signinPage.ID_PASSWORD)).sendKeys(this.password);
			commonService.selectDropDownById(signinPage.ID_DAYS).selectByValue(this.days);
			commonService.selectDropDownById(signinPage.ID_MONTHS).selectByValue(this.months);
			commonService.selectDropDownById(signinPage.ID_YEARS).selectByValue(this.years);
			driver.findElement(By.id(signinPage.ID_COMPANY)).sendKeys(this.company);
			driver.findElement(By.id(signinPage.ID_ADDRESS1)).sendKeys(this.address1);
			driver.findElement(By.id(signinPage.ID_ADDRESS2)).sendKeys(this.address2);
			driver.findElement(By.id(signinPage.ID_CITY)).sendKeys(this.city);
			commonService.selectDropDownById(signinPage.ID_STATE).selectByValue(this.state);
			driver.findElement(By.id(signinPage.ID_POSTALCODE)).sendKeys(this.postalCode);
			driver.findElement(By.id(signinPage.ID_CITY)).sendKeys(this.city);
			driver.findElement(By.id(signinPage.ID_PHONE)).sendKeys(this.phone);
			driver.findElement(By.id(signinPage.ID_PHONE_MOB)).sendKeys(this.phone_mob);
			driver.findElement(By.id(signinPage.ID_ALIAS)).sendKeys(this.alias);
			driver.findElement(By.id(signinPage.ID_SUBMIT)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signinPage.CSS_SELECTOR)));
			this.heading = driver.findElement(By.cssSelector(signinPage.CSS_SELECTOR))
			//Using overloaded assert method to give user friendly msg in case of failure occur
			//Now we can move signin validation part into separate service file of same kind
			signinPageService.validateSignDetails(this.headingText,name,surname,signinPage,heading);
		}catch (Exception e) 
		{
			fail("error in signInTest() for script : " + this.getClass().getSimpleName() + " : " + e.getMessage());//promoted by junit
			//code to take screen shot after failure or caught exception
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File(File.separator+"hellofresh"+File.separator+"challenge"+File.separator);
			FileUtils.copyFile(SrcFile, DestFile);
		}
	}

	@Test
	public void logInTest() {
		try{
			//Reading full name from excel file
			//String fullName = "Joe Black";
			//We can remove this business logic into separate service file so the test file will more readable and maintainable format
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(loginPage.CLASS_LOGIN))).click();
			driver.findElement(By.id(loginPage.ID_EMAIL)).sendKeys(this.existingUserEmail);
			driver.findElement(By.id(loginPage.ID_PASSWORD)).sendKeys(this.existingUserPassword);
			driver.findElement(By.id(loginPage.ID_SUBMIT)).click();
		    this.heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loginPage.CSS_SELECTOR)));
			//Using trim() function of java to remove white spaves
			//Now we can move login validation part into separate service file of same kind
			loginPageService.validateLoginDetails(this.headingText,this.fullName,this.logInTest,heading);
		}catch (Exception e) 
		{
			fail("error in signInTest() for script : " + this.getClass().getSimpleName() + " : " + e.getMessage());
			//code to take screen shot after failure or caught exception
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File(File.separator+"hellofresh"+File.separator+"challenge"+File.separator);
			FileUtils.copyFile(SrcFile, DestFile);
		}
	}

	@Test
	public void checkoutTest() {
		try{
			//We can remove this business logic into separate service file so the test file will more readable and maintainable format
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(checkoutPage.CLASS_LOGIN))).click();
			driver.findElement(By.id(checkoutPage.ID_EMAIL)).sendKeys(this.existingUserEmail);
			driver.findElement(By.id(checkoutPage.ID_PASSWORD)).sendKeys(this.existingUserPassword);
			driver.findElement(By.id(checkoutPage.ID_SUBMIT)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(checkoutPage.LINKTEXT_WOMEN))).click();
			driver.findElement(By.xpath(checkoutPage.XPATH_FADDED_TSHIRT)).click();
			//Commented unnecessary code
			//driver.findElement(By.xpath(checkoutPage.XPATH_FADDED_TSHIRT)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(checkoutPage.NAME_SUBMIT))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkoutPage.XPATH_PROCEED_CHECKOUT))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkoutPage.XPATH_CART_CHECKOUT))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(checkoutPage.NAME_PROCESS_ADDRESS))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(checkoutPage.ID_UNIFORM_CGV))).click();
			driver.findElement(By.name(checkoutPage.NAME_PROCESS_CARRIER)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(checkoutPage.CLASS_BANKWIRE))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkoutPage.XPATH_CART_NAVIGATION))).click();
			this.heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(checkoutPage.CSS_SELECTOR)));
			checkoutPageService.validateCheckoutDetails(this.heading,this.checkoutPage);
		}catch (Exception e) 
		{
			fail("error in signInTest() for script : " + this.getClass().getSimpleName() + " : " + e.getMessage());
			//code to take screen shot after failure or caught exception
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File(File.separator+"hellofresh"+File.separator+"challenge"+File.separator);
			FileUtils.copyFile(SrcFile, DestFile);
		}
	}
}