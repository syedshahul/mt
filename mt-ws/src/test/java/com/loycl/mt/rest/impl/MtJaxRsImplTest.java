package com.loycl.mt.rest.impl;

import com.loycl.mt.rest.MtJaxRs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

/**
 * @author: Syed Shahul
 */
@ContextConfiguration(locations = { "classpath*:applicationContext*.xml" })
@Test(singleThreaded = true)
public class MtJaxRsImplTest extends AbstractTestNGSpringContextTests {
	private static final Logger LOGGER =
		LoggerFactory.getLogger(MtJaxRsImplTest.class);

  @Qualifier("mtJaxRs")
	@Autowired
	private MtJaxRs mtJaxRs;
	@BeforeClass
	public void setUp() throws Exception {

	}

	@AfterClass
	public void tearDown() throws Exception {

	}

	@Test
	public void testPushMT() throws Exception {
		Integer i;
		for (i=0;i<50000;i++){

		 String input = "{\"mobile_no\":\""+i+"\"," +
		               "\"msg\":\"Hello "+i+"\"}";
	   mtJaxRs.pushMT(input);
			if(LOGGER.isInfoEnabled()){
			   LOGGER.info("Process : "+i);
			}
		}
		
	}
}
