import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JoinServerPanel extends JFrame implements ActionListener {
    private boolean buttonPressed = false;
    private boolean host;
    private String ipAddress;
    private String name;
    private JButton button;
    private JTextField ipField;
    private JTextField nameField;
    
    JoinServerPanel(boolean host) {
        this.host = host;
        
        //Set up panel properties
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 130);
        
        //Create name text field
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(800, 40)); 
        nameField.setText("Input Nickname");
        this.add(nameField);

        //Create Submit button (Displayed as "Create Server:)
        button = new JButton("Create Server");
        button.addActionListener(this);  
        this.add(button);

        //If online, set up server IP address text field
        if (!host) {
            button.setText("Enter Server");
            ipField = new JTextField();
            ipField.setPreferredSize(new Dimension(800, 60)); 
            ipField.setText("Input Server IP Address");
            this.add(ipField);
            this.setSize(850, 180);
        }

        this.setVisible(true);  
        this.setResizable(false);
    }
    
    public String getServerIPAdress(){
        return ipAddress;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean buttonPressed() {
        return buttonPressed;
    }
    /*----- Overriden methods from ACtionListener -----*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button)) {
            //If a server is created, get ip address from the ip address text field
            if (!host) {
                ipAddress = ipField.getText();
            }
            //Get name from name text field
            name = nameField.getText();    
            buttonPressed = true;
            this.dispose();
        }
    }

}
