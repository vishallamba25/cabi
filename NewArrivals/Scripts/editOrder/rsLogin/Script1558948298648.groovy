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

RSURL = findTestData('credData').getValue('RSURL', 1)

RSuser = findTestData('credData').getValue('RSuser', 1)

RSpass = findTestData('credData').getValue('RSpass', 1)

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(RSURL)

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/i_Not my stylist_fa fa-user'))

WebUI.setText(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/input_Sign in  Create account_email'), 
    RSuser)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/button_Continue'))

WebUI.setText(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/input_Welcome_password'), 
    RSpass)

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/button_Continue'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/completeProfileLater'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/i_Michigan_fa fa-caret-down'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/a_My Profile'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Profile - Cabi Fall 2018 Collection/span_Order History'))

