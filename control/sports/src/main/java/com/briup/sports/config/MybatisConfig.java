package com.briup.sports.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.sports.mapper")
public class MybatisConfig {

}
