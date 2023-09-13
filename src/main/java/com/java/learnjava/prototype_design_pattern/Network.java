package com.java.learnjava.prototype_design_pattern;

public class Network implements Cloneable {

	private String ip;
	private String data;
	public String getIp() {
		return ip;
	}
	public String getData() {
		return data;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Network [ip=" + ip + ", data=" + data + "]";
	}
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public void loadImportantData() throws InterruptedException {
		Thread.sleep(10000);
		System.out.println("loaded data");
		
	}
	
	
}
