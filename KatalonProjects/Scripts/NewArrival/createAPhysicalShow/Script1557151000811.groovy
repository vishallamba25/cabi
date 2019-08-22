import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.maximizeWindow()

BOURL = findTestData('envtData').getValue('BOURL', 1)

BOuser = findTestData('credData').getValue('BOuser', 1)

BOpass = findTestData('credData').getValue('BOpass', 1)

String hostessFName = findTestData('contactData').getValue('firstName', 1)

String hostessLName = findTestData('contactData').getValue('lastName', 1)

String cohostessFName = findTestData('contactData').getValue('firstName', 2)

String cohostessLName = findTestData('contactData').getValue('lastName', 2)

String space = ' '

hostess = "$hostessFName$space$hostessLName"

cohostess = "$cohostessFName$space$cohostessLName"

WebUI.navigateToUrl(BOURL)

WebUI.setText(findTestObject('Page_cabi/input_Welcome to_USERNAME'), BOuser)

WebUI.setText(findTestObject('Page_cabi/input_Welcome to_PASSWORD'), BOpass)

WebUI.click(findTestObject('Page_cabi/input_Welcome to_consultantLogin'))

WebUI.delay(10)

WebUI.rightClick(findTestObject('Page_cabi Home/a_Shows  Orders'))

WebUI.click(findTestObject('Page_cabi Home/a_Create_A_Show'))
WebUI.setText(findTestObject('Page_cabi Create Show - Set Hostess/input_Hostess'), hostess)
WebUI.delay(2)
WebUI.sendKeys(findTestObject('Page_cabi Create Show - Set Hostess/input_Hostess'), Keys.chord(
		Keys.ARROW_DOWN))
WebUI.sendKeys(findTestObject('Page_cabi Create Show - Set Hostess/input_Hostess'), Keys.chord(
		Keys.ENTER))

WebUI.delay(3)

/////////////////////////
List<WebElement> validateHostessAddressMsg = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Create Show - Set Hostess/validate_address_msg'), 
    5)

println(validateHostessAddressMsg.size())

if (validateHostessAddressMsg.isEmpty()) {
    WebUI.click(findTestObject('Page_cabi Create Show - Set Hostess/validate_hostess_address'))

    WebUI.delay(5)
}

/////////////////////////
WebUI.selectOptionByValue(findTestObject('Page_cabi Create Show - Set Hostess/select_Choose_From_Contacts_Co-Hostess'), 
    '3', true)


WebUI.setText(findTestObject('Page_cabi Create Show - Set Hostess/input_Cohostess'), cohostess)
WebUI.delay(2)
WebUI.sendKeys(findTestObject('Page_cabi Create Show - Set Hostess/input_Cohostess'), Keys.chord(
		Keys.ARROW_DOWN))
WebUI.sendKeys(findTestObject('Page_cabi Create Show - Set Hostess/input_Cohostess'), Keys.chord(
		Keys.ENTER))

WebUI.delay(3)

/////////////////////////
validateHostessAddressMsg = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Create Show - Set Hostess/validate_address_msg'), 
    5)

if (validateHostessAddressMsg.size() != 4) {
    WebUI.click(findTestObject('Page_cabi Create Show - Set Hostess/validate_cohostess_address'))

    WebUI.delay(5)
}

/////////////////////////
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

