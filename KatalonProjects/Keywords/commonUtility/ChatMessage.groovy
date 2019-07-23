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

import internal.GlobalVariable

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
	
	public ChatMessage createActualChatMessage(){
		
	}
}
