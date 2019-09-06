package commonUtility

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DateFormat
import java.text.SimpleDateFormat

import javax.imageio.ImageIO

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot


public class UtilityMethods {
	@Keyword
	public static String SplitData(String Data) {

		String[] data = Data.split('[$.|-]')
		String data1 = data[1].toString()
		return data1;
	}

	@Keyword
	public static String[] SplitSizes(String Data) {

		String[] sizeRangeSplit = Data.split('[-]')
		return sizeRangeSplit;
	}

	@Keyword
	public static String[] splitPersonName(String Data) {

		String[] sizeRangeSplit = Data.split(' ')
		return sizeRangeSplit;
	}


	@Keyword
	public static ArrayList<String> getExpectedRange(String[] sizeRange, String[] arr) {
		ArrayList<String> expectedRange= new ArrayList<>();
		int fSize=0, lSize=0;

		if(arr.length==3){
			for(int i=0; i<sizeRange.length; i++){
				if(sizeRange[i]=="Long"){
					fSize=i;
				}
				if(sizeRange[i]=="Regular"){
					lSize=i;
				}
			}
		}
		else{
			for(int i=0; i<sizeRange.length; i++){
				if(sizeRange[i]==arr[0]){
					fSize=i;
				}
				if(sizeRange[i]==arr[1]){
					lSize=i;
				}
			}
		}



		for(int j=fSize; j<=lSize; j++){
			expectedRange.add(sizeRange[j]);
		}

		return expectedRange;
	}

	@Keyword
	public static boolean listEquals(ArrayList<String> expectedRange, ArrayList<String> actualRange){
		if(expectedRange.size()!=actualRange.size())
			return false;
		for(int i=0; i<expectedRange.size(); i++){
			if(expectedRange.get(i)!=actualRange.get(i)){
				return false;
			}
		}
		return true;
	}

	@Keyword
	public static String getTestData(String testData, String header, int row){
		return findTestData(testData).getValue(header, row);
	}


	@Keyword
	public static void getWebElementsAsList(String xpath4elements) {
		WebDriver webDriver = DriverFactory.getWebDriver()
		List<WebElement> elements = webDriver.findElements(By.xpath("//select[@name = 'sizeSelect']"))

		int abc = elements.size()
		println(abc)
		//return elements
	}

	@Keyword
	public static String createScreenshotImagePath(String storeType, String style) throws IOException{
		File directory = new File("productImages/"+storeType+"_"+style+" "+"image.png");
		String filePath=directory.getAbsolutePath();
		System.out.println(filePath);

		return filePath;
	}

	@Keyword
	public static String createSkuForPWL(String productStyle, String productDescription, String productColor) throws IOException{
		String sku=productStyle + "\n"+productDescription+" "+productColor;

		return sku;
	}

	@Keyword
	public static String splitStyle(String style) {

		String[] data = style.split(' \\(')
		String data1 = data[0].toString()
		return data1;
	}

	@Keyword
	public static String concat(String ...s) {
		String result="";
		for(String i: s){
			result+=i;
		}
		return result;
	}

	@Keyword
	public static String createURL(String rsName, String cabitTestEnvt, String showID){
		String micrositeURL="https://"+ rsName.toLowerCase()+"."+cabitTestEnvt+".com/show-microsite/"+showID.replaceAll("[^0-9]", "")+"/";
		//String abc=rsName+cabitTestEnvt+showID;
		return micrositeURL;
	}

	@Keyword
	public static TestObject createTestObject(String name, String ...s){
		String xpath = UtilityMethods.concat(s);
		TestObject to = new TestObject(name);
		to.addProperty('xpath', ConditionType.EQUALS, xpath);
		return to;
	}

	@Keyword
	public static int getFavCount(String guest){
		WebUI.setText(findTestObject('Page_cabi Edit Customer Profile/input_check_contact'), guest)
		Thread.sleep(1000)
		WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Customer Profile/a_contact_search_first_result'))
		Thread.sleep(3000)
		WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Customer Profile/a_contact_details'))
		Thread.sleep(1000)
		List<WebElement> favs = WebUiCommonHelper.findWebElements(findTestObject('virualShowRSVPOR/dashboard/button_start_pre_show'), 1)
		Thread.sleep(1000)
		WebUI.click(findTestObject('Object Repository/virualShowRSVPOR/Page_cabi Edit Customer Profile/a_back_to_contact_manager'))
		return favs.size();
	}

	@Keyword
	public static void takeWebElementScreenshot(TestObject tobj, String name){
		WebElement we= WebUiCommonHelper.findWebElement(tobj, 20);
		WebDriver driver= DriverFactory.getWebDriver();

		DateFormat dateFormat = new SimpleDateFormat("yyyy_mm_dd__hh_mm_ss_");
		String strDate = dateFormat.format(Calendar.getInstance().getTime());

		Screenshot screenshot=new AShot().takeScreenshot(driver, we);
		ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir")+"/screenshots/camInfocus/"+strDate+"_"+name+"_SS.png"));
	}

	@Keyword
	public static void validateGuestsListDashboard(List<VSGuest> yesList, List<VSGuest> noList ,List<VSGuest> maybeList, List<VSGuest> noreplyList, List<VSGuest> presentList, List<VSGuest> allList){
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)

		try {
			assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex) {
			assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_present'), presentList);
		}
		WebUI.delay(2)
		executor.executeScript("arguments[0].click();", WebUiCommonHelper.findWebElement(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply_1'), 5));
		WebUI.delay(2)
		try {
			assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply'), allList);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex) {
			assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_blankreply'), allList);
		}
		WebUI.delay(2)
		try {
			assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_yes'), yesList);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex) {
			assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_yes'), yesList);
		}
		WebUI.delay(2)
		try {
			assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_no'), noList);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex) {
			assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_no'), noList);
		}
		WebUI.delay(2)
		try {
			assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_maybe'), maybeList);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex) {
			assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_maybe'), maybeList);
		}
		WebUI.delay(2)
		try {
			assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_notreply'), noreplyList);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex) {
			assert VSGuest.validateGuests(findTestObject('Object Repository/virualShowRSVPOR/dashboard/select_rsvp_notreply'), noreplyList);
		}
	}

	//extract 'test18' from whole backoffice url string provided
	@Keyword
	public static String getEnvt(String BOURL){
		String user=""
		for(int i=0; i<BOURL.length(); i++){
			if(BOURL.charAt(i)=='/'){
				i+=2;
				while(BOURL.charAt(i)!='.'){
					user=UtilityMethods.concat(user, (BOURL.charAt(i)).toString());
					i++;
				}
				break;
			}
		}
		println user
		return user;
	}
}
