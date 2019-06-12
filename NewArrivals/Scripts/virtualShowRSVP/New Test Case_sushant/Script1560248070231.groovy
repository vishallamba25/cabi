import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

/*WebUI.callTestCase(findTestCase('virtualShowRSVP/createShow'), [('testEnvt') : '', ('username') : '', ('password') : '', ('stylist') : ''
        , ('hostess') : '', ('cohostess') : '', ('guest1') : '', ('guest2') : '', ('verifyHostess') : '', ('verifyCohostess') : ''
        , ('verifyGuestCount') : '', ('verifyGuest1') : '', ('verifyGuest2') : '', ('cabiTestEnvt') : ''], FailureHandling.STOP_ON_FAILURE)
*/
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.callTestCase(findTestCase('NewArrival/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('https://test19.cliotest.com/backoffice/control/VSStylistDashboard?showId=104596896&consultantPartyId=100000042')

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Show - Send Invitations/a_dashboard'))

WebUI.delay(5)

WebUI.switchToFrame(findTestObject('virualShowRSVPOR/dashboard/frame_start_pre_show'), 60)

WebUI.delay(5)

/////////////////////////
List<WebElement> isShowNotStarted = WebUiCommonHelper.findWebElements(findTestObject('virualShowRSVPOR/dashboard/button_start_pre_show'),5)
if (isShowNotStarted.isEmpty()) {
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Create Show - Set Hostess/validate_hostess_address'))
	WebUI.delay(5)
}
/////////////////////////

if(WebUI.verifyElementPresent(findTestObject('virualShowRSVPOR/dashboard/button_start_pre_show'), 5, FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('virualShowRSVPOR/dashboard/button_start_pre_show'))
	WebUI.click(findTestObject('virualShowRSVPOR/dashboard/button_pre_show_sure'))
}
else{
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/button_re_join_show'))
}




WebUI.acceptAlert()

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'))

/*****************************tab switching****************/
String currentPage = WebUI.getUrl()
int currentTab = WebUI.getWindowIndex()

WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor js = ((driver) as JavascriptExecutor)
js.executeScript('window.open();')

WebUI.switchToWindowIndex(currentTab + 1)
WebUI.navigateToUrl(GlobalVariable.micrositeURL)
WebUI.delay(3)
WebUI.switchToWindowIndex(currentTab)
WebUI.delay(3)
WebUI.switchToWindowIndex(currentTab+1)
/**********************************************************/






