import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//WebUI.openBrowser('')



WebUI.callTestCase(findTestCase('editOrder/rsLogin'), [('RSURL') : '', ('RSuser') : '', ('RSpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_shop'))

	WebUI.delay(10)
	
	//////////WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_first_item_to_buy'))
	WebDriver driver = DriverFactory.getWebDriver()
	WebElement firstItemToBuy = driver.findElement(By.xpath("(//div[@class='entry-content']/div[@class='item_photos']/div[@class='item_image_main'])[1]"));
	Actions actions = new Actions(driver);
	actions.moveToElement(firstItemToBuy).click().build().perform();
	//////////

	

	WebUI.delay(5)

	WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_add_item_to_bag'))

	WebUI.delay(5)

	WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_cart_svg'))

	WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_checkout'))

	WebUI.delay(5)

	/*element = driver.findElement(By.xpath('(//button[@type=\'submit\']/span[contains(text(), \'Save\')])[1]'))
	actions = new Actions(driver)
	actions.moveToElement(element).click().build().perform()*/
	
	WebUI.click(findTestObject('ReplicatedSite/button_save_and_continue'))

	WebUI.delay(3)
	
	/////////////////credit card
	WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_pay_with_credit'))
	WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_add_another_card'))
	
		WebUI.click(findTestObject('Object Repository/ReplicatedSite/select_credit_card_type'))
	
		WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_first_name'), 'abcd')
	
		WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_last_name'), 'efgh')
	
		WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_card_number'), '4111111111111111')
	
		WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_month'))
	
		WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_year'))
	
		WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_address'))
		
		driver = DriverFactory.getWebDriver()
		element = driver.findElement(By.xpath('(//button[@type=\'submit\']/span[contains(text(), \'Save\')])[2]'))
		actions = new Actions(driver)
		actions.moveToElement(element).click().build().perform()
		
	/*
	List<WebElement> existingCreditCardSlected = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/div_select_existing_credit_card_selected'),5)
	List<WebElement> existingCreditCards = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/div_select_existing_credit_card'),5)
	if (existingCreditCardSlected.size() > 0) {
		existingCreditCardSlected.get(0).click()
		
	}
	else if (existingCreditCards.size() > 0) {
		existingCreditCards.get(0).click()
		
	}
	else{
		WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_add_another_card'))
	
		WebUI.click(findTestObject('Object Repository/ReplicatedSite/select_credit_card_type'))
	
		WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_first_name'), 'abcd')
	
		WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_last_name'), 'efgh')
	
		WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_card_number'), '4111111111111111')
	
		WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_month'))
	
		WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_year'))
	
		WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_address'))
		
		driver = DriverFactory.getWebDriver()
		element = driver.findElement(By.xpath('(//button[@type=\'submit\']/span[contains(text(), \'Save\')])[2]'))
		actions = new Actions(driver)
		actions.moveToElement(element).click().build().perform()
	}
	*/
	
	

	

	WebUI.delay(10)
	
	/*driver = DriverFactory.getWebDriver()
	element = driver.findElement(By.xpath('(//button/span[contains(text(), \'Save and Continue\')])[2]'))
	actions = new Actions(driver)
	actions.moveToElement(element).click().build().perform()*/

	WebUI.click(findTestObject('ReplicatedSite/button_save_and_continue_2'))

	WebUI.delay(10)

	/*element = driver.findElement(By.xpath('//span[contains(text(), \'COMPLETE ORDER\')]'))
	actions = new Actions(driver)
	actions.moveToElement(element).click().build().perform()*/
	
	WebUI.click(findTestObject('Object Repository/ReplicatedSite/span_complete_order'))

	WebUI.delay(5)

	
	
	

