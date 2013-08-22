package fooSharing;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;


public class ComputerListModel extends DefaultListModel implements ListModel {
	
	ArrayList<Computer> collection = new ArrayList<Computer>();
	
	public ComputerListModel(){
		
	}

	public ComputerListModel(Collection<Computer> collection) {
		this.collection = (ArrayList<Computer>) collection;
	}

	public Object getElementAt(int index) {
		return (collection.get(index));
	}

	public int getSize() {
		return (collection.size());
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub

	}

	 public void sendFile(File file, String computerName){
	 System.out.println(file.getAbsolutePath());
	 System.out.println(computerName);
	 }

}
