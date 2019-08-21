package com.feri.shop.newretail.goods.dao;

import com.feri.shop.newretail.entity.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    //校验手机号是否存在
    @Select("select * from t_user where flag=1 and phone=#{phone}")
    @ResultType(User.class)
    User selectByPhone(String phone);
    //新增用户
    @Insert("insert into t_user(phone,password,flag) values(#{phone},#{password},1)")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int save(User user);

}
