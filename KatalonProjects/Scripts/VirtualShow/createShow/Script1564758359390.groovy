import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import commonUtility.UtilityMethods as UtilityMethods
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

/**********vaiable initialization********************/
String dataFile = 'virtualShowData'

String stylist = findTestData(dataFile).getValue('stylist', 1)

String hostess = findTestData(dataFile).getValue('hostess', 1)

String cohostess = findTestData(dataFile).getValue('cohostess', 1)

String guest1 = findTestData(dataFile).getValue('guest1', 1)

String guest2 = findTestData(dataFile).getValue('guest2', 1)

String verifyGuestCount = findTestData(dataFile).getValue('verifyGuestCount', 1)

String RSTestEnvt = findTestData('envtData').getValue('RSTestEnvt', 1)

/****************************************************/
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi/span_username'), stylist)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Home/a_shows _orders'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Home/a_Create_A_Show'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Hostess'), hostess)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Hostess'), Keys.chord(
        Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Hostess'), Keys.chord(
        Keys.ENTER))

WebUI.delay(2)

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

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Cohostess'), 
    cohostess)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Cohostess'), 
    Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/input_Cohostess'), 
    Keys.chord(Keys.ENTER))

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

//WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Time and Place/check_Virtual_Show'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Time and Place/input_Show_Date_Time'))

/***********************************Calendar date*****************************/
int year = ((findTestData('virtualShowData').getValue('vsyear', 1)) as Integer)

int month = ((findTestData('virtualShowData').getValue('vsmonth', 1)) as Integer)

int day = ((findTestData('virtualShowData').getValue('vsday', 1)) as Integer)

String pastdate= findTestData('virtualShowData').getValue('pastdate', 1)

////td[@data-month='5' and @data-year='2019']/a[contains(text(), '15')]
////////////////dynamic obj for date
String xpath = UtilityMethods.concat(((((('//td[@data-month=\'' + (month - 1)) + '\' and @data-year=\'') + year) + '\']/a[contains(text(), \'') + 
    day) + '\')]')

TestObject dateObj = new TestObject('td_month_year_day')

dateObj.addProperty('xpath', ConditionType.EQUALS, xpath)

//////////////
int monthBound = 12

List<WebElement> dateObjList = WebUiCommonHelper.findWebElements(dateObj, 5)

while ((dateObjList.size() == 0) && (monthBound > 0)) {
	if(pastdate.equalsIgnoreCase("no"))
    	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/a_next_month'))
	else
		WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/a_prev_month'))
    WebUI.delay(3)

    dateObjList = WebUiCommonHelper.findWebElements(dateObj, 5)

    monthBound--

    println(dateObjList)
}

WebUI.click(dateObj)

/***********************************End Calendar date*****************************/
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Time and Place/a_select_End_Time'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Time and Place/input_next'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Invite Hostess/input_Skip_Invite'))

/////////
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'), 
    guest1)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'), 
    Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'), 
    Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/a_add_guest'))

/////////
WebUI.delay(5)

/////////
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'), 
    guest2)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'), 
    Keys.chord(Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'), 
    Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/a_add_guest'))

WebUI.delay(2)

/*
WebUI.rightClick(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'), guest1)*/
/*WebUI.rightClick(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.rightClick(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/plus_add_guest'))*/
/*WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/i_span_add_guest'))

WebUI.rightClick(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'), guest2)

WebUI.rightClick(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/contact_search_box'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.rightClick(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.rightClick(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/plus_add_guest'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/i_span_add_guest'))*/
/**************verifying host, cohost, guest1, guest2**************************/
String[] verifyHostess = UtilityMethods.splitPersonName(hostess)

String[] verifyCohostess = UtilityMethods.splitPersonName(cohostess)

String[] verifyGuest1 = UtilityMethods.splitPersonName(guest1)

String[] verifyGuest2 = UtilityMethods.splitPersonName(guest2)

/*findTestData(dataFile).getValue('verifyHostess', 1)
verifyCohostess = findTestData(dataFile).getValue('verifyCohostess', 1)
verifyGuest1 = findTestData(dataFile).getValue('verifyGuest1', 1)
verifyGuest2 = findTestData(dataFile).getValue('verifyGuest2', 1)*/
WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/span_hostess_name'), 
    UtilityMethods.concat(verifyHostess[1], ', ', verifyHostess[0]))

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/span_cohostess_name'), 
    UtilityMethods.concat(verifyCohostess[1], ', ', verifyCohostess[0]))

/////////////////////////
List<WebElement> listElement = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/span_guest_name_list'), 
    5)

int guestCount = Integer.parseInt(verifyGuestCount)

assert listElement.size() == guestCount

boolean flag = false

for (int i = 0; i < guestCount; i++) {
    flag = false

    if (listElement.get(i).getText().equals(UtilityMethods.concat(verifyGuest1[1], ', ', verifyGuest1[0]))) {
        flag = true //println(WebUI.getText(we))
    }
    
    if (listElement.get(i).getText().equals(UtilityMethods.concat(verifyGuest2[1], ', ', verifyGuest2[0]))) {
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
/**************verifying host, cohost, guest1, guest2**************************/
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Add Guests/input_Next'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Send Invitations/input_Overview'))

String showID = WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Orders/li_Show_ID_Text'))

WebUI.rightClick(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Orders/a_Account'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Orders/a_My Profile'))

String rsName = WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi My Profile/span_rsName'))

GlobalVariable.micrositeURL = UtilityMethods.createURL(rsName, RSTestEnvt, showID)

println(GlobalVariable.micrositeURL)

/*String micrositeURL = WriteToExcel.createURL(rsName, cabitTestEnvt, showID)

CustomKeywords.'myPack.WriteExcel.demoKey'(micrositeURL)*/
//WebUI.closeBrowser()
WebUI.back()

