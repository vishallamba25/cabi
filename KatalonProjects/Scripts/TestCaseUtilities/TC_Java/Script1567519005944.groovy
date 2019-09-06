import commonUtility.UtilityMethods

String s= "https://test1ca.cliotest.com/backoffice/control/main"
String user=""
for(int i=0; i<s.length(); i++){
	if(s.charAt(i)=='/'){
		i+=2;
		while(s.charAt(i)!='.'){
			user=UtilityMethods.concat(user, (s.charAt(i)).toString());
			i++;
		}
		break;
	}
}
println user