package com.loycl.mt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author: Syed Shahul
 */
@XmlRootElement(name = "mtException") @XmlAccessorType(XmlAccessType
	                                                               .FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class MtExceptionResponse implements Serializable{

	private static final long serialVersionUID = -4670433838988718653L;
	// todo : http://www.developpez.net/forums/d972324/java/general-java/xml/hashmap-jaxb/
	//todo :  http://stackoverflow
	// .com/questions/3941479/jaxb-how-to-marshall-map-into-keyvalue-key
	@XmlElementWrapper(name="errorMsgs")
	private Map<Integer, String> errorMsgs;

	/**
	 * Default constructor is required for JAXB conversion.
	 */
	public MtExceptionResponse() {
	}

	public Map<Integer, String> getErrorMsgs() {
		return errorMsgs;
	}

	public void setErrorMsgs(Map<Integer, String> errorMsgs) {
		this.errorMsgs = errorMsgs;
	}

	@Override public String toString() {
		return "MtExceptionResponse{" +
		       "errorMsgs=" + errorMsgs +
		       '}';
	}
}
