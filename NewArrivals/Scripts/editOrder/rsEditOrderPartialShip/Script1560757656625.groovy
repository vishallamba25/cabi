import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('editOrder/retailOrderBO'), [('editScenarioNumber') : 5], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(10)
WebUI.callTestCase(findTestCase('NewArrival/warehouseShipping'), [('orderId') : GlobalVariable.retailOrderID], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('virtualShowRSVP/setVHost'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('editOrder/rsLogin'), [('RSURL') : '', ('RSuser') : '', ('RSpass') : ''], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('editOrder/rsOrderHistoryConfirm'), [('orderID') : '', ('editScenarioNumber') : 5], FailureHandling.STOP_ON_FAILURE)
