import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join

WebUI.openBrowser('https://www.katalon.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.katalon.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://testconsultant.cabisandbox.com/show-microsite/104610390/")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='June 30, 2019'])[1]/following::button[1]")
selenium.click("name=email")
selenium.type("name=email", "shilpaprod2@test.com")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Remember me'])[1]/following::button[1]")
selenium.type("name=password", "blackdress19")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Show'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='complete my profile'])[1]/following::div[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='June 30, 2019'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='June 30, 2019'])[2]/following::select[1]")
selenium.select("xpath=(.//*[normalize-space(text()) and normalize-space(.)='June 30, 2019'])[2]/following::select[1]", "label=Yes, I'm joining")
selenium.click("name=textarea")
selenium.type("name=textarea", "Yes, I am joining!")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='June 30, 2019'])[2]/following::button[1]")
selenium.click("name=textarea")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='cabi STYLIST'])[1]/following::div[1]")
selenium.click("name=textarea")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)=concat('It', \"'\", 's time to get started')])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Control your microphone and webcam'])[1]/i[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Sign Out'])[4]/following::i[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Sign Out'])[4]/following::i[3]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Sign Out'])[4]/following::i[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Stylist: Gift'])[1]/following::div[14]")
selenium.click("name=textarea")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Save outfit'])[1]/following::a[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Save outfit'])[1]/following::a[2]")
selenium.click("link=Save outfit")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='View my favorites'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Loading'])[1]/following::div[7]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='SAVE THIS OUTFIT'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='FAVORITES'])[1]/following::div[1]")
selenium.selectFrame("index=0")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='$109.00'])[2]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='color: Petal'])[1]/following::select[1]")
selenium.select("xpath=(.//*[normalize-space(text()) and normalize-space(.)='color: Petal'])[1]/following::select[1]", "label=S")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='color: Petal'])[1]/following::select[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Added to wishlist!'])[1]/following::span[1]")
selenium.selectFrame("relative=parent")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='LOOKS'])[1]/following::div[1]")
selenium.selectFrame("index=0")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Clear bag'])[2]/following::a[1]")
selenium.selectFrame("relative=parent")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Checkout'])[1]/following::div[7]")
selenium.selectFrame("index=0")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='REMINDER:'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Pay with Gift Card(s)'])[1]/following::input[1]")
selenium.click("id=creditcard-card-type")
selenium.select("id=creditcard-card-type", "label=Visa")
selenium.click("id=creditcard-first-name")
selenium.type("id=creditcard-first-name", "Candace")
selenium.type("id=creditcard-last-name", "Abbey")
selenium.type("id=creditcard-card-number", "4111111111111111")
selenium.select("id=creditcard-expiration-month", "label=8")
selenium.select("id=creditcard-expiration-year", "label=25")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Add new'])[1]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='REMINDER:'])[3]/following::span[1]")
selenium.selectFrame("relative=parent")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)=concat('Don', \"'\", 't worry, you can still shop and chat with the group.')])[1]/following::button[1]")
selenium.close()
