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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser('')

WebUI.callTestCase(findTestCase('backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)

for (int row = 1; row <= findTestData('contactData').getRowNumbers(); row++) {
    firstName = findTestData('contactData').getValue('firstName', row)

    lastName = findTestData('contactData').getValue('lastName', row)

    email = findTestData('contactData').getValue('email', row)

    address1 = findTestData('contactData').getValue('address1', row)

    city = findTestData('contactData').getValue('city', row)

    state = findTestData('contactData').getValue('state', row)

    zip = findTestData('contactData').getValue('zip', row)

    WebUI.click(findTestObject('Page_cabi Home/a_Connections'))

    WebUI.click(findTestObject('Page_cabi Home/a_Contact Manager'))

    String space = ' '

    String fNameLName = "$firstName$space$lastName"

    WebUI.setText(findTestObject('Page_cabi Edit Customer Profile/input_check_contact'), fNameLName)

    List<WebElement> contactNotFound = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi/div_contact_not_found'), 
        5)

    if (contactNotFound.size() > 0) {
        WebUI.click(findTestObject('Page_cabi/a_NEW CONTACT'))

        WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_First Name_firstName'), firstName)

        WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Last Name_lastName'), lastName)

        WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Email Address_emailAddress'), 
            email)

        WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address1_address1'), address1)

        WebUI.click(findTestObject('Object Repository/Page_cabi Edit Customer Profile/li_Address2'))

        WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address2_address2'), '')

        WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_City_city'), city)

        WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_select_a_state'))

        WebUI.setText(findTestObject('Page_cabi Edit Customer Profile/input_state'), state)

        WebUI.delay(2)

        WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_state'))

        WebUI.setText(findTestObject('Page_cabi Edit Customer Profile/input_state_postalCode'), zip)

        WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_click_near_address'))

        WebUI.delay(3)

        WebUI.verifyElementText(findTestObject('Page_cabi Edit Customer Profile/address_validator_check'), '  Address validated by cabi.', 
            FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Page_cabi Edit Customer Profile/input_Interested In_save'))

        WebUI.delay(3)

        WebUI.verifyElementText(findTestObject('Page_cabi View Customer Profile/label_first_name'), firstName)

        WebUI.verifyElementText(findTestObject('Page_cabi View Customer Profile/label_last_name'), lastName)
    } else {
        println('Contact already present.')
    }
}

WebUI.closeBrowser()

