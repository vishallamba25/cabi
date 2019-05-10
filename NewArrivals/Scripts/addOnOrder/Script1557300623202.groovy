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

WebUI.delay(3)

WebUI.click(findTestObject('Page_cabi Home/a_personal_purchases'))

WebUI.click(findTestObject('Page_cabi Personal Store/span_Continue to Order'))

WebUI.delay(5)

List<WebElement> emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 
    5)

if (emptyCart.size() > 0) {
    WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'))
    println('cart not empty')
    WebUI.delay(5)
}

addOnStyle = findTestData('miscData').getValue('addOnStyle', 1)

WebUI.setText(findTestObject('Object Repository/Page_cabi Order Items/input_Discount_stylelookup_0'), addOnStyle)

WebUI.delay(3)

WebUI.sendKeys(findTestObject('Page_cabi Order Items/input_Discount_stylelookup_0'), Keys.chord(Keys.DOWN))

WebUI.sendKeys(findTestObject('Page_cabi Order Items/input_Discount_stylelookup_0'), Keys.chord(Keys.DOWN))

not_run: WebUI.click(findTestObject('Page_cabi Personal Store/styleID'))

WebUI.sendKeys(findTestObject('Page_cabi Order Items/input_Discount_stylelookup_0'), Keys.chord(Keys.ENTER))

WebUI.delay(5)

WebUI.selectOptionByValue(findTestObject('Page_cabi Order Items/selectSize'), 'L', true)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Add to Cart'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Continue to Shipping'))

WebUI.click(findTestObject('Page_cabi Personal Store/nextButtonShipping'))

WebUI.click(findTestObject('Page_cabi Personal Store/makeFirstPayment'))

WebUI.click(findTestObject('Page_cabi Personal Store/submitPayment'))

WebUI.click(findTestObject('Page_cabi Personal Store/submitOrderId'))

String successMsg = ''

boolean orderSuccess = false

List<WebElement> successMsgs = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/p_success_msg'), 
    5)

if (successMsgs.size() > 0) {
    successMsg = WebUI.getText(findTestObject('Object Repository/Page_cabi Personal Store/p_success_msg'))

    orderSuccess = true

    GlobalVariable.addOnOrderId = WebUI.getText(findTestObject('Object Repository/Page_cabi Personal Store/p_order_id'))
}

assert orderSuccess == true

WebUI.callTestCase(findTestCase('warehouseShipping'), [('orderId') : GlobalVariable.addOnOrderId], FailureHandling.STOP_ON_FAILURE)

/***************************End warehouse shipping***************************/
WebUI.callTestCase(findTestCase('backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Home/a_Shows  Orders'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Home/a_Orders'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/b'))

WebUI.delay(3)

WebUI.click(findTestObject('findOrders/Page_cabi Find Orders/orderNo'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/pendingShipment'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/inputShipped'))

WebUI.setText(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/inputOrderId'), GlobalVariable.addOnOrderId)

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/findOrders'))

WebUI.click(findTestObject('findOrders/Page_cabi Find Orders/orderView'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Order View/a_(Return Order)'))

WebUI.delay(3)

WebUI.selectOptionByValue(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/selectReason1'), 
    'CABI_c', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/selectReason2'), 
    'CABI_c_a', true)

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/inputRefund'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_Next'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/inputPostalService'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/inputConfirmAdderess'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_Next_1'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_Submit RMA'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/addonOrder'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi_addOn_order/a_continue_to_order'))

WebUI.delay(2)

WebUI.callTestCase(findTestCase('productVerifyShort'), [('available') : GlobalVariable.BOAddonPersonal], FailureHandling.STOP_ON_FAILURE)
