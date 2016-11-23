package com.magic.rent.util;

import org.slf4j.Logger;

/**
 * Created by wu on 2016/11/23.
 */
public class LogUtil {

    /**
     * 对象打印的日志
     *
     * @param logger
     * @param pojo
     */
    public static void LogPOJO(Logger logger, Object pojo) {
        if (null != pojo) {
            logger.info("LogPOJO:" + pojo.toString());
        } else {
            logger.info("LogPOJO：传入对象为空，无法打印。");
        }
    }
}
