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
import internal.GlobalVariable as GlobalVariable

for (int row = 1; row <= findTestData('productData').getRowNumbers(); row++) {
    WebUI.setText(findTestObject('Page_cabicentral_orders/input_style'), findTestData('productData').getValue('Style', row))

    WebUI.delay(5)

    WebUI.sendKeys(findTestObject('Page_cabicentral_orders/input_style'), Keys.chord(Keys.ENTER))

    if (available.toString().equalsIgnoreCase('no')) {
		List<WebElement> noResultMessages = WebUiCommonHelper.findWebElements(findTestObject('Page_cabi Order Items/no_result_found'),5)
		assert noResultMessages.size()>0
		WebUI.verifyElementText(findTestObject('Page_cabi Order Items/no_result_found'), "No Results Found!")
		
    }
	else{
		WebUI.click(findTestObject('Page_cabi Order Items/li_5618 Breeze Dress'))
		
			WebUI.delay(3)
		
			/*******Style***********************************/
			WebUI.verifyElementText(findTestObject('Page_cabi Order Items/GetAttribute_getID'), findTestData('productData').getValue(
					'Style', row))
		
			WebUI.delay(3)
		
			/*******Colour***********************************/
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
		
			/*******retail***********************************/
			String getPrice = WebUI.getText(findTestObject('Page_cabi Order Items/GetAttribute_Price'))
		
			String Split_Data = UtilityMethods.SplitData(getPrice)
		
			WebUI.verifyMatch(Split_Data, findTestData('productData').getValue('Retail', row), true)
		
			/*******Size***********************************/
			String[] sizeRange1 = ['XXS', 'XS', 'S', 'M', 'L', 'XL']
		
			String[] sizeRange2 = ['00', '0', '2', '4', '6', '8', '10', '12', '14', '16']
		
			String[] sizeRange3 = ['Long', 'Regular', 'Short']
		
			String[] sizeRange4 = ['5', '6', '6.5', '7', '7.5', '8', '8.5', '9', '9.5', '10', '11']
		
			String[] sizeRangeSplit = UtilityMethods.SplitSizes(findTestData('productData').getValue('SzRange', row))
		
			String sizeType = WebUI.getText(findTestObject('Object Repository/Page_cabi Order Items/Size'))
		
			List<WebElement> sizeOptions = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_cabi Order Items/Size'),
				5)
		
			ArrayList<String> actualRange = new ArrayList<String>()
		
			ArrayList<String> expectedRange
		
			if (sizeType.equalsIgnoreCase('Select')) {
				for (int i = 1; i < sizeOptions.size(); i++) {
					actualRange.add(sizeOptions.get(i).getText())
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
				} else {
					println('else')
		
					println(actualRange.get(0).toString())
				}
				
				println(expectedRange.toString())
		
				assert UtilityMethods.listEquals(expectedRange, actualRange) == true
			} else {
				assert sizeType.equalsIgnoreCase('N/A') || sizeType.equalsIgnoreCase(sizeRangeSplit[0])
			}
			
			WebUI.delay(3)
		
			/*******Description***********************************/
			WebUI.verifyElementText(findTestObject('Page_cabi Order Items/product_title'), findTestData('productData').getValue(
					'Description', row))
		
			/*******Fabric***********************************/
			WebUI.verifyElementText(findTestObject('Page_cabi Order Items/product_fabric'), findTestData('productData').getValue(
					'FinalContent', row))
		
			/*******care instr***********************************/
			String actualCasreIntrn = ('<div>' + WebUI.getText(findTestObject('Page_cabi Order Items/care_instruction'))) + '</div>'
		
			assert actualCasreIntrn.equals(findTestData('productData').getValue('CareInstr', row))
	}
    
    
}

