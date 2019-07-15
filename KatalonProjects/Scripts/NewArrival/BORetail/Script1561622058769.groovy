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
WebUI.openBrowser('')

for (int timeRow = 1; timeRow <= findTestData('timezoneData').getRowNumbers(); timeRow++) {
    WebUI.callTestCase(findTestCase('NewArrival/populateTimeGlobalVars'), [('row') : timeRow], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('NewArrival/setTimezone'), [('ofbizURL') : '', ('ofbizuser') : '', ('ofbizpass') : ''
            , ('orderType') : GlobalVariable.orderType, ('timeZone') : GlobalVariable.timeZone, ('serverTarget') : GlobalVariable.serverTarget], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.rightClick(findTestObject('Page_cabi Home/a_Shows  Orders'))

    WebUI.click(findTestObject('Page_cabi Home/a_retail_purchases'))

    WebUI.delay(3)

    //WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_guest_info'))
    WebUI.click(findTestObject('Object Repository/Page_cabi Home/existingCustomer'))

    ///////////////////////
    int contactNumber = 5

    String firstName = findTestData('contactData').getValue('firstName', contactNumber)

    String lastName = findTestData('contactData').getValue('lastName', contactNumber)

    String email = findTestData('contactData').getValue('email', contactNumber)

    String address1 = findTestData('contactData').getValue('address1', contactNumber)

    String city = findTestData('contactData').getValue('city', contactNumber)

    String state = findTestData('contactData').getValue('state', contactNumber)

    String zip = findTestData('contactData').getValue('zip', contactNumber)

    String existingCustFName = firstName

    String existingCustLName = lastName

    String space = ' '

    String existingCust = "$existingCustFName$space$existingCustLName"

    ///////////////////////
    WebUI.setText(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), existingCust)

    WebUI.delay(3)

    WebUI.rightClick(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'))

    WebUI.rightClick(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Create Show - Set Hostess/a_select_customer'))

    WebUI.setText(findTestObject('Object Repository/Page_cabi Home/input_existing_guest'), existingCust)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Retail Store/input_email'), email)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address1_address1'), address1)

    //WebUI.click(findTestObject('Object Repository/Page_cabi Edit Customer Profile/li_Address2'))
    WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_Address2_address2'), '')

    WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_City_city'), city)

    WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_select_a_state'))

    WebUI.delay(1)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Edit Customer Profile/input_state_1'), state)

    WebUI.delay(2)

    WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_state'))

    WebUI.setText(findTestObject('Page_cabi Edit Customer Profile/input_state_postalCode'), zip)

    //WebUI.click(findTestObject('Page_cabi Edit Customer Profile/span_click_near_address_1'))
    WebUI.delay(10)

    WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_same_shipping_address'))

  
    WebUI.delay(10)

    WebUI.click(findTestObject('Page_cabi Retail Store/span_next_1'))

    WebUI.delay(3)

    /////////////////////////
    WebUI.callTestCase(findTestCase('NewArrival/productVerify'), [('available') : GlobalVariable.BORetail, ('storeType') : 'BORetail'], 
        FailureHandling.STOP_ON_FAILURE)
}