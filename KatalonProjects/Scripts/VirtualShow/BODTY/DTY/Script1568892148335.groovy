import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.testng.asserts.SoftAssert as SoftAssert
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import commonUtility.UtilityMethods as UtilityMethods
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

/**********vaiable initialization********************/
String dataFile = 'virtualShowData'

String guest1 = findTestData(dataFile).getValue('guest1', 1)

String guest2 = findTestData(dataFile).getValue('guest2', 1)

String hostess = findTestData(dataFile).getValue('hostess', 1)

String cohostess = findTestData(dataFile).getValue('cohostess', 1)

/***************getting DTY eleigible date: Two days after today*************/
DateFormat dfMM = new SimpleDateFormat('MM')

DateFormat dfDD = new SimpleDateFormat('dd')

DateFormat dfYYYY = new SimpleDateFormat('yyyy')

Date today = Calendar.getInstance().getTime()

Calendar c = Calendar.getInstance()

c.setTime(today)

c.add(Calendar.DATE, 2) //Two days after today

Date newShowDate = c.getTime()

//String todayAsString = df.format(currentDatePlusOne);
String vsyear = dfYYYY.format(newShowDate)

String vsmonth = dfMM.format(newShowDate)

String vsday = dfDD.format(newShowDate)
println UtilityMethods.concat("from DTY: ", vsday, " ", vsmonth, " ", vsyear)
/***************end getting DTY eleigible date*********/
/****************************************************/
WebUI.callTestCase(findTestCase('VirtualShow/createAPhysicalShow'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : '', ('hostess') : ''
        , ('cohostess') : '', ('vsday') : vsday, ('vsmonth') : vsmonth, ('vsyear') : vsyear], FailureHandling.STOP_ON_FAILURE)

/*WebUI.openBrowser('')
WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.navigateToUrl('https://test18.cliotest.com/backoffice/control/ShowOverview?showId=104723620')*/
/***********************place show order with DTY check******************/
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Send Invitations/a_orders'))

String[] g1Vars = UtilityMethods.splitPersonName(guest1)

String g1Var = UtilityMethods.concat(g1Vars[1], ', ', g1Vars[0])

TestObject buttonPlaceOrder = UtilityMethods.createTestObject('buttoPlaceOrder', '//table[@class=\'show-order-table\']/tbody/tr/td/span[contains(text(), \'', 
    g1Var, '\')]/parent::td/following-sibling::td[1]/button')

WebUI.click(buttonPlaceOrder)

WebUI.delay(3)

String DTYMsg = 'Hooray! This order is eligible for "Direct to You" shipping.'

println(WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/DTY/label_DtyEligibility')))

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/DTY/label_DtyEligibility'), DTYMsg, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.check(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))

WebUI.delay(3)

WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor executor = ((driver) as JavascriptExecutor)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Home/a_order_items'), 
        5))

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

addOnStyle = findTestData('miscData').getValue('addOnStyle', 1)

addOnStyle2 = findTestData('miscData').getValue('addOnStyle', 2)

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

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/selectSize'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Add to Cart'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/a_next'))

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg1'), 'This order is eligible for "Direct to You" shipping.', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg2'), '"Direct to You" order must be paid by credit card or cabi Gift Card.', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg3'), '"Direct to You" order can start being placed 2 days before the show date.', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_show_loc'), 'disabled', 
    20, FailureHandling.CONTINUE_ON_FAILURE)

println(WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_show_loc'), 
        5).getAttribute('disabled'))

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 
        5))

WebUI.delay(5)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_show_loc'), 'disabled', 
    'true', 20)

println(WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_show_loc'), 
        5).getAttribute('disabled'))

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_show_loc_label'), 
    'style', 'color: rgb(211, 211, 211);', 20)

WebUI.delay(1)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 
        5))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_show_order_checkout_next'))

WebUI.delay(1)

println(WebUI.getText(findTestObject('Object Repository/Page_cabi Shipping/div_DTY-warning_popup')))

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/div_DTY-warning_popup'), 'This order is eligible for "Direct to You" shipping.\nDo you want to change this order to "Direct to You" and ship immediately?')

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/button_DTY_warning_popup_ship_DTY'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_make_first_payment'))

