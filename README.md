# springboot_demo
springboot学习项目
2018/12/21 开启springboot学习之路

@ConfigurationProperties注解使用：
  1.表示启指定的配置项
  2.作用在dto上
  3.当该注解使用在dto上的使用，则对应dto的属性可以在全局配置文件application.properties配置属性值
  4.属性【prefix】是指当在application.properties配置属性dto属性值的时候，每个属性的前缀
  
 @EnableConfigurationProperties:表示开启属性注入，value声明的数组，
 可以在使用了EnableConfigurationProperties的对象上直接使用autowired注入value申明的属性
 
 @ConditionalOnProperty:表示当application.properties配置文件中有指定的属性的时候
                        则ConditionalOnProperty作用类生效
    1.prefix:属性前缀名称
    2.name:和prefix一起使用，表示完整的属性名，会在全局配置文件寻找{{prefix.name}}为key的属性值
    3.value同value一样的用法
    4.havingValue：对应的key的值是否同havingValue的值相等，相等的话配置生效，反之不生效
    5.matchIfMissing：没有配置对应key的时候，配置项是否生效
 
