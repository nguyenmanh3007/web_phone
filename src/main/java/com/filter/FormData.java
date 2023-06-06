package com.filter;

public class FormData {
	private String type;
    private String configuration;
    private String cost;
    
    public FormData() {
		// TODO Auto-generated constructor stub
	}

	public FormData(String type, String configuration, String cost) {
		super();
		this.type = type;
		this.configuration = configuration;
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getConfiguration() {
		return configuration;
	}

	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
    
}
