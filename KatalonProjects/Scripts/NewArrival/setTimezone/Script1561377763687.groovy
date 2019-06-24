import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
<<<<<<< HEAD:KatalonProjects/Scripts/NewArrival/newArrivalsSetTimezone/Script1556088493812.groovy
=======

import commonUtility.UtilityMethods
>>>>>>> 9065244ac13450ebfce5e098cfbd1cf538b0d153:KatalonProjects/Scripts/NewArrival/setTimezone/Script1561377763687.groovy

not_run: WebUI.openBrowser('')

not_run: WebUI.maximizeWindow()

ofbizURL = findTestData('credData').getValue('ofbizURL', 1)

ofbizuser = findTestData('credData').getValue('ofbizuser', 1)

ofbizpass = findTestData('credData').getValue('ofbizpass', 1)

WebUI.navigateToUrl(ofbizURL)

WebUI.setText(findTestObject('Page_/input_Username_username'), ofbizuser)

WebUI.setText(findTestObject('Page_/input_Password_password'), ofbizpass)

WebUI.click(findTestObject('Page_/input_Password_Submit'))

WebUI.click(findTestObject('Object Repository/Page_/a_Clock set'))

WebUI.click(UtilityMethods.createTestObject("select_target", "//select[@name='Target']/option[contains(text(), '", serverTarget, "')]"))

WebUI.click(findTestObject('Page_/thisDateAndTime'))

WebUI.setText(findTestObject('Object Repository/Page_/setTargetTime'), timeZone)

WebUI.click(findTestObject('Object Repository/Page_/input'))

WebUI.delay(10)

not_run: WebUI.closeBrowser()

