import java.text.DateFormat
import java.text.SimpleDateFormat

import commonUtility.UtilityMethods

function getElementByXpath(path) {
	return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
  }