package com.loycl.mt.utils.generator.impl;

//~--- non-JDK imports --------------------------------------------------------

import com.loycl.mt.utils.generator.LongGenerator;

import java.util.concurrent.atomic.AtomicLong;

//~--- JDK imports ------------------------------------------------------------

public class AtomicLongGenerator implements LongGenerator {
  private final AtomicLong atomicLong;

  private AtomicLongGenerator() {
    atomicLong = new AtomicLong(System.currentTimeMillis());
  }

  public Long generate() {
    return atomicLong.incrementAndGet();
  }
}
