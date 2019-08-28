import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.interactions.Actions as Actions

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject
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
/**********************************************************************88Delete************************************************************************/
WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_first_item_to_buy_from_vs'))

WebUI.delay(3)

////////////
noOfOptions = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_no_of_options_for_checkout'), 
    5)

for (int i = 1; i <= noOfOptions.size(); i++) {
    TestObject dropDown = UtilityMethods.createTestObject('div_drop_down', '(//div[@class=\'add-to-cart-form\']/div[@class=\'attribute ng-scope\']/div[@class=\'input-select ng-scope\']/select)[', 
        String.valueOf(i), ']')

    WebUI.click(dropDown)

    //WebUI.delay(3)
    TestObject selectLastOption = UtilityMethods.createTestObject('div_select_last_option', '(//div[@class=\'add-to-cart-form\']/div[@class=\'attribute ng-scope\']/div[@class=\'input-select ng-scope\']/select)[', 
        String.valueOf(i), ']/option[last()]')

    WebUI.click(selectLastOption)

    WebUI.delay(3)
}

WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_add_item_to_bag'))
WebUI.delay(3)

	
WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_cart_svg'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_checkout'))
WebUI.delay(10)

/**********************************************************************88Delete************************************************************************/
WebUI.delay(10)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_other_address'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_my_address_edit_order'))

WebUI.waitForElementClickable(findTestObject('ReplicatedSite/button_save_and_continue'), 60)

driver = DriverFactory.getWebDriver()

element = driver.findElement(By.xpath('(//button/span[contains(text(), \'Save and Continue\')])[1]'))

executor.executeScript('arguments[0].click();', element)

WebUI.delay(3)

/////////////////credit card
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_pay_with_credit'), 
        5))

//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_pay_with_credit'))
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/button_add_another_card'), 
        5))

//WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_add_another_card'))
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/select_credit_card_type'), 
        5))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/select_credit_card_type'))

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_first_name'), 
        5))

WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_first_name'), 'abcd')

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_last_name'), 
        5))

WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_last_name'), 'efgh')

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_card_number'), 
        5))

WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_card_number'), '4111111111111111')

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_month'), 
        5))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_month'))

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_year'), 
        5))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_year'))

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_billing_address'), 
        5))

//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_address'))
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'), 
        5))

//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'))
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_billing_location_add_new'), 
        5))

//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_add_new'))
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'), 
        5))

//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'))
driver = DriverFactory.getWebDriver()

element = driver.findElement(By.xpath('(//button[@type=\'submit\']/span[contains(text(), \'Save\')])[2]'))

actions = new Actions(driver)

actions.moveToElement(element).click().build().perform()

WebUI.delay(10)

WebUI.waitForElementClickable(findTestObject('ReplicatedSite/button_save_and_continue_2'), 60)

driver = DriverFactory.getWebDriver()

element = driver.findElement(By.xpath('(//button/span[contains(text(), \'Save and Continue\')])[2]'))

executor.executeScript('arguments[0].click();', element)

WebUI.delay(5)

WebUI.waitForElementClickable(findTestObject('Object Repository/ReplicatedSite/span_complete_order'), 30)

element = driver.findElement(By.xpath('//span[contains(text(), \'COMPLETE ORDER\')]'))

executor.executeScript('arguments[0].click();', element)

WebUI.delay(5)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/h1_thanks_msg'), 
        5))
WebUI.delay(3)

