package org.shaneking.roc.persistence;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
///can't use conditionals here for junit test
//@ConditionalOnBean(JdbcTemplate.class)
//@ConditionalOnClass(JdbcTemplate.class)
@Configuration
public class PersistenceAutoConfiguration {
}
