import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/VirtualShowRSVPSuites/MicrositeTestSuite')

suiteProperties.put('name', 'MicrositeTestSuite')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\user\\Documents\\testautomation\\NewArrivals\\Reports\\VirtualShowRSVPSuites\\MicrositeTestSuite\\20190617_193118\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/VirtualShowRSVPSuites/MicrositeTestSuite', suiteProperties, [new TestCaseBinding('Test Cases/virtualShowRSVP/createShow', 'Test Cases/virtualShowRSVP/createShow',  [ 'verifyCohostess' : null , 'testEnvt' : null , 'password' : null , 'verifyGuest2' : null , 'cabiTestEnvt' : null , 'cohostess' : null , 'verifyGuestCount' : null , 'hostess' : null , 'verifyGuest1' : null , 'stylist' : null , 'guest1' : null , 'verifyHostess' : null , 'username' : null , 'guest2' : null ,  ]), new TestCaseBinding('Test Cases/virtualShowRSVP/micrositeRSVPValidUser', 'Test Cases/virtualShowRSVP/micrositeRSVPValidUser',  [ 'hostessPass' : null , 'cohostessPass' : null , 'ofbizUser' : null , 'cohostessMail' : null , 'guest1Mail' : null , 'guest1Pass' : null , 'ofbizPass' : null , 'guestUninvitedPass' : null , 'hostessMail' : null , 'guestUninvitedMail' : null , 'vHostTarget' : null , 'ofbizURL' : null ,  ])])
