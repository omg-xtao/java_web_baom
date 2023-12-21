package com.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author xtaod
 */
public class Encrypt {
    public static String MD5(String s) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(s.getBytes());
            byte[] md = mdInst.digest();
            int k = 0, j = md.length;
            char[] str = new char[j * 2];
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String SHA(String s) {
        MessageDigest sha;
        StringBuilder hexValue;
        try {
            sha = MessageDigest.getInstance("SHA");
            byte[] md5Bytes = sha.digest(s.getBytes(StandardCharsets.UTF_8));
            hexValue = new StringBuilder();
            for (byte md5Byte : md5Bytes) {
                int val = ((int) md5Byte) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return hexValue.toString();
    }
}