WebUI.delay(3)

List<WebElement> paymentOptions = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Shipping/select_payment_options'), 
    20)

paymentOptions.get(0).getAttribute(addOnStyle)

boolean validPayOption = true

for (WebElement we : paymentOptions) {
    String option = we.getText()

    if (!((option.matches('.*[^\\d]\\d{4}$') || option.equalsIgnoreCase('Gift Card')) || option.equalsIgnoreCase('Add New Credit Card'))) {
        validPayOption = false

        break
    }
}

SoftAssert sa = new SoftAssert()

sa.assertTrue(validPayOption)

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/li_DTY_payment_info'), '"Direct to You" orders require payment via credit card or cabi Gift Card.', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

/**************------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>******************/
WebUI.callTestCase(findTestCase('TestCaseUtilities/showOrderPaeymentCC'), [:], FailureHandling.STOP_ON_FAILURE)
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_submit_order'),
		10))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_order_view'))

String actualOrderStatus = WebUI.getText(findTestObject('Object Repository/Page_cabi Shipping/span_order_status'))

String expectedOrderStatus = 'PENDING SHIPMENT'

sa.assertTrue(actualOrderStatus.contains(expectedOrderStatus))

println(actualOrderStatus)

/***********************end palce show order with DTY check******************/
WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_back_to_orders'))

WebUI.delay(2)

/***********************place show order without DTY check: cash******************/
String[] g2Vars = UtilityMethods.splitPersonName(guest2)

String g2Var = UtilityMethods.concat(g2Vars[1], ', ', g2Vars[0])

buttonPlaceOrder = UtilityMethods.createTestObject('buttoPlaceOrder', '//table[@class=\'show-order-table\']/tbody/tr/td/span[contains(text(), \'', 
    g2Var, '\')]/parent::td/following-sibling::td[1]/button')

WebUI.click(buttonPlaceOrder)

WebUI.delay(3)

DTYMsg = 'Hooray! This order is eligible for "Direct to You" shipping.'

println(WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/DTY/label_DtyEligibility')))

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/DTY/label_DtyEligibility'), DTYMsg, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.check(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))

WebUI.delay(3)

driver = DriverFactory.getWebDriver()

executor = ((driver) as JavascriptExecutor)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Home/a_order_items'), 
        5))

/////////////////////////////////////////////////
WebUI.click(findTestObject('Object Repository/Page_cabi Retail Store/span_quick_entry'))

WebUI.delay(3)

emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 
    5)

if (emptyCart.size() > 0) {
    WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'))

    println('cart not empty')

    WebUI.delay(5)
}

addOnStyle = findTestData('miscData').getValue('addOnStyle', 1)

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

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/selectSize'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Add to Cart'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/a_next'))

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg1'), 'This order is eligible for "Direct to You" shipping.', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg2'), '"Direct to You" order must be paid by credit card or cabi Gift Card.', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg3'), '"Direct to You" order can start being placed 2 days before the show date.', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_show_loc'), 'disabled', 
    20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_guest_add'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_show_order_checkout_next'))

WebUI.delay(1)

println(WebUI.getText(findTestObject('Object Repository/Page_cabi Shipping/div_DTY-warning_popup')))

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/div_DTY-warning_popup'), 'This order is eligible for "Direct to You" shipping.\nDo you want to change this order to "Direct to You" and ship immediately?')

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/button_DTY_warning_popup_no_ship_DTY'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_make_first_payment'))

WebUI.delay(3)

List<WebElement> DTYMsgs = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Shipping/li_DTY_payment_info'), 
    5)

if (DTYMsgs.size() > 0) {
    sa.assertTrue(false)
}

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/select_payment_options_select'))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/select_payment_options_cash'))

WebUI.delay(1)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_review_order'), 
        10))

WebUI.delay(2)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_submit_order'), 
        10))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_order_view'))

actualOrderStatus = WebUI.getText(findTestObject('Object Repository/Page_cabi Shipping/span_order_status'))

expectedOrderStatus = 'OPEN'

sa.assertTrue(actualOrderStatus.contains(expectedOrderStatus))

