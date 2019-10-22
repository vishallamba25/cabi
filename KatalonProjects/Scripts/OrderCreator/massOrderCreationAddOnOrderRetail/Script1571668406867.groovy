import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.testng.asserts.SoftAssert

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
WebUI.openBrowser('')

/**********vaiable initialization********************/
String dataFile = 'orderCreationData'
int orderType=5;
int noOfOrders= Integer.parseInt(findTestData(dataFile).getValue('noOfOrders', orderType));
String ship= findTestData(dataFile).getValue('shipping', orderType)
println noOfOrders
println ship
/*****************************************************/


for(int i=1; i<= noOfOrders; i++){
	WebUI.callTestCase(findTestCase('Test Cases/OrderCreator/addOnOrderRetail'), [('ship') : ship],
	FailureHandling.CONTINUE_ON_FAILURE)
}





