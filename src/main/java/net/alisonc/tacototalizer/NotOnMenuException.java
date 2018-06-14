/**
 * 
 */
package net.alisonc.tacototalizer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception! We don't serve that!
 * @author alisonc
 *
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="An item in your order wasn't on the menu")
public class NotOnMenuException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
