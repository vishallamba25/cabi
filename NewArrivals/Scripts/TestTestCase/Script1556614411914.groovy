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

WebUI.navigateToUrl('https://test14.cliotest.com/cabicentral/control/main')

WebUI.setText(findTestObject('Page_cabi/input_Username_USERNAME'), 'ehudson')

WebUI.setEncryptedText(findTestObject('Page_cabi/input_Password_PASSWORD'), 'B/N/DIt9VtgMeGq7IFnfMA==')

WebUI.click(findTestObject('Page_cabi/input_Password_section-btn btn-stl-pk rFloat'))

WebUI.click(findTestObject('Page_cabi cabiCentral Tasks/a_ORDERS'))

WebUI.click(findTestObject('Page_cabi Find Order/a_Create Order'))

WebUI.click(findTestObject('Page_cabi Create Order/input_select_order_type'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create Order/a_Create Order'))

WebUI.selectOptionByValue(findTestObject('Page_cabi Create Order/select_order_type'), 
    'PERSONAL', true)

WebUI.click(findTestObject('Page_cabi Create Order/input_select_order_type'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), '5618')

WebUI.click(findTestObject('Page_cabi Create Order/first_option'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), '21211')

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), '21211')

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Create Order/a_No matching result found'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create Order/a_No matching result found'))

WebUI.setText(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), '5618')

WebUI.click(findTestObject('Page_cabi Create Order/first_option'))

WebUI.rightClick(findTestObject('Page_cabi Create Order/select_colour'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_cabi Create Order/select_SelectXSSMLXL'), 'XS', true)

WebUI.click(findTestObject('Page_cabi Create Order/retail_price'))

