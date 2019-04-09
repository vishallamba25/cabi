import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import myPack.WriteExcel as WriteToExcel
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

WebUI.openBrowser('')

WebUI.maximizeWindow()

/*not_run: WebUI.navigateToUrl(findTestData('virtualShowData').getValue(1, 5))

not_run: WebUI.setText(findTestObject('Page_/input_Username_username'), findTestData('virtualShowData').getValue(2, 5))

not_run: WebUI.setEncryptedText(findTestObject('Page_/input_Password_password'), findTestData('virtualShowData').getValue(3, 5))

not_run: WebUI.click(findTestObject('Page_/input_Password_Submit'))

not_run: WebUI.click(findTestObject('Page_/a_Set Vhost'))

not_run: WebUI.selectOptionByValue(findTestObject('Page_/select_cabitestcabitest2cabitest3cabitest4cabitest5virtual_cabitest18virtual_cabitest19virtual_cabitest21virtual_cabitest6virtual_cabitest7virtual_cabitest8virtual_cabitest9'), 
    '19', true)

not_run: WebUI.click(findTestObject('Page_/input'))*/
WebUI.navigateToUrl(findTestData('virtualShowData').getValue(1, 2))

WebUI.delay(10)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/h1_Youre invited (1)'), 
    'You\'re invited')

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Login to RSVP'))

'Login with the invited guest'
WebUI.setText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/input_Sign in  Create account_email'), 
    findTestData('virtualShowData').getValue(13, 1))

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Continue'))

WebUI.delay(5)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/input_Welcome_password'), 
    'B/N/DIt9VtgMeGq7IFnfMA==')

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Continue'))

WebUI.delay(5)

if (WebUI.verifyElementPresent(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/complete_my_profile_later'), 
    0)) {
    WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/div_Ill complete my profile later' //WebUI.verifyElementPresent(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/div_Update your RSVP'), 0)
            ))
}

//WebDriver driver = DriverFactory.get DriverFactory.getDriver()
List<WebElement> listElement = WebUiCommonHelper.findWebElements(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/div_Update your RSVP'), 
    5)

'Validating invited guest\'s \'Yes\' RSVP\r\n'
if (listElement.empty) {
    println('list is empty')

    println('RSVP is not updated')

    WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_RSVP'))

    WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/select_RSVPYes Im joiningMaybeNo I cant make it'), 
        'Yes', true)

    WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_SEND'))

    WebUI.delay(4)

    WebUI.verifyElementText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/h2_Were so glad you can make it.'), 
        'We\'re so glad you can make it.')
} else {
    println('RSVP is updated previously')
}

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/div_Update your RSVP'))

WebUI.delay(5)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/select_RSVPYes Im joiningMaybeNo I cant make it'), 
    'Maybe', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/select_RSVPYes Im joiningMaybeNo I cant make it'), 
    'No', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/select_RSVPYes Im joiningMaybeNo I cant make it'), 
    'Maybe', true)

WebUI.click(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/button_SEND'))

WebUI.delay(5)

'Validating invited guest\'s \'Maybe\' RSVP msg\r\n\r\n'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/h2_We hope youll be able to attend.'), 
    'We hope you\'ll be able to attend.')

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/div_Update your RSVP'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/select_RSVPYes Im joiningMaybeNo I cant make it'), 
    'No', true)

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_SEND'))

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/h2_Sorry you cant make it.'), 
    'Sorry you can\'t make it.')

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/div_Update your RSVP'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/select_RSVPYes Im joiningMaybeNo I cant make it'), 
    'Yes', true)

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_SEND'))

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/h2_Were so glad you can make it.'), 
    'We\'re so glad you can make it.')

WebUI.delay(5)

WebUI.click(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/profile_dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/a_Sign Out'))

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Sign out'))

WebUI.delay(5)

WebUI.navigateToUrl(findTestData('virtualShowData').getValue(1, 2))

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/h1_Youre invited (1)'), 
    'You\'re invited')

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Login to RSVP'))

WebUI.setText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/input_Sign in  Create account_email'), 
    findTestData('virtualShowData').getValue(15, 1))

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Continue'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/input_Welcome_password'), 
    'B/N/DIt9VtgMeGq7IFnfMA==')

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Continue'))

WebUI.delay(5)

if (WebUI.verifyElementPresent(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/complete_my_profile_later'), 
    0)) {
    WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/div_Ill complete my profile later' //WebUI.verifyElementPresent(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/div_Update your RSVP'), 0)
            ))
}

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/uninvited_user_msg'), 'Your name doesn\'t seem to be on the guest list. Contact your Hostess or Stylist for more information.')

WebUI.delay(5)

WebUI.click(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/profile_dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/a_Sign Out'))

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Sign out'))

WebUI.delay(5)

WebUI.navigateToUrl(findTestData('virtualShowData').getValue(1, 2))

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/h1_Youre invited (1)'), 
    'You\'re invited')

WebUI.delay(5)

WebUI.click(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/button_Login to RSVP'))

WebUI.setText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/input_Sign in  Create account_email'), 
    findTestData('virtualShowData').getValue(9, 1))

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Continue'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/input_Welcome_password'), 
    'B/N/DIt9VtgMeGq7IFnfMA==')

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Continue'))

WebUI.delay(5)

if (WebUI.verifyElementPresent(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/complete_my_profile_later'), 
    0)) {
    WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/div_Ill complete my profile later' //WebUI.verifyElementPresent(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/div_Update your RSVP'), 0)
            ))
}

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/hostess_msg'), 'Thanks for hosting.')

WebUI.delay(5)

WebUI.click(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/profile_dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/a_Sign Out'))

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Sign out'))

WebUI.delay(5)

WebUI.navigateToUrl(findTestData('virtualShowData').getValue(1, 2))

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/h1_Youre invited (1)'), 
    'You\'re invited')

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Login to RSVP'))

WebUI.setText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/input_Sign in  Create account_email'), 
    findTestData('virtualShowData').getValue(11, 1))

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Continue'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/input_Welcome_password'), 
    'B/N/DIt9VtgMeGq7IFnfMA==')

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Continue'))

if (WebUI.verifyElementPresent(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/complete_my_profile_later'), 
    0)) {
    WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/div_Ill complete my profile later' //WebUI.verifyElementPresent(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/div_Update your RSVP'), 0)
            ))
}

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/hostess_msg'), 'Thanks for hosting.')

WebUI.delay(5)

WebUI.click(findTestObject('Page_Show microsite - Cabi Fall 2018 Collection/profile_dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/a_Sign Out'))

WebUI.click(findTestObject('Object Repository/Page_Show microsite - Cabi Fall 2018 Collection/button_Sign out'))

WebUI.closeBrowser()

