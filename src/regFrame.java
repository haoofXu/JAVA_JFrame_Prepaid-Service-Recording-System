
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class regFrame extends Frame {

	JFrame frame = new JFrame();
	Panel LogPanel;
	
	private void generateLogPanel() {
		
		LogPanel = new Panel();
		LogPanel.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Account:  ");
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
        JLabel label2 = new JLabel("Password: ");
        JTextField text = new JTextField(20);
        JTextField text2 = new JTextField(20);
        JTextField text3 = new JTextField(20);
        JTextField text4 = new JTextField(20);
        JTextField text5 = new JTextField(20);
        JLabel label3 = new JLabel("    Money:     ");
        JLabel label4 = new JLabel("Name: ");
        JLabel label5 = new JLabel("   Identity:    ");
        JButton confirm = new JButton("Register");
	    

        LogPanel.add(BorderLayout.NORTH,jmptext);
        LogPanel.add(jmptext4);
        LogPanel.add(jmptext5);
        LogPanel.add(BorderLayout.CENTER,label5);
        LogPanel.add(text5);
        LogPanel.add(jmptext8);
        LogPanel.add(label1);
        LogPanel.add(text);
        LogPanel.add(jmptext2);
	    LogPanel.add(label2);
	    LogPanel.add(text2);
        LogPanel.add(jmptext6);
	    LogPanel.add(label3);
	    LogPanel.add(text3);
        LogPanel.add(BorderLayout.SOUTH,jmptext3);
	    LogPanel.add(confirm);
	    
	    confirm.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
	    		String name = text.getText();
	    		String password = text2.getText();
	    		double money = Double.parseDouble(text3.getText());
	    		In in=null;
	    	    String accounts[] = null;
				try {
					if(text5.getText().equals("customer") || text5.getText().equals("Customer")){
						in = new In("CustomerRequests.csv");
					}
					else if(text5.getText().equals("Provider") || text5.getText().equals("provider")){
						in = new In("ProviderRequests.csv");
					}
		    	    accounts = in.readAllStrings();
		    	    in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Out out = null;
				if(text5.getText().equals("customer") || text5.getText().equals("Customer")){
					out = new Out("CustomerRequests.csv");
				}
				else if(text5.getText().equals("Provider") || text5.getText().equals("provider")){
					out = new Out("ProviderRequests.csv");
				}
	    	    
	    	    for (int i=0;i<accounts.length;i++){
	    			out.println(accounts[i]);
	    		}
	    	    out.println(name + "," + password + "," + money);
	    	}
	    	
	    });
	}
	    
	    
	
	public regFrame(String panelName) {
		frame = new JFrame(panelName);
		
		generateLogPanel();

        frame.add(LogPanel);
   
        frame.setSize(300, 500);
        frame.setLocation(300,200);
        frame.setVisible(true);
        
        
        
        
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent arg0) {
               System.exit(0);
            }
        });
     }
	
}
