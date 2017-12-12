package com.medicapp.data.model;

public class PrescriptWrap {
	private String encodedFile;

	public String getEncodedFile() {
		return encodedFile;
	}

	public void setEncodedFile(String encodedFile) {
		this.encodedFile = encodedFile;
	}

	public PrescriptWrap(String encodedFile) {
		super();
		this.encodedFile = encodedFile;
	}
	
}
