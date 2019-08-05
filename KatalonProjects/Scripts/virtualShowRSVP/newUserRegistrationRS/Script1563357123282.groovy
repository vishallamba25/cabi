import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.github.javafaker.Faker as Faker
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods

RSURL = findTestData('envtData').getValue('RSURL', 1)

RSuser = findTestData('credData').getValue('RSuser', 1)

String RSTestEnvt= findTestData('envtData').getValue('RSTestEnvt', 1)

Faker faker = new Faker()

String name = faker.name().fullName()

String firstName = faker.name.firstName()

String lastName = faker.name().lastName()

String email = faker.internet.emailAddress()

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('TestCaseUtilities/setVHost'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(RSURL)

//WebUI.click(findTestObject('ReplicatedSite/rs_Page_Trendy/i_user_login'))

String loginURL= UtilityMethods.concat("https://mirandakate.", RSTestEnvt, ".com/?component=account.login-gateway")

WebUI.navigateToUrl(loginURL)


WebUI.setText(findTestObject('ReplicatedSite/rs_Page_Trendy/input_Sign in  Create account_email'), email)

WebUI.click(findTestObject('ReplicatedSite/rs_Page_Trendy/button_Continue'))

WebUI.delay(5)

WebUI.click(findTestObject('ReplicatedSite/rsNewUser/rsFirstName'))

WebUI.setText(findTestObject('ReplicatedSite/rsNewUser/rsFirstName'), firstName)

WebUI.setText(findTestObject('ReplicatedSite/rsNewUser/rsLastName'), lastName)

WebUI.setText(findTestObject('ReplicatedSite/rsNewUser/rsPassword'), 'blackdress19')

WebUI.setText(findTestObject('ReplicatedSite/rsNewUser/rsConfirmPassword'), 'blackdress19')

WebUI.click(findTestObject('ReplicatedSite/rsNewUser/noThanksLabel'))

WebUI.click(findTestObject('ReplicatedSite/rsNewUser/continueButton'))

WebUI.delay(3)

WebUI.click(findTestObject('ReplicatedSite/rsNewUser/gotItThanks'))

//TestObject profileOptions= UtilityMethods.createTestObject("profileOptions", '//div[@class=\'check\' and preceding-sibling::div[text()=\'',Casual,'\']]')

WebUI.click(findTestObject('ReplicatedSite/rsNewUser/setUpMyProfile'))

WebUI.waitForElementClickable(findTestObject('ReplicatedSite/rsNewUser/dressOftenOption'), 5)

WebUI.delay(3)

WebUI.click(findTestObject('ReplicatedSite/rsNewUser/dressOftenOption'))

