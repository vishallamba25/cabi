import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods as UtilityMethods

/**********vaiable initialization********************/
String dataFile = 'virtualShowData'
String guest1 = findTestData(dataFile).getValue('guest1', 1)
/****************************************************/

/*WebUI.callTestCase(findTestCase('VirtualShow/createAPhysicalShow'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : '', ('hostess') : ''
        , ('cohostess') : ''], FailureHandling.STOP_ON_FAILURE)*/
WebUI.openBrowser('')
WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.navigateToUrl('https://test18.cliotest.com/backoffice/control/ShowOverview?showId=104711815')

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Send Invitations/a_orders'))
String[] g1Vars= UtilityMethods.splitPersonName(guest1)
String g1Var= UtilityMethods.concat(g1Vars[1], ", ", g1Vars[0])
TestObject buttonPlaceOrder = UtilityMethods.createTestObject('buttoPlaceOrder', '//table[@class=\'show-order-table\']/tbody/tr/td/span[contains(text(), \'', g1Var, '\')]/parent::td/following-sibling::td[1]/button')
WebUI.click(buttonPlaceOrder)
WebUI.delay(3)
String DTYMsg= 'Hooray! This order is eligible for "Direct to You" shipping.'
println  WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/DTY/label_DtyEligibility'))
WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/DTY/label_DtyEligibility'), DTYMsg, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.check(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))
WebUI.delay(3)
WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor executor = ((driver) as JavascriptExecutor)
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Home/a_order_items'), 5))
/////////////////////////////////////////////////
WebUI.click(findTestObject('Object Repository/Page_cabi Retail Store/span_quick_entry'))

WebUI.delay(3)

List<WebElement> emptyCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'), 5)
if (emptyCart.size() > 0) {
	WebUI.click(findTestObject('Object Repository/Page_cabi Personal Store/removeFromCart'))
	println('cart not empty')
	WebUI.delay(5)
}

addOnStyle = findTestData('miscData').getValue('addOnStyle', 1)

addOnStyle2 = findTestData('miscData').getValue('addOnStyle', 2)

///////////////
WebUI.setText(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), addOnStyle)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), Keys.chord(
		Keys.ARROW_DOWN))
WebUI.delay(2)
WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), Keys.chord(
	Keys.ARROW_DOWN))

WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Create Order/input_Manual Discount_stylelookup_0'), Keys.chord(
		Keys.ENTER))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/selectSize'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/span_Add to Cart'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_cabi Order Items/a_next'))
WebUI.delay(3)
WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg1'), 'This order is eligible for "Direct to You" shipping.', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1)
WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg2'), '"Direct to You" order must be paid by credit card or cabi Gift Card.', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1)
WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Shipping/label_DTYMsg3'), '"Direct to You" order can start being placed 2 days before the show date.', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1)
WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_show_loc'), 'disabled', 20, FailureHandling.CONTINUE_ON_FAILURE)
println WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_show_loc'), 5).getAttribute("disabled")
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/check_as_dty_order'), 5))
WebUI.delay(5)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_show_loc'), 'disabled', 'true', 20)
println WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Shipping/select_ship_to_show_loc'), 5).getAttribute("disabled")



