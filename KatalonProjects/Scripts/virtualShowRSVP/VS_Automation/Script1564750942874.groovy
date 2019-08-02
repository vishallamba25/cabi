import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.ChatMessage
import commonUtility.UtilityMethods
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
String RSTestEnvt= findTestData('envtData').getValue('RSTestEnvt', 1)

BOURL = findTestData('envtData').getValue('BOURL', 1)
/****************************************************/
List<VSGuest> actualGuestList= new ArrayList<>()
List<VSGuest> yesList= new ArrayList<>()
List<VSGuest> noList= new ArrayList<>()
List<VSGuest> maybeList= new ArrayList<>()
List<VSGuest> noreplyList= new ArrayList<>()
List<VSGuest> presentList= new ArrayList<>()
List<VSGuest> allList= new ArrayList<>()
/****************************************************/



WebUI.callTestCase(findTestCase('virtualShowRSVP/createShow'), [('testEnvt') : '', ('username') : '', ('password') : '', ('stylist') : ''
, ('hostess') : '', ('cohostess') : '', ('guest1') : '', ('guest2') : '', ('verifyHostess') : '', ('verifyCohostess') : ''
, ('verifyGuestCount') : '', ('verifyGuest1') : '', ('verifyGuest2') : '', ('cabiTestEnvt') : ''], FailureHandling.STOP_ON_FAILURE)

/*WebUI.openBrowser('')
WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('https://test21.cliotest.com/backoffice/control/VSStylistDashboard?showId=104653490&consultantPartyId=100000042')
*/
/***************updating lists***-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->creating show-->***/
VSGuest hostessObj= new VSGuest(hostess)
VSGuest cohostessObj= new VSGuest(cohostess)
VSGuest guest1Obj= new VSGuest(guest1)
VSGuest guest2Obj= new VSGuest(guest2)
//getting fav count from backoffice cust customer profile
/*****************************tab switching****************/
WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor executor = (JavascriptExecutor)driver;
String currentPage = WebUI.getUrl()
int currentTab = WebUI.getWindowIndex()
driver = DriverFactory.getWebDriver()
/*executor.executeScript('window.open();')
WebUI.switchToWindowIndex(currentTab + 1)
WebUI.navigateToUrl(BOURL)
WebUI.click(findTestObject('Page_cabi Home/a_Connections'))
WebUI.click(findTestObject('Page_cabi Home/a_Contact Manager'))*/

hostessObj.favorites=0//UtilityMethods.getFavCount(hostess);
cohostessObj.favorites=0//UtilityMethods.getFavCount(cohostess);
guest1Obj.favorites=0//UtilityMethods.getFavCount(guest1);
guest2Obj.favorites=0//UtilityMethods.getFavCount(guest2);
/*WebUI.closeWindowIndex(currentTab+1);
WebUI.switchToWindowIndex(currentTab)*/

allList.add(hostessObj); allList.add(cohostessObj); allList.add(guest1Obj); allList.add(guest2Obj)
yesList.add(hostessObj); yesList.add(cohostessObj);
noreplyList.add(guest1Obj); noreplyList.add(guest2Obj);





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
//_________________________________
WebUI.switchToWindowIndex(currentTab + 1)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
WebUI.delay(2)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply_1'), 5));
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply'), allList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply'), allList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_yes'), yesList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_yes'), yesList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_no'), noList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_no'), noList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_maybe'), maybeList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_maybe'), maybeList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_notreply'), noreplyList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_notreply'), noreplyList);
}
//_________________________________



println WebUI.getWindowIndex()
executor.executeScript('window.open();')
WebUI.switchToWindowIndex(currentTab + 2)
println WebUI.getWindowIndex()

WebUI.callTestCase(findTestCase('TestCaseUtilities/setVHost'), [:], FailureHandling.STOP_ON_FAILURE)

//GlobalVariable.micrositeURL="https://mirandakate.cabitest5.com/show-microsite/104653490/"
//WebUI.navigateToUrl(GlobalVariable.micrositeURL)
String loginURL= UtilityMethods.concat("https://mirandakate.", RSTestEnvt, ".com/?component=account.login-gateway")
WebUI.navigateToUrl(loginURL)

/*******************************guest login on microsite****************************/
'Login with the invited guest'
'Login with the invited guest'
WebUI.delay(3)
/*WebElement enterMail = driver.findElement(By.xpath("//div[@class='form-field']/custom-input/div/input[@name='email']"));
executor.executeScript("arguments[0].click();", enterMail);*/
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'),	guest1Mail)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Welcome_password'), guest1Pass)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue_pass'))
WebUI.delay(5)
if (WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/complete_my_profile_later'), 0)) {
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Ill complete my profile later'))
}

WebUI.navigateToUrl(GlobalVariable.micrositeURL)


List<WebElement> userLogin = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/i_user_login'), 5)
if(userLogin.size()==0){
WebUI.refresh();
}

