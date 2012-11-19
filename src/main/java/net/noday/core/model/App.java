package net.noday.core.model;

import java.io.Serializable;

public class App implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
