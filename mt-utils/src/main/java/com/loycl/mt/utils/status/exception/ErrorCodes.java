package com.loycl.mt.utils.status.exception;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * Generic Error Codes for the project. Suggested ErrorCode ranges:
 * ServiceErrors 100-199 ControllerError 200-299 ModelError 300-399 The project
 * should provide the detailed error codes.
 * <p/>
 * http://static.springsource.org/spring/docs/3.0 .x/javadoc-api/org/springframework/http/HttpStatus.html
 *
 * @author: Syed Shahul
 */
public enum ErrorCodes {

	/**
	 * List of defined ErrorCodes.
	 */
	ServiceOk(200, "OK"),

	/**
	 * The Service error.
	 */
	ServiceError(100, "Error in service"), CREATED(201, "CREATED"),

	/* on success of DELETE request */
	ACCEPTED(202, "Accepted"),

	/* on success of PUT request */
	NO_CONTENT(204, "No Content"), CONFLICT(409, "Conflict"),
	SYSTEM_EXCEPTION(500, "System exception"),
	VALIDATION_EXCEPTION(400, "Validation exception"),
	FAILED_TO_PARSE_DATA(501,"failed to parse data"),

	/**
	 * The Default error code.
	 */
	DefaultErrorCode(500, "Internal server error"),

	/* DAO Error Codes */

	/**
	 * The Duplicate entry.
	 */
	DuplicateEntry(301, "Duplicate entry"),

	/**
	 * The Database error.
	 */
	DatabaseError(300, "Database error"),

	/**
	 * The User not found.
	 */
	UserNotFound(302, "User not found"),

	/**
	 * The Passwords do not match.
	 */
	PasswordsDoNotMatch(303, "Passwords do not match"),

	/**
	 * The Already exists.
	 */
	AlreadyExists(304, "Already exists"),

	/**
	 * The Controller error.
	 */
	ControllerError(305, "Error in action"),

	/**
	 * The Data not found.
	 */
	DataNotFound(306, "Data not found"),

	/**
	 * The Data not sufficient.
	 */
	DataNotSufficient(307, "Data not sufficient"),

	/* Service Error codes */

	/**
	 * The Params not sufficient.
	 */
	ParamsNotSufficient(101, "Params not sufficient"),

	/**
	 * The Params empty.
	 */
	ParamsEmpty(102, "Params empty"),

	/**
	 * The Not available.
	 */
	NotAvailable(103, "Not available"),

	/**
	 * The Operation returned no results.
	 */
	OperationReturnedNoResults(104, "Operation returned no results"),

	/**
	 * The Params not correct.
	 */
	ParamsNotCorrect(105, "Params not correct");

	/**
	 * error Message.
	 */
	private String errorMessage;

	/**
	 * errorCode value.
	 */
	private int errorCode;

	/**
	 * private constructor for enum.
	 *
	 * @param code    errorCode.
	 * @param message errorMessage to understand errorCode.
	 */
	private ErrorCodes(final int code, final String message) {
		this.errorCode    = code;
		this.errorMessage = message;
	}

	/**
	 * getErrorMessage for the class.
	 *
	 * @return String errorMessage.
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * error Code value.
	 *
	 * @return int. error code
	 */
	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return "ErrorCodes{" +
		       "errorCode=" + errorCode +
		       ", errorMessage='" + errorMessage + '\'' +
		       '}';
	}

}
