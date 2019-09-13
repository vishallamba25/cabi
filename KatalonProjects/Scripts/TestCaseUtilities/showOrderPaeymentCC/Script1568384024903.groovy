import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor executor = ((driver) as JavascriptExecutor)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/select_payment_options_select'))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/select_payment_options_new_cc'))

WebUI.delay(3)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/select_payment_visa'),
		10))

WebUI.setText(findTestObject('Object Repository/Page_cabi Shipping/select_payment_fname'), 'abcd')

WebUI.setText(findTestObject('Object Repository/Page_cabi Shipping/select_payment_lname'), 'fghi')

WebUI.setText(findTestObject('Object Repository/Page_cabi Shipping/select_payment_card_number'), '4111111111111111')

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/select_payment_exp_date_month'))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/select_payment_exp_date_year'))

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/input_select_billing_add_same_as_mailing_add'),
		10))

WebUI.delay(3)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_save_shipping_info'),
		10))

WebUI.delay(2)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_review_order'),
		10))

WebUI.delay(2)
