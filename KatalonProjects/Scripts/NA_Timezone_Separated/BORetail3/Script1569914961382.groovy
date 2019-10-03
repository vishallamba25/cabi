import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
WebUI.openBrowser('')
WebDriver driver;
JavascriptExecutor executor;
for (int timeRow = 3; timeRow <= 3; timeRow++) {
    WebUI.callTestCase(findTestCase('NewArrival/populateTimeGlobalVars'), [('row') : timeRow], FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.callTestCase(findTestCase('NewArrival/setTimezone'), [('ofbizURL') : '', ('ofbizuser') : '', ('ofbizpass') : ''
            , ('orderType') : GlobalVariable.orderType, ('timeZone') : GlobalVariable.timeZone, ('serverTarget') : GlobalVariable.serverTarget, ('clockServerTarget') : GlobalVariable.clockServerTarget], 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
        FailureHandling.CONTINUE_ON_FAILURE)

	driver = DriverFactory.getWebDriver()
	executor = ((driver) as JavascriptExecutor)
	
	WebElement AshowOrders = WebUiCommonHelper.findWebElement(findTestObject('Page_cabi Home/a_retail_purchases'),30)
	WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(AshowOrders))
	
    /*WebUI.click(findTestObject('Page_cabi Home/a_Shows  Orders'))
	WebUI.delay(1)
    WebUI.click(findTestObject('Page_cabi Home/a_retail_purchases'))*/

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
	WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))
  
    WebUI.delay(5)

	println executor.executeScript('return arguments[0].value;', WebUiCommonHelper.findWebElement(findTestObject('Page_cabi Retail Store/span_next_1'), 5))
	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Page_cabi Retail Store/span_next_1'), 5))
	WebUI.click(findTestObject('Page_cabi Retail Store/span_next_1'))
	//executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Page_cabi Retail Store/span_next_1'), 5))

    WebUI.delay(3)

    /////////////////////////
    WebUI.callTestCase(findTestCase('NewArrival/productVerify'), [('available') : GlobalVariable.BORetail, ('storeType') : 'BORetail'], 
        FailureHandling.CONTINUE_ON_FAILURE)
}