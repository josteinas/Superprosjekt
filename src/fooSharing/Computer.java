package fooSharing;

public class Computer {
	
	private String name;
	private String ip;
	
	public Computer(String name, String ip) {
		this.name = name;
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		
		return name;
	}


}
