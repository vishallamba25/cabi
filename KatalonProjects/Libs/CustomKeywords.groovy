
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import java.util.ArrayList

import com.kms.katalon.core.testobject.TestObject

import java.util.List


def static "commonUtility.UtilityMethods.SplitData"(
    	String Data	) {
    (new commonUtility.UtilityMethods()).SplitData(
        	Data)
}

def static "commonUtility.UtilityMethods.SplitSizes"(
    	String Data	) {
    (new commonUtility.UtilityMethods()).SplitSizes(
        	Data)
}

def static "commonUtility.UtilityMethods.splitPersonName"(
    	String Data	) {
    (new commonUtility.UtilityMethods()).splitPersonName(
        	Data)
}

def static "commonUtility.UtilityMethods.getExpectedRange"(
    	String[] sizeRange	
     , 	String[] arr	) {
    (new commonUtility.UtilityMethods()).getExpectedRange(
        	sizeRange
         , 	arr)
}

def static "commonUtility.UtilityMethods.listEquals"(
    	java.util.ArrayList<String> expectedRange	
     , 	java.util.ArrayList<String> actualRange	) {
    (new commonUtility.UtilityMethods()).listEquals(
        	expectedRange
         , 	actualRange)
}

def static "commonUtility.UtilityMethods.getTestData"(
    	String testData	
     , 	String header	
     , 	int row	) {
    (new commonUtility.UtilityMethods()).getTestData(
        	testData
         , 	header
         , 	row)
}

def static "commonUtility.UtilityMethods.getWebElementsAsList"(
    	String xpath4elements	) {
    (new commonUtility.UtilityMethods()).getWebElementsAsList(
        	xpath4elements)
}

def static "commonUtility.UtilityMethods.createScreenshotImagePath"(
    	String storeType	
     , 	String style	) {
    (new commonUtility.UtilityMethods()).createScreenshotImagePath(
        	storeType
         , 	style)
}

def static "commonUtility.UtilityMethods.createSkuForPWL"(
    	String productStyle	
     , 	String productDescription	
     , 	String productColor	) {
    (new commonUtility.UtilityMethods()).createSkuForPWL(
        	productStyle
         , 	productDescription
         , 	productColor)
}

def static "commonUtility.UtilityMethods.splitStyle"(
    	String style	) {
    (new commonUtility.UtilityMethods()).splitStyle(
        	style)
}

def static "commonUtility.UtilityMethods.concat"(
    	String[] s	) {
    (new commonUtility.UtilityMethods()).concat(
        	s)
}

def static "commonUtility.UtilityMethods.createURL"(
    	String rsName	
     , 	String cabitTestEnvt	
     , 	String showID	) {
    (new commonUtility.UtilityMethods()).createURL(
        	rsName
         , 	cabitTestEnvt
         , 	showID)
}

def static "commonUtility.UtilityMethods.createTestObject"(
    	String name	
     , 	String[] s	) {
    (new commonUtility.UtilityMethods()).createTestObject(
        	name
         , 	s)
}

def static "commonUtility.UtilityMethods.getFavCount"(
    	String guest	) {
    (new commonUtility.UtilityMethods()).getFavCount(
        	guest)
}

def static "commonUtility.UtilityMethods.takeWebElementScreenshot"(
    	TestObject tobj	) {
    (new commonUtility.UtilityMethods()).takeWebElementScreenshot(
        	tobj)
}

def static "commonUtility.UtilityMethods.validateGuestsListDashboard"(
    	java.util.List<commonUtility.VSGuest> yesList	
     , 	java.util.List<commonUtility.VSGuest> noList	
     , 	java.util.List<commonUtility.VSGuest> maybeList	
     , 	java.util.List<commonUtility.VSGuest> noreplyList	
     , 	java.util.List<commonUtility.VSGuest> presentList	
     , 	java.util.List<commonUtility.VSGuest> allList	) {
    (new commonUtility.UtilityMethods()).validateGuestsListDashboard(
        	yesList
         , 	noList
         , 	maybeList
         , 	noreplyList
         , 	presentList
         , 	allList)
}
