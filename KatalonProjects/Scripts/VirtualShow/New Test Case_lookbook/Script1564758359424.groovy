import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods as UtilityMethods
import commonUtility.VSGuest as VSGuest
import internal.GlobalVariable as GlobalVariable

/**********vaiable initialization********************/
String dataFile = 'micrositeData'

guest1Mail = findTestData(dataFile).getValue('guest1Mail', 1)

guest1Pass = findTestData(dataFile).getValue('guest1Pass', 1)

dataFile = 'virtualShowData'

String hostess = findTestData(dataFile).getValue('hostess', 1)

String cohostess = findTestData(dataFile).getValue('cohostess', 1)

String guest1 = findTestData(dataFile).getValue('guest1', 1)

String guest2 = findTestData(dataFile).getValue('guest2', 1)

String RSTestEnvt = findTestData('envtData').getValue('RSTestEnvt', 1)

BOURL = findTestData('envtData').getValue('BOURL', 1)

/****************************************************/
List<VSGuest> actualGuestList = new ArrayList()

List<VSGuest> yesList = new ArrayList()

List<VSGuest> noList = new ArrayList()

List<VSGuest> maybeList = new ArrayList()

List<VSGuest> noreplyList = new ArrayList()

List<VSGuest> presentList = new ArrayList()

List<VSGuest> allList = new ArrayList()

/****************************************************/
WebUI.callTestCase(findTestCase('VirtualShow/createShow'), [('testEnvt') : '', ('username') : '', ('password') : '', ('stylist') : ''
        , ('hostess') : '', ('cohostess') : '', ('guest1') : '', ('guest2') : '', ('verifyHostess') : '', ('verifyCohostess') : ''
        , ('verifyGuestCount') : '', ('verifyGuest1') : '', ('verifyGuest2') : '', ('cabiTestEnvt') : ''], FailureHandling.)

/*WebUI.openBrowser('')


WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
    FailureHandling.)

WebUI.navigateToUrl('https://test21.cliotest.com/backoffice/control/VSStylistDashboard?showId=104658676&consultantPartyId=100000042')
*/
/*****************************tab switching****************/
WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor executor = ((driver) as JavascriptExecutor)

String currentPage = WebUI.getUrl()

int currentTab = WebUI.getWindowIndex()

driver = DriverFactory.getWebDriver()

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

WebUI.switchToWindowIndex(currentTab + 1)

println(WebUI.getWindowIndex())

executor.executeScript('window.open();')

WebUI.switchToWindowIndex(currentTab + 2)

println(WebUI.getWindowIndex())

WebUI.callTestCase(findTestCase('TestCaseUtilities/setVHost'), [:], FailureHandling.)

//GlobalVariable.micrositeURL = 'https://mirandakate.cabitest5.com/show-microsite/104658676/'

//WebUI.navigateToUrl(GlobalVariable.micrositeURL)
String loginURL = UtilityMethods.concat('https://mirandakate.', RSTestEnvt, '.com/?component=account.login-gateway')

WebUI.navigateToUrl(loginURL)

/*******************************guest login on microsite****************************/
'Login with the invited guest'
WebElement enterMail = driver.findElement(By.xpath('//div[@class=\'form-field\']/custom-input/div/input[@name=\'email\']'))

executor.executeScript('arguments[0].click();', enterMail)

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'), 
    guest1Mail)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Welcome_password'), guest1Pass)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue_pass'))

WebUI.delay(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/complete_my_profile_later'), 
    0)) {
    WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Ill complete my profile later'))
}

WebUI.navigateToUrl(GlobalVariable.micrositeURL)

List<VSGuest> userLogin = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/i_user_login'), 
    5)

if (userLogin.size() == 0) {
    WebUI.refresh()
}


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

WebUI.click(findTestObject('Object Repository/showMicrosite/button_join_the_show'))
WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'))

WebUI.switchToWindowIndex(currentTab + 1)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'))

/****************lookbook collection******************/
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/button_play_videos'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/button_shopping'))

WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(2)

WebUI.click(findTestObject('virualShowRSVPOR/Page_Show microsite/button_looks'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_first_look'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_first_look_img'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_first_look_item'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_look_save_to_fav'))

/////end lookbook
WebUI.switchToWindowIndex(currentTab + 1)

WebUI.delay(2)

WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_collection'))

WebUI.delay(3)

WebUI.switchToFrame(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/frame_collection_rs'), 60)

////////////iframe
WebDriverWait wait2 = new WebDriverWait(driver, 10);
wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/h2/a/span[contains(text(), 'Beast Belt')]")));
WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_first_item_to_buy'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/select_item_size'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_collection_save_to_fav'))

WebUI.delay(3)

/////end collection fav
WebUI.switchToWindowIndex(currentTab + 1)

WebUI.delay(2)

WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(3)

/////collection checkout..............................IMPORTANT.......................
WebUI.switchToFrame(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/frame_collection_rs'), 60)
WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_add_item_to_bag'))

WebUI.delay(3)

WebUI.switchToDefaultContent()
WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_checkout'))

WebUI.delay(3)
WebUI.switchToFrame(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/frame_collection_rs'), 60)
List<WebElement> okGotIt = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_got_it'), 5)
if (okGotIt.size() > 0) {
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_got_it'))
}

List<WebElement> chkOut = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/button_checkout'), 5)
if (chkOut.size() > 0) {
	WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_checkout'))
}
else{
	WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_checkout_yourself'))
	WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_checkout_yourself_yes'))
}


WebUI.delay(10)
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_other_address'))
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_my_address'))
WebUI.waitForElementClickable(findTestObject('ReplicatedSite/button_save_and_continue'), 60)

driver = DriverFactory.getWebDriver()

element = driver.findElement(By.xpath('(//button/span[contains(text(), \'Save and Continue\')])[1]'))

executor.executeScript('arguments[0].click();', element)

WebUI.delay(3)

/////////////////credit card
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_pay_with_credit'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_add_another_card'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/select_credit_card_type'))

WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_first_name'), 'abcd')

WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_last_name'), 'efgh')

WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_card_number'), '4111111111111111')

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_month'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_year'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_address'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_add_new'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'))

driver = DriverFactory.getWebDriver()

element = driver.findElement(By.xpath('(//button[@type=\'submit\']/span[contains(text(), \'Save\')])[2]'))

actions = new Actions(driver)

actions.moveToElement(element).click().build().perform()

WebUI.delay(10)

WebUI.waitForElementClickable(findTestObject('ReplicatedSite/button_save_and_continue_2'), 60)

driver = DriverFactory.getWebDriver()

element = driver.findElement(By.xpath('(//button/span[contains(text(), \'Save and Continue\')])[2]'))

executor.executeScript('arguments[0].click();', element)

WebUI.delay(5)

WebUI.waitForElementClickable(findTestObject('Object Repository/ReplicatedSite/span_complete_order'), 30)

element = driver.findElement(By.xpath('//span[contains(text(), \'COMPLETE ORDER\')]'))

executor.executeScript('arguments[0].click();', element)

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/ReplicatedSite/h1_thanks_msg'), 'Thanks for placing your order!')

String orderID = WebUI.getText(findTestObject('Object Repository/ReplicatedSite/span_rs_orderid'))