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
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class Chat extends JPanel {
	
	private JTextField _messagesField;
	private JTextField _inputBox;
	private JButton _sendButton;
	private Net _net;
	private JPanel _mainPanel;
	private JPanel _sendPanel;
	private String[] _messages = new String(5);
	private GameLanguage _gl = null;

	private static int LINES = 5;
	private String SEND = "->";
	
	/**
	 * Constructor
	 */
	public Chat (Net net, GameLanguage gl){
		_gl = gl;
		_net = net;
		initChat();
	}

	/**
	 * initializes the Chat
	 *
	 * @return Chat
	 */
	public Chat initChat(Net net) {
		SEND = _gl.tr(send);
		_messagesField = new JTextField();
		_inputBox = new JTextField();
		_sendButton = new JButton();
		_mainPanel = new JPanel(new BorderLayout());
		_sendPanel = new JPanel(new BorderLayout());
		
		_sendPanel.add(_inputBox, BorderLayout.CENTER);
		_sendPanel.add(_sendButton, BorderLayout.EAST);
		_mainPanel.add(_messagesField, BorderLayout.CENTER);
		_mainPanel.add(_sendPanel, BorderLayout.SOUTH);
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

	public void reiceive(String text) {
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
			send(inputBox.getText());
		}
	}
}
