package io.yun.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by xulingfeng on 16/8/31.
 */
public class Utils {

  public static String hash(String password, String salt) {
    String hex = DigestUtils.sha1Hex(salt+password);
    return DigestUtils.sha1Hex(hex);
  }
}
