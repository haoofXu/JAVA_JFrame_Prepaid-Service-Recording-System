import java.io.IOException;

abstract class Services {

	static String id;
	
	abstract void regRequest(String name, String password, double money) throws IOException;
	
	//	打印提供商
	static void printPs() throws IOException{
		In in = new In("ProviderAccounts.csv");
	    String accounts[] = in.readAllStrings();
	    for (int i=0;i<accounts.length;i++){
			Stdout.println(csvOperator.getTitle(accounts[i]));
		}
	    in.close();
	}
	
	//	打印提供商服务
	void printServices() throws IOException{
		In in = new In(id + "Services.csv");
	    String services[] = in.readAllStrings();
	    for (int i=0;i<services.length;i++){
			Stdout.println(csvOperator.getTitle(services[i]) + "\t\t " + csvOperator.getValue(services[i]));
		}
	    in.close();
	}
	static void printServices(String provider) throws IOException{
		In in = new In(provider + "Services.csv");
	    String services[] = in.readAllStrings();
	    for (int i=0;i<services.length;i++){
			Stdout.println(csvOperator.getTitle(services[i]) + "\t\t " + csvOperator.getValue(services[i]));
		}
	    in.close();
	}

	//	打印服务记录
	void printRecords() throws IOException{
		In in = new In(id + "sRecord.csv");
	    String records[] = in.readAllStrings();
	    for (int i=0;i<records.length;i++){
			Stdout.println(csvOperator.getTitle(records[i]) + "\t\t " + csvOperator.getValue(records[i]));
		}
	    in.close();
	}

}
