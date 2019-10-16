import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], FailureHandling.STOP_ON_FAILURE)
int noOfContacts= findTestData('contactData').getRowNumbers()
for (int row = 1; row <= noOfContacts; row++) {
	println noOfContacts
	
    firstName = findTestData('contactData').getValue('firstName', row)

    lastName = findTestData('contactData').getValue('lastName', row)

    email = findTestData('contactData').getValue('email', row)

    address1 = findTestData('contactData').getValue('address1', row)

    city = findTestData('contactData').getValue('city', row)

    state = findTestData('contactData').getValue('state', row)

    zip = findTestData('contactData').getValue('zip', row)

    WebDriver driver = DriverFactory.getWebDriver()
	JavascriptExecutor executor = ((driver) as JavascriptExecutor)
	executor.executeScript('arguments[0].click();', WebUiCommonHelper.findWebElement(findTestObject('Page_cabi Home/a_Contact Manager'), 5))

    String space = ' '

    String fNameLName = "$firstName$space$lastName"

    WebUI.setText(findTestObject('Page_cabi Edit Customer Profile/input_check_contact'), fNameLName)
	
	WebUI.delay(2)

    List<WebElement> contactNotFound = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi/div_contact_not_found'), 
        5)

    if (contactNotFound.size() > 0) {
        WebUI.click(findTestObject('Page_cabi/a_NEW CONTACT'))

        WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_First Name_firstName'), firstName)

        WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Last Name_lastName'), lastName)

        WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Email Address_emailAddress'), 
            email)

        WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address1_address1'), address1)

        //WebUI.click(findTestObject('Object Repository/Page_cabi Edit Customer Profile/li_Address2'))

        WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address2_address2'), '')

        WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_City_city'), city)

        WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_select_a_state'))

        WebUI.setText(findTestObject('Page_cabi Edit Customer Profile/input_state'), state)

        WebUI.delay(2)

        WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_state'))

        WebUI.setText(findTestObject('Page_cabi Edit Customer Profile/input_state_postalCode'), zip)

        WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_click_near_address'))

        WebUI.delay(3)
		
		List<WebElement> addSuggest = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Edit Customer Profile/check_address_suggestion'),
			5)
		
		if(addSuggest.size()>0){
			WebUI.click(findTestObject('Object Repository/Page_cabi Edit Customer Profile/check_address_suggestion'))
		}
		WebUI.delay(3)

        WebUI.verifyElementText(findTestObject('Page_cabi Edit Customer Profile/address_validator_check'), '  Address validated by cabi.', 
            FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.click(findTestObject('Page_cabi Edit Customer Profile/input_Interested In_save'))

        WebUI.delay(3)

        WebUI.verifyElementText(findTestObject('Page_cabi View Customer Profile/label_first_name'), firstName)

        WebUI.verifyElementText(findTestObject('Page_cabi View Customer Profile/label_last_name'), lastName)
    } else {
        println('Contact already present.')
    }
}

WebUI.closeBrowser()

