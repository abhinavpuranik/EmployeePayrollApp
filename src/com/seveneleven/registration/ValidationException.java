/* @author Developer
 * @version 1.0
 * Custom exception
 */

package com.seveneleven.registration;

public class ValidationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
		super(message);
	}
}
