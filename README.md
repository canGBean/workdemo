# workdemo
测试demo,目前包含
* springboot+mybatis+mybatisGenerator
* apollo配置中心
* spingboot拦截器(url pathMatch)

## springboot+mybatis+mybatisGenerator
在com.example.mybatis.demomybatis.DemomybatisApplication.java中,方法
* generatorArtifacts(); 
* generatorCoffeeTest();
用来测试mybatis的Generator及查询。例子中采用了H2数据库

## apollo配置中心
在com.example.mybatis.demomybatis.DemomybatisApplication.java中,方法
* apolloConfigLoggerTest();
用来测试与apollo配置中的配置同步，其中apollo配置在demomyabtis\src\main\resources\application.yml内的下部分
```yaml
app:
  id: demomybatis-apollo

apollo:
  meta: http://10.23.141.112:9090
  bootstrap:
     enabled: true
  eagerLoad:
     enabled: true


logging:
  level:
    com:
     example:
      myabtis:
        demomyabtis: info
```
例子中是测试了同步日志级别，也是参考apollo的demo。日志相关配置在com.example.mybatis.demomybatis.configuration.LoggerConfiguration.java内

## spingboot拦截器(url pathMatch)
测试spring的拦截器，同时测试URI匹配/index及/index.do（/index.xx均可）。此处发现了spring4和spring5中的不同,[参考地址]([https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-pathmatch)
>7.1.8. Path Matching and Content Negotiation

