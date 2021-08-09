package com.thuctapcdit.qlnguyenlieube.dto;

import lombok.Data;

@Data
public class ExceptionResponse {
	 private Integer code;
	    private String message;

	    public ExceptionResponse() {
	    }

	    public ExceptionResponse(String message, Integer code) {
	        this.message = message;
	        this.code = code;

	    }


	    public static ExceptionResponse responseFail(String message){
	    	ExceptionResponse responseEx = new ExceptionResponse();
	        responseEx.setMessage(message);
	        return responseEx;
	    }
	    public static ExceptionResponse responseFail(String message, Integer code){
	    	ExceptionResponse responseEx = new ExceptionResponse();
	        responseEx.setMessage(message);
	        responseEx.setCode(code);
	        return responseEx;
	    }


}
