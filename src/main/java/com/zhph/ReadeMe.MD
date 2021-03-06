
SpringMVC的基础知识和技术要点。
#2017.12.20 - 2017.12.26 学习整理
#阅读书籍《SpringBoot实战：JaveEE开发的颠覆者》

目录
第一部分 点睛Spring4.x
第二部分  点睛SpringMVC 4.x
第三部分  实战SpringBoot

第一部分
第1章 Spring基础
第2章 Spring常用配置
第3章 Spring高级话题

第二部分
第4章 SpringMVC基础

第三部分
第5章  SpringBoot基础
第6章  SpringBoot核心
实战

第四部分
第7章 SpringBoot的Web开发
第8章 SpringBoot的数据访问
第9章 SpringBoot企业级开发
第10章 SpringBoot开发部署与测试
第11章 应用监控
第12章 分布式系统开发


7.1 Spring Boot的Web的开发支持
	1）boot 提供了spring-boot-starter-web 对Web开发给予支持。
	2）内部嵌入了Tomcat和SpringMvc的依赖。
	3）Web自动配置包：spring-boot-autoconfigure.jar ---> org.springframework.boot.autoconfigure.web
		3.1 自动配置内嵌Servlet容器
		3.2 自动配置Http的编码
		3.3 自动配置上传文件的属性
		3.4自动配置mappingJackson2HttpMessageConverter， json和xml的消息转换
		3.5自动配置SpringMvc
7.2 Thymeleaf 模板引擎
	1）基础知识：Thymeleaf是一个Java类库，它是一个xml/xhtml/html5的模板引擎，可以作为View层。
			  Thymeleaf提供了额外的模块与SpringMVC集成，所以我们使用完全可以替代JSP.
	2）引入Thymeleaf, <html xmlns:th="http://www.thymeleaf.org">
	3）${}访问model数据
	4）th:each - th:text 集合遍历
	5）${not #lists.isEmpty(people)} 数据判断
	6）var single = [[${singlePerson}]] //对象     js通过[[${}]]访问
	   console.info（single.name);//值
