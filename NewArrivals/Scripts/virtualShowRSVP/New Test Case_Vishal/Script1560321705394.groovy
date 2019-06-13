import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('virtualShowRSVP/createShow'), [('testEnvt') : '', ('username') : '', ('password') : '', ('stylist') : ''
        , ('hostess') : '', ('cohostess') : '', ('guest1') : '', ('guest2') : '', ('verifyHostess') : '', ('verifyCohostess') : ''
        , ('verifyGuestCount') : '', ('verifyGuest1') : '', ('verifyGuest2') : '', ('cabiTestEnvt') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.back()

WebUI.click(findTestObject('virualShowRSVPOR/Page_Show microsite/dashboardTab'))

String dataFile = 'virtualShowData'

stylist = findTestData(dataFile).getValue('stylist', 1)

hostess = findTestData(dataFile).getValue('hostess', 1)

cohostess = findTestData(dataFile).getValue('cohostess', 1)

guest1 = findTestData(dataFile).getValue('guest1', 1)

guest2 = findTestData(dataFile).getValue('guest2', 1)

WebUI.delay(5)

WebUI.switchToFrame(findTestObject('virualShowRSVPOR/dashboard/frame_start_pre_show'), 60)

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('virualShowRSVPOR/Page_Show microsite/neoGuest1'), guest1)

