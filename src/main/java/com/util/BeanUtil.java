package com.util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author xtaod
 */
public class BeanUtil {
    public static <T> T mapToBean(Class<T> c, Map<String, ?> map) {
        try {
            T t = c.newInstance();
            BeanUtils.populate(t, map);
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
