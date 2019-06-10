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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

//WebUI.openBrowser('')

//WebUI.maximizeWindow()

BOURL = findTestData('credData').getValue('BOURL', 1)

BOuser = findTestData('credData').getValue('BOuser', 1)

BOpass = findTestData('credData').getValue('BOpass', 1)



WebUI.callTestCase(findTestCase('NewArrival/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.rightClick(findTestObject('Page_cabi Home/a_Shows  Orders'))

WebUI.click(findTestObject('Page_cabi Home/a_Create_A_Show'))

WebUI.click(findTestObject('Page_cabi Home/select_i_am_hostess'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_cabi Create Show - Set Hostess/input_next'))

WebUI.delay(3)

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input_Show_date_time'))

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/a_16'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/a_16'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/b'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/div_Location for ShowSame as Hostess Home Address'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input__address_Same_as_hostess'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input_Same as show location'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/label_Tax Rate Calculated'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input_Back_section'))

WebUI.delay(3)

WebUI.click(findTestObject('Page_cabi Create ShowTime_Place/input_ShowSummaryTab'))

