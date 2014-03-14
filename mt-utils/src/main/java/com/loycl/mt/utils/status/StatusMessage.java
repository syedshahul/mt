package com.loycl.mt.utils.status;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


/**
 * The type Status message.
 *
 * @author: Syed Shahul
 */
@XmlRootElement(name = "status")
public class StatusMessage implements Serializable {


	/**
	 * StatusMessage Message.
	 */
	private String message;

	/**
	 * response code.
	 */
	private int code;

	public StatusMessage() {
	}

	/**
	 * Instantiates a new Status message.
	 *
	 * @param message
	 * 	the message
	 * @param code
	 * 	the code
	 */
	public StatusMessage(String message, int code) {
		this.message = message;
		this.code = code;
	}

	/**
	 * Gets message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets message.
	 *
	 * @param message
	 * 	the message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets code.
	 *
	 * @param code
	 * 	the code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
			.append("{code:", this.getCode()).append(", message:", this.getMessage())
			.append("}");

		return sb.toString();
	}
}
