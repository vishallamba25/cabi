import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('www.google.com')

WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor executor = (JavascriptExecutor)driver;
String currentPage = WebUI.getUrl()
int currentTab = WebUI.getWindowIndex()
println currentTab;
driver = DriverFactory.getWebDriver()
executor.executeScript('window.open();')
WebUI.delay(3)
WebUI.switchToWindowIndex(currentTab + 1)
println WebUI.getWindowIndex()
WebUI.navigateToUrl('www.facebook.com')
WebUI.switchToWindowIndex(currentTab)
println WebUI.getWindowIndex()
WebUI.delay(3)
WebUI.closeWindowIndex(currentTab+1)
WebUI.switchToWindowIndex(currentTab)
println WebUI.getWindowIndex()

executor.executeScript('window.open();')
WebUI.delay(3)
WebUI.switchToWindowIndex(currentTab + 1)
WebUI.navigateToUrl('www.yahoo.com')
println WebUI.getWindowIndex()


