package com.loycl.mt.utils.conversion;

//~--- non-JDK imports --------------------------------------------------------

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loycl.mt.utils.status.exception.ErrorCodes;
import com.loycl.mt.utils.status.exception.MTException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

//~--- JDK imports ------------------------------------------------------------

public final class MapperUtil {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(MapperUtil.class);
	private static final ObjectMapper MAPPER = JacksonConfig.createMapper();
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * Prevent any construction.
	 */
	private MapperUtil() {
		super();
	}

	public static <T> T convertToObjectOf(Class<T> clazz, Object object)
			throws MTException {
		try {
			return MAPPER.convertValue(object, clazz);
		} catch (Exception e) {
			LOGGER.error("{}, {}", e.getMessage(), e.fillInStackTrace());
			throw new MTException(toErrorCodeList(ErrorCodes.SYSTEM_EXCEPTION,
			                                      ErrorCodes.FAILED_TO_PARSE_DATA),
			                      null, null, null, e
			);
		}
	}

	public static <T> T convertToObjectOf(TypeReference<T> typeReference,
	                                      Object object) throws MTException {
		try {
			return MAPPER.convertValue(object, typeReference);
		} catch (Exception e) {
			LOGGER.error("{}, {}", e.getMessage(), e.fillInStackTrace());

			throw new MTException(toErrorCodeList(ErrorCodes.SYSTEM_EXCEPTION,
			                                      ErrorCodes.FAILED_TO_PARSE_DATA),
			                      null, null, null, e
			);
		}
	}

	public static <T> T readAsObjectOf(Class<T> clazz, String value)
			throws MTException {
		try {
			return MAPPER.readValue(value, clazz);
		} catch (Exception e) {
			LOGGER.error("{}, {}", e.getMessage(), e.fillInStackTrace());
			throw new MTException(toErrorCodeList(ErrorCodes.SYSTEM_EXCEPTION,
			                                      ErrorCodes.FAILED_TO_PARSE_DATA),
			                      null, null, null, e
			);
		}
	}

	public static <T> T readAsObjectOf(TypeReference<T> typeReference,
	                                   String value) throws MTException {
		try {
			return MAPPER.readValue(value, typeReference);
		} catch (IOException e) {
			LOGGER.error("{}, {}", e.getMessage(), e.fillInStackTrace());

			throw new MTException(toErrorCodeList(ErrorCodes.SYSTEM_EXCEPTION,
			                                      ErrorCodes.FAILED_TO_PARSE_DATA),
			                      null, null, null, e
			);
		}
	}

	public static String convertToString(Object object) throws MTException {
		try {
			return MAPPER.writeValueAsString(object);
		} catch (IOException e) {
			LOGGER.error("{}, {}", e.getMessage(), e.fillInStackTrace());

			throw new MTException(toErrorCodeList(ErrorCodes.SYSTEM_EXCEPTION,
			                                      ErrorCodes.FAILED_TO_PARSE_DATA),
			                      null, null, null, e
			);
		}
	}

	/**
	 * Use JacksonConverter for date serialization and deserialization
	 *
	 * @param dateStr
	 * @return
	 * @throws MTException
	 */
	@Deprecated
	public static Date convertToDate(String dateStr) throws MTException {
		try {
			return convertToDate(dateStr, DEFAULT_DATE_FORMAT);
		} catch (MTException e) {
			LOGGER.error("{}, {}", e.getMessage(), e.fillInStackTrace());

			throw e;
		}
	}

	/**
	 * Use JacksonConverter for date serialization and deserialization
	 *
	 * @param dateStr
	 * @param dateFormat
	 * @return
	 * @throws MTException
	 */
	@Deprecated
	public static Date convertToDate(String dateStr, String dateFormat)
			throws MTException {
		try {
			DateFormat formatter = new SimpleDateFormat(dateFormat);

			return new Date(formatter.parse(dateStr).getTime());
		} catch (ParseException e) {
			LOGGER.error("{}, {}", e.getMessage(), e.fillInStackTrace());

			throw new MTException(toErrorCodeList(ErrorCodes.SYSTEM_EXCEPTION,
			                                      ErrorCodes.FAILED_TO_PARSE_DATA),
			                      null, null, null, e
			);
		}
	}

	public static Map<String, Object> toMap(final String jsonString)
			throws MTException {
		try {
			if (StringUtils.isBlank(jsonString)) {
				return Collections.emptyMap();
			}

			return MAPPER
					.readValue(jsonString, new TypeReference<Map<String, Object>>() {
					});
		} catch (Exception cause) {
			LOGGER.error("Problem decoding json string into map {}", cause);

			throw new MTException(toErrorCodeList(ErrorCodes.SYSTEM_EXCEPTION,
			                                      ErrorCodes.FAILED_TO_PARSE_DATA),
			                      null, null, null, cause
			);
		}
	}

	public static <K, V> Map<K, V> toMap(final InputStream inputStream)
			throws MTException {
		try {
			if (inputStream == null) {
				return Collections.emptyMap();
			}

			return MAPPER.readValue(inputStream, new TypeReference<Map<K, V>>() {
			});
		} catch (Exception cause) {
			LOGGER.error("Problem decoding inputstream data into map {}", cause);

			throw new MTException(toErrorCodeList(ErrorCodes.SYSTEM_EXCEPTION,
			                                      ErrorCodes.FAILED_TO_PARSE_DATA),
			                      null, null, null, cause
			);
		}
	}

	public static List<ErrorCodes> toErrorCodeList(ErrorCodes... errorCodes) {
		return Arrays.asList(errorCodes);
	}
}
