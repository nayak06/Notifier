package com.notifier.notebook;

public class notebook_name_bin {
	


	 private String notebook_name;
	 private int count;
	 

	
	
	
	public String getNotebook_name() {
		return notebook_name;
	}

	public void setNotebook_name(String notebook_name) {
		this.notebook_name = notebook_name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	@Override
	public String toString() {
		return "notebook_name_bin [notebook_name=" + notebook_name + ", count=" + count + "]";
	}

	public notebook_name_bin(String notebook_name, int count) {
		super();
		this.notebook_name = notebook_name;
		this.count = count;
		
	}
	
	

}
