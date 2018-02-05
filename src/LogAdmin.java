
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LogAdmin extends Frame {

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
        JLabel label2 = new JLabel("Password: ");
        JTextField text = new JTextField(15);
        JTextArea area = new JTextArea(10,20);
        JButton confirm = new JButton("Confirm");
        JPasswordField password = new JPasswordField(15);
	    

        LogPanel.add(BorderLayout.NORTH,jmptext);
        LogPanel.add(jmptext4);
        LogPanel.add(jmptext5);
	    LogPanel.add(BorderLayout.CENTER,label1);
        LogPanel.add(text);
        LogPanel.add(jmptext2);
	    LogPanel.add(label2);
	    LogPanel.add(password);
        LogPanel.add(BorderLayout.SOUTH,jmptext3);
	    LogPanel.add(confirm);
	    
	    confirm.addActionListener(new ActionListener(){ 
	    	@Override
            public void actionPerformed(ActionEvent arg0) {
//	    		Stdout.println(text.getText());
//	    		Stdout.println(password.getText());
	    		In in = null;
				try {
					in = new In("AdminAccounts.csv");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	    String accounts[] = in.readAllStrings();
	    	    try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    boolean getIn = false;
	    	    for (int i=0;i<accounts.length;i++){
	    	    	if(text.getText().equals(csvOperator.getTitle(accounts[i]))
	    	    			&& password.getText().equals(csvOperator.getValue(accounts[i]))){
	    	    		Stdout.println("in");
	    	    		getIn = true;
	    	    		frame.dispose();
	    	    		AdminFrame provide = new AdminFrame(text.getText());
	    	    	}
	    		}
	    	    if(!getIn){ Stdout.println("not in"); }
	    	    
	    	}            
	    });
	}
	    
	    
	
	public LogAdmin(String panelName) {
		frame = new JFrame(panelName);
		
		generateLogPanel();

        frame.add(LogPanel);
   
        frame.setSize(300, 300);
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
