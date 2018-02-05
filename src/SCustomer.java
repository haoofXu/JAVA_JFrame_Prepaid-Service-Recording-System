import java.io.IOException;

public class SCustomer extends Services {

	static String id;
	
	SCustomer(String s){
		this.id = s;
	}
	
	public static double getMoney() throws IOException{
		double money = 0;
		String moneyStr = null;
		In inAcc = new In("CustomerAccounts.csv");
		String acc[] = inAcc.readAllStrings();
		inAcc.close();
		for(int i = 0;i<acc.length;i++){
			if (id.equals(csvOperator.getTitle(acc[i]))){
				moneyStr = csvOperator.getMoney(acc[i]);
			}
		}
		money =  Double.parseDouble(moneyStr); 
		return money;
	}
	
	//	顾客 注册请求
	void regRequest(String name, String password, double money) throws IOException{
		In in = new In("CustomerRequests.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("CustomerRequests.csv");
	    for (int i=0;i<accounts.length;i++){
			out.println(accounts[i]);
		}
	    out.println(name + "," + password + "," + money);
	}
	
	//	顾客  创建服务记录
	void addRecord(String provider, String name) throws IOException{
		boolean finish = false;
		boolean addIn = false;
		
		double money = getMoney();
		
		In in = new In(provider + "Services.csv");
		String services[] = in.readAllStrings();
	    in.close();
	    
	    In inRec = new In(id + "sRecord.csv");
		String recs[] = inRec.readAllStrings();
		inRec.close();
	    
	    Out out = new Out(id + "sRecord.csv");
	    for (int i=0;i<recs.length;i++){
	    	//Stdout.println(recs[i]);
			out.println(recs[i]);
		}

	    for (int i=0;i<services.length;i++){
			if(name.equals(csvOperator.getTitle(services[i]))){
				double servePrice = Double.parseDouble(csvOperator.getValue(services[i]));
				if(servePrice < money){
					money -= servePrice;
					out.println(provider + "," + name + ",unfinished");
					addIn = true;
				}
				else{
					Stdout.println("You don't have enough money.");
				}
				finish = true;
			}
		}
	    if(addIn){
			In inAcc = new In("CustomerAccounts.csv");
			String acc[] = inAcc.readAllStrings();
		    inAcc.close();
	    	Out outAcc = new Out("CustomerAccounts.csv");
		    for (int i=0;i<acc.length;i++){
		    	if (id.equals(csvOperator.getTitle(acc[i]))){
					outAcc.println(id + "," + csvOperator.getValue(acc[i]) + "," + money);
				}
		    	else{ outAcc.println(acc[i]); }
			}
		    outAcc.close();
		    In inSer = new In("ServicesList.csv");
		    String ser[] = inSer.readAllStrings();
		    inSer.close();
		    Out outSer = new Out("ServicesList.csv");
		    for(int i=0;i<ser.length;i++){
		    	outSer.println(ser[i]); 
		    }
		    outSer.println(provider + "," + id + "," + name + ",unfinished");
		    outSer.close();

	    }
	    else if(!finish){ Stdout.println(provider + " doesn't have this service."); }
	    out.close();
	}
	
	//	顾客  删除服务记录
	void delRecord(String provider, String name) throws IOException{
		In inRec = new In(id + "sRecord.csv");
		String recs[] = inRec.readAllStrings();
		inRec.close();
	    
	    Out out = new Out(id + "sRecord.csv");
	    for (int i=0;i<recs.length;i++){
	    	if(provider.equals(csvOperator.getTitle(recs[i]))
	    			&& name.equals(csvOperator.getValue(recs[i]))){}
	    	else{ out.println(recs[i]); }
		}
	    out.close();
	}
	
}
