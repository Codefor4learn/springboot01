1.所有/webjars/**的访问，都去META-INF/resources/webjars/路径下找
  如：引入jquery的jar包：
   <dependency>
      <groupId>org.webjars</groupId>
      <artifactId>jquery</artifactId>
      <version>3.5.1</version>
  </dependency>
  访问路径为：http://localhost:8080/springboot/webjars/jquery/3.5.1/jquery.js
  webjars：以jar包的形式引入静态资源

2.所有/**的访问的任何资源(自己静态资源的访问)默认文件夹：优先级从高到低
  "classpath:/META-INF/resources/",
  "classpath:/resources/",
  "classpath:/static/",
  "classpath:/public/"
  "/" 当前项目的根路径  (测试不成功)

3.欢迎页：扫描静态资源文件夹下的所有index.html页面

4.页面图标：所有的**/favicon.ico 都是在静态资源文件夹下找

 自己配置了静态资源路径，则原来的路径不生效



