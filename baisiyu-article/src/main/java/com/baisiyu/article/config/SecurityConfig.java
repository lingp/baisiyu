package com.baisiyu.article.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServletComponentScan("com.baisiyu.common.security.app")
public class SecurityConfig {
}
