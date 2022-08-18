package com.seckill.validator;

import com.seckill.vo.IsMobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;
import java.util.List;

/**
 * 验证手机号
 * @author yt
 * date 2022-08-17
 */
@Documented
@Constraint(
        validatedBy = {IsMobileValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsMobile {
    boolean required() default true; //如果手机号码不填就没办法校验

    String message() default "手机号码格式错误" ;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
