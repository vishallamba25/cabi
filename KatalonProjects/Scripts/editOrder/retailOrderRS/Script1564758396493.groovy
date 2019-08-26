import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions as Actions

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods

WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor executor = ((driver) as JavascriptExecutor)

Actions actions = new Actions(driver)
String RSTestEnvt= findTestData('envtData').getValue('RSTestEnvt', 1)

WebUI.delay(10)

WebUI.callTestCase(findTestCase('TestCaseUtilities/rsLogin'), [('RSURL') : '', ('RSuser') : '', ('RSpass') : ''], FailureHandling.STOP_ON_FAILURE)

String loginURL= UtilityMethods.concat("https://mirandakate.", RSTestEnvt, ".com/account/#!/checkout")

WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_shop'))
//////////WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_first_item_to_buy'))
List<WebElement> firstItem = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/div_first_item_to_buy'), 5)
	if (firstItem.size() > 0) {
		println('firstItem is present')
		WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_first_item_to_buy'))
	}
//	WebDriverWait wait2 = new WebDriverWait(driver, 10);
//	wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/h2/a/span[contains(text(), 'Flaunt Scarf')]")));
//WebUI.delay(10)
//	wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/h2/a/span[contains(text(), 'Delight Scarf')]")));
//WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_first_item_to_buy'))
//	WebElement firstItemToBuy = driver.findElement(By.xpath("(//div[@class='entry-content']/div[@class='item_photos']/div[@class='item_image_main'])[1]"));
//actions.moveToElement(firstItemToBuy).click().build().perform()
//	executor.executeScript("arguments[0].click();", firstItemToBuy);
WebUI.waitForElementClickable(findTestObject('Object Repository/ReplicatedSite/div_first_item_to_buy'), 30)
	WebElement firstItemToBuy = driver.findElement(By.xpath("(//div[@class='item_photos']/div[@class='product-info'])[1]"));
	//actions.moveToElement(firstItemToBuy).click().build().perform()
	executor.executeScript("arguments[0].click();", firstItemToBuy);
//WebUI.delay(5)
//
//List<WebElement> button_add_item_to_bag = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/button_add_item_to_bag'), 
//    5)
//
//if (button_add_item_to_bag.size() == 0) {
//    WebUI.refresh()
//}
//
//button_add_item_to_bag = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/button_add_item_to_bag'), 
//    5)
//
//if (button_add_item_to_bag.size() == 0) {
//    WebUI.refresh()
//}
//
//WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_add_item_to_bag'))
//
//WebUI.delay(5)
//
//WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_cart_svg'))
//
//WebUI.delay(5)
//
//WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_checkout'))
WebUI.delay(10)

WebUI.scrollToElement(findTestObject('Object Repository/ReplicatedSite/ScrollToNew'), 5)

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('arguments[0].click();', findTestObject('ReplicatedSite/button_save_and_continue'))


//WebUI.click(findTestObject('ReplicatedSite/button_save_and_continue'), 60)
//	driver = DriverFactory.getWebDriver()
//	element = driver.findElement(By.xpath('(//button/span[contains(text(), \'Save and Continue\')])[1]'))
//	executor.executeScript("arguments[0].click();", element);
//	
//	WebUI.waitForElementClickable(findTestObject('ReplicatedSite/button_save_and_continue'), 60)
//	//span[contains(text(), 'Save and Continue') and ancestor::button[@class='btn pull-right' and ancestor::div[@class='panel active']]]
//	driver = DriverFactory.getWebDriver()
//	
//	element = driver.findElement(By.xpath('(//button/span[contains(text(), \'Save and Continue\')])[1]'))
//	
//	executor.executeScript('arguments[0].click();', element)
WebUI.delay(5)

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

executor.executeScript('arguments[0].click();', element)

//WebUI.click(findTestObject('ReplicatedSite/button_save_and_continue_2'))
WebUI.delay(5)

WebUI.waitForElementClickable(findTestObject('Object Repository/ReplicatedSite/span_complete_order'), 30)

element = driver.findElement(By.xpath('//span[contains(text(), \'COMPLETE ORDER\')]'))

executor.executeScript('arguments[0].click();', element)

WebUI.delay(5)

