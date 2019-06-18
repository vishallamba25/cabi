import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

String dataFile = 'virtualShowData'
stylist = findTestData(dataFile).getValue('stylist', 1)
hostess = findTestData(dataFile).getValue('hostess', 1)
cohostess = findTestData(dataFile).getValue('cohostess', 1)
guest1 = findTestData(dataFile).getValue('guest1', 1)
guest2 = findTestData(dataFile).getValue('guest2', 1)

String dataFile2 = "micrositeData"
guest1Mail = findTestData(dataFile2).getValue('guest1Mail', 1)
guest1Pass = findTestData(dataFile2).getValue('guest1Pass', 1)


//WebUI.callTestCase(findTestCase('virtualShowRSVP/createShow'), [('testEnvt') : '', ('username') : '', ('password') : '', ('stylist') : ''
//        , ('hostess') : '', ('cohostess') : '', ('guest1') : '', ('guest2') : '', ('verifyHostess') : '', ('verifyCohostess') : ''
//        , ('verifyGuestCount') : '', ('verifyGuest1') : '', ('verifyGuest2') : '', ('cabiTestEnvt') : ''], FailureHandling.STOP_ON_FAILURE)
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.callTestCase(findTestCase('NewArrival/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('https://test19.cliotest.com/backoffice/control/VSStylistDashboard?showId=104596896&consultantPartyId=100000042')
//WebUI.navigateToUrl('https://test19.cliotest.com/vsstylistdashboard/?externalLoginKey=EL60408552551&showId=104596896/#/video-conference')

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Send Invitations/a_dashboard'))

WebUI.delay(5)

WebUI.switchToFrame(findTestObject('virualShowRSVPOR/dashboard/frame_start_pre_show'), 60)

WebUI.delay(5)

List<WebElement> listElement = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/guestList'),
	5)

listElement.get(1).getText().equalsIgnoreCase(hostess)

listElement.get(2).getText().equalsIgnoreCase(cohostess)

listElement.get(3).getText().equalsIgnoreCase(guest1)

listElement.get(3).getText().equalsIgnoreCase(guest2)

WebUI.delay(5)

List<WebElement> isShowNotStarted = WebUiCommonHelper.findWebElements(findTestObject('virualShowRSVPOR/dashboard/button_start_pre_show'),
	5)

if (isShowNotStarted.size() > 0) {
	WebUI.click(findTestObject('virualShowRSVPOR/dashboard/button_start_pre_show'))

	WebUI.click(findTestObject('virualShowRSVPOR/dashboard/button_pre_show_sure'))
} else {
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/button_re_join_show'))
}

/////////////////////////
WebUI.delay(5)

/*WebUI.acceptAlert()
WebDriver driver = DriverFactory.getWebDriver()
driver.switchTo().alert().accept();
*/
/*****************************tab switching****************/
String currentPage = WebUI.getUrl()

int currentTab = WebUI.getWindowIndex()

WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.open();')

WebUI.switchToWindowIndex(currentTab + 2)

WebUI.callTestCase(findTestCase('virtualShowRSVP/setVHost'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.micrositeURL="https://mirandakate.cabitest5.com/show-microsite/104596896/"
WebUI.navigateToUrl(GlobalVariable.micrositeURL)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h1_Youre invited'),
	'You\'re invited to Front Row')

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Login to RSVP'))

'Login with the invited guest'
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'),
	guest1Mail)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Welcome_password'),
	guest1Pass)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

WebUI.delay(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/complete_my_profile_later'),
	0)) {
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Ill complete my profile later' //WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'), 0)
			))
}

//WebDriver driver = DriverFactory.get DriverFactory.getDriver()
List<WebElement> listElement1 = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'),
	5)

'Validating invited guest\'s \'Yes\' RSVP\r\n'
if (listElement.empty) {
	println('list is empty')

	println('RSVP is not updated')

	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_RSVP'))
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_yes'))
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_SEND'))

	WebUI.delay(4)

	WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h2_Were so glad you can make it.'),
		'We\'re so glad you can make it.')
} else {
	println('RSVP is updated previously')
}


WebUI.delay(3)

WebUI.switchToWindowIndex(currentTab + 1)

//WebUI.verifyElementText(findTestObject('virualShowRSVPOR/Page_Show microsite/neoGuest1'), guest1)

