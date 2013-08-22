package fooSharing;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;


public class ComputerListModel extends DefaultListModel {
	
	ArrayList<Computer> computers = new ArrayList<Computer>();
	
	public ComputerListModel(){
		
	}

	public ComputerListModel(Collection<Computer> computers) {
		this.computers = (ArrayList<Computer>) computers;
	}

	public Object getElementAt(int index) {
		return (computers.get(index));
	}

	public int getSize() {
		return (computers.size());
	}
	
	public void updateComputers(ArrayList<Computer> computers) {
		this.computers.removeAll(computers);
		this.computers.addAll(computers);
	}


}
