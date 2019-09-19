import java.text.DateFormat
import java.text.SimpleDateFormat

import commonUtility.UtilityMethods

DateFormat dfMM = new SimpleDateFormat('MM')

DateFormat dfDD = new SimpleDateFormat('dd')

DateFormat dfYYYY = new SimpleDateFormat('yyyy')

Date today = Calendar.getInstance().getTime()

Calendar c = Calendar.getInstance()

c.setTime(today)

c.add(Calendar.MONTH, -3) //Three days after today

Date newShowDate = c.getTime()

//String todayAsString = df.format(currentDatePlusOne);
String vsyear = dfMM.format(newShowDate)
println vsyear