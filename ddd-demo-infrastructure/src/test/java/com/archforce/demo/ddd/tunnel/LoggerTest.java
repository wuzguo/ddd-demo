package com.archforce.demo.ddd.tunnel;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * Logback初始化过程：
 * <p>
 * 1、初始化发生在ContextInitializer类的init静态方法中。 2、默认文件加载顺序依次是:logback-test.xml, logback.groovy, logback.xml (test的优先级最高，这个make
 * sense的，因为在执行测试的时候，总 3、如果都没有，初始化默认项console输出的Appender 4、如果是通过SpringBoot进行初始化的话，除了上面的默认顺序以外，也可以用logback-spring.xml,
 * 详细可以参考：org.springframework.boot.logging.AbstractLoggingSystem#initializeWithConventions
 *
 * @author Frank Zhang
 * @date 2019-02-28 1:21 PM
 */

@Slf4j
public class LoggerTest {

    @Test
    public void testLogger() {
        log.debug("I am printing DEBUG logger");
        log.info("I am printing INFO logger");
        Assert.assertEquals(String.class, String.class);
    }
}
