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

WebUI.callTestCase(findTestCase('backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_cabi Home/a_Connections'))

WebUI.click(findTestObject('Page_cabi Home/a_Contact Manager'))

WebUI.click(findTestObject('Page_cabi/span_SEND eBLAST'))

WebUI.click(findTestObject('Object Repository/Page_cabi Eblast/a_Stylist Picks'))

WebUI.click(findTestObject('Object Repository/Page_cabi Eblast/button_ADD PRODUCTS TO EBLAST'))

WebUI.setText(findTestObject('Page_cabi Eblast/eBlastStyleSearch'), '5618')

for (int row = 1; row <= findTestData('productData').getRowNumbers(); row++) {
	WebUI.delay(2)
	
	WebUI.setText(findTestObject('Page_cabi Eblast/eBlastStyleSearch'), findTestData(
			'productData').getValue('Style', row))

	WebUI.delay(2)

	String prod_message = WebUI.getText(findTestObject('Page_cabi Create Order/first_option'))
	
	WebUI.delay(1)
	
	WebUI.click(findTestObject('Page_cabi Create Order/first_option'))

}