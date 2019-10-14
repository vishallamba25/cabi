import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
WebUI.openBrowser('')

WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''],
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))

WebUI.click(findTestObject('Page_cabi Home/a_personal_purchases'))

WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/span_Continue to Order'))

addOnStyle = "2158"//findTestData('miscData').getValue('addOnStyle', 1)

WebUI.setText(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), addOnStyle)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), Keys.chord(
		Keys.ARROW_DOWN))
WebUI.delay(2)
WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), Keys.chord(
	Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), Keys.chord(
		Keys.ENTER))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/selectSize'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Add to Cart'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/a_checkout'))

WebUI.delay(3)

WebUI.click(findTestObject('Page_cabi Personal Store/nextButtonShipping'))

WebUI.delay(3)

WebUI.click(findTestObject('Page_cabi Personal Store/makeFirstPayment'))

WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/select_cash'))

WebUI.click(findTestObject('Page_cabi Personal Store/submitPayment'))

WebUI.click(findTestObject('Page_cabi Personal Store/submitOrderId'))

//String successMsg = ''
//
//boolean orderSuccess = false
//
//List<WebElement> successMsgs = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/p_success_msg'),
//	5)
//
//if (successMsgs.size() > 0) {
//	successMsg = WebUI.getText(findTestObject('Object Repository/Page_cabi Personal Store/p_success_msg'))
//
//	orderSuccess = true
//	
//}
//	
//	assert orderSuccess == true
