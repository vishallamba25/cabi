import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('www.google.com')
String currentPage = WebUI.getUrl()
int currentTab = WebUI.getWindowIndex()
WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor js = ((driver) as JavascriptExecutor)
js.executeScript('window.open();')
WebUI.switchToWindowIndex(currentTab + 1)
WebUI.navigateToUrl(currentPage)
WebUI.navigateToUrl('www.yahoo.com')
WebUI.switchToWindowIndex(currentTab)
WebUI.navigateToUrl(currentPage)
WebUI.delay(3)
WebUI.switchToWindowIndex(currentTab+1)
WebUI.delay(3)
WebUI.switchToWindowIndex(currentTab)

