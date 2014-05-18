package com.loycl.mt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author: Syed Shahul
 */

@XmlRootElement(name = "sample")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class Sample implements Serializable {

	private static final long serialVersionUID = -697233093460220089L;
	@XmlElement(name = "msg")
	private String msg;

	/**
	 * Default constructor is required for JAXB conversion.
	 */
	public Sample() {
	}

	public Sample(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Sample{" +
				"msg='" + msg + '\'' +
				'}';
	}
}
