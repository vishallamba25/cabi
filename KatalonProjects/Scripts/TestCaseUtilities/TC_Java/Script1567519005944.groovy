import java.text.DateFormat
import java.text.SimpleDateFormat

//String pattern = "MM/dd/yyyy HH:mm:ss";

//String pattern = "MM";

DateFormat df = new SimpleDateFormat("yyyy");

Date today = Calendar.getInstance().getTime();  
Calendar c = Calendar.getInstance();
c.setTime(today);
c.add(Calendar.DATE, 27);
Date currentDatePlusOne = c.getTime();
String todayAsString = df.format(currentDatePlusOne);

int MM= todayAsString as Integer
println MM