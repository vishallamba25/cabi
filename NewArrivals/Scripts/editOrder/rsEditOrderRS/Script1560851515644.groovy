import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
WebUI.openBrowser('')
WebUI.callTestCase(findTestCase('virtualShowRSVP/setVHost'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('editOrder/retailOrderRS'), [('addOnStyle') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/ReplicatedSite/h1_thanks_msg'), 'Thanks for placing your order!')
List<WebElement> editOrderButton = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/div_edit_order_rs'), 5)
assert editOrderButton.size() > 0
WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_edit_order_rs'))
WebUI.delay(10)

WebUI.callTestCase(findTestCase('editOrder/rsUpdateOrder'), [:], FailureHandling.STOP_ON_FAILURE)