package com.haitunhv;


import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

/**
 * @Author: haitunhv
 * @Date: 2021/4/20 22:09
 */
public class TestLog4j {
    public static void main(String[] args) {
        Logger logger = new LogManager().getLogger(TestLog4j.class);

        logger.fatal("致命_FATAL");
        logger.error("错误_ERROR");
        logger.warn("警告_WARN");
        logger.info("信息_INFO");
        logger.debug("调试_DEBUG");
        logger.trace("痕迹_TRACE");
    }
}
