package gui.helper;

import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

import fooSharing.Computer;
import fooSharing.ComputerListModel;

public class ComputerList extends JList {
	
	ComputerListModel listModel;
	
	public ComputerList(ArrayList<Computer> collection){
		listModel = new ComputerListModel(collection);
		setModel(listModel);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setCellRenderer(new MyListCellRenderer());
	}

}
