package fooSharing;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ComputerList extends JList {
	
	ComputerListModel listModel;
	JScrollPane listScrollPane;
	JLabel lblComputers;
	JList list;
	
	public ComputerList(){
		listModel = new ComputerListModel();
		list.setModel(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setCellRenderer(new MyListCellRenderer());
		//listScrollPane = new JScrollPane(list);
		//listScrollPane.setMinimumSize(new Dimension(120,300 ));		
		//listScrollPane.setPreferredSize(new Dimension(150, 300));
		lblComputers = new JLabel("Computers");
		//listScrollPane.setColumnHeaderView(lblComputers);
	}

}
