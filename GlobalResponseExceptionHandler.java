package my.smvc.hib.api.exception.handler;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalResponseExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(RuntimeException.class)
	
	
	
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		CustomException customException = new CustomException(ex.getMessage());

		if (ex instanceof EntityNotFoundException) {
			status = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<Object>(customException, status);
	}

}
