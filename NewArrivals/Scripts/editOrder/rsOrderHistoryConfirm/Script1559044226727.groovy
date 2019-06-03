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

////////////////span[contains(text(), '${orderID}')]/parent::div/parent::div/div[@class='table-row-edit-order']
String xpath = UtilityMethods.concat("//span[contains(text(), '", orderID, "')]/parent::div/parent::div/div[@class='table-row-edit-order']")
TestObject to = new TestObject("a_link_dynamic")
to.addProperty("xpath", ConditionType.EQUALS, xpath)
//////////////

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/i_Michigan_fa fa-caret-down'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Trendy Womens Fashion and Outfits  Cabi Clothing/a_My Profile'))

WebUI.click(findTestObject('Object Repository/ReplicatedSite/Page_Profile - Cabi Fall 2018 Collection/span_Order History'))

WebUI.delay(5)

List<WebElement> editButton = WebUiCommonHelper.findWebElements(to, 1)

assert editButton.size() > 0

if (editButton.size() > 0) {
	WebUI.click(to)
	WebUI.delay(10)
	
	if(editScenarioNumber==1 || editScenarioNumber==2){
		println "scen = 1 or 2"
	}
	else if(editScenarioNumber==3){
		println "scen = 3"
		String expectedNoEditMsg1= "We're Sorry."
		String expectedNoEditMsg2= "Your order has gift card items and cannot be edited."
		String actualNoEditMsg1= WebUI.getText(findTestObject('Object Repository/ReplicatedSite/div_no_edit_msg1'))
		String actualNoEditMsg2= WebUI.getText(findTestObject('Object Repository/ReplicatedSite/div_no_edit_msg2'))
		assert actualNoEditMsg1.equalsIgnoreCase(expectedNoEditMsg1)
		assert actualNoEditMsg2.equalsIgnoreCase(expectedNoEditMsg2)
		WebUI.click(findTestObject('Object Repository/ReplicatedSite/button_accept_msg'))
	}
	else if(editScenarioNumber==4){
		println "scen = 4"
		List<WebElement> donationItemPresent = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/div_donation_present'))
		assert donationItemPresent.size() > 0
		List<WebElement> donationRemoveButton = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/a_donation_cannot_remove'))
		assert donationRemoveButton.size() == 0
	}
	else if(editScenarioNumber==5){
		println "scen = 5"
		String expectedMessage= "Item Shipped"
		String actualMessage=  WebUI.getText(findTestObject('Object Repository/ReplicatedSite/itemShipped'))
		assert actualMessage.equalsIgnoreCase(expectedMessage)
		List<WebElement> itemRemove = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ReplicatedSite/itemRemove'),
			5)
		
		assert(itemRemove.size==0)
		
	}
	else{
		println "editScenarioNumber is should be from 1 to 5"
		assert false
	}
	
}