List<WebElement> listElement1 = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'), 5)
'Validating invited guest\'s \'Yes\' RSVP\r\n'
if (listElement1.empty) {
println('RSVP is not updated')
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_RSVP'))
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_maybe'))
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_SEND'))
WebUI.delay(4)
WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h2_We hope youll be able to attend.'),
'We hope you\'ll be able to attend.')
} else {
println('RSVP is updated previously')
}
/***************updating lists***-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->***/
maybeList.add(guest1Obj);
noreplyList.remove(guest1Obj)
//_________________________________
WebUI.switchToWindowIndex(currentTab + 1)
WebUI.delay(2)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'), 5));
//WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'))

try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
WebUI.delay(2)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply_1'), 5));
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply'), allList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply'), allList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_yes'), yesList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_yes'), yesList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_no'), noList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_no'), noList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_maybe'), maybeList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_maybe'), maybeList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_notreply'), noreplyList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_notreply'), noreplyList);
}
//_________________________________

WebUI.switchToWindowIndex(currentTab + 2)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'))
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_no'))
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_SEND'))
WebUI.delay(4)
WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h2_Sorry you cant make it.'),
'Sorry you can\'t make it.')
/***************updating lists***-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->***/
noList.add(guest1Obj);
maybeList.remove(guest1Obj)
//_________________________________
WebUI.switchToWindowIndex(currentTab + 1)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
WebUI.delay(2)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply_1'), 5));
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply'), allList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply'), allList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_yes'), yesList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_yes'), yesList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_no'), noList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_no'), noList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_maybe'), maybeList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_maybe'), maybeList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_notreply'), noreplyList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_notreply'), noreplyList);
}
//_________________________________

/********************************YES and JOIN************************/
WebUI.switchToWindowIndex(currentTab + 2)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'))
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_yes'))
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_SEND'))
WebUI.delay(4)
WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h2_Were so glad you can make it.'),
		'We\'re so glad you can make it.')
WebUI.delay(4)
WebUI.click(findTestObject('Object Repository/showMicrosite/button_join_the_show'))
WebUI.delay(3)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'), 5));
//WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'))
/***************updating lists***-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->***/
guest1Obj.active=true;
guest1Obj.micStatus=2;
guest1Obj.webcamStatus=2;
presentList.add(guest1Obj)
/***************updating lists***-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->***/
yesList.add(guest1Obj);
noList.remove(guest1Obj)
//_________________________________
WebUI.switchToWindowIndex(currentTab + 1)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
WebUI.delay(2)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply_1'), 5));
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply'), allList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply'), allList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_yes'), yesList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_yes'), yesList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_no'), noList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_no'), noList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_maybe'), maybeList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_maybe'), maybeList);
}
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_notreply'), noreplyList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_notreply'), noreplyList);
}
//_________________________________

/*****************************************Check All*************************/
WebUI.delay(2)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
WebUI.delay(2)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/guest_micStatuss'), 5));
guest1Obj.micStatus=1;

WebUI.switchToWindowIndex(currentTab + 2)
WebUI.delay(2)
List<WebElement> guestMicBB = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/guest_mic_brady_bunch'), 5)
assert guestMicBB.size()==0;
WebUI.switchToWindowIndex(currentTab + 1)
WebUI.delay(2)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/guest_webcamStatuss_disable'), 5));
guest1Obj.webcamStatus=1;
WebUI.switchToWindowIndex(currentTab + 2)
WebUI.delay(2)
List<WebElement> guestWebcamBB = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/guest_webcam_brady_bunch'), 5)
assert guestWebcamBB.size()==0;
/*****************************************End Check All*************************/
/**************************************************************************************************************/
/*****************************************Chat***********************************************************/
/****************chatting******************/
WebUI.switchToWindowIndex(currentTab + 1)
WebUI.delay(4)
String iMStylist="Hi I am stylistA"
String iMGuest1="Hi I am guest 1A"
String iMGuest2="Hi I am guest 2"
ChatMessage expectedMessage;
ChatMessage actualMessage;
String stylstName= WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/my_sender_name'))
String g1= (UtilityMethods.splitPersonName(guest1))[0]

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/input_text'), iMStylist)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/chatboard/send_text'))
expectedMessage= new ChatMessage(stylstName, iMStylist)

WebUI.switchToWindowIndex(currentTab + 2)
WebUI.delay(3)
actualMessage= new ChatMessage(WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/last_sender')), WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/last_message')))
assert actualMessage.equals(expectedMessage)
WebUI.delay(2)
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/input_text'), iMGuest1)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/chatboard/send_text'))

expectedMessage= new ChatMessage(g1, iMGuest1)

