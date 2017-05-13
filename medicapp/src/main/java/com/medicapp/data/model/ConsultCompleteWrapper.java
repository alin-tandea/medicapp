package com.medicapp.data.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConsultCompleteWrapper {
	private String observations;
	
	

	public ConsultCompleteWrapper() {
		super();
	}

	public ConsultCompleteWrapper(String observations) {
		super();
		this.observations = observations;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	
}
