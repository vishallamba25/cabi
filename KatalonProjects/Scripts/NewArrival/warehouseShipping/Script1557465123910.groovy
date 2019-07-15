import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//orderId="PR707945104"
//WebUI.openBrowser("")
WebUI.callTestCase(findTestCase('TestCaseUtilities/cabiWarehouseLogin'), [('CWURL') : '', ('CWuser') : '', ('CWpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_cabi Manage PickLists/a_Create PickLists'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi SampleLine Shipment Screen/a_Single Order'))

WebUI.setText(findTestObject('Page_cabi Create Single Order PickList/input_Order Id_orderId'), orderId)

WebUI.click(findTestObject('Page_cabi Create Single Order PickList/input_Create even if fully backordered_submitButton'))

List<WebElement> pickListCreated = WebUiCommonHelper.findWebElements(findTestObject('Cabi warehouse/picklistCreatedMessage'),
	5)

if (pickListCreated.size() == 0) {
	WebUI.refresh()
	WebUI.delay(10)
	WebUI.setText(findTestObject('Page_cabi Create Single Order PickList/input_Order Id_orderId'), orderId)
	WebUI.click(findTestObject('Page_cabi Create Single Order PickList/input_Create even if fully backordered_submitButton'))
}

String picklistCreatedMessage= commonUtility.UtilityMethods.concat("Picklist for order: [", orderId, "] has been created successfully.")
WebUI.verifyElementText(findTestObject('Cabi warehouse/picklistCreatedMessage'), picklistCreatedMessage)

WebUI.click(findTestObject('Page_cabi Create Single Order PickList/a_Manage PickLists'))

WebUI.setText(findTestObject('Page_cabi Manage PickLists/input_Order _orderId'), orderId)

WebUI.click(findTestObject('Page_cabi Manage PickLists/input'))

WebUI.delay(3)

WebUI.click(findTestObject('Page_cabi Manage PickLists/td_104238610'))

picklistId = WebUI.getText(findTestObject('Page_cabi Manage PickLists/td_104238610'))

WebUI.click(findTestObject('Page_cabi Manage PickLists/a_Packing'))

WebUI.setText(findTestObject('Page_cabi Pack Init/input_Pack Station_packStationId'), '30')

WebUI.click(findTestObject('Page_cabi Pack Init/input_Pack Station_submitButton'))

WebUI.setText(findTestObject('Page_cabi Pack Init/input_Picklist ID_pickId'), picklistId)

WebUI.click(findTestObject('Page_cabi Pack Init/input_Picklist ID_submitButton'))

WebUI.click(findTestObject('Page_cabi General Pack/input_Cream Of Wheat_button addItemForVerification'))

WebUI.click(findTestObject('Page_cabi General Pack/input_Pack Station  30_shipConfirmBtn'))

WebUI.delay(3)

List<WebElement> itemsNotpacked = WebUiCommonHelper.findWebElements(findTestObject('Cabi warehouse/itemsNotPacked'),
	5)

if (itemsNotpacked.size() > 0) {
	
	WebUI.click(findTestObject('Cabi warehouse/completeAnywayButton'))
}


WebUI.click(findTestObject('Cabi warehouse/warehouseLogout'))

