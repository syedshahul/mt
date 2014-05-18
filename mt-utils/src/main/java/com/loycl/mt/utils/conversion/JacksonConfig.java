package com.loycl.mt.utils.conversion;

//~--- non-JDK imports --------------------------------------------------------

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

/**
 * This class provides methods to configure and get a Jackson JSON processor.
 * <p/>
 *
 * @author $author$
 * @version $Revision$, $Date$
 */
public final class JacksonConfig {
	private JacksonConfig() {
		super();
	}

	public static ObjectMapper createMapper() {
		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES,
		                 false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility
				.ANY);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		AnnotationIntrospector pair =
				new AnnotationIntrospectorPair(new JacksonAnnotationIntrospector(),
				                               new JaxbAnnotationIntrospector(
						                               TypeFactory.defaultInstance())
				);

		mapper.setAnnotationIntrospector(pair);

		return mapper;
	}
}
