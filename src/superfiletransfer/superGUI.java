package superfiletransfer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

import fooSharing.Computer;
import fooSharing.ComputerListModel;
import fooSharing.MyListCellRenderer;

public class superGUI extends JPanel {
	
	private JList list;
	private ComputerListModel listModel;
	private JButton btnSendFile;
	private JScrollPane listScrollPane;
	private Collection<Computer> collection;
	private JButton btnRefresh;
	private JLabel lblComputers;
	//private static JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Filetransfer");
        frame.getContentPane().add(new superGUI());
        //frame.setSize (500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

	public superGUI() {
		/*String location = "/Users/Jostein/Documents/workspace/Superprosjekt/src/datamaskin.jpg";
		Icon pingImage = new ImageIcon(location);
		JLabel pingLabel = new JLabel("Ping", pingImage, JLabel.LEFT);
		JPanel pingPanel = new JPanel();
		pingPanel.add(pingLabel);
		*/
		//contentPanel.setSize(500, 500);
		//add(contentPanel);
		this.setBackground(Color.ORANGE);
		setLayout(new GridBagLayout());
		
		collection = new ArrayList<Computer>();
		//collection.add("Jostein");
		//collection.add("Hakon");
		collection.add(new Computer("jostein", "192.168.1.101"));
		collection.add(new Computer("hakon", "192.168.1.102"));
		collection.add(new Computer("hakon", "192.168.1.102"));
		collection.add(new Computer("hakon", "192.168.1.102"));
		collection.add(new Computer("hakon", "192.168.1.102"));
		collection.add(new Computer("hakon", "192.168.1.102"));
		collection.add(new Computer("hakon", "192.168.1.102"));
		collection.add(new Computer("hakon", "192.168.1.102"));
		collection.add(new Computer("hakon", "192.168.1.102"));
		collection.add(new Computer("hakon", "192.168.1.102"));
		
		listModel = new ComputerListModel(collection);
		//listModel.addElement("Jostein");

		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints c = new GridBagConstraints();
		//		model.addElement("Jostein");
		//		model.addElement("Jostein");
		//		model.addElement("Josteinzssnsnjsnshsnsnsnsnsnsnsnsn");
		//		model.addElement("Jostein");
		//		model.addElement("Jostein");
		//		model.addElement("Jostein");
		//		model.addElement("Jostein");
		//		model.addElement("Jostein");
		//		model.addElement("Jostein");
				//model.addElement(pingPanel);
				//add(list);
		list.setCellRenderer(new MyListCellRenderer());
		listScrollPane = new JScrollPane(list);
		listScrollPane.setMinimumSize(new Dimension(120,300 ));		
		listScrollPane.setPreferredSize(new Dimension(150, 300));
		lblComputers = new JLabel("Computers");
		listScrollPane.setColumnHeaderView(lblComputers);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 4;
		add(listScrollPane, c);
		
		
		btnRefresh = new JButton("Refresh");
		//btnRefresh.setBorder(BorderFactory.createEmptyBorder());
		//btnRefresh.setContentAreaFilled(false);
		btnRefresh.addActionListener(new RefreshListener());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		add(btnRefresh, c);
	
		
		btnSendFile = new JButton("Send file");
		btnSendFile.addActionListener(new SendFileListener());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 1;
		add(btnSendFile, c);
		
		//splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
		//		listScrollPane, 
		//		buttonPanel);
		
		//add(splitPane);

	}
	
	class SendFileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(list.getAnchorSelectionIndex() == -1) {
				JOptionPane.showMessageDialog(btnSendFile, "Velg noen aa sende til!", "Advarsel", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JFileChooser c = new JFileChooser();
				int rVal = c.showOpenDialog(superGUI.this);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					 listModel.sendFile(c.getSelectedFile(),listModel.get(list.getAnchorSelectionIndex()).toString());
				}
				if (rVal == JFileChooser.CANCEL_OPTION) {
				}
			
			}
			
		}
		
	}
	class RefreshListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			collection.removeAll(collection);
			//listModel.clear();
			//listModel.removeAllElements();
			repaint();
			System.out.println("Refresh");
			
			
		}
		
	}
}
