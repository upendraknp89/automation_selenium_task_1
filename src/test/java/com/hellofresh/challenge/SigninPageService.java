package com.hellofresh.challenge;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

**
 * This class contains some common methods to perform all validation actions on signin page
 * @author Upendra
 */
 
 public class SigninPageService 
{
	/**
	* This method will validate all details in signin page
	*/
	public void validateSignDetails(String headingText,String name,String surname,SignInPage signinPage, WebElement heading){
		    assertEquals(heading.getText()+"actual value not matching with "+headingText+" expected value on "+signinPage.PAGE_TITLE+" page",heading.getText(),headingText);
			assertEquals(driver.findElement(By.className(signinPage.CLASS_ACCOUNT)).getText()+"actual value not matching with "+name + " " + surname+" expected value on "+signinPage.PAGE_TITLE+" page",driver.findElement(By.className(signinPage.CLASS_ACCOUNT)).getText(), name + " " + surname);
			assertTrue("Expected text not contain in info account on "+signinPage.PAGE_TITLE+" page",driver.findElement(By.className(signinPage.CLASS_INFO_ACCOUNT)).getText().contains("Welcome to your account."));
			assertTrue(driver.findElement(By.className(signinPage.CLASS_LOGOUT)).isDisplayed());
			assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
	}
}