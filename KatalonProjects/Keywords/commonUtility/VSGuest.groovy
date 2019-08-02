package commonUtility

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class VSGuest {
	int micStatus=0;     //0: undefined, 1: disabled-audio, 2: black-audio-slash, 3: black-audio
	int webcamStatus=0;
	boolean active=false;
	String name;
	int favorites;
	int ordered=0;


	public VSGuest(String name){
		this.name=name;
	}

	public boolean equals(VSGuest v) {
		return this.micStatus==v.micStatus && this.webcamStatus== v.webcamStatus && this.active==v.active && this.name.equalsIgnoreCase(v.name) &&this.favorites==v.favorites && this.ordered==v.ordered;
	}

	public static boolean listEquals(ArrayList<VSGuest> actualList, ArrayList<VSGuest> expectedList, Comparator<VSGuest> comp){
		if(expectedList.size()!=actualList.size())
			return false;

		//Collections.sort(actualList, comp)

		/*for(VSGuest el: actualList){
		 println UtilityMethods.concat(el.micStatus.toString(), ", ", el.webcamStatus.toString(), ", ", el.active.toString(), ", ", el.name, ", ", el.favorites.toString(), ", ", el.ordered.toString());
		 }
		 println "-----------------------------"
		 for(VSGuest el: expectedList){
		 println UtilityMethods.concat(el.micStatus.toString(), ", ", el.webcamStatus.toString(), ", ", el.active.toString(), ", ", el.name, ", ", el.favorites.toString(), ", ", el.ordered.toString());
		 }*/

		for(int i=0; i<actualList.size(); i++) {
			if(!(actualList.get(i).equals(expectedList.get(i)))){
				return false;
			}
		}
		//return expectedList.equals(actualList);
		return true;
	}

	public static ArrayList<VSGuest> createActualGuestList(){
		List<WebElement> micStatuss = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/dashboard/guest_micStatuss'), 1)
		List<WebElement> webcamStatuss = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/dashboard/guest_webcamStatuss'), 1)
		List<WebElement> actives = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/dashboard/guest_actives'), 1)
		List<WebElement> names = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/dashboard/guest_names'), 1)
		List<WebElement> favoritess = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/dashboard/guest_favoritess'), 1)
		List<WebElement> ordereds = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/virualShowRSVPOR/dashboard/guest_ordereds'), 1)


		int elementCount= names.size();
		ArrayList<VSGuest> resultList= new ArrayList<>()
		VSGuest guest;
		for(int i=0; i<elementCount; i++){
			guest= new VSGuest(names.get(i).getText());
			String mstatus= micStatuss.get(i).getAttribute("class");
			switch(mstatus){
				case "undefined simple-tooltip": guest.micStatus  =0; break;
				case "icon disabled-audio simple-tooltip": guest.micStatus=1; break;
				case "icon black-audio-slash simple-tooltip": guest.micStatus=2; break;
				case "icon black-audio simple-tooltip": guest.micStatus=3; break;
			}

			String wstatus= webcamStatuss.get(i).getAttribute("class");
			switch(wstatus){
				case "undefined simple-tooltip": guest.webcamStatus=0; break;
				case "icon disabled-video simple-tooltip": guest.webcamStatus=1; break;
				case "icon black-video-slash simple-tooltip": guest.webcamStatus=2; break;
				case "icon black-video simple-tooltip": guest.webcamStatus=3; break;
			}

			String fav= favoritess.get(i).getText();
			if(fav.equalsIgnoreCase("...")){
				guest.favorites=0;
			}
			else{
				guest.favorites=Integer.parseInt(fav);
			}

			String ord= ordereds.get(i).getText();
			if(ord.equalsIgnoreCase("...")){
				guest.ordered=0;
			}
			else{
				guest.ordered=Integer.parseInt(ord);
			}

			String act= actives.get(i).getAttribute("class");
			if(act.equalsIgnoreCase("fa fa-circle active")){
				guest.active=true;
			}
			else{
				guest.active=false;
			}

			//////////
			resultList.add(guest);
		}
		return resultList;
	}


	public static boolean validateGuests(TestObject action, ArrayList<VSGuest> expectedList){
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(action, 5));

		//WebUI.click(action);
		ArrayList<VSGuest> actualGuestList= VSGuest.createActualGuestList();
		TestObject sortArrow= findTestObject('Object Repository/virualShowRSVPOR/dashboard/i_sort_asc_desc');
		String guestOrder= (WebUiCommonHelper.findWebElement(sortArrow, 5)).getAttribute("class");
		if(guestOrder.equalsIgnoreCase("fa fa-sort-asc")){
			WebUI.click(sortArrow);
		}

		boolean result=VSGuest.listEquals(actualGuestList, expectedList, new NameSort())
		if(result==false){
			println "----------actualList-------------------"
			println actualGuestList.size();
			for(VSGuest el: actualGuestList){
				println UtilityMethods.concat(el.micStatus.toString(), ", ", el.webcamStatus.toString(), ", ", el.active.toString(), ", ", el.name, ", ", el.favorites.toString(), ", ", el.ordered.toString());
			}
			println "----------expectedList-----------------"
			println expectedList.size();
			for(VSGuest el: expectedList){
				println UtilityMethods.concat(el.micStatus.toString(), ", ", el.webcamStatus.toString(), ", ", el.active.toString(), ", ", el.name, ", ", el.favorites.toString(), ", ", el.ordered.toString());
			}
		}
		return result

	}


}

class NameSort implements Comparator<VSGuest>{
	public int compare(VSGuest g1, VSGuest g2){
		return g1.name.compareTo(g2.name);
	}
}

class FavSort implements Comparator<VSGuest>{
	public int compare(VSGuest g1, VSGuest g2){
		return g1.favorites-g2.favorites;
	}
}

class OrderSort implements Comparator<VSGuest>{
	public int compare(VSGuest g1, VSGuest g2){
		return g1.ordered-g2.ordered;
	}
}
