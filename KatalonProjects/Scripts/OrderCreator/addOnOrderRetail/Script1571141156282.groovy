import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')
WebDriver driver;
JavascriptExecutor executor;

addOnStyle = findTestData('miscData').getValue('addOnStyle', 1)
//int i = 1

for (int timeRow = 1; timeRow <= 1; timeRow++) {
    

    WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.CONTINUE_ON_FAILURE)

    driver = DriverFactory.getWebDriver()
	executor = ((driver) as JavascriptExecutor)
	
	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Page_cabi Home/a_retail_purchases'), 5))
    //WebUI.click(findTestObject('Page_cabi Home/a_retail_purchases'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/Page_cabi Home/existingCustomer'))

    ///////////////////////
    int contactNumber = 1

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
	WebUI.delay(2)
	WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), Keys.chord(Keys.ARROW_DOWN))
	WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), Keys.chord(Keys.ENTER))

	/*WebUI.setText(findTestObject('Object Repository/Page_cabi Retail Store/input_email'), email)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address1_address1'), address1)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address2_address2'), '')

    WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_City_city'), city)

    WebUI.setText(findTestObject('Page_cabi Edit Customer Profile/input_state_postalCode'), zip)
	WebUI.delay(2)
	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Page_cabi Edit Customer Profile/span_click_near_address_1'), 5))
    WebUI.delay(5)
	
	List<WebElement> addSuggest = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Edit Customer Profile/check_address_suggestion'),
		5)
	
	if(addSuggest.size()>0){
		executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Edit Customer Profile/check_address_suggestion'), 5))
	}*/
	WebUI.delay(5)

	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'), 5))

  
    WebUI.delay(5)

	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Page_cabi Retail Store/span_next_1'), 5))

    WebUI.delay(3)

    /////////////////////////

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/Page_cabi Retail Store/span_quick_entry'))

    WebUI.delay(3)

    List<WebElement> emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 5)

   while (emptyCart.size() > 0) {
        WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'))

        println('cart not empty')

        WebUI.delay(5)
		emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 5)
    }
    
    

    ///////////////
    WebUI.click(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'))

    WebUI.setText(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), addOnStyle)

    WebUI.delay(3)

    String prod_message = WebUI.getText(findTestObject('Page_cabi Create Order/first_option'))

    WebUI.click(findTestObject('Page_cabi Create Order/first_option'))

    ///////////////
    WebUI.delay(5)

    WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/selectSize'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Add to Cart'))

    WebUI.delay(5)

    WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Continue to Shipping'))

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

        GlobalVariable.addOnOrderId = WebUI.getText(findTestObject('Object Repository/Page_cabi Personal Store/p_order_id'))
    }
    
    assert orderSuccess == true

    /***************************warehouse shipping***************************/
    WebUI.callTestCase(findTestCase('NewArrival/warehouseShipping'), [('orderId') : GlobalVariable.addOnOrderId], FailureHandling.CONTINUE_ON_FAILURE)

    /***********************************************************************/
    WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Home/a_Shows  Orders'))

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Home/a_Orders'))

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/b'))

    WebUI.delay(3)

    WebUI.click(findTestObject('findOrders/Page_cabi Find Orders/orderNo'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/pendingShipment'))

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/inputShipped'))

    WebUI.setText(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/inputOrderId'), 
        GlobalVariable.addOnOrderId)

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/findOrders'))

    WebUI.click(findTestObject('findOrders/Page_cabi Find Orders/orderView'))

    WebUI.delay(3)

    WebUI.refresh()

    WebUI.delay(3)

    WebUI.refresh()

    WebUI.delay(10)

    WebUI.refresh()

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Order View/a_(Return Order)'))

    WebUI.delay(3)

    WebUI.selectOptionByValue(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/selectReason1'), 
        'CABI_c', true)

    WebUI.selectOptionByValue(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/selectReason2'), 
        'CABI_c_a', true)

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/inputRefund'))

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_Next'))

/*    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_edit_address'))

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/select_address'))

    WebUI.delay(3)*/

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/inputPostalService'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/inputConfirmAdderess'))

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_Next_1'))

    WebUI.delay(5)

    ///////////////
    List<WebElement> confirmAddress = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/inputConfirmAdderess'), 
        1)

    if (confirmAddress.size() != 0) {
        WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/inputConfirmAdderess'))

        WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_Next_1'))
    }
    
    ////////////////
    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_Submit RMA'))

    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/addonOrder'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/Page_cabi Retail Store/span_next'))


   /* *//****************product Verify Short******************//*
    WebUI.callTestCase(findTestCase('NewArrival/productVerifyShort'), [('available') : GlobalVariable.BOAddonRetail], FailureHandling.CONTINUE_ON_FAILURE)

    GlobalVariable.controlParallelism = (GlobalVariable.controlParallelism + 1)

    if (GlobalVariable.controlParallelism == GlobalVariable.parallelTC) {
        i++
    }
    
    println('retail')

    println(GlobalVariable.controlParallelism)

    println(GlobalVariable.parallelTC)*/
}

