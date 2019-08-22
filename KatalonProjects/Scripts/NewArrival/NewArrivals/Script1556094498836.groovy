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

WebUI.maximizeWindow()

WebDriver driver;
JavascriptExecutor executor;



for (int timeRow = 1; timeRow <= findTestData('timezoneData').getRowNumbers(); timeRow++) {
	driver = DriverFactory.getWebDriver()
	executor = ((driver) as JavascriptExecutor)
	
    WebUI.callTestCase(findTestCase('NewArrival/populateTimeGlobalVars'), [('row') : timeRow], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('NewArrival/setTimezone'), [('ofbizURL') : '', ('ofbizuser') : '', ('ofbizpass') : ''
            , ('orderType') : GlobalVariable.orderType, ('timeZone') : GlobalVariable.timeZone, ('clockServerTarget') : GlobalVariable.clockServerTarget], 
        FailureHandling.STOP_ON_FAILURE)

    /*****************1 going to backoffice: personal*******************/
    WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))

    WebUI.click(findTestObject('Page_cabi Home/a_personal_purchases'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/span_Continue to Order'))

    WebUI.callTestCase(findTestCase('NewArrival/productVerify'), [('available') : GlobalVariable.BOPersonal, ('storeType') : 'BOPersonal'], 
        FailureHandling.STOP_ON_FAILURE)

    /*****************2 going to backoffice: retail******************/
	driver = DriverFactory.getWebDriver()
	executor = ((driver) as JavascriptExecutor)
	
    WebUI.click(findTestObject('Page_cabi Home/a_Shows  Orders'))
	WebUI.delay(1)
    WebUI.click(findTestObject('Page_cabi Home/a_retail_purchases'))

    WebUI.delay(3)

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
	
	WebUI.setText(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), existingCust)
	WebUI.delay(2)
	WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), Keys.chord(Keys.ARROW_DOWN))
	WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), Keys.chord(Keys.ENTER))

	WebUI.setText(findTestObject('Object Repository/Page_cabi Retail Store/input_email'), email)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address1_address1'), address1)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address2_address2'), '')

    WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_City_city'), city)

    WebUI.setText(findTestObject('Page_cabi Edit Customer Profile/input_state_postalCode'), zip)

	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Page_cabi Edit Customer Profile/span_click_near_address_1'), 5))
    WebUI.delay(5)
	
	List<WebElement> addSuggest = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Edit Customer Profile/check_address_suggestion'),
		5)
	
	if(addSuggest.size()>0){
		executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Edit Customer Profile/check_address_suggestion'), 5))
	}
	WebUI.delay(5)

	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'), 5))

  
    WebUI.delay(5)

	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Page_cabi Retail Store/span_next_1'), 5))

    WebUI.delay(3)

    /////////////////////////
    WebUI.callTestCase(findTestCase('NewArrival/productVerify'), [('available') : GlobalVariable.BORetail, ('storeType') : 'BORetail'], 
        FailureHandling.STOP_ON_FAILURE)

    /*****************3 going to backoffice: online******************/
   
	
	/*WebUI.click(findTestObject('Page_cabi Home/a_Shows  Orders'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Page_cabi Home/a_online_outline_purchases'))
	WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/Page_cabi Online Outlet Store/span_Continue to Order'))

    WebUI.callTestCase(findTestCase('NewArrival/productVerify'), [('available') : GlobalVariable.BOOnlineoutlet, ('storeType') : 'BOOnlineoutlet'], 
        FailureHandling.STOP_ON_FAILURE)*/

    /*****************4 going to backoffice: showorder************************/
    WebUI.callTestCase(findTestCase('NewArrival/createAPhysicalShow_IMHostess'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/Page_cabi Orders/span_orders'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Orders/button_placeOrder'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/Page_cabi Order Entry/span_orderItems'))

    WebUI.delay(2)

    WebUI.callTestCase(findTestCase('NewArrival/productVerifyShort'), [('available') : GlobalVariable.BOShow], FailureHandling.STOP_ON_FAILURE)

    /***********5 backoffice productWatchList************/
    WebUI.callTestCase(findTestCase('NewArrival/productWatchlist'), [('available') : GlobalVariable.BOEblast], FailureHandling.STOP_ON_FAILURE)

    /***********6 backoffice eblast************/
    WebUI.callTestCase(findTestCase('NewArrival/productEblast'), [('available') : GlobalVariable.BOEblast], FailureHandling.STOP_ON_FAILURE)

    /************7 addOn for personal order RMA *******/
    WebUI.callTestCase(findTestCase('NewArrival/addOnOrderPersonal'), [('addOnStyle') : ''], FailureHandling.STOP_ON_FAILURE)
    /************8 addOn for retail order RMA *******/
    WebUI.callTestCase(findTestCase('NewArrival/addOnOrderRetail'), [('addOnStyle') : ''], FailureHandling.STOP_ON_FAILURE)
    /*****************9 going to CabiCentral: personal order******************/
    WebUI.callTestCase(findTestCase('TestCaseUtilities/cabiCentralLogin'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(3)

    WebUI.click(findTestObject('Page_cabi cabiCentral Tasks/a_ORDERS'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Page_cabi Find Order/a_Create Order'))

    WebUI.selectOptionByValue(findTestObject('Page_cabi Create Order/select_order_type'), 'PERSONAL', true)

    WebUI.click(findTestObject('Page_cabi Create Order/input_select_order_type'))

    WebUI.callTestCase(findTestCase('NewArrival/productVerifyShort'), [('available') : GlobalVariable.CCPersonal, ('storeType') : 'CCPersonal'], 
        FailureHandling.STOP_ON_FAILURE)

    /*****************10 going to CabiCentral: retail order******************/
    WebUI.click(findTestObject('Page_cabi Find Order/a_Create Order'))

    WebUI.selectOptionByValue(findTestObject('Page_cabi Create Order/select_order_type'), 'RETAIL', true)

    WebUI.click(findTestObject('Page_cabi Create Order/input_select_order_type'))

    WebUI.callTestCase(findTestCase('NewArrival/productVerifyShort'), [('available') : GlobalVariable.CCRetail], FailureHandling.STOP_ON_FAILURE)

    /*****************11 going to CabiCentral: show order******************/
    WebUI.click(findTestObject('Page_cabi Find Order/a_Create Order'))

    WebUI.selectOptionByValue(findTestObject('Page_cabi Create Order/select_order_type'), 'SHOW', true)

    WebUI.click(findTestObject('Page_cabi Create Order/input_select_order_type'))

    WebUI.callTestCase(findTestCase('NewArrival/productVerifyShort'), [('available') : GlobalVariable.CCShow], FailureHandling.STOP_ON_FAILURE)
}