package com.loycl.mt.utils.validation;

//~--- JDK imports ------------------------------------------------------------

import java.util.Collection;

/**
 * @author: Syed Shahul
 */
public class CollectionUtil {
  public static <T> boolean isEmpty(Collection<T> coll) {
    return (coll == null) || coll.isEmpty();
  }

  public static boolean isNotEmpty(String str) {
    return (str != null) &&!str.isEmpty();
  }
}
