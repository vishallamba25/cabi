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

WebUI.callTestCase(findTestCase('cabiWarehouseLogin'), [('CWURL') : '', ('CWuser') : '', ('CWpass') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_cabi Manage PickLists/a_Create PickLists'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi SampleLine Shipment Screen/a_Single Order'))

<<<<<<< HEAD
WebUI.setText(findTestObject('Page_cabi Create Single Order PickList/input_Order Id_orderId'), orderId)
=======
WebUI.setText(findTestObject('Page_cabi Create Single Order PickList/input_Order Id_orderId'), ' RT707934509')
>>>>>>> 29279761128638fb29c27501e86a25ce8fa615aa

WebUI.click(findTestObject('Page_cabi Create Single Order PickList/input_Create even if fully backordered_submitButton'))

not_run: WebUI.verifyElementText(findTestObject('Cabi warehouse/picklistCreatedMessage'), 'Picklist for order has been created successfully.')

WebUI.click(findTestObject('Page_cabi Create Single Order PickList/a_Manage PickLists'))

<<<<<<< HEAD
WebUI.setText(findTestObject('Page_cabi Manage PickLists/input_Order _orderId'), orderId)
=======
WebUI.setText(findTestObject('Page_cabi Manage PickLists/input_Order _orderId'), ' RT707934509')
>>>>>>> 29279761128638fb29c27501e86a25ce8fa615aa

WebUI.click(findTestObject('Page_cabi Manage PickLists/input'))

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


<<<<<<< HEAD
=======
WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Home/a_Shows  Orders'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Home/a_Orders'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/b'))

WebUI.delay(3)

WebUI.click(findTestObject('findOrders/Page_cabi Find Orders/orderNo'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/pendingShipment'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/inputShipped'))

WebUI.setText(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/inputOrderId'), ' RT707934509')

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Find Orders/findOrders'))

WebUI.click(findTestObject('findOrders/Page_cabi Find Orders/orderView'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Order View/a_(Return Order)'))

WebUI.delay(3)

WebUI.selectOptionByValue(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/selectReason1'), 
    'CABI_c', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/selectReason2'), 
    'CABI_c_a', true)

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/inputRefund'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_Next'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/inputPostalService'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/inputConfirmAdderess'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_Next_1'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/a_Submit RMA'))

WebUI.click(findTestObject('Object Repository/findOrders/Page_cabi Find Orders/Page_cabi Stylist Create RMA/addonOrder'))
>>>>>>> 29279761128638fb29c27501e86a25ce8fa615aa

