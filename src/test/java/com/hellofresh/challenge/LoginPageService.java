package com.hellofresh.challenge;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

**
 * This class contains some common methods to perform all validation actions on login page
 * @author Upendra
 */
 
 public class LoginPageService 
{
	/**
	* This method will validate all details in login page
	*/
	public void validateLoginDetails(String headingText,StringfullName,LoginPage loginPage,WebElement heading){
		    assertEquals(headingText+"not matching with actual value "+heading.getText()+"on "+loginPage.PAGE_TITLE+" page",headingText, heading.getText());
			assertEquals(fullName+"not matching with actual value "+driver.findElement(By.className(loginPage.CLASS_ACCOUNT)).getText().trim()+"on "+loginPage.PAGE_TITLE+" page",fullName, driver.findElement(By.className(loginPage.CLASS_ACCOUNT)).getText());
			assertTrue("Condition not true for info account matching text on "+loginPage.PAGE_TITLE+" page",driver.findElement(By.className(loginPage.CLASS_INFO_ACCOUNT)).getText().contains("Welcome to your account."));
			assertTrue("Condition not true for logout matching text on "+loginPage.PAGE_TITLE+" page",driver.findElement(By.className(loginPage.CLASS_LOGOUT)).isDisplayed());
			assertTrue("Condition not true for current matching text on "+loginPage.PAGE_TITLE+" page",driver.getCurrentUrl().contains("controller=my-account"));
	}
}