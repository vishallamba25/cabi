import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DateFormat
import java.text.SimpleDateFormat

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods

BOURL = findTestData('envtData').getValue('BOURL', 1)
BOuser = findTestData('credData').getValue('BOuser', 1)
BOpass = findTestData('credData').getValue('BOpass', 1)

WebUI.openBrowser('')

//WebUI.maximizeWindow()

WebUI.navigateToUrl(BOURL)

List<WebElement> logOut = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Home/log_out'), 
    1)

if (logOut.size() == 0) {
	
	
	
    WebUI.setText(findTestObject('Page_cabi/input_Welcome to_USERNAME'), BOuser)

    WebUI.setText(findTestObject('Object Repository/Page_cabi/input_Welcome to_PASSWORD'), BOpass)

    WebUI.click(findTestObject('Object Repository/Page_cabi/input_Welcome to_consultantLogin'))
}

/*WebUI.waitForElementPresent(findTestObject('Object Repository/Page_cabi Home/log_out'), 3)
WebUI.click(findTestObject('Object Repository/Page_cabi/span_username'))
*/
WebUI.delay(3)

