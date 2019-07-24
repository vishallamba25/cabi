import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import commonUtility.VSGuest as VSGuest
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

/**********vaiable initialization********************/
String dataFile2 = 'micrositeData'

dataFile = 'virtualShowData'

String hostess = findTestData(dataFile).getValue('hostess', 1)

String cohostess = findTestData(dataFile).getValue('cohostess', 1)

String guest1 = findTestData(dataFile).getValue('guest1', 1)

String guest2 = findTestData(dataFile).getValue('guest2', 1)

hostessMail = findTestData(dataFile2).getValue('hostessMail', 1)

hostessPass = findTestData(dataFile2).getValue('hostessPass', 1)

guest1Mail = findTestData(dataFile2).getValue('guest1Mail', 1)

guest1Pass = findTestData(dataFile2).getValue('guest1Pass', 1)

/****************************************************/
List<VSGuest> actualGuestList = new ArrayList()

List<VSGuest> yesList = new ArrayList()

List<VSGuest> noList = new ArrayList()

List<VSGuest> maybeList = new ArrayList()

List<VSGuest> noreplyList = new ArrayList()

List<VSGuest> presentList = new ArrayList()

List<VSGuest> allList = new ArrayList()

/****************************************************/
WebUI.callTestCase(findTestCase('virtualShowRSVP/createShow'), [('testEnvt') : '', ('username') : '', ('password') : '', ('stylist') : ''
        , ('hostess') : '', ('cohostess') : '', ('guest1') : '', ('guest2') : '', ('verifyHostess') : '', ('verifyCohostess') : ''
        , ('verifyGuestCount') : '', ('verifyGuest1') : '', ('verifyGuest2') : '', ('cabiTestEnvt') : ''], FailureHandling.STOP_ON_FAILURE)

/***********list update: yes, noreply********/
VSGuest hostessObj = new VSGuest(hostess)

VSGuest cohostessObj = new VSGuest(cohostess)

VSGuest guest1Obj = new VSGuest(guest1)

VSGuest guest2Obj = new VSGuest(guest2)

allList.add(hostessObj)

allList.add(cohostessObj)

allList.add(guest1Obj)

allList.add(guest2Obj)

yesList.add(hostessObj)

yesList.add(cohostessObj)

noreplyList.add(guest1Obj)

noreplyList.add(guest2Obj)

WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor executor = ((driver) as JavascriptExecutor)

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
List<VSGuest> isShowNotStarted = WebUiCommonHelper.findWebElements(findTestObject('virualShowRSVPOR/dashboard/button_start_pre_show'), 
    5)

if (isShowNotStarted.size() > 0) {
    WebElement button_start_pre_show = driver.findElement(By.xpath('//button[contains(text(), \'Start pre-show\')]'))

    executor.executeScript('arguments[0].click();', button_start_pre_show)

    WebUI.delay(3)

    WebElement button_pre_show_sure = driver.findElement(By.xpath('//button[contains(text(), \' sure\')]'))

    executor.executeScript('arguments[0].click();', button_pre_show_sure)
} else {
    WebElement button_re_join_show = driver.findElement(By.xpath('//button[contains(text(), \'Re-join show\')]'))

    executor.executeScript('arguments[0].click();', button_re_join_show)
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

//WebElement enterMail = driver.findElement(By.xpath("//div[@class='form-field']/custom-input/div/input[@name='email']"));
//executor.executeScript("arguments[0].click();", enterMail);
'Login with the hostess'
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'), 
    hostessMail)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Welcome_password'), hostessPass)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue_pass'))

WebUI.delay(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/complete_my_profile_later'), 
    0)) {
    WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Ill complete my profile later'))
}
	
	WebUI.delay(3)

WebUI.verifyElementText(findTestObject('virualShowRSVPOR/Page_cabi Edit Customer Profile/hostessLiveMessage'), 'And we\'re live!')

//List<VSGuest> listElement1 = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'),
//	5)
//
//'Validating invited guest\'s \'Yes\' RSVP\r\n'
//if (listElement1.empty) {
//	println('RSVP is not updated')
//
//	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_RSVP'))
//
//	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_yes'))
//
//	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_SEND'))
//
//	WebUI.delay(4)
//
//	WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h2_Were so glad you can make it.'),
//		'We\'re so glad you can make it.')
//} else {
//	println('RSVP is updated previously')
//}
/***************updating lists*********************/
yesList.add(guest1Obj)

noreplyList.remove(guest1Obj)

WebUI.delay(4)

//WebUI.click(findTestObject('Object Repository/showMicrosite/button_join_the_show'))
/***************updating lists*********************/
guest1Obj.active = true

guest1Obj.micStatus

presentList.add(guest1Obj)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'))

/* --------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Switch to Dashboard---------------------- */
WebUI.switchToWindowIndex(currentTab + 1)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_all'))

//List<VSGuest> actualGuestListWE = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/dashboard/div_all_guests'),
//    5)
//
//for (WebElement we : actualGuestListWE) {
//    println(we.getText())
//}
/*WebUI.click(findTestObject('Object Repository/showMicrosite/button_join_the_show'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'))
*/
WebUI.click(findTestObject('virualShowRSVPOR/dashboard/playVideosButton'))

WebUI.delay(3)

WebUI.click(findTestObject('virualShowRSVPOR/dashboard/playButton'))

WebUI.delay(3)

WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(3)

WebUI.click(findTestObject('virualShowRSVPOR/carouselTestObjects/carouselFav'))

