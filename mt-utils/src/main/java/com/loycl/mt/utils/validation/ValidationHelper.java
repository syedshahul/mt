package com.loycl.mt.utils.validation;

import com.google.common.collect.Lists;
import com.loycl.mt.utils.status.exception.ErrorCodes;
import com.loycl.mt.utils.status.exception.MTException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ValidationHelper {
	private final ValidatorFactory factory;
	private final Validator validator;

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
			Iterator<ConstraintViolation<Object>> it =
				constraintViolations.iterator();

			while(it.hasNext()) {
				messages.add(it.next().getMessage());
			}

			MTException validationException = new MTException(
				ErrorCodes.VALIDATION_EXCEPTION, messages);

			validationException.setErrorMessages(messages);
			validationException.setSource(object);

			throw validationException;
		}
	}
}
