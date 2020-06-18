package com.example.demo.exception;

public class RawMaterialsNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
    public RawMaterialsNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

	public RawMaterialsNotFoundException(String message) {
		super(message);
		
	}
    

}