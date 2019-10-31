import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement
import org.testng.asserts.SoftAssert

import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(WebUiCommonHelper.findWebElement(findTestObject('Object Repository/showOrderShipping/input_decline_hostess_benefit'),30)))
WebUI.delay(1)
WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(WebUiCommonHelper.findWebElement(findTestObject('Object Repository/showOrderShipping/input_decline_cohostess_benefit'),30)))
WebUI.delay(1)
WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(WebUiCommonHelper.findWebElement(findTestObject('Object Repository/showOrderShipping/button_close_the_show'),30)))
WebUI.delay(2)
WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(WebUiCommonHelper.findWebElement(findTestObject('Object Repository/showOrderShipping/button_close_the_show_confirm'),30)))

List<WebElement> yesCloseShow = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/showOrderShipping/button_close_the_show_yes'), 5)
if (yesCloseShow.size() > 0){
	WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(yesCloseShow))
}

SoftAssert sa = new SoftAssert()
String showCloseMsg= WebUI.getText(findTestObject('Object Repository/showOrderShipping/text_show_close_msg'))
sa.assertTrue(false)