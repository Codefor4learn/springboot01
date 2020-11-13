1.不使用springmvc的xml配置，扩展springmvc功能
  添加一个配置类：
  1) 使用注解@Configuration标注
  2) 继承WebMvcConfigurerAdapter抽象类，不能标注@EnableWebMvc注解
    为什么不直接实现WebMvcConfigurer类？而使用继承WebMvcConfigurerAdapter实现了它的抽象类？
    答：因为实现这个接口太麻烦，不是每次都需要这个接口的所有方法
  3) 需要扩展的功能，继承父类中的对应方法

2.原理：
  SpringMvc的自动配置在配置过程中，会将我们自己的配置类一起启动。具体不详

3.@EnableWebMvc：全面接管SpingMvc
  springboot对springmvc的配置全部不需要了，所有的都是我们自己配
  为什么？
    @Import(DelegatingWebMvcConfiguration.class)
    public @interface EnableWebMvc {
    }
    @EnableWebMvc 会导入一个组件：WebMvcConfigurationSupport
    当没有这个组件时候，自动配置类才生效

    @Configuration
    public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport {
    }

    @Configuration
    @ConditionalOnWebApplication
    @ConditionalOnClass({ Servlet.class, DispatcherServlet.class,
    		WebMvcConfigurerAdapter.class })
    // 容器中没有这个组件的时候，自动配置类才生效
    @ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
    @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
    @AutoConfigureAfter({ DispatcherServletAutoConfiguration.class,
    		ValidationAutoConfiguration.class })
    public class WebMvcAutoConfiguration {
