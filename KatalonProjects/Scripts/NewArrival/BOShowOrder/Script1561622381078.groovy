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
    WebUI.callTestCase(findTestCase('NewArrival/populateTimeGlobalVars'), [('row') : timeRow], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('NewArrival/setTimezone'), [('ofbizURL') : '', ('ofbizuser') : '', ('ofbizpass') : ''
            , ('orderType') : GlobalVariable.orderType, ('timeZone') : GlobalVariable.timeZone, ('serverTarget') : GlobalVariable.serverTarget
            , ('clockServerTarget') : GlobalVariable.clockServerTarget], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('NewArrival/createAPhysicalShow_IMHostess'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/Page_cabi Orders/span_orders'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Orders/button_placeOrder'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/Page_cabi Order Entry/span_orderItems'))

    WebUI.delay(2)

    WebUI.callTestCase(findTestCase('NewArrival/productVerifyShort'), [('available') : GlobalVariable.BOShow], FailureHandling.STOP_ON_FAILURE)
}

