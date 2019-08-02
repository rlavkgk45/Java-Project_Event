package event.exception;

import Log4j.Log4j;

public class NotExistException extends Exception{
	public NotExistException(){}
	public NotExistException(String message){
		super(message);
		Log4j.logger();
	}
}