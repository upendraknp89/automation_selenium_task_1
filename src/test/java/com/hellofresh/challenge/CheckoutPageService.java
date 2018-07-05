package com.hellofresh.challenge;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

**
 * This class contains some common methods to perform all validation actions on checkout page
 * @author Upendra
 */
 
 public class CheckoutPageService 
{
	/**
	* This method will validate all details in checkout page
	*/
	public void validateCheckoutDetails(String headingText,CheckoutPage checkoutPage){
		    assertEquals("ORDER CONFIRMATION"+"text not matching with "+heading.getText()+"actual text on "+checkoutPage.PAGE_TITLE+" page","ORDER CONFIRMATION", heading.getText());
			assertTrue("Condition not true for info account matching text on "+checkoutPage.PAGE_TITLE+" page",driver.findElement(By.xpath(checkoutPage.XPATH_STEPDONE)).isDisplayed());
			assertTrue("Condition not true for info account matching text on "+checkoutPage.PAGE_TITLE+" page",driver.findElement(By.xpath(checkoutPage.XPATH_STEP_END)).isDisplayed());
			assertTrue("Condition not true for info account matching text on "+checkoutPage.PAGE_TITLE+" page",driver.findElement(By.xpath(checkoutPage.XPATH_CHECKINDENT)).getText().contains("Your order on My Store is complete."));
			assertTrue("Condition not true for info account matching text on "+checkoutPage.PAGE_TITLE+" page",driver.getCurrentUrl().contains("controller=order-confirmation"));
	}
}