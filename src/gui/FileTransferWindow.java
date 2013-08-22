package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fooSharing.Computer;
import fooSharing.FileTransferModel;
import gui.helper.ComputerList;

public class FileTransferWindow extends JPanel {
	
	private JButton btnSendFile;
	private ArrayList<Computer> collection;
	private ComputerList computerList;
	private JScrollPane listScrollPane;
	private JLabel lblComputers;
	private JButton btnRefresh;
	private FileTransferModel model;
	
	public static void main(String[] args) {
		JFrame frame1 = new JFrame("bugggg");
		FileTransferWindow panel = new FileTransferWindow();
		frame1.getContentPane().add(panel);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.pack();
		frame1.setVisible(true);
		
	}
	
	public FileTransferWindow() {
		
		model = new FileTransferModel(this);
		
		int i = 0;
		

		//setBackground(Color.ORANGE);
		setLayout(new GridBagLayout());
		
		collection = new ArrayList<Computer>();

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
		
		computerList = new ComputerList(collection);
		listScrollPane = new JScrollPane(computerList);
		listScrollPane.setMinimumSize(new Dimension(120,300 ));		
		listScrollPane.setPreferredSize(new Dimension(150, 300));
		lblComputers = new JLabel("Computers");
		listScrollPane.setColumnHeaderView(lblComputers);
		add(listScrollPane, new GBC(i,0).setWeight(0.5 , 0).setHeight(4).setFill(GBC.HORIZONTAL));
		
		
		
		i++;
		
		btnRefresh = new JButton("Refresh");

		btnRefresh.addActionListener(new RefreshListener());
		add(btnRefresh, new GBC(i,0).setHeight(1).setWeight(0.5, 0).setFill(GBC.HORIZONTAL));
	
		
		btnSendFile = new JButton("Send file");
		btnSendFile.addActionListener(new SendFileListener());
		add(btnSendFile, new GBC(i,1).setHeight(1).setWeight(0.5, 0).setFill(GBC.HORIZONTAL));
		
		
	}
	class SendFileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(computerList.getAnchorSelectionIndex() == -1) {
				JOptionPane.showMessageDialog(btnSendFile, "Velg noen aa sende til!", "Advarsel", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JFileChooser c = new JFileChooser();
				int rVal = c.showOpenDialog(FileTransferWindow.this);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					 model.sendFile(c.getSelectedFile(),(Computer) computerList.getSelectedValue());
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
