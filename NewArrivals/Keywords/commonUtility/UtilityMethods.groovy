package commonUtility

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable

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
		//String sizeRangeFirst = size[0].toString()
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
}
