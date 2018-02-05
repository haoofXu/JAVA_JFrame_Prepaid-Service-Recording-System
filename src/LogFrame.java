import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class LogFrame extends Frame {

	JFrame frame = new JFrame();
	Panel SwichUserPanel;
	Panel RegPanel;
	
	private void generateSwichUserPanel() {
		
		SwichUserPanel = new Panel();
		SwichUserPanel.setLayout(new GridLayout(1,3));
	    Button button1 = new Button("Provider");
	    Button button2 = new Button("Customer");
	    Button button3 = new Button("Administrator");
	    
	    button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
               LogProvider logProvider = new LogProvider("Provider");
               
            }
        });
	    

	    button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
               LogCustomer logCustomer = new LogCustomer("Customer");
               
            }
        });

	    button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
               LogAdmin logCustomer = new LogAdmin("Administrator");
               
            }
        });
	    
	    SwichUserPanel.add(button1);
	    SwichUserPanel.add(button2);
	    SwichUserPanel.add(button3);
	}
	
	private void generateRegPanel() {
		RegPanel = new Panel();
		RegPanel.setLayout(new GridLayout(1,1));
	    Button button1 = new Button("Register");
	    RegPanel.add(button1); 
	    

	    button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
               regFrame logCustomer = new regFrame("Register");
               
            }
        });
	}
	
	public LogFrame(String panelName) {
		frame = new JFrame(panelName);
		
		generateSwichUserPanel();
		generateRegPanel();
        frame.setLayout(new GridLayout(2,1));

        frame.add(SwichUserPanel);
        frame.add(RegPanel);
   
        frame.setSize(500, 300);
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