println(actualOrderStatus)

/***********************end place show order without DTY check******************/
WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_back_to_orders'))

WebUI.delay(2)

String ActualDTYOptedOrderStatus = WebUI.getText(UtilityMethods.createTestObject('DTYOptedOrderStatus', '//table[@class=\'show-order-table\']/tbody/tr/td/span[contains(text(), \'', 
        g1Var, '\')]/parent::td/following-sibling::td[@class=\'order-status\']'))

String ActualDTYNonOptedOrderStatus = WebUI.getText(UtilityMethods.createTestObject('DTYOptedOrderStatus', '//table[@class=\'show-order-table\']/tbody/tr/td/span[contains(text(), \'', 
        g2Var, '\')]/parent::td/following-sibling::td[@class=\'order-status\']'))

sa.assertEquals(ActualDTYOptedOrderStatus, 'PENDING SHIPMENT')

sa.assertEquals(ActualDTYNonOptedOrderStatus, 'Completed')

/******************************Editing DTY opted order*********************/
TestObject buttonEditDTYOptedOrder = UtilityMethods.createTestObject('buttonEditDTYOptedOrder', '//table[@class=\'show-order-table\']/tbody/tr/td/span[contains(text(), \'', 
    g1Var, '\')]/parent::td/following-sibling::td[@class=\'column-order\']/a')

WebUI.click(buttonEditDTYOptedOrder)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order'))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order_shipping'))

boolean checkDisabled = WebUI.verifyElementHasAttribute(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 
    'disabled', 20, FailureHandling.CONTINUE_ON_FAILURE)

boolean checkChecked = WebUI.verifyElementHasAttribute(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 
    'checked', 20, FailureHandling.CONTINUE_ON_FAILURE)

if (checkDisabled && checkChecked) {
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 'disabled', 
        'true', 20)

    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 'checked', 
        'true', 20)
}

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order_cancel'))

WebUI.delay(1)

/******************************end Editing DTY opted order*********************/
//adding third guest: michigan
WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_invitaions'))

/////////
String guest3 = findTestData(dataFile).getValue('guest3', 1)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/a_add_guests'), 
        10))

//WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/a_add_guests'))
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'), 
    guest3)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'), 
    Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'), 
    Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/a_add_guest'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/input_Next'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Send Invitations/input_Overview'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Send Invitations/a_orders'))

/////////
/******************************Editing DTY non opted order: cash*********************/
TestObject buttonEditDTYNonOptedOrder = UtilityMethods.createTestObject('buttonEditDTYNonOptedOrder', '//table[@class=\'show-order-table\']/tbody/tr/td/span[contains(text(), \'', 
    g2Var, '\')]/parent::td/following-sibling::td[@class=\'column-order\']/a')

WebUI.click(buttonEditDTYNonOptedOrder)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order'))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order_shipping'))

WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 'disabled', 
    20, FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'))
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order_payments'))

WebUI.delay(3)

/**************------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>******************/
WebUI.callTestCase(findTestCase('TestCaseUtilities/showOrderPaeymentCC'), [:], FailureHandling.STOP_ON_FAILURE)
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order_save_changes'), 
        10))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order'))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order_shipping'))

WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 'disabled', 
    20, FailureHandling.CONTINUE_ON_FAILURE)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 
        5))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_show_order_checkout_next'))

WebUI.delay(1)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_review_order'), 
        10))

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order_save_changes'), 
        10))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_back_to_orders'))

WebUI.delay(2)

/******************************end Editing DTY non opted order: cash*********************/
/***********************place show order without DTY check: CC******************/
String[] g3Vars = UtilityMethods.splitPersonName(guest3)

String g3Var = UtilityMethods.concat(g3Vars[1], ', ', g3Vars[0])

buttonPlaceOrder = UtilityMethods.createTestObject('buttoPlaceOrder', '//table[@class=\'show-order-table\']/tbody/tr/td/span[contains(text(), \'', 
    g3Var, '\')]/parent::td/following-sibling::td[1]/button')

WebUI.click(buttonPlaceOrder)

WebUI.delay(3)

