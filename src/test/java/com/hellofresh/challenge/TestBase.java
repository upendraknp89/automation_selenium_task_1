package com.hellofresh.challenge;
/**
 * Automation test base class
 * @author upendra
 * This class will take care to initialize all the basic initialization,add-ons and browser profiling things
 */
public class TestBase 
{
	WebDriver driver;
	WebDriverWait wait;
	private final String CONFIG_PROPERTIES = File.separator+"hellofresh"+File.separator+"challenge"+File.separator+"config.properties";//Final so that no body can change the value
	protected  static Properties config;
	protected XlsReader datatable;

	//This method will dedicated to initialization of driver object and other setup related activities to the particular browser
	public void initialize(){
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		this.driver                  =  new ChromeDriver();
		this.wait                    =  new WebDriverWait(driver, 10);//WebDriverWait constructor takes only 2 arguments driver object and time(by default in seconds)
		this.config                  =  new Properties();
		FileInputStream fileInputStr = new FileInputStream(System.getProperty("user.dir") + CONFIG_PROPERTIES);
		config.load(fileInputStr);
	}

	/**
	 * This method will read the data from excel sheet of respective test case
	 * @param driver
	 * @param collectError
	 * @param testName
	 * @return - a object array will be returned with all data from excel sheet
	 */
	public static Object[][] getData(EventFiringWebDriver driver,
			ErrorCollector collectError,String testName) {

		try {

			this.datatable = new XlsReader(System.getProperty("user.dir")
					+File.separator+"hellofresh"+File.separator+"challenge"+File.separator+"TestData1.xlsx");

			int rows = datatable.getRowCount(testName);
			if (rows <= 0) {
				Object[][] testdata = null;
				return testdata;
			}
			rows = datatable.getRowCount(testName);
			int cols = datatable.getColumnCount(testName);
			Object data[][] = new Object[rows - 1][cols];

			for (int rowNum = 2; rowNum <= rows; rowNum++) {
				for (int colNum = 0; colNum < cols; colNum++) {
					data[rowNum - 2][colNum] = datatable.getCellData(testName,
							colNum, rowNum);
				}
			}
			return data;
		} catch (Exception e) {
			collectError.addError(e);
			//throw e;
		}
		return null;
	}
}