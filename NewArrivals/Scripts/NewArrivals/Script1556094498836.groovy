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

WebUI.navigateToUrl('https://test14.cliotest.com/backoffice/control/main')

for (int timeRow = 1; timeRow <= findTestData('timezoneData').getRowNumbers(); timeRow++) {
    WebUI.callTestCase(findTestCase('populateTimeGlobalVars'), [('row') : timeRow], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('newArrivalsSetTimezone'), [('ofbizURL') : ofbizURL, ('ofbizuser') : ofbizuser, ('ofbizpass') : ofbizpass
            , ('orderType') : GlobalVariable.orderType, ('timeZone') : GlobalVariable.timeZone, ('serverTarget') : GlobalVariable.serverTarget], 
        FailureHandling.STOP_ON_FAILURE)

    /*****************going to backoffice: personal*******************/
    WebUI.navigateToUrl(BOURL)

    WebUI.maximizeWindow()

    List<WebElement> logOut = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Home/log_out'), 
        5)

    if (logOut.size() == 0) {
        WebUI.setText(findTestObject('Page_cabi/input_Welcome to_USERNAME'), BOuser)

        WebUI.setText(findTestObject('Object Repository/Page_cabi/input_Welcome to_PASSWORD'), BOpass)

        WebUI.click(findTestObject('Object Repository/Page_cabi/input_Welcome to_consultantLogin'))
    }
    
    WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Page_cabi Home/a_personal_purchases'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/span_Continue to Order'))

    WebUI.callTestCase(findTestCase('productVerify'), [('available') : GlobalVariable.BOPersonal], FailureHandling.STOP_ON_FAILURE)

    /*****************going to backoffice: retail******************/
    WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))
    WebUI.delay(3)
    WebUI.click(findTestObject('Page_cabi Home/a_retail_purchases'))
	WebUI.click(findTestObject('Object Repository/Page_cabi Retail Store/span_Continue to Order'))
	WebUI.callTestCase(findTestCase('productVerify'), [('available') : GlobalVariable.BORetail], FailureHandling.STOP_ON_FAILURE)
	
	/*****************going to backoffice: online******************/
	WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))
	WebUI.delay(3)
	WebUI.click(findTestObject('Page_cabi Home/a_online_outlet_purchases'))
	WebUI.click(findTestObject('Object Repository/Page_cabi Online Outlet Store/span_Continue to Order'))
	WebUI.callTestCase(findTestCase('productVerify'), [('available') : GlobalVariable.BOOnline], FailureHandling.STOP_ON_FAILURE)
}