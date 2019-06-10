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



RunConfiguration.setExecutionSettingFile("C:\\Users\\user\\Documents\\testautomation\\NewArrivals\\Reports\\VirtualShowRSVPSuites\\MicrositeTestSuite\\20190610_124033\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/VirtualShowRSVPSuites/MicrositeTestSuite', suiteProperties, [new TestCaseBinding('Test Cases/virtualShowRSVP/micrositeRSVPValidUser', 'Test Cases/virtualShowRSVP/micrositeRSVPValidUser',  [ 'hostessPass' : 'blackdress19' , 'cohostessPass' : 'blackdress19' , 'ofbizUser' : 'sshinde' , 'cohostessMail' : 'neocohost1a@test.com' , 'guest1Mail' : 'neoguest1ab@test.com' , 'guest1Pass' : 'blackdress19' , 'ofbizPass' : 'C@bi$ush5' , 'guestUninvitedPass' : 'blackdress19' , 'hostessMail' : 'neohost1a@test.com' , 'guestUninvitedMail' : 'neoguest2ab@test.com' , 'vHostTarget' : 'virtual_cabitest19' , 'ofbizURL' : 'https://pushofbiz.cliotest.com/login.php' ,  ])])