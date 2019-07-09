import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData


import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


/**********vaiable initialization********************/
String dataFile2 = "micrositeData"
guest1Mail = findTestData(dataFile2).getValue('guest1Mail', 1)
guest1Pass = findTestData(dataFile2).getValue('guest1Pass', 1)
/****************************************************/
WebUI.openBrowser('')
WebUI.callTestCase(findTestCase('TestCaseUtilities/setVHost'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('https://mirandakate.cabisandbox.com/show-microsite/104611400')


WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor executor = (JavascriptExecutor)driver;

'Login with the invited guest'
WebElement enterMail = driver.findElement(By.xpath("//div[@class='form-field']/custom-input/div/input[@name='email']"));
executor.executeScript("arguments[0].click();", enterMail);
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'),	guest1Mail)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))
WebUI.delay(5)
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Welcome_password'), guest1Pass)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))
WebUI.delay(5)
if (WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/complete_my_profile_later'), 0)) {
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Ill complete my profile later'))
}
List<WebElement> listElement1 = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'), 5)

'Validating invited guest\'s \'Yes\' RSVP\r\n'
if (listElement1.empty) {
	println('RSVP is not updated')
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_RSVP'))
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_yes'))
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_SEND'))
	WebUI.delay(4)
	WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h2_Were so glad you can make it.'),
		'We\'re so glad you can make it.')
} else {
	println('RSVP is updated previously')
}
WebUI.delay(4)
WebUI.click(findTestObject('Object Repository/showMicrosite/button_join_the_show'))
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/dashboard/a_close_mic_alert'))



