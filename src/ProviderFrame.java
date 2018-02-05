
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProviderFrame extends Frame {

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
		JLabel showtext = new JLabel("                       ");
		JLabel showtext2 = new JLabel("                             ");
		JLabel label = new JLabel("Provider: " + id);
        JTextArea area = new JTextArea();
        JButton service = new JButton("Show Services");
        JButton showService = new JButton("Show Service Records");

        LogPanel.add(BorderLayout.NORTH,jmptext);
        LogPanel.add(jmptext2);
        LogPanel.add(jmptext3);
	    LogPanel.add(BorderLayout.CENTER,label);
        LogPanel.add(jmptext4);
	    LogPanel.add(service);
        LogPanel.add(jmptext5);
		LogPanel.add(showService);
        LogPanel.add(jmptext6);
        LogPanel.add(jmptext7);
        LogPanel.add(BorderLayout.SOUTH,area);
	    
	    service.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		area.setText("");
	    		In in = null;
				try {
					in = new In(id + "Services.csv");
					String services[] = in.readAllStrings();
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    String services[] = in.readAllStrings();
	    	    for (int i=0;i<services.length;i++){
	    	    	area.append(csvOperator.getTitle(services[i]) + "\t\t " + csvOperator.getValue(services[i]) + "\n");
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
	    	    	area.append(csvOperator.getTitle(records[i]) + "\t " + csvOperator.getValue(records[i])+ "\t " + csvOperator.getMoney(records[i]) + "\t " + csvOperator.getState(records[i]) + "\n");
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
		JLabel addName = new JLabel("Service Name: ");
		JLabel deName = new JLabel("Service Name: ");
		JLabel addPrice = new JLabel("Service Price: ");
		JTextField name = new JTextField(20);
		JTextField price = new JTextField(20);
		JTextField delName = new JTextField(20);
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
		addPanel.add(deName);
		addPanel.add(delName);
		addPanel.add(jmptext9);
		addPanel.add(delService);
		addPanel.add(jmptext10);
		

	    addService.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		In in = null;
	    		String services[] = null;
				try {
					in = new In(id + "Services.csv");
		    		services = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    Out out = new Out(id + "Services.csv");
	    	    for (int i=0;i<services.length;i++){
	    			out.println(services[i]);
	    		}
	    	    out.println(name.getText() + "," + price.getText());
	    	    out.close();
	    	}            
	    });
	    
	    delService.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		In in = null;
	    		String services[] = null;
				try {
					in = new In(id + "Services.csv");
		    		services = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    Out out = new Out(id + "Services.csv");
	    	    for (int i=0;i<services.length;i++){
	    	    	if(delName.getText().equals(csvOperator.getTitle(services[i]))){}
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
		JLabel motName = new JLabel("Service: ");
		JLabel motPrice = new JLabel("Price:   ");
		JLabel finiName = new JLabel("Service: ");
		JLabel finiCustomer = new JLabel("Customer:");
		JTextField name = new JTextField(20);
		JTextField price = new JTextField(20);
		JTextField fininame = new JTextField(20);
		JTextField finicustomer = new JTextField(20);
		JButton adjService = new JButton("Adjust");
		JButton finiService = new JButton("Finish");
		
		motPanel.add(jmptext);
		motPanel.add(jmptext2);
		motPanel.add(jmptext3);
		motPanel.add(jmptext4);
		motPanel.add(motName);
		motPanel.add(name);
		motPanel.add(jmptext5);
		motPanel.add(motPrice);
		motPanel.add(price);
		motPanel.add(jmptext6);
		motPanel.add(adjService);
		motPanel.add(jmptext7);
		motPanel.add(jmptext8);
		motPanel.add(finiName);
		motPanel.add(fininame);
		motPanel.add(jmptext9);
		motPanel.add(finiCustomer);
		motPanel.add(finicustomer);
		motPanel.add(jmptext10);
		motPanel.add(finiService);
		
		adjService.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		In in = null;
	    		String services[] = null;
				try {
					in = new In(id + "Services.csv");
		    		services = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    Out out = new Out(id + "Services.csv");
	    	    for (int i=0;i<services.length;i++){
	    	    	if(name.getText().equals(csvOperator.getTitle(services[i]))){
	    	    		out.println(name.getText() + "," + price.getText());
	    	    	}
	    	    	else{
	    	    		out.println(services[i]);
	    	    	}
	    		}
	    	    out.close();
	    	}    
	    });
		
		finiService.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		
	    		String customer = finicustomer.getText();
	    		String name = fininame.getText();
	    		boolean multify = false;
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
	    	    In inRec = null;
	    	    String rec[] = null;
				try {
					inRec = new In(customer + "sRecord.csv");
		    	    rec = inRec.readAllStrings();
		    	    inRec.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	    	    In inSerPri = null;
	    	    String Pri[] = null;
				try {
					inSerPri = new In(id + "Services.csv");
		    	    Pri = inSerPri.readAllStrings();
		    	    inSerPri.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    for(int i=0;i<Pri.length;i++){
	    	    	if(name.equals(csvOperator.getTitle(Pri[i]))){
	    	    		price = Double.parseDouble(csvOperator.getValue(Pri[i]));
	    	    	}
	    	    }
	    	    double money = 0;
				try {
					money = getMoney(id) + price;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    
	    	    In inPAcc = null;
	    	    String pacc[] = null;
				try {
					inPAcc = new In("ProviderAccounts.csv");
		    	    pacc = inPAcc.readAllStrings();
		    	    inPAcc.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    Out outPacc = new Out("ProviderAccounts.csv");
	    	    
	    	    for (int i=0;i<pacc.length;i++){
	    	    	if (id.equals(csvOperator.getTitle(pacc[i]))){
	    				outPacc.println(id + "," + csvOperator.getValue(pacc[i]) + "," + money);
	    			}
	    	    	else{ outPacc.println(pacc[i]); }
	    		}
	    	    outPacc.close();
	    		
	    	}    
	    });
	    
	}
	
	
	public ProviderFrame(String panelName) {
		frame = new JFrame(panelName);
		
		generateLogPanel(panelName);
		generateAddPanel(panelName);
		generateMotPanel(panelName);

        frame.add(LogPanel);
        frame.add(addPanel);
        frame.add(motPanel);

        frame.setLayout(new GridLayout(1,3));
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
