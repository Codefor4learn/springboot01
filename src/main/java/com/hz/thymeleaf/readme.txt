1.thymeleaf默认路径

  private static final Charset DEFAULT_ENCODING = Charset.forName("UTF-8");
  private static final MimeType DEFAULT_CONTENT_TYPE = MimeType.valueOf("text/html");
  public static final String DEFAULT_PREFIX = "classpath:/templates/";
  public static final String DEFAULT_SUFFIX = ".html";

2.导入：<html lang="en" xmlns:th="http://www.thymeleaf.org">名称空间 会有语法提示

3.优先级：
  1) Fragment inclusion ------ 例：th:insert th:replace -----------片段包含：如jsp的include
  2) Fragment iteration ------ 例：th:each --------------遍历：c:forEach
  3) Conditional evalution ------- 例：th:if th:unless th:switch th:case -------- 条件判断：c:if
  4) Local variable definition ------- 例：th:object th:with --------- 声明变量：c:set
  5) General attribute modification -- 例：th:attr th:attrprepend th:attrappend ----- 任意属性修改
  6) Specific attribute modification ---- 例：th:value th:href th:src ----- 修改指定属性
  7) Text(tag body modification) ----- 例：th:text th:utext
  8) Fragment specification ------- 例：th:fragment ------------ 声明片段
  9）Fragment removal ------------- 例：th:remove

4.表达式语法
  1) ${} 获取变量值：OGNL
    a.获取对象的属性、调用方法
    b.使用内置的基本对象：
      #ctx : the context object.-----------------------当前上下文对象
      #vars: the context variables.--------------------当前上下文变量值
      #locale : the context locale.--------------------区域信息
      #request : (only in Web Contexts) the HttpServletRequest object.
      #response : (only in Web Contexts) the HttpServletResponse object.
      #session : (only in Web Contexts) the HttpSession object.
      #servletContext : (only in Web Contexts) the ServletContext object
    c.内置工具对象：
      #conversions : methods for executing the configured conversion service (if any).
      #dates : methods for java.util.Date objects: formatting, component extraction, etc.
      #calendars : analogous to #dates , but for java.util.Calendar objects.
      #numbers : methods for formatting numeric objects.
      #strings : methods for String objects: contains, startsWith, prepending/appending, etc.
      #objects : methods for objects in general.
      #bools : methods for boolean evaluation.
      #arrays : methods for arrays.
      #lists : methods for lists.
      #sets : methods for sets.
      #maps : methods for maps.
      #aggregates : methods for creating aggregates on arrays or collections.
      #ids : methods for dealing with id attributes that might be repeated
             (for example, as a result of an iteration).
  2)*{} 在功能上和 ${} 一致
    补充功能,配合th:object使用
    <div th:object="${session.user}">
        <p>Name<span th:text="*{firstName}"></span></p>
        <p>Name<span th:text="*{age}"></span></p>
    </div>
    *代表刚刚取得的对象 相当于:
    <div>
        <p>Name<span th:text="${session.user.firstName}"></span></p>
        <p>Name<span th:text="${session.user.age}"></span></p>
    </div>
  3) #{}取国际化内容
  4) @{} 定义url链接
  5）~{} 片段引用表达式