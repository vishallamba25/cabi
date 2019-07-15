package commonUtility

import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class VSGuest {
	String name;//1
	int micStatus=0;  //2
	//0: undefined, 1: disabled-audio, 2: black-audio-slash, 3: black-audio
	int webcamStatus=0;//3
	int favorites;//4
	int ordered;//5
	boolean active=false;//6

	public VSGuest(String name){
		this.name=name;
	}

	public static boolean listEquals(ArrayList<VSGuest> expectedList, ArrayList<VSGuest> actualList, Comparator<VSGuest> comp){
		if(expectedList.size()!=actualList.size())
			return false;

		Collections.sort(actualList, comp)
		return expectedList.equals(actualList);
	}

	public static ArrayList<VSGuest> createActualGuestList(List<WebElement> names, List<WebElement> micStatuss, List<WebElement> webcamStatuss, List<WebElement> favoritess, List<WebElement> ordereds, List<WebElement> actives){
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
				guest.ordered=Integer.parseInt(fav);
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



	class nameSort implements Comparator<VSGuest>{
		public int compare(VSGuest g1, VSGuest g2){
			return g1.name.compareTo(g2.name);
		}
	}

	class favSort implements Comparator<VSGuest>{
		public int compare(VSGuest g1, VSGuest g2){
			return g1.favorites-g2.favorites;
		}
	}

	class OrderSort implements Comparator<VSGuest>{
		public int compare(VSGuest g1, VSGuest g2){
			return g1.ordered-g2.ordered;
		}
	}


}
