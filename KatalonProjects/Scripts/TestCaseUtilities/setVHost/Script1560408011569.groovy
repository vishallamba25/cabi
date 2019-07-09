import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods

/**********vaiable initialization********************/
ofbizURL = findTestData('envtData').getValue('ofbizURL', 1)
ofbizUser = findTestData('credData').getValue('ofbizuser', 1)
ofbizPass = findTestData('credData').getValue('ofbizpass', 1)
vhostTarget = findTestData('envtData').getValue('vhostTarget', 1)
/****************************************************/
//WebUI.openBrowser('')
WebUI.navigateToUrl(ofbizURL)
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_/input_Username_username'), ofbizUser)
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_/input_Password_password'), ofbizPass)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_/input_Password_Submit'))
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_/a_Set Vhost'))
//select[@name='Target']/option[contains(text(), 'virtual_cabitest21')]
WebUI.click(UtilityMethods.createTestObject("select_target", "//select[@name='Target']/option[contains(text(), '", vhostTarget, "')]"))
//WebUI.selectOptionByValue(findTestObject('virualShowRSVPOR/Page_/select_cabitest'), '19', true)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_/input'))