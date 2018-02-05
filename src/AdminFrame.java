
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdminFrame extends Frame {

	JFrame frame = new JFrame();
	Panel LogPanel;
	Panel addPanel;
	Panel motPanel;
	
	public static double getMoney(String id) throws IOException{
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
		JLabel jmptext8 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext9 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext10 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext11 = new JLabel("                                                                                                                                                                                                             ");
		JLabel showtext = new JLabel("       ");
		JLabel showtext2 = new JLabel("                             ");
		JLabel label = new JLabel("Administrator: " + id);
		JLabel labelPro = new JLabel("Provider: ");
        JTextField providerBox = new JTextField(10);
        JTextArea area = new JTextArea();
        JButton provider = new JButton("Show Providers");
        JButton customer = new JButton("Show Customers");
        JButton service = new JButton("Show Services");
        JButton showService = new JButton("Show Service Records");

        LogPanel.add(BorderLayout.NORTH,jmptext);
        LogPanel.add(jmptext2);
        LogPanel.add(jmptext3);
	    LogPanel.add(BorderLayout.CENTER,label);
        LogPanel.add(jmptext4);
	    LogPanel.add(provider);
        LogPanel.add(showtext);
	    LogPanel.add(customer);
	    

        LogPanel.add(jmptext8);
	    LogPanel.add(labelPro);
	    LogPanel.add(providerBox);
	    LogPanel.add(showtext);
	    LogPanel.add(service);
	    
        LogPanel.add(jmptext5);
		LogPanel.add(showService);
        LogPanel.add(jmptext6);
        LogPanel.add(jmptext7);
        LogPanel.add(BorderLayout.SOUTH,area);
	    
        provider.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		area.setText("");
	    		In in= null;
	    	    String accounts[] = null;
				try {
					in = new In("ProviderAccounts.csv");
		    	    accounts = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    for (int i=0;i<accounts.length;i++){

	    	    	area.append(csvOperator.getTitle(accounts[i]) + "\t " 
	    					+ csvOperator.getValue(accounts[i]) + "\t " 
	    					+ csvOperator.getMoney(accounts[i]) + "\n");
	    		}
	    	    
	    	    
	    	}            
	    });
        
        customer.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		area.setText("");
	    		In in= null;
	    	    String accounts[] = null;
				try {
					in = new In("CustomerAccounts.csv");
		    	    accounts = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    for (int i=0;i<accounts.length;i++){

	    	    	area.append(csvOperator.getTitle(accounts[i]) + "\t " 
	    					+ csvOperator.getValue(accounts[i]) + "\t " 
	    					+ csvOperator.getMoney(accounts[i]) + "\n");
	    		}
	    	    
	    	    
	    	}            
	    });

	    showService.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		area.setText("");
	    		In in = null;
	    	    String records[] = null;
				try {
					in = new In("ServicesList.csv");
		    	    records = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		for (int i=0;i<records.length;i++){
	    			area.append(csvOperator.getTitle(records[i]) + "\t " + csvOperator.getValue(records[i])
	    			+ "\t " + csvOperator.getMoney(records[i])
	    			+ "\t " + csvOperator.getState(records[i]) + "\n");
	    		}
	    	}            
	    });
	    
	    service.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		area.setText("");
	    		In in = null;
	    		String services[] = null;
				try {
					in = new In(providerBox.getText() + "Services.csv");
		    		services = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    for (int i=0;i<services.length;i++){
	    			area.append(csvOperator.getTitle(services[i]) + "\t " 
					+ csvOperator.getValue(services[i]) + "\n");
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
		JLabel jmptext12 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext13 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext14 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext15 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext16 = new JLabel("                                                                                                                                                                                                             ");
		
		
		JLabel addProvider = new JLabel("Provider: ");
		JLabel addService = new JLabel("Service: ");
		JLabel addPrice = new JLabel("Price: ");
		JTextField addpro = new JTextField(20);
		JTextField addser = new JTextField(20);
		JTextField addpri = new JTextField(20);
        JButton supplyService = new JButton("Supply New Service");
        
        JLabel delProvider = new JLabel("Provider: ");
		JLabel delService = new JLabel("Service: ");
		JTextField delpro = new JTextField(20);
		JTextField delser = new JTextField(20);
        JButton deleteService = new JButton("Delete Service");
        

        JLabel adjProvider = new JLabel("Provider: ");
		JLabel adjService = new JLabel("Service: ");
		JLabel adjPrice = new JLabel("Price: ");
		JTextField adjpro = new JTextField(20);
		JTextField adjser = new JTextField(20);
		JTextField adjpri = new JTextField(20);
        JButton adjectService = new JButton("Adject Service Price");

		addPanel.add(jmptext);
		addPanel.add(jmptext2);
		addPanel.add(jmptext3);
		addPanel.add(jmptext4);
		addPanel.add(addProvider);
		addPanel.add(addpro);
		addPanel.add(jmptext5);
		addPanel.add(addService);
		addPanel.add(addser);
		addPanel.add(jmptext6);
		addPanel.add(addPrice);
		addPanel.add(addpri);
		addPanel.add(jmptext7);
		addPanel.add(supplyService);
		
		
		addPanel.add(jmptext8);
		addPanel.add(jmptext9);
		addPanel.add(delProvider);
		addPanel.add(delpro);
		addPanel.add(jmptext10);
		addPanel.add(delService);
		addPanel.add(delser);
		addPanel.add(jmptext11);
		addPanel.add(deleteService);
		

		addPanel.add(jmptext16);
		addPanel.add(jmptext12);
		addPanel.add(adjProvider);
		addPanel.add(adjpro);
		addPanel.add(jmptext13);
		addPanel.add(adjService);
		addPanel.add(adjser);
		addPanel.add(jmptext14);
		addPanel.add(adjPrice);
		addPanel.add(adjpri);
		addPanel.add(jmptext15);
		addPanel.add(adjectService);
		

		supplyService.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		String provider = addpro.getText();
	    		String name = addser.getText();
	    		double price = Double.parseDouble(addpri.getText());
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
	    	    Out out = new Out(provider + "Services.csv");
	    	    for (int i=0;i<services.length;i++){
	    			out.println(services[i]);
	    		}
	    	    out.println(name + "," + price);
	    	    out.close();
	    	}            
	    });
	    
		deleteService.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		String provider = delpro.getText();
	    		String name = delser.getText();
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
	    	    Out out = new Out(provider + "Services.csv");
	    	    for (int i=0;i<services.length;i++){
	    	    	if(name.equals(csvOperator.getTitle(services[i]))){}
	    	    	else{
	    	    		out.println(services[i]);
	    	    	}
	    		}
	    	    out.close();
	    	}            
	    });
		

		adjectService.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		String provider = adjpro.getText();
	    		String name = adjser.getText();
	    		double price = Double.parseDouble(adjpri.getText());
	    		In in=null;
	    		String services[] = null;
				try {
					in = new In(provider + "Services.csv");
		    		services = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    Out out = new Out(provider + "Services.csv");
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
	    });
	    
	}

	private void generateMotPanel(String id){
		motPanel = new Panel();
		motPanel.setLayout(new FlowLayout());
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
		JLabel jmptext12 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext13 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext14 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext15 = new JLabel("                                                                                                                                                                                                             ");
		JLabel jmptext16 = new JLabel("                                                                                                                                                                                                             ");
		JLabel addCustomer = new JLabel("Customer: ");
		JLabel addProvider = new JLabel("Provider: ");
		JLabel addName = new JLabel("Service: ");
		JTextField addcus = new JTextField(20);
		JTextField addpro = new JTextField(20);
		JTextField addnam = new JTextField(20);
		JButton addRecord = new JButton("Add Record");


		JLabel delCustomer = new JLabel("Customer: ");
		JLabel delProvider = new JLabel("Provider: ");
		JLabel delName = new JLabel("Service: ");
		JTextField delcus = new JTextField(20);
		JTextField delpro = new JTextField(20);
		JTextField delnam = new JTextField(20);
		JButton delRecord = new JButton("Delete Record");
		JButton pRegRequest = new JButton("Approve Provider Register");
		JButton cRegRequest = new JButton("Approve Customer Register");
		
		motPanel.add(jmptext);
		motPanel.add(jmptext2);
		motPanel.add(jmptext3);
		motPanel.add(jmptext4);
		motPanel.add(addCustomer);
		motPanel.add(addcus);
		motPanel.add(jmptext5);
		motPanel.add(addProvider);
		motPanel.add(addpro);
		motPanel.add(jmptext6);
		motPanel.add(addName);
		motPanel.add(addnam);
		motPanel.add(jmptext7);
		motPanel.add(addRecord);
		motPanel.add(jmptext8);
		motPanel.add(jmptext9);
		motPanel.add(delCustomer);
		motPanel.add(delcus);
		motPanel.add(jmptext10);
		motPanel.add(delProvider);
		motPanel.add(delpro);
		motPanel.add(jmptext11);
		motPanel.add(delName);
		motPanel.add(delnam);
		motPanel.add(jmptext12);
		motPanel.add(delRecord);
		motPanel.add(jmptext13);
		motPanel.add(jmptext14);
		motPanel.add(pRegRequest);
		
		motPanel.add(jmptext15);
		motPanel.add(jmptext16);
		motPanel.add(cRegRequest);
		
		addRecord.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		String customer = addcus.getText();
	    		String provider = addpro.getText();
	    		String name = addnam.getText();
	    		In in=null;
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
					inRec = new In(customer + "sRecord.csv");
		    		recs = inRec.readAllStrings();
		    		inRec.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    
	    	    Out out = new Out(customer + "sRecord.csv");
	    	    for (int i=0;i<recs.length;i++){
	    	    	//Stdout.println(recs[i]);
	    			out.println(recs[i]);
	    		}

	    	    for (int i=0;i<services.length;i++){
	    			if(name.equals(csvOperator.getTitle(services[i]))){
	    				out.println(provider + "," + name);
	    			}
	    		}
	    	    out.close();
	    	    
	    	    In inrr = null;
	    		String rr[] = null;
				try {
					inrr = new In("ServicesList.csv");
		    		rr = inrr.readAllStrings();
		    		inrr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    out = new Out("ServicesList.csv");
	    	    for (int i=0;i<rr.length;i++){
	    			out.println(rr[i]);
	    		}
	    	    out.println(provider+","+customer+","+name+",unfinished");
	    	    out.close();
	    	}    
	    });
		
		delRecord.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		String customer = delcus.getText();
	    		String provider = delpro.getText();
	    		String name = delnam.getText();
	    		In inRec = null;
	    		String recs[] = null;
				try {
					inRec = new In(customer + "sRecord.csv");
		    		recs = inRec.readAllStrings();
		    		inRec.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    
	    	    Out out = new Out(customer + "sRecord.csv");
	    	    for (int i=0;i<recs.length;i++){
	    	    	if(provider.equals(csvOperator.getTitle(recs[i]))
	    	    			&& name.equals(csvOperator.getValue(recs[i]))){}
	    	    	else{ out.println(recs[i]); }
	    		}
	    	    out.close();
	    	    
	    	    In inrr = null;
	    		String rr[] = null;
				try {
					inrr = new In("ServicesList.csv");
		    		rr = inrr.readAllStrings();
		    		inrr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    out = new Out("ServicesList.csv");
	    	    for (int i=0;i<rr.length;i++){
	    	    	if(provider.equals(csvOperator.getTitle(rr[i]))
	    	    			&& name.equals(csvOperator.getMoney(rr[i]))
	    	    			&& customer.equals(csvOperator.getValue(rr[i]))){}
	    	    	else{ out.println(rr[i]); }
	    		}
	    	    out.close();
	    	}    
	    });
	    
		
		pRegRequest.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		In in = null;
	    	    String accounts[] = null;
				try {
					in = new In("ProviderRequests.csv");
		    	    accounts = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    Out out = new Out("ProviderRequests.csv");
	    		out.println(accounts[0]);
	    		out.close();
	    		In inAcc =null;
	    	    String acc[] = null;
				try {
					inAcc = new In("ProviderAccounts.csv");
		    	    acc = inAcc.readAllStrings();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		Out outAcc = new Out("ProviderAccounts.csv");
	    	    for (int i=0;i<acc.length;i++){
	    			outAcc.println(acc[i]);
	    		}
	    	    for (int i=1;i<accounts.length;i++){
	    			outAcc.println(accounts[i]);
	    		}
	    	    outAcc.close();
	    	}    
	    });
		
		cRegRequest.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		
	    	}    
	    });
		
	}
	
	
	public AdminFrame(String panelName) {
		frame = new JFrame(panelName);
		
		generateLogPanel(panelName);
		generateAddPanel(panelName);
		generateMotPanel(panelName);

        frame.add(LogPanel);
        frame.add(addPanel);
        frame.add(motPanel);

        frame.setLayout(new GridLayout(1,3));
        frame.setSize(1200, 800);
        frame.setLocation(100,100);
        frame.setVisible(true);
        
        
        
        
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent arg0) {
               System.exit(0);
            }
        });
     }
	
}
