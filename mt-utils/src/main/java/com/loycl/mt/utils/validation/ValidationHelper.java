package com.loycl.mt.utils.validation;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.loycl.mt.utils.status.exception.ErrorCodes;
import com.loycl.mt.utils.status.exception.MTException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidationHelper {
	private final ValidatorFactory factory;
	private final Validator validator;
	private static Map<String,ErrorCodes> errorCodesMap =new HashMap<>();

	static {
		for (ErrorCodes errorCode : ErrorCodes.values()) {
			errorCodesMap.put(errorCode.getErrorMessage(), errorCode);
		}
	}
	public ValidationHelper() {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public void validate(Object object) throws MTException {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(
			object);

		if(!constraintViolations.isEmpty()) {
			List<String> messages = Lists.newArrayListWithCapacity(
				constraintViolations.size());
			List<ErrorCodes> validationErrCodes = Lists.newArrayListWithCapacity(
				constraintViolations.size());

			Iterator<ConstraintViolation<Object>> it =
				constraintViolations.iterator();

			while(it.hasNext()) {
				messages.add(it.next().getMessage());
				validationErrCodes.add(errorCodesMap.get(it.next().getMessage()));
			}

			throw new MTException(validationErrCodes, messages, null, object);
		}
	}
}
