package com.api.identitydocument.exception;


@SuppressWarnings("serial")
public class NotNullable extends RuntimeException {
	
	private String fieldName;	
	
	public NotNullable(String fieldName) {
		super(String.format(fieldName));
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}

