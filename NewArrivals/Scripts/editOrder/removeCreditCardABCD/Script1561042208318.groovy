import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods

String RSURL = findTestData('credData').getValue('RSURL', 1)
String cartURL= UtilityMethods.concat(RSURL, "/cart/")
WebUI.navigateToUrl(cartURL)