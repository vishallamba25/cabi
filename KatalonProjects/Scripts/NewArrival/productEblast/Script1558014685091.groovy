import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement
import org.testng.asserts.SoftAssert

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

//available= "no"
WebUI.openBrowser('')
SoftAssert sa;

for (int timeRow = 3; timeRow <= findTestData('timezoneData').getRowNumbers(); timeRow++) {
    WebUI.callTestCase(findTestCase('NewArrival/populateTimeGlobalVars'), [('row') : timeRow], FailureHandling.STOP_ON_FAILURE)

    available = GlobalVariable.BOEblast

    WebUI.callTestCase(findTestCase('NewArrival/setTimezone'), [('ofbizURL') : '', ('ofbizuser') : '', ('ofbizpass') : ''
            , ('orderType') : GlobalVariable.orderType, ('timeZone') : GlobalVariable.timeZone, ('clockServerTarget') : GlobalVariable.clockServerTarget], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Page_cabi Home/a_Connections'))

    WebUI.click(findTestObject('Page_cabi Home/a_Contact Manager'))

    WebUI.click(findTestObject('Page_cabi/span_SEND eBLAST'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Eblast/a_Stylist Picks'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Eblast/button_ADD PRODUCTS TO EBLAST'))

    for (int row = 1; row <= findTestData('productData').getRowNumbers(); row++) {
        WebUI.delay(2)

        String styleid_data = findTestData('productData').getValue('Style', row)

        /*String[] styleid_data_arr= styleid_data.split("");
		String tmp=""
		for(String ele: styleid_data_arr){
			
		}*/
        WebUI.setText(findTestObject('Page_cabi Eblast/eBlastStyleSearch'), styleid_data)

        WebUI.delay(2)

        WebUI.click(findTestObject('Object Repository/Page_cabi Eblast/div_add_product_h3'))

        WebUI.setText(findTestObject('Page_cabi Eblast/eBlastStyleSearch'), styleid_data)

        WebUI.delay(2)

        WebUI.click(findTestObject('Object Repository/Page_cabi Eblast/div_add_product_h3'))

        WebUI.delay(1)
		sa=new SoftAssert()

        if (available.toString().equalsIgnoreCase('no')) {
            WebUI.delay(5)

            List<WebElement> style_notfound = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Eblast/styleNotFound'), 
                5)

            WebUI.delay(4)

            println(style_notfound.size())

			sa.assertTrue(style_notfound.size() > 0)
            //assert style_notfound.size() > 0

            WebUI.verifyElementText(findTestObject('Page_cabi Eblast/styleNotFound'), 'No matching product')
        } else {
            List<WebElement> div_product = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Eblast/div_product'), 
                5)

            if (div_product.size() > 0) {
            }
            
            String space = ' '

            String openbrace = '('

            String closebrace = ')'

            String style_id = WebUI.getText(findTestObject('Page_cabi Eblast/style_id'))

            String style_name = WebUI.getText(findTestObject('Page_cabi Eblast/style_name'))

            String style_color = WebUI.getText(findTestObject('Page_cabi Eblast/style_color'))

            String style_web = "$style_id$space$style_name$space$style_color"

            String styleid_name = findTestData('productData').getValue('Description', row)

            String styleid_color = findTestData('productData').getValue('Color', row)

            style_data = "$styleid_data$space$styleid_name$space$openbrace$styleid_color$closebrace"

            println(style_web)

            println(style_data)

			sa.assertTrue(style_data.equalsIgnoreCase(style_web))
            //assert style_data.equalsIgnoreCase(style_web)
        }
    }
}