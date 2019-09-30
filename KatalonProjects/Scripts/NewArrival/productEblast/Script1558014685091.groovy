import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import commonUtility.UtilityMethods as UtilityMethods
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.stringtemplate.v4.compiler.STParser.listElement_return as listElement_return

//available= "no"
WebUI.openBrowser('')
for (int timeRow = 1; timeRow <= findTestData('timezoneData').getRowNumbers(); timeRow++) {
    WebUI.callTestCase(findTestCase('NewArrival/populateTimeGlobalVars'), [('row') : timeRow], FailureHandling.STOP_ON_FAILURE)
	available= GlobalVariable.BOEblast;
	
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

        WebUI.setText(findTestObject('Page_cabi Eblast/eBlastStyleSearch'), findTestData('productData').getValue('Style', 
                row))

        //WebUI.delay(4)

        if (available.toString().equalsIgnoreCase('no')) {
			WebUI.delay(5)
            List<WebElement> style_notfound = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Eblast/styleNotFound'), 5)
<<<<<<< HEAD

			WebUI.delay(4)	
      
			println(style_notfound.size())
=======
			
			
            println(style_notfound.size())
>>>>>>> ee6b80c3a6c1dbbda90c4fba21f0c3bfff03f623

            assert style_notfound.size() > 0

            WebUI.verifyElementText(findTestObject('Page_cabi Eblast/styleNotFound'), 'No matching product')
        } else {
            String space = ' '

            String openbrace = '('

            String closebrace = ')'

            String style_id = WebUI.getText(findTestObject('Page_cabi Eblast/style_id'))

            String style_name = WebUI.getText(findTestObject('Page_cabi Eblast/style_name'))

            String style_color = WebUI.getText(findTestObject('Page_cabi Eblast/style_color'))

            style_web = "$style_id$space$style_name$space$style_color"

            String styleid_data = findTestData('productData').getValue('Style', row)

            String styleid_name = findTestData('productData').getValue('Description', row)

            String styleid_color = findTestData('productData').getValue('Color', row)

            style_data = "$styleid_data$space$styleid_name$space$openbrace$styleid_color$closebrace"

            println(style_web)

            println(style_data)

            assert style_data.equalsIgnoreCase(style_web)
        }
    }
}