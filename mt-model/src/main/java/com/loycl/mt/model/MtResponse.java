package com.loycl.mt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author: Syed Shahul
 */
@XmlRootElement(name = "mtResponse") @XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class MtResponse implements Serializable{
	
	private static final long serialVersionUID = -3081516183308198744L;
	/**
	 * reference_no
	 */

	private String referenceNo;

	/**
	 * Default constructor is required for JAXB conversion.
	 */
	public MtResponse() {
	}

	public MtResponse(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	@Override public String toString() {
		return "MtResponse{" +
		       "referenceNo='" + referenceNo + '\'' +
		       '}';
	}
}
