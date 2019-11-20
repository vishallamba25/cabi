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


suiteProperties.put('id', 'Test Suites/NewArrivalsSuites/NewArrivalsSuite1')

suiteProperties.put('name', 'NewArrivalsSuite1')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\user\\Documents\\testautomation\\KatalonProjects\\Reports\\NewArrivalsSuites\\NewArrivalsSuite1\\20191114_154839\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/NewArrivalsSuites/NewArrivalsSuite1', suiteProperties, [new TestCaseBinding('Test Cases/NA_Timezone_Separated/BOPersonal1', 'Test Cases/NA_Timezone_Separated/BOPersonal1',  null), new TestCaseBinding('Test Cases/NA_Timezone_Separated/BORetail6', 'Test Cases/NA_Timezone_Separated/BORetail6',  null), new TestCaseBinding('Test Cases/NA_Timezone_Separated/addOnOrderPersonal1', 'Test Cases/NA_Timezone_Separated/addOnOrderPersonal1',  null), new TestCaseBinding('Test Cases/NA_Timezone_Separated/addOnOrderPersonal2', 'Test Cases/NA_Timezone_Separated/addOnOrderPersonal2',  null), new TestCaseBinding('Test Cases/NA_Timezone_Separated/addOnOrderPersonal3', 'Test Cases/NA_Timezone_Separated/addOnOrderPersonal3',  null), new TestCaseBinding('Test Cases/NA_Timezone_Separated/addOnOrderPersonal4', 'Test Cases/NA_Timezone_Separated/addOnOrderPersonal4',  null), new TestCaseBinding('Test Cases/NA_Timezone_Separated/addOnOrderPersonal5', 'Test Cases/NA_Timezone_Separated/addOnOrderPersonal5',  null), new TestCaseBinding('Test Cases/NA_Timezone_Separated/addOnOrderPersonal6', 'Test Cases/NA_Timezone_Separated/addOnOrderPersonal6',  null)])
