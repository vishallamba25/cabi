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


suiteProperties.put('id', 'Test Suites/NewArrivalSuite')

suiteProperties.put('name', 'NewArrivalSuite')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\user\\Documents\\testautomation\\NewArrivals\\Reports\\NewArrivalSuite\\20190516_200338\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/NewArrivalSuite', suiteProperties, [new TestCaseBinding('Test Cases/NewArrivals', 'Test Cases/NewArrivals',  [ 'BOpass' : 'blackdress19' , 'BOuser' : '400000002' , 'BOURL' : 'https://test17.cliotest.com/backoffice/control/main' , 'ofbizuser' : 'sshinde' , 'ofbizpass' : 'C@bi$ush5' , 'ofbizURL' : 'https://pushofbiz.cliotest.com/login.php' ,  ])])
