package com.loycl.mt.utils.status.exception;


import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * Custom exception class for the project.
 *
 * @author: Syed Shahul
 */

public class MTException extends Exception implements Serializable{

	private static final long serialVersionUID = -8215491669064289884L;

	private List<ErrorCodes> errorCodes;

	private List<String> errorMessages;

	private String errorCause;
	/**
	 * The source that caused the exception.
	 */
	@XmlTransient
	private Object source;

	/**
	 * Default constructor is required for JAXB conversion.
	 */
	public MTException() {
	}

	public MTException(List<ErrorCodes> errorCodes, List<String> errorMessages,
	                   String errorCause, Object source, final Exception e) {
		super(e);
		this.errorCodes = errorCodes;
		this.errorMessages = errorMessages;
		this.errorCause = errorCause;
		this.source=source;
	}

	public List<ErrorCodes> getErrorCodes() {
		return errorCodes;
	}

	public void setErrorCodes(List<ErrorCodes> errorCodes) {
		this.errorCodes = errorCodes;
	}

	public String getErrorCause() {
		return errorCause;
	}

	public void setErrorCause(String errorCause) {
		this.errorCause = errorCause;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}

	/**
	 * Overrides the toString of ExceptionClass. It is in json format. It can thus
	 * be easily passed to the UI layer.
	 *
	 * @return customized message.
	 */
	@Override public String toString() {
		return "MTException{" +
		       "errorCodes=" + errorCodes +
		       ", errorMessages=" + errorMessages +
		       ", errorCause='" + errorCause + '\'' +
		       ", source=" + source +
		       '}';
	}
}
