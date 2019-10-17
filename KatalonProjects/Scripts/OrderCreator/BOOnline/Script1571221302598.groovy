import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import org.testng.asserts.SoftAssert as SoftAssert
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import commonUtility.UtilityMethods as UtilityMethods

WebUI.openBrowser('')

for (int timeRow = 1; timeRow <= 1; timeRow++) {
    WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))

    WebUI.delay(3)

    WebUI.rightClick(findTestObject('Page_cabi Home/a_online_outline_purchases'))

    WebUI.click(findTestObject('Page_cabi Home/a_online_outline_purchases'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Online Outlet Store/span_Continue to Order'))

    /*****************************************************************************************************/
    addOnStyle = '2147' //findTestData('miscData').getValue('addOnStyle', 1)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Order Items/input_New Arrivals - Blooming Blush_style'), addOnStyle)

    WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Order Items/input_New Arrivals - Blooming Blush_style'), 
        Keys.chord(Keys.ENTER))
	
	WebUI.delay(2)
	
	WebUI.executeJavaScript('arguments[0].click()', Arrays.asList(WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Order Items/a_item_img'),
		30)))
	
	WebUI.delay(2)

    WebUI.executeJavaScript('arguments[0].click()', Arrays.asList(WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Order Items/input_New Arrivals - Blooming Blush_style'), 
                30)))

    List<WebElement> availableOptions = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Order Items/input_select_available_options'), 
        5)

    for (int i = 1; i <= availableOptions.size(); i++) {
        TestObject selectFirstOption = UtilityMethods.createTestObject('div_drop_down', '(//li[@class=\'product-color\']/label/following-sibling::select/option[contains(text(), \'Select\')])[', 
            String.valueOf(i), ']/following-sibling::option[1]')

        WebUI.click(selectFirstOption)

        WebUI.delay(3)
    }
    
	WebUI.executeJavaScript('arguments[0].click()', Arrays.asList(WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Order Items/a_add_to_cart'),
		30)))
	WebUI.delay(3)
	WebUI.executeJavaScript('arguments[0].click()', Arrays.asList(WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Order Items/a_checkout_online_store'),
		30)))
	WebUI.delay(3)
	
	WebUI.click(findTestObject('Page_cabi Personal Store/nextButtonShipping'))
	
	WebUI.delay(3)
	
	WebUI.click(findTestObject('Page_cabi Personal Store/makeFirstPayment'))
	
	//WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/select_cash'))
	
	WebUI.click(findTestObject('Page_cabi Personal Store/submitPayment'))
	
	WebUI.click(findTestObject('Page_cabi Personal Store/submitOrderId'))
	
	
	String successMsg = ''
	
	boolean orderSuccess = false
	
	List<WebElement> successMsgs = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/p_success_msg'),
		5)
	
	if (successMsgs.size() > 0) {
		successMsg = WebUI.getText(findTestObject('Object Repository/Page_cabi Personal Store/p_success_msg'))
		orderSuccess = true
		
	}
	SoftAssert sa= new SoftAssert();
		
		sa.assertTrue(orderSuccess)
	//WebUI.closeBrowser()
	
	
	
	
}	