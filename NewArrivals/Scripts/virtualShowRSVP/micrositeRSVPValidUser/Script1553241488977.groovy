import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

WebUI.openBrowser('')

WebUI.maximizeWindow()

/*****************set vhost steps****************/
WebUI.navigateToUrl(ofbizURL)

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_/input_Username_username'), ofbizUser)

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_/input_Password_password'), ofbizPass)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_/input_Password_Submit'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_/a_Set Vhost'))

WebUI.selectOptionByValue(findTestObject('virualShowRSVPOR/Page_/select_cabitest'), 
    '19', true)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_/input'))

/*****************End set vhost steps****************/
WebUI.navigateToUrl(GlobalVariable.micrositeURL)
//WebUI.navigateToUrl('https://mirandakate.cabitest5.com/show-microsite/104595204/')


WebUI.delay(12)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h1_Youre invited'), 
    'You\'re invited to Front Row')

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Login to RSVP'))

'Login with the invited guest'
WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'), 
    guest1Mail)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Welcome_password'), 
    guest1Pass)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

WebUI.delay(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/complete_my_profile_later'), 
    0)) {
    WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Ill complete my profile later' //WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'), 0)
            ))
}

//WebDriver driver = DriverFactory.get DriverFactory.getDriver()
List<WebElement> listElement = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'), 
    5)

'Validating invited guest\'s \'Yes\' RSVP\r\n'
if (listElement.empty) {
    println('list is empty')

    println('RSVP is not updated')

    WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_RSVP'))
    WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_yes'))
    WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_SEND'))

    WebUI.delay(4)

    WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h2_Were so glad you can make it.'), 
        'We\'re so glad you can make it.')
} else {
    println('RSVP is updated previously')
}

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_maybe'))
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_no'))
WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_maybe'))

/*WebUI.selectOptionByValue(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_RSVPYes Im joiningMaybeNo I cant make it'), 
    'Maybe', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_RSVPYes Im joiningMaybeNo I cant make it'), 
    'No', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_RSVPYes Im joiningMaybeNo I cant make it'), 
    'Maybe', true)*/

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_SEND'))

WebUI.delay(5)

//'Validating invited guest\'s \'Maybe\' RSVP msg\r\n\r\n'
WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h2_We hope youll be able to attend.'), 
    'We hope you\'ll be able to attend.')

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_no'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_SEND'))

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h2_Sorry you cant make it.'), 
    'Sorry you can\'t make it.')

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/select_rsvp_yes'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_SEND'))

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h2_Were so glad you can make it.'), 
    'We\'re so glad you can make it.')

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/profile_dropdown'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/a_Sign Out'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Sign out'))

WebUI.delay(5)

WebUI.navigateToUrl(GlobalVariable.micrositeURL)

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h1_Youre invited'), 
    'You\'re invited to Front Row')

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Login to RSVP'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'), 
    guestUninvitedMail)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Welcome_password'), 
    guestUninvitedPass)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

WebUI.delay(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/complete_my_profile_later'), 
    0)) {
    WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Ill complete my profile later' //WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'), 0)
            ))
}

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/uninvited_user_msg'), 
    'Your name doesn\'t seem to be on the guest list. Contact your Hostess or Stylist for more information.')

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/profile_dropdown'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/a_Sign Out'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Sign out'))

WebUI.delay(5)

WebUI.navigateToUrl(GlobalVariable.micrositeURL)

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h1_Youre invited'), 
    'You\'re invited')

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Login to RSVP'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'), 
    hostessMail)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Welcome_password'), 
    hostessPass)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

WebUI.delay(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/complete_my_profile_later'), 
    0)) {
    WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Ill complete my profile later' //WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'), 0)
            ))
}

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/hostess_msg'), 
    'Thanks for hosting.')

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/profile_dropdown'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/a_Sign Out'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Sign out'))

WebUI.delay(5)

WebUI.navigateToUrl(GlobalVariable.micrositeURL)

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/h1_Youre invited'), 
    'You\'re invited')

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Login to RSVP'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Sign in  Create account_email'), 
    cohostessMail)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

WebUI.setText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/input_Welcome_password'), 
    cohostessPass)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Continue'))

if (WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/complete_my_profile_later'), 
    0)) {
    WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Ill complete my profile later' //WebUI.verifyElementPresent(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/div_Update your RSVP'), 0)
            ))
}

WebUI.delay(5)

WebUI.verifyElementText(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/hostess_msg'), 
    'Thanks for hosting.')

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/profile_dropdown'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/a_Sign Out'))

WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_Show microsite/button_Sign out'))

WebUI.closeBrowser()