7.2.2 Thymeleaf与SpringMvc集成
7.2.3 SpringBoot默认支持Thymeleaf。   --> 在boot.autoconfigure.thymeleaf
7.2.4 新建Boot项目集成Thymeleaf
7.3 Web相关配置
	1.Boot提供的自动配置
		1）ViewResolver
			1.ContentNegotiationViewResolver: 这是SpringMVC提供的一个特殊的ViewResolver
			2.BeanNameViewResolver：在控制器中的一个方法的返回值会根据BeanNameViewResolver去查找Bean的名称为返回字符串的View来渲染视图。
				定义BeanNameViewResolver的Bean-->beanNameViewResolver
				定义一个View的Bean--->jsonView
					控制器中，返回字符串jsonView,它会查找Bean的名称为jsonView的视图来渲染
		2）.自动配置的静态资源
			1）类路径文件： /static、/public、/resource、/META-INF/resources  映射为/**
			2）webjar(我们常用的脚本框架封装在jar包中)
				 ： /META-INF/resources/webjars/ 下的静态文件映射为/webjar/**
		3）.自动配置的Formatter和Converter
			只要我们定义了Converter、GenericConverter和Formatter接口的实现类的Bean，就会自动注册到SpringMvc中
		4）.自动配置的HttpMessageConverters
		5）.静态首页的支持
			classpath:/static/index.html
			classpath:/public/indes.html
			classpath:/resources/index.html
			classpath:/META-INF/resources/index.html
	2.接管SpringBoot的web配置
		当Boot提供的SpringMVC不符合要求，可以通过@Configuration的类加入@EnableWebMvc注解来实现自己控制的MVC配置
		继承SpringBoot的配置类WebMvcConfigurerAdapter，无需@EnableWebMvc注解。重写方法
	3.注册Servlert、Filter、Listener
7.4 Tomcat/servlet容器配置
	1.properties配置Tomcat
	2.java代码配置Tomcat
	3.替换Tomcat 为Netty
	4.SSL配置
		secure Socketes layer 安全套接协议，安全协议，位于tcp/ip协议与各种应用层协议之间，为数据通信提供安全支持.
		分为两层，1）SSL记录协议。它建立在可靠的传旭协议TCP之上，为高层协议提供数据封装压缩加密等基本功能。
				2）SSL我收协议，建立在SSL记录协议之上，用于实际数据传输开始前，通信双方进行身份认知，协商加密算法，加交换加密密钥等
				通过HTTPS来实现，以安全为目标的HTTP通道，即在HTTP下加入SSL层，HTTPS的安全基础是SSL
		1.生成证书
			使用SSL受限需要一个整数，这个整数既可以是自签名的，也可以使从SSL证书授权中心获得的。演示自授权证书的生产。
			1）每一个JDK都有一个工具叫keytool，它是一个整数管理工具，用来生成自签名的证书。安装JDK后就可以使用keytool
			命令：
				keytool -genkey -alias tomcat  //这时当前目录下生成了证书.keystore文件
		2.springBoot配置SSL
			1.  .keystore文件复制到项目的跟目录，然后在application.properties中做如下SSL的配置
			2. 启动tomcat
		3.http 转向https
			
				

5.1 Boot 概述
	1.什么事SpringBoot:
		随着动态语言的流行（Ruby\Groovy\Scala\Node.js)，Java的开发显得格外的笨重。
		繁多的配置，低下的开发效率，复杂的部署流程以及第三方技术集成难度大。
		SpringBoot应运而生。它使用“习惯优于配置”的理念让你的项目快速运行起来。使用Spring Boot很容易创建一个独立运行的Jar,运行Jar内嵌Servlet容器，准生产界别的基于Spring的框架的项目，使用SpringBoot可以不用或者很少的Spring配置
	2.核心功能
		1）独立运行的Spring项目。它可以以jar包的形式独立运行，运行一个Spring Boot项目只需要通过 java -jar xx.jar 来运行。
		2）内嵌Servlet容器。Spring Boot可选择内嵌Tomcat,Jetty，Undertow，这样我们无须以War包形式部署项目。
		3）提供starter简化Maven配置。
		4）自动配置Spring . 我们也可以自定义自动配置（见实战）
		5）准生产的应用监控
		6）无代码生产和xml配置。 核心是通过调节注解来实现
	 3.优点：快速构建项目、对主流开发框架的无配置集成、项目独立运行无须外部依赖Servlet容器、应用监控、提高开发部署效率\
5.2 Boot 快速搭建
	1.http://start.spring.io 
	2.IntelliJ IDEA
	3.Spring Boot CLI . 控制台命令工具
	4.Maven 手工构建。
		 1）增加父级依赖。
		 2）添加spring-boot-starter-web。 web的依赖
		 3）.添加SpringBoot编译插件
	5.简单演示
6.1 基本配置
	1.入口类和@SpringBootApplication. 组合注解
		@Configuration、
		@EnableAutoConfiguration、根据类路径中的Jar包依赖为当前项目进行自动配置
		@ComponentScan
	2.@SpingBootApplication(exclude={DataSourceAutoConfiguration.class}) 关闭特定的自动配置
	3.定值Banner.
		1) 在src/main/resources下新建一个banner.txt
		2) 通过http://patorjk.com/software/taag 网站生成字符，将字符赋值到banner.txt中
		3) 可通过mian。  application.setShowBanner(false) 关闭banner
	4.配置文件
		1）application.properties
		2）application.yml   默认的全局配置文件放置在src/main/resources目录或者类路径的/config下
	5.starter pom . 为我们提供了简化企业级开发绝大多数场景的starter pom,消除技术配置
	6.使用xml配置   @importResource({"classpath:some-context.xml","classpath:anthoer-context.xml"})
6.2 外部配置
	spring Boot 允许使用properties文件,yaml文件或者命令行参数作为外部配置
	1.命令行参数配置。  
		1）基于Jar包运行：
			java -jar xx.jar
		2）可以通过以下命令修改tomcat 端口号：
			java -jar xx.jar --server.port=9090
	2.常规属性配置
		在常规Spring环境下，注入properties文件里的值，是通过@PropertySource指明properties文件的位置,然后通过@Value注入值。在Spring Boot里，只需在application.properties定义属性，直接使用@Value注入即可
		1）application.properties 添加属性
		2）入口类 使用@Value("${book.author}")注入到字段上。
	3.类型安全的配置
		1）通过@ConfigurationProperties将properties属性和一个Bean和属性管理，从而实现类型安全的配置
		2）通过PropertiesResource指定properties文件位置，不指定则默认为全局配置文件
6.3 日志配置
	1.默认使用LogBack作为日志框架
		1）配置日志级别：
			logging.file = D:/mylog/log.log
		2)配置日志文件，格式为logging.level.包名=级别
			logging.level.org.springframework.web = DEBUG
6.4 Profile 配置
	1.生产环境配置：application-prod.properties
	1.测试环境配置：application-dev.properties
	2.application.properties 中 设置 spring.profiles.active = prod 指定活动的profile
6.5 Spring Boot 运行原理
	1.可以通过下面三种方式查看当前项目中已启用和未启用的自动配置的
		1）.运行jar时增加--debug参数.2）全局配置 debug = true 3)STS中设置-Ddebug
	1.运作原理
		1）查看@EnableAutoConfiguration 注解源码
	2.核心注解
		@ConditionalOnBean、@ConditionalOnClass。。。
	3.案列安息 Spring Boot 内置的自动配置功能， http的编码配置。
	4.实战
		当某个类存在的时候，自动配置这个类的Bean，并将Bean的属性在application.properties中配置


1.1 spring概述（发展简史、概述）
1.2 spring项目环境搭建（maven介绍、构建）
1.3 spring基础配置(依赖注入、Java配置、AOP)
	1.DI依赖注入 com.zhph.spring.di
	2.JAVA配置 @Configuration声明当前类是配置类，相当于xml;@Bean声明当前方法的返回值是一个Bean
		全局的配置使用JAVA配置，业务Bean使用注解配置（@Controller、@Repositoty、@Service、@Component）
	3.AOP:spring支持AspectJ的注解式切面编程
		1）使用@Aspect声明式一个切面
		2）使用@After\@Before\@Around定义advice,注解的value为拦截规则（切点）
		3）其中@After、@Before、@Around参数的拦截规则为切点PonintCut,切点修饰连接点JoinPoint
		4) 其中符合条件的每一个被拦截处为连接点JoinPoint
		5) 使用@EnableAspectJAutoProxy注解开启Spring对AspectJ代理的支持。
	4.自定义注解

2.1 Bean的Scope
	1.Scope描述的是Spring容器如何创建Bean的实例的。
		Singleton:单例。  Prototype:每次调用新建 一个Bean的实例。
		Request：Web项目中给每一个http request新建一个Bean的实例
		Session: Web项目中，給每一个http session新建一个Bean的实例。
2.2 Spring EL 和资源调用
	1.支持在xml和注解中使用EL表达式类似于JSP的EL表达式
	2.开发中经常涉及调用各种资源如普通文件\网址、配置文件、系统环境变量等 都可以使用EL实现资源注入。
	3.主要在注解@Value的参数中使用表达式。
		演示内容：注入普通字符；操作系统属性；运算结果；其他Bean的属性；文件内容；网址内容；属性文件
	4.引入Commons-io 简化文件相关操作。file 相关的操作。
2.3 Bean的初始化和销毁
	1.JAVA配置方式：使用@Bean的initMethod 和 DestoryMethod（xml : init-method和destory-method）
	2.注解方式：利用JSR-250注解的 @PostConstruct 和 @PreDestory。
2.4 Profile
	1.简述：Profile为在不同环境下适用不同的配置提供了支持。在不同情况下选择实例化不同的Bean.
	2.后置注册Bean配置类，不然会报Bean未定义的错误;刷新容器
2.5 事件（Application Event)
	1.自定义事件，继承ApplicationEvent ，super(resource);
	2.定义监听器  实现ApplicationListener接口，重写onApplicationEvent方法
	3.容器发布事件（发布-订阅模型） applicationContext.publishEvent DemoEvent(this,msg);

3.1 Spring Aware
	1.实现BeanNameAware、ResourceLoaderAware接口，获得Bean名称和资源加载的服务。
	2.实现ResourceLoaderAware 需要重写setResourceLoader;BeanNameAware重写setBeanName;
3.2 多线程
	1.Spring 通过任务执行器（TaskExecutor) 来实现多线程和并发编程
	2.配置类通过@EnableAsync开启对异步任务的支持
3.3 计划任务
	1.简述：通过配置@EnableScheduling开启对定时任务的支持，在方法上@Scheduled声明式一个定时任务。
		   配置值：fixedRate
3.4 条件注解@Conditional：根据满足特定的一个条件创建一个特定的Bean。 结合多态的写法，只有一个子类成为Bean
3.5 组合注解与元注解
3.6 @Enable* 常用注解和工作原理 :@EnableAspectJAutoProxy、@EnableAsync、@EnableScheduling、@EnableWebMvc
3.7 测试

4.1 Spring MVC 概述
	1.MVC的概念，Model+View+Controller(数据模型+视图+控制器)
	2.三层架构：展现层+应用层+数据访问层
4.2 Spring MVC 项目快速搭建
	1.依赖：
	    JavaEE:
		    javax.javaee-web-api
		    javax.servlet.jstl
		    javax.servlet.javax.servlet-api
		    javax.servlet.jsp.jsp-api
    	日志:  
    	    org.slf4j.slf4j-api
		    org.slf4j.jcl-over-slf4j
			ch.qos.logback.logback-classic
			ch.qos.logback.logback-core
			ch.qos.logback.logback-access
		对象和JSON/XML转换的支持:
			com.fasterxml.jackson.dataformat.jackson-dataformat-xml
		切面：
			org.aspectj.aspectjrt
			org.aspectj.aspectjweaver
		公用类：
			org.apache.commons.commons-io
			org.apache.commons.commons-fileupload
			org.apache.commons.commons-lang3
		JSR:
			javax.annotation.jsr250-api
	2.在src/main/resources/ 新建logback.xml
	3.配置类加@EnableWebMvc ,会开启默认的配置 viewResovler 、 MessaggeConverter等
	4.web配置，实现WebApplicationInitializer，注册Spring的容器和mvc的DispatcherServlet
	5.编写简单的控制器，发布项目导tomcat测试
4.3 Spring MVC 的常用注解
	1。@Controller
	2.@ResquestMapping produces可定制返回媒体类型和字符集
	3.@ResponseBody
	4.@RequestBody
	5.@PathVariable 接受路径参数，如/news/001,可接受001作为参数
	6.@RestController  直接返回对象，对象会自动转换为json
4.4 Spring MVC 的基本配置
	0.配置类MyMvcConfig继承WebMvcConfigurerAdapter
	1.静态资源映射. 重写addResourceHandlers方法
	2.拦截器配置
		1.自定义一个拦截器，继承HandlerInterceptorAdapter,重写preHandle、postHandle方法
		2.重写addInterceptors方法
	3.@ControllerAdvice： 控制器的全局配置
		1)注解了Controller的类的方法可使用@ExceptionHandler，@InitBinder,@ModelAttribute注解到该方法上，市全局的配置。
		@ExceptionHandler,用于全局处理控制器的异常.
		@InitBinder:用来设置WebDataBinder，用来自动绑定前台请求参数到Model中。
		@ModelAttribute,绑定键值对到Model中，
		
	4.其他配置
		1）ViewController:重写addViewControllers
		2）路径匹配参数配置。如果路径参数带.后面的值会被忽略，可以自定义是否被忽略
		3）更多配置查看WebMvcConfigurerAdapter类的API
4.4 Spring MVC 的高级配置
	1.文件上传与下载
	2.自定义HttpMessageConverter
	3.服务器端推送技术
		1）SSE（Server Send Event）
		2）Servlet 3.0+异步方法处理
4.6 Spring MVC 的测试
	1.MockMvc-模拟MVC对象


