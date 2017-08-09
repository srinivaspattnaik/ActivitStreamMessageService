package com.stackroute.activitystream.messageutility;

import javax.persistence.Transient;

import org.springframework.hateoas.ResourceSupport;

public class BaseDomain extends ResourceSupport
{
	@Transient
	public String statusCode;
	
	@Transient
	public String statusDesc;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
	

}
