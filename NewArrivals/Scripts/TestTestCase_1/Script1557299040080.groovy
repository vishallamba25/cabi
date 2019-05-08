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

WebUI.navigateToUrl('https://test14.cliotest.com/backoffice/control/main')

WebUI.setText(findTestObject('Page_cabi/input_Welcome to_USERNAME'), '400000002')

WebUI.setEncryptedText(findTestObject('Page_cabi/input_Welcome to_PASSWORD'), 'B/N/DIt9VtgMeGq7IFnfMA==')

WebUI.click(findTestObject('Page_cabi/input_Welcome to_consultantLogin'))

WebUI.rightClick(findTestObject('Page_cabi Home/a_Shows  Orders'))

WebUI.click(findTestObject('Page_cabi Home/a_Create A Show'))

WebUI.setText(findTestObject('Page_cabi Create Show - Set Hostess/input_New_cohost'), 'neoh')

WebUI.click(findTestObject('Page_cabi Create Show - Set Hostess/a_neohost1 abc'))

WebUI.setText(findTestObject('Page_cabi Create Show - Set Hostess/input_New_cohost'), 'neohost1 abc')

WebUI.selectOptionByValue(findTestObject('Page_cabi Create Show - Set Hostess/choose_from_contacts'), '3', true)

WebUI.setText(findTestObject('Page_cabi Create Show - Set Hostess/input_Co-Hostess'), 'neoc')

WebUI.click(findTestObject('Page_cabi Create Show - Set Hostess/a_neocohost1 abc'))

WebUI.setText(findTestObject('Page_cabi Create Show - Set Hostess/input_Co-Hostess'), 'neocohost1 abc')

WebUI.click(findTestObject('Page_cabi Create Show - Set Hostess/input_Cancel_submitButton'))

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input_Show_date_time'))

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/a_16'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/a_16'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/b'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/div_Location for ShowSame as Hostess Home Address'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input__address_Same_as_hostess'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input_Same as show location'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/label_Tax Rate Calculated'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input_Back_section'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input_PlaceOrderTab'))

WebUI.click(findTestObject('Object Repository/Page_cabi Orders/button_Place Order'))

WebUI.click(findTestObject('Page_cabi/span_Order Items'))

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

WebUI.closeBrowser()