WebUI.switchToWindowIndex(currentTab + 1)
WebUI.delay(3)
actualMessage= new ChatMessage(WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/last_sender_stylist')), WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/last_message_stylist')))
assert actualMessage.equals(expectedMessage)
/**************************************************************************************************************/
/*****************************************save outfit from carousel***********************************************************/
WebUI.click(findTestObject('virualShowRSVPOR/dashboard/playVideosButton'))
WebUI.delay(3)
WebUI.click(findTestObject('virualShowRSVPOR/dashboard/playButton'))
WebUI.delay(3)
WebUI.switchToWindowIndex(currentTab + 2)
WebUI.delay(10)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/carouselTestObjects/carouselSaveOutfit'))
guest1Obj.favorites= guest1Obj.favorites+3;
WebUI.switchToWindowIndex(currentTab + 1)
WebUI.delay(15)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
WebUI.delay(2)
/**************************************************************************************************************/
/*****************************************fav from lookbook***********************************************************/
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/button_shopping'))
guest1Obj.webcamStatus=2;
guest1Obj.micStatus=2;
WebUI.switchToWindowIndex(currentTab + 2)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_lookbook'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_first_look'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_first_look_img'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_first_look_item'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_look_save_to_fav'))
guest1Obj.favorites= guest1Obj.favorites+1;
WebUI.switchToWindowIndex(currentTab + 1)
WebUI.delay(15)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
WebUI.delay(2)
/**************************************************************************************************************/
/*****************************************fav from collection***********************************************************/
WebUI.switchToWindowIndex(currentTab + 2)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_collection'))
WebUI.delay(3)
WebUI.switchToFrame(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/frame_collection_rs'), 60)
////////////iframe


WebDriverWait wait2 = new WebDriverWait(driver, 10);
wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/h2/a/span[contains(text(), 'Beast Belt')]")));
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_collection_save_to_fav'))
WebUI.delay(3)
guest1Obj.favorites= guest1Obj.favorites+1;
WebUI.switchToWindowIndex(currentTab + 1)
WebUI.delay(15)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
WebUI.delay(2)
/**************************************************************************************************************/
/*****************************************checkout***********************************************************/
WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(3)

/////collection checkout..............................IMPORTANT.......................
WebUI.switchToFrame(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/frame_collection_rs'), 60)
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_first_item_to_buy_from_vs'))
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/ReplicatedSite/select_item_size'))
WebUI.delay(5)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/button_add_item_to_bag'), 5));
WebUI.delay(3)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_checkout'))

WebUI.delay(3)
WebUI.switchToFrame(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/frame_collection_rs'), 60)
/*List<WebElement> okGotIt = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_got_it'), 5)
if (okGotIt.size() > 0) {
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_got_it'))
}*/
WebUI.delay(3)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/a_checkout_and_add_to_show'), 5));
/*List<WebElement> chkOut = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/a_checkout_and_add_to_show'), 15)
if (chkOut.size() > 0) {
	//WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_checkout_and_add_to_show'))
	executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/a_checkout_and_add_to_show'), 5));
}
else{
	WebUI.switchToDefaultContent()
	executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/div_checkout'), 5));
	WebUI.delay(3)
	WebUI.switchToFrame(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/frame_collection_rs'), 60)
	executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/a_checkout_and_add_to_show'), 5));
}*/


WebUI.delay(10)
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_other_address'))
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_my_address'))
WebUI.waitForElementClickable(findTestObject('ReplicatedSite/button_save_and_continue'), 60)

driver = DriverFactory.getWebDriver()

element = driver.findElement(By.xpath('(//button/span[contains(text(), \'Save and Continue\')])[1]'))

executor.executeScript('arguments[0].click();', element)

WebUI.delay(3)

/////////////////credit card
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_pay_with_credit'), 5));
//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_pay_with_credit'))

executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/button_add_another_card'), 5));
//WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_add_another_card'))

executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/select_credit_card_type'), 5));
WebUI.click(findTestObject('Object Repository/ReplicatedSite/select_credit_card_type'))

executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_first_name'), 5));
WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_first_name'), 'abcd')


executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_last_name'), 5));
WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_last_name'), 'efgh')


executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_card_number'), 5));
WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_card_number'), '4111111111111111')


executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_month'), 5));
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_month'))

executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_year'), 5));
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_year'))

executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_billing_address'), 5));
//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_address'))

executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'), 5));
//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'))

executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_billing_location_add_new'), 5));
//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_add_new'))

executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'), 5));
//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'))

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

executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/h1_thanks_msg'), 5));
WebUI.verifyElementText(findTestObject('Object Repository/ReplicatedSite/h1_thanks_msg'), 'Thanks for placing your order!')

WebUI.delay(2)
guest1Obj.ordered= guest1Obj.ordered+1;
guest1Obj.favorites= guest1Obj.favorites-1;
WebUI.switchToWindowIndex(currentTab + 1)
WebUI.delay(15)
try {
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
catch(org.openqa.selenium.StaleElementReferenceException ex)
{
	assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
}
WebUI.delay(10)
/**************************************************************************************************************/
/*****************************************end session***********************************************************/
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/button_end_session'))
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/button_end_session_sure'))
WebUI.delay(3)
WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/dashboard/p_show_is_over'), 'This show is not active.')












