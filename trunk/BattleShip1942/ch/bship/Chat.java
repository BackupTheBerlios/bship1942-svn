package ch.bship;

/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 *
 * Changelog:
 *
 * 26.08.2004	AG	Erstellung
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chat extends JPanel {
	
	private JTextField _messagesField;
	private JTextField _inputBox;
	private JButton _sendButton;
	private Net _net;
	private JPanel _mainPanel;
	private JPanel _sendPanel;
	private String _messages[];

	private static int LINES = 5;
	private String SEND = "->";
	private String tmpText;
	private String messages[];
	
	private Net net;
	private GameLanguage _gl = new GameLanguage();
	
	/**
	 * Constructor
	 */
	public Chat (){
	    super();
		initialize();
		_net = net;
	}
	/**
	 * initializes the Chat
	 *
	 * @return Chat
	 */
	private void initialize() {
		 
		SEND = _gl.tr("send");
		_messagesField = new JTextField();
		_inputBox = new JTextField();
		_sendButton = new JButton();
		_mainPanel = new JPanel(new BorderLayout());
		_sendPanel = new JPanel(new BorderLayout());
		_sendButton.setText("Send");
		_mainPanel.setPreferredSize(new java.awt.Dimension(200,150));
		this.setSize(216, 165);
		_sendPanel.add(_inputBox, BorderLayout.CENTER);
		_sendPanel.add(_sendButton, BorderLayout.EAST);
		_mainPanel.add(_messagesField, BorderLayout.CENTER);
		_mainPanel.add(_sendPanel, BorderLayout.SOUTH);
		this.add(_mainPanel, null);
	}
	
	/**
	 * sends a message to the opponent
	 *
	 * @param message
	 */
	private void send(String text) {
		_net.send(text);
		
		for (int i = 0; i > LINES; i++) {
			_messages[i] = _messages[i-1];
			tmpText += messages[i] + "/n";
		}
		tmpText += "<-" + text;
		_messagesField.setText(tmpText);
	}

	/**
	 * is called by the engine if a message comes in
	 *
	 * @param the received message
	 */

	public void recieve(String text) {
		String tmpText = "";
		for (int i = 0; i > LINES; i++) {
			_messages[i] = _messages[i-1];
			tmpText += messages[i] + "/n";
		}
		tmpText += "->" + text;
		_messagesField.setText(tmpText);
	}

	/**
	 * action performed for the sendButton
	 */

	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if (cmd.equals(SEND)) {
			//send(inputBox.getText());
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
