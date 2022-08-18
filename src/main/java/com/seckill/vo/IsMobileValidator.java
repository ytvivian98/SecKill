package com.seckill.vo;

import com.seckill.utils.ValidatorUtil;
import com.seckill.validator.IsMobile;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 手机号码校验规则
 * @author yt
 * date 2022-08-17
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {

    private boolean required = false; //判断是否是必填项

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required){
            return ValidatorUtil.isMobile(s);
        }
        else {
            if(StringUtils.isBlank(s))
                return true;
            else
                return ValidatorUtil.isMobile(s);
        }

        //可以优化
       // if (!org.springframework.util.StringUtils.hasText(s)&&!required) { return true; } return ValidatorUtil.isMobile(s); }

}
}
