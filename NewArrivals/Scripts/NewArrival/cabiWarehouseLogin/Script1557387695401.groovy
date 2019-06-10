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

CWURL = findTestData('credData').getValue('CWURL', 1)

CWuser = findTestData('credData').getValue('CWuser', 1)

CWpass = findTestData('credData').getValue('CWpass', 1)

WebUI.openBrowser("")

//WebUI.maximizeWindow()

WebUI.navigateToUrl(CWURL)

List<WebElement> logOut = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Cabi warehouse/Page_cabi_home/log_out'),1)
if (logOut.size() == 0) {
	WebUI.setText(findTestObject('Object Repository/Cabi warehouse/Page_cabi/input_Username_USERNAME'), CWuser)
	WebUI.setText(findTestObject('Object Repository/Cabi warehouse/Page_cabi/input_Password_PASSWORD'), CWpass)
	WebUI.click(findTestObject('Object Repository/Cabi warehouse/Page_cabi/input_Password_section-btn btn-stl-pk rFloat'))
}

WebUI.delay(3)


