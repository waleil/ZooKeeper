package org.example.config;

import org.example.service.CustomeImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Auther: csx
 * @Date: 2021/12/22 22:15
 * 配置类
 */
@Configuration
@Import(CustomeImportSelector.class)
public class springImports {
}
