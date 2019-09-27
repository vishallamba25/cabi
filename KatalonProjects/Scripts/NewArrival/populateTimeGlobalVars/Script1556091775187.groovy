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

import commonUtility.UtilityMethods
import internal.GlobalVariable as GlobalVariable

String dataFile="timezoneData"

GlobalVariable.clockServerTarget= UtilityMethods.getTestData('envtData', 'clockServerTarget', 1) 
println GlobalVariable.clockServerTarget
GlobalVariable.orderType= UtilityMethods.getTestData(dataFile, 'orderType', row)
GlobalVariable.timeZone= UtilityMethods.getTestData(dataFile, 'timeZone', row)


GlobalVariable.BOPersonal= UtilityMethods.getTestData(dataFile, 'BOPersonal', row)
GlobalVariable.BOAddonPersonal= UtilityMethods.getTestData(dataFile, 'BOAddonPersonal', row)
GlobalVariable.BOAddonRetail= UtilityMethods.getTestData(dataFile, 'BOAddonRetail', row)
GlobalVariable.BORetail= UtilityMethods.getTestData(dataFile, 'BORetail', row)
GlobalVariable.BOShow= UtilityMethods.getTestData(dataFile, 'BOShow', row)
GlobalVariable.BOOnlineoutlet= UtilityMethods.getTestData(dataFile, 'BOOnlineoutlet', row)
GlobalVariable.BOEmployee= UtilityMethods.getTestData(dataFile, 'BOEmployee', row)
GlobalVariable.CCPersonal= UtilityMethods.getTestData(dataFile, 'CCPersonal', row)
GlobalVariable.CCRetail= UtilityMethods.getTestData(dataFile, 'CCRetail', row)
GlobalVariable.CCShow= UtilityMethods.getTestData(dataFile, 'CCShow', row)

GlobalVariable.BOEblast= UtilityMethods.getTestData(dataFile, 'BOEblast', row)

println row
println GlobalVariable.BOPersonal
