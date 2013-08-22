package fooSharing;

import gui.FileTransferWindow;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileTransferModel {
	
	FileTransferWindow view;
	
	public FileTransferModel(FileTransferWindow view) {
		this.view = view;
	}
	
	
	public boolean acceptFile(TransferRequest request) {
		
		int n = JOptionPane.showConfirmDialog(view, "Vil du motta " 
	+ request.getFilename() + " fra " + request.getComputer().getName() 
	+ "?", "Foresp¿rsel", JOptionPane.YES_NO_OPTION,
	JOptionPane.QUESTION_MESSAGE);
		if(n == JOptionPane.YES_OPTION) {
			JFileChooser filechooser = new JFileChooser();
			filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int choice = filechooser.showSaveDialog(view);
			if (choice == JFileChooser.APPROVE_OPTION) {
				request.setLocation(new File(filechooser.getSelectedFile().getAbsolutePath() + "/" + request.getFilename()));
				return true;
				
			}
		}
		return false;
	}
	
	
	 public void sendFile(File file, Computer computer){
	 System.out.println(file.getAbsolutePath());
	 System.out.println(computer.getName());
	 }

}
