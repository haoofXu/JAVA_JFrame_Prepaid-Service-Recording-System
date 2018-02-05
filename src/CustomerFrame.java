
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerFrame extends Frame {

	JFrame frame = new JFrame();
	Panel LogPanel;
	Panel addPanel;
	Panel motPanel;
	
	public static double getMoney(String id) throws IOException{
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
	
	private void generateLogPanel(String id) {
		
		LogPanel = new Panel();
		LogPanel.setLayout(new FlowLayout());
        JLabel jmptext = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext2 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext3 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext4 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext5 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext6 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext7 = new JLabel("                                                                                                                                                                                                             ");
		JLabel showtext = new JLabel("                       ");
		JLabel showtext2 = new JLabel("                             ");
		JLabel label = new JLabel("Provider: " + id);
        JTextArea area = new JTextArea();
        JButton showService = new JButton("Show Provider Services");
        JButton showRecord = new JButton("Show Service Records");

        LogPanel.add(BorderLayout.NORTH,jmptext);
        LogPanel.add(jmptext2);
        LogPanel.add(jmptext3);
	    LogPanel.add(BorderLayout.CENTER,label);
        LogPanel.add(jmptext4);
	    LogPanel.add(showService);
        LogPanel.add(jmptext5);
		LogPanel.add(showRecord);
        LogPanel.add(jmptext6);
        LogPanel.add(jmptext7);
        LogPanel.add(BorderLayout.SOUTH,area);
	    
	    showService.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		area.setText("");
	    		In in = null;
	    	    String accounts[] = null;
				try {
					in = new In("ProviderAccounts.csv");
		    	    accounts = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				area.append("Provider\tService\tPrice\n");
	    	    for (int i=1;i<accounts.length;i++){
					In inservice = null;
					String serve[] = null;
	    			try {
						inservice = new In(csvOperator.getTitle(accounts[i]) + "Services.csv");
						serve = inservice.readAllStrings();
						inservice.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					for(int j=1;j<serve.length;j++){
						area.append(csvOperator.getTitle(accounts[i]) + "\t" + csvOperator.getTitle(serve[j]) + "\t" + csvOperator.getValue(serve[j]) + "\n");
					}
	    		}
	    	    
	    	}            
	    });

	    showRecord.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		area.setText("");
	    		In in = null;
	    	    String records[] = null;
				try {
					in = new In(id + "sRecord.csv");
		    	    records = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    for (int i=0;i<records.length;i++){
	    			area.append(csvOperator.getTitle(records[i]) + "\t" + csvOperator.getValue(records[i])+ "\t"+csvOperator.getMoney(records[i])+ "\n");
	    		}
	    	}            
	    });
	}
	    
	private void generateAddPanel(String id) {
		addPanel = new Panel();
		addPanel.setLayout(new FlowLayout());
		JLabel jmptext = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext2 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext3 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext4 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext5 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext6 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext7 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext8 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext9 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext10 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext11 = new JLabel("                                                                                                                                                                                                             ");
		JLabel addName = new JLabel("Provider: ");
		JLabel depro = new JLabel("Provider: ");
		JLabel deName = new JLabel("Service: ");
		JLabel addPrice = new JLabel("Service: ");
		JTextField name = new JTextField(20);
		JTextField price = new JTextField(20);
		JTextField delProvider = new JTextField(20);
		JTextField delServe = new JTextField(20);
        JButton addService = new JButton("Add Service");
        JButton delService = new JButton("Delete Service");
        

		addPanel.add(jmptext);
		addPanel.add(jmptext2);
		addPanel.add(jmptext3);
		addPanel.add(jmptext4);
		addPanel.add(addName);
		addPanel.add(name);
		addPanel.add(jmptext5);
		addPanel.add(addPrice);
		addPanel.add(price);
		addPanel.add(jmptext6);
		addPanel.add(addService);
		addPanel.add(jmptext7);
		addPanel.add(jmptext8);
		addPanel.add(depro);
		addPanel.add(delProvider);
		addPanel.add(jmptext11);
		addPanel.add(deName);
		addPanel.add(delServe);
		addPanel.add(jmptext9);
		addPanel.add(delService);
		addPanel.add(jmptext10);
		

	    addService.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		boolean finish = false;
	    		boolean addIn = false;
	    		
	    		double money = 0;
				try {
					money = getMoney(id);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		String provider = name.getText();
	    		String name = price.getText();
	    		In in = null;
	    		String services[] = null;
				try {
					in = new In(provider + "Services.csv");
		    		services = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    
	    	    In inRec = null;
	    		String recs[] = null;
				try {
					inRec = new In(id + "sRecord.csv");
		    		recs = inRec.readAllStrings();
		    		inRec.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    
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
	    			In inAcc = null;
	    			String acc[] = null;
					try {
						inAcc = new In("CustomerAccounts.csv");
		    			acc = inAcc.readAllStrings();
		    		    inAcc.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	    	Out outAcc = new Out("CustomerAccounts.csv");
	    		    for (int i=0;i<acc.length;i++){
	    		    	if (id.equals(csvOperator.getTitle(acc[i]))){
	    					outAcc.println(id + "," + csvOperator.getValue(acc[i]) + "," + money);
	    				}
	    		    	else{ outAcc.println(acc[i]); }
	    			}
	    		    outAcc.close();
	    		    In inSer = null;
	    		    String ser[] = null;
					try {
						inSer = new In("ServicesList.csv");
		    		    ser = inSer.readAllStrings();
		    		    inSer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
	    });
	    
	    delService.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		String provider = delProvider.getText();
	    		String name = delServe.getText();
	    		In inRec;
	    		String recs[] = null;
				try {
					inRec = new In(id + "sRecord.csv");
		    		recs = inRec.readAllStrings();
		    		inRec.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    
	    	    Out out = new Out(id + "sRecord.csv");
	    	    for (int i=0;i<recs.length;i++){
	    	    	if(provider.equals(csvOperator.getTitle(recs[i]))
	    	    			&& name.equals(csvOperator.getValue(recs[i]))){}
	    	    	else{ out.println(recs[i]); }
	    		}
	    	    out.close();
	    	}            
	    });
	    
	}

	public CustomerFrame(String panelName) {
		frame = new JFrame(panelName);
		
		generateLogPanel(panelName);
		generateAddPanel(panelName);

        frame.add(LogPanel);
        frame.add(addPanel);

        frame.setLayout(new GridLayout(1,2));
        frame.setSize(1200, 500);
        frame.setLocation(300,300);
        frame.setVisible(true);
        
        
        
        
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent arg0) {
               System.exit(0);
            }
        });
     }
	
}
