package order.mng.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import order.mng.utils.MessageUtils;

@Controller
public class GlobalExceptionHandler {
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<?> orderNotFoundException(OrderNotFoundException ex,WebRequest request)
	{
		MessageUtils msgUtils=new MessageUtils();
		msgUtils.setMessage(ex.getMessage());
		return new ResponseEntity<>(msgUtils,HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		    MessageUtils msgUtils=new MessageUtils();
			msgUtils.setMessage(ex.getMessage());
		   return new ResponseEntity<>(msgUtils, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
