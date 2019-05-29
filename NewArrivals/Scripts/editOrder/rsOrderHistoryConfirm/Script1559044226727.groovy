import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commonUtility.UtilityMethods
import internal.GlobalVariable as GlobalVariable


orderID = GlobalVariable.retailOrderID
println orderID
//orderID = "1234"

////////////////span[contains(text(), '${orderID}')]/parent::div/parent::div/div[@class='table-row-edit-order']
String dynamicId = 'Katalon123'
String xpath = UtilityMethods.concat("//span[contains(text(), '", orderID, "')]/parent::div/parent::div/div[@class='table-row-edit-order']")
//String xpath = '//div[@id="' + dynamicId + '"]'
TestObject to = new TestObject("a_link_dynamic")
to.addProperty("xpath", ConditionType.EQUALS, xpath)
//WebUI.click(to)
//////////////

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/i_Michigan_fa fa-caret-down'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/a_My Profile'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Profile - Cabi Fall 2018 Collection/span_Order History'))

WebUI.delay(5)

List<WebElement> editButton = WebUiCommonHelper.findWebElements(to, 1)

assert editButton.size() > 0

if (editButton.size() > 0) {
	WebUI.click(to)
}


