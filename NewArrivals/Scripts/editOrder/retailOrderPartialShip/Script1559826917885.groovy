import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_cabi Home/a_Shows  Orders'))

WebUI.click(findTestObject('Page_cabi Home/a_retail_purchases'))

WebUI.delay(3)

//WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_guest_info'))
WebUI.click(findTestObject('Object Repository/Page_cabi Home/existingCustomer'))

///////////////////////
int contactNumber = 5

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
WebUI.setText(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), existingCust)

WebUI.delay(3)

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'))

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create Show - Set Hostess/a_select_customer'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), existingCust)

WebUI.setText(findTestObject('Object Repository/Page_cabi Retail Store/input_email'), email)

WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address1_address1'), address1)

//WebUI.click(findTestObject('Object Repository/Page_cabi Edit Customer Profile/li_Address2'))
WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address2_address2'), '')

WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_City_city'), city)

WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_select_a_state'))

WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_state_1'), state)

WebUI.delay(2)

WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_state'))

WebUI.setText(findTestObject('Page_cabi Edit Customer Profile/input_state_postalCode'), zip)

//WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_click_near_address_1'))
WebUI.delay(5)

WebUI.check(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))

WebUI.delay(5)

WebUI.check(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))

WebUI.delay(10)

WebUI.click(findTestObject('Page_cabi Retail Store/span_next_1'))

WebUI.delay(3)

/////////////////////////////////////////////////
WebUI.click(findTestObject('Object Repository/Page_cabi Retail Store/span_quick_entry'))

WebUI.delay(3)

List<WebElement> emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 
    5)

if (emptyCart.size() > 0) {
    WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'))

    println('cart not empty')

    WebUI.delay(5)
}

////////////////////////////////////////////add item 1
addOnStyle = findTestData('miscData').getValue('addOnStyle', 1)

addOnStyle2 = findTestData('miscData').getValue('addOnStyle', 2)

///////////////
WebUI.click(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), addOnStyle)

WebUI.delay(3)

String prod_message = WebUI.getText(findTestObject('Page_cabi Create Order/first_option'))

WebUI.click(findTestObject('Page_cabi Create Order/first_option'))

///////////////
WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/selectSize'))

WebUI.click(findTestObject('Page_cabi Order Items/span_Add to Cart'))

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

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/addToCart2'))

WebUI.delay(5)

//////////////////////////end adding items

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Continue to Shipping'))

WebUI.delay(3)

//////////////
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

assert orderSuccess == true

 WebUI.callTestCase(findTestCase('warehouseShipping'), [('orderId') : GlobalVariable.retailOrderID], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.closeBrowser()

