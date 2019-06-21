import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods
////////////////
String testEnvt="https://test21.cliotest.com/backoffice/control/main"
String username="400000002"
String password="blackdress19"
String hostess="neohost1 abc"
String cohostess="neocohost1 abc"
////////////////



WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(testEnvt)

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi/input_username'), username)

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi/input_password'), password)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi/input_consultantLogin'))

WebUI.delay(10)

//WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi/span_username'), stylist)

WebUI.rightClick(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Home/a_shows _orders'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Home/a_Create_A_Show'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Hostess'), hostess)

WebUI.rightClick(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Hostess'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/a_select_hostess'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Hostess_Txt'), hostess)
WebUI.delay(3)

/////////////////////////
List<WebElement> validateHostessAddressMsg = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/validate_address_msg'), 
    5)

println(validateHostessAddressMsg.size())

if (validateHostessAddressMsg.isEmpty()) {
    WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/validate_hostess_address'))

    WebUI.delay(5)
}

/////////////////////////
WebUI.selectOptionByValue(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/select_Choose_From_Contacts_Co-Hostess'), 
    '3', true)

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Cohostess'), cohostess)

WebUI.rightClick(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Cohostess'))

WebUI.rightClick(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Cohostess'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/a_select_cohostess'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Cohostess'), cohostess)
WebUI.delay(3)
/////////////////////////
validateHostessAddressMsg = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/validate_address_msg'), 
    5)

if (validateHostessAddressMsg.size() != 4) {
    WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/validate_cohostess_address'))

    WebUI.delay(5)
}

/////////////////////////
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_next'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Time and Place/check_Virtual_Show'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Time and Place/input_Show_Date_Time'))

/***********************************Calendar date*****************************/
int year= (findTestData('virtualShowData').getValue('vsyear', 1)) as Integer
int month= (findTestData('virtualShowData').getValue('vsmonth', 1)) as Integer
int day= (findTestData('virtualShowData').getValue('vsday', 1)) as Integer


////td[@data-month='5' and @data-year='2019']/a[contains(text(), '15')]
////////////////dynamic obj for date
String xpath = UtilityMethods.concat("//td[@data-month='"+(month-1)+"' and @data-year='"+year+"']/a[contains(text(), '"+day+"')]")
TestObject dateObj = new TestObject('td_month_year_day')
dateObj.addProperty('xpath', ConditionType.EQUALS, xpath)
//////////////

int monthBound=12
List<WebElement> dateObjList = WebUiCommonHelper.findWebElements(dateObj, 5)
while(dateObjList.size()==0 && monthBound>0){
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/a_next_month'))
	WebUI.delay(3)
	dateObjList = WebUiCommonHelper.findWebElements(dateObj, 5)
	monthBound--;
	println dateObjList
}
WebUI.click(dateObj)
/***********************************End Calendar date*****************************/



