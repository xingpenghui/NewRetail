package com.feri.shop.newretail.login.dao;

import com.feri.shop.newretail.entity.user.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDao {
    //查询
    @Select("select * from t_user where flag=1 and phone=#{phone}")
    @ResultType(User.class)
    User selectByPhone(String phone);
    //修改密码
    @Update("update t_user set password=#{password} where phone=#{phone}")
    int updatePass(@Param("phone") String phone,@Param("password") String password);
}
