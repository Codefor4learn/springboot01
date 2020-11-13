1.<!-- 使用slf4j框架，移除其他默认日志依赖 在父项目中已经移除-->
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <exclusions>
          <exclusion>
              <groupId>commons-logging</groupId>
              <artifactId>commons-logging</artifactId>
          </exclusion>
      </exclusions>
  </dependency>

2.日志使用
  1) 日志的级别由低到高，可以调整输出级别，日志就只会在这个级别以后的高级别生效
      logger.trace("这是trace日志");
      logger.debug("这是debug日志");
      // springboot默认使用info级别
      logger.info("这是info日志");
      logger.warn("这是warn日志");
      logger.error("这是error日志");

  2) 设置级别：logging.level.com.hz=trace

  3) 如果不指定 logging.file 和 logging.path 只在控制台输出
     logging.file=my.log（输出当前项目下到指定文件my.log中）
     logging.path=/var/log（输出到指定目录的spring.log中）

  4) logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} -%msg%n ----------控制台输出格式
     logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} -%msg%n ----------文件输出格式
     %d：日期时间
     %thread表：线程名
     %-5level：级别从左显示5个字符宽度
     %logger{50}：表示logger名字最长50字符，否则按照句点分割
     %msg：日志消息
     %n：换行符