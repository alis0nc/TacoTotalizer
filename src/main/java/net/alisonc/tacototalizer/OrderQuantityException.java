/**
 * 
 */
package net.alisonc.tacototalizer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * You can't order negative tacos. Nice try.
 * @author alisonc
 *
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Order quantities must be at least 0")
public class OrderQuantityException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
