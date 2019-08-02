import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods



String dataFile = "micrositeData"
guest1Mail = findTestData(dataFile).getValue('guest1Mail', 1)
guest1Pass = findTestData(dataFile).getValue('guest1Pass', 1)

String RSTestEnvt= findTestData('envtData').getValue('RSTestEnvt', 1)

//WebUI.openBrowser('')
//WebUI.callTestCase(findTestCase('TestCaseUtilities/setVHost'), [:], FailureHandling.STOP_ON_FAILURE)

//GlobalVariable.micrositeURL="https://mirandakate.cabitest5.com/show-microsite/104653490/"
//WebUI.navigateToUrl(GlobalVariable.micrositeURL)
String loginURL= UtilityMethods.concat("https://mirandakate.", RSTestEnvt, ".com/?component=account.login-gateway")
WebUI.navigateToUrl(loginURL)

/*******************************guest login on microsite****************************/
'Login with the invited guest'
'Login with the invited guest'
WebUI.delay(3)
/*WebElement enterMail = driver.findElement(By.xpath("//div[@class='form-field']/custom-input/div/input[@name='email']"));
executor.executeScript("arguments[0].click();", enterMail);*/
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'),	guest1Mail)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Welcome_password'), guest1Pass)
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue_pass'))
WebUI.delay(5)
if (WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/complete_my_profile_later'), 0)) {
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Ill complete my profile later'))
}