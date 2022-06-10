import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedHashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerChat extends JFrame implements ActionListener {
	private Client client;
	private JTextArea txaDisplay;
	private JScrollPane scrdisplay;
	private JTextField txtInput;
	private JButton button;
	private String message;
	
	ServerChat(Client client) {	
		this.client = client;
		setTitle("Chat");
		setLayout(new FlowLayout());
		
		txaDisplay = new JTextArea();
		txaDisplay.setEditable(false);
		scrdisplay = new JScrollPane(txaDisplay);
		scrdisplay.setPreferredSize(new Dimension(450, 200));
		getContentPane().add(scrdisplay);
		
		txtInput = new JTextField();
		txtInput.setPreferredSize(new Dimension(450, 30));
		getContentPane().add(txtInput);
		
		button = new JButton("Send message");
		button.addActionListener(this);
		this.add(button);
		
		setSize(500, 300);
		setVisible(false);
		setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == button) {
        	message = txtInput.getText();
        	System.out.println(message);
        	txaDisplay.append(message+"\n");
        	try {
				client.sendMessage(message);
			} catch (Exception ex) {}
        }
        
    }
	
	public String getMessage() {
		return message;
	}
	
	public void sendMessage(String message) {
    	txaDisplay.append(message+"\n");
	}
	
}