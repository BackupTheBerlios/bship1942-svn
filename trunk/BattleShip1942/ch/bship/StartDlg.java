/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 *
 * Changelog:
 * 
 * 24.08.2004	MR		Erstellung
 * 
 */

package ch.bship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import java.net.InetAddress;


public class StartDlg extends JFrame implements ActionListener {

    private final static String OK = "OK_CMD";
    private final static String CANCEL = "CANCEL_CMD";
    private final static String MAP_CHANGED = "MAP_CHANGED_CMD";

    private JPanel _mapPanel, _buttonPanel, 
            _bottomPanel, _centerPanel, _choosePanel;
    private JComboBox _nationCBox, _mapCBox, _langCBox;
    private Vector _nations, _maps, _flags;
    private JTextField _nickField;
    private JButton _okButton, _cancelButton;
    private GameLanguage _lang;
    private Net _net;
    private Engine _engine;
    private JLabel _mapPreview;
    private String _ip;
    private JTextField _ipTF, _nickNameTF;

    public StartDlg (Net net, Engine engine) {
        _lang = GameLanguage.getInstance();
        _net = net;
        _engine = engine;

        initIp();
        initComponents();
        initPanels();

    }

    private void initIp() {
        try {
            _ip = (InetAddress.getLocalHost()).getHostAddress();
        } catch( Exception e ) { 
            _ip = "";
        }
    }

    public void initComponents() {
        _okButton = new JButton(_lang.tr("Ok"));
        _okButton.addActionListener(this);
        _okButton.setActionCommand(OK);

        _cancelButton = new JButton(_lang.tr("Cancel"));
        _cancelButton.addActionListener(this);
        _cancelButton.setActionCommand(CANCEL);

        _nations = listDir("nations", "");
        _maps = listDir("maps", "");
        _flags = listDir("nations", "banner.jpg");

        _nationCBox = new JComboBox(_nations);
        _nationCBox.setRenderer(new NationsCBoxRenderer());

        _mapCBox = new JComboBox(_maps);
        _mapCBox.addActionListener(this);
        _mapCBox.setActionCommand(MAP_CHANGED);
        _langCBox = new JComboBox(_lang.getLanguages());

        _mapPreview = new JLabel("", 
            new ImageIcon("logo.jpg"),SwingConstants.LEFT);

        _ipTF = new JTextField(_ip);
        _nickNameTF = new JTextField();
    }

    public void initPanels() {
        _mapPanel = new JPanel(new BorderLayout());
        _buttonPanel = new JPanel(new BorderLayout());
        _choosePanel = new JPanel(new GridLayout(5,1));
        _bottomPanel = new JPanel(new BorderLayout());
        _centerPanel = new JPanel(new BorderLayout());
        JPanel helpPanel = new JPanel(new BorderLayout());

        _buttonPanel.add(_okButton, BorderLayout.WEST);
        _buttonPanel.add(_cancelButton, BorderLayout.EAST);
        _bottomPanel.add(_buttonPanel, BorderLayout.EAST);
        _choosePanel.add(_nickNameTF);
        _choosePanel.add(_ipTF);
        _choosePanel.add(_nationCBox);
        _choosePanel.add(_mapCBox);
        _choosePanel.add(_langCBox);
        _mapPanel.add(_mapPreview, BorderLayout.CENTER);
        _centerPanel.add(_mapPanel, BorderLayout.EAST);
        helpPanel.add(_choosePanel, BorderLayout.NORTH);
        _centerPanel.add(helpPanel, BorderLayout.WEST);
        _centerPanel.add(_bottomPanel, BorderLayout.SOUTH);

        getContentPane().add(_centerPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if ((e.getActionCommand()).equals(OK)) {
            _lang.setLanguage((_langCBox.getSelectedItem()).toString());
            _net.setIP(_ipTF.getText());
            _engine.setMyNick(_nickNameTF.getText());
            _engine.setMyNationality((String)(_nationCBox.getSelectedItem()));
            _engine.setMap((String)(_mapCBox.getSelectedItem()));
            
            String message = _net.MSG_HELLO + "|" + 
                _ipTF.getText() + "|" +
                _nickNameTF.getText() + "|" +
                ((String)(_nationCBox.getSelectedItem())) + "|" +
                ((String)(_mapCBox.getSelectedItem()));
            _net.send(message);
            setVisible(false);
        } else if ((e.getActionCommand()).equals(CANCEL)) {
            System.exit(0);
        } else if ((e.getActionCommand()).equals(MAP_CHANGED)) {
            // set new image to map...
            _mapPreview.setIcon(new ImageIcon("maps" + File.separator + 
                    (_mapCBox.getSelectedItem().toString())
                    + File.separator + "map.jpg"));
            _mapPreview.repaint();
        } //  vielleicht noch die sprachen aendern
    }

    private Vector listDir(String dirName, String filename) {
        Vector list = new Vector();

        File file = new File(dirName);
        System.out.println(dirName);
        File[] dirs = file.listFiles();
        System.out.println(dirs);
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i].isDirectory()) {
                if (filename.equals("")) {
                    list.addElement(dirs[i].getName());
                } else {
                    list.addElement(dirs[i].getName() + 
                        File.separator + "banner.jpg");
                }
            }
        }
        return list;
    }

    class NationsCBoxRenderer extends JLabel implements ListCellRenderer {
        
        public NationsCBoxRenderer() {
            setOpaque(true);
        }
        public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus)
        {
            setIcon(new ImageIcon("nations" + File.separator + (String)value + File.separator + "banner.jpg"));
            setText((String)value);
            return this;
        }
    }
}
