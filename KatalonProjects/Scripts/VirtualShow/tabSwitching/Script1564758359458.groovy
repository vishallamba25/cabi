import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot
import java.awt.event.KeyEvent

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

Robot robot = new Robot();
robot.keyPress(KeyEvent.VK_ALT);
robot.keyPress(KeyEvent.VK_TAB);
robot.keyRelease(KeyEvent.VK_ALT);
robot.keyRelease(KeyEvent.VK_TAB);

WebUI.click(findTestObject('TabSwitching/input_search'))
//WebUI.sendKeys(findTestObject('TabSwitching/input_search'), Keys.chord(Keys.ALT, Keys.TAB));

//WebUI.switchToDefaultContent()
WebUI.navigateToUrl('www.abc.com')
/*Actions action = new Actions(driver);
action.keyDown(Keys.LEFT_ALT).sendKeys(Keys.TAB).keyUp(Keys.LEFT_ALT).perform();*/


//action.sendKeys(Keys.chord(Keys.ALT, Keys.TAB)).build().perform();



//executor.executeScript('window.close();')
driver.switchTo().window(tabsa[0])
//executor.executeScript('window.close();')



driver = DriverFactory.getWebDriver()
executor = (JavascriptExecutor)driver;
executor.executeScript('window.open();')






