/* @author Developer
 * @version 6.0
 * 
 */

package com.seveneleven.validation;

import com.seveneleven.registration.ValidationException;

public class PasswordValidationException extends ValidationException {

    public PasswordValidationException(String message) {
        super(message);
    }

}