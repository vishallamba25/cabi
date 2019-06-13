import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**********vaiable initialization********************/
String dataFile="micrositeData"
ofbizURL = findTestData(dataFile).getValue('ofbizURL', 1)
ofbizUser = findTestData(dataFile).getValue('ofbizUser', 1)
ofbizPass = findTestData(dataFile).getValue('ofbizPass', 1)
vhostTarget = findTestData(dataFile).getValue('vhostTarget', 1)
/****************************************************/

WebUI.navigateToUrl(ofbizURL)
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_/input_Username_username'), ofbizUser)
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_/input_Password_password'), ofbizPass)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_/input_Password_Submit'))
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_/a_Set Vhost'))
WebUI.selectOptionByValue(findTestObject('virualShowRSVPOR/Page_/select_cabitest'), '19', true)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_/input'))