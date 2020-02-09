package com.cteste.cursomc2.resources.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError implements Serializable {

	
	private List<FieldMessage> errors = new ArrayList<>();
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void  addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
		
	}

}

