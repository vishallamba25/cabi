import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods



WebUI.click(findTestObject('Object Repository/ReplicatedSite/span_shipping_info'))
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_other_address'))
//////////////////Enter other adress/////////////////////
int contactNumber = 4 //guest2
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
WebDriver driver = DriverFactory.getWebDriver()
WebElement element = driver.findElement(By.xpath("//button[@type='submit']/span[contains(text(), 'Save')]"));
Actions actions = new Actions(driver);
actions.moveToElement(element).click().build().perform();
//////////
WebUI.delay(4)
WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_save_address_continue'))
WebUI.delay(3)
////////////////////////////
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_make_donation'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_make_donation'))
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_pay_with_gc'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_pay_with_gc'))
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_pay_with_credit'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/ReplicatedSite/input_pay_with_credit'))
/////////////////////////////
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_cart'))



