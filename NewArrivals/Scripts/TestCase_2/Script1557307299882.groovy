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

CWURL = findTestData('credData').getValue('CWURL', 1)

CWuser = findTestData('credData').getValue('CWuser', 1)

CWpass = findTestData('credData').getValue('CWpass', 1)

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(CWURL)


    WebUI.setText(findTestObject('Page_cabi/input_Welcome to_USERNAME'), CWuser)

    WebUI.setText(findTestObject('Object Repository/Page_cabi/input_Welcome to_PASSWORD'), CWpass)

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/Page_cabi/input_Welcome to_consultantLogin'))


WebUI.delay(3)

