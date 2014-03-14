package com.loycl.mt.utils.status.exception;


import java.util.List;

/**
 * Custom exception class for the project.
 *
 * @author: Syed Shahul
 */
public class MTException extends Exception {
	private static final long serialVersionUID = -3346790275219831279L;

	/**
	 * error code to set.
	 */
	private ErrorCodes errorCode = ErrorCodes.DefaultErrorCode;

	/**
	 * className.
	 */
	private String errorName;

	/**
	 * The error message.
	 */
	private String errorMessage;

	/**
	 * The error messages.
	 */
	private List<String> errorMessages;

	/**
	 * The source that caused the exception.
	 */
	private Object source;

	/**
	 * constructor to wrap the generic exception.
	 *
	 * @param errorCode
	 * 	exception
	 */
	public MTException(final ErrorCodes errorCode) {
		super();
		this.errorCode = errorCode;
	}

	/**
	 * constructor to wrap the generic exception.
	 *
	 * @param e
	 * 	exception
	 */
	public MTException(final Exception e) {
		super(e);
	}

	/**
	 * constructor to wrap the generic exception.
	 *
	 * @param message
	 * 	exception message.
	 */
	public MTException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new price net exception.
	 *
	 * @param errorCode
	 * 	the error code
	 * @param errorMessage
	 * 	the error message
	 */
	public MTException(ErrorCodes errorCode, final String errorMessage) {
		super();
		setErrorCode(errorCode);
		setErrorMessage(errorMessage);
	}

	/**
	 * constructor to wrap entity.
	 *
	 * @param e
	 * 	exception
	 * @param errorName
	 * 	the error name
	 */
	public MTException(final Exception e, final String errorName) {
		super(e);
		setErrorName(errorName);
	}

	/**
	 * Instantiates a new price net exception.
	 *
	 * @param e
	 * 	the e
	 * @param errorCode
	 * 	the error code
	 * @param errorMessage
	 * 	the error message
	 */
	public MTException(final Exception e, ErrorCodes errorCode,
	                   final String errorMessage) {
		super(e);
		setErrorCode(errorCode);
		setErrorMessage(errorMessage);
	}

	public MTException(final Exception e, ErrorCodes errorCode,
	                   final List<String> errorMessages) {
		super(e);
		setErrorCode(errorCode);
		setErrorMessages(errorMessages);
	}

	public MTException(ErrorCodes errorCode, final List<String> errorMessages) {
		setErrorCode(errorCode);
		setErrorMessages(errorMessages);
	}

	/**
	 * Gets the error message.
	 *
	 * @return errorMessage error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * setErrorMessage.
	 *
	 * @param errorMessage
	 * 	error message from the define method.
	 */
	public final void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the error messages.
	 *
	 * @return errorMessages error messages
	 */
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	/**
	 * setErrorMessages.
	 *
	 * @param errorMessages
	 * 	error messages from the define method.
	 */
	public void setErrorMessages(final List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	/**
	 * Gets the source.
	 *
	 * @return source
	 */
	public Object getSource() {
		return source;
	}

	/**
	 * setSource.
	 *
	 * @param source
	 * 	source from the define method.
	 */
	public void setSource(final Object source) {
		this.source = source;
	}

	/**
	 * Gets the error name.
	 *
	 * @return the errorName
	 */
	public String getErrorName() {
		return errorName;
	}

	/**
	 * Sets the error name.
	 *
	 * @param errorName
	 * 	the errorName to set
	 */
	public final void setErrorName(final String errorName) {
		this.errorName = errorName;
	}

	/**
	 * set the appropriate errorCode.
	 *
	 * @param errorCode
	 * 	errorCode to be used.
	 */
	public final void setErrorCode(final ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * get Error Code.
	 *
	 * @return int. error code
	 */
	public int getErrorCode() {
		return this.errorCode.getErrorCode();
	}

	/**
	 * get Error Code detail.
	 *
	 * @return int. error code detail
	 */
	public String getErrorCodeDetail() {
		return this.errorCode.getErrorMessage();
	}

	/**
	 * Overrides the toString of ExceptionClass. It is in json format. It can thus
	 * be easily passed to the UI layer.
	 *
	 * @return customized message.
	 */
	@Override
	public String toString() {
		String messages = "";
		if(this.errorMessages != null) {
			for(String message : this.errorMessages) {
				messages = messages.concat(", ").concat(message);
			}
		}

		StringBuilder stringBuilder = new StringBuilder()
			//{"message":"message", "code":"400"}
			.append("{").append("\"messages\":\"").append(
				this.errorMessage != null ? this.errorMessage.concat(", ") : "").append(
				messages != null ? messages : "").append("\",").append("\"code\":\"")
			.append(getErrorCode()).append("\"").append("}");
		return stringBuilder.toString();
	}
}
