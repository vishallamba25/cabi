import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.testng.asserts.SoftAssert

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')




WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_cabi Home/a_Shows  Orders'))

WebUI.click(findTestObject('Page_cabi Home/a_retail_purchases'))

WebUI.delay(3)

//WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_guest_info'))
WebUI.click(findTestObject('Object Repository/Page_cabi Home/existingCustomer'))

///////////////////////
int contactNumber = 3

String firstName = findTestData('contactData').getValue('firstName', contactNumber)

String lastName = findTestData('contactData').getValue('lastName', contactNumber)

String email = findTestData('contactData').getValue('email', contactNumber)

String address1 = findTestData('contactData').getValue('address1', contactNumber)

String city = findTestData('contactData').getValue('city', contactNumber)

String state = findTestData('contactData').getValue('state', contactNumber)

String zip = findTestData('contactData').getValue('zip', contactNumber)

String existingCustFName = firstName

String existingCustLName = lastName

String space = ' '

String existingCust = "$existingCustFName$space$existingCustLName"

///////////////////////
///////////////
WebUI.setText(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), existingCust)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), Keys.chord(
		Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), Keys.chord(
		Keys.ENTER))
////////////////
/*WebUI.setText(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), existingCust)

WebUI.delay(3)

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'))

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create Show - Set Hostess/a_select_customer'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), existingCust)*/

WebUI.setText(findTestObject('Object Repository/Page_cabi Retail Store/input_email'), email)

WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address1_address1'), address1)

//WebUI.click(findTestObject('Object Repository/Page_cabi Edit Customer Profile/li_Address2'))
WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address2_address2'), '')

WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_City_city'), city)

WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_select_a_state'))

WebUI.delay(1)

/*WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_state_1'), state)

WebUI.delay(2)

WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_state'))*/

WebUI.setText(findTestObject('Page_cabi Edit Customer Profile/input_state_postalCode'), zip)

//WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_click_near_address_1'))
WebUI.delay(5)

WebUI.check(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))

WebUI.delay(5)

WebUI.check(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))

WebUI.delay(5)
WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor executor = (JavascriptExecutor)driver;
WebElement nextButton = driver.findElement(By.xpath("//li/a/span[@id='returnToActionLabel']"));
executor.executeScript("arguments[0].click();", nextButton);

//WebUI.click(findTestObject('Page_cabi Retail Store/span_next_1'))

WebUI.delay(3)

/////////////////////////////////////////////////
WebUI.click(findTestObject('Object Repository/Page_cabi Retail Store/span_quick_entry'))

WebUI.delay(3)

List<WebElement> emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 5)
if (emptyCart.size() > 0) {
    WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'))
    println('cart not empty')
    WebUI.delay(5)
}

addOnStyle = "2158"//findTestData('miscData').getValue('addOnStyle', 1)

addOnStyle2 = "3709"//findTestData('miscData').getValue('addOnStyle', 2)

///////////////
WebUI.setText(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), addOnStyle)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), Keys.chord(
		Keys.ARROW_DOWN))
WebUI.delay(2)
WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), Keys.chord(
	Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), Keys.chord(
		Keys.ENTER))
////////////////
/*WebUI.click(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), addOnStyle)

WebUI.delay(3)

String prod_message = WebUI.getText(findTestObject('Page_cabi Create Order/first_option'))

WebUI.click(findTestObject('Page_cabi Create Order/first_option'))*/

///////////////
WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/selectSize'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Add to Cart'))

WebUI.delay(5)

/////////////////////////////////////////////////add item 2
WebUI.click(findTestObject('Object Repository/Page_cabi Create Order/inputStyleLookup1'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Create Order/inputStyleLookup1'), addOnStyle2)

WebUI.delay(3)

String prod_message2 = WebUI.getText(findTestObject('Page_cabi Create Order/first_option'))

WebUI.click(findTestObject('Page_cabi Create Order/first_option'))

///////////////
WebUI.delay(5)


WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/selectSize2'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/addToCart2'))

WebUI.delay(5)

/////////////////////////////////////////////////////////////
editScenarioNumber=1;
if (editScenarioNumber == 1) {
    //////////
    //////////
    /***************add gift card*******************/
    /***************add donation*******************/
} else if (editScenarioNumber == 2) {
    
} else if (editScenarioNumber == 3) {
    WebUI.click(findTestObject('Object Repository/Page_cabi Retail Store/span_gift_card'))

    WebUI.delay(5)

    WebUI.click(findTestObject('Page_cabi Order Items/select_gc_amount'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/select_delivery_method'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/input_gc_type'))

    int recContactNumber = 3

    String recFName = findTestData('contactData').getValue('firstName', recContactNumber)

    String recLName = findTestData('contactData').getValue('lastName', recContactNumber)

    String recEmail = findTestData('contactData').getValue('email', recContactNumber)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Order Items/input_gc_rec_fname'), recFName)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Order Items/input_gc_rec_lname'), recLName)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Order Items/input_gc_rec_email'), recEmail)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Order Items/input_gc_send_fname'), firstName)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Order Items/input_gc_send_lname'), lastName)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Order Items/input_gc_send_email'), email)

    WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/a_submit'))
} else if (editScenarioNumber == 4) {
    println('scen = 4')

    WebUI.click(findTestObject('Object Repository/Page_cabi Retail Store/span_donation'))

    WebUI.delay(5)

    WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/select_donation_amount'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_add_to_cart'))
} else if (editScenarioNumber == 5) {
} else {
    println('editScenarioNumber is should be from 1 to 5')

    assert false
}

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/a_checkout'))

WebUI.delay(3)

WebUI.click(findTestObject('Page_cabi Personal Store/nextButtonShipping'))

WebUI.delay(3)

WebUI.click(findTestObject('Page_cabi Personal Store/makeFirstPayment'))

WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/select_cash'))

WebUI.click(findTestObject('Page_cabi Personal Store/submitPayment'))

WebUI.click(findTestObject('Page_cabi Personal Store/submitOrderId'))

String successMsg = ''

boolean orderSuccess = false

List<WebElement> successMsgs = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/p_success_msg'), 
    5)

if (successMsgs.size() > 0) {
    successMsg = WebUI.getText(findTestObject('Object Repository/Page_cabi Personal Store/p_success_msg'))

    orderSuccess = true

    GlobalVariable.retailOrderID = WebUI.getText(findTestObject('Object Repository/Page_cabi Personal Store/p_order_id'))
}

SoftAssert sa = new SoftAssert()

sa.assertTrue(orderSuccess)


not_run: WebUI.closeBrowser()

