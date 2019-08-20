import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods


WebDriver driver = DriverFactory.getWebDriver();
JavascriptExecutor executor = (JavascriptExecutor)driver;
WebElement element;
Actions actions;

/*WebUI.waitForElementClickable(findTestObject('Object Repository/ReplicatedSite/span_shipping_info'), 30)
element = driver.findElement(By.xpath('//span[contains(text(), \'1. Shipping information\')]'))
executor.executeScript("arguments[0].click();", element);
//WebUI.click(findTestObject('Object Repository/ReplicatedSite/span_shipping_info'))
*/WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_other_address'))
//////////////////Enter other adress/////////////////////
int contactNumber = 3 //guest2
String address1 = findTestData('contactData').getValue('address1', contactNumber)
String city = findTestData('contactData').getValue('city', contactNumber)
String state = findTestData('contactData').getValue('state', contactNumber)
String zip = findTestData('contactData').getValue('zip', contactNumber)
WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_address1_update'), address1)
WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_city_update'), city)
////////////////
String xpath = UtilityMethods.concat("//select[@id='stateProvince']/option[@label='", state, "']")
TestObject addressState = new TestObject("select_state_dynamic")
addressState.addProperty("xpath", ConditionType.EQUALS, xpath)
WebUI.click(addressState)
//////////////
WebUI.setText(findTestObject('Object Repository/ReplicatedSite/input_postal_code_update'), zip)
/////////////////////////////////////////////////////////////
WebUI.delay(4)
//WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_save_address'))
//////////
driver = DriverFactory.getWebDriver()
element = driver.findElement(By.xpath("//button[@type='submit']/span[contains(text(), 'Save')]"));
actions = new Actions(driver);
actions.moveToElement(element).click().build().perform();
//////////
WebUI.waitForElementClickable(findTestObject('Object Repository/ReplicatedSite/button_save_and_continue'), 30)
element = driver.findElement(By.xpath('(//button[@class=\'btn pull-right\'])[1]'))
executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", element);
//WebUI.click(findTestObject('ReplicatedSite/button_save_and_continue'))
WebUI.delay(3)
////////////////////////////
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_make_donation'), 5));
WebUI.delay(2)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_make_donation'), 5));
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_pay_with_gc'), 5));
WebUI.delay(2)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_pay_with_gc'), 5));
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_pay_with_credit'), 5));
WebUI.delay(2)
executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ReplicatedSite/input_pay_with_credit'), 5));
/////////////////////////////
WebUI.delay(2)

String RSURL = findTestData('envtData').getValue('RSURL', 1)
String cartURL= UtilityMethods.concat(RSURL, "/cart/")
WebUI.navigateToUrl(cartURL)



