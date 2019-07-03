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

CCURL = findTestData('envtData').getValue('CCURL', 1)
CCuser = findTestData('credData').getValue('CCuser', 1)
CCpass = findTestData('credData').getValue('CCpass', 1)

WebUI.openBrowser("")

WebUI.navigateToUrl(CCURL)

WebUI.maximizeWindow()

List<WebElement> logOut = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Home/log_out'), 
    1)

if (logOut.size() == 0) {
    WebUI.setText(findTestObject('Object Repository/Page_cabi/input_Username_USERNAME'), CCuser)

    WebUI.setText(findTestObject('Object Repository/Page_cabi/input_Password_PASSWORD'), CCpass)

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/Page_cabi/input_Password_section-btn btn-stl-pk rFloat'))
}

WebUI.delay(3)
