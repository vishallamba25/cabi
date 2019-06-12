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

not_run: WebUI.openBrowser('')

not_run: WebUI.maximizeWindow()

ofbizURL = findTestData('credData').getValue('ofbizURL', 1)

ofbizuser = findTestData('credData').getValue('ofbizuser', 1)

ofbizpass = findTestData('credData').getValue('ofbizpass', 1)

WebUI.navigateToUrl(ofbizURL)

WebUI.setText(findTestObject('Page_/input_Username_username'), ofbizuser)

WebUI.setText(findTestObject('Page_/input_Password_password'), ofbizpass)

WebUI.click(findTestObject('Page_/input_Password_Submit'))

WebUI.click(findTestObject('Object Repository/Page_/a_Clock set'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_/serverTarget'), serverTarget, true)

WebUI.click(findTestObject('Page_/thisDateAndTime'))

WebUI.setText(findTestObject('Object Repository/Page_/setTargetTime'), timeZone)

WebUI.click(findTestObject('Object Repository/Page_/input'))

WebUI.delay(10)

not_run: WebUI.closeBrowser()
