import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())


RunConfiguration.setExecutionSettingFile('C:\\Users\\user\\AppData\\Local\\Temp\\Katalon\\20190528_154110\\execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runWSVerificationScript(new TestCaseBinding('',['RSURL': '', 'RSuser': '', 'RSpass': '']), 'import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI\nimport com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile\nimport com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW\nimport com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS\nimport static com.kms.katalon.core.testobject.ObjectRepository.findTestObject\nimport static com.kms.katalon.core.testdata.TestDataFactory.findTestData\nimport static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase\nimport static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint\nimport com.kms.katalon.core.model.FailureHandling as FailureHandling\nimport com.kms.katalon.core.testcase.TestCase as TestCase\nimport com.kms.katalon.core.testdata.TestData as TestData\nimport com.kms.katalon.core.testobject.TestObject as TestObject\nimport com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint\nimport internal.GlobalVariable as GlobalVariable\nimport org.openqa.selenium.Keys as Keys\n\nRSURL = findTestData(\'credData\').getValue(\'RSURL\', 1)\n\nRSuser = findTestData(\'credData\').getValue(\'RSuser\', 1)\n\nRSpass = findTestData(\'credData\').getValue(\'RSpass\', 1)\n\nWebUI.openBrowser(\'\')\n\nWebUI.maximizeWindow()\n\nWebUI.navigateToUrl(RSURL)\n\nWebUI.delay(5)\n\nWebUI.click(findTestObject(\'Page_Trendy Womens Fashion and Outfits  Cabi Clothing/i_Not my stylist_fa fa-user\'))\n\nWebUI.setText(findTestObject(\'Page_Trendy Womens Fashion and Outfits  Cabi Clothing/input_Sign in  Create account_email\'), \n    RSuser)\n\nWebUI.click(findTestObject(\'Page_Trendy Womens Fashion and Outfits  Cabi Clothing/button_Continue\'))\n\nWebUI.setText(findTestObject(\'Page_Trendy Womens Fashion and Outfits  Cabi Clothing/input_Welcome_password\'), RSpass)\n\nWebUI.click(findTestObject(\'Page_Trendy Womens Fashion and Outfits  Cabi Clothing/button_Continue\'))\n\n', FailureHandling.STOP_ON_FAILURE, true)

