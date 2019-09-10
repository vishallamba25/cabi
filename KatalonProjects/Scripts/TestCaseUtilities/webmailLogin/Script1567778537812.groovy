import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DateFormat
import java.text.SimpleDateFormat
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import commonUtility.UtilityMethods

BOURL = findTestData('envtData').getValue('BOURL', 1)
String WMURL= findTestData('envtData').getValue('WMURL', 1)
String roundcubeUser= UtilityMethods.getEnvt(BOURL);
String roundcubePass='blackdress19'
WebUI.openBrowser('')

//WebUI.maximizeWindow()

WebUI.navigateToUrl(WMURL)
List<WebElement> logOut = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/webmail/log_out'), 1)
if (logOut.size() == 0) {
    WebUI.setText(findTestObject('Object Repository/webmail/input_username'), roundcubeUser)
    WebUI.setText(findTestObject('Object Repository/webmail/input_pass'), roundcubePass)
    WebUI.click(findTestObject('Object Repository/webmail/button_submit'))
}

//WebUI.delay(3)

