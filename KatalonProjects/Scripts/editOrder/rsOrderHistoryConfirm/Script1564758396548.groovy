import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import commonUtility.UtilityMethods as UtilityMethods
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

orderID = GlobalVariable.retailOrderID

println(orderID)

////////////////span[contains(text(), '${orderID}')]/parent::div/parent::div/div[@class='table-row-edit-order']
String xpath = UtilityMethods.concat('//span[contains(text(), \'', orderID, '\')]/parent::div/parent::div/div[@class=\'table-row-edit-order\']//a')

TestObject to = new TestObject('a_link_dynamic')

to.addProperty('xpath', ConditionType.EQUALS, xpath)

//////////////
WebUI.click(findTestObject('ReplicatedSite/rs_Page_Trendy/i_Michigan_fa fa-caret-down'))

WebUI.click(findTestObject('ReplicatedSite/rs_Page_Trendy/a_My Profile'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Profile - Cabi Fall 2018 Collection/span_Order History'))

WebUI.delay(5)

List<WebElement> editButton = WebUiCommonHelper.findWebElements(to, 1)

assert editButton.size() > 0

if (editButton.size() > 0) {
    WebUI.click(to)

    WebUI.delay(10)

    if (editScenarioNumber == 1) {
        println('scen = 1')

//        List<WebElement> updateButton = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/a_update_order'),1)
//        assert updateButton.size() > 0

        WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_update_order'))
        WebUI.delay(5)
        ////call rsUpdateOrder
		WebUI.callTestCase(findTestCase('EditOrder/rsUpdateOrder'), [:], FailureHandling.STOP_ON_FAILURE)
		////end rsUpdateOrder
        WebUI.delay(3)

        /////cancel edit
        WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_cancel_edit'))
        List<WebElement> cancelEditButton = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/h2_sure_to_cancel_edit'),1)
        assert cancelEditButton.size() > 0
        WebUI.click(findTestObject('ReplicatedSite/button_yes_cancel_edit'))
        WebUI.delay(5)
        WebUI.click(to)
        WebUI.delay(5)
        /////cancel order
        WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_cancel_order'))
        List<WebElement> cancelOrderButton = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/h2_sure_to_cancel_order'), 1)
        assert cancelOrderButton.size() > 0
        WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_yes_cancel_order'))
        WebUI.delay(5)
		TestObject div_cancelled_order= UtilityMethods.createTestObject("div_cancelled_order", '//span[contains(text(), \'', orderID, '\')]/parent::div/parent::div/div[@class=\'table-row-status\']/span')
		println WebUI.getText(div_cancelled_order)
		WebUI.verifyElementText(div_cancelled_order, "Cancelled")
		
    } else if (editScenarioNumber == 3) {
        println('scen = 3')

        String expectedNoEditMsg1 = 'We\'re Sorry.'

        String expectedNoEditMsg2 = 'Your order has gift card items and cannot be edited.'

        String actualNoEditMsg1 = WebUI.getText(findTestObject('Object Repository/ReplicatedSite/div_no_edit_msg1'))

        String actualNoEditMsg2 = WebUI.getText(findTestObject('Object Repository/ReplicatedSite/div_no_edit_msg2'))

        assert actualNoEditMsg1.equalsIgnoreCase(expectedNoEditMsg1)

        assert actualNoEditMsg2.equalsIgnoreCase(expectedNoEditMsg2)

        WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_accept_msg'))
    } else if (editScenarioNumber == 4) {
        println('scen = 4')

//        List<WebElement> donationItemPresent = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/div_donation_present'), 5)
//
//        assert donationItemPresent.size() > 0

        List<WebElement> donationRemoveButton = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/a_donation_cannot_remove'), 5)

        assert donationRemoveButton.size() == 0
    } else if (editScenarioNumber == 5) {
        println('scen = 5')

        String expectedMessage = 'Item Shipped'

        String actualMessage = WebUI.getText(findTestObject('Object Repository/ReplicatedSite/itemShipped'))

        assert actualMessage.equalsIgnoreCase(expectedMessage)

        List<WebElement> itemRemove = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/itemRemove'), 
            5)

        assert itemRemove.size() == 0
    } else {
        println('editScenarioNumber is should be from 1 to 5')

        assert false
    }
}

