package com.loycl.mt.service.impl;

import com.loycl.mt.service.SampleManager;
import org.springframework.stereotype.Service;


/**
 * @author: Syed Shahul
 */
@Service("sampleManager")
public class SampleManagerImpl extends BaseManagerImpl implements
  SampleManager {
  @Override public String getService() {
    return "Service";
  }
}
