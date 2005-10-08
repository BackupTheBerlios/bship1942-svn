package ch.bship;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 * 
 * Changelog:
 * 
 * 26.08.2004 AG Erstellung
 *  
 */



public class Chat extends JPanel implements ActionListener {

	private JTextArea _messagesField = null;
	private JTextField _inputBox = null;
	private JScrollPane _scroller = null;
	private JButton _sendButton = null;
	private Engine _engine;
	private JPanel _mainPanel;
	private JPanel _sendPanel;
	private Vector _messages = new Vector();
	private static String SEND_CMD = "send_pressed";
	/**
	 * Constructor
	 */
	public Chat(Engine engine) {
		super();
		_engine = engine;
		initialize();
	}

	/**
	 * initializes the Chat
	 */
	private void initialize() {
		_mainPanel = new JPanel(new BorderLayout());
		_sendPanel = new JPanel(new BorderLayout());
		_sendPanel.add(getInputBox(), BorderLayout.CENTER);
		_sendPanel.add(getSendButton(), BorderLayout.EAST);
		_mainPanel.setPreferredSize(new Dimension(200,150));
		_mainPanel.add(getScroller(), BorderLayout.CENTER);
		_mainPanel.add(_sendPanel, BorderLayout.SOUTH);
		_engine.getGuiElements().addElement(getSendButton());
		this.add(_mainPanel, null);
	}
	
	private JButton getSendButton() {
		if (_sendButton == null) {
			_sendButton = new JButton();
			_sendButton.setText(_engine.getTranslator().tr("Send"));
			_sendButton.setName("Send");
			_sendButton.setActionCommand(SEND_CMD);
			_sendButton.addActionListener(this);
		}
		return _sendButton;
	}
	
	private JTextField getInputBox() {
		if (_inputBox == null) {
			_inputBox = new JTextField();
		}
		return _inputBox;
	}
	
	private JTextArea getMessagesField() {
		if (_messagesField == null){
			_messagesField = new JTextArea();
			_messagesField.setEditable(false);
		}
		return _messagesField;
	}
	
	private JScrollPane getScroller() {
		if (_scroller == null) {
			_scroller = new JScrollPane(getMessagesField());
		}
		return _scroller;
	}

	/**
	 * sends a message to the opponent
	 * 
	 * @param message
	 */
	private void send(String text) {
		_engine.getNetInstance().send(Net.MSG_CHAT + "|" + text);
		_messages.addElement("<-" + text);
		String tmpText = new String();
		for (int i = 0; i < _messages.size(); i++) {
			tmpText = tmpText + "\n" + _messages.elementAt(i);
		}
		_messagesField.setText(tmpText);
	}

	/**
	 * is called by the engine if a message comes in
	 * 
	 * @param the
	 *            received message
	 */
	public void receive(String text) {
		_messages.addElement("->" + text);
		String tmpText = new String();
		for (int i = 0; i < _messages.size(); i++) {
			tmpText = tmpText + "\n" + _messages.elementAt(i);
		}
		_messagesField.setText(tmpText);
	}

	/**
	 * action performed for the sendButton
	 */
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if (cmd.equals(SEND_CMD)) {
			send(getInputBox().getText());
		}
	}
} //  @jve:decl-index=0:visual-constraint="10,10"
