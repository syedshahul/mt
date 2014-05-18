package com.loycl.mt.work.conversion;

import com.loycl.mt.model.MtRequest;
import com.loycl.mt.utils.conversion.MapperUtil;
import com.loycl.mt.utils.status.exception.MTException;
import org.springframework.amqp.core.Message;

/**
 * @author: Syed Shahul
 */
public class AmqpUtil {

	public static <T> T convertMessage(Message message) throws MTException {
		message.getMessageProperties().getType();
		switch (message.getMessageProperties().getType()) {
			case "MtRequest":
				return (T) MapperUtil
						.readAsObjectOf(MtRequest.class, new String(message.getBody()));
			default:
				break;
		}
		return (T) String.valueOf(message.getBody());
	}
}
