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
	ServiceError(100, "Error in service"),
	CREATED(201, "CREATED"),
	/* on success of DELETE request*/
	ACCEPTED(202, "Accepted"),
	/* on success of PUT request*/
	NO_CONTENT(204, "No Content"),
	CONFLICT(409, "Conflict"),
	OPERATION_UNSUCCESSFUL(500, "Operation Unsuccessful, please try again"),
	VALIDATION_EXCEPTION(400, "Validation Exception"),

	/**
	 * The Default error code.
	 */
	DefaultErrorCode(500, "Internal Server Error"),

	/* DAO Error Codes */

	/**
	 * The Duplicate entry.
	 */
	DuplicateEntry(301, "DuplicateEntry"),

	/**
	 * The Database error.
	 */
	DatabaseError(300, "DatabaseError"),

	/**
	 * The User not found.
	 */
	UserNotFound(302, "UserNotFound"),

	/**
	 * The Passwords do not match.
	 */
	PasswordsDoNotMatch(303, "PasswordsDoNotMatch"),

	/**
	 * The Already exists.
	 */
	AlreadyExists(304, "AlreadyExists"),

	/**
	 * The Controller error.
	 */
	ControllerError(305, "Error in Action"),

	/**
	 * The Data not found.
	 */
	DataNotFound(306, "DataNotFound"),

	/**
	 * The Data not sufficient.
	 */
	DataNotSufficient(307, "DataNotSufficient"),

	/* Service Error codes */

	/**
	 * The Params not sufficient.
	 */
	ParamsNotSufficient(101, "ParamsNotSufficient"),

	/**
	 * The Params empty.
	 */
	ParamsEmpty(102, "ParamsEmpty"),

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
	 * @param code
	 * 	errorCode.
	 * @param message
	 * 	errorMessage to understand errorCode.
	 */
	private ErrorCodes(final int code, final String message) {
		this.errorCode = code;
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
