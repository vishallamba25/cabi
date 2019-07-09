import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.VSGuest
import internal.GlobalVariable as GlobalVariable




/**********vaiable initialization********************/
String dataFile = "micrositeData"
guest1Mail = findTestData(dataFile).getValue('guest1Mail', 1)
guest1Pass = findTestData(dataFile).getValue('guest1Pass', 1)
dataFile = 'virtualShowData'
String hostess = findTestData(dataFile).getValue('hostess', 1)
String cohostess = findTestData(dataFile).getValue('cohostess', 1)
String guest1 = findTestData(dataFile).getValue('guest1', 1)
String guest2 = findTestData(dataFile).getValue('guest2', 1)
/****************************************************/
List<VSGuest> actualGuestList= new ArrayList<>()
List<VSGuest> yesList= new ArrayList<>()
List<VSGuest> noList= new ArrayList<>()
List<VSGuest> maybeList= new ArrayList<>()
List<VSGuest> noreplyList= new ArrayList<>()
List<VSGuest> presentList= new ArrayList<>()
/****************************************************/



WebUI.callTestCase(findTestCase('virtualShowRSVP/createShow'), [('testEnvt') : '', ('username') : '', ('password') : '', ('stylist') : ''
        , ('hostess') : '', ('cohostess') : '', ('guest1') : '', ('guest2') : '', ('verifyHostess') : '', ('verifyCohostess') : ''
        , ('verifyGuestCount') : '', ('verifyGuest1') : '', ('verifyGuest2') : '', ('cabiTestEnvt') : ''], FailureHandling.STOP_ON_FAILURE)

/***********list update: yes, noreply********/
yesList.add(new VSGuest(hostess));
yesList.add(new VSGuest(cohostess));
noreplyList.add(new VSGuest(guest1));
noreplyList.add(new VSGuest(guest2));

WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor executor = (JavascriptExecutor)driver;

/*WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('https://test21.cliotest.com/backoffice/control/VSStylistDashboard?showId=104602773&consultantPartyId=100000042')
*/
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Send Invitations/a_dashboard'))

WebUI.delay(5)

WebUI.switchToFrame(findTestObject('virualShowRSVPOR/dashboard/frame_start_pre_show'), 60)

//WebUI.delay(5)

/////////////////////////
List<WebElement> isShowNotStarted = WebUiCommonHelper.findWebElements(findTestObject('virualShowRSVPOR/dashboard/button_start_pre_show'), 
    5)

if (isShowNotStarted.size() > 0) {
	
	WebElement button_start_pre_show = driver.findElement(By.xpath("//button[contains(text(), 'Start pre-show')]"));
	executor.executeScript("arguments[0].click();", button_start_pre_show);
	WebUI.delay(3)
	WebElement button_pre_show_sure = driver.findElement(By.xpath("//button[contains(text(), ' sure')]"));
	executor.executeScript("arguments[0].click();", button_pre_show_sure);
} else {
	WebElement button_re_join_show = driver.findElement(By.xpath("//button[contains(text(), 'Re-join show')]"));
	executor.executeScript("arguments[0].click();", button_re_join_show);
}

/////////////////////////
WebUI.delay(5)


/*****************************tab switching****************/
String currentPage = WebUI.getUrl()

int currentTab = WebUI.getWindowIndex()

driver = DriverFactory.getWebDriver()

//JavascriptExecutor js = ((driver) as JavascriptExecutor)

executor.executeScript('window.open();')

WebUI.switchToWindowIndex(currentTab + 2)

WebUI.callTestCase(findTestCase('TestCaseUtilities/setVHost'), [:], FailureHandling.STOP_ON_FAILURE)

//GlobalVariable.micrositeURL="https://mirandakate.cabitest5.com/show-microsite/104602773/"
WebUI.navigateToUrl(GlobalVariable.micrositeURL)

'Login with the invited guest'
WebElement enterMail = driver.findElement(By.xpath("//div[@class='form-field']/custom-input/div/input[@name='email']"));
executor.executeScript("arguments[0].click();", enterMail);
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'),	guest1Mail)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))
WebUI.delay(5)
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Welcome_password'), guest1Pass)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue_pass'))
WebUI.delay(5)
if (WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/complete_my_profile_later'), 0)) {
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Ill complete my profile later'))
}

WebUI.navigateToUrl(GlobalVariable.micrositeURL)

List<WebElement> listElement1 = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'), 5)

'Validating invited guest\'s \'Yes\' RSVP\r\n'
if (listElement1.empty) {
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
WebUI.delay(4)
WebUI.click(findTestObject('Object Repository/showMicrosite/button_join_the_show'))
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'))

WebUI.switchToWindowIndex(currentTab + 1)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'))






