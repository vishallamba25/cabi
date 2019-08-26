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
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

for (int timeRow = 1; timeRow <= findTestData('timezoneData').getRowNumbers(); timeRow++) {
    WebUI.callTestCase(findTestCase('NewArrival/populateTimeGlobalVars'), [('row') : timeRow], FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.callTestCase(findTestCase('NewArrival/setTimezone'), [('ofbizURL') : '', ('ofbizuser') : '', ('ofbizpass') : ''
            , ('orderType') : GlobalVariable.orderType, ('timeZone') : GlobalVariable.timeZone, ('serverTarget') : GlobalVariable.serverTarget, ('clockServerTarget') : GlobalVariable.clockServerTarget], 
        FailureHandling.CONTINUE_ON_FAILURE)

    /*****************9 going to CabiCentral: personal order******************/
    WebUI.callTestCase(findTestCase('TestCaseUtilities/cabiCentralLogin'), [:], FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(3)

    WebUI.click(findTestObject('Page_cabi cabiCentral Tasks/a_ORDERS'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Page_cabi Find Order/a_Create Order'))

    WebUI.selectOptionByValue(findTestObject('Page_cabi Create Order/select_order_type'), 'PERSONAL', true)

    WebUI.click(findTestObject('Page_cabi Create Order/input_select_order_type'))

    WebUI.callTestCase(findTestCase('NewArrival/productVerifyShort'), [('available') : GlobalVariable.CCPersonal, ('storeType') : 'CCPersonal'], 
        FailureHandling.CONTINUE_ON_FAILURE)

    /*****************10 going to CabiCentral: retail order******************/
    WebUI.click(findTestObject('Page_cabi Find Order/a_Create Order'))

    WebUI.selectOptionByValue(findTestObject('Page_cabi Create Order/select_order_type'), 'RETAIL', true)

    WebUI.click(findTestObject('Page_cabi Create Order/input_select_order_type'))

    WebUI.callTestCase(findTestCase('NewArrival/productVerifyShort'), [('available') : GlobalVariable.CCRetail], FailureHandling.CONTINUE_ON_FAILURE)

    /*****************11 going to CabiCentral: show order******************/
    /*WebUI.click(findTestObject('Page_cabi Find Order/a_Create Order'))

    WebUI.selectOptionByValue(findTestObject('Page_cabi Create Order/select_order_type'), 'SHOW', true)

    WebUI.click(findTestObject('Page_cabi Create Order/input_select_order_type'))

    WebUI.callTestCase(findTestCase('NewArrival/productVerifyShort'), [('available') : GlobalVariable.CCShow], FailureHandling.CONTINUE_ON_FAILURE)*/
}