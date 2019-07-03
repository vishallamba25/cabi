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
selenium.open("https://testconsultant.cabisandbox.com/")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Not my stylist?'])[2]/following::i[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Sign in / Create account'])[1]/following::input[1]")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Sign in / Create account'])[1]/following::input[1]", "shilpa25201000@gmail.com")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Remember me'])[1]/following::button[1]")
selenium.click("name=firstName")
selenium.type("name=firstName", "Shilpa")
selenium.type("name=lastName", "New")
selenium.type("name=phone", "(654) 654-6546")
selenium.type("name=password", "blackdress19")
selenium.type("name=confirmPassword", "blackdress19")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Show'])[2]/following::label[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='no thanks'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='(111) 222-3334'])[3]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='(plus, it makes checkout a breeze!)'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Business'])[1]/following::div[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Classic'])[1]/following::div[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Inverted Triangle'])[1]/following::div[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Petite'])[1]/following::div[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Legs'])[1]/following::label[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Purple'])[1]/following::div[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Polka Dots'])[1]/following::div[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='I wear any pattern'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Tops'])[3]/following::img[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Sweaters'])[3]/following::div[9]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Bottoms'])[3]/following::div[9]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Skirts'])[3]/following::div[5]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Dresses'])[3]/following::div[5]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Jackets'])[3]/following::div[9]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Jackets'])[3]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Bust'])[1]/following::span[10]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Band Size'])[1]/following::span[10]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='B'])[1]/following::span[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Waist'])[1]/following::span[28]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Hips'])[1]/following::span[8]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Inseam'])[1]/following::span[6]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Tops'])[3]/following::span[8]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='XS'])[1]/following::span[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Trouser'])[3]/following::span[8]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='R'])[1]/following::span[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='XS'])[2]/following::span[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Jacket'])[1]/following::span[10]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Skirts'])[3]/following::span[10]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Skirts'])[3]/following::span[10]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Dresses'])[3]/following::span[8]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='XS'])[5]/following::span[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Shoes'])[3]/following::span[6]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Shoes'])[3]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Enter your mailing information'])[1]/following::input[1]")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Enter your mailing information'])[1]/following::input[1]", "350 5th Ave")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='street address 1'])[1]/following::input[1]", "qa123")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='street address 1'])[1]/following::div[2]")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='street address 1'])[1]/following::input[1]", "APT123")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='street address 2'])[1]/following::input[1]", "New York")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='State'])[1]/following::div[5]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Nevada'])[1]/following::div[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Wyoming'])[1]/following::input[1]")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Wyoming'])[1]/following::input[1]", "10118")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='phone number'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Address Suggestions'])[1]/following::button[1]")
