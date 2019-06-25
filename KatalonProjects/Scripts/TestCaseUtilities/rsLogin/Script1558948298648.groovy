import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

RSURL = findTestData('credData').getValue('RSURL', 1)

RSuser = findTestData('credData').getValue('RSuser', 1)

RSpass = findTestData('credData').getValue('RSpass', 1)

BSURL = findTestData('credData').getValue('BSURL', 1)

/*WebUI.openBrowser('')
WebUI.callTestCase(findTestCase('TestCaseUtilities/setVHost'), [:], FailureHandling.STOP_ON_FAILURE)*/

//WebUI.maximizeWindow()
WebUI.navigateToUrl(RSURL)

//WebUI.delay(10)
WebUI.click(findTestObject('ReplicatedSite/rs_Page_Trendy/i_user_login'))

WebUI.setText(findTestObject('ReplicatedSite/rs_Page_Trendy/input_Sign in  Create account_email'), RSuser)

WebUI.click(findTestObject('ReplicatedSite/rs_Page_Trendy/button_Continue'))

WebUI.setText(findTestObject('ReplicatedSite/rs_Page_Trendy/input_Welcome_password'), RSpass)

WebUI.click(findTestObject('ReplicatedSite/rs_Page_Trendy/button_Continue'))

List<WebElement> completeProfileLater = WebUiCommonHelper.findWebElements(findTestObject('ReplicatedSite/rs_Page_Trendy/completeProfileLater'), 5)
if (completeProfileLater.size() > 0) {
    WebUI.click(findTestObject('ReplicatedSite/rs_Page_Trendy/completeProfileLater'))
}

if(WebUI.getUrl() == BSURL){
	WebUI.back()
}

