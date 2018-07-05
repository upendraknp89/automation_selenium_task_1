package com.hellofresh.challenge;

/**
 * common method which will be used by helper classes as well as Test classes
 * @author Upendra
 */
 
 /**
 *This method will return the select dropdown object on basis of locator type
 */
 public Select selectDropDownById(String id)
	{
		Select select = new Select(driver.findElement(By.id(signinPage.ID_DAYS)));
		return select;
	}