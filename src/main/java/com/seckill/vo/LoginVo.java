package com.seckill.vo;

import com.seckill.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yt
 * date 2022-08-17
 */
@Data
public class LoginVo {
    @NotBlank
    @IsMobile
    private String mobile;

    @NotBlank
    @Length(min=32)
    private String password;
}
