import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


orderID = GlobalVariable.retailOrderID
orderID= "qwwqeqe"
println orderID

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/i_Michigan_fa fa-caret-down'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/a_My Profile'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Profile - Cabi Fall 2018 Collection/span_Order History'))

List<WebElement> editButton = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/Page_Profile - Cabi Fall 2018 Collection/a_edit_order'),
	1)

assert editButton.size() > 0

if (editButton.size() == 0) {
	WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Profile - Cabi Fall 2018 Collection/a_edit_order'))
}



