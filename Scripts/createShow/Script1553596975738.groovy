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
import myPack.WriteExcel as WriteToExcel
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import org.stringtemplate.v4.compiler.STParser.listElement_return as listElement_return

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(testEnvt)

WebUI.setText(findTestObject('Page_cabi/input_username'), username)

WebUI.setText(findTestObject('Page_cabi/input_password'), password)

WebUI.click(findTestObject('Page_cabi/input_consultantLogin'))

WebUI.delay(10)

WebUI.verifyElementText(findTestObject('Page_cabi/span_username'), stylist)

WebUI.rightClick(findTestObject('Page_cabi Home/a_shows _orders'))

WebUI.click(findTestObject('Page_cabi Home/a_Create_A_Show'))

WebUI.setText(findTestObject('Page_cabi Create Show - Set Hostess/input_Hostess'), hostess)

WebUI.rightClick(findTestObject('Page_cabi Create Show - Set Hostess/input_Hostess'))

WebUI.click(findTestObject('Page_cabi Create Show - Set Hostess/a_select_hostess'))

WebUI.setText(findTestObject('Page_cabi Create Show - Set Hostess/input_Hostess_Txt'), hostess)
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

WebUI.rightClick(findTestObject('Page_cabi Create Show - Set Hostess/input_Cohostess'))

WebUI.rightClick(findTestObject('Page_cabi Create Show - Set Hostess/input_Cohostess'))

WebUI.click(findTestObject('Page_cabi Create Show - Set Hostess/a_select_cohostess'))

WebUI.setText(findTestObject('Page_cabi Create Show - Set Hostess/input_Cohostess'), cohostess)
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

WebUI.delay(5)

WebUI.click(findTestObject('Page_cabi Create Show - Time and Place/check_Virtual_Show'))

WebUI.rightClick(findTestObject('Page_cabi Create Show - Time and Place/input_Show_Date_Time'))

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Create Show - Time and Place/a_18'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create Show - Time and Place/a_18'))

WebUI.click(findTestObject('Page_cabi Create Show - Time and Place/a_select_End_Time'))

WebUI.click(findTestObject('Page_cabi Create Show - Time and Place/input_next'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_cabi Create Show - Invite Hostess/input_Skip_Invite'))

WebUI.rightClick(findTestObject('Page_cabi Edit Show - Add Guests/contact_search_box'))

WebUI.setText(findTestObject('Page_cabi Edit Show - Add Guests/contact_search_box'), guest1)

WebUI.click(findTestObject('Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.rightClick(findTestObject('Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.rightClick(findTestObject('Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.click(findTestObject('Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_cabi Edit Show - Add Guests/i_span_add_guest'))

WebUI.rightClick(findTestObject('Page_cabi Edit Show - Add Guests/contact_search_box'))

WebUI.setText(findTestObject('Page_cabi Edit Show - Add Guests/contact_search_box'), guest2)

WebUI.rightClick(findTestObject('Page_cabi Edit Show - Add Guests/contact_search_box'))

WebUI.click(findTestObject('Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.rightClick(findTestObject('Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.rightClick(findTestObject('Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.click(findTestObject('Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_cabi Edit Show - Add Guests/i_span_add_guest'))

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Page_cabi Edit Show - Add Guests/span_hostess_name'), verifyHostess)

WebUI.verifyElementText(findTestObject('Page_cabi Edit Show - Add Guests/span_cohostess_name'), verifyCoHostess)

/////////////////////////
List<WebElement> listElement = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Edit Show - Add Guests/span_guest_name_list'), 
    5)

int guestCount = Integer.parseInt(verifyGuestCount)

//println "guest count is"
//println guestCount
//println listElement.size()
assert listElement.size() == guestCount

boolean flag = false

for (int i = 0; i < guestCount; i++) {
    flag = false

    if (listElement.get(i).getText().equals(verifyGuest1)) {
        flag = true //println(WebUI.getText(we))
    }
    
    if (listElement.get(i).getText().equals(verifyGuest2)) {
        flag = true //println(WebUI.getText(we))
        /*for (WebElement we : listElement) {
        println(we.getText())
		if (we.getText().equals(findTestData('virtualShowData').getValue(21 + i, 1))) {
            flag = true //println(WebUI.getText(we))
        }
    }*/
    }
}

assert flag == true

///////////////////////////////////
WebUI.click(findTestObject('Page_cabi Edit Show - Add Guests/input_Next'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_cabi Edit Show - Send Invitations/input_Overview'))

String showID = WebUI.getText(findTestObject('Page_cabi Orders/li_Show_ID_Text'))

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Orders/a_Account'))

WebUI.click(findTestObject('Object Repository/Page_cabi Orders/a_My Profile'))

String rsName = WebUI.getText(findTestObject('Page_cabi My Profile/span_rsName'))

String cabitTestEnvt = cabiTestEnvt

GlobalVariable.micrositeURL = WriteToExcel.createURL(rsName, cabitTestEnvt, showID)

/*String micrositeURL = WriteToExcel.createURL(rsName, cabitTestEnvt, showID)

CustomKeywords.'myPack.WriteExcel.demoKey'(micrositeURL)*/
WebUI.closeBrowser()

