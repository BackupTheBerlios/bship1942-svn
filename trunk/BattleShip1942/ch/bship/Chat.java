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
	
	public Chat (Net net){
		initChat(net);
	}

	public Chat initChat(Net net) {
		messages = new JTextField;
		inputBox = new JTextField;
		myColor = new JColor("blue");
		hisColor = new JColor("red");
		_net = net;

		
	}
	
	private void send(String text) {
		_net.	
}
