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
import commonUtility.UtilityMethods as UtilityMethods
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

//available="no"
WebUI.openBrowser('')
for (int timeRow = 1; timeRow <= findTestData('timezoneData').getRowNumbers(); timeRow++) {
    WebUI.callTestCase(findTestCase('NewArrival/populateTimeGlobalVars'), [('row') : timeRow], FailureHandling.CONTINUE_ON_FAILURE)
	available= GlobalVariable.BOEblast;

    WebUI.callTestCase(findTestCase('NewArrival/setTimezone'), [('ofbizURL') : '', ('ofbizuser') : '', ('ofbizpass') : ''
            , ('orderType') : GlobalVariable.orderType, ('timeZone') : GlobalVariable.timeZone, ('clockServerTarget') : GlobalVariable.clockServerTarget], 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.callTestCase(findTestCase('TestCaseUtilities/backOfficeLogin'), [('BOURL') : '', ('BOuser') : '', ('BOpass') : ''], 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Shows  Orders'))

    WebUI.click(findTestObject('Object Repository/Page_cabi Home/a_Product Watch List'))

    if (available.toString().equalsIgnoreCase('no')) {
        List<WebElement> noResultFound = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Product Watch list/span_(New Arrivals 1)'), 
            5)

        assert noResultFound.size() == 0
    } else {
        WebUI.click(findTestObject('Object Repository/Page_cabi Product Watch list/span_(New Arrivals 1)'))

        WebUI.verifyElementText(findTestObject('Object Repository/Page_cabi Product Watch list/span_(New Arrivals 1)'), '(New Arrivals 1)')

        List<WebElement> actualProductList = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Product Watch list/div_product_list_na1'), 
            5)

        println(actualProductList.size())

        ArrayList<String> actualList = new ArrayList<String>()

        ArrayList<String> expectedList = new ArrayList<String>()

        for (WebElement product : actualProductList) {
            actualList.add(product.getText())

            println(product.getText())
        }
        
		int p1Rows= findTestData('productData1').getRowNumbers();
		println p1Rows
        for (int row = 1; row <= p1Rows; row++) {
            String productStyle = findTestData('productData1').getValue('Style', row)

            String productDescription = findTestData('productData1').getValue('Description', row)

            String productColor = findTestData('productData1').getValue('Color', row)

            String expectedString = UtilityMethods.createSkuForPWL(productStyle, productDescription, productColor)

            println(expectedString)

            expectedList.add(expectedString)
        }
        println expectedList.size();
        assert UtilityMethods.listEquals(expectedList, actualList) == true
    }
}