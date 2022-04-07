package com.api.identitydocument.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GenericException extends RuntimeException {

	private String resourceName;
	private String fieldName;	
	private String errorDesc;
	public GenericException(String resourceName, String fieldName, String errorDesc) {
		super(String.format("%s generate error with %s: %s.", resourceName, fieldName, errorDesc));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.errorDesc = errorDesc;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}	
}