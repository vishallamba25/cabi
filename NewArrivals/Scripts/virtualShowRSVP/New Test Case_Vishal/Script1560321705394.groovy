import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String dataFile = 'virtualShowData'

stylist = findTestData(dataFile).getValue('stylist', 1)

hostess = findTestData(dataFile).getValue('hostess', 1)

cohostess = findTestData(dataFile).getValue('cohostess', 1)

guest1 = findTestData(dataFile).getValue('guest1', 1)

guest2 = findTestData(dataFile).getValue('guest2', 1)

//WebUI.callTestCase(findTestCase('virtualShowRSVP/createShow'), [('testEnvt') : '', ('username') : '', ('password') : '', ('stylist') : ''
//        , ('hostess') : '', ('cohostess') : '', ('guest1') : '', ('guest2') : '', ('verifyHostess') : '', ('verifyCohostess') : ''
//        , ('verifyGuestCount') : '', ('verifyGuest1') : '', ('verifyGuest2') : '', ('cabiTestEnvt') : ''], FailureHandling.STOP_ON_FAILURE)
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('NewArrival/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://test19.cliotest.com/backoffice/control/VSStylistDashboard?showId=104597108&consultantPartyId=100000042')

WebUI.delay(3)

//WebUI.back()

WebUI.click(findTestObject('virualShowRSVPOR/Page_Show microsite/dashboardTab'))

WebUI.delay(5)

WebUI.switchToFrame(findTestObject('virualShowRSVPOR/dashboard/frame_start_pre_show'), 60)

WebUI.delay(5)

List<WebElement> listElement = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/guestList'),
	5)

listElement.get(1).getText().equalsIgnoreCase(hostess)

listElement.get(2).getText().equalsIgnoreCase(cohostess)

listElement.get(3).getText().equalsIgnoreCase(guest1)

listElement.get(3).getText().equalsIgnoreCase(guest2)

//WebUI.verifyElementText(findTestObject('virualShowRSVPOR/Page_Show microsite/neoGuest1'), guest1)

