package com.example.demo.untils;

import org.mapstruct.TargetType;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateLog {
    String operateModel() default ""; // 操作模块

    String operateType() default "";  // 操作类型

    String operateDesc() default "";  // 操作说明
}
