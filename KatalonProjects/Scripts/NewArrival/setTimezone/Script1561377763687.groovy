import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import commonUtility.UtilityMethods as UtilityMethods

WebUI.openBrowser('')

not_run: WebUI.maximizeWindow()

ofbizURL = findTestData('envtData').getValue('ofbizURL', 1)

ofbizuser = findTestData('credData').getValue('ofbizuser', 1)

ofbizpass = findTestData('credData').getValue('ofbizpass', 1)

WebUI.navigateToUrl(ofbizURL)

WebUI.setText(findTestObject('Page_/input_Username_username'), ofbizuser)

WebUI.setText(findTestObject('Page_/input_Password_password'), ofbizpass)

WebUI.click(findTestObject('Page_/input_Password_Submit'))

WebUI.click(findTestObject('Object Repository/Page_/a_Clock set'))
//clockServerTarget='test4ca'
TestObject cst=  UtilityMethods.createTestObject('select_target', '//select[@name=\'Target\']/option[contains(text(), \'', clockServerTarget, '\')]')
println clockServerTarget
WebUI.click(cst)

WebUI.click(findTestObject('Page_/thisDateAndTime'))

WebUI.setText(findTestObject('Object Repository/Page_/setTargetTime'), timeZone)

WebUI.click(findTestObject('Object Repository/Page_/input'))

WebUI.delay(10)

not_run: WebUI.closeBrowser()

