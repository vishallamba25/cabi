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
import com.github.javafaker.Faker as Faker
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

RSURL = findTestData('envtData').getValue('RSURL', 1)

RSuser = findTestData('credData').getValue('RSuser', 1)

Faker faker = new Faker()

String name = faker.name().fullName()

String firstName = faker.name.firstName()

String lastName = faker.name().lastName()

String email = faker.internet.emailAddress()

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('TestCaseUtilities/setVHost'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(RSURL)

WebUI.click(findTestObject('ReplicatedSite/rs_Page_Trendy/i_user_login'))

WebUI.setText(findTestObject('ReplicatedSite/rs_Page_Trendy/input_Sign in  Create account_email'), email)

WebUI.click(findTestObject('ReplicatedSite/rs_Page_Trendy/button_Continue'))

WebUI.delay(3)

//WebUI.click(findTestObject('ReplicatedSite/rsNewUser/rsFirstName'))
WebUI.setText(findTestObject('ReplicatedSite/rsNewUser/rsFirstName'), firstName)

WebUI.setText(findTestObject('ReplicatedSite/rsNewUser/rsLastName'), lastName)

WebUI.setText(findTestObject('ReplicatedSite/rsNewUser/rsPassword'), 'blackdress19')

WebUI.setText(findTestObject('ReplicatedSite/rsNewUser/rsConfirmPassword'), 'blackdress19')

WebUI.click(findTestObject('ReplicatedSite/rsNewUser/noThanksLabel'))

WebUI.click(findTestObject('ReplicatedSite/rsNewUser/continueButton'))

WebUI.delay(3)

WebUI.click(findTestObject('ReplicatedSite/rsNewUser/gotItThanks'))

WebUI.click(findTestObject('ReplicatedSite/rsNewUser/setUpMyProfile'))

