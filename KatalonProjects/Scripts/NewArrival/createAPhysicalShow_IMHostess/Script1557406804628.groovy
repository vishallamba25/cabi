import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods

//WebUI.openBrowser('')

//WebUI.maximizeWindow()

BOURL = findTestData('envtData').getValue('BOURL', 1)

BOuser = findTestData('credData').getValue('BOuser', 1)

BOpass = findTestData('credData').getValue('BOpass', 1)



WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.rightClick(findTestObject('Page_cabi Home/a_Shows  Orders'))

WebUI.click(findTestObject('Page_cabi Home/a_Create_A_Show'))

WebUI.click(findTestObject('Page_cabi Home/select_i_am_hostess'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_cabi Create Show - Set Hostess/input_next'))

WebUI.delay(3)

WebUI.rightClick(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input_Show_date_time'))


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

/*WebUI.rightClick(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/a_16'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/a_16'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/b'))*/

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/div_Location for ShowSame as Hostess Home Address'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input__address_Same_as_hostess'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input_Same as show location'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/label_Tax Rate Calculated'))

WebUI.click(findTestObject('Object Repository/Page_cabi Create ShowTime_Place/input_Back_section'))

WebUI.delay(3)

//WebUI.click(findTestObject('Page_cabi Create ShowTime_Place/input_ShowSummaryTab'))

