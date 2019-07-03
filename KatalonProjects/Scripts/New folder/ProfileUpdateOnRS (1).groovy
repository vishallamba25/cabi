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
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Shilpa'])[1]/following::i[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Shilpa'])[1]/following::a[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='first name'])[1]/following::input[1]")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='first name'])[1]/following::input[1]", "New-Updated")
selenium.click("id=phoneNumber")
selenium.type("id=phoneNumber", "(654) 654-6544")
selenium.click("link=Upload")
selenium.type("id=pictureInput", "C:\\fakepath\\image1.jpg")
selenium.click("name=profile.facebookInfo")
selenium.type("name=profile.facebookInfo", "shilpa")
selenium.click("name=profile.twitterInfo")
selenium.type("name=profile.twitterInfo", "shilpa")
selenium.click("name=profile.instagramInfo")
selenium.type("name=profile.instagramInfo", "shilpa")
selenium.click("name=profile.pinterestInfo")
selenium.type("name=profile.pinterestInfo", "shilpa")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='My Information'])[2]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Upcoming Shows'])[2]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='shipping address'])[1]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Shipping Address same as Mailing Address'])[1]/following::input[1]")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Shipping Address same as Mailing Address'])[1]/following::input[1]", "250 5th Ave")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='street address 2'])[2]/following::input[1]", "New")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='state'])[1]/following::input[1]", "York")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='street address 2'])[2]/following::input[1]")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='street address 2'])[2]/following::input[1]", "New York")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='State'])[2]/following::div[6]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Nevada'])[1]/following::div[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Wyoming'])[1]/following::input[1]")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Wyoming'])[1]/following::input[1]", "10001")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Address Suggestions'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Address'])[2]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Payment information'])[1]/following::div[3]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Card Type'])[1]/following::div[5]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='card type'])[1]/following::div[4]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Discover'])[1]/following::input[1]")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Discover'])[1]/following::input[1]", "Shilpa")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='first name'])[1]/following::input[1]", "Test")
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='last name'])[1]/following::input[1]", "4111111111111111")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Expiration Date'])[1]/following::div[7]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='mm'])[1]/following::div[6]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='yy'])[1]/following::div[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='yy'])[1]/following::div[6]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Payment information'])[1]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Expiration Date'])[1]/following::div[14]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Expiration Date'])[1]/following::div[22]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Payment information'])[1]/following::span[1]")
selenium.click("link=Remove this credit card")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Payment'])[2]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Hip Sizes:'])[1]/following::div[8]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Hip Sizes:'])[1]/following::div[20]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Trouser Sizes:'])[1]/following::div[17]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Small'])[3]/following::div[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Shoe Sizes:'])[1]/following::div[9]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Shoe Sizes:'])[1]/following::div[18]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Sizes / Measurements'])[1]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Casual'])[1]/following::div[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Bold'])[1]/following::div[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Bold'])[1]/following::div[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='What shape do you identify with most?'])[1]/following::div[6]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Inverted Triangle'])[2]/following::div[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Tops'])[3]/following::div[11]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Style'])[2]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='txt'])[1]/following::label[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Communication'])[2]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Order History'])[2]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Order History'])[1]/following::button[1]")
