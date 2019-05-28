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


orderID = GlobalVariable.retailOrderID

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/i_Michigan_fa fa-caret-down'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/a_My Profile'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Profile - Cabi Fall 2018 Collection/span_Order History'))

List<WebElement> editButton = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/Page_Profile - Cabi Fall 2018 Collection/a_edit_order'),
	1)

assert editButton.size() > 0

if (editButton.size() == 0) {
	WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Profile - Cabi Fall 2018 Collection/a_edit_order'))
}



