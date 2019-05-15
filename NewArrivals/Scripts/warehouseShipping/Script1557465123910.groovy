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
//orderId="PR707945104"
WebUI.openBrowser("")
WebUI.callTestCase(findTestCase('cabiWarehouseLogin'), [('CWURL') : '', ('CWuser') : '', ('CWpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_cabi Manage PickLists/a_Create PickLists'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi SampleLine Shipment Screen/a_Single Order'))

WebUI.setText(findTestObject('Page_cabi Create Single Order PickList/input_Order Id_orderId'), orderId)

WebUI.click(findTestObject('Page_cabi Create Single Order PickList/input_Create even if fully backordered_submitButton'))

not_run: WebUI.verifyElementText(findTestObject('Cabi warehouse/picklistCreatedMessage'), 'Picklist for order has been created successfully.')

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

WebUI.click(findTestObject('Cabi warehouse/warehouseLogout'))

