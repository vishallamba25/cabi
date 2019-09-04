import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import commonUtility.UtilityMethods as UtilityMethods
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

//WebUI.callTestCase(findTestCase('TestCaseUtilities/setVHost'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('EditOrder/retailOrderRS'), [('addOnStyle') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/ReplicatedSite/h1_thanks_msg'), 'Thanks for placing your order!')

String orderID = WebUI.getText(findTestObject('Object Repository/ReplicatedSite/span_rs_orderid'))

println(orderID)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/addItemsLink'))

WebUI.delay(5)

title = WebUI.getWindowTitle()

WebUI.verifyMatch(title, 'Clothes - Cabi Fall 2019 Collection', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_cart_svg'))


/********************order completed*************/
WebUI.delay(5)

//List<String> editOrderButton = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/div_edit_order_rs'), 
//    5)
//
//assert editOrderButton.size() > 0

WebUI.click(findTestObject('Object Repository/ReplicatedSite/shopForMoreItemsLink'))

WebUI.verifyMatch(title, 'Clothes - Cabi Fall 2019 Collection', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_cart_svg'))

WebUI.delay(5)

//WebUI.click(findTestObject('Object Repository/ReplicatedSite/div_edit_order_rs'))
//
//WebUI.delay(10)


//
//List<WebElement> updateButton = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/a_update_order'),1)
//assert updateButton.size() > 0
WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_update_order'))

WebUI.delay(5)

WebUI.callTestCase(findTestCase('EditOrder/rsUpdateOrder'), [:], FailureHandling.STOP_ON_FAILURE)

////end rsUpdateOrder
WebUI.delay(3)

/////cancel edit
WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_cancel_edit'))

List<String> cancelEditButton = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/h2_sure_to_cancel_edit'), 
    1)

assert cancelEditButton.size() > 0

WebUI.click(findTestObject('ReplicatedSite/button_yes_cancel_edit'))

////////////////span[contains(text(), '${orderID}')]/parent::div/parent::div/div[@class='table-row-edit-order']
//WebUI.delay(10)
String xpath = UtilityMethods.concat('//span[contains(text(), \'', orderID, '\')]/parent::div/parent::div/div[@class=\'table-row-edit-order\']')

TestObject to = new TestObject('a_edit_link')

to.addProperty('xpath', ConditionType.EQUALS, xpath)

WebUI.delay(5)

println(to.getXpaths())

//List<WebElement> editButton = WebUiCommonHelper.findWebElements(to, 1)
//assert editButton.size() > 0
WebUI.click(to)

//////////////
WebUI.delay(5)

/////cancel order
WebUI.click(findTestObject('Object Repository/ReplicatedSite/a_cancel_order'))

WebUI.delay(5)

List<String> cancelOrderButton = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/h2_sure_to_cancel_order'), 
    1)

assert cancelOrderButton.size() > 0

WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_yes_cancel_order'))

WebUI.delay(5)

TestObject div_cancelled_order = UtilityMethods.createTestObject('div_cancelled_order', '//span[contains(text(), \'', orderID, 
    '\')]/parent::div/parent::div/div[@class=\'table-row-status\']/span')

println(WebUI.getText(div_cancelled_order))

