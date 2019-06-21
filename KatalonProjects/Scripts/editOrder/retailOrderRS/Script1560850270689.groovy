import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor executor = (JavascriptExecutor)driver;
Actions actions = new Actions(driver);

WebUI.callTestCase(findTestCase('editOrder/rsLogin'), [('RSURL') : '', ('RSuser') : '', ('RSpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_shop'))

	WebUI.delay(10)
	
	//////////WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_first_item_to_buy'))
	
	
	
	
	WebElement firstItemToBuy = driver.findElement(By.xpath("(//div[@class='entry-content']/div[@class='item_photos']/div[@class='item_image_main'])[1]"));
	actions.moveToElement(firstItemToBuy).click().build().perform()
	
	//////////

	

	WebUI.delay(5)

	WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_add_item_to_bag'))

	WebUI.delay(5)

	WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_cart_svg'))

	WebUI.delay(5)
	WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_checkout'))

	WebUI.delay(5)

	WebUI.delay(10)
	WebUI.waitForElementClickable(findTestObject('ReplicatedSite/button_save_and_continue'), 60)
	driver = DriverFactory.getWebDriver()
	element = driver.findElement(By.xpath('(//button/span[contains(text(), \'Save and Continue\')])[1]'))
	executor.executeScript("arguments[0].click();", element);

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

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'))
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_add_new'))
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'))

driver = DriverFactory.getWebDriver()
element = driver.findElement(By.xpath('(//button[@type=\'submit\']/span[contains(text(), \'Save\')])[2]'))
actions = new Actions(driver)
actions.moveToElement(element).click().build().perform()

WebUI.delay(10)
WebUI.waitForElementClickable(findTestObject('ReplicatedSite/button_save_and_continue_2'), 60)
driver = DriverFactory.getWebDriver()
element = driver.findElement(By.xpath('(//button/span[contains(text(), \'Save and Continue\')])[2]'))
executor.executeScript("arguments[0].click();", element);

//WebUI.click(findTestObject('ReplicatedSite/button_save_and_continue_2'))
WebUI.delay(5)
WebUI.waitForElementClickable(findTestObject('Object Repository/ReplicatedSite/span_complete_order'), 30)
element = driver.findElement(By.xpath('//span[contains(text(), \'COMPLETE ORDER\')]'))
executor.executeScript("arguments[0].click();", element);

	WebUI.delay(5)

	
	
	

