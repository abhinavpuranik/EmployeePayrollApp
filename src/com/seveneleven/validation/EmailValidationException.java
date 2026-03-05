
/* @author Developer
 * @version 6.0
 * 
 */
package com.seveneleven.validation;

import com.seveneleven.registration.ValidationException;

public class EmailValidationException extends ValidationException {

    public EmailValidationException(String message) {
        super(message);
    }

}