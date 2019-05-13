import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser('')

WebUI.callTestCase(findTestCase('backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_cabi Home/a_Shows  Orders'))

WebUI.click(findTestObject('retailOrder/Page_cabi Home/a_Retail Orders'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/retailOrder/Page_cabi Guest Information/existingCustomerOption'))

not_run: WebUI.setText(findTestObject('Object Repository/retailOrder/Page_cabi Guest Information/existingCustomer'), 'kelli')

WebUI.sendKeys(findTestObject('Page_cabi Order Items/input_Discount_stylelookup_0'), Keys.chord(Keys.DOWN))

not_run: WebUI.sendKeys(findTestObject('Page_cabi Order Items/input_Discount_stylelookup_0'), Keys.chord(Keys.DOWN))

not_run: WebUI.click(findTestObject('Page_cabi Personal Store/styleID'))

WebUI.sendKeys(findTestObject('Object Repository/retailOrder/Page_cabi Guest Information/existingCustomer'), Keys.chord(
        Keys.ENTER))

not_run: WebUI.click(findTestObject('Page_cabi Shipping/span_Next'))

not_run: WebUI.click(findTestObject('retailOrder/Page_cabi Order Items/span_Quick Entry'))

//not_run: List<WebElement> emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 
//    5)
//not_run: if (emptyCart.size() > 0) {
//    WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'))
//
//    WebUI.delay(5)
//}
not_run: WebUI.setText(findTestObject('Page_cabi Order Items/input_Discount_stylelookup_0'), '5447')

not_run: WebUI.delay(3)

not_run: WebUI.sendKeys(findTestObject('Page_cabi Order Items/input_Discount_stylelookup_0'), Keys.chord(Keys.DOWN))

not_run: WebUI.sendKeys(findTestObject('Page_cabi Order Items/input_Discount_stylelookup_0'), Keys.chord(Keys.DOWN))

not_run: WebUI.click(findTestObject('Page_cabi Personal Store/styleID'))

not_run: WebUI.sendKeys(findTestObject('Page_cabi Order Items/input_Discount_stylelookup_0'), Keys.chord(Keys.ENTER))

not_run: WebUI.delay(5)

not_run: WebUI.selectOptionByValue(findTestObject('Page_cabi Order Items/selectSize'), 'L', true)

not_run: WebUI.click(findTestObject('Page_cabi Order Items/span_Add to Cart'))

not_run: WebUI.delay(3)

not_run: WebUI.click(findTestObject('Page_cabi Order Items/span_Continue to Shipping'))

not_run: WebUI.click(findTestObject('Page_cabi Personal Store/nextButtonShipping'))

not_run: WebUI.click(findTestObject('Page_cabi Payment Options/a_Make First Payment'))

not_run: WebUI.delay(3)

not_run: WebUI.click(findTestObject('Page_cabi Payment Options/paymentByCash'))

not_run: WebUI.click(findTestObject('Page_cabi Payment Options/span_Review Order'))

not_run: WebUI.click(findTestObject('Page_cabi OrderReview/span_Submit Order'))

