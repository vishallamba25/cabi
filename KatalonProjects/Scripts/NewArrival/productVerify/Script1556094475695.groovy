import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By
import org.testng.asserts.SoftAssert

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


import commonUtility.UtilityMethods as UtilityMethods

//WebUI.openBrowser('')
SoftAssert sa;
String styleid_data;
By by;
WebElement styleWe;
TestObject to;


WebDriver driver = DriverFactory.getWebDriver()
int rowNumbers= findTestData('productData').getRowNumbers()
println rowNumbers
for (int row = 1; row <= rowNumbers; row++) {
	WebUI.delay(5)
	sa= new SoftAssert();
	
	styleid_data = findTestData('productData').getValue('Style', row)
	println "******************+++++++++++++++++++**********************************************"
	println styleid_data
	/*****************solving stale element exception problem*******************/
	by= By.xpath("//input[@name='style']")
	styleWe= UtilityMethods.getElementByLocator(by, driver)
	to= UtilityMethods.fromElement(styleWe)
	
	//findTestObject('Object Repository/Page_cabi Order Items/input_New Arrivals - Blooming Blush_style')
	
    WebUI.setText(to, styleid_data)

    WebUI.sendKeys(to, Keys.chord(Keys.ENTER))
	/*****************solving stale element exception problem*******************/
    WebUI.delay(2)


    //WebUI.setText(findTestObject('Object Repository/Page_cabi Order Items/input_New Arrivals - Blooming Blush_style'), findTestData(
    //      'productData').getValue('Style', row))

    //WebUI.sendKeys(to, Keys.chord(Keys.ENTER))	

	//WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(WebUiCommonHelper.findWebElement(to, 30)))
    
	//WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_cabi Order Items/input_New Arrivals - Blooming Blush_style'),30)))
    

    //WebUI.delay(2)

    if (available.toString().equalsIgnoreCase('no')) {
        WebUI.delay(2)

        List<WebElement> noResultMessages = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Order Items/no_result_found'), 
            5)

        println(noResultMessages.size())

		sa.assertTrue(noResultMessages.size() > 0)
        //assert noResultMessages.size() > 0

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

        String imagePath = UtilityMethods.createScreenshotImagePath(storeType, styleid_data)

        println(imagePath)

        WebUI.takeScreenshot(imagePath)

        WebUI.verifyElementText(findTestObject('Page_cabi Order Items/GetAttribute_getID'), styleid_data, FailureHandling.CONTINUE_ON_FAILURE)

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
        
		sa.assertTrue(colourVerified)
        //assert colourVerified == true

        String getPrice = WebUI.getText(findTestObject('Page_cabi Order Items/GetAttribute_Price'))

        String Split_Data = UtilityMethods.SplitData(getPrice)

        WebUI.verifyMatch(Split_Data, findTestData('productData').getValue('Retail', row), true, FailureHandling.CONTINUE_ON_FAILURE)

<<<<<<< HEAD
        String[] sizeRange1 = ['XXS', 'XS', 'S', 'M', 'L', 'XL','XXL']
=======
        String[] sizeRange1 = ['XXS', 'XS', 'S', 'M', 'L', 'XL', 'XXL']
>>>>>>> 45ddcf8a36005955970df0fe3698d707966c82b4

        String[] sizeRange2 = ['00', '0', '2', '4', '6', '8', '10', '12', '14', '16']

        String[] sizeRange3 = ['Long', 'Regular', 'Short']

        String[] sizeRange4 = ['5', '6', '6.5', '7', '7.5', '8', '8.5', '9', '9.5', '10', '11']

        String[] sizeRange5 = ['XS/S', 'M/L']
		
		String[] sizeRange6 = ['One Size']

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
            } else if (actualRange.get(0).toString().equalsIgnoreCase('One Size')) {
                expectedRange = UtilityMethods.getExpectedRange(sizeRange6, sizeRangeSplit)

                println('One Size')
            }else {
                println('else')

                println(actualRange.get(0).toString())
            }
            
            println(expectedRange.toString())

			sa.assertTrue(UtilityMethods.listEquals(expectedRange, actualRange))
            //assert UtilityMethods.listEquals(expectedRange, actualRange) == true
        } else {
			sa.assertTrue(sizeType.equalsIgnoreCase('N/A') || sizeType.equalsIgnoreCase(sizeRangeSplit[0]))
            //assert sizeType.equalsIgnoreCase('N/A') || sizeType.equalsIgnoreCase(sizeRangeSplit[0])
        }
        
        WebUI.delay(2)

        WebUI.verifyElementText(findTestObject('Page_cabi Order Items/product_title'), findTestData('productData').getValue(
                'Description', row), FailureHandling.CONTINUE_ON_FAILURE)

		String finalContent=findTestData('productData').getValue('FinalContent', row);
		if(finalContent.equalsIgnoreCase("")){
			List<WebElement> fContent = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Order Items/product_fabric'), 5)
			sa.assertTrue(fContent.size() == 0)
		}
		else{
			WebUI.verifyElementText(findTestObject('Page_cabi Order Items/product_fabric'), finalContent, FailureHandling.CONTINUE_ON_FAILURE)
		}
		
        

        String actualCasreIntrn = ('<div>' + WebUI.getText(findTestObject('Page_cabi Order Items/care_instruction'))) + 
        '</div>'

		sa.assertTrue(actualCasreIntrn.equals(findTestData('productData').getValue('CareInstr', row)))
        //assert actualCasreIntrn.equals(findTestData('productData').getValue('CareInstr', row))
    }
}