/*

*//**********vaiable initialization********************//*
dataFile = 'micrositeData'

guest1Mail = findTestData(dataFile).getValue('guest1Mail', 1)

guest1Pass = findTestData(dataFile).getValue('guest1Pass', 1)

hostessMail = findTestData(dataFile).getValue('hostessMail', 1)

hostessPass = findTestData(dataFile).getValue('hostessPass', 1)

dataFile = 'virtualShowData'

String hostess = findTestData(dataFile).getValue('hostess', 1)

String cohostess = findTestData(dataFile).getValue('cohostess', 1)

//String guest1 = findTestData(dataFile).getValue('guest1', 1)

String guest2 = findTestData(dataFile).getValue('guest2', 1)

String RSTestEnvt = findTestData('envtData').getValue('RSTestEnvt', 1)

BOURL = findTestData('envtData').getValue('BOURL', 1)

*//****************************************************//*
List<WebElement> actualGuestList = new ArrayList<String>()

List<WebElement> yesList = new ArrayList<String>()

List<WebElement> noList = new ArrayList<String>()

List<WebElement> maybeList = new ArrayList<String>()

List<WebElement> noreplyList = new ArrayList<String>()

List<WebElement> presentList = new ArrayList<String>()

List<WebElement> allList = new ArrayList<String>()

*//****************************************************//*
WebUI.callTestCase(findTestCase('VirtualShow/createShow'), [('testEnvt') : '', ('username') : '', ('password') : '', ('stylist') : ''
        , ('hostess') : '', ('cohostess') : '', ('guest1') : '', ('guest2') : '', ('verifyHostess') : '', ('verifyCohostess') : ''
        , ('verifyGuestCount') : '', ('verifyGuest1') : '', ('verifyGuest2') : '', ('cabiTestEnvt') : ''], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.openBrowser('')
WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.navigateToUrl('https://test21.cliotest.com/backoffice/control/VSStylistDashboard?showId=104653490&consultantPartyId=100000042')

*//***************updating lists***-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->creating show-->***//*
VSGuest hostessObj = new VSGuest(hostess)

VSGuest cohostessObj = new VSGuest(cohostess)

VSGuest guest1Obj = new VSGuest(guest1)

VSGuest guest2Obj = new VSGuest(guest2)

//getting fav count from backoffice cust customer profile
*//*****************************tab switching****************//*
WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor executor = ((driver) as JavascriptExecutor)

String currentPage = WebUI.getUrl()

int currentTab = WebUI.getWindowIndex()

driver = DriverFactory.getWebDriver()

executor.executeScript('window.open();')
WebUI.switchToWindowIndex(currentTab + 1)
WebUI.navigateToUrl(BOURL)
WebUI.click(findTestObject('Page_cabi Home/a_Connections'))
WebUI.click(findTestObject('Page_cabi Home/a_Contact Manager'))
hostessObj.favorites = 0 //UtilityMethods.getFavCount(hostess);

cohostessObj.favorites = 0 //UtilityMethods.getFavCount(cohostess);

guest1Obj.favorites = 0 //UtilityMethods.getFavCount(guest1);

guest2Obj.favorites = 0 //UtilityMethods.getFavCount(guest2);

WebUI.closeWindowIndex(currentTab+1);
WebUI.switchToWindowIndex(currentTab)
allList.add(hostessObj)

allList.add(cohostessObj)

allList.add(guest1Obj)

allList.add(guest2Obj)

yesList.add(hostessObj)

yesList.add(cohostessObj)

noreplyList.add(guest1Obj)

noreplyList.add(guest2Obj)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Send Invitations/a_dashboard'))

WebUI.delay(5)

WebUI.switchToFrame(findTestObject('virualShowRSVPOR/dashboard/frame_start_pre_show'), 60)

//WebUI.delay(5)
/////////////////////////
List<WebElement> isShowNotStarted = WebUiCommonHelper.findWebElements(findTestObject('virualShowRSVPOR/dashboard/button_start_pre_show'), 
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

//_________________________________
WebUI.switchToWindowIndex(currentTab + 1)

UtilityMethods.validateGuestsListDashboard(yesList, noList, maybeList, noreplyList, presentList, allList)

println(WebUI.getWindowIndex())

executor.executeScript('window.open();')

WebUI.switchToWindowIndex(currentTab + 2)

println(WebUI.getWindowIndex())

WebUI.callTestCase(findTestCase('TestCaseUtilities/setVHost'), [:], FailureHandling.CONTINUE_ON_FAILURE)

//GlobalVariable.micrositeURL="https://mirandakate.cabitest5.com/show-microsite/104653490/"
//WebUI.navigateToUrl(GlobalVariable.micrositeURL)
String loginURL = UtilityMethods.concat('https://mirandakate.', RSTestEnvt, '.com/?component=account.login-gateway')

WebUI.navigateToUrl(loginURL)

*//*******************************guest login on microsite****************************//*
'Login with the invited guest'
WebUI.delay(3)

WebElement enterMail = driver.findElement(By.xpath("//div[@class='form-field']/custom-input/div/input[@name='email']"));
executor.executeScript("arguments[0].click();", enterMail);
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'), 
    guest1Mail)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Welcome_password'), guest1Pass)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue_pass'))

WebUI.delay(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/complete_my_profile_later'), 
    0)) {
    WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Ill complete my profile later'))
}

WebUI.navigateToUrl(GlobalVariable.micrositeURL)

List<WebElement> userLogin = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/i_user_login'), 
    5)

if (userLogin.size() == 0) {
    WebUI.refresh()
}

List<WebElement> listElement1 = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'), 
    5)

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

*//***************updating lists***-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->***//*
maybeList.add(guest1Obj)

noreplyList.remove(guest1Obj)

//_________________________________
WebUI.switchToWindowIndex(currentTab + 1)

WebUI.delay(2)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'), 
        5))

UtilityMethods.validateGuestsListDashboard(yesList, noList, maybeList, noreplyList, presentList, allList)

WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_no'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_SEND'))

WebUI.delay(4)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h2_Sorry you cant make it.'), 
    'Sorry you can\'t make it.')

*//***************updating lists***-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->***//*
noList.add(guest1Obj)

maybeList.remove(guest1Obj)

//_________________________________
WebUI.switchToWindowIndex(currentTab + 1)

UtilityMethods.validateGuestsListDashboard(yesList, noList, maybeList, noreplyList, presentList, allList)

*//********************************YES and JOIN************************//*
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

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'), 
        5))

//WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'))
*//***************updating lists***-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->***//*
guest1Obj.active = true

guest1Obj.micStatus = 2

guest1Obj.webcamStatus = 2

presentList.add(guest1Obj)

*//***************updating lists***-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->***//*
yesList.add(guest1Obj)

noList.remove(guest1Obj)

//_________________________________
WebUI.switchToWindowIndex(currentTab + 1)

UtilityMethods.validateGuestsListDashboard(yesList, noList, maybeList, noreplyList, presentList, allList)

*//*****************************************************************************//*
*//*****************************************camInfocus Screenshot*************************//*
WebUI.delay(2)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/i_start_webcam'), 
        5))

WebUI.delay(5)

UtilityMethods.takeWebElementScreenshot(findTestObject('Object Repository/virualShowRSVPOR/dashboard/div_infocus_both_images'), 
    'infocus')

WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(5)

UtilityMethods.takeWebElementScreenshot(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_infocus_both_images_microsite'), 
    'infocus')

WebUI.delay(2)

WebUI.switchToWindowIndex(currentTab + 1)

*//*****************************************end camInfocus Screenshot*************************//*
*//*****************************************Check All*************************//*
WebUI.delay(2)

try {
    assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList)
}
catch (org.openqa.selenium.StaleElementReferenceException ex) {
    assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList)
} 

WebUI.delay(2)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/guest_micStatuss'), 
        5))

guest1Obj.micStatus = 1

WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(2)

List<WebElement> guestMicBB = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/guest_mic_brady_bunch'), 
    5)

assert guestMicBB.size() == 0

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.delay(2)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/guest_webcamStatuss_disable'), 
        5))

guest1Obj.webcamStatus = 1

WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(2)

List<WebElement> guestWebcamBB = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/guest_webcam_brady_bunch'), 
    5)

assert guestWebcamBB.size() == 0

*//*****************************************End Check All*************************//*
*//**************************************************************************************************************//*
*//*****************************************Chat***********************************************************//*
*//****************chatting******************//*
WebUI.switchToWindowIndex(currentTab + 1)

WebUI.delay(4)

String iMStylist = 'Hi I am stylistA'

String iMGuest1 = 'Hi I am guest 1A'

String iMGuest2 = 'Hi I am guest 2'

ChatMessage expectedMessage

ChatMessage actualMessage

String stylstName = WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/my_sender_name'))

String g1 = UtilityMethods.splitPersonName(guest1)[0]

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/input_text'), iMStylist)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/chatboard/send_text'))

expectedMessage = new ChatMessage(stylstName, iMStylist)

WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(3)

actualMessage = new ChatMessage(WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/last_sender')), 
WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/last_message')))

assert actualMessage.equals(expectedMessage)

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/input_text'), iMGuest1)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/chatboard/send_text'))

expectedMessage = new ChatMessage(g1, iMGuest1)

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.delay(3)

actualMessage = new ChatMessage(WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/last_sender_stylist')), 
WebUI.getText(findTestObject('Object Repository/virualShowRSVPOR/chatboard/last_message_stylist')))

assert actualMessage.equals(expectedMessage)

*//**************************************************************************************************************//*
*//*****************************************save outfit from carousel***********************************************************//*
WebUI.click(findTestObject('virualShowRSVPOR/dashboard/playVideosButton'))

WebUI.delay(3)

WebUI.click(findTestObject('virualShowRSVPOR/dashboard/playButton'))

WebUI.delay(5)

*//*****************************************video1 Screenshot*************************//*
UtilityMethods.takeWebElementScreenshot(findTestObject('Object Repository/virualShowRSVPOR/dashboard/div_infocus_both_images'), 
    'video1')

*//*****************************************end video1 Screenshot*************************//*
WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(5)

*//*****************************************video2 Screenshot*************************//*
UtilityMethods.takeWebElementScreenshot(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_infocus_both_images_microsite'), 
    'video2')

*//*****************************************end video2 Screenshot*************************//*
WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/carouselTestObjects/carouselSaveOutfit'))

guest1Obj.favorites = (guest1Obj.favorites + 3)

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.delay(15)

try {
    assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList)
}
catch (org.openqa.selenium.StaleElementReferenceException ex) {
    assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList)
} 

WebUI.delay(2)

*//**************************************************************************************************************//*
*//*****************************************add an item to bag from favorites***********************************************************//*
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/button_shopping'))

guest1Obj.webcamStatus = 2

guest1Obj.micStatus = 2

WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_view_my_fav'))

WebUI.delay(3)

WebUI.click(findTestObject('virualShowRSVPOR/Page_Show microsite/div_chat_opened'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_chat_closed'))

WebUI.delay(3)

WebUI.switchToFrame(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/frame_collection_rs'), 60)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_add_to_bag_from_fav'))

WebUI.delay(3)

List<WebElement> noOfOptions = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_no_of_options_for_add_to_bag_item'), 
    5)

for (int i = 1; i <= noOfOptions.size(); i++) {
    WebUI.delay(3)

    TestObject dropDown = UtilityMethods.createTestObject('div_drop_down', '(//div[@class=\'dropdown-toggle\']/div[@class=\'dropdown-button\']/div[@class=\'drop-caret\'])[', 
        Integer.toString(i), ']')

    WebUI.click(dropDown)

    WebUI.delay(3)

    TestObject selectSecondOption = UtilityMethods.createTestObject('div_select_second_option', '(//div/div[@class=\'item-options\']/app-dropdown)[', 
        Integer.toString(i), ']/div/div/div/div/div/div/div[@class=\'dropdown-item\' and position()=\'2\']')

    WebUI.click(selectSecondOption)

    WebUI.delay(3)
}

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_add_to_bag_from_fav_option_selected'))

guest1Obj.favorites = (guest1Obj.favorites - 1)

WebUI.delay(5)

WebUI.switchToDefaultContent()

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.delay(15)

try {
    assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList)
}
catch (org.openqa.selenium.StaleElementReferenceException ex) {
    assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList)
} 

WebUI.delay(2)

*//**************************************************************************************************************//*
*//*****************************************fav from lookbook***********************************************************//*
WebUI.switchToWindowIndex(currentTab + 2)

WebUI.click(findTestObject('virualShowRSVPOR/Page_Show microsite/button_looks'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_first_look'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_first_look_img'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_first_look_item'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_look_save_to_fav'))

guest1Obj.favorites = (guest1Obj.favorites + 1)

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.delay(15)

try {
    assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList)
}
catch (org.openqa.selenium.StaleElementReferenceException ex) {
    assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList)
} 

WebUI.delay(2)

*//**************************************************************************************************************//*
*//*****************************************fav from collection***********************************************************//*
WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_collection'))

WebUI.delay(3)

WebUI.switchToFrame(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/frame_collection_rs'), 60)

////////////iframe
WebDriverWait wait2 = new WebDriverWait(driver, 10)

//wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/h2/a/span[contains(text(), 'Beast Belt')]")));
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_collection_save_to_fav'))

WebUI.delay(3)

guest1Obj.favorites = (guest1Obj.favorites + 1)

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.delay(15)

try {
    assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList)
}
catch (org.openqa.selenium.StaleElementReferenceException ex) {
    assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList)
} 

WebUI.delay(2)

*//**************************************************************************************************************//*
*//*****************************************checkout***********************************************************//*
WebUI.switchToWindowIndex(currentTab + 2)

WebUI.delay(3)

/////collection checkout..............................IMPORTANT.......................
WebUI.switchToFrame(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/frame_collection_rs'), 60)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_first_item_to_buy_from_vs'))

WebUI.delay(3)

////////////
noOfOptions = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_no_of_options_for_checkout'), 
    5)

for (int i = 1; i <= noOfOptions.size(); i++) {
    TestObject dropDown = UtilityMethods.createTestObject('div_drop_down', '(//div[@class=\'add-to-cart-form\']/div[@class=\'attribute ng-scope\']/div[@class=\'input-select ng-scope\']/select)[', 
        String.valueOf(i), ']')

    WebUI.click(dropDown)

    //WebUI.delay(3)
    TestObject selectLastOption = UtilityMethods.createTestObject('div_select_last_option', '(//div[@class=\'add-to-cart-form\']/div[@class=\'attribute ng-scope\']/div[@class=\'input-select ng-scope\']/select)[', 
        String.valueOf(i), ']/option[last()]')

    WebUI.click(selectLastOption)

    WebUI.delay(3)
}

WebUI.delay(3)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/button_add_item_to_bag'), 
        5))

WebUI.delay(3)

////////////
WebUI.click(findTestObject('Object Repository/ReplicatedSite/select_item_size'))
WebUI.delay(5)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/button_add_item_to_bag'), 5));
WebUI.delay(3)
WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_checkout'))

WebUI.delay(3)

WebUI.switchToFrame(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/frame_collection_rs'), 60)

List<WebElement> okGotIt = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_got_it'), 5)
if (okGotIt.size() > 0) {
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_got_it'))
}
WebUI.delay(3)

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/a_checkout_and_add_to_show'), 
        5))

List<WebElement> chkOut = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/a_checkout_and_add_to_show'), 15)
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
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_pay_with_credit'), 
        5))

//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_pay_with_credit'))
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/button_add_another_card'), 
        5))

//WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_add_another_card'))
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/select_credit_card_type'), 
        5))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/select_credit_card_type'))

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_first_name'), 
        5))

WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_first_name'), 'abcd')

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_last_name'), 
        5))

WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_last_name'), 'efgh')

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_card_number'), 
        5))

WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_creditcard_card_number'), '4111111111111111')

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_month'), 
        5))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_month'))

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_year'), 
        5))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_creditcard_expiration_year'))

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_billing_address'), 
        5))

//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_address'))
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'), 
        5))

//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'))
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_billing_location_add_new'), 
        5))

//WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_billing_location_add_new'))
executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_billing_location_mailing'), 
        5))

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

executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/h1_thanks_msg'), 
        5))

WebUI.verifyElementText(findTestObject('Object Repository/ReplicatedSite/h1_thanks_msg'), 'Thanks for placing your order!')

WebUI.delay(2)

guest1Obj.ordered = (guest1Obj.ordered + 3)

guest1Obj.favorites = (guest1Obj.favorites - 1)

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.delay(15)

try {
    assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList)
}
catch (org.openqa.selenium.StaleElementReferenceException ex) {
    assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList)
} 

WebUI.delay(10)

*//**************************************************************************************************************//*
*//*****************************************end session***********************************************************//*
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/button_end_session'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/button_end_session_sure'))

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/dashboard/p_show_is_over'), 'This show is not active.')*/

