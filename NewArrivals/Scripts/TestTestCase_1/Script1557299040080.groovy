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

GlobalVariable.BOShow="on"

WebUI.callTestCase(findTestCase('createContact'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : '', ('firstName') : ''
	, ('lastName') : '', ('email') : '', ('address1') : '', ('city') : '', ('state') : '', ('zip') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('createAPhysicalShow'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : '', ('hostess') : ''
	, ('cohostess') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Orders/span_orders'))

WebUI.click(findTestObject('Page_cabi Orders/button_placeOrder'))

WebUI.click(findTestObject('Object Repository/Page_cabi Order Entry/span_orderItems'))

WebUI.callTestCase(findTestCase('productVerifyShort'), [('available') : GlobalVariable.BOShow], FailureHandling.STOP_ON_FAILURE)

/*

WebUI.setText(findTestObject('Object Repository/Page_cabi Order Entry/input_Discount_'), '5618')

WebUI.click(findTestObject('Object Repository/Page_cabi Order Entry/a_5618 Breeze Dress'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Order Entry/input_Discount_'), '5618 Breeze Dress')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_cabi Order Entry/select_Select_size'), 'XS', true)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Entry/span_Next'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Order Entry/input_Discount_'), '5618')

WebUI.click(findTestObject('Object Repository/Page_cabi Order Entry/a_5618'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Order Entry/input_Discount_'), '5618 Breeze Dress')

WebUI.click(findTestObject('Object Repository/Page_cabi Order Entry/span_Next'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Order Entry/input_Discount_'), '5618')

WebUI.click(findTestObject('Object Repository/Page_cabi Order Entry/a_5618_2'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Order Entry/input_Discount_'), '5618 Breeze Dress')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_cabi Order Entry/select_Select_size'), 'M', true)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Entry/span_Add to Cart'))

WebUI.click(findTestObject('Object Repository/Page_cabi Order Entry/span_Next'))

WebUI.click(findTestObject('Object Repository/Page_cabi Shipping/span_Next'))

WebUI.closeBrowser()*/

