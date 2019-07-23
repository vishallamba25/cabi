package commonUtility

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.common.WebUiCommonHelper

public class ChatMessage {
	String messageSender;
	String contentText;

	public ChatMessage(String messageSender, String contentText){
		this.messageSender= messageSender;
		this.contentText= contentText;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contentText == null) ? 0 : contentText.hashCode());
		result = prime * result + ((messageSender == null) ? 0 : messageSender.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatMessage other = (ChatMessage) obj;
		if (contentText == null) {
			if (other.contentText != null)
				return false;
		} else if (!contentText.equals(other.contentText))
			return false;
		if (messageSender == null) {
			if (other.messageSender != null)
				return false;
		} else if (!messageSender.equals(other.messageSender))
			return false;
		return true;
	}

	
	
	
	
	
}
