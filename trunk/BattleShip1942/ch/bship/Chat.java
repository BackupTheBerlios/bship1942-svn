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
import java.util.*;

public class Chat extends JPanel implements ActionListener {
	
	private JTextArea _messagesField;
	private JTextField _inputBox;
	private JButton _sendButton;
	private Net _net;
	private JPanel _mainPanel;
	private JPanel _sendPanel;
	private Vector _messages = new Vector();

        private static String SEND_CMD = "send_pressed";
	private String SEND = "->";
	private String tmpText;
	
	private GameLanguage _gl = GameLanguage.getInstance();
	
	/**
	 * Constructor
	 */
	public Chat (Net net){
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
		_messagesField = new JTextArea();
                _messagesField.setEditable(false);
                JScrollPane scroller = new JScrollPane(_messagesField);
		_inputBox = new JTextField();
		_sendButton = new JButton();
		_sendButton.setText(_gl.tr("Send"));
		_sendButton.setName("Send");
                _sendButton.setActionCommand(SEND_CMD);
                _sendButton.addActionListener(this);
		_mainPanel = new JPanel(new BorderLayout());
		_sendPanel = new JPanel(new BorderLayout());
		_mainPanel.setPreferredSize(new java.awt.Dimension(200,150));
		this.setSize(216, 165);
		_sendPanel.add(_inputBox, BorderLayout.CENTER);
		_sendPanel.add(_sendButton, BorderLayout.EAST);
		_mainPanel.add(scroller, BorderLayout.CENTER);
		_mainPanel.add(_sendPanel, BorderLayout.SOUTH);
		this.add(_mainPanel, null);
		Engine.guiElements.addElement(_sendButton);
	}
	
	/**
	 * sends a message to the opponent
	 *
	 * @param message
	 */
	private void send(String text) {
            _net.send(Net.MSG_CHAT + "|" + text);
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
         * @param the received message
         */
    public void receive(String text) {
            _messagesField.setText(tmpText);
	}

	/**
	 * action performed for the sendButton
	 */
	public void actionPerformed(ActionEvent event) {
            String cmd = event.getActionCommand();
            if (cmd.equals(SEND_CMD)) {
                send(_inputBox.getText());
            }
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
