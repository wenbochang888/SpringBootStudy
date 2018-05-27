# SpringBoot整合各个第三方模块

## 1：Web模块，Restful风格的url

1：项目在com.web包下面

2：使用了两种方式：一种不带参数固定url，一种带参数传入的url

## 2：数据库整合Mybaits

1：项目在com.dao包下面

2：增删改查

## 3：整合Redis缓存

1：项目在com.redis包下面

2：整理用了springboot提供的两种操作redis的模板。StringRedisTemplate和RedisTemplate

3：在整合RedisTemplate将默认的JDK序列化改为了Jackson

## 4：整合消息队列RabbitMQ

1：项目在com.rabbitmq包下面

2：这里因为要传送bean对象，但自带的模板只能传送string对象，这里注入了一个配置文件修改了序列化的方式。为此我还debug了SpringBoot的启动过程，说实话感觉是劝退，不敢惹不敢惹

## 5：使用AOP和声明式事务

1：项目在com.aop包下面