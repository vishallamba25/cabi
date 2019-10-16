import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

addOnStyle = findTestData('miscData').getValue('addOnStyle', 1)

String rmaNumber

//int i = 1
for (int timeRow = 1; timeRow <= 1; timeRow++) {
    
    if (timeRow == 1) {
        /**************************************Order Creation and Shipping*************************************************************/
        WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
            FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.click(findTestObject('Page_cabi Home/a_Shows  Orders'))

        WebUI.delay(1)

        WebUI.click(findTestObject('Page_cabi Home/a_personal_purchases'))

        WebUI.delay(3)

        WebUI.click(findTestObject('Page_cabi Personal Store/span_Continue to Order'))

        WebUI.delay(5)

        List<WebElement> emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 
            5)

        while (emptyCart.size() > 0) {
            WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'))

            println('cart not empty')

            WebUI.delay(5)

            emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 
                5)
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

        WebUI.delay(3)

        WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Continue to Shipping'))

        WebUI.click(findTestObject('Page_cabi Personal Store/nextButtonShipping'))

        WebUI.delay(3)

        WebUI.click(findTestObject('Page_cabi Personal Store/makeFirstPayment'))

        WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/select_ach_payment'))

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
			println GlobalVariable.addOnOrderId
        }
        
        assert orderSuccess == true

        /***************************warehouse shipping***************************/
        WebUI.callTestCase(findTestCase('NewArrival/warehouseShipping'), [('orderId') : GlobalVariable.addOnOrderId], FailureHandling.CONTINUE_ON_FAILURE /***********************************************************************/ /***************************end warehouse shipping***********************/ ) /**************************************End Order Creation and Shipping*************************************************************/
    }
    
    /***************************return order and validate addOn products***************************/
    WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
        FailureHandling.CONTINUE_ON_FAILURE)

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

    if (timeRow == 1) {
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
		WebUI.delay(2)
        rmaNumber = WebUI.getText(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_get_rma_number'))
    }
	else{
		WebUI.delay(1)
		WebUI.click(UtilityMethods.createTestObject("a_view_existing_rma", '//div/span[text()= \'RMA# ', rmaNumber, '\']/following-sibling::a'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_next_existing_rma'))
	}
	WebUI.delay(1)
    WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/addonOrder'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/Page_cabi_addOn_order/a_continue_to_order'))


    /****************product Verify Short*****************
    WebUI.callTestCase(findTestCase('NewArrival/productVerifyShort'), [('available') : GlobalVariable.BOAddonPersonal], 
        FailureHandling.CONTINUE_ON_FAILURE /*GlobalVariable.controlParallelism = (GlobalVariable.controlParallelism + 1)

    if (GlobalVariable.controlParallelism == GlobalVariable.parallelTC) {
        i++
    }
	println "from personal"
	println GlobalVariable.controlParallelism
	println GlobalVariable.parallelTC*/
}