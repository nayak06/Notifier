package com.notifier.edituser;

public class edituserBin {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public edituserBin(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "edituserBin [name=" + name + "]";
	}

}
