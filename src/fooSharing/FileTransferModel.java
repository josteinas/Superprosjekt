package fooSharing;

import java.io.File;

public class FileTransferModel {
	
	public FileTransferModel() {
		
	}
	
	
	
	
	
	 public void sendFile(File file, Computer computer){
	 System.out.println(file.getAbsolutePath());
	 System.out.println(computer.getName());
	 }

}
