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

String[][] orderCreationData= new String[7][3];

for(int i=1; i<=6; i++){
	orderCreationData[i][0]= findTestData(dataFile).getValue('orderType', i)
	orderCreationData[i][1]= findTestData(dataFile).getValue('noOfOrders', i)
	orderCreationData[i][2]= findTestData(dataFile).getValue('shipping', i)
}



/*****************************************************/
String noOfOrders= Integer.parseInt(orderCreationData[1][1]);
String personalShip= orderCreationData[1][2];
println noOfOrders
println personalShip

for(int i=1; i<= noOfOrders; i++){
	WebUI.callTestCase(findTestCase('Test Cases/OrderCreator/personalOrder'), [('personalShip') : personalShip],
	FailureHandling.CONTINUE_ON_FAILURE)
	println i
}



