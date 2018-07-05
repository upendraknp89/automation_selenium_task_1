package com.hellofresh.challenge;
/**
 * This class is designed to store the locators of "Checkout" page
 * @author Upendra
 */

public class CheckoutPage {

	//Name of page title
	//make all the fields final to escape reinitialization
	public final String PAGE_TITLE                 = "Checkout";	 

	//class of elements
	public final String CLASS_LOGIN                = "login";
	public final String CLASS_BANKWIRE             = "bankwire";

	//Id of elements
	public final String ID_EMAIL                   = "email";
	public final String ID_PASSWORD                = "passwd";
	public final String ID_SUBMIT                  = "SubmitLogin";
	public final String ID_UNIFORM_CGV             = "uniform-cgv";

	//Linktext of elements
	public final String LINKTEXT_WOMEN             = "Women";

	//Xpaths of elements
	public final String XPATH_FADDED_TSHIRT        = "//a[@title='Faded Short Sleeve T-shirts']/ancestor::li";
	public final String XPATH_PROCEED_CHECKOUT     = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']";
	public final String XPATH_CART_CHECKOUT        = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']";
	public final String XPATH_CART_NAVIGATION      = "//*[@id='cart_navigation']/button";
	public final String XPATH_STEPDONE             = "//li[@class='step_done step_done_last four']";
	public final String XPATH_STEP_END             = "//li[@id='step_end' and @class='step_current last']";
	public final String XPATH_CHECKINDENT          = "//*[@class='cheque-indent']/strong";

	//Names of the elements
	public final String NAME_SUBMIT                ="Submit";
	public final String NAME_PROCESS_ADDRESS       = "processAddress";
	public final String NAME_PROCESS_CARRIER       = "processCarrier";

	//CSS Selectors
	public final String CSS_SELECTOR               = "h1";
}