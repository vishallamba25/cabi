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
import commonUtility.UtilityMethods as UtilityMethods
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser('')
WebUI.maximizeWindow()

for (int timeRow = 1; timeRow <= findTestData('timezoneData').getRowNumbers(); timeRow++) {
    WebUI.callTestCase(findTestCase('populateTimeGlobalVars'), [('row') : timeRow], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('newArrivalsSetTimezone'), [('ofbizURL') : ofbizURL, ('ofbizuser') : ofbizuser, ('ofbizpass') : ofbizpass
            , ('orderType') : GlobalVariable.orderType, ('timeZone') : GlobalVariable.timeZone, ('serverTarget') : GlobalVariable.serverTarget], 
        FailureHandling.STOP_ON_FAILURE)

    /*****************1 going to backoffice: personal*******************/
    /*
    WebUI.callTestCase(findTestCase('backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))

    WebUI.click(findTestObject('Page_cabi Home/a_personal_purchases'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/span_Continue to Order'))

    WebUI.callTestCase(findTestCase('productVerify'), [('available') : GlobalVariable.BOPersonal, ('storeType') : 'BOPersonal'], 
        FailureHandling.STOP_ON_FAILURE)

    *//*****************2 going to backoffice: retail******************//*
    WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))

    WebUI.delay(1)

    WebUI.rightClick(findTestObject('Page_cabi Home/a_Shows  Orders'))

    WebUI.click(findTestObject('Page_cabi Home/a_retail_purchases'))

    WebUI.delay(3)

    //WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_guest_info'))
    WebUI.click(findTestObject('Object Repository/Page_cabi Home/existingCustomer'))

    ///////////////////////
    String existingCustFName = findTestData('contactData').getValue('firstName', 3)

    String existingCustLName = findTestData('contactData').getValue('lastName', 3)

    String space = ' '

    String existingCust = "$existingCustFName$space$existingCustLName"

    WebUI.setText(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), existingCust)

    WebUI.delay(3)

    WebUI.rightClick(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'))

    WebUI.rightClick(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'))
    WebUI.click(findTestObject('Object Repository/Page_cabi Create Show - Set Hostess/a_select_customer'))

    WebUI.setText(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), existingCust)

    WebUI.check(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))

    WebUI.click(findTestObject('Page_cabi Retail Store/span_next_1'))

    WebUI.delay(3)

    /////////////////////////
    WebUI.callTestCase(findTestCase('productVerify'), [('available') : GlobalVariable.BORetail, ('storeType') : 'BORetail'], 
        FailureHandling.STOP_ON_FAILURE)

    *//*****************3 going to backoffice: online******************//*
    WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))

    WebUI.delay(3)

    WebUI.rightClick(findTestObject('Page_cabi Home/a_online_outline_purchases'))

    WebUI.click(findTestObject('Page_cabi Home/a_online_outline_purchases'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Online Outlet Store/span_Continue to Order'))

    WebUI.callTestCase(findTestCase('productVerify'), [('available') : GlobalVariable.BOOnlineoutlet, ('storeType') : 'BOOnlineoutlet'], 
        FailureHandling.STOP_ON_FAILURE)

    *//*****************4 going to backoffice: showorder************************//*
    WebUI.callTestCase(findTestCase('createAPhysicalShow_IMHostess'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/Page_cabi Orders/span_orders'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Orders/button_placeOrder'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/Page_cabi Order Entry/span_orderItems'))

    WebUI.delay(2)

    WebUI.callTestCase(findTestCase('productVerifyShort'), [('available') : GlobalVariable.BOShow], FailureHandling.STOP_ON_FAILURE)

    */

    /***********5 backoffice productWatchList************/
	WebUI.callTestCase(findTestCase('productWatchlist'), [('available') : GlobalVariable.BOEblast], FailureHandling.STOP_ON_FAILURE)
	
    /***********5 backoffice eblast************/
    WebUI.callTestCase(findTestCase('productEblast'), [('available') : GlobalVariable.BOEblast], FailureHandling.STOP_ON_FAILURE)

    /************6 addOn for personal order RMA *******/
   /* WebUI.callTestCase(findTestCase('addOnOrderPersonal'), [('addOnStyle') : ''], FailureHandling.STOP_ON_FAILURE)

    *//************7 addOn for retail order RMA *******//*
    WebUI.callTestCase(findTestCase('addOnOrderRetail'), [('addOnStyle') : ''], FailureHandling.STOP_ON_FAILURE) */
	
	/*****************8 going to CabiCentral: personal order******************/
    /*
    WebUI.callTestCase(findTestCase('cabiCentralLogin'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(3)

    WebUI.click(findTestObject('Page_cabi cabiCentral Tasks/a_ORDERS'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Page_cabi Find Order/a_Create Order'))

    WebUI.selectOptionByValue(findTestObject('Page_cabi Create Order/select_order_type'), 'PERSONAL', true)

    WebUI.click(findTestObject('Page_cabi Create Order/input_select_order_type'))

    WebUI.callTestCase(findTestCase('productVerifyShort'), [('available') : GlobalVariable.CCPersonal, ('storeType') : 'CCPersonal'], 
        FailureHandling.STOP_ON_FAILURE)
	
    */
    /*****************9 going to CabiCentral: retail order******************/
    /* 

    WebUI.click(findTestObject('Page_cabi Find Order/a_Create Order'))

    WebUI.selectOptionByValue(findTestObject('Page_cabi Create Order/select_order_type'), 'RETAIL', true)

    WebUI.click(findTestObject('Page_cabi Create Order/input_select_order_type'))

    WebUI.callTestCase(findTestCase('productVerifyShort'), [('available') : GlobalVariable.CCRetail], FailureHandling.STOP_ON_FAILURE)

    */
    /*****************10 going to CabiCentral: show order******************/
    /*
    WebUI.click(findTestObject('Page_cabi Find Order/a_Create Order'))

    WebUI.selectOptionByValue(findTestObject('Page_cabi Create Order/select_order_type'), 'SHOW', true)

    WebUI.click(findTestObject('Page_cabi Create Order/input_select_order_type'))

    WebUI.callTestCase(findTestCase('productVerifyShort'), [('available') : GlobalVariable.CCShow], FailureHandling.STOP_ON_FAILURE)*/
}

