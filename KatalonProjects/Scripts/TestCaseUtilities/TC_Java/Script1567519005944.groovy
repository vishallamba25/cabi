import java.text.DateFormat
import java.text.SimpleDateFormat

import commonUtility.UtilityMethods

//String pattern = "MM/dd/yyyy HH:mm:ss";

//String pattern = "MM";

/*DateFormat df = new SimpleDateFormat("yyyy");

Date today = Calendar.getInstance().getTime();  
Calendar c = Calendar.getInstance();
c.setTime(today);
c.add(Calendar.DATE, 27);
Date currentDatePlusOne = c.getTime();
String todayAsString = df.format(currentDatePlusOne);

int MM= todayAsString as Integer
println MM*/

DateFormat dfMM = new SimpleDateFormat('MM')

DateFormat dfDD = new SimpleDateFormat('dd')

DateFormat dfYYYY = new SimpleDateFormat('yyyy')

Date today = Calendar.getInstance().getTime()

Calendar c = Calendar.getInstance()

c.setTime(today)

c.add(Calendar.DATE, 2) //Two days after today

Date newShowDate = c.getTime()

//String todayAsString = df.format(currentDatePlusOne);
String vsyear = dfYYYY.format(newShowDate)

String vsmonth = dfMM.format(newShowDate)

String vsday = dfDD.format(newShowDate)
println UtilityMethods.concat("from DTY: ", vsday, " ", vsmonth, " ", vsyear)