package com.pixel.exceptions;

public class DAOException extends RuntimeException {


    /**
	 * 
	 */
	private static final long serialVersionUID = -7991366214607900022L;


	public DAOException( String message ) {
        super( message );
    }

    public DAOException( String message, Throwable cause ) {
        super( message, cause );
    }


    public DAOException( Throwable cause ) {
        super( cause );
    }
}