DTYMsg = 'Hooray! This order is eligible for "Direct to You" shipping.'

println(WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/DTY/label_DtyEligibility')))

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/DTY/label_DtyEligibility'), DTYMsg, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.check(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))

WebUI.delay(3)

driver = DriverFactory.getWebDriver()

executor = ((driver) as JavascriptExecutor)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Home/a_order_items'), 
        5))

/////////////////////////////////////////////////
WebUI.click(findTestObject('Object Repository/Page_cabi Retail Store/span_quick_entry'))

WebUI.delay(3)

emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 
    5)

if (emptyCart.size() > 0) {
    WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'))

    println('cart not empty')

    WebUI.delay(5)
}

addOnStyle = findTestData('miscData').getValue('addOnStyle', 1)

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

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/selectSize'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Add to Cart'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/a_next'))

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg1'), 'This order is eligible for "Direct to You" shipping.', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg2'), '"Direct to You" order must be paid by credit card or cabi Gift Card.', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg3'), '"Direct to You" order can start being placed 2 days before the show date.', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_show_loc'), 'disabled', 
    20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_guest_add'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_show_order_checkout_next'))

WebUI.delay(1)

println(WebUI.getText(findTestObject('Object Repository/Page_cabi Shipping/div_DTY-warning_popup')))

WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/div_DTY-warning_popup'), 'This order is eligible for "Direct to You" shipping.\nDo you want to change this order to "Direct to You" and ship immediately?')

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/button_DTY_warning_popup_no_ship_DTY'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_make_first_payment'))

WebUI.delay(3)

DTYMsgs = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Shipping/li_DTY_payment_info'), 
    5)

if (DTYMsgs.size() > 0) {
    sa.assertTrue(false)
}

/**************------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>******************/
WebUI.callTestCase(findTestCase('TestCaseUtilities/showOrderPaeymentCC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_submit_order'), 
        10))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_order_view'))

actualOrderStatus = WebUI.getText(findTestObject('Object Repository/Page_cabi Shipping/span_order_status'))

expectedOrderStatus = 'OPEN'

sa.assertTrue(actualOrderStatus.contains(expectedOrderStatus))

println(actualOrderStatus)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_back_to_orders'))

WebUI.delay(2)

/***********************end place show order without DTY check: CC******************/
/******************************Editing DTY non opted order: CC*********************/
TestObject buttonEditDTYNonOptedOrderCC = UtilityMethods.createTestObject('buttonEditDTYNonOptedOrderCC', '//table[@class=\'show-order-table\']/tbody/tr/td/span[contains(text(), \'', 
    g3Var, '\')]/parent::td/following-sibling::td[@class=\'column-order\']/a')

WebUI.click(buttonEditDTYNonOptedOrderCC)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order'))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order_shipping'))

WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 'disabled', 
    20, FailureHandling.CONTINUE_ON_FAILURE)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 
        10))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order_payments'))

WebUI.delay(3)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_review_order'), 
        10))

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_edit_order_save_changes'), 
        10))

WebUI.delay(2)

actualOrderStatus = WebUI.getText(findTestObject('Object Repository/Page_cabi Shipping/span_order_status'))

expectedOrderStatus = 'PENDING SHIPMENT'

sa.assertTrue(actualOrderStatus.contains(expectedOrderStatus))

println(actualOrderStatus)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_back_to_orders'))

WebUI.delay(2)

/******************************end Editing DTY non opted order: CC*********************/
/******************************place order for hostess*********************/
String[] hVars = UtilityMethods.splitPersonName(hostess)

String hVar = UtilityMethods.concat(hVars[1], ', ', hVars[0])

buttonPlaceOrder = UtilityMethods.createTestObject('buttoPlaceOrder', '//table[@class=\'show-order-table\']/tbody/tr/td/span[contains(text(), \'', 
    hVar, '\')]/parent::td/following-sibling::td[1]/button')

WebUI.click(buttonPlaceOrder)

WebUI.delay(3)

List<WebElement> noDTYMsg = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/DTY/label_DtyEligibility'), 
    5)

if (noDTYMsg.size() > 0) {
    sa.assertTrue(false)
}

