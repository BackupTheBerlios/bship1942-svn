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

public class Chat extends JPanel {
	
	JTextField _messages;
	JTextField _inputBox;
	JColor _myColor;
	JColor _hisColor;
	Net _net;
	
	/**
	 * Constructor
	 */
	public Chat (Net net){
		initChat(net);
	}

	/**
	 * initializes the Chat
	 *
	 * @return Chat
	 */
	public Chat initChat(Net net) {
		messages = new JTextField;
		inputBox = new JTextField;
		myColor = new JColor("blue");
		hisColor = new JColor("red");
		_net = net;

		
	}
	
	/**
	 * sends a message to the opponent
	 *
	 * @param message
	 */
	private void send(String text) {
		_net.send(text);
	}

	public void reiceive(String text) {
		messages.write(text);
}
