import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.asserts.SoftAssert

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods

WebUI.openBrowser('')




String RSTestEnvt = findTestData('envtData').getValue('RSTestEnvt', 1)

WebUI.callTestCase(findTestCase('TestCaseUtilities/setVHost'), [:], FailureHandling.CONTINUE_ON_FAILURE)

SoftAssert sa = new SoftAssert()

String WMURL= findTestData('envtData').getValue('WMURL', 1)
String WMEnvt= findTestData('envtData').getValue('WMEnvt', 1)
String WMpass= findTestData('credData').getValue('WMpass', 1)
int noOfContacts= 1;//findTestData('contactData').getRowNumbers()
for (int row = 1; row <= noOfContacts; row++) {
	println noOfContacts
	
	String firstName = findTestData('contactData').getValue('firstName', row)
	String lastName = findTestData('contactData').getValue('lastName', row)
	String email = findTestData('contactData').getValue('email', row)
	String pass = findTestData('contactData').getValue('pass', row)

	WebDriver driver = DriverFactory.getWebDriver()
	JavascriptExecutor executor = ((driver) as JavascriptExecutor)
	
	//GlobalVariable.micrositeURL="https://mirandakate.cabitest5.com/show-microsite/104653490/"
	//WebUI.navigateToUrl(GlobalVariable.micrositeURL)
	String loginURL = UtilityMethods.concat('https://mirandakate.', RSTestEnvt, '.com/?component=account.login-gateway')
	
	WebUI.navigateToUrl(loginURL)
	/*******************************guest login on microsite****************************/
	'Login with the invited guest'
	WebUI.delay(3)
	
	/*WebElement enterMail = driver.findElement(By.xpath("//div[@class='form-field']/custom-input/div/input[@name='email']"));
	executor.executeScript("arguments[0].click();", enterMail);*/
	WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'), email)
	
	WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))
	
	/*WebUI.click(findTestObject('Object Repository/User_Registration/h2_new_to_cabi'))
	WebUI.sendKeys(findTestObject('Object Repository/User_Registration/h2_new_to_cabi'), Keys.TAB)*/
	
	//WebUI.click(findTestObject('Object Repository/User_Registration/input_fname'))
	//js.executeScript("document.getElementById('s').value='Avinash Mishra';");
	//document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
	//String xpath="//div[@class='custom-input']/input[@name='firstName']"
	
	
	
	WebUI.delay(3)
	WebElement element1 = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/User_Registration/input_fname'),30)
	WebUI.executeJavaScript("arguments[0].value='Your Value'", Arrays.asList(element1))
	WebUI.click(findTestObject('User_Registration/input_fname_div'))
	WebUI.setText(findTestObject('Object Repository/User_Registration/input_fname'), firstName)
	
	//WebUI.executeJavaScript("arguments[0].value='Your Value'", Arrays.asList(element1))
	
	element1 = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/User_Registration/input_lname'),30)
	WebUI.executeJavaScript("arguments[0].value='gfkfdkhj'", Arrays.asList(element1))
	WebUI.click(findTestObject('User_Registration/input_lname_div'))
	WebUI.setText(findTestObject('Object Repository/User_Registration/input_lname'), lastName)
	
	element1 = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/User_Registration/input_lname'),30)
	WebUI.executeJavaScript("arguments[0].value='gfkfdkhj'", Arrays.asList(element1))
	WebUI.click(findTestObject('User_Registration/input_lname_div'))
	WebUI.setText(findTestObject('Object Repository/User_Registration/input_lname'), lastName)
	
	element1 = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/User_Registration/input_lname'),30)
	WebUI.executeJavaScript("arguments[0].value='gfkfdkhj'", Arrays.asList(element1))
	WebUI.click(findTestObject('User_Registration/input_lname_div'))
	WebUI.setText(findTestObject('Object Repository/User_Registration/input_lname'), lastName)
	
	//div[@class='custom-input']/input[@name='firstName']/following-sibling::span
	
	//WebElement element = WebUiCommonHelper.findWebElement(findTestObject('User_Registration/input_fname_div'),30)
	//WebUI.executeJavaScript("arguments[0].click", Arrays.asList(element))
	//WebUI.delay(2)
	
	//WebUI.executeJavaScript("arguments[0].click", Arrays.asList(element))
	
	
	
	
	
	//executor.executeScript("document.evaluate('//div[@class=\\'custom-input\\']/input[@name=\\'firstName\\']', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='ABCD';")
	executor.executeScript("document.evaluate('//div[@class=\\'custom-input\\']/input[@name=\\'lastName\\']', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='ABCD';")
	executor.executeScript("document.evaluate('//div[@class=\\'custom-input password\\']/input[@name=\\'password\\']', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='ABCD';")
	executor.executeScript("document.evaluate('//div[@class=\\'custom-input password\\']/input[@name=\\'confirmPassword\\']', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='ABCD';")
	
	WebUI.click(findTestObject('Object Repository/User_Registration/check_email'))
	WebUI.click(findTestObject('Object Repository/User_Registration/button_submit'))
	
	/*//executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/User_Registration/input_fname'), 10))
	WebUI.sendKeys(findTestObject('Object Repository/User_Registration/input_fname'), firstName)

	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/User_Registration/input_lname'), 10))
	WebUI.sendKeys(findTestObject('Object Repository/User_Registration/input_lname'), lastName, lastName)
	
	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/User_Registration/input_email'), 10))
	WebUI.setText(findTestObject('Object Repository/User_Registration/input_email'), email)
	
	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/User_Registration/input_pass'), 10))
	WebUI.setText(findTestObject('Object Repository/User_Registration/input_pass'), pass)
	
	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('User_Registration/input_confirm-pass'), 10))
	WebUI.setText(findTestObject('User_Registration/input_confirm-pass'), pass)*/
	
	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/User_Registration/check_email'), 10))
	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Object Repository/User_Registration/button_submit'), 10))
	
	List<WebElement> emailAlreadyPresent = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/User_Registration/verify_text_already_have_email'), 5)
	if(emailAlreadyPresent.size()<1){
		sa.assertTrue(false)
		continue;
	}
	
	/***********************************opening roundcube in new tab*********************************/
	int currentTab = WebUI.getWindowIndex()
	executor.executeScript('window.open();')
	WebUI.switchToWindowIndex(currentTab + 1)
	WebUI.navigateToUrl(WMURL)
	
	WebUI.setText(findTestObject('Object Repository/User_Registration/Roundcube_Webmail/input_user'), WMEnvt)
	WebUI.setText(findTestObject('Object Repository/User_Registration/Roundcube_Webmail/input_pass'), WMpass)
	WebUI.click(findTestObject('Object Repository/User_Registration/Roundcube_Webmail/input_submit'))
	
	WebUI.delay(2)
	List<WebElement> tdVerifyMail = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/User_Registration/Roundcube_Webmail/td_verify_mail'), 5)
	WebUI.doubleClick(findTestObject('Object Repository/User_Registration/Roundcube_Webmail/td_verify_mail'))
	WebUI.delay(2)
	String veriCode= WebUI.getText(findTestObject('Object Repository/User_Registration/Roundcube_Webmail/p_verify_code'))
	
	WebUI.switchToWindowIndex(currentTab)
	WebUI.closeWindowIndex(currentTab + 1)
	
	
	
	
	
	
}
