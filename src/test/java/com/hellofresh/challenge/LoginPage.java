package com.hellofresh.challenge;
/**
 * This class is designed to store the locators of "Login" page
 * @author Upendra
 */

public class LoginPage {
	//Name of page title
	//make all the fields final to escape reinitialization
	public final String PAGE_TITLE           = "Login";

	//class of elements
	public final String CLASS_LOGIN          = "login";
	public final String CLASS_ACCOUNT        = "account";
	public final String CLASS_INFO_ACCOUNT   = "info-account";
	public final String CLASS_LOGOUT         = "logout";

	//Id of elements
	public final String ID_EMAIL             = "email";
	public final String ID_PASSWORD          = "passwd";
	public final String ID_SUBMIT            = "SubmitLogin";

	//CSS Selectors
	public final String CSS_SELECTOR         = "h1";
}
