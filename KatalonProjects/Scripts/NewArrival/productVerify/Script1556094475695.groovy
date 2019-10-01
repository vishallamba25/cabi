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

//WebUI.openBrowser('')
for (int row = 1; row <= findTestData('productData').getRowNumbers(); row++) {
    WebUI.setText(findTestObject('Object Repository/Page_cabi Order Items/input_New Arrivals - Blooming Blush_style'), findTestData(
            'productData').getValue('Style', row))

    WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Order Items/input_New Arrivals - Blooming Blush_style'), 
        Keys.chord(Keys.ENTER))

    WebUI.delay(2)

    WebUI.setText(findTestObject('Object Repository/Page_cabi Order Items/input_New Arrivals - Blooming Blush_style'), findTestData(
            'productData').getValue('Style', row))

    WebUI.sendKeys(findTestObject('Object Repository/Page_cabi Order Items/input_New Arrivals - Blooming Blush_style'), 
        Keys.chord(Keys.ENTER))	

    WebUI.delay(2)

    if (available.toString().equalsIgnoreCase('no')) {
        WebUI.delay(2)

        List<WebElement> noResultMessages = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Order Items/no_result_found'), 
            5)

        println(noResultMessages.size())

        assert noResultMessages.size() > 0

        WebUI.verifyElementText(findTestObject('Page_cabi Order Items/no_result_found'), 'No Results Found!', FailureHandling.CONTINUE_ON_FAILURE /*******screenshot***********************************/ ) /*******Style***********************************/
        //WebUI.delay(3)
        /*******Colour***********************************/
        /*******retail***********************************/
        /*******Size***********************************/
        /*******Description***********************************/
        /*******Fabric***********************************/
        /*******care instr***********************************/
    } else {
        WebUI.click(findTestObject('Page_cabi Order Items/li_order_item'))

        WebUI.delay(5)

        String imgString1 = findTestData('productData').getValue('Style', row).toString()

        String imagePath = UtilityMethods.createScreenshotImagePath(storeType, imgString1)

        println(imagePath)

        WebUI.takeScreenshot(imagePath)

        WebUI.verifyElementText(findTestObject('Page_cabi Order Items/GetAttribute_getID'), findTestData('productData').getValue(
                'Style', row), FailureHandling.CONTINUE_ON_FAILURE)

        List<WebElement> colorOptions = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Order Items/GetAttribute_Color'), 
            5)

        println(colorOptions.size())

        String expectedColour = findTestData('productData').getValue('Color', row)

        println('expected colour is')

        println(expectedColour)

        boolean colourVerified = false

        for (WebElement op : colorOptions) {
            println(op.getText())

            if (expectedColour.equalsIgnoreCase(op.getText())) {
                colourVerified = true

                break
            }
        }
        
        assert colourVerified == true

        String getPrice = WebUI.getText(findTestObject('Page_cabi Order Items/GetAttribute_Price'))

        String Split_Data = UtilityMethods.SplitData(getPrice)

        WebUI.verifyMatch(Split_Data, findTestData('productData').getValue('Retail', row), true, FailureHandling.CONTINUE_ON_FAILURE)

        String[] sizeRange1 = ['XXS', 'XS', 'S', 'M', 'L', 'XL']

        String[] sizeRange2 = ['00', '0', '2', '4', '6', '8', '10', '12', '14', '16']

        String[] sizeRange3 = ['Long', 'Regular', 'Short']

        String[] sizeRange4 = ['5', '6', '6.5', '7', '7.5', '8', '8.5', '9', '9.5', '10', '11']

        String[] sizeRange5 = ['XS/S', 'M/L']

        String[] sizeRangeSplit = UtilityMethods.SplitSizes(findTestData('productData').getValue('SzRange', row))

        String sizeType = WebUI.getText(findTestObject('Object Repository/Page_cabi Order Items/Size'))

        List<WebElement> sizeOptions = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Order Items/Size'), 
            5)

        ArrayList<String> actualRange = new ArrayList<String>()

        ArrayList<String> expectedRange

        if (sizeType.equalsIgnoreCase('Select')) {
            for (int i = 1; i < sizeOptions.size(); i++) {
                actualRange.add(sizeOptions.get(i).getAttribute('value').toString())
            }
            
            if (actualRange.get(0).toString().equalsIgnoreCase('XS') || actualRange.get(0).toString().equalsIgnoreCase('XXS')) {
                expectedRange = UtilityMethods.getExpectedRange(sizeRange1, sizeRangeSplit)

                println('XS')
            } else if (actualRange.get(0).toString().equalsIgnoreCase('00') || actualRange.get(0).toString().equalsIgnoreCase(
                '0')) {
                expectedRange = UtilityMethods.getExpectedRange(sizeRange2, sizeRangeSplit)

                println('00')
            } else if (actualRange.get(0).toString().equalsIgnoreCase('Long')) {
                expectedRange = UtilityMethods.getExpectedRange(sizeRange3, sizeRangeSplit)

                println('Long')
            } else if (actualRange.get(0).toString().equalsIgnoreCase('5')) {
                expectedRange = UtilityMethods.getExpectedRange(sizeRange4, sizeRangeSplit)

                println('S')
            } else if (actualRange.get(0).toString().equalsIgnoreCase('XS/S')) {
                expectedRange = UtilityMethods.getExpectedRange(sizeRange5, sizeRangeSplit)

                println('XS/S')
            } else {
                println('else')

                println(actualRange.get(0).toString())
            }
            
            println(expectedRange.toString())

            assert UtilityMethods.listEquals(expectedRange, actualRange) == true
        } else {
            assert sizeType.equalsIgnoreCase('N/A') || sizeType.equalsIgnoreCase(sizeRangeSplit[0])
        }
        
        WebUI.delay(2)

        WebUI.verifyElementText(findTestObject('Page_cabi Order Items/product_title'), findTestData('productData').getValue(
                'Description', row), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.verifyElementText(findTestObject('Page_cabi Order Items/product_fabric'), findTestData('productData').getValue(
                'FinalContent', row), FailureHandling.CONTINUE_ON_FAILURE)

        String actualCasreIntrn = ('<div>' + WebUI.getText(findTestObject('Page_cabi Order Items/care_instruction'))) + 
        '</div>'
		
		println actualCasreIntrn

        assert actualCasreIntrn.equals(findTestData('productData').getValue('CareInstr', row))
    }
}