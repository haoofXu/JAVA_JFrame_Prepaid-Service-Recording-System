
public class csvOperator {
	public static String getTitle(String s){
		int separator = 0;
		String value[] =  s.split(",");
		return(value[0]);
	}
	
	public static String getValue(String s){
		int separator = 0;
		String value[] =  s.split(",");
		return(value[1]);
	}
	
	public static String getMoney(String s){
		int separator = 0;
		String value[] =  s.split(",");
		return(value[2]);
	}
	
	public static String getState(String s){
		int separator = 0;
		String value[] =  s.split(",");
		return(value[3]);
	}
}
