package com.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seckill.pojo.User;
import org.springframework.stereotype.Repository;

/**
* @author yutin
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-08-17 10:51:29
* @Entity com.generator.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

}




