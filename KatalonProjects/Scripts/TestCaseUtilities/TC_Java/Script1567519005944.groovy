import java.text.DateFormat
import java.text.SimpleDateFormat

import commonUtility.UtilityMethods

int[] a= new int[5];
for(int i=0; i<a.length;i++){
	a[i]=i;
}

for(int i=0; i<a.length; i++){
	if(i==3){
		continue;
	}
	println a[i];
}