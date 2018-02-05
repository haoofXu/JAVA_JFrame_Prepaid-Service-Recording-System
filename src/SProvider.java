import java.io.IOException;

public class SProvider extends Services {

	static String id;
	
	SProvider(String s){
		this.id = s;
	}
	
	public static double getMoney() throws IOException{
		double money = 0;
		String moneyStr = null;
		In inAcc = new In("ProviderAccounts.csv");
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
	
	//	提供商 注册请求
	void regRequest(String name, String password, double money) throws IOException{
		In in = new In("ProviderRequests.csv");
	    String accounts[] = in.readAllStrings();
	    in.close();
	    Out out = new Out("ProviderRequests.csv");
	    for (int i=0;i<accounts.length;i++){
			out.println(accounts[i]);
		}
	    out.println(name + "," + password + "," + money);
	}
	
	//	提供商 完成需求
	void finishServe(String customer, String name) throws IOException{
		boolean multify = false;
		In inSer = new In("ServicesList.csv");
	    String ser[] = inSer.readAllStrings();
	    inSer.close();
	    Out outSer = new Out("ServicesList.csv");
	    for(int i=0;i<ser.length;i++){
	    	if(id.equals(csvOperator.getTitle(ser[i]))
	    			&& customer.equals(csvOperator.getValue(ser[i]))
	    			&& name.equals(csvOperator.getMoney(ser[i]))
	    			&& "unfinished".equals(csvOperator.getState(ser[i]))
	    			&& !multify){

	    	    outSer.println(id + "," + customer + "," + name + ",finished");
	    	    multify = true;
	    	}
	    	else{ outSer.println(ser[i]); }
	    }
	    outSer.close();
	    
	    multify = false;
	    In inRec = new In(customer + "sRecord.csv");
	    String rec[] = inRec.readAllStrings();
	    inRec.close();
	    Out outRec = new Out(customer + "sRecord.csv");
	
	    for(int i=0;i<rec.length;i++){
	    	if(id.equals(csvOperator.getTitle(rec[i]))
	    			&& name.equals(csvOperator.getValue(rec[i]))
	    			&& "unfinished".equals(csvOperator.getMoney(rec[i]))
	    			&& !multify){
	    		outRec.println(id + ","  + name + ",finished");
	    		multify = true;
	    	}
	    	else{ outRec.println(rec[i]); }
	    }
	    
	    double price = 0;
	    In inSerPri = new In(id + "Services.csv");
	    String Pri[] = inSerPri.readAllStrings();
	    inSerPri.close();
	    for(int i=0;i<Pri.length;i++){
	    	if(name.equals(csvOperator.getTitle(Pri[i]))){
	    		price = Double.parseDouble(csvOperator.getValue(Pri[i]));
	    	}
	    }
	    double money = getMoney() + price;
	    
	    In inPAcc = new In("ProviderAccounts.csv");
	    String pacc[] = inPAcc.readAllStrings();
	    inPAcc.close();
	    Out outPacc = new Out("ProviderAccounts.csv");
	    
	    for (int i=0;i<pacc.length;i++){
	    	if (id.equals(csvOperator.getTitle(pacc[i]))){
				outPacc.println(id + "," + csvOperator.getValue(pacc[i]) + "," + money);
			}
	    	else{ outPacc.println(pacc[i]); }
		}
	    outPacc.close();
	    
	}
	
	//	提供商 添加服务
	void addService(String name, double price) throws IOException{
		In in = new In(id + "Services.csv");
		String services[] = in.readAllStrings();
	    in.close();
	    Out out = new Out(id + "Services.csv");
	    for (int i=0;i<services.length;i++){
			out.println(services[i]);
		}
	    out.println(name + "," + price);
	    out.close();
	}
	
	//	提供商 删除服务
	void delService(String name) throws IOException{
		In in = new In(id + "Services.csv");
		String services[] = in.readAllStrings();
	    in.close();
	    Out out = new Out(id + "Services.csv");
	    for (int i=0;i<services.length;i++){
	    	if(name.equals(csvOperator.getTitle(services[i]))){}
	    	else{
	    		out.println(services[i]);
	    	}
		}
	    out.close();
	}
	
	//	提供商 修改服务价格
	void adjService(String name, double price) throws IOException{
		In in = new In(id + "Services.csv");
		String services[] = in.readAllStrings();
	    in.close();
	    Out out = new Out(id + "Services.csv");
	    for (int i=0;i<services.length;i++){
	    	if(name.equals(csvOperator.getTitle(services[i]))){
	    		out.println(name + "," + price);
	    	}
	    	else{
	    		out.println(services[i]);
	    	}
		}
	    out.close();
	}

}
