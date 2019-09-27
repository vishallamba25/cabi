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

for (int timeRow = 1; timeRow <= 1; timeRow++) {
    WebUI.callTestCase(findTestCase('NewArrival/populateTimeGlobalVars'), [('row') : timeRow], FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.callTestCase(findTestCase('NewArrival/setTimezone'), [('ofbizURL') : '', ('ofbizuser') : '', ('ofbizpass') : ''
            , ('orderType') : GlobalVariable.orderType, ('timeZone') : GlobalVariable.timeZone, ('serverTarget') : GlobalVariable.serverTarget, ('clockServerTarget') : GlobalVariable.clockServerTarget], 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))

    WebUI.click(findTestObject('Page_cabi Home/a_personal_purchases'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/span_Continue to Order'))

	println GlobalVariable.BOPersonal
    WebUI.callTestCase(findTestCase('NewArrival/productVerify'), [('available') : GlobalVariable.BOPersonal, ('storeType') : 'BOPersonal'], 
        FailureHandling.CONTINUE_ON_FAILURE)
}