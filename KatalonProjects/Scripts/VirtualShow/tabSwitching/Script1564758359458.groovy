import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('www.google.com')

ChromeOptions options = new ChromeOptions();
options.addArguments("incognito");
println WebUI.getWindowIndex()
WebDriver driver = new ChromeDriver(options);
executor = (JavascriptExecutor)driver;


executor.executeScript('window.open();')
Set<String> tabs= driver.getWindowHandles()
println tabs
String[] tabsa= tabs.toArray()

println tabsa
driver.switchTo().window(tabsa[0])
WebUI.delay(3)
driver.switchTo().window(tabsa[1])
driver.navigate().to("http://www.facebook.com")
executor.executeScript('window.close();')
driver.switchTo().window(tabsa[0])
executor.executeScript('window.close();')

WebUI.navigateToUrl('www.abc.com')

driver = DriverFactory.getWebDriver()
executor = (JavascriptExecutor)driver;
executor.executeScript('window.open();')






