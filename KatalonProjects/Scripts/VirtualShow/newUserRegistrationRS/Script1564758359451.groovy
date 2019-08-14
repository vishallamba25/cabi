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

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/dressStyle'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/dressShape'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/dressAccentuate'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/dislikeColors'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/dislikePatterns'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/continueButtonStyleForm'))

WebUI.waitForElementClickable(findTestObject('Object Repository/ReplicatedSite/rsNewUser/topsRadiobutton'), 5)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/sweatersRadioButton'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/bottomsRadioButton'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/bottomsRadioButton'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/skirtsRadioButton'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/dressessRadioButton'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/jacketsRadioButton'))	

WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/continueButtonStyleForm'))

WebUI.delay(5)

List<String> titleList = new ArrayList<>();
titleList.add("Bust")
titleList.add("Band Size")
titleList.add("Cup Size")
titleList.add("Waist")
titleList.add("Hips")
titleList.add("Inseam")
titleList.add("Tops")
titleList.add("Trouser")
titleList.add("Trouser Length")
titleList.add("Jacket")
titleList.add("Skirts")
titleList.add("Dresses")
titleList.add("Shoes")




List<String> sizeList = new ArrayList<>();
sizeList.add("35")
sizeList.add("30")
sizeList.add("B")
sizeList.add("28")
sizeList.add("34")
sizeList.add("30")
sizeList.add("L")
sizeList.add("L")
sizeList.add("L")
sizeList.add("L")
sizeList.add("L")
sizeList.add("L")
sizeList.add("9")


for(int i=0;i<titleList.size();i++){

	TestObject fitForm= UtilityMethods.createTestObject("fitForm", '//h3[text()=\'',titleList.get(i),'\']/parent::div//span[@class=\'dressText dressTextNonSelected\' and text()=\'',sizeList.get(i),'\']')

	WebUI.click(fitForm)
	
	WebUI.delay(2)
	
	}


WebUI.click(findTestObject('Object Repository/ReplicatedSite/rsNewUser/continueButtonStyleForm'))

WebUI.delay(5)