WebUI.check(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))

WebUI.delay(3)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Home/a_order_items'), 
        5))

/////////////////////////////////////////////////
WebUI.click(findTestObject('Object Repository/Page_cabi Retail Store/span_quick_entry'))

WebUI.delay(3)

emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 
    5)

if (emptyCart.size() > 0) {
    WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'))

    println('cart not empty')

    WebUI.delay(5)
}

addOnStyle = findTestData('miscData').getValue('addOnStyle', 1)

addOnStyle2 = findTestData('miscData').getValue('addOnStyle', 2)

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

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/selectSize'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Add to Cart'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/a_next'))

WebUI.delay(3)

noDTYMsg = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg1'), 5)

if (noDTYMsg.size() > 0) {
    sa.assertTrue(false)
}

List<WebElement> noDTYCheck = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 
    5)

if (noDTYCheck.size() > 0) {
    sa.assertTrue(false)
}

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_show_order_checkout_next'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_make_first_payment'))

WebUI.delay(3)

DTYMsgs = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Shipping/li_DTY_payment_info'), 
    5)

if (DTYMsgs.size() > 0) {
    sa.assertTrue(false)
}

/**************------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>******************/
WebUI.callTestCase(findTestCase('TestCaseUtilities/showOrderPaeymentCC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_submit_order'), 
        10))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_order_view'))

actualOrderStatus = WebUI.getText(findTestObject('Object Repository/Page_cabi Shipping/span_order_status'))

expectedOrderStatus = 'OPEN'

sa.assertTrue(actualOrderStatus.contains(expectedOrderStatus))

println(actualOrderStatus)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_back_to_orders'))

WebUI.delay(2)

/******************************end place order for hostess*********************/
/******************************place order for cohostess***********************/
String[] chVars = UtilityMethods.splitPersonName(cohostess)

String chVar = UtilityMethods.concat(chVars[1], ', ', chVars[0])

buttonPlaceOrder = UtilityMethods.createTestObject('buttoPlaceOrder', '//table[@class=\'show-order-table\']/tbody/tr/td/span[contains(text(), \'', 
    chVar, '\')]/parent::td/following-sibling::td[1]/button')

WebUI.click(buttonPlaceOrder)

WebUI.delay(3)

noDTYMsg = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/DTY/label_DtyEligibility'), 
    5)

if (noDTYMsg.size() > 0) {
    sa.assertTrue(false)
}

WebUI.check(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))

WebUI.delay(3)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Home/a_order_items'), 
        5))

/////////////////////////////////////////////////
WebUI.click(findTestObject('Object Repository/Page_cabi Retail Store/span_quick_entry'))

WebUI.delay(3)

emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 
    5)

if (emptyCart.size() > 0) {
    WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'))

    println('cart not empty')

    WebUI.delay(5)
}

addOnStyle = findTestData('miscData').getValue('addOnStyle', 1)

addOnStyle2 = findTestData('miscData').getValue('addOnStyle', 2)

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

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/selectSize'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Add to Cart'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/a_next'))

WebUI.delay(3)

noDTYMsg = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg1'), 5)

if (noDTYMsg.size() > 0) {
    sa.assertTrue(false)
}

noDTYCheck = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 
    5)

if (noDTYCheck.size() > 0) {
    sa.assertTrue(false)
}

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_show_order_checkout_next'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_make_first_payment'))

WebUI.delay(3)

DTYMsgs = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Shipping/li_DTY_payment_info'), 
    5)

if (DTYMsgs.size() > 0) {
    sa.assertTrue(false)
}

/**************------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>******************/
WebUI.callTestCase(findTestCase('TestCaseUtilities/showOrderPaeymentCC'), [:], FailureHandling.STOP_ON_FAILURE)
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/a_submit_order'),
		10))


WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_order_view'))

actualOrderStatus = WebUI.getText(findTestObject('Object Repository/Page_cabi Shipping/span_order_status'))

expectedOrderStatus = 'OPEN'

sa.assertTrue(actualOrderStatus.contains(expectedOrderStatus))

println(actualOrderStatus)

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/a_back_to_orders'))

WebUI.delay(2)

