一、关于配置文件
1.两种配置的格式
2.各注解作用
  @SpringBootTest 表示这是springboot的测试类
  @RunWith(SpringRunner.class) 表示该类使用SpringRunner类来运行

  @ConfigurationProperties(prefix = "person")导入配置
  @Value也能达到相同的效果，但是不能进行数据校验。
        功能总体不如ConfigurationProperties，但是好处是 **支持SPEL（Spring表达式）。**
        适合在需要的场合引入值。例如在Controller 申明私有变量 @Value("$person.last-name")
  @Validated 数据校验 @Email就可以校验该参数的值是不是邮箱，如果不是则会报错
  @PropertySource 在一个项目中可能有很多配置文件，但springboot默认只加载application配置文件，
        如果抽取出单独的文件，需要该注解进行引入。
  @ImportResource 由于springboot默认不加载spring的配置文件，所以编写的xml需要用这种方式进行引入。
        但是因为配置文件比较多，这种方式不太推荐。
  @Bean springboot推荐全注解方式引入配置，所以在@Configuration修饰类中，用@Bean方式向容器中注入。
        返回值就是注入的对象，切该对象默认在容器中的id为 **方法名**

3.在配置文件中使用占位符
  1) ${random.uuid}---------------uuid
  2) ${random.int}----------------随机数
  3) 占位符获取之前配置的值，如果没有可以使用：指定默认值
      ${person.last-name}_dog  使用前面标识过的内容
      ${person.hello}_dog 如果person.hello取不到值，默认就是值就是${person.hello}_dog
      ${person.hello:hello}_dog 如果person.hello取不到值，hello_dog

4.切换配置文件
  1) spring.profiles.active=prod 指定需要激活配置文件
  2) yml文件可以用---区分文档块，用spring.profiles指定文档快名，在顶部适应spring.profile.active的方式激活

5.配置文件加载位置
  1) spring boot启动会扫描以下位置的 application.properties或者application.yml文件作为Spring boot的默认配置文件。
  - file:/config/
  - file:/
  - classpath:/config/
  - classpath:/
  以上是按照优先级从高到低的顺序，所有位置的文件都会被加载，高优先级配置内容会 **覆盖** 低优先级配置内容.
  我们也可以通过配置 spring. config. location来改变默认配。
  加载完高优先级，也会加载低优先级配置
  2) ==== 可以通过spring.config.location来改变默认的配置文件位置 =======
  项目打包以后，适应命令行参数的形式，启动项目的时候用来指定配置文件的新位置(可以放主机的任意配置)

6.外部配置加载顺序
  1.命令行参数--------------------------------------------------------------------------------------------(1)
  2.来自java:comp/env的NDl属性
  3.Java系统属性(System. getProperties())
  4.操作系统环境变量
  5.RandomValuePropertySource配置的random.*属性值
  6.jar包外部的 application-{profile}.properties或application.yml（带spring-profile）配置文件--------------(2)
  7.jar包内部的 application-{profile}.properties或application.yml（带spring.profile）配置文件--------------(3)
  8.jar包外部的 application.properties或application.yml（不带spring.profile）配置文件----------------------(4)
  9.jar包内部的 application.properties或application.yml（不带spring.profile）配置文件----------------------(5)
  10.@Configuration注解类上的@PropertySource
  11.通过SpringApplication.setDefaultProperties指定的默认属性