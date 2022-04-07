package com.api.identitydocument.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequiredField extends RuntimeException {

	private String fieldName;
	private String className;
	
	public RequiredField(String fieldName, String className) {
		super(String.format("Field '%s' is required in class '%s'.", fieldName, className));
		this.fieldName = fieldName;
		this.className = className;
	}	

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getFieldName() {
		return fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
