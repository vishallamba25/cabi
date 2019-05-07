import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

BOURL = findTestData('credData').getValue('BOURL', 1)

BOuser = findTestData('credData').getValue('BOuser', 1)

BOpass = findTestData('credData').getValue('BOpass', 1)

not_run: WebUI.openBrowser('')

WebUI.navigateToUrl(BOURL)

WebUI.maximizeWindow()

List<WebElement> logOut = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Home/log_out'), 
    5)

if (logOut.size() == 0) {
    WebUI.setText(findTestObject('Page_cabi/input_Welcome to_USERNAME'), BOuser)

    WebUI.setText(findTestObject('Object Repository/Page_cabi/input_Welcome to_PASSWORD'), BOpass)

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/Page_cabi/input_Welcome to_consultantLogin'))
}

WebUI.delay(3)

