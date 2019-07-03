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
selenium.open("https://sandbox.cabiclio.com//backoffice/control/main")
selenium.type("id=username", "TestConsultant")
selenium.type("id=consultantPwd", "clio2grow")
selenium.click("id=consultantLogin")
selenium.click("link=Create A Show")
selenium.click("id=hostess-choice1")
selenium.click("id=ui-id-5")
selenium.type("id=hostess-choice1", "Shilpa Zarya")
selenium.click("id=submitButton")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Virtual Show'])[1]/span[1]")
selenium.click("id=showDate1")
selenium.click("link=28")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::input[1]")
selenium.click("link=Add Guests")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Added'])[3]/following::i[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Added'])[4]/following::i[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Invitations'])[1]/following::span[1]")
selenium.selectFrame("index=0")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='guests:'])[1]/preceding::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='H: Shilpa...'])[1]/following::button[1]")
selenium.selectWindow("win_ser_1")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Control your microphone and webcam'])[1]/preceding::i[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Introductions'])[1]/preceding::i[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Introductions'])[1]/preceding::i[2]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Introductions'])[1]/preceding::i[1]")
selenium.click("name=textarea")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='All Guests'])[1]/following::div[3]")
selenium.click("name=textarea")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Introductions'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Cranberry Crush Catwalk'])[1]/following::i[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='End session'])[1]/following::i[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Cranberry Crush Catwalk'])[2]/following::i[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Play videos'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Shopping'])[1]/following::button[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")
selenium.close()
selenium.selectWindow("win_ser_local")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Invitations'])[1]/following::span[1]")